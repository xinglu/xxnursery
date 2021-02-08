package com.nursery.service.impl;

import com.nursery.api.iservice.IDomesticConsumerSV;
import com.nursery.beans.DomesticConsumerDO;
import com.nursery.beans.vo.MailVo;
import com.nursery.dao.DomesticConsumerMapper;
import com.nursery.utils.EmailUtils;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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
        //注册前判断
        DomesticConsumerDO checkDConsumerDo = new DomesticConsumerDO();
        String checkEmail = consumerDO.getConsumerEmail();
        String checkCellPhone = consumerDO.getConsumerCellPhone();
        if (StringUtils.isNotBlank(checkEmail)){
            checkDConsumerDo.setConsumerEmail(checkEmail);
        }
        if (StringUtils.isNotBlank(checkCellPhone)){
            checkDConsumerDo.setConsumerCellPhone(checkCellPhone);
        }
        List<DomesticConsumerDO> resultList = mapper.checkConsumerToRegister(checkDConsumerDo);
        if (!resultList.isEmpty()){
            throw new SQLException("sql错误");
        }
        try {
            EmailUtils sendEmailUtils = null;
            mapper.insert(consumerDO);
            String consumerEmail = consumerDO.getConsumerEmail();
            String consumerCellPhone = consumerDO.getConsumerCellPhone();
            // 邮件功能

            if (StringUtils.isNotBlank(consumerEmail) && EmailUtils.checkEmail(consumerEmail)) {
                logger.info("发送邮件consumerEmail：" + consumerEmail);
                sendEmailUtils = new EmailUtils();
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

    //2021-01-21 16:32:53
    @Override
    public List<DomesticConsumerDO> selectByMonth(String date) {
        String dateMonth = date.substring(0,7);
        return mapper.selectByMonth(dateMonth+"%");
    }

    @Override
    public List<DomesticConsumerDO> selectByQuarter(String date) {
        String month = date.substring(5,7);
        String year = date.substring(0,5);
        int num = Integer.parseInt(month);
        String startMonth = "";
        String endMonth = "";
        if (1<=num && num<4){
            startMonth = "01";
            endMonth="04";
        }else if (4<=num && num<7){
            startMonth = "04";
            endMonth="07";
        }else if (7<=num && num<10){
            startMonth = "07";
            endMonth="10";
        }else {
            startMonth = "10";
            endMonth="01";
        }
        startMonth = year+startMonth+"%";
        endMonth = year+endMonth+"%";
        return mapper.selectByQuarter(startMonth,endMonth);
    }

    @Override
    public List<DomesticConsumerDO> selectByYear(String date) {
        return mapper.selectByYear(date.substring(0,4)+"%");
    }

    @Override
    public List<DomesticConsumerDO> selectConsumers() {
        return mapper.selectConsumers();
    }

    @Override
    public DomesticConsumerDO selectConsumerByConsumerID(String consumerID) throws SQLException {
        return mapper.selectConsumerByConsumerID(consumerID);
    }

    @Override
    public int updateConsumer(DomesticConsumerDO consumerDO) {
        return mapper.updateConsumer(consumerDO);
    }

    @Override
    public void addPassword(String id,String password) throws Exception {
        mapper.updatePassword(id,password);
    }

    //校验手机号
    private boolean checkCellphone(String consumerCellPhone){
        boolean flag = false;

        return true;
    }
}