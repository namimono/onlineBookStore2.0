package com.hx5847.onlinebookstore.utils;

import java.lang.annotation.*;

/**
 * @author GaoLiWei
 * @date 2019/7/29 14:40
 */
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    /**
     * 该字段中文名
     */
    String alias() default "";

    /**
     * 字段为长文本，图片，视频时为true
     */
    boolean isSimpleLog() default false;

    /**
     * 是否是要处理的List集合
     */
    boolean isList() default false;

    /**
     * 保存新增list的属性名
     */
    String addListName() default "";

    /**
     * 保存修改list的属性名
     */
    String updateListName() default "";

    /**
     * 保存删除list的属性名
     */
    String deleteListName() default "";

    /**
     * 保存删除Id的List的属性名
     */
    String deleteIdListName() default "";

    /**
     * 在addInfo上为true
     * 格式："成人票,儿童票"
     */
    boolean isAdd() default false;

    /**
     * 表示是不是记录为数字
     */
    boolean isNum() default false;

    /**
     * 表示名字的属性名
     */
    String fieldName() default "";

    /**
     * 在updateList上为true
     * 新对象的updateList里存放分好的对象，原有对象也要存放分好的对象
     */
    boolean isUpdate() default false;

    /**
     * 在deleteInfo上为true
     * 格式："成人票,半价票"
     */
    boolean isDelete() default false;


    /**
     * 在需要导出到execl表的字段上为true
     */
    boolean isExport() default false;

}
