package com.nursery.dao;

import com.nursery.beans.DomesticConsumerDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户表操作
 */
public interface DomesticConsumerMapper {

    //保存
    @Insert("insert into tb_consumer (consumer_id,consumer_address,consumer_cellphone,consumer_name,consumer_password," +
            "consumer_qianming,consumer_email,consumer_sex,consumer_nickname,consumer_age" +
            ",consumer_status,consumer_educationBg,consumer_URL,consumer_birthDay,consumer_joinDay) " +
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

    //查询个人信息
    @Select("select * from tb_consumer where consumer_id = #{consumerID}")
    @ResultMap("domesticConsumer")
    DomesticConsumerDO selectByID(String consumerID)throws Exception;

    //修改密码
    @Update("update tb_consumer set consumer_password = #{param2}  where consumer_id = #{param1}")
    Integer updatePassword(String consumerID, String password) throws Exception;

    //校验用户是否存在 to 注册
    @Select("select * from tb_consumer where consumer_email = #{consumerEmail} or consumer_cellphone = #{consumerCellPhone}")
    @ResultMap("domesticConsumer")
    List<DomesticConsumerDO> checkConsumerToRegister(DomesticConsumerDO checkDConsumerDo);

    //查询当前月份新增用户，
    @Select("select * from tb_consumer where consumer_joinDay like #{date} ")
    @ResultMap("domesticConsumer")
    List<DomesticConsumerDO> selectByMonth(String date);

    //查询当前季度份新增用户，
    @Select("select * from tb_consumer where consumer_joinDay between #{param1} AND #{param2}")
    @ResultMap("domesticConsumer")
    List<DomesticConsumerDO> selectByQuarter(String param1, String param2);

    //查询今年份新增用户，
    @Select("select * from tb_consumer where consumer_joinDay  like '#{date}' ")
    @ResultMap("domesticConsumer")
    List<DomesticConsumerDO> selectByYear(String date);

    //查询所有用户
    @Select("select * from tb_consumer ")
    @ResultMap("domesticConsumer")
    List<DomesticConsumerDO> selectConsumers();

}
