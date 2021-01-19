package com.nursery.cmsweb.controller;

import com.nursery.api.iservice.IDomesticConsumerSV;
import com.nursery.api.iweb.PersonalCenterApi;
import com.nursery.beans.UserInfo;
import com.nursery.beans.DomesticConsumerDO;
import com.nursery.common.model.response.CommonCode;
import com.nursery.common.model.response.ResponseResult;
import com.nursery.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 个人中心业务
 *  查询个人信息   *
 *  更改密码操作   *
 *  更改用户名
 *  更改出生日期
 */
@RestController
@RequestMapping("/consumer")
public class PersonalCenterController extends BaseController implements PersonalCenterApi {

    @Autowired
    IDomesticConsumerSV domesticConsumerSV;

    /**
     * generalContent
     * @param consumerID
     * @return
     */
    @GetMapping("/generalContent")
    @Override
    public ResponseResult generalContent(String consumerID) {
        ResponseResult responseResult = ResponseResult.SUCCESS();
        Map<String, String> returnMap = new HashMap<>();
        String imageUrl = "";
        //1. 判断是否已经登录
        //2. 返回的参数有
        DomesticConsumerDO consumerDO = null;
        try {
            consumerDO = domesticConsumerSV.findByconsumerID(consumerID);
            if (consumerDO != null) {
                UserInfo userInfo = new UserInfo();
                userInfo.setAge(consumerDO.getConsumerAge());
                userInfo.setEducationBg(consumerDO.getConsumerEducationBg());
                userInfo.setStatus(consumerDO.getConsumerStatus());//身份
                returnMap.put("userName", consumerDO.getConsumerName());
                returnMap.put("consumerCellPhone", consumerDO.getConsumerCellPhone());
                returnMap.put("consumerEamil", consumerDO.getConsumerEmail());
                returnMap.put("consumerAddress", consumerDO.getConsumerAddress());
                returnMap.put("consumerNickname", consumerDO.getConsumerNickname());
                returnMap.put("consumerBirthday", consumerDO.getConsumerBirthday());
                returnMap.put("consumerJoinDay", consumerDO.getConsumerJoinDay());
                returnMap.put("userInfo", userInfo.toString());
                if (!imageUrl.equals(consumerDO.getConsumerURL())) {
                    imageUrl = consumerDO.getConsumerURL();
                } else {
                    imageUrl = "默认地址-头像-https://img.bosszhipin.com/boss/avatar/avatar_14.png";
                }
                Integer resumeflag = consumerDO.getResumeISNOT();
                if (consumerDO.getResumeISNOT()==0){//没有简历,,提示上传简历
                    //保存到jvm缓存中,   id + 0(RESUMERZORE),

                }
                returnMap.put("resumeflag", resumeflag.toString());//提示 用户 是否已经上传简历,判断后
                returnMap.put("imageUrl", imageUrl);
            } else {
                return new ResponseResult(CommonCode.UNAUTHORISE);
            }
        } catch (Exception e) {
            return new ResponseResult(CommonCode.SELECTISFAIL);
        }
        responseResult.setBean(returnMap);
        return responseResult;
    }

    /**
     * 比对密码正确
     * @param consumerID
     * @param password
     * @return
     */
    @PostMapping("/consultingcode")
    @Override
    public ResponseResult selectPassword(String consumerID, String password) {
        if ((password != null && !"".equals(password)) && (consumerID != null && !"".equals(consumerID))) {
            if (domesticConsumerSV.selectPassword(consumerID, password)) {
                //存入标识  PASSWORDSUCCESS

                //返回
                return ResponseResult.SUCCESS();
            }
        }
        return ResponseResult.FAIL();
    }

    //更改用户密码
    @PostMapping("/changecode")
    @Override
    public ResponseResult updatePassword(String consumerID, String password) {
        ResponseResult responseResult = new ResponseResult(CommonCode.FAIL);
        //获取标识 PASSWORDSUCCESS从redis中获取

        //如果存在则进行密码修改
        if (domesticConsumerSV.updatePassword(consumerID,password)){
            //1.更新redis和jvm缓存,

            //2.返回前端提示信息
            responseResult.setCode(CommonCode.SUCCESS.code());
            responseResult.setMessage(CommonCode.SUCCESS.message());
            responseResult.setSuccess(CommonCode.SUCCESS.success());
        }
        return responseResult;
    }

    //更改用户名
    @RequestMapping("/changeConsumerName")
    public void changeConsumerName(){

    }

    //设置出身日期
    @RequestMapping("/setBirthday")
    public void setBirthday(){

    }



}
