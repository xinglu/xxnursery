package com.nursery.api.iweb;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/2/25 | Time:14:13
 */
@Api(value = "/information",description = "最新新闻，资讯")
public interface InformationApi {

    @ApiOperation("访问资讯页面")
    ModelAndView visitInformation(ModelAndView modelAndView);

}
