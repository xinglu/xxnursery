package com.nursery.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

//date日期工具类
public class DateUtils {
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
    private static SimpleDateFormat sdf = null;
    private static String YYYYMMDD = "yyyyMMdd";
    private static String YYYYMM = "yyyyMM";
    public static final String HH = "HH";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String YYYYMMDDHHMM1 = "yyyy年MM月dd日 HH:mm";
    public static final DateTimeFormatter FORMATTER_HH = DateTimeFormatter.ofPattern(HH);
    public static final DateTimeFormatter FORMATTER_YYYY_MM_DD = DateTimeFormatter.ofPattern(YYYY_MM_DD);
    public static final DateTimeFormatter FORMATTER_YYYYMMDD = DateTimeFormatter.ofPattern(YYYYMMDD);
    public static final DateTimeFormatter FORMATTER_YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS);
    public static String getHH() {
        return FORMATTER_HH.format(LocalDateTime.now());
    }
    public static String getYYYYMMDD() {
        return FORMATTER_YYYY_MM_DD.format(LocalDateTime.now());
    }
    public static String YYYYMMDDHHMMSS() {
        return FORMATTER_YYYYMMDDHHMMSS.format(LocalDateTime.now());
    }
    //当前月份
    public static String getNowDate(){
        sdf = new SimpleDateFormat(YYYYMM);
        return sdf.format(new Date());
    }

    public static String getNowDate(String s) {
        sdf = new SimpleDateFormat(s);
        return sdf.format(new Date());
    }

    public static String getAge(String date) throws ParseException {
        String ageStr = "";
        sdf = new SimpleDateFormat(YYYYMMDDHHMMSS);
        Date birthdayDate = sdf.parse(date);
        Calendar calendar = Calendar.getInstance();
        if (calendar.before(birthdayDate)){
            return ageStr;
        }
        int yearNow = calendar.get(Calendar.YEAR);
        int monthNow = calendar.get(Calendar.MONTH);
        int dayNow = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTime(birthdayDate);
        int yearBirthday = calendar.get(Calendar.YEAR);
        int monthBirthday = calendar.get(Calendar.MONTH);
        int dayBirthday = calendar.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirthday;
        if (monthNow <= monthBirthday){
            if (monthNow == dayBirthday){
                if (dayNow < monthBirthday) age--;
            }else {
                age--;
            }
        }
        ageStr = age+"";
        return ageStr;
    }

    public static Date parseYYYYMMDDHHMM(String date) throws ParseException {
        sdf = new SimpleDateFormat(YYYYMMDDHHMM1);
        return sdf.parse(date);
    }


    //判断时间是否过期
    public static boolean verifyOverDue(String startTime, String endTime) {
        try {
            sdf = new SimpleDateFormat(YYYYMMDDHHMM);
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);
            int i = endDate.compareTo(startDate);
            if (i <= 0){
                logger.info("结束时间不得小于等于开始时间");
                return false;
            }
        }catch (Exception e){
            logger.info("时间格式不正确！！！");
            return false;
        }
        return true;
    }
}
