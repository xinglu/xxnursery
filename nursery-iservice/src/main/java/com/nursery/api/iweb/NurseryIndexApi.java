package com.nursery.api.iweb;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页
 */
@Api(description = "首页")
public interface NurseryIndexApi {

    @ApiOperation("首页")
    public ModelAndView index(ModelAndView modelAndView);

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
