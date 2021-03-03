package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 公告数据
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NurseryAnnounceDO {

    private Integer id;
    private String table;//公告标题
    private String date;//公告发布时间
    private String date_YYYYMMDD;//公告发布时间
    private String author;//作者
    private String etcompiler;//编辑
    private String time;//浏览次数
    private String size;//公告总大小
    private String path;//路径
    private String imgPath;//表名
    private String content;//缩率内容  smallContent
    private String tableflag;//
    private String title;   //表名
    private String bigContent; // 文本内容

}
