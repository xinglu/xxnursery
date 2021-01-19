package com.nursery.common.exception;


import com.nursery.common.model.response.ResultCode;

/**
 * 异常抛出类
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2020/9/3
 * Time:9:23
 */
public class ExceptionCast {

    public static void  cast(ResultCode resultCode){
        throw  new CustomException(resultCode);
    }
}
