package com.nursery.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 通用参数
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DBDataParam {
    private String table_flag;//表名
    @ApiModelProperty("搜索关键字")
    private String search;
    @ApiModelProperty("类型")
    private String type;
    @ApiModelProperty("地点")
    private String placeId;
    private String param1;
    private String param2;
    private String param3;
}
