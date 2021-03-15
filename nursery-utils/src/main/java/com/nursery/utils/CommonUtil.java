package com.nursery.utils;

import java.util.Random;
import java.util.UUID;

public class CommonUtil {

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    public static String getRandomNum(int x,int y) {
        Random random = new Random();
        x = random.nextInt(x);
        y = random.nextInt(y);
        return x+y+"";
    }

    public static String getVerifyCode(int i) {
        return null;
    }


    //获取经验
    public static String getExperience(String experienceCode) {
        switch(experienceCode){
            case "0" :
                return "不限";
            case "1" :
                return "在校生";
            case "2" :
                return "应届生";
            case "3" :
                return "1年以内";
            case "4" :
                return "1-3年";
            case "5" :
                return "3-5年";
            case "6" :
                return "5-10年";
            case "7" :
                return "10年以上";
        }
        return "不限";
    }

    /**
     * 学历要求
     * @param requireEduDB 学历code
     * @return
     */
    public static String getRequureEdu(String requireEduDB) {
        switch(requireEduDB){
            case "0" :
                return "不限";
            case "1" :
                return "大专";
            case "2" :
                return "本科";
            case "3" :
                return "硕士";
            case "4" :
                return "博士";
        }
        return "不限";
    }
}