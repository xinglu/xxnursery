package com.nursery.nurserymanage2.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.INurseryRecruitInfoSV;
import com.nursery.api.iwebm.ManageRecruitApi;
import com.nursery.beans.RecruitmentDO;
import com.nursery.beans.bo.RecruitBO;
import com.nursery.beans.code.RecruitCode;
import com.nursery.common.model.response.ResponseResult;
import com.nursery.common.web.BaseController;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.DateUtils;
import com.nursery.utils.RSAUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * author:MeiShiQiang
 * Date:2021/1/27 | Time:11:38
 * 一级目录 recruit manage | 二级目录 招聘管理
 */
@Controller
@RequestMapping("/manage")
public class ManageRecruitController extends BaseController implements ManageRecruitApi {
    private static final Logger logger = LoggerFactory.getLogger(ManageRecruitController.class);

    @Autowired
    private INurseryRecruitInfoSV nurseryRecruitInfoSV;

    // 获取公钥
    @PostMapping("/recruit/getPublicKey")
    @ResponseBody
    public String getPublicKey() {
        String publicKey = RSAUtils.getPublicKey();
        logger.info("获取到公钥: " + publicKey);
        return publicKey;
    }

    // 模仿前端传来的数据
    @PostMapping("/recruit/getModol")
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
     *
     * @param recruitBO 招聘内容
     * @return 提示信息
     */
//    @PutMapping("")
    @RequestMapping(value = "/recruit/recruitInfo", method = RequestMethod.POST)
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
        Integer needNumber = Integer.parseInt(recruitBO.getNeedNumber());
        String workPlace = recruitBO.getWorkPlace();
        String type = recruitBO.getType();
        String pay = recruitBO.getPay();
        logger.info("putRecruitInfo：RecruitBO==> " + recruitBO);
        //判断是否参数有误
        if (StringUtils.isEmpty(recruitBO.getId())) {
            logger.warn("参数不对，没有id值");
            responseResult.setCommonCode(RecruitCode.RECRUIT_PARAM_NONE);
            return responseResult;
        }
        try {
            RecruitmentDO recruitmentDO = new RecruitmentDO();
            recruitmentDO.setId(recruitBO.getId());
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
            logger.warn("putRecruitInfo: RecruitmentDO==>" + JSON.toJSONString(recruitmentDO));
            int i = nurseryRecruitInfoSV.updateRecruitInfo(recruitmentDO);
            //判断更新是否成功
            if (i > 0) {
                logger.error("putRecruitInfo： 更新成功,影响行数" + i);
                responseResult.setCommonCode(RecruitCode.RECRUIT_SQL_SUCCEED);
                return responseResult;
            }
        } catch (Exception e) {
            logger.error("putRecruitInfo： 更新失败");
            responseResult.setCommonCode(RecruitCode.RECRUIT_SQL_FAIL);
            return responseResult;
        }
        return responseResult;
    }

    /**
     * 发布招聘
     * @param recruitmentDO
     * @param erId
     * @return
     */
    @RequestMapping(value = "/postRecruitment/{erId}", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseResult postRecruitInfo(RecruitmentDO recruitmentDO, @PathVariable("erId")String erId) {
        ResponseResult responseResult = ResponseResult.SUCCESS();
        String id = CommonUtil.getUUID();
        String authorId = recruitmentDO.getAuthorId();  //发布者id
        String startTime = recruitmentDO.getStarttime();
        String endTime = recruitmentDO.getEndtime();
        //封面内容
        String recruittablename = recruitmentDO.getRecruittablename();//标题
        String place = recruitmentDO.getPlace();//地点
        String pay = recruitmentDO.getPay();//薪资情况
        String requireEduDB = recruitmentDO.getRequireEduDB();//学历要求
        int manNumbers = recruitmentDO.getManNumbers();//招聘人数
        String responsibility = recruitmentDO.getResponsibility();//职责描述
        String require = recruitmentDO.getRequire();//职位要求
        String treatment = recruitmentDO.getTreatment();//福利待遇
        String requireExperience = recruitmentDO.getRequireExperience();//工作经验
        String classify = recruitmentDO.getClassify();//分类信息

        try {
            /*判断参数问题*/
            if (StringUtils.isEmpty(recruittablename) || StringUtils.isEmpty(place)
                    || StringUtils.isEmpty(pay) || StringUtils.isEmpty(requireEduDB)) {
                logger.warn("请输入正确的参数！！");
                responseResult.setCommonCode(RecruitCode.RECRUIT_PARAM_NONE);
                return responseResult;
            }
            /*判断id 是否为null*/
            if (StringUtils.isEmpty(id)) {
                logger.warn("获取id为空，服务器异常！！");
                responseResult.setCommonCode(RecruitCode.RECRUIT_GET_ID_ISNULL);
                return responseResult;
            }
            recruitmentDO.setId(id);
            /*判断是否过期 传过来的日期格式 yyyy-MM-dd HH:ss*/
            if (StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)
                    || !DateUtils.verifyOverDue(startTime, endTime)) {
                logger.warn("日期格式不正确，or开始时间和结束时间前后顺序颠倒！");
                responseResult.setCommonCode(RecruitCode.RECRUIT_Date_IS_WRONG);
                return responseResult;
            }
            recruitmentDO.setCutoff("no");
            recruitmentDO.setEnrollFull("no");
            if(StringUtils.isEmpty(authorId)){
                recruitmentDO.setAuthorId(erId);
            }
            nurseryRecruitInfoSV.insertRecruitInfo(recruitmentDO);
            logger.info("招聘信息recruitmentDO "+ JSON.toJSONString(recruitmentDO));
        }catch (Exception e){
            logger.error("数据插入失败=>错误信息 : "+e.getMessage());
            responseResult.setCommonCode(RecruitCode.RECRUIT_SQL_Fail);
        }
        return responseResult;
    }

    @RequestMapping(value = "/manage/recruit/delete/{erId}/{recruitId}")
    public ResponseResult deleteRecruit(@PathVariable(value = "erId",required = true) String erId,@PathVariable(value = "recruitId",required = true) String recruitId){
        int i = nurseryRecruitInfoSV.deleteRecruitById(erId);
        return null;
    }
}
