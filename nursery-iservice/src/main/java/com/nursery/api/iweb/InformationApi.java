package com.nursery.api.iweb;

import com.github.pagehelper.PageInfo;
import com.nursery.beans.NurseryAnnounceDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/2/25 | Time:14:13
 */
@Api(value = "/information", description = "最新新闻，资讯")
public interface InformationApi {

    @ApiOperation("访问资讯页面")
    ModelAndView visitInformation(ModelAndView modelAndView);

    @ApiOperation("访问资讯页面-最新")
    ModelAndView visitNewInformation(String page, String size, ModelAndView modelAndView);

    @ApiOperation("访问资讯页面-最热")
    ModelAndView visitHotInformation(String page, String size, ModelAndView modelAndView);

    @ApiOperation("点击更多-最新")
    PageInfo<NurseryAnnounceDO> visitNewInformation(String page, String param);

    @ApiOperation("点击更多-最热")
    PageInfo<NurseryAnnounceDO> visitHotInformation(String page, String param);

    @ApiOperation("访问资讯页面-推荐")
    ModelAndView visitRecommendInformation(ModelAndView modelAndView);

    @ApiOperation("点击详情")
    ModelAndView visitOneInformation(String id, ModelAndView modelAndView);
}
