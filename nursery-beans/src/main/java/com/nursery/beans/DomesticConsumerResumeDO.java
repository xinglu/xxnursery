package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * author:MeiShiQiang
 * Date:2021/3/29 | Time:10:59
 * 简历详情  tb_consumer_resume
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DomesticConsumerResumeDO implements Serializable {
    private String id;
    private String name;
    private String type;
    private String size;
    private String url;
    private String base64;
    private String htmlContent;
}
