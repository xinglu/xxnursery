package com.nursery.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author:MeiShiQiang
 * Date:2021/1/26
 * Time:17:31
 */
@Controller
@RequestMapping("/manage")
public class ManageIndexControler {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
