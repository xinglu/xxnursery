package com.nursery.cmsweb.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.IHotTopicSV;
import com.nursery.api.iweb.DiscoverApi;
import com.nursery.beans.HotTopicDO;
import com.nursery.beans.TopicCommentDO;
import com.nursery.beans.bo.ConsumerBO;
import com.nursery.common.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:MeiShiQiang
 * Date:2021/2/25 | Time:16:52
 * 发现- 热门话题
 */
@Controller
public class DiscoverController extends BaseController implements DiscoverApi {
    private Logger logger = LoggerFactory.getLogger(DiscoverController.class);
    @Autowired
    private IHotTopicSV hotTopicSV;


    // http://localhost:32226/discover/wenti/2?number=jj
    @RequestMapping(value = "/discover/wenti/{tableId}", method = RequestMethod.GET)
    @ResponseBody
    @Override
    public ModelAndView visitWenti(
            @PathVariable(value = "tableId", required = true) String tableId,
            @RequestParam(value = "number", required = false) String param,
            RedirectAttributes attr) {
        ModelAndView modelAndView = new ModelAndView();
        if (!StringUtils.isEmpty(param)) {
            attr.addAttribute("error", "参数信息不正确请先登录");
            modelAndView.setViewName("redirect:/discover/wenti/" + tableId);
            try {
                ConsumerBO consumerBO = (ConsumerBO) session.getAttribute(param);
                if (consumerBO == null) {
                    return modelAndView;
                }
            } catch (Exception e) {
                return modelAndView;
            }
        }
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("tableid", tableId);
        HotTopicDO topic = null;
        modelAndView.setViewName("discover_wenti");
        try {
            topic = hotTopicSV.getTopic(tableId);
            returnMap.put("tag", topic.getTag());
            returnMap.put("introduce", topic.getIntroduce());
            returnMap.put("startdate", topic.getStartDate());
            returnMap.put("content", topic.getContent());
            returnMap.put("tablename", topic.getTableName());
            returnMap.put("author", topic.getAuthor());
            returnMap.put("authorId", topic.getAuthorId());
            List<TopicCommentDO> commentDOS = topic.getCommentDOS();
            modelAndView.addObject("commentDOS", commentDOS);
        } catch (NullPointerException nullPointerException) {
            System.out.println("null");
            modelAndView.setViewName("404");
        } catch (SQLException throwables) {
            System.out.println("sql");
        }
        logger.info(JSON.toJSONString(returnMap));
        modelAndView.addObject("data", returnMap);
        return modelAndView;
    }


    //http://localhost:32226/discover?number=202103221543272312

    /**
     * 访问discover页面
     *
     * @param param 前端流水号
     */
    @RequestMapping(value = {"/discover"}, method = RequestMethod.GET)
    @ResponseBody
    @Override
    public ModelAndView visitDiscover(RedirectAttributes attr, @RequestParam(value = "number", required = false) String param) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (!StringUtils.isEmpty(param)) {
                attr.addAttribute("error", "参数信息不正确请先登录");
                modelAndView.setViewName("redirect:/discover");
                try {
                    ConsumerBO consumerBO = (ConsumerBO) session.getAttribute(param);
                    if (consumerBO == null) {
                        return modelAndView;
                    }
                } catch (Exception e) {
                    return modelAndView;
                }
            }
            List<HotTopicDO> topicRandom = hotTopicSV.getTopicRandom();
            modelAndView.addObject("data", topicRandom);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        modelAndView.setViewName("discover");
        return modelAndView;
    }
}
