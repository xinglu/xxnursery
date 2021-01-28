package com.nursery.nurserymanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nursery.api")
@ComponentScan("com.nursery.nurserymanage")
@ComponentScan("com.nursery.service")
@MapperScan("com.nursery.dao")
@ComponentScan("com.nursery.beans")
public class NurseryManageApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NurseryManageApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(NurseryManageApplication.class, args);
    }

}
