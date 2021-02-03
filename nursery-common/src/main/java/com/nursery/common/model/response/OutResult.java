package com.nursery.common.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 统一返回参数   OutResult
 */
@Data
@ToString
@NoArgsConstructor
public class OutResult implements Response {

    //操作是否成功
    boolean success = SUCCESS;
    //操作代码
    int code = SUCCESS_CODE;
    //提示信息
    String message;

    public OutResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();

    }

    public static OutResult SUCCESS(){
        return new OutResult(CommonCode.SUCCESS);
    }
    public static OutResult FAIL(){
        return new OutResult(CommonCode.FAIL);
    }

}
