package com.nursery.nurserymanage2.controller;

import com.nursery.api.iservice.ILoggerManageSV;
import com.nursery.beans.LogDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/18 | Time:10:19
 */
@Controller
public class ManageLoggerController {

    @Autowired
    private ILoggerManageSV loggerManageSV;
//    http://localhost:32227/manage/consumer/log.html
    @RequestMapping(value = {"/manage/consumer/log.html"},method = RequestMethod.GET)
    public ModelAndView consumerLog(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("consumer-log");
        modelAndView.setViewName("loggerConsumerPage");
        return modelAndView;
    }

    @RequestMapping(value = {"/manage/admin/log.html"},method = RequestMethod.GET)
    public ModelAndView adminLog(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("admin-log");
        modelAndView.setViewName("loggerAdminPage");
        return modelAndView;
    }


    @RequestMapping(value = {"/manage/consumer/log"},method = RequestMethod.POST)
    public ModelAndView consumerLog(LogDO logDO, RedirectAttributes attr){
        ModelAndView modelAndView = new ModelAndView();
        List<LogDO> logDOS = loggerManageSV.selectConsumerLogs(logDO);
        modelAndView.addObject("logDOS",logDOS);
        modelAndView.setViewName("loggerConsumerPage");
        return modelAndView;
    }

    @RequestMapping(value = {"/manage/admin/log"},method = RequestMethod.POST)
    public ModelAndView adminLog(LogDO logDO){
        ModelAndView modelAndView = new ModelAndView();
        List<LogDO> logDOS = loggerManageSV.selectAdminLogs(logDO);
        modelAndView.addObject("logDOS",logDOS);
        modelAndView.setViewName("loggerAdminPage");
        return modelAndView;
    }




}
