package com.nursery.api.iweb;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/3/4 | Time:8:42
 * 招聘
 */
@Api(value = "/jobdetail",description = "招聘信息")
public interface JobDetailApi {

    @ApiOperation("访问工作页面")
    public ModelAndView visitJobDetailPage(ModelAndView modelAndView);

    @ApiOperation("点击详情页面")
    public ModelAndView clickDetailPage(String recruitId,ModelAndView model);
}
