package com.nursery.manage.controller;

import com.nursery.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HelloController extends BaseController {
    @RequestMapping(value = {"/test"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"/register","/register/","/register.html","/nursery/register","/nursery/register/","/nursery/register.html"})
    public String register(){
        return "consumerRegisterPage";
    }
    @RequestMapping(value = {"/login","/login.html","/login/","/nursery/login","/nursery/login/","/nursery/login.html"})
    public String login(){
        return "man_login";
    }
    @RequestMapping(value = {"/index","/index.html","/index/","/nursery/main","/nursery/main/","/nursery/main.html"})
    public void index_main(){
        try {
            response.sendRedirect("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
