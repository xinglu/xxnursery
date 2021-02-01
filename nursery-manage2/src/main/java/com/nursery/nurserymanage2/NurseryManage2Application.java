package com.nursery.nurserymanage2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nursery.api")
@ComponentScan("com.nursery.nurserymanage2")
@ComponentScan("com.nursery.service")
@MapperScan("com.nursery.dao")
@ComponentScan("com.nursery.beans")
public class NurseryManage2Application {

    public static void main(String[] args) {
        SpringApplication.run(NurseryManage2Application.class, args);
    }

}
