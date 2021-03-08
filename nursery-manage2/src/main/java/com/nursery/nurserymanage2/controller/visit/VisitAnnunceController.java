package com.nursery.nurserymanage2.controller.visit;

import com.nursery.api.iservice.INurseryAnnounceSV;
import com.nursery.api.iwebm.visit.VisitAnnunceApi;
import com.nursery.beans.NurseryAnnounceDO;
import com.nursery.common.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

/**
 * author:MeiShiQiang
 * 通告管理中心
 */
@Controller
public class VisitAnnunceController extends BaseController implements VisitAnnunceApi {

    private Logger logger = LoggerFactory.getLogger(VisitAnnunceController.class);

    @Autowired
    private INurseryAnnounceSV annunceManageSV;

    @RequestMapping(value = {"/manage/announcement/{erId}.html"},method = RequestMethod.GET)
    @Override
    public ModelAndView visitAnnuncePage(@PathVariable(value = "erId") String id, ModelAndView modelAndView) {
        modelAndView.setViewName("annuncePage");
        try {
            List<NurseryAnnounceDO> announceDOS = annunceManageSV.selectAnnunces();
            modelAndView.addObject("announcedata",announceDOS);
        } catch (SQLException throwables) {
            logger.error("报错信息："+throwables.getMessage());
        }
        return modelAndView;
    }

    /**
     *
     * @param id  管理人员id
     * @param modelAndView 返回餐宿
     * @return ModelandView
     */
    @RequestMapping(value = {"/manage/pullAnnouncement/{erId}.html"},method = RequestMethod.GET)
    @Override
    public ModelAndView pullAnnuncePage(@PathVariable(value = "erId") String id, ModelAndView modelAndView) {
        modelAndView.setViewName("annuncePullPage");
        return modelAndView;
    }

    @RequestMapping(value = {"/manage/announce/detail/{erId}/{announceId}.html"},method = RequestMethod.GET)
    @ResponseBody
    @Override
    public ModelAndView getAnnuncePage( @PathVariable(value = "erId") String id,@PathVariable(value = "announceId") String announceId, ModelAndView modelAndView) {
        modelAndView.setViewName("annunceDetailPage");
        try {
            NurseryAnnounceDO announceById = annunceManageSV.getAnnounceById(announceId);
            modelAndView.addObject("announce",announceById);
        } catch (SQLException throwables) {
            logger.error("错误sql : "+throwables.getSQLState()+" 错误信息: "+throwables.getMessage());
        }
        return modelAndView;
    }

}
