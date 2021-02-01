package com.nursery.nurserymanage2.controller;

import com.nursery.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class HelloController extends BaseController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HelloController.class);
/*
    @RequestMapping(value = {"/register","/register/","/register.html","/nursery/register","/nursery/register/","/nursery/register.html"})
    public String register(){
        return "consumerRegisterPage";
    }*/
    @RequestMapping(value = {"/login","/login.html","/login/","/nursery/login","/nursery/login/","/nursery/login.html"})
    public String loginPage(){
        return "main_login";
    }

    //招聘管理
    @RequestMapping(value = {"/recruit"})
    public String recruitPage(){
        return "recruitManagePage";
    }
}
