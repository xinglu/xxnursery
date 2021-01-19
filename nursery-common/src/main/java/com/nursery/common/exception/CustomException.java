package com.nursery.common.exception;


import com.nursery.common.model.response.ResultCode;

/**
 * 自定义异常类
 * 定义异常类型
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2020/9/3
 * Time:9:20
 */
public class CustomException extends RuntimeException {

    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        super("错误代码: "+resultCode.code()+"错误信息: "+resultCode.message());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return this.resultCode;
    }
}
