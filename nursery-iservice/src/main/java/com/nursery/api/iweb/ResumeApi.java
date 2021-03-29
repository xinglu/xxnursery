package com.nursery.api.iweb;

import com.alibaba.fastjson.JSONObject;
import com.nursery.common.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

/**
 * 简历上传 下载api
 */
@Api(value = "/resume",description = "专门提供简历上传 下载的api")
public interface ResumeApi {

    /**
     * 跳转到上传简历的页面
     * @param param 流水号
     */
    @ApiOperation("访问上传简历")
    public String visitResume(String param);

    public JSONObject uploadResume(MultipartFile file,String liushui);

    @ApiOperation("简历上传")
    QueryResponseResult resumeUpload(String strDocument, MultipartFile file);

    @ApiOperation("简历下载")
    QueryResponseResult resumeDownIng(String urlWord);

    @ApiOperation("简历修改")
    QueryResponseResult resumeUpdateUpload();

    @ApiOperation("简历在线观看")
    QueryResponseResult resumeOnlineReading();
}
