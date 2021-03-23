package com.nursery.cmsweb.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.nursery.api.iservice.*;
import com.nursery.api.iweb.NurseryIndexApi;
import com.nursery.beans.RecruitmentDO;
import com.nursery.beans.RecruitmentTypesDO;
import com.nursery.beans.SlideshowDO;
import com.nursery.beans.bo.ConsumerBO;
import com.nursery.common.web.BaseController;
import com.nursery.dao.NurseryAnnouncefMapper;
import com.nursery.dao.SlideshowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:MeiShiQiang
 * Date:2021/1/5
 * Time:11:16
 */
@Controller
public class NurseryIndexController extends BaseController implements NurseryIndexApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(NurseryIndexController.class);

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

    private String hotjob = "RANKED_FIRST_HOT_JOB";

    @GetMapping(value = {"/index","/","/index.html","/index/","/index.html/"})
    @ResponseBody
    public ModelAndView index(ModelAndView modelAndView,@RequestParam(value = "number",required = false) String param) {
        try {
            //1. 获取热门信息
            String[] sordStr = searchInfoSV.getSordStr();
            LOGGER.info("获取热门信息:" + JSONObject.toJSONString(sordStr));
            //2. 获取职位推荐
            List<RecruitmentDO> recruitmentDOList = nurseryRecruitInfoSV.getRandomRecruit();
            //3. 获取热招职位（只获取排行第一的）
            //3.1 获取职位类型信息
            List<RecruitmentTypesDO> recruitmentTypesDOList = recruitmentTypesSV.getTypesLimit();
            //3.2 根据type查询
            String type = recruitmentTypesDOList.get(0).getType_name();
            List<RecruitmentDO> recruitmentDOList1 = nurseryRecruitInfoSV.getRecruitByType(type);
            LOGGER.info("热门数据（"+type+"）:" + JSONObject.toJSONString(recruitmentDOList1));
            modelAndView.addObject("recommendData",recruitmentDOList);
            modelAndView.addObject("hotData",recruitmentDOList1);
            modelAndView.addObject("sordStr", sordStr);
            modelAndView.addObject("classStr",recruitmentTypesDOList);
            if (!StringUtils.isEmpty(param)){
                ConsumerBO attribute = (ConsumerBO) session.getAttribute(param);
                modelAndView.addObject("consuerBO",attribute);
            }
        } catch (Exception e) {
            modelAndView.setViewName("404");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/index/newJob"},method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getNewJob(ModelAndView model){
        //. 获取最新职位
        List<RecruitmentDO> recruitmentDOList = null;
        try {
            recruitmentDOList = nurseryRecruitInfoSV.getRecruitByNewDate();
            model.addObject("newData",recruitmentDOList);
            model.setViewName("index::new_job");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = {"/index/hotJob/{typeId}/{typename}"},method = RequestMethod.GET)
    @ResponseBody
    public List<RecruitmentDO> getHotJob(@PathVariable("typeId") String typeId,@PathVariable("typename") String typename){
        //. 获取最新职位
        List<RecruitmentDO> recruitmentDOList = null;
        try {
            recruitmentDOList = nurseryRecruitInfoSV.getRecruitByTypeId(typename);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recruitmentDOList;
    }

    /**
     * 退出 根据id退出
     * @param id
     */
    @RequestMapping(value = {"/logout/{param}"},method = RequestMethod.GET)
    public String logout(@PathVariable(value = "param",required = true) String id){
        try {
            session.removeAttribute(id);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return "500";
        }
        return "redirect:/index";
    }

    /**
     * 查询轮播图
     * @param classify
     * @return
     */
    public Map<String, String> slideList(String classify) throws SQLException {
        Map<String, String> slideMap = new HashMap<>();
        List<SlideshowDO> slideshowDTOS = null;
        slideshowDTOS = slideshowSV.slideList(classify);
        for (SlideshowDO slideshowDTO : slideshowDTOS) {
            // 轮播图名字 ; 路径
            // 轮播图宽 ; 高
            slideMap.put(slideshowDTO.getName() + ";" + slideshowDTO.getPath()
                    , slideshowDTO.getHeight() + ";" + slideshowDTO.getWidth());
        }
        return slideMap;
    }
}
