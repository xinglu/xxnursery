package com.nursery.api.iwebm;

import com.alibaba.fastjson.JSONObject;
import com.nursery.common.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

/**
 * author:MeiShiQiang
 * Date:2021/3/9 | Time:10:17
 */
//http://localhost:32227/manage/announce/delete/1
@Api(value = "/manage/announce", description = "通告管理中心")
public interface ManageAnnunceApi {

    @ApiOperation(value = "删除单个", response = ResponseResult.class, code = 200)
    public ResponseResult deleteAnnounce(String erid, String id);

    @ApiOperation(value = "上传图片")
    public JSONObject editormdPic(MultipartFile file);
}
