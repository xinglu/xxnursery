package com.nursery.api.iwebm;

import com.nursery.beans.bo.RecruitBO;
import com.nursery.common.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:MeiShiQiang
 * Date:2021/1/27 | Time:11:42
 */
@Api(value = "/manage/recruit",description = "招聘管理")
public interface ManageRecruitApi {

    @ApiOperation(value = "更新招聘信息",httpMethod = "PUT",response = ModelAndView.class )
    public ResponseResult putRecruitInfo(RecruitBO recruitBO);
}
