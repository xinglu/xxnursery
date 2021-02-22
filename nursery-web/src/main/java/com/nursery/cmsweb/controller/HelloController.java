package com.nursery.cmsweb.controller;

import com.nursery.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HelloController extends BaseController {

    @RequestMapping(value = {"/register","/register/","/register.html","/nursery/register","/nursery/register/","/nursery/register.html"})
    public String register(){
        return "registration";
    }
    @RequestMapping(value = {"/login","/login.html","/login/","/nursery/login","/nursery/login/","/nursery/login.html"})
    public String login(){
        return "login";
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
