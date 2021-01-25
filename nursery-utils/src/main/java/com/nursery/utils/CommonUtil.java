package com.nursery.utils;

import java.util.UUID;

public class CommonUtil {
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    public static String getVerifyCode(int i) {
        return null;
    }
}