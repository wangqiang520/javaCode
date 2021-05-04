package com.userService.cn.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author Morris
 * @version 1.0
 */
public class DateUtil {

	private static final transient Logger log = LoggerFactory.getLogger(DateUtil.class);

	/** 毫秒 */
	public final static long MS = 1;
	/** 每秒钟的毫秒数 */
	public final static long SECOND_MS = MS * 1000;
	/** 每分钟的毫秒数 */
	public final static long MINUTE_MS = SECOND_MS * 60;
	/** 每小时的毫秒数 */
	public final static long HOUR_MS = MINUTE_MS * 60;
	/** 每天的毫秒数 */
	public final static long DAY_MS = HOUR_MS * 24;

	/** 标准日期格式 */
	public final static String NORM_DATE_PATTERN = "yyyy-MM-dd";
	/** 标准时间格式 */
	public final static String NORM_TIME_PATTERN = "HH:mm:ss";
	/** 标准日期时间格式，精确到分 */
	public final static String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
	/** 标准日期时间格式，精确到秒 */
	public final static String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/** 简单时间日期格式，精确到秒 */
	public final static String SIMPLE_TIME_PATTERN = "yyyyMMddHHmmss";
	/** 标准日期时间格式，精确到毫秒 */
	public final static String NORM_DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

