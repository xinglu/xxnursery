package com.nursery.dao;

import com.nursery.beans.TopicCommentDO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/1 | Time:17:09
 * `tb_comment`
 */
public interface CommentMapper {

    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "t_content",property = "content"),
            @Result(column = "topic_id",property = "topicId"),
            @Result(column = "consumer_id_i",property = "consumerId"),
            @Result(column = "consumer_id_ii",property = "consumerIId"),
            @Result(column = "t_consumer_name",property = "consumerName"),
            @Result(column = "t_consumer_introduce",property = "consumerIntroduce"),
    })
    @Select("select * from tb_comment where topic_id = #{topicId}")
    List<TopicCommentDO> commentDos(String topicId);

}
