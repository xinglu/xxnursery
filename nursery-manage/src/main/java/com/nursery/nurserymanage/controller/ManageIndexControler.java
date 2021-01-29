package com.nursery.nurserymanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * author:MeiShiQiang
 * Date:2021/1/26
 * Time:17:31
 */
@Controller
@RequestMapping("/manage")
public class ManageIndexControler {
    private static final Logger log = LoggerFactory.getLogger(ManageIndexControler.class);

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
