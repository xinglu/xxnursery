package com.nursery.api.iweb;

import com.nursery.common.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户登录api
 */
@Api(value = "/consumer")
public interface ConsumerLoginApi {

    @ApiOperation("生成验签 判断短信,邮箱")
    ResponseResult sendCheckCode(String channel);

    @ApiOperation("登录方法")
    ResponseResult login();
}
