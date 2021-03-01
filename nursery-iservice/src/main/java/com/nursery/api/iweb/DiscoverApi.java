package com.nursery.api.iweb;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/2/25 | Time:16:49
 */
@Api(value = "/discover",description = "最新内容，发现")
public interface DiscoverApi {

    @ApiOperation("访问发现页面")
    ModelAndView visitDiscover(ModelAndView modelAndView);
    @ApiOperation("问题跳转")
    ModelAndView visitWenti(String table,ModelAndView modelAndView);
}
