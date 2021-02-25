package com.nursery.cmsweb.controller;

import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.*;
import com.nursery.beans.RecruitmentDO;
import com.nursery.dao.NurseryAnnouncefMapper;
import com.nursery.dao.SlideshowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/2/24 | Time:16:33
 * job_detail.html
 */
@Controller
public class JobDetailController {
    private static final Logger logger = LoggerFactory.getLogger(JobDetailController.class);

    @Autowired
    private INurseryRecruitInfoSV nurseryRecruitInfoSV;
    @Autowired
    private ISlideshowSV slideshowSV;//搜索框
    @Autowired
    private INurseryAnnounceSV nurseryAnnounceSV;
    @Autowired
    private ISearchInfoSV searchInfoSV;
    @Autowired
    private IRecruitmentTypesSV recruitmentTypesSV;

    @Autowired
    @SuppressWarnings("all")
    private NurseryAnnouncefMapper mapper;
    @Autowired
    @SuppressWarnings("all")
    private SlideshowMapper slideshowMapper;


    @GetMapping("/job_detail")
    @ResponseBody
    public ModelAndView index(ModelAndView modelAndView) {
        try {
            List<RecruitmentDO> recruitmentDOList = nurseryRecruitInfoSV.selectRecruitmentDOs();
            modelAndView.addObject("recommendData",recruitmentDOList);
            logger.info(JSON.toJSONString(recruitmentDOList));
        } catch (Exception e) {

        }
        modelAndView.setViewName("job_detail");
        return modelAndView;
    }

}
