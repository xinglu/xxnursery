package com.nursery.nurserymanage2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author:MeiShiQiang
 * Date:2021/1/26
 * Time:17:31 首页
 */
@Controller
@RequestMapping("/manage")
public class ManageIndexControler {
    private static final Logger log = LoggerFactory.getLogger(ManageIndexControler.class);

    @GetMapping(value = {"/index","/index.html"})
    public String index(){
        return "index";
    }
}
