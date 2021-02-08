package com.nursery.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机号
 */
public class CellUtils {

    public static final String REGEX_MOBILE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";

    public static String sendCheckCellPhone(String cellPhone) {
        return null;
    }

    public static boolean sendCell(String accountNum, String verifyCode) {
        return false;
    }

    public static boolean verify(String cellPhone) {
        // \d 匹配一个或多个数字，其中 \ 要转义，所以是 \\d
        Pattern p = Pattern.compile(REGEX_MOBILE);
        Matcher m = p.matcher(cellPhone.trim());
        return m.matches();
    }
}
