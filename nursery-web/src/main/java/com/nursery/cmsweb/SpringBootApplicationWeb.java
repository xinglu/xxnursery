package com.nursery.cmsweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2020/12/24
 * Time:10:44
 */
@SpringBootApplication
@ComponentScan("com.nursery.api")
@ComponentScan("com.nursery.cmsweb")
@ComponentScan("com.nursery.service")
@MapperScan("com.nursery.dao")
@ComponentScan("com.nursery.beans")
public class SpringBootApplicationWeb extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootApplicationWeb.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationWeb.class,args);
    }
}
