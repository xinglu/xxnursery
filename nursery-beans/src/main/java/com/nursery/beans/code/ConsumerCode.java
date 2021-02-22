package com.nursery.beans.code;

import com.google.common.collect.ImmutableMap;
import com.nursery.common.model.response.ResultCode;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/2/3 | Time:16:45
 * 用户
 */
@ToString
public enum ConsumerCode implements ResultCode {

    CONSUMER_SQL_SUCCEED(true,13001,"用户信息更新成功！"),
    CONSUMER_SQL_FAIL(false,13002,"用户信息操作数据库错误！"),
    CONSUMER_PARAM_NONE(false,13003,"请传入正确的参数信息！"),
    CONSUMER_PASSWORD_NONE(false,13004,"请输入密码！"),
    CONSUMER_VERIFYCODE_NONE(false,13005,"请输入验证码！"),
    CONSUMER_ACCOUNT_NOTEXISTS(false,13006,"账号不存在！"),
    CONSUMER_CREDENTIAL_ERROR(false,13007,"账号或密码错误！"),
    CONSUMER_LOGIN_ERROR(false,13008,"登陆过程出现异常请尝试重新操作！"),
    CONSUMER_SELECT_LIST_ISNULL(true,13009,"查询为空！"),
    CONSUMER_SQL_SELECT_FAIL(true,13010,"查询失败！"),
    CONSUMER_PARAM_ID_ISNOT(false,13011,"参数不对，没有id值！"),
    CONSUMER_VERIFY_CELL_NOT(false,13012,"手机号格式不正确！"),
    CONSUMER_VERIFY_EMAIL_NOT(false,13013,"邮箱格式不正确！"),
    CONSUMER_FAIL_TO_REGISTER(false,13014,"注册失败！"),
    CONSUMER_REAL_NAME_WRONG(false,13015,"请输入正确的真实姓名！");

    boolean success;

    int code;

    String message;

    ConsumerCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    private static final ImmutableMap<Integer, ConsumerCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, ConsumerCode> builder = ImmutableMap.builder();
        for (ConsumerCode commonCode : values()) {
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
