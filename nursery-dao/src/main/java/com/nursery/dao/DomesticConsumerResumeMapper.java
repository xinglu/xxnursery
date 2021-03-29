package com.nursery.dao;

import com.nursery.beans.DomesticConsumerResumeDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

/**
 * 用户表操作
 */
public interface DomesticConsumerResumeMapper {

    //保存信息
    @Insert("insert into tb_consumer_resume (id,word_64base,word_url,word_size,word_type,word_name) " +
            "values (#{id},#{base64},#{url},#{size},#{type},#{name})")
    void insertResume(DomesticConsumerResumeDO consumerResumeDO) throws SQLException;

    //根据id查询
    @Select("select * from tb_consumer_resume where id = #{resumeId}")
    @Results(
            id = "consumerResume",
            value = {
                    @Result(column = "id",property = "id",id = true),
                    @Result(column = "word_64base",property = "base64"),
                    @Result(column = "word_url",property = "url"),
                    @Result(column = "word_size",property = "size"),
                    @Result(column = "word_type",property = "type"),
                    @Result(column = "word_name",property = "name")
            }
    )
    DomesticConsumerResumeDO selectConsumerResumeByResumeId(String resumeId);
}