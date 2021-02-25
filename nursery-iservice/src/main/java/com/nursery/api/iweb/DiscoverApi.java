package com.nursery.api.iweb;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/2/25 | Time:14:13
 */
@Api(value = "/discover",description = "最新新闻，发现")
public interface DiscoverApi {

    @ApiOperation("访问发现页面")
    public ModelAndView visitDiscover(ModelAndView modelAndView);

}
