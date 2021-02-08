package com.nursery.api.iwebm;

import com.nursery.beans.DomesticConsumerDO;
import com.nursery.common.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * author:MeiShiQiang
 * Date:2021/2/8 | Time:14:19
 * 个人中心
 */
@Api(value = "/manage/consumer",description = "个人中心")
public interface ManageConsumerApi {

    //访问个人中心页面
    @ApiOperation("更新 个人资料")
    ResponseResult putConsumer(DomesticConsumerDO consumerDO);

    //访问个人中心页面
    @ApiOperation("更新 密码和头像")
    ResponseResult putConsumerPassAndImg(DomesticConsumerDO consumerDO);
}
