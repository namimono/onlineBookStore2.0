package com.hx5847.onlinebookstore.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	
	private static String OS_NAME = System.getProperty("os.name").toLowerCase();
	
	public static String getWeekByMapWebUseOSIf(String week) {
		
		String commandArray = "";
		OS_NAME = OS_NAME.toLowerCase();
		if (OS_NAME.contains("win")) {
			commandArray=getChineseWeekDate(week);
		} else {
			commandArray=getWeekByMapWebUseLinux(getChineseWeekDate(week));
		}
		
		return commandArray;
	}
	
	public static Integer getMonth(String date) {
		
		String _M = "";
			try {
				_M = new SimpleDateFormat("M").format(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			} catch (ParseException e) {
			}
		
		return Integer.valueOf(_M);

	}
	
	public static String firstOneDay(String date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = null;
		String startDate = "";
		try {
			today = sdf.parse(date);
			String endDate = sdf.format(today);//当前日期
			Calendar theCa = Calendar.getInstance();
			theCa.setTime(today);
			theCa.add(Calendar.MONTH, 0); 
			theCa.set(Calendar.DAY_OF_MONTH, 1); 
			Date start = theCa.getTime();
			startDate = sdf.format(start);
		} catch (ParseException e) {
		}
		
		
		return startDate;
	}
	
	public static String finOneDay(String date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = null;
		String startDate = "";
		try {
			today = sdf.parse(date);
			String endDate = sdf.format(today);//当前日期
			Calendar theCa = Calendar.getInstance();
			theCa.setTime(today);
			theCa.set(Calendar.DAY_OF_MONTH, 1); 
			theCa.set(Calendar.DATE, theCa.getActualMaximum(Calendar.DATE));
			Date start = theCa.getTime();
			startDate = sdf.format(start);
		} catch (ParseException e) {
		}
		
		
		return startDate;
	}
	
	public static String addOneDay(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = null;
		String startDate = "";
		try {
			today = sdf.parse(date);
			String endDate = sdf.format(today);//当前日期
			Calendar theCa = Calendar.getInstance();
			theCa.setTime(today);
			theCa.add(theCa.DATE, +1);
			Date start = theCa.getTime();
			startDate = sdf.format(start);
		} catch (ParseException e) {
		}
		return startDate;
	}
	
	public static String addTenDay(Integer dayInt) {
		
		dayInt = dayInt - 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String endDate = sdf.format(today);//当前日期
        Calendar theCa = Calendar.getInstance();
		theCa.setTime(today);
		theCa.add(theCa.DATE, +dayInt);//最后一个数字30可改，30天的意思
		Date start = theCa.getTime();
		String startDate = sdf.format(start);//三十天之前日期
		
		return startDate;
	}
	
	public static String subOneDay(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = null;
		String startDate = "";
		try {
			today = sdf.parse(date);
			String endDate = sdf.format(today);//当前日期
			Calendar theCa = Calendar.getInstance();
			theCa.setTime(today);
			theCa.add(theCa.DATE, -1);
			Date start = theCa.getTime();
			startDate = sdf.format(start);
		} catch (ParseException e) {
		}
		return startDate;
	}
	public static String subTenDay(Integer dayInt) {
		
		dayInt = dayInt - 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String endDate = sdf.format(today);//当前日期
        Calendar theCa = Calendar.getInstance();
		theCa.setTime(today);
		theCa.add(theCa.DATE, -dayInt);//最后一个数字30可改，30天的意思
		Date start = theCa.getTime();
		String startDate = sdf.format(start);//三十天之前日期
		
		return startDate;
		
	}
	
	/** 

	* 获取一段时间的列表 

	*/ 

	public static String getWeekByMap(String week) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("Monday", "星期一");
		map.put("Tuesday", "星期二");
		map.put("Wednesday", "星期三");
		map.put("Thursday", "星期四");
		map.put("Friday", "星期五");
		map.put("Saturday", "星期六");
		map.put("Sunday", "星期日");
		return map.get(week);
	}
	
	public static Integer getWeekByMapInt(String week) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("星期一",1);
		map.put("星期二",2);
		map.put("星期三",3);
		map.put("星期四",4);
		map.put("星期五",5);
		map.put("星期六",6);
		map.put("星期日",0);
		return map.get(week);
	}
	
	/**
	 * 页面 有效日期 传参 判断 用
	 */
	public static String getWeekByMapWebUse(String week) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "星期一");
		map.put("2", "星期二");
		map.put("3", "星期三");
		map.put("4", "星期四");
		map.put("5", "星期五");
		map.put("6", "星期六");
		map.put("7", "星期日");
		return map.get(week);
	}
	
	public static String getWeekByMapWebUseLinux(String week) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("Mon", "星期一");
		map.put("Tue", "星期二");
		map.put("Wed", "星期三");
		map.put("Thu", "星期四");
		map.put("Fri", "星期五");
		map.put("Sat", "星期六");
		map.put("Sun", "星期日");
		return map.get(week);
	}
	

	public static String getChineseWeekDate(String week) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(week);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new SimpleDateFormat("E").format(date);
	}
	
	/**
	 * 取起始时间到结束时间 所有的时间
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	
	public static List<String> get_D_Plaus_1List(String startTime, String endTime) {
		List<String> list = new ArrayList<String>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();

		try {
			cal.setTime(sdf.parse(startTime));
			for (long d = cal.getTimeInMillis(); d <= sdf.parse(endTime).getTime(); d = get_D_Plaus_1(cal)) {
				list.add(sdf.format(d));
			}
		} catch (ParseException e) {
			System.out.println("date change err");
		}

		return list;
	}

	public static long get_D_Plaus_1(Calendar c) {
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
		return c.getTimeInMillis();
	}
	    
	

	public static void main(String[] args) {
	}
}
