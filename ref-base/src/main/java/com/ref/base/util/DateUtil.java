package com.ref.base.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * @description 获取当前时间编号,月份两位(例如：20160729)
	 * @author xin
	 * @date 2016年7月29日 下午8:30:33
	 * @return
	 */
	public static String getDateCode(){
		LocalDate localDate = LocalDate.now();
		String date = localDate.toString();
		return date.replaceAll("-", "");
	}
	
	/**
	 * @description String转Date
	 * @author xin
	 * @date 2016年7月29日 下午9:03:59
	 * @param dateString
	 * @param formate
	 * @return
	 */
	public static Date getDateByStr(String dateString, String formate){
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @description 获取当前时间，按照传入的格式
	 * @author xin
	 * @date 2016年7月29日 下午9:20:44
	 * @param formate
	 */
	public static String getNowTime(String formate){
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());
	}
	
	/**
	 * @description 获取当月第一天
	 * @author xin
	 * @date 2016年7月30日 下午3:28:21
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	/**
	 * @description 获取两个时间相差月份
	 * @author xin
	 * @date 2016年7月30日 下午3:27:29
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static int getBetweenMonths(Date dateStart, Date dateEnd) {
		dateStart = getFirstDayOfMonth(dateStart);
		dateEnd = getFirstDayOfMonth(dateEnd);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(dateStart);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(dateEnd);

		int i = 0;
		while (calendar1.getTime().before(calendar2.getTime())) {
			calendar1.add(Calendar.MONTH, 1);
			i++;
		}
		return i;
	}
	
	/**
	 * @description 获取两个时间相差小时
	 * @author xin
	 * @date 2016年7月30日 下午3:26:09
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static int getBetweenHours(Timestamp dateStart,Timestamp dateEnd){
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(dateStart);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(dateEnd);
		int hours = 0;
		while (calendar1.getTime().before(calendar2.getTime())) {
			calendar1.add(Calendar.HOUR, 1);
			hours++;
		}
		return hours;
	}
	
	/**
	 * @description 获取两个时间相差天数
	 * @author xin
	 * @date 2016年7月30日 下午3:24:18
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static int getBetweenDays(Date dateStart, Date dateEnd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateStart);
        long time1 = cal.getTimeInMillis();
        cal.setTime(dateEnd);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        String str = sdf.format(new Date());
        System.out.println(str);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        System.out.println(getNowTime("HH:mm:ss"));
	}
}
