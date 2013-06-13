package net.ant.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * 方法说明：日期工具类
 * </p>
 */
public class DateUtil {

    private static Log logger = LogFactory.getLog(DateUtil.class);

    public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final String PATTERN_TIME = "HH:mm:ss";
    public static final String PATTERN_YEAR = "yyyy";
    public static final String PATTERN_MONTH = "MM";
    public static final String PATTERN_DAY = "dd";
    public static final String PATTERN_HOUR = "HH";
    public static final String PATTERN_MINITE = "mm";
    public static final String PATTERN_SECOND = "ss";

    // number of milliseconds of a day
    public static final long DAY_SECONDS = 24 * 60 * 60 * 1000;

    public static final String convertToString(Date date, String pattern) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (date == null) {
            logger.warn("date is null!");
        } else {
            df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return returnValue;

    }

    public static final Date convertToDate(String dateStr, String pattern) {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(pattern);
        logger.debug("converting '" + dateStr + "' to date with mask '" + pattern + "'");
        try {
            date = df.parse(dateStr);
        } catch (ParseException pe) {
            logger.error("ParseException: " + pe);
        }

        return date;
    }

    public static final Date getNow() {
        return Calendar.getInstance().getTime();
    }

    public static final String getNow(Date now, String pattern) {
        return convertToString(now, pattern);
    }

    public static final String getCurrentDate() {
        return convertToString(getNow(), PATTERN_DATE);
    }

    public static final String getCurrentTime() {
        return convertToString(getNow(), PATTERN_TIME);
    }

    public static final String getCurrentYear() {
        return convertToString(getNow(), PATTERN_YEAR);
    }

    public static final String getCurrentMonth() {
        return convertToString(getNow(), PATTERN_MONTH);
    }

    public static final String getCurrentDay() {
        return convertToString(getNow(), PATTERN_DAY);
    }

    /**
     * 获取当天的日期
     * 
     * @param date
     *            起始的日期
     * @return 当天的00:00:00
     */
    public static Date getBeginingOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 00);
        calendar.set(GregorianCalendar.MINUTE, 00);
        calendar.set(GregorianCalendar.SECOND, 00);
        calendar.set(GregorianCalendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当天的日期
     * 
     * @param date
     *            结束日期
     * @return 当天的23:59:59
     */
    public static Date getEndingOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 23);
        calendar.set(GregorianCalendar.MINUTE, 59);
        calendar.set(GregorianCalendar.SECOND, 59);
        calendar.set(GregorianCalendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static int daysBetween(Calendar early, Calendar late) {
        return (int) (toJulian(late) - toJulian(early));
    }

    public static final float toJulian(Calendar c) {
        int Y = c.get(Calendar.YEAR);
        int M = c.get(Calendar.MONTH);
        int D = c.get(Calendar.DATE);
        int A = Y / 100;
        int B = A / 4;
        int C = 2 - A + B;
        float E = (int) (365.25f * (Y + 4716));
        float F = (int) (30.6001f * (M + 1));
        float JD = (C + D + E + F) - 1524.5f;
        return JD;
    }

    /**
     * 获取指定日期对应月份的第一天
     * 
     * @param date
     *            指定日期
     * @return 月份的第一天
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取指定日期对应月份的最后一天
     * 
     * @param date
     *            指定日期
     * @return 月份的最后一天
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
        return (Date) calendar.getTime().clone();
    }

    public static Date getNextNDay(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.DAY_OF_MONTH, n);
        return (Date) calendar.getTime().clone();
    }

    public static Date getNextNMonth(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.MONTH, n);
        return (Date) calendar.getTime().clone();
    }

}
