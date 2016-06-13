package com.ys.wechat.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:时间工具类
 *
 * @author 吕志博
 * @date 2016-3-8 下午3:42:21
 * @version V1.0
 */
public class DateUtil {

	public final static DateFormat YYYY_MM_DD_MM_HH_SS = new SimpleDateFormat(DateFormatConstant.FORMAT_DATETIME);
	public final static DateFormat YYYY_MM_DD = new SimpleDateFormat(DateFormatConstant.FORMAT_DATE);
	public final static DateFormat YYYY_MM = new SimpleDateFormat("yyyy-MM");
	public final static DateFormat YYYYMMDDMMHHSS = new SimpleDateFormat("yyyyMMddHHmmss");
	public final static DateFormat YYYYMMDDMMHHSSSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	public static final String yyyyMMdd = "yyyyMMdd";
	
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

	public static Date parseToDate(String datetime) {
		Date date = null;
		try {
			date = YYYY_MM_DD_MM_HH_SS.parse(datetime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 当前日期 
	 */
	public static String getCurrentDay() {
		return date2String(new Date(), yyyyMMdd);
	}

	/**
	 * 当前日期
	 */
	public static String getCurrentDateTime() {
		return date2String(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	

	/**
	 * 日期按照指定格式转换为字符串
	 */
	public static String date2String(Date date, String formatStr) {
		return date2String(date, formatStr, Locale.getDefault());
	}

	private static String date2String(Date date, String formatStr, Locale locale) {
		Format format = new SimpleDateFormat(formatStr, locale);
		return format.format(date);
	}

	/**
	 * 时间转换为yyyy-MM-dd HH:mm:ss格式的字符串
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return YYYY_MM_DD_MM_HH_SS.format(date);
	}

	public static Date strToDate(String dateString) {
		Date date = null;
		try {
			date = YYYY_MM_DD_MM_HH_SS.parse(dateString);
		} catch (ParseException e) {
			date = new Date();
			e.printStackTrace();
		}
		return date;
	}
	public static Date strToDate(String dateString,String pattern) {
		Date date = null;
		try {
			date = new SimpleDateFormat(pattern).parse(dateString);
		} catch (ParseException e) {
			date = new Date();
			e.printStackTrace();
		}
		return date;
	}

	
	public static boolean startDateBeforEndDate(Date startDate, Date endDate){
		System.out.print("=========startDate="+dateToString(startDate)+"=========endDate=="+dateToString(endDate)+"=====");
		boolean bool=false;
		 if (startDate.getTime() <= endDate.getTime()) {
             System.out.println("startDate 在endDate前");
             bool=true;
         } else if (startDate.getTime() > endDate.getTime()) {
             System.out.println("startDate在endDate2  后");
         }else{
        	 System.out.println("startDate========endDate2  ");
         }
		 return bool;
	}
	
	public static int countDayOfMonth(Date startDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 计算两个时间之间相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int diffDays(Date startDate, Date endDate) {
		long days = 0;
		long start = startDate.getTime();
		long end = endDate.getTime();
		// 一天的毫秒数1000 * 60 * 60 * 24=86400000
		days = (end - start) / 86400000;
		return Integer.parseInt(Long.toString(days));
	}

	/**
	 * 日期加上月数的时间
	 * 
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date dateAddMonth(Date date, int month) {
		return add(date, Calendar.MONTH, month);
	}

	/**
	 * 日期加上天数的时间
	 * 
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date dateAddDay(Date date, int day) {
		return add(date, Calendar.DAY_OF_YEAR, day);
	}

	/**
	 * 日期加上年数的时间
	 * 
	 * @param date
	 * @param year
	 * @return
	 */
	public static Date dateAddYear(Date date, int year) {
		return add(date, Calendar.YEAR, year);
	}

	/**
	 * 计算剩余时间 (多少天多少时多少分)
	 * 
	 * @param startDateStr
	 * @param endDateStr
	 * @return
	 */
	public static String remainDateToString(Date startDate, Date endDate) {
		StringBuilder result = new StringBuilder();
		long times = endDate.getTime() - startDate.getTime();
		if (times < -1) {
			result.append("过期");
		} else {
			long temp = 1000 * 60 * 60 * 24;
			// 天数
			long d = times / temp;

			// 小时数
			times %= temp;
			temp /= 24;
			long m = times / temp;
			// 分钟数
			times %= temp;
			temp /= 60;
			long s = times / temp;

			result.append(d);
			result.append("天");
			result.append(m);
			result.append("小时");
			result.append(s);
			result.append("分");
		}
		return result.toString();
	}

	/**
	 * 
	 * @param startTime(包括这天)
	 * @param endTime
	 * @return
	 */
	public static int mistimingDate(Date startTime,Date endTime){
		long times = endTime.getTime()-startTime.getTime();
		if(times <-1){
			return 1;
		}
		long temp = 1000 * 60 * 60 * 24;
		int day = (int) (times / temp)+1;
		return day;
		
	}
	
	/**
	 * 比较大小
	 */
	public static boolean compare(Date start,Date end){
		long times = end.getTime()-start.getTime();
		if(times <-1){
			return false;
		}
		return true;
	}
	
	private static Date add(Date date, int type, int value) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, value);
		return calendar.getTime();
	}
	
	public static void main(String[] args) throws ParseException{
//		System.out.println(repayDate(new Date(),31));
		int diff=DateUtil.mistimingDate(
				new SimpleDateFormat("yyyyMMdd").parse("20140210"), 
				new SimpleDateFormat("yyyyMMdd").parse("20140216"));
		//05-01   6.3
//		System.out.println(diff);
//		System.out.println(appointDate(new SimpleDateFormat("yyyyMMdd").parse("20140501"),5));
//		System.out.println(getAppoinDay(new SimpleDateFormat("yyyyMMdd").parse("20140210")));
//		DateFormat date = DateFormat.getDateInstance();
//		System.out.println("相差天数="+diff);
//		System.out.println(mistimingDate(new SimpleDateFormat("yyyyMMdd").parse("20140210"),new SimpleDateFormat("yyyyMMdd").parse("20140214")));
//		System.out.println("期数"+repayPeriods(new SimpleDateFormat("yyyyMMdd").parse("20140215"),30,new SimpleDateFormat("yyyyMMdd").parse("20140315")));
		
		System.out.println(DateUtil.startDateBeforEndDate(new SimpleDateFormat("yyyyMMdd").parse("20140211"),new SimpleDateFormat("yyyyMMdd").parse("20140211")));
	}
	
	/**
	 * 返回一个日期，即入参日期+i天
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date nextsDay(Date date,int i){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); 
		calendar.add(calendar.DATE,i);//把日期往后增加一天.整数往后推,负数往前移动 
		date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
		return date;
	}
	
	/**
	 * 返回一个日期，即入参日期前i天
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date presDay(Date date,int i){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); 
		calendar.add(calendar.DATE,-i);//把日期往后增加一天.整数往后推,负数往前移动 
		date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
		return date;
	}
	
	/**
	 * 返回一个日期，即入参日期前i个月的最后一天
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date theLastDayOfPreMount(Date date,int i){
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(Calendar.MONTH, date.getMonth()-1);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 返回一个日期，即入参日期+i月
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date nextsMonth(Date date,int i){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); 
		calendar.add(calendar.MONTH,i);//把日期往后增加一天.整数往后推,负数往前移动 
		date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
		return date;
	}
	
	
}
