package com.nursery.nurserymanage2.controller.visit;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.INurseryRecruitInfoSV;
import com.nursery.api.iwebm.visit.VisitRecruitApi;
import com.nursery.beans.RecruitmentDO;
import com.nursery.common.model.response.CommonCode;
import com.nursery.common.model.response.QueryResponseResult;
import com.nursery.common.model.response.QueryResult;
import com.nursery.common.web.BaseController;
import com.nursery.utils.RSAUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:MeiShiQiang
 * Date:2021/2/3 | Time:17:37
 * 访问招聘
 */
@Controller
public class VisitRecruitController extends BaseController implements VisitRecruitApi {
    private static final Logger logger = LoggerFactory.getLogger(VisitRecruitController.class);

    @Autowired
    private INurseryRecruitInfoSV nurseryRecruitInfoSV;

    /**
     * 获取所有的招聘信息
     * @return
     */
    @GetMapping("/manage/recruit/getRecruitManages")
    @ResponseBody
    public ModelAndView getRecruitManage() {
        Map<String, String> returnMap = new HashMap<>();
        QueryResult<RecruitmentDO> queryResult = new QueryResult<RecruitmentDO>();
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.FAIL, queryResult);
        ModelAndView modelAndView = new ModelAndView();

        try {
            List<RecruitmentDO> recruitmentDOList = null;

            recruitmentDOList = nurseryRecruitInfoSV.selectRecruitinfoByerid();
            if (recruitmentDOList != null && !recruitmentDOList.isEmpty()) {
                queryResult.setList(recruitmentDOList);
                queryResult.setTotal(recruitmentDOList.size());
            } else {

            }
        } catch (Exception e) {

        }
        queryResponseResult.setCommonCode(CommonCode.SUCCESS);
        modelAndView.addObject("data", queryResponseResult);
        modelAndView.setViewName("recruitManagePage");
        logger.info(JSON.toJSONString(queryResponseResult));
        return modelAndView;
    }

    /**
     * 根据内容id 获取招聘的详细信息
     *
     * @param recruitid 招聘内容id
     * @return 招聘详情页面、招聘更新页面
     */
    @GetMapping("/manage/recruit/getRecruitInfo/{recruitid}")
    @ResponseBody
    public ModelAndView getRecruitInfoByrecruitid(@PathVariable("recruitid") String recruitid) {
        QueryResult<RecruitmentDO> queryResult = new QueryResult<RecruitmentDO>();
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.FAIL, queryResult);
        ModelAndView modelAndView = new ModelAndView();
        try {
            RecruitmentDO recruitmentDO = nurseryRecruitInfoSV.selectRecruitInfoByrecruitid(recruitid);
            if (!ObjectUtils.isEmpty(recruitmentDO)) {
                queryResult.setObject(recruitmentDO);
                queryResponseResult.setCommonCode(CommonCode.SUCCESS);
            }
        } catch (Exception e) {

        }
        modelAndView.addObject("data", queryResponseResult);
        modelAndView.setViewName("recruitInfoPage");
        logger.info(JSON.toJSONString(queryResponseResult));
        return modelAndView;
    }


    /**
     * @param param 包含 用户id、ip地址、当前所在地
     * @return
     */
    @GetMapping("/manage/recruit/getRecruitManage")
    @ResponseBody
    public ModelAndView getRecruitManage(String param) {
        Map<String, String> returnMap = new HashMap<>();
        QueryResult<RecruitmentDO> queryResult = new QueryResult<RecruitmentDO>();
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.FAIL, queryResult);
        ModelAndView modelAndView = new ModelAndView();

        try {
            //String rsa_param = RSAUtils.decrypt(param);//解密
            String userId = param;
            if (!StringUtils.isEmpty(userId)) {
                List<RecruitmentDO> recruitmentDOList = null;
                if (!StringUtils.isEmpty(userId)) {
                    recruitmentDOList = nurseryRecruitInfoSV.selectRecruitinfoByerid(userId);
                    if (recruitmentDOList != null && !recruitmentDOList.isEmpty()) {
                        queryResult.setList(recruitmentDOList);
                        queryResult.setTotal(recruitmentDOList.size());
                    }
                }
            } else {
                logger.error("userid不能为空");
                queryResponseResult.setCommonCode(CommonCode.FAIL);
            }
        } catch (Exception e) {
            logger.error("rsa解密出错");
            try {
                //如果解密失败，则随机生成密钥对；返回
                RSAUtils.genKeyPair();
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            }
        }
        queryResponseResult.setCommonCode(CommonCode.SUCCESS);
        modelAndView.addObject("data", queryResponseResult);
        modelAndView.setViewName("recruitManagePage");
        logger.info(JSON.toJSONString(queryResponseResult));
        return modelAndView;
    }

}
