package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author:MeiShiQiang
 * Date:2021/3/8 | Time:16:31
 * 公告详情
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NurseryAnnounceDetailDO {
    private String title;   //表名
    private String bigContent; // 文本内容
    private String id;
    private String author;
    private String startDate;
}
