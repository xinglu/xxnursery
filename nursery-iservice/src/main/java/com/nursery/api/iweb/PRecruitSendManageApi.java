package com.nursery.api.iweb;

import com.nursery.beans.vo.PeoRecruitSendVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 个人  简历  投递  管理  Api
 */
@Api(value = "/p-recruit",description = "个人 简历 投递 管理 Api,包括投递的岗位,和投递的状态")
public interface PRecruitSendManageApi {

    @ApiOperation("根据id查询投递信息,并展显示到前端页面")
    List<PeoRecruitSendVO> showRecruitSend(String consumerID);

}
