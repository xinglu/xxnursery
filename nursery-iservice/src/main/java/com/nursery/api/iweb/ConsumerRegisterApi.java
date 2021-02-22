package com.nursery.api.iweb;

import com.nursery.beans.bo.RegisterBO;
import com.nursery.common.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

/**
 * 用户注册api
 */
@Api(value = "/consumerRegister",description = "用户注册")
public interface ConsumerRegisterApi {


    @ApiOperation("创建用户")
    ResponseResult register(RegisterBO registerBO);

    @ApiOperation("注册成功,向邮箱发布信息")
    void sendRegisterinfo();

    @ApiOperation("点击确认,注册成功")
    void registersuccess();

    @ApiOperation("邮箱校验")
    public Map<String,String> sendCheckEmail(String email);

    @ApiOperation("手机号校验")
    public Map<String,String> sendCheckCellPhone(String cellPhone);
}
