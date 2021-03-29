package com.nursery.cmsweb.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.IDomesticConsumerSV;
import com.nursery.api.iweb.ConsumerLoginApi;
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
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
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
     * @param accountNum 账号
     * @param channel    1 邮箱 2  手机号
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
     * 登录
     * @param consumerBO 用户参数
     */
    @RequestMapping(value = {"/login"},method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseResult login(ConsumerBO consumerBO) {
        //获取前端url
        String referer = request.getHeader("referer");
        System.out.println(referer);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCommonCode(ConsumerCode.CONSUMER_CREDENTIAL_ERROR);
        String mail = "";
        String cellPhone = "";
        String pass = consumerBO.getPass();
        String username = consumerBO.getYhu();
        String liushui  = consumerBO.getLiushui();
        //判断yhu登录方式 手机号/邮箱
        if (!CellUtils.verify(username) && EmailUtils.verify(username)) {
            mail = username;
            try {
                consumerBO = domesticConsumer.findByMailAndPass(mail, pass);
            } catch (SQLException throwables) {
                logger.error("sql错误： " + throwables.getSQLState());
                return responseResult;
            }
            if (consumerBO == null) {
                logger.warn("前端用于查询为空");
                return responseResult;
            }
        }
        if (!EmailUtils.verify(username) && CellUtils.verify(username)) {
            cellPhone = username;
            try {
                consumerBO = domesticConsumer.findByCellAndPass(cellPhone, pass);
            } catch (SQLException throwables) {
                logger.error("sql错误： " + throwables.getSQLState());
                return responseResult;
            }
            if (consumerBO == null) {
                logger.warn("前端用户查询为空");
                return responseResult;
            }
        }
        //session
        HttpSession session = request.getSession();
        session.setAttribute(liushui, consumerBO);
        //cookie
        Cookie cookie = new Cookie("number",liushui);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
        //设置返回值
        responseResult.setSuccess(true);
        responseResult.setCode(200);
        String url = CommonUtil.getUrlByReferer(referer);
        responseResult.setMessage(url);
        logger.info(liushui+"返回值"+JSON.toJSONString(responseResult));
        return responseResult;
    }
}
