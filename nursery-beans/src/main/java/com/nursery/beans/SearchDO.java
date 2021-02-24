package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/2/23 | Time:16:41
 * 搜索框排名 tb_search
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SearchDO {
    private String info;       //varchar(128)   搜索框信息
    private String count;      //varchar(100)   搜索次数
    private String startdate;  //varchar(24)    第一次搜索时间
    private String newdate;    //varchar(24)    最近一次搜索时间
    //1，入参格式化 @DateTimeFormat(pattern="yyyy-MM-dd")
    //
    //　　前台返回日期格式字符处，实体类中是Date类型，访问抛出异常 ，需要实体类中加入日期格式化注解。
    //
    //2，出参格式化 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")

}
