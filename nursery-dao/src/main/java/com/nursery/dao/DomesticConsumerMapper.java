package com.nursery.dao;

import com.nursery.beans.DomesticConsumerDO;
import org.apache.ibatis.annotations.*;

/**
 * 用户表操作
 * consumer_id VARCHAR(32) PRIMARY KEY,
 * 	consumer_address VARCHAR(64) NOT NULL,
 * 	consumer_cellphone VARCHAR(11) NOT NULL,
 * 	consumer_name VARCHAR(32) NOT NULL,
 * 	consumer_password VARCHAR(32) NOT NULL,
 * 	consumer_qianming VARCHAR(64) NOT NULL
 */
public interface DomesticConsumerMapper {

    /**
     `consumer_id` varchar(32) NOT NULL,
     `consumer_address` varchar(64) NOT NULL,
     `consumer_cellphone` varchar(11) NOT NULL,
     `consumer_name` varchar(32) NOT NULL,
     `consumer_password` varchar(32) NOT NULL,
     `consumer_qianming` varchar(64) NOT NULL,
     `consumer_email` varchar(64) NOT NULL,
     `consumer_sex` char(2) DEFAULT NULL,
     `consumer_nickname` varchar(32) DEFAULT NULL,
     `consumer_age` char(3) DEFAULT NULL,
     `consumer_status` varchar(32) DEFAULT NULL,
     `consumer_educationBg` varchar(32) DEFAULT NULL,
     `consumer_URL` varchar(32) NOT NULL,
     `consumer_birthday` varchar(11) DEFAULT NULL,
     `consumer_joinDay` varchar(11) DEFAULT NULL,
     `resumeISNOT` int(1) NOT NULL DEFAULT '0',
     PRIMARY KEY (`consumer_id`),
     KEY `consumer_URL` (`consumer_URL`),
     CONSTRAINT `tb_consumer_ibfk_1` FOREIGN KEY (`consumer_URL`) REFERENCES `tb_consumerimage` (`image_id`)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8

     * @param domesticConsumerDO
     * @throws Exception
     */
    //保存
    @Insert("insert into tb_consumer (consumer_id,consumer_address,consumer_cellphone,consumer_name,consumer_password," +
            "consumer_qianming,consumer_email,consumer_sex,consumer_nickname,consumer_age,consumer_status,consumer_educationBg" +
            "consumer_URL,consumer_birthDay,consumer_joinDay) " +
            "values " +
            "(#{consumerID},#{consumerAddress},#{consumerCellPhone},#{consumerName},#{consumerPass}" +
            ",#{consumerSignature},#{consumerEmail},#{consumerSex},#{consumerNickname},#{consumerAge}" +
            ",#{consumerStatus},#{consumerEducationBg},#{consumerURL}" +
            ",#{consumerBirthday},#{consumerJoinDay})")
    void insert(DomesticConsumerDO domesticConsumerDO)throws Exception;

    //更新
    @Update("update")
    void update()throws Exception;

    //删除
    @Delete("delete from tb_consumer where consumer_id = #{consumerID}")
    void delete(String consumerID)throws Exception;

    //根据姓名查询
    @Select("select * from tb_consumer where consumer_name = #{name}")
    @Results(
            id = "domesticConsumer",
            value = {
                    @Result(id = true,column = "consumer_id",property = "consumerID"),
                    @Result(column = "consumer_address",property = "consumerAddress"),
                    @Result(column = "consumer_cellphone",property = "consumerCellPhone"),
                    @Result(column = "consumer_email",property = "consumerEmail"),
                    @Result(column = "consumer_name",property = "consumerName"),
                    @Result(column = "consumer_password",property = "consumerPass"),
                    @Result(column = "consumer_qianming",property = "consumerSignature"),
                    @Result(column = "consumer_sex",property = "consumerSex"),
                    @Result(column = "consumer_nickname",property = "consumerNickname"),
                    @Result(column = "consumer_age",property = "consumerAge"),
                    @Result(column = "consumer_status",property = "consumerStatus"),
                    @Result(column = "consumer_educationBg",property = "consumerEducationBg"),
                    @Result(column = "consumer_URL",property = "consumerURL"),
                    @Result(column = "consumer_birthday",property = "consumerBirthday"),
                    @Result(column = "resumeISNOT",property = "resumeISNOT"),
                    @Result(column = "consumer_joinDay",property = "consumerJoinDay")
            })
    DomesticConsumerDO selectByName(String name)throws Exception;

    //根据手机号查询
    @Select("select * from tb_consumer where consumer_name = #{name}")
    @ResultMap("domesticConsumer")
    DomesticConsumerDO selectByCellphone(String consumerCellPhone)throws Exception;

    @Select("select * from tb_consumer where consumer_id = #{consumerID}")
    @ResultMap("domesticConsumer")
    DomesticConsumerDO selectByID(String consumerID)throws Exception;

    @Update("update tb_consumer set consumer_password = #{param2}  where consumer_id = #{param1}")
    Integer updatePassword(String consumerID, String password) throws Exception;

}
