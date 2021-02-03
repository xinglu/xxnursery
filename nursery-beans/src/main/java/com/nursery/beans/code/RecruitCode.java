package com.nursery.beans.code;

import com.google.common.collect.ImmutableMap;
import com.nursery.common.model.response.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/2/3 | Time:16:45
 * 招聘
 */
@ToString
public enum RecruitCode implements ResultCode {

    RECRUIT_SQL_SUCCEED(false,23001,"招聘信息更新成功！"),
    RECRUIT_SQL_FAIL(false,23001,"招聘信息操作数据库错误！"),
    RECRUIT_PARAM_NONE(false,23001,"请传入正确的参数信息！"),
    RECRUIT_PASSWORD_NONE(false,23002,"请输入密码！"),
    RECRUIT_VERIFYCODE_NONE(false,23003,"请输入验证码！"),
    RECRUIT_ACCOUNT_NOTEXISTS(false,23004,"账号不存在！"),
    RECRUIT_CREDENTIAL_ERROR(false,23005,"账号或密码错误！"),
    RECRUIT_LOGIN_ERROR(false,23006,"登陆过程出现异常请尝试重新操作！");

    //操作代码
    @ApiModelProperty(value = "操作是否成功", example = "true", required = true)
    boolean success;

    //操作代码
    @ApiModelProperty(value = "操作代码", example = "22001", required = true)
    int code;
    //提示信息
    @ApiModelProperty(value = "操作提示", example = "操作过于频繁！", required = true)
    String message;
    private RecruitCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, RecruitCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, RecruitCode> builder = ImmutableMap.builder();
        for (RecruitCode commonCode : values()) {
            builder.put(commonCode.code(), commonCode);
        }
        CACHE = builder.build();
    }

    @Override
    public boolean success() {
        return false;
    }

    @Override
    public int code() {
        return 0;
    }

    @Override
    public String message() {
        return null;
    }
}