	/** 标准日期（不含时间）格式化器 */
	private static ThreadLocal<SimpleDateFormat> NORM_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>(){
		synchronized protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(NORM_DATE_PATTERN);
		};
	};

	/** 标准时间格式化器 */
	private static ThreadLocal<SimpleDateFormat> NORM_TIME_FORMAT = new ThreadLocal<SimpleDateFormat>(){
		synchronized protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(NORM_TIME_PATTERN);
		};
	};

	/** 标准日期时间格式化器 */
	private static ThreadLocal<SimpleDateFormat> NORM_DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>(){
		synchronized protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(NORM_DATETIME_PATTERN);
		};
	};

	/** 简单日期时间格式化器 */
	private static ThreadLocal<SimpleDateFormat> SIMPLE_DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>(){
		synchronized protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(SIMPLE_TIME_PATTERN);
		};
	};

	/**
	 * 将日期转换为Calendar对象。
	 *
	 * @param date 日期
	 * @return Calendar对象
	 */
	private static Calendar toCalendar(Date date){
		final Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * 从日期中获得月份。
	 *
	 * @param date 日期
	 * @return 月份
	 */
	public static int getMonth(Date date){
		return toCalendar(date).get(Calendar.MONTH) + 1;
	}

	/**
	 * 从日期中获得年。
	 *
	 * @param date 日期
	 * @return 年份
	 */
	public static int getYear(Date date){
		return toCalendar(date).get(Calendar.YEAR);
	}

	/**
	 * 从日期中获得季度。
	 *
	 * @param date 日期
	 * @return 季度
	 */
	public static int getSeason(Date date){
		return toCalendar(date).get(Calendar.MONTH) / 3 + 1;
	}

	/**
	 * 根据指定格式格式化日期。
	 *
	 * @param date 待格式化的日期
	 * @param format 格式
	 * @return 格式化后的日期字符串
	 */
	public static String format(Date date, String format){
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 根据格式yyyy-MM-dd HH:mm:ss格式化日期。
	 *
	 * @param date 待格式化的日期
	 * @return 格式化后的日期字符串
	 */
	public static String formatDateTime(Date date) {
		return NORM_DATETIME_FORMAT.get().format(date);
	}

	/**
	 * 根据格式yyyy-MM-dd格式化日期。
	 *
	 * @param date 待格式化的日期
	 * @return 格式化后的日期字符串
	 */
	public static String formatDate(Date date) {
		return NORM_DATE_FORMAT.get().format(date);
	}

	/**
	 * 根据格式yyyyMMddHHmmss格式化日期。
	 *
	 * @param date 待格式化的日期
	 * @return 格式化后的日期字符串
	 */
	public static String formatSimpleDateTime(Date date) {
		return SIMPLE_DATETIME_FORMAT.get().format(date);
	}

	/**
	 * 根据给定的日期格式户器将字符串转换成Date对象。
	 *
	 * @param dateStr Date字符串
	 * @param simpleDateFormat 格式化器
	 * @return Date对象，转换失败返回null
	 */
	public static Date parse(String dateStr, SimpleDateFormat simpleDateFormat){
		try {
			return simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			log.error("日期解析异常：", e);
			return null;
		}
	}

	/**
	 * 将特定格式的日期字符串转换为Date对象。
	 *
	 * @param dateStr 特定格式的日期字符串
	 * @param format 格式，例如yyyy-MM-dd
	 * @return 日期对象，转换失败返回null
	 */
	public static Date parse(String dateStr, String format){
		return parse(dateStr, new SimpleDateFormat(format));
	}

	/**
	 * 将格式形如yyyy-MM-dd HH:mm:ss的字符串转换为Date对象。
	 *
	 * @param dateStr 标准形式的时间字符串
	 * @return 日期对象，转换失败返回null
	 */
	public static Date parseDateTime(String dateStr){
		return parse(dateStr, NORM_DATETIME_FORMAT.get());
	}

	/**
	 * 将格式形如yyyyMMddHHmmss的字符串转换为Date对象。
	 *
	 * @param dateStr 简单形式的时间字符串
	 * @return 日期对象，转换失败返回null
	 */
	public static Date parseSimpleDateTime(String dateStr){
		return parse(dateStr, SIMPLE_DATETIME_FORMAT.get());
	}

	/**
	 * 将格式形如yyyy-MM-dd的字符串转换为Date对象。
	 *
	 * @param dateStr 标准形式的日期字符串
	 * @return 日期对象，转换失败返回null
	 */
	public static Date parseDate(String dateStr) {
		return parse(dateStr, NORM_DATE_FORMAT.get());
	}

	/**
	 * 将格式形如HH:mm:ss的字符串转换为Date对象。
	 *
	 * @param timeStr 标准形式的时间字符串
	 * @return 日期对象
	 * @throws ParseException
	 */
	public static Date parseTime(String timeStr) {
		return parse(timeStr, NORM_TIME_FORMAT.get());
	}

	/**
	 * 将日期字符串转化为另一格式日期字符串。
	 *
	 * @param dateStr 旧日期字符串
	 * @param oldDateStyle 旧日期风格
	 * @param newDateStyle 新日期风格
	 * @return 新日期字符串
	 */
	public static String strToStr(String dateStr, String oldDateStyle, String newDateStyle) {
		Date date = parse(dateStr, new SimpleDateFormat(oldDateStyle));
		return format(date, newDateStyle);
	}

	/**
	 * 昨天。
	 *
	 * @return 昨天
	 */
	public static Date yesterday() {
		return offsiteDay(new Date(), -1);
	}



	/**
	 * 上周。
	 *
	 * @return 上周
	 */
	public static Date lastWeek() {
		return offsiteWeek(new Date(), -1);
	}

	/**
	 * 上个月。
	 *
	 * @return 上个月
	 */
	public static Date lastMonth() {
		return offsiteMonth(new Date(), -1);
	}

	/**
	 * 偏移天。
	 *
	 * @param date 日期
	 * @param offsite 偏移天数，正数向未来偏移，负数向历史偏移
	 * @return 偏移后的日期
	 */
	public static Date offsiteDay(Date date, int offsite) {
		return offsiteDate(date, Calendar.DAY_OF_YEAR, offsite);
	}

	/**
	 * 偏移周。
	 *
	 * @param date 日期
	 * @param offsite 偏移周数，正数向未来偏移，负数向历史偏移
	 * @return 偏移后的日期
	 */
	public static Date offsiteWeek(Date date, int offsite) {
		return offsiteDate(date, Calendar.WEEK_OF_YEAR, offsite);
	}

	/**
	 * 偏移月。
	 *
	 * @param date 日期
	 * @param offsite 偏移月数，正数向未来偏移，负数向历史偏移
	 * @return 偏移后的日期
	 */
	public static Date offsiteMonth(Date date, int offsite) {
		return offsiteDate(date, Calendar.MONTH, offsite);
	}

	/**
	 * 获取指定日期偏移指定时间后的时间。
	 *
	 * @param date 基准日期
	 * @param calendarField 偏移的粒度大小（小时、天、月等）使用Calendar中的常数
	 * @param offsite 偏移量，正数为向后偏移，负数为向前偏移
	 * @return 偏移后的日期
	 */
	public static Date offsiteDate(Date date, int calendarField, int offsite){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(calendarField, offsite);
		return cal.getTime();
	}

	/**
	 * 判断两个日期相差的时长返回 minuend - subtrahend 的差。
	 *
	 * @param subtrahend 减数日期
	 * @param minuend 被减数日期
	 * @param diffField 相差的选项：相差的天、小时
	 * @return 日期差
	 */
	public static long diff(Date subtrahend, Date minuend, long diffField){
		long diff = minuend.getTime() - subtrahend.getTime();
		return diff/diffField;
	}

	/**
	 * 计时，常用于记录某段代码的执行时间，单位：毫秒。
	 *
	 * @param preTime 之前记录的时间
	 * @return 时间差，毫秒
	 */
	public static long spendMs(long preTime) {
		return System.currentTimeMillis() - preTime;
	}

	/**
	 * 将字符串转成Timestamp。
	 * @param time
	 * @return
	 */
	public static Timestamp strToTimestamp(String time) {
		DateFormat format = null;
		if(time.indexOf("/")>-1)
			format = new SimpleDateFormat("yyyy/MM/dd");
		else
			format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		try {
			return new Timestamp(format.parse(time).getTime());
		} catch (ParseException e) {
			log.error("字符串转成Timestamp异常", e);
			return null;
		}
	}

	public static Date getDate(String dateStr) {
		Date date = null;
		try {
			date =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 两个日期之间的差值
	 */
	public static long dateDiff(Date start, Date end) {
		Calendar cal = Calendar.getInstance();   
		cal.setTime(start);
		long startTime = cal.getTimeInMillis();    
		cal.setTime(end);  
		long endTime = cal.getTimeInMillis();         
        long dateDiffValue = (endTime-startTime)/(1000*3600*24); 
        dateDiffValue ++;
		return dateDiffValue;
	}
	
	/**
	 * 计算两个日期相差多少个小时
	 */
	public static double differHour(Date start, Date end) {
		long endTime = end.getTime();
		long startTime = start.getTime();
		//毫秒
		long hm = endTime - startTime;
		//小时
		double diffHour = Double.parseDouble("" + hm) / 1000 / 3600;
		return diffHour;
	}
	
	public static Date format(String dateStr){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		dateStr = dateStr.replaceAll(" ","");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyy.MM.dd");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyy/MM/dd");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyyMMdd");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyy-M-d");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyy/M/d");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyy.M.d");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyyMd");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyy-M-dd");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyy/M/dd");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyy.M.dd");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyyMdd");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}


		format = new SimpleDateFormat("yyyy-MM-d");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyy/MM/d");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyy.MM.d");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}

		format = new SimpleDateFormat("yyyyMMd");

		try {
			return tryFormat(format,dateStr);
		} catch (ParseException e) {

		}
		return null;
	}

	private static Date tryFormat(SimpleDateFormat format, String dateStr) throws ParseException {
		format.setLenient(false);
		return format.parse(dateStr);
	}
	/**
	 * 根据开始时间，和天数计算结束时间
	 */
	public static Date getEndTime(Date startTime, int dateCount) {
		long timeTemp = startTime.getTime() + DAY_MS * dateCount;
		Date endTime = new Date(timeTemp);
		return endTime;
	}
	
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTime1 = sf.parse("2017-08-31 14:43:35");
		Date dateTime2 = sf.parse("2017-08-31 14:43:35");
		
		long endTime = dateTime2.getTime();
		long startTime = dateTime1.getTime();
		//毫秒
		//long hm = endTime - startTime;
		//小时
		//long diffHour = hm / 1000 / 3600;
		System.out.println(getEndTime(dateTime1, 2));
	}
}
