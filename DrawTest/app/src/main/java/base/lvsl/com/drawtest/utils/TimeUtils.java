package base.lvsl.com.drawtest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间相关的工具类
 *
 * @author JueYes
 * @Time 2018/1/25
 */

public class TimeUtils {


    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour   = 60 * minute;// 1小时
    private final static long day    = 24 * hour;// 1天
    private final static long month  = 31 * day;// 月
    private final static long year   = 12 * month;// 年

    public static String getTimeDifference(long time) {
        return getTimeDifference(new Date(time * 1000));
    }

    public static String getTimeDifference(Date date) {

        if (date == null) return "很久以前";

        long diff = new Date().getTime() - date.getTime();

        if (diff > year) return (diff / year) + "年前";

        if (diff > month) return (diff / month) + "个月前";

        if (diff > day) return (diff / day) + "天前";

        if (diff > hour) return (diff / hour) + "个小时前";

        if (diff > minute) return (diff / minute) + "分钟前";

        return "刚刚";
    }

    public static final String FORMAT_TYPE_A = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String FORMAT_TYPE_B = "yyyy年MM月dd日";
    public static final String FORMAT_TYPE_C = "yyyy-MM-dd";
    public static final String FORMAT_TYPE_D = "yyyy年MM月dd日 HH:mm:ss";

    // currentTime要转换的long类型的时间
    // formatType要转换的string类型的时间格式
    public static String longToString(long currentTime, String formatType) {
        Date date = null; // long类型转成Date类型
        try {
            date = longToDate(currentTime * 1000, formatType);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String strTime = dateToString(date, formatType); // date类型转成String
        return strTime;
    }

    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    // currentTime要转换的long类型的时间
    // formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    public static boolean isExpire(long time) {
        return new Date().getTime() > (time * 1000);
    }

    // 获取下一天时间 返回格式 yyyy年MM月dd日
    public static String getNextDay(long currentTime) {
        currentTime += 60 * 60 * 24;
        return longToString(currentTime, FORMAT_TYPE_B);
    }
}


