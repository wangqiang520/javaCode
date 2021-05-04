package com.userService.cn.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    /**
     * Date转时间
     *
     * @param date date
     * @return String
     */
    public static String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * date转LocalDateTime
     *
     * @param date date
     * @return localDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * date转LocalDate
     *
     * @param date date
     * @return localDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        return dateToLocalDateTime(date).toLocalDate();
    }

    /**
     * localDate转ate
     *
     * @param localDate localDate
     * @return date
     */
    public static Date localDateToDate(LocalDate localDate) {
        return localDateTimeToDate(localDate.atStartOfDay());
    }

    /**
     * LocalDate转日期
     *
     * @param localDate localDate
     * @return String
     */
    public static String localDateToString(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String localDateTimeToString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static String localTimeToString(LocalTime localTime) {
        return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public static LocalDate stringToLocalDate(String time) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static LocalDateTime stringToLocalDateTime(String time) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * localDateTime转Date
     *
     * @param dateTime local
     * @return date
     */
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * localDateTime转时间戳
     *
     * @param localDateTime long
     * @return .
     */
    public static long localDateTimeToStamp(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 查询一个日期(年月日格式)到目前过了多少年
     *
     * @param startTime
     * @return 鐩稿樊鏁伴噺
     */
    public static Integer getYearsByStartTime(String startTime) {
        LocalDate startDate = stringToLocalDate(startTime);
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isBefore(startDate)) {
            return 0;
        } else {
            return startDate.until(currentDate).getYears();
        }
    }

    /**
     * 时间戳转LocalDateTime
     *
     * @param stamp 时间戳转
     * @return LocalDateTime
     */
    public static LocalDateTime stampToLocalDateTime(Long stamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(stamp), ZoneId.systemDefault());
    }


    /**
     * Date转字符串
     * @param date   date
     * @param format 格式("yyyy-MM-dd")
     * @return string 
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat format1 = new SimpleDateFormat(format);
        return format1.format(date);
    }

    /**
     * 字符串转Date
     *
     * @param date 字符串时间
     * @return Date
     */
    public static Date stringToDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }


    /**
     * 字符串转Date
     *
     * @param date   字符串时间
     * @param format 格式(yyyy-MM-dd HH:mm:ss)
     * @return Date
     */
    public static Date stringToDate(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 字符串时间转日期
     * @param str 字符串时间
     * @return Calendar
     */
    public static Calendar stringDateToCalendar(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar;
    }

    /**
     * 字符串时间转日期
     *
     * @param calendar
     * @param format 格式(yyyy-MM-dd HH:mm:ss)
     * @return Date
     */
    public static Date calendarToDate(Calendar calendar, String format) {
        return stringToDate(calendarToStringDate(calendar, format));
    }

    /**
     * 日期转字符串时间
     *
     * @param calendar 鏃ユ湡
     * @param format 格式(yyyy-MM-dd HH:mm:ss)
     * @return String
     */
    public static String calendarToStringDate(Calendar calendar, String format) {
        return dateToString(calendar.getTime(), format);
    }

    /**
     * 获取某个时间所在月份的天数
     *
     * @param date
     * @return int
     */
    public static int getAllDaysOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获取时间的天数，如2017-12-13，返回13
     * @param date
     * @return int
     */
    public static int getDays(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }

    /**
     * 获取时间所在的年份
     * @param date
     * @return int
     */
    public static int getYears(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取时间所在月份
     * @param date
     * @return int
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 增加月份
     * @param date 时间对象
     * @param n 月数
     * @return date
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 增加天数
     * @param date 时间对象
     * @param n 天数
     * @return date
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 字符串日期转时间戳
     * @param stringDate 字符串时间
     * @return 时间戳
     */
    public static Long stringDateToStamp(String stringDate) {
        return TimeUtils.stringToDate(stringDate).getTime();
    }

    /**
     * 时间戳转字符串时间
     * @param timeStamp 时间戳
     * @return String
     */
    public static String stampToStringDate(Long timeStamp) {
        long l = timeStamp;
        return TimeUtils.dateToString(new Date(l));
    }

    /**
     * 计算两个日期相差的天数（不包括今天）
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return int
     */
    public static int dateBetween(String startDate, String endDate) {
        Date dateStart = stringToDate(startDate, "yyyy-MM-dd");
        Date dateEnd = stringToDate(endDate, "yyyy-MM-dd");
        return (int) ((dateEnd.getTime() - dateStart.getTime()) / 1000 / 60 / 60 / 24);
    }

    /**
     * 计算两个日期相差的天数（包括今天）
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return int
     */
    public static int dateBetweenIncludeToday(String startDate, String endDate) {
        return dateBetween(startDate, endDate) + 1;
    }

}
