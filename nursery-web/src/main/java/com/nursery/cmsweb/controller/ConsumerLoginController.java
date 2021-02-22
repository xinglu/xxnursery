package com.nursery.cmsweb.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.IDomesticConsumerSV;
import com.nursery.api.iweb.ConsumerLoginApi;
import com.nursery.beans.DomesticConsumerDO;
import com.nursery.beans.bo.ConsumerBO;
import com.nursery.beans.code.ConsumerCode;
import com.nursery.common.model.response.CommonCode;
import com.nursery.common.model.response.QueryResponseResult;
import com.nursery.common.model.response.ResponseResult;
import com.nursery.common.web.BaseController;
import com.nursery.utils.CellUtils;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2021/1/7
 * Time:15:14
 */
@Controller
@RequestMapping("/consumer")
public class ConsumerLoginController extends BaseController implements ConsumerLoginApi {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerRegisterController.class);

    @Autowired
    private IDomesticConsumerSV domesticConsumer;

    /**
     * 登录-发送验证码
     *
     * @param accountNum 账号
     * @param channel    1 邮箱 2  手机号
     * @return
     */
    @Override
    @GetMapping("/login/sendCheckCode")
    public QueryResponseResult sendCheckCode(String accountNum, String channel) {
        if (StringUtils.isEmpty(accountNum) || StringUtils.isEmpty(channel)) {
            return new QueryResponseResult(CommonCode.INVALID_PARAM, null);
        }
        String verifyCode = "";
        if ("1".equals(channel) && EmailUtils.checkEmail(accountNum)) {
            verifyCode = CommonUtil.getVerifyCode(6);
            boolean success = EmailUtils.sendEmail(accountNum, verifyCode);
            if (success) {
                //验证码存入缓存，verifyCode

            } else {
                //失败,重新发送

                //重新发送失败，返回提示信息
            }
        } else if ("2".equals(channel)) {
            verifyCode = CommonUtil.getVerifyCode(6);
            boolean success = CellUtils.sendCell(accountNum, verifyCode);
            if (success) {
                //验证码存入缓存，verifyCode

            } else {
                //失败,重新发送

                //重新发送失败，返回提示信息
            }
        } else {
            return new QueryResponseResult(CommonCode.INVALID_PARAM, null);
        }
        return null;
    }

    /**
     * @param consumerBO
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    @Override
    public ResponseResult login(ConsumerBO consumerBO) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCommonCode(ConsumerCode.CONSUMER_CREDENTIAL_ERROR);
        String mail = consumerBO.getMail();
        String pass = consumerBO.getPass();
        DomesticConsumerDO consumerDO = null;
        try {
            consumerDO = domesticConsumer.findByMailAndPass(mail, pass);
            if (consumerDO==null){
                logger.warn(JSON.toJSONString(responseResult));
                return responseResult;
            }
            HttpSession session = request.getSession();
            session.setAttribute("user_", consumerDO);
        } catch (SQLException throwables) {
            logger.error(JSON.toJSONString(responseResult));
            return responseResult;
        }
        responseResult.setCommonCode(CommonCode.SUCCESS);
        logger.info(JSON.toJSONString(responseResult));
        logger.info(JSON.toJSONString(consumerDO));
        return responseResult;
    }
}
