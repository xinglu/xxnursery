package com.nursery.api.iwebm.visit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/2/7 | Time:10:16
 * 个人中心 跳转页面
 */
@Api(value = "/manage/consumer",description = "个人中心-访问")
public interface VisitConsumerApi{

    //访问个人中心页面
    @ApiOperation("访问个人中心")
    ModelAndView visitConsumerPage();

    @ApiOperation("访问个人信息")
    ModelAndView getConsumerInfoByID(String consumerID,ModelAndView modelAndView);
}
