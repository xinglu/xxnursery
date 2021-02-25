package com.nursery.api.iweb;

import com.nursery.beans.RecruitmentDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    //获取最新数据
    @ApiOperation("获取最新数据")
    public ModelAndView getNewJob(ModelAndView model);

    /**
     * 获取热门数据
     * @param typeId   类型表示
     * @param typename 类型名称
     * @return 返回招聘信息
     */
    @ApiOperation("获取热门数据")
    public List<RecruitmentDO> getHotJob(String typeId,String typename);
}
