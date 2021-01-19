package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 招聘内容
 *
 * CREATE TABLE `tb_nursery_recruitinfo` (
 *   `id` varchar(32) NOT NULL,
 *   `recruittablename` varchar(128) DEFAULT NULL COMMENT '招聘标题',
 *   `recruitclassify` varchar(4) DEFAULT NULL COMMENT '招聘分类信息',
 *   `recruitpay` varchar(12) DEFAULT NULL COMMENT '招聘待遇--薪资',
 *   `recruitstarttime` varchar(16) DEFAULT NULL COMMENT '招聘开始时间',
 *   `recruitendtime` varchar(16) DEFAULT NULL COMMENT '招聘结束时间',
 *   `recruitplace` varchar(64) DEFAULT NULL COMMENT '招聘地点',
 *   `recruitrequire_experience` varchar(16) DEFAULT NULL COMMENT'招聘要求--工作经验',
 *   `recruitrequire_edubg` varchar(4) DEFAULT NULL COMMENT '招聘要求--学历',
 *   `recruitnumbers` varchar(2) DEFAULT NULL COMMENT '招聘人数',
 *   `companyresume` varchar(255) DEFAULT NULL COMMENT '公司简历',
 *   `jobdesciption` varchar(255) DEFAULT NULL COMMENT '职位描述',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentDO {
    private String id;
    private String recruittablename;//招聘标题
    private String classify;//招聘分类信息
    private String pay;//招聘待遇--薪资
    private String starttime;//招聘开始时间
    private String endtime;//招聘结束时间
    private String place;//招聘地点
    private String requireExperience;//招聘要求--工作经验
    private String requireEduDB;//招聘要求--学历
    private String manNumbers;//招聘人数
    private String companyresume;//公司简历
    private String jobdesciption;//职位描述

}
