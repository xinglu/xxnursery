package com.nursery.api.iwebm;

import com.nursery.common.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * author:MeiShiQiang
 * Date:2021/1/27 | Time:11:42
 */
@Api(value = "/manage/recruit",description = "招聘管理")
public interface SecondeLevelRecruitManageApi {

    @ApiOperation("获取招聘信息")
    QueryResponseResult getRecruitManage(String param);

}
