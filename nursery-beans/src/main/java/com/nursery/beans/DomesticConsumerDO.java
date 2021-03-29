package com.nursery.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 普通用户--应聘者
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
    private String consumerAge;//年龄
    private String consumerEducationBg;//教学背景
    private String consumerEduBgCollege;//教学背景-大学
    private String consumerEduBgDepartment;//教学背景-院系
    private String consumerEduBgSpecialty;//教学背景-专业
    private String consumerEduBgDegree;//教学背景-学位
    private String consumerEduBgGrade;//教学背景-成绩
    private String consumerEduBgCourse;//教学背景-课程
    private String consumerStatus;//省份
    @ApiModelProperty("头像:外键id")
    private String consumerURL;//头像
    private String consumerBirthday;//生日
    private String consumerJoinDay;//加入时间
    private Integer resumeISNOT;//简历是否上传 默认0 没有, 1 已经上传
    @ApiModelProperty("简历:外键id")
    private String resumeId;//简历:外键id
    private DomesticConsumerResumeDO consumerResume;
}
