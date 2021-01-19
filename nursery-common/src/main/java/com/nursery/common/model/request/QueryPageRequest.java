package com.nursery.common.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryPageRequest extends RequestData{

    @ApiModelProperty("站点id")
    private String siteId;//站点id
    @ApiModelProperty("页面id")
    private String pageId;//页面id；
    @ApiModelProperty("页面名称")
    private String pageName;//页面名称
    @ApiModelProperty("别名")
    private String pageAliase;//别名
    @ApiModelProperty("模板id")
    private String templateId;//模板id
    @ApiModelProperty("模板id")
    private String pageType;//模板id

}
