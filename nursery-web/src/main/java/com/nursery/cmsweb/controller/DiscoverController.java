package com.nursery.cmsweb.controller;

import com.nursery.api.iweb.DiscoverApi;
import com.nursery.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/2/25 | Time:14:11
 * 对应  discover.html页面
 */
@Controller
@RequestMapping("/information")
public class DiscoverController extends BaseController implements DiscoverApi {

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public ModelAndView visitDiscover(ModelAndView modelAndView) {
        modelAndView.setViewName("information");
        return modelAndView;
    }
}
