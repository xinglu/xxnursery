package com.nursery.nurserymanage2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/2/4 | Time:10:48
 * 罗马数字 转 整数
 */
public class Java01 {
    /*
     * 罗马数字 转 整数
     */
    @Test
    public void test01(){}{
        romanToInt("IIV");
    }

    @Test
    public void test02(){}{
        System.out.println(isValid("{}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("[]"));
        System.out.println(isValid("[)"));
        System.out.println(isValid("{]"));
        System.out.println(isValid("[)}"));
        System.out.println(isValid("{()}"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{[]()}"));
        System.out.println(isValid("{}[]()"));
        System.out.println(isValid("{[]}]["));
        System.out.println(isValid("([}}])"));
    }

    /**
     ()   )(
     {}  }{
     []  ][
     */
    public boolean isValid(String s) {
        List<String> strings = new ArrayList<>(Arrays.asList(s.split("")));
        while (strings.size()!=0){
            if (strings.size()%2==0){
                if (strings.contains("(")){
                    if ( !strings.contains(")")) return false;
                    int x = strings.indexOf(")")-strings.indexOf("(");
                    strings.remove(strings.indexOf(")"));
                    strings.remove(strings.indexOf("("));
                    if (x < 0 || x%2==0) {
                        return false;
                    }
                }
                if (strings.contains("{")){
                    if ( !strings.contains("}")) return false;
                    int x = strings.indexOf("}")-strings.indexOf("{");
                    strings.remove(strings.indexOf("{"));
                    strings.remove(strings.indexOf("}"));
                    if (x < 0 || x%2==0) {
                        return false;
                    }
                }
                if (strings.contains("[")){
                    if ( !strings.contains("]")) return false;
                    int x = strings.indexOf("]")-strings.indexOf("[");
                    strings.remove(strings.indexOf("]"));
                    strings.remove(strings.indexOf("["));
                    if (x < 0 || x%2==0) {
                        return false;
                    }
                }
            }else {
                return false;
            }
        }
        return true;
    }


    public int romanToInt(String s){
        int sum = 0;
        return sum;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
