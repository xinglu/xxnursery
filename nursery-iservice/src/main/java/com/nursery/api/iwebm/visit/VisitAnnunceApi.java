package com.nursery.api.iwebm.visit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/3/8 | Time:15:04
 */
@Api(value = "/annunce",description = "通告管理中心")
public interface VisitAnnunceApi {

    @ApiOperation("访问通告管理中心页面")
    public ModelAndView visitAnnuncePage(String id, ModelAndView modelAndView);

    @ApiOperation("发布通告页面")
    public ModelAndView pullAnnuncePage(String id, ModelAndView modelAndView);

    @ApiOperation("访问通告单个页面")
    public ModelAndView getAnnuncePage(String announceId,String id, ModelAndView modelAndView);

}
