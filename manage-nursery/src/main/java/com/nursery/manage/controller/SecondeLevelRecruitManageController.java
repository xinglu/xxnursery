package com.nursery.manage.controller;

import com.alibaba.druid.util.StringUtils;
import com.nursery.api.iservice.INurseryRecruitInfoSV;
import com.nursery.api.iwebm.SecondeLevelRecruitManageApi;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:MeiShiQiang
 * Date:2021/1/27 | Time:11:38
 * 一级目录 recruit manage | 二级目录 招聘管理
 */
@Controller
@RequestMapping("/manage/recruit")
public class SecondeLevelRecruitManageController extends BaseController implements SecondeLevelRecruitManageApi {
    private static final Logger logger = LoggerFactory.getLogger(RSAUtils.class);

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

    /**
     * @param param 包含 用户id、ip地址、当前所在地
     * @return
     */
    @GetMapping("/getRecruitManage")
    @Override
    public QueryResponseResult getRecruitManage(/*@PathVariable("param")*/ String param) {
        Map<String, String> returnMap = new HashMap<>();
        QueryResult<RecruitmentDO> queryResult = new QueryResult<RecruitmentDO>();
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.FAIL, queryResult);
        try {
            String rsa_param = RSAUtils.decrypt(param);//解密
            if (!StringUtils.isEmpty(rsa_param)){
                String[] arr_param = param.split("|");//进行切割
                String userId = arr_param[0];
                String ipAddress = arr_param[1];
                String address = arr_param[2];
                if(!StringUtils.isEmpty(userId) && (!StringUtils.isEmpty(ipAddress) || !StringUtils.isEmpty(address))){
                    //记录当前ip和地址,以防后台管理系统出现问题
                    logger.error(userId+"==>当前ip"+ ipAddress +"当前地址:"+ address);
                }
                List<RecruitmentDO> recruitmentDOList = null;
                if (!StringUtils.isEmpty(userId)){
                    recruitmentDOList = nurseryRecruitInfoSV.selectRecruitinfoByerid(userId);
                    if(recruitmentDOList!=null&&!recruitmentDOList.isEmpty()){
                        queryResult.setList(recruitmentDOList);
                        queryResult.setTotal(recruitmentDOList.size());
                    }
                }
            }
        }catch (Exception e){
            logger.error("rsa解密出错");
            try {
                //如果解密失败，则随机生成密钥对；返回
                RSAUtils.genKeyPair();
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            }
            returnMap.put("publicKey",RSAUtils.getPublicKey());
            queryResponseResult.setBean(returnMap);
            return queryResponseResult;
        }
        queryResponseResult.setCommonCode(CommonCode.SUCCESS);
        return queryResponseResult;
    }
}
