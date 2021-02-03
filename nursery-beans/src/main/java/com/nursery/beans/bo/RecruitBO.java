package com.nursery.beans.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/2/3 | Time:16:17
 * 招聘信息
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class RecruitBO {
    private String id;
    @ApiModelProperty("招聘类型- 老师-")
    private String type;
    @ApiModelProperty("公司简介")
    private String companyProfile;
    private String endTime;
    @ApiModelProperty("职位描述")
    private String jobDescription;
    @ApiModelProperty("需要人数")
    private String needNumber;
    @ApiModelProperty("薪资")
    private String pay;
    @ApiModelProperty("工作地点")
    private String workPlace;
    @ApiModelProperty("职业")
    private String employment;
    @ApiModelProperty("学历背景")
    private String educationBg;
    @ApiModelProperty("标签")
    private String label;

}
