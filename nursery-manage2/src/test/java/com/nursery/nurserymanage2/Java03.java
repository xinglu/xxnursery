package com.nursery.nurserymanage2;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * author:MeiShiQiang
 * Date:2021/3/17 | Time:16:58
 */
public class Java03 {

    @Test
    public void test01(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456Msq./");
        System.out.println(encode);
    }
}
