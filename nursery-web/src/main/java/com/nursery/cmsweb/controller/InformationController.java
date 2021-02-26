package com.nursery.cmsweb.controller;

import com.nursery.api.iweb.InformationApi;
import com.nursery.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/2/25 | Time:14:11
 * 对应  discover.html页面
 *Information
 */
@Controller
@RequestMapping("/information")
public class InformationController extends BaseController implements InformationApi {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @Override
    public ModelAndView visitInformation(ModelAndView modelAndView) {
        modelAndView.setViewName("information");
        return modelAndView;
    }
}
