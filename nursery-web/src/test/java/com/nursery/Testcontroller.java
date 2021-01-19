package com.nursery;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class Testcontroller {


    @Test
    public void test01(){
        String name = Testcontroller.class.getName();
        System.out.println(name);
    }

    @Test
    public void getNowDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String format = sdf.format(new Date());
        System.out.println(format.concat("1456789"));
    }


    @Test
    public void test02(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid.length());
    }


    @Test
    public void test03() throws JsonProcessingException {
       String str = "str,ji,ii,ll";
        String[] split = str.split(",");
        System.out.println(Arrays.toString(split));
        System.out.println(20 * 1024 * 1024);
    }
}
