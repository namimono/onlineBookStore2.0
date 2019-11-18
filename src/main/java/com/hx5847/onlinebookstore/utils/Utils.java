package com.hx5847.onlinebookstore.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.web.multipart.MultipartFile;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author GaoLiwei
 * @date 2019/4/18
 */
public class Utils {

    /**
     * 获得UUID
     *
     * @return UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获得当前时间格式化后的时间
     *
     * @return yyyy-MM-dd格式的时间
     */
    public static String getNowFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 判断List是即不为null也不为空
     *
     * @param list 要判断的list
     * @return 标志位
     */
    public static Boolean isNotNullAndEmpty(List list) {
        return null != list && list.size() > 0;
    }

    /**
     * 获得要保存的文件名
     *
     * @param multipartFile 要截取的文件
     * @param fileId        保存的文件id
     * @return 文件后缀
     */
    public static String getFileSaveName(MultipartFile multipartFile, String fileId) {
        return fileId + "." + multipartFile.getOriginalFilename().substring(
                multipartFile.getOriginalFilename().lastIndexOf(".") + 1);
    }

//    /**
//     * 处理list中的图片
//     *
//     * @param list 要处理的list
//     * @param path 拼接路径
//     */
//    public static void setListImg(List list, String path) {
//        if (isNotNullAndEmpty(list)) {
//            for (Object o : list) {
//                setObjImg(o, path);
//            }
//        }
//    }


    /**
     * 将对象中的图片名称处理为URL
     *
     * @param path 要拼接的路径
     * @param obj  要处理的对象
     * @return 处理好的对象
     */
//    public static void setObjImg(Object obj, String path) {
//        if (null != obj) {
//            Class aClass = obj.getClass();
//            //获得当前类的所有属性
//            Field[] declaredFields = aClass.getDeclaredFields();
//
//            for (Field field : declaredFields) {
//                //获取属性注解
//                IsImg annotation = field.getAnnotation(IsImg.class);
//                if (annotation == null) {
//                    continue;
//                }
//
//                try {
//                    //获得属性的get方法
//                    Method getMethod = aClass.getMethod("get" + org.rcisoft.hill.utils.StringUtils.toUpperCaseFirstOne(field.getName()));
//                    //获得属性的set方法
//                    Method setMethod = aClass.getMethod("set" + org.rcisoft.hill.utils.StringUtils.toUpperCaseFirstOne(field.getName()), String.class);
//                    setMethod.invoke(obj, getImgUrl((String) getMethod.invoke(obj), path));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//    }


    /**
     * 将图片名称处理为URL
     *
     * @param img  要处理的图片名称
     * @param path 要拼接的路径
     * @return 处理好的图片URL
     */
    public static String getImgUrl(String img, String path) {

        if (StringUtils.isNotEmpty(img) && StringUtils.isNotEmpty(path)) {
            String[] splitImg = img.split(",");
            for (int i = 0; i < splitImg.length; i++) {
                splitImg[i] = path + splitImg[i];
            }
            String s = Arrays.toString(splitImg);
            s = s.substring(1);
            s = s.substring(0, s.length() - 1);
            return s;
        }
        return "";
    }

    /**
     * 将要修改的记录封装成map
     *
     * @param list 要修改的记录
     * @return 封装成map的记录信息
     */
    public static Map<String, Object> getUpdateMap(List list) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("updateItemList", list);
        return map;
    }

    /**
     * 将要删除的记录ID封装成map
     *
     * @param list 要修改的记录
     * @return 封装成map的记录信息
     */
    public static Map<String, Object> getDeleteMap(List list) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("deleteItemList", list);
        return map;
    }


    /**
     * 用于合并数组，可以合并多个
     *
     * @param first
     * @param rest
     * @param <T>
     * @return 合并之后的数组
     */
    public static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }

    /**
     * 合并俩个相同的Bean 数据字段为NULL的字段 合并至 target 传来的Bean
     *
     * @param <M>
     * @param target
     * @param destination
     * @throws Exception
     */
    //merge two bean by discovering differences
    public static <M> void merge(M target, M destination) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(target.getClass());

        // Iterate over all the attributes
        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {

            // Only copy writable attributes
            if (descriptor.getWriteMethod() != null) {
                Object originalValue = descriptor.getReadMethod()
                        .invoke(target);

                // Only copy values values where the destination values is null
                if (originalValue == null) {
                    Object defaultValue = descriptor.getReadMethod().invoke(
                            destination);
                    descriptor.getWriteMethod().invoke(target, defaultValue);
                }

            }
        }
    }

    /**
     * List 根据字段 行专列
     *
     * @param <T>
     * @param clazz
     * @param list
     * @return
     */
    //row to column
    public static <T> List convert(Class<T> clazz, List<T> list) {
        List<List> result;
        Field[] fields = clazz.getDeclaredFields();
        result = new ArrayList<>(fields.length);
        for (int i = 0; i < fields.length; i++) {
            result.add(new ArrayList());
        }
        for (T t : list) {
            for (int i = 0; i < fields.length; i++) {
                List l = result.get(i);
                Field field = fields[i];
                field.setAccessible(true);
                try {
                    l.add(field.get(t));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    
    /**
     * 判断数字(Decimal)是否有效
     * @param obj  BigDecimal 类型
     * @return    是否为有效值(是否不为 null 并大于0 )
     * @author    wyl
     */
    public static boolean isValidNumberBigDecimal(BigDecimal obj){
        return null != obj && obj.compareTo(new BigDecimal(0)) >= 1;
    }


    /**
     * @Description <p>获取到对象中属性为null的属性名  </P>
     * @param source 要拷贝的对象
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null){
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * @Description <p> 拷贝非空对象属性值 </P>
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyPropertiesIgnoreNull(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }


    /**
     * 获得订单号
     *
     * @param type 订单前缀类型 比如 JD
     * @return 订单号
     */
    public static String getOrderNum(String type,int num) {
        return type + getMathRandomNum(num);
    }

    /***
     *  生成随机数字
     * @param num
     * @return
     */
    public static int getMathRandomNum(int num) {
        int numRandom = 10;

        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return (int) ((Math.random() * 9 + 1));
        }

        if (num > 1) {
            for (int i = 1; i < num - 1; i++) {
                int _n_num = 10;
                numRandom = numRandom * _n_num;
            }

            return (int) ((Math.random() * 9 + 1) * numRandom);
        }
        return 0;
    }


}
