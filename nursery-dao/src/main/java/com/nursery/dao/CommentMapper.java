package com.nursery.dao;

import com.nursery.beans.TopicCommentDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    @Insert("insert into tb_comment (id,t_content,topic_id,consumer_id_i,t_consumer_name,t_consumer_introduce,t_date)" +
            "values (#{id},#{content},#{tableId},#{consumer_id},#{consumer_name},#{consumer_introduce},#{date})")
    void insertTopicComment(Map<String, String> map) throws SQLException;
}
