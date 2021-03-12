package com.nursery.nurserymanage2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2021/1/20
 * Time:16:45
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 拦截某个请求跳转固定位置
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }

    //将磁盘文件路径映射为项目访问路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/img/**").addResourceLocations("file:D:\\IdeaProjects\\git\\xxnursery\\xxnurseryimg\\upload\\");
        registry.addResourceHandler("/upload/cover/img/**").addResourceLocations("file:D:\\IdeaProjects\\git\\xxnursery\\xxnurseryimg\\upload\\cover\\");
    }

}
