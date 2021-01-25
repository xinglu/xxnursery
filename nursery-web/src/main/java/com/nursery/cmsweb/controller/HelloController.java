package com.nursery.cmsweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2021/1/20
 * Time:17:31
 */
@Controller
public class HelloController {

    @RequestMapping("/test")
    public String hello(){
        return "index";
    }
    @RequestMapping("/test2")
    public String hello2(){
        return "main";
    }
}
