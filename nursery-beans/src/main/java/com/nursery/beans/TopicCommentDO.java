package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * author:MeiShiQiang
 * Date:2021/3/1 | Time:11:39
 * 话题 - 评论
 * tb_comment
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TopicCommentDO implements Serializable {

    private String id;
    private String content;
    private String topicId;
    private String consumerId;
    private String consumerIId;
    private String consumerName;
    private String consumerIntroduce;

}
