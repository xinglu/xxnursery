package com.nursery.api.iweb;

import com.nursery.common.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 个人用户中心页面  personalCenterPage.jsp
 */
@Api(value = "/consumer",description = "个人用户中心信息")
public interface PersonalCenterApi {


    @ApiOperation("查询个人的大概信息,,,")
    ResponseResult generalContent(String consumerID);

    @ApiOperation("查询密码")
    ResponseResult selectPassword(String consumerID,String password);


    @ApiOperation("修改密码")
    ResponseResult updatePassword(String consumerID,String password);

}
