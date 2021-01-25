package com.nursery.cmsweb.controller;

import com.alibaba.druid.util.StringUtils;
import com.nursery.api.iweb.ConsumerLoginApi;
import com.nursery.beans.bo.ConsumerBO;
import com.nursery.common.model.response.CommonCode;
import com.nursery.common.model.response.QueryResponseResult;
import com.nursery.common.web.BaseController;
import com.nursery.utils.CellUtils;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.EmailUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2021/1/7
 * Time:15:14
 */
@Controller
@RequestMapping("/consumer")
public class ConsumerLoginController extends BaseController implements ConsumerLoginApi {
    /**
     * 登录-发送验证码
     * @param accountNum    账号
     * @param channel    1 邮箱 2  手机号
     * @return
     */
    @Override
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
    @Override
    public QueryResponseResult login(ConsumerBO consumerBO) {
        String channel = consumerBO.getChannel();
        if (!StringUtils.isEmpty(channel)){
            if ("0".equals(channel)){

            }else if ("1".equals(channel)){

            }else if ("2".equals(channel)){
                
            }else {
                return new QueryResponseResult(CommonCode.LOGIN_CHANNEL_IS_FAIL,null);
            }
        }

        return null;
    }
}
