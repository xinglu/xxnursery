package com.nursery.nurserymanage2.controller;

import com.nursery.common.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class HelloController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

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
