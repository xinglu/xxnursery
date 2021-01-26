package com.nursery.manage.controller;

import com.alibaba.druid.util.StringUtils;
import com.nursery.beans.bo.ConsumerBO;
import com.nursery.common.model.response.CommonCode;
import com.nursery.common.model.response.QueryResponseResult;
import com.nursery.common.web.BaseController;
import com.nursery.utils.CellUtils;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.EmailUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * 管理-登录
 */
@Controller
@RequestMapping("/manage")
public class ManageLoginController extends BaseController /*implements ConsumerLoginApi*/ {
    /**
     * 登录-发送验证码
     * @param accountNum    账号
     * @param channel    1 邮箱 2  手机号
     * @return
     */
//    @Override
    @GetMapping("/login/sendCheckCode")
    public QueryResponseResult sendCheckCode(String accountNum, String channel) {
        if (StringUtils.isEmpty(accountNum) || StringUtils.isEmpty(channel)){
            return new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }
        String verifyCode = "";
        if ("1".equals(channel) && EmailUtils.checkEmail(accountNum)){
            verifyCode = CommonUtil.getVerifyCode(6);
            boolean success = EmailUtils.sendEmail(accountNum, verifyCode);
            if (success) {
                //验证码存入缓存，verifyCode

            }else {
                //失败,重新发送

                //重新发送失败，返回提示信息
            }
        }else if ("2".equals(channel)){
            verifyCode = CommonUtil.getVerifyCode(6);
            boolean success = CellUtils.sendCell(accountNum, verifyCode);
            if (success) {
                //验证码存入缓存，verifyCode

            }else {
                //失败,重新发送

                //重新发送失败，返回提示信息
            }
        }else {
            return new QueryResponseResult(CommonCode.INVALID_PARAM,null);
        }
        return null;
    }

    /**
     *
     * @param consumerBO
     * @return
     */
    @PostMapping("/login.do")
//    @Override
    public String login(ConsumerBO consumerBO) {
        String channel = consumerBO.getChannel();
        // 直接重定向到首页
        try {
            response.sendRedirect("/manage/index");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!StringUtils.isEmpty(channel)){
            if ("0".equals(channel)){

            }else if ("1".equals(channel)){

            }else if ("2".equals(channel)){
                
            }else {

            }
        }

        return "";
    }
}
