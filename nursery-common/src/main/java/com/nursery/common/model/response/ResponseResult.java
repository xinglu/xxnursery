package com.nursery.common.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * 统一返回参数   responoseresult
 */
@Data
@ToString
@NoArgsConstructor
public class ResponseResult implements Response {

    //操作是否成功
    boolean success = SUCCESS;
    //操作代码
    int code = SUCCESS_CODE;
    //提示信息
    String message;
    //返回的参数
    Map<String,String> bean;
    //参数的
    Map<String,Map<String,String>> beans;


    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();

    }
    public void setCommonCode(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static ResponseResult SUCCESS(){
        return new ResponseResult(CommonCode.SUCCESS);
    }
    public static ResponseResult FAIL(){
        return new ResponseResult(CommonCode.FAIL);
    }


    public Map<String, String> getBean() {
        return bean;
    }

    public void setBean(Map<String, String> bean) {
        this.bean = bean;
    }

    public Map<String, Map<String, String>> getBeans() {
        return beans;
    }

    public void setBeans(Map<String, Map<String, String>> beans) {
        this.beans = beans;
    }
}
