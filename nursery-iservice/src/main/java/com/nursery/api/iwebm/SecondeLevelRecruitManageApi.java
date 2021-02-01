package com.nursery.api.iwebm;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/1/27 | Time:11:42
 */
@Api(value = "/manage/recruit",description = "招聘管理")
public interface SecondeLevelRecruitManageApi {

    @ApiOperation("获取当前用户发布的招聘信息")
    ModelAndView getRecruitManage(String param);

    @ApiOperation("获取所有的招聘信息")
    ModelAndView getRecruitManage();

    @ApiOperation("获取单个详细招聘信息")
    public ModelAndView getRecruitInfoByrecruitid(String recruitid);
}
