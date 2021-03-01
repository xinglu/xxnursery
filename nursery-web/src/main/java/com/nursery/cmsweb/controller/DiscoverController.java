package com.nursery.cmsweb.controller;

import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.IHotTopicSV;
import com.nursery.api.iweb.DiscoverApi;
import com.nursery.beans.HotTopicDO;
import com.nursery.beans.TopicCommentDO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:MeiShiQiang
 * Date:2021/2/25 | Time:16:52
 * 发现- 热门话题
 */
@Controller
@RequestMapping("/discover")
public class DiscoverController extends BaseController implements DiscoverApi {
    private Logger logger = LoggerFactory.getLogger(DiscoverController.class);
    @Autowired
    private IHotTopicSV hotTopicSV;
//    http://localhost:32226/wenti/3

    @RequestMapping(value = "/wenti/{tableid}",method = RequestMethod.GET)
    @ResponseBody
    @Override
    public ModelAndView visitWenti(@PathVariable("tableid") String tableid, ModelAndView modelAndView) {
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("tableid",tableid);
        HotTopicDO topic = null;
        modelAndView.setViewName("discover_wenti");
        try {
            topic = hotTopicSV.getTopic(tableid);
            returnMap.put("tag",topic.getTag());
            returnMap.put("introduce",topic.getIntroduce());
            returnMap.put("startdate",topic.getStartDate());
            returnMap.put("content",topic.getContent());
            returnMap.put("tablename",topic.getTableName());
            returnMap.put("author",topic.getAuthor());
            returnMap.put("authorId",topic.getAuthorId());
            List<TopicCommentDO> commentDOS = topic.getCommentDOS();
            modelAndView.addObject("commentDOS",commentDOS);
        } catch (NullPointerException nullPointerException) {
            System.out.println("null");
            modelAndView.setViewName("404");
        } catch (SQLException throwables) {
            System.out.println("sql");
        }
        logger.info(JSON.toJSONString(returnMap));
        modelAndView.addObject("data",returnMap);
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @Override
    public ModelAndView visitDiscover(ModelAndView modelAndView) {
        try {
            List<HotTopicDO> topicRandom = hotTopicSV.getTopicRandom();
            modelAndView.addObject("data",topicRandom);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        modelAndView.setViewName("discover");
        return modelAndView;
    }
}
