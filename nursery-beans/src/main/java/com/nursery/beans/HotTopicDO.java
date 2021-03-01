package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/1 | Time:9:26
 * -- 话题表 TABLE tb_topic
 * -- 话题表 | 评论表
 * CREATE TABLE tb_comment(
 * 	id VARCHAR(32) PRIMARY KEY COMMENT '唯一主键',
 * 	t_content VARCHAR(500) COMMENT '内容',
 * 	topic_id VARCHAR(32) COMMENT '外键-话题id',
 * 	consumer_id_i VARCHAR(32) NOT NULL COMMENT '用户标题 | 一级',
 * 	consumer_id_ii VARCHAR(32) NOT NULL COMMENT '用户标题 | 二级'
 * )
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HotTopicDO {
    private String id;
    private String tableName;
    private String content;
    private String startDate;
    private String tag;
    private String author;
    private String introduce;
    private String authorId;
    private List<TopicCommentDO> commentDOS;
}