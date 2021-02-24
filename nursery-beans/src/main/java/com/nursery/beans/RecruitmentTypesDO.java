package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 招聘信息分类列表
 * tb_type
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentTypesDO {
    private String id; //主键ID
    private String type_name;//类型名
    private String type_id; //html动态使用id
    private String clicks; //点击次数
}
