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
}