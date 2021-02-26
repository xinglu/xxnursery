package com.nursery.api.iweb;

import com.nursery.beans.vo.PeoRecruitSendVO;
import com.nursery.common.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 简历上传 下载api
 */
@Api(value = "/resume",description = "专门提供简历上传 下载的api")
public interface ResumeApi {

    @ApiOperation("根据id查询投递信息,并展显示到前端页面")
    List<PeoRecruitSendVO> showRecruitSend(String consumerID);

    @ApiOperation("简历上传")
    QueryResponseResult resumeUpload(String strDocument, MultipartFile file);

    @ApiOperation("简历下载")
    QueryResponseResult resumeDownIng(String urlWord);

    @ApiOperation("简历修改")
    QueryResponseResult resumeUpdateUpload();

    @ApiOperation("简历在线观看")
    QueryResponseResult resumeOnlineReading();
}
