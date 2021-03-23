package com.nursery.beans.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 业务对象
 *  登录
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class ConsumerBO {
    private String id;
    @ApiModelProperty("用户")
    private String yhu;//用户
    private String mail;//邮箱账号
    private String cell;//手机账号
    @ApiModelProperty("验证码")
    private String verifyCode;//验证码
    private String pass;//
    @ApiModelProperty("标识-（1邮箱|验证码， 2手机号|验证码）")
    private String channel;//
    @ApiModelProperty("流水号")
    private String liushui;

}
