package com.nursery.cmsweb.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.IHotTopicSV;
import com.nursery.api.iweb.DiscoverApi;
import com.nursery.beans.DBDataParam;
import com.nursery.beans.HotTopicDO;
import com.nursery.beans.TopicCommentDO;
import com.nursery.beans.bo.ConsumerBO;
import com.nursery.common.model.response.CommonCode;
import com.nursery.common.model.response.ResponseResult;
import com.nursery.common.web.BaseController;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
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
    public static final String NOW_DATE_YMDHMS = "yyyy-MM-dd HH:mm:ss";
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


    /**
     * 发表言论
     * @param dataParam 参数
     */
    @RequestMapping(value = {"/discover/answer"})
    @ResponseBody
    @Override
    public ResponseResult publishDiscoverAnswer(DBDataParam dataParam){
        //参数
        ResponseResult responseResult = ResponseResult.FAIL();
        HashMap<String, String> returnMap = new HashMap<>();
        String id = CommonUtil.getUUID();
        String liushui = dataParam.getParam1();
        String tableId = dataParam.getParam2();
        String answer = dataParam.getParam3();//回答的话
        String yhu = "";
        if (!StringUtils.isEmpty(liushui)){
            Map<String, String> map = new HashMap<>();
            ConsumerBO consumerBO = (ConsumerBO) session.getAttribute(liushui);
            if (!ObjectUtils.isEmpty(consumerBO)){
                map.put("id",id);
                map.put("content",answer);
                map.put("tableId",tableId);
                map.put("consumer_id",consumerBO.getId());
                yhu = consumerBO.getYhu();
                map.put("consumer_name",yhu);
                map.put("date", DateUtils.getNowDate(NOW_DATE_YMDHMS));
                String introduce = consumerBO.getIntroduce();
                if(StringUtils.isEmpty(introduce)){
                    introduce = CommonUtil.getIntroduce(consumerBO.getId());
                }
                map.put("consumer_introduce",introduce);
                try {
                    hotTopicSV.insertTopicComment(map);
                } catch (SQLException throwables) {
                    logger.error("错误原因: "+throwables.getMessage()+"错误代码: "+throwables.getSQLState()+"");
                    return responseResult;
                }
            }else {
                responseResult.setCommonCode(CommonCode.SERVER_ERROR);
                return responseResult;
            }
        }else {
            responseResult.setCommonCode(CommonCode.UNAUTHENTICATED);
            return responseResult;
        }
        responseResult.setCommonCode(CommonCode.SUCCESS);
        returnMap.put("yhu",yhu);
        responseResult.setBean(returnMap);
        return responseResult;
    }
    /*
        CREATE TABLE `tb_topic` (
          `id` varchar(32) NOT NULL COMMENT '唯一主键',
          `t_table` varchar(128) DEFAULT NULL COMMENT '标题',
          `t_content` varchar(1000) NOT NULL COMMENT '内容',
          `startdate` varchar(24) NOT NULL COMMENT '开始时间',
          `t_tag` varchar(24) NOT NULL COMMENT '标签',
          `t_author` varchar(24) NOT NULL COMMENT '作者',
          `t_authid` varchar(32) NOT NULL COMMENT '作者id',
          `t_introduce` varchar(64) DEFAULT NULL COMMENT '作者介绍',
     */

}
