package com.nursery.dao;

import com.nursery.beans.HotTopicDO;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.sql.SQLException;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/1 | Time:9:34
 * com.nursery.beans.HotTopicDO
 */
public interface HotTopicMapper {

    @Results({
            @Result(column = "id", property = "id", id = true, jdbcType = JdbcType.VARCHAR),
            @Result(column = "t_table", property = "tableName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "t_content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "t_tag", property = "tag", jdbcType = JdbcType.VARCHAR),
            @Result(column = "t_author", property = "author", jdbcType = JdbcType.VARCHAR),
            @Result(column = "t_authid", property = "authorId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "t_introduce", property = "introduce", jdbcType = JdbcType.VARCHAR),
            @Result(column = "t_introduce", property = "introduce", jdbcType = JdbcType.VARCHAR),
            @Result(column = "startdate", property = "startDate", jdbcType = JdbcType.VARCHAR)
    })
    @Select("SELECT *  FROM `tb_topic` AS t1 JOIN ( SELECT ROUND( RAND() * ( (SELECT MAX(id) FROM `tb_topic`) - (SELECT MIN(id) FROM `tb_topic`)  ) + (SELECT MIN(id) FROM `tb_topic`) ) AS id ) AS t2 WHERE t1.id >= t2.id ORDER BY t1.id  LIMIT 12;")
    List<HotTopicDO> selectTopicRandom() throws SQLException;

    @Results({
            @Result(column="id",property="id",id = true,jdbcType = JdbcType.VARCHAR),
            @Result(column="t_table",property="tableName",jdbcType = JdbcType.VARCHAR),
            @Result(column="t_content",property="content",jdbcType = JdbcType.VARCHAR),
            @Result(column="t_tag",property="tag",jdbcType = JdbcType.VARCHAR),
            @Result(column="t_author",property="author",jdbcType = JdbcType.VARCHAR),
            @Result(column="t_authid",property="authorId",jdbcType = JdbcType.VARCHAR),
            @Result(column="t_introduce",property="introduce",jdbcType = JdbcType.VARCHAR),
            @Result(column="t_introduce",property="introduce",jdbcType = JdbcType.VARCHAR),
            @Result(column="startdate",property="startDate",jdbcType = JdbcType.VARCHAR),
            @Result(column = "id",property = "commentDOS",many = @Many(select = "com.nursery.dao.CommentMapper.commentDos"))
    })
    @Select("select * from tb_topic where id = #{value}")
    HotTopicDO selectTopic(String value) throws SQLException;

}
