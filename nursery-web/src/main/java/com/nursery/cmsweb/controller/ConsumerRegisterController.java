package com.nursery.cmsweb.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.IDomesticConsumerSV;
import com.nursery.api.iweb.ConsumerRegisterApi;
import com.nursery.beans.DomesticConsumerDO;
import com.nursery.common.web.BaseController;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.DateUtils;
import com.nursery.utils.CellUtils;
import com.nursery.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 需要服务
 * 短信接口
 * 邮箱接口
 * 获取当前省份
 */
@RestController
@RequestMapping("/consumerRegister")
public class ConsumerRegisterController extends BaseController implements ConsumerRegisterApi {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerRegisterController.class);
    @Autowired
    IDomesticConsumerSV domesticConsumerSV;

    /**
     * 注册
     * @param consumerDO
     */
    @PostMapping("/register")
    @Override
    @SuppressWarnings("all")
    public void register(DomesticConsumerDO consumerDO) {
        Map logoMap = new HashMap<String, String>();
        String consumerID = consumerDO.getConsumerID();
        String consumerName = consumerDO.getConsumerName();    //名字
        String consumerXing = consumerDO.getConsumerXing();    //姓
        String consumerSex = consumerDO.getConsumerSex();     //性别
        String consumerAddress = consumerDO.getConsumerAddress(); //地址
        String consumerCellPhone = consumerDO.getConsumerCellPhone();
        String consumerEmail = consumerDO.getConsumerEmail();
        String consumerPass = consumerDO.getConsumerPass();
        String consumerNickname = consumerDO.getConsumerNickname();//昵称
        String consumerAge = consumerDO.getConsumerAge();//根据出生日期得出
        String consumerEducationBg = consumerDO.getConsumerEducationBg();//教学背景
        String consumerStatus = consumerDO.getConsumerStatus();//省份
        String consumerURL = consumerDO.getConsumerURL();//头像
        String consumerBirthday = consumerDO.getConsumerBirthday();//生日
        String consumerJoinDay = consumerDO.getConsumerJoinDay();//加入时间

        try {
            String uuid = CommonUtil.getUUID();
            if (uuid != null && uuid.length() == 32) {
                consumerDO.setConsumerID(uuid);
                logoMap.put("id", consumerID);
            } else {
                System.out.println("获取id错误");
                request.setAttribute("returnCode", "服务器报错，请重新注册 '\n' 感谢你支持");
                return;
            }
            if (StringUtils.isEmpty(consumerName) || (StringUtils.isEmpty(consumerCellPhone)
                    && StringUtils.isEmpty(consumerEmail)) || StringUtils.isEmpty(consumerPass)) {
                System.out.println("参数错误");
                request.setAttribute("returnCode", "参数错误");
                return;
            }
            if (!StringUtils.isEmpty(consumerName)) {
                if (consumerName.length() <= 3) consumerXing = consumerName.substring(0, 1);
                else consumerXing = "";
                logoMap.put("name", consumerName);
                consumerDO.setConsumerXing(consumerXing);
                logoMap.put("xing", consumerXing);
            }
            logoMap.put("sex", consumerSex);
            logoMap.put("address", consumerAddress);
            logoMap.put("cellphone", consumerCellPhone);
            logoMap.put("email", consumerEmail);
            logoMap.put("pass", consumerPass);
            logoMap.put("nickname", consumerNickname);
            if (!StringUtils.isEmpty(consumerBirthday)) {
                logoMap.put("birthday", consumerBirthday);
                consumerAge = DateUtils.getAge(consumerBirthday);
                consumerDO.setConsumerAge(consumerAge);
                logoMap.put("age", consumerAge);
            }
            logoMap.put("edcationbg", consumerEducationBg);
            logoMap.put("status", consumerStatus);
            if (StringUtils.isEmpty(consumerURL)) {
                //  后期从数据库中获取   YLY_ZP_IMAGE_HEAR_URL
                consumerURL="image1";
                logoMap.put("consumerurl", consumerURL);
            }
            consumerDO.setConsumerURL(consumerURL);
            String consumerDayStr = consumerJoinDay;
            if (consumerDayStr == null || StringUtils.isEmpty(consumerDayStr)) {
                String nowDay = DateUtils.getNowDate(DateUtils.YYYYMMDDHHMMSS);
                consumerDayStr = nowDay;
            }
            logoMap.put("joinday", consumerDayStr);
            consumerDO.setConsumerJoinDay(consumerDayStr);
            logger.info("consumerid: "+uuid+"register注册参数："+JSON.toJSONString(consumerDO));
            domesticConsumerSV.insertConsumer(consumerDO);

            //重定向
            response.sendRedirect("");
        } catch (Exception e) {
            System.out.println("错误");
        }
    }

    @Override
    public void sendRegisterinfo() {

    }

    @Override
    public void registersuccess() {

    }

    @GetMapping("/sendCheckEmail")
    @Override
    public Map<String,String> sendCheckEmail(String email) {
        Map map = new HashMap<String,String>();
        String code = "";
        boolean authCode = EmailUtils.sendEmail(email,code);
        return map;
    }

    @GetMapping("/sendCheckCellPhone")
    @Override
    public Map<String,String> sendCheckCellPhone(String cellPhone) {
        Map map = new HashMap<String,String>();
        String authCode = CellUtils.sendCheckCellPhone(cellPhone);
        return map;
    }

}
