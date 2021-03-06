package com.nursery.common.model.response;

import lombok.ToString;

@ToString
public enum CommonCode implements ResultCode{

    SUCCESS(true,10000,"操作成功！"),
    INVALID_PARAM(false,10003,"非法参数！"),
    FAIL(false,11111,"操作失败！"),
    IS_EXIST(false,11112,"抱歉,已存在！"),
    PASSWORDISEQUALITY(false,11113,"密码不能喝原密码相同！"),
    PASSWORDISNOTFORMAT(false,11114,"密码格式不正确！"),
    SELECTISFAIL(false,11115,"查询失败！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！");
//    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
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
