package com.nursery.beans.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/2/22 | Time:10:47
 * 注册信息
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class RegisterBO {

    @ApiModelProperty("真实姓名")
    private String realName;
    private String address;
    private String email;
    private String birthday;
    private String gender;
    @ApiModelProperty("用户名")
    private String nickname;
    private String password;

}
