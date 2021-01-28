package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/1/27 | Time:16:47
 * 招聘管理人员， 不由自己创建，有admin创建
 *  发布招聘，
 *  后期管理招聘信息、进度
 * sql: tb_er_recruit
 *  中间表 tb_middle_recruiter_info
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RecruiterManagmentDO {
    private String id;
    private String dateStr;
    private String recruitName;
    private String recruitPass;
    private String realName;
}
