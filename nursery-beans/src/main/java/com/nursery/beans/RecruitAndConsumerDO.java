package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/3/15 | Time:14:06
 * 表名 tb_middle_consuemr_recruit
 * 用于 应聘者和招聘信息
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RecruitAndConsumerDO {
    private String consumerId;//应聘者id
    private String recruitId;//招聘信息id
    private String consumerName;   //应聘者 (姓名)
    private String consuemrToudiDate;//'应聘者(投递时间)',
    private int consumerAge;//'应聘者(年龄)',
    private String consuemrResume;//'应聘者(个人简介)',
    private String toudiStatus;//'投递状态(0未通过 , 1通过)',
    private String recruitTitle;//'招聘标题',
    private String recruitClassify;//'招聘类型',
    private String recruitPay;//'薪资',
    private String recruitPlace;//'地点',

}
