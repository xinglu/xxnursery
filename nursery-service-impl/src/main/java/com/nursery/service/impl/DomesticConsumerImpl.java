package com.nursery.service.impl;

import com.nursery.api.iservice.IDomesticConsumerSV;
import com.nursery.beans.DomesticConsumerDO;
import com.nursery.beans.vo.MailVo;
import com.nursery.dao.DomesticConsumerMapper;
import com.nursery.utils.SendEmailUtils;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2021/1/2
 * Time:12:36
 */
@Service
public class DomesticConsumerImpl implements IDomesticConsumerSV {
    private static final Logger logger = LoggerFactory.getLogger(DomesticConsumerImpl.class);


    @Autowired
    @SuppressWarnings("all")
    DomesticConsumerMapper mapper;

    @Override
    public DomesticConsumerDO findByconsumerID(String consumerID) throws Exception {
        return mapper.selectByID(consumerID);
    }

    @Override
    public boolean selectPassword(String consumerID, String password) {
        try {
            DomesticConsumerDO byconsumerID = findByconsumerID(consumerID);
            String consumerPass = byconsumerID.getConsumerPass();
            if (consumerPass.equals(password)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean updatePassword(String consumerID, String password) {
        try {
            DomesticConsumerDO byconsumerID = findByconsumerID(consumerID);
            String consumerPass = byconsumerID.getConsumerPass();
            if (!consumerPass.equals(password)) {
                Integer integer = mapper.updatePassword(consumerID, password);
                if (integer == 1) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void insertConsumer(DomesticConsumerDO consumerDO) throws Exception {
        try {
            SendEmailUtils sendEmailUtils = null;
            mapper.insert(consumerDO);
            String consumerEmail = consumerDO.getConsumerEmail();
            String consumerCellPhone = consumerDO.getConsumerCellPhone();
            // 邮件功能
            if (StringUtils.isNotBlank(consumerEmail) && checkEmail(consumerEmail)) {
                logger.info("发送邮件consumerEmail：" + consumerEmail);
                sendEmailUtils = new SendEmailUtils();
                MailVo mailVo = new MailVo();
                mailVo.setTo(consumerEmail);
                mailVo.setSubject("发送邮件标题");
                mailVo.setText("发送邮件的正文内容。。。。。。。");
                try {
                    sendEmailUtils.sendSimpleEmail(mailVo);
                } catch (Exception e) {
                    logger.debug("注册用户：" + consumerDO.getConsumerID() + "发送邮件错误");
                }
            }
            // 手机号短信
            if (StringUtils.isNotBlank(consumerCellPhone)&& checkCellphone(consumerCellPhone)) {

            }

        }catch (Exception e){
            logger.error("注册错误");
        }
    }

    //校验邮箱
    private boolean checkEmail(String consumerEmail){
        boolean flag = false;

        return flag;
    }

    //校验手机号
    private boolean checkCellphone(String consumerCellPhone){
        boolean flag = false;

        return flag;
    }

}