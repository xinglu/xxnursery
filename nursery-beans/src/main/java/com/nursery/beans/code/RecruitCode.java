package com.nursery.beans.code;

import com.google.common.collect.ImmutableMap;
import com.nursery.common.model.response.ResultCode;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/2/3 | Time:16:45
 * 招聘
 */
@ToString
public enum RecruitCode implements ResultCode {

    RECRUIT_SQL_Fail(false,23000,"数据库插入失败！"),
    RECRUIT_SQL_SUCCEED(true,23001,"招聘信息更新成功！"),
    RECRUIT_SQL_FAIL(false,23002,"招聘信息操作数据库错误！"),
    RECRUIT_PARAM_NONE(false,23003,"请传入正确的参数信息！"),
    RECRUIT_PASSWORD_NONE(false,23004,"请输入密码！"),
    RECRUIT_VERIFYCODE_NONE(false,23005,"请输入验证码！"),
    RECRUIT_ACCOUNT_NOTEXISTS(false,23006,"账号不存在！"),
    RECRUIT_CREDENTIAL_ERROR(false,23007,"账号或密码错误！"),
    RECRUIT_LOGIN_ERROR(false,23008,"登陆过程出现异常请尝试重新操作！"),
    RECRUIT_Date_IS_WRONG(false,23009,"参数时间不正确，请再次确认后请求！"),
    RECRUIT_GET_ID_ISNULL(false,23010,"获取id失败！服务器异常");

    boolean success;

    int code;

    String message;

    RecruitCode(boolean success, int code, String message) {
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
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
