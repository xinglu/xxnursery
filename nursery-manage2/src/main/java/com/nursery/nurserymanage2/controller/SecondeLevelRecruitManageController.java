package com.nursery.nurserymanage2.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.INurseryRecruitInfoSV;
import com.nursery.api.iwebm.SecondeLevelRecruitManageApi;
import com.nursery.beans.RecruitmentDO;
import com.nursery.beans.bo.RecruitBO;
import com.nursery.beans.code.RecruitCode;
import com.nursery.common.model.response.ResponseResult;
import com.nursery.common.web.BaseController;
import com.nursery.utils.RSAUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * author:MeiShiQiang
 * Date:2021/1/27 | Time:11:38
 * 一级目录 recruit manage | 二级目录 招聘管理
 */
@Controller
@RequestMapping("/manage/recruit")
public class SecondeLevelRecruitManageController extends BaseController implements SecondeLevelRecruitManageApi {
    private static final Logger logger = LoggerFactory.getLogger(SecondeLevelRecruitManageController.class);

    @Autowired
    private INurseryRecruitInfoSV nurseryRecruitInfoSV;

    // 获取公钥
    @PostMapping("/getPublicKey")
    @ResponseBody
    public String getPublicKey() {
        String publicKey = RSAUtils.getPublicKey();
        logger.info("获取到公钥: " + publicKey);
        return publicKey;
    }

    // 模仿前端传来的数据
    @PostMapping("/getModol")
    @ResponseBody
    public String getModol() throws Exception {
        String publicKey = RSAUtils.getPublicKey();
        logger.info("获取到公钥: " + publicKey);

        InetAddress ip4 = Inet4Address.getLocalHost();
        String hostAddress = ip4.getHostAddress();
        String encrypt = RSAUtils.encrypt("1|" + hostAddress, publicKey);
        return encrypt;
    }

    /**
     * 更新招聘内容
     * @param recruitBO 招聘内容
     * @return 提示信息
     */
    @PutMapping("/recruitInfo")
    @ResponseBody
    @Override
    public ResponseResult putRecruitInfo(RecruitBO recruitBO) {
        //初始化返回值
        ResponseResult responseResult = ResponseResult.FAIL();
        String employment = recruitBO.getEmployment();
        String educationBg = recruitBO.getEducationBg();
        String companyProfile = recruitBO.getCompanyProfile();
        String endTime = recruitBO.getEndTime();
        String label = recruitBO.getLabel();
        String jobDescription = recruitBO.getJobDescription();
        String needNumber = recruitBO.getNeedNumber();
        String workPlace = recruitBO.getWorkPlace();
        String type = recruitBO.getType();
        String pay = recruitBO.getPay();
        //判断是否参数有误
        if (StringUtils.isEmpty(recruitBO.getId())) {
            logger.warn("参数不对，没有id值");
            responseResult.setCommonCode(RecruitCode.RECRUIT_PARAM_NONE);
            return responseResult;
        }
        try {
            RecruitmentDO recruitmentDO = new RecruitmentDO();
            recruitmentDO.setClassify(type);
            recruitmentDO.setId(recruitBO.getId());
            recruitmentDO.setCompanyresume(companyProfile);
            recruitmentDO.setEndtime(endTime);
            recruitmentDO.setRecruittablename(employment);
            recruitmentDO.setJobdesciption(jobDescription);
            recruitmentDO.setManNumbers(needNumber);
            recruitmentDO.setRequireEduDB(educationBg);
            recruitmentDO.setRequireExperience(label);
            recruitmentDO.setPlace(workPlace);
            recruitmentDO.setPay(pay);
            int i = nurseryRecruitInfoSV.updateRecruitInfo(recruitmentDO);
            //判断更新是否成功
            if (i > 0) {
                logger.warn(JSON.toJSONString(recruitmentDO));
                responseResult.setCommonCode(RecruitCode.RECRUIT_SQL_SUCCEED);
                return responseResult;
            }
        } catch (Exception e) {
            logger.error("sql操作错误");
            responseResult.setCommonCode(RecruitCode.RECRUIT_SQL_FAIL);
        }
        return responseResult;
    }

}
