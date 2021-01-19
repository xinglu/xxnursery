package com.nursery.cmsweb.controller;

import com.nursery.api.iweb.ConsumerLoginApi;
import com.nursery.common.model.response.ResponseResult;
import com.nursery.common.web.BaseController;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2021/1/7
 * Time:15:14
 */
public class ConsumerLoginController extends BaseController implements ConsumerLoginApi {
    @Override
    public ResponseResult sendCheckCode(String channel) {
        return null;
    }

    @Override
    public ResponseResult login() {
        return null;
    }
}
