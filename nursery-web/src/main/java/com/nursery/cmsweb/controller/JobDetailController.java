package com.nursery.cmsweb.controller;

import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.*;
import com.nursery.api.iweb.JobDetailApi;
import com.nursery.beans.RecruitmentDO;
import com.nursery.common.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/2/24 | Time:16:33
 * job_detail.html
 */
@Controller
public class JobDetailController extends BaseController implements JobDetailApi {
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

    @GetMapping("/job_detail")
    @ResponseBody
    public ModelAndView visitJobDetailPage(ModelAndView modelAndView) {
        try {
            List<RecruitmentDO> recruitmentDOList = nurseryRecruitInfoSV.selectRecruitmentDOs();
            modelAndView.addObject("recommendData", recruitmentDOList);
            logger.info(JSON.toJSONString(recruitmentDOList));
        } catch (Exception e) {

        }
        modelAndView.setViewName("job_detail");
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/job_detail/{id}.html")
    public ModelAndView clickDetailPage(@PathVariable(value = "id", required = true) String recruitId, ModelAndView model) {
        try {
            model.setViewName("recruitment_Details");
            RecruitmentDO recruitmentDO = nurseryRecruitInfoSV.selectRecruitInfoByrecruitid(recruitId);
            if (ObjectUtils.isEmpty(recruitmentDO)) {
                model.addObject("message","错误信息");
                model.setViewName("404");
                return model;
            }
            logger.info("查询招聘信息："+recruitmentDO);
            String classify = recruitmentDO.getClassify();
            String label = recruitmentDO.getRequireExperience();
            if (!StringUtils.isEmpty(classify)){
                classify.substring(0,classify.length()-1);
                String[] types = classify.split(",");
                recruitmentDO.setTypes(types);
            }
            if (!StringUtils.isEmpty(label)){
                label.substring(0,label.length()-1);
                String[] labels = label.split(",");
                recruitmentDO.setLabels(labels);
            }
            model.addObject("recruitment",recruitmentDO);
        }catch (Exception e){
            model.addObject("message","错误信息");
            model.setViewName("500");
        }
        return model;
    }

}
