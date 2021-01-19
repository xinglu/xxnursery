package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 普通用户--招聘者
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DomesticConsumerDO {
    private String consumerID;
    private String consumerName;    //名字
    private String consumerXing;    //姓
    private String consumerSex;     //性别
    private String consumerAddress; //地址
    private String consumerCellPhone;
    private String consumerEmail;
    private String consumerPass;
    private String consumerSignature;//签名
    private String consumerNickname;//昵称
    private String consumerAge;//昵称
    private String consumerEducationBg;//教学背景
    private String consumerStatus;//省份
    private String consumerURL;//头像
    private String consumerBirthday;//生日
    private String consumerJoinDay;//加入时间
    private Integer resumeISNOT ;//简历是否上传 默认0 没有, 1 已经上传

//    private String consumer;
//    private String consumerID;
//    private String consumerID;
//    private String consumerID;
//    private String consumerID;
//    private String consumerID;
//    private String consumerID;
//    private String consumerID;
//    private String consumerID;
//    private String consumerID;
//    private String consumerID;

}
