package com.nursery.api.iweb;

import com.nursery.common.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * 首页
 */
@Api(description = "首页")
public interface NurseryIndexApi {

    @ApiOperation("首页")
    ResponseResult index();


    /**
     * 测试
     *  添加数据
     */
    @PutMapping("/insertAnnounce")
    void insertAnnounce();
    /**
     * 测试
     *  添加数据
     */
    @PutMapping("/insertlunbotu")
    void insertlunbotu();

}
