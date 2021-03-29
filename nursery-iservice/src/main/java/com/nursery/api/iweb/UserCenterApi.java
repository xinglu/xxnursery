package com.nursery.api.iweb;

import com.nursery.common.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.ModelAndView;

/**
 * 个人用户中心页面  personalCenterPage.jsp
 */
@Api(value = "/consumer",description = "个人用户中心信息")
public interface UserCenterApi {

    @ApiOperation("访问个人中心")
    public ModelAndView visitUserInfoPage(String param, ModelAndView modelAndView);

    @ApiOperation("用户编辑")
    public ModelAndView visitUserEditByID(String param, ModelAndView modelAndView);

    @ApiOperation("查询个人的大概信息,,,")
    ResponseResult generalContent(String consumerID);

    @ApiOperation("查询密码")
    ResponseResult selectPassword(String consumerID,String password);


    @ApiOperation("修改密码")
    ResponseResult updatePassword(String consumerID,String password);

}
