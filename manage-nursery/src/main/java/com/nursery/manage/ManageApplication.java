package com.nursery.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nursery.api")
@ComponentScan("com.nursery.manage")
@ComponentScan("com.nursery.service")
@MapperScan("com.nursery.dao")
@ComponentScan("com.nursery.beans")
public class ManageApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ManageApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }

}
