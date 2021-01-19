package com.nursery.api.iweb;

import com.nursery.common.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 首页信息展示
 *      幼儿园 招聘信息
 */

@Api(value = "/nursery/recruit",description = "首页信息展示 ,幼儿园 招聘信息")
public interface NurseryRecruitInfoApi {

    @ApiOperation("根据分类信息和,表名字(模糊)查询")
    public QueryResponseResult recruitList(String classify, String tablename);

    @ApiOperation("热门招聘信息")
    public QueryResponseResult hotRecruitlist();
}
