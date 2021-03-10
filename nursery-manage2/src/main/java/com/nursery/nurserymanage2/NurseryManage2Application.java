package com.nursery.nurserymanage2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan("com.nursery.api")
@ComponentScan("com.nursery.nurserymanage2")
@ComponentScan("com.nursery.service")
@ComponentScan("com.nursery.beans")
@MapperScan("com.nursery.dao") //mybatis dao类扫描
@EnableAsync //开启异步
public class NurseryManage2Application {

    public static void main(String[] args) {
        SpringApplication.run(NurseryManage2Application.class, args);
    }

}

