package com.nursery.api.iservice;

import com.nursery.beans.DomesticConsumerDO;
import com.nursery.beans.bo.ConsumerBO;

import java.sql.SQLException;
import java.util.List;

/**
 * DomesticConsumerMapper
 */
public interface IDomesticConsumerSV {


    //根据id获取用户信息
    DomesticConsumerDO findByconsumerID(String consumerID) throws Exception;
    //比对密码是否正确
    boolean selectPassword(String consumerID, String password);
    //更新密码
    boolean updatePassword(String consumerID, String password);
    //注册用户
    void insertConsumer(DomesticConsumerDO domesticConsumerDO) throws Exception;
    //查询当前月份新增用户，
    List<DomesticConsumerDO> selectByMonth(String date);
    //查询当前季度份新增用户，
    List<DomesticConsumerDO> selectByQuarter(String date);
    //查询今年份新增用户，
    List<DomesticConsumerDO> selectByYear(String date);
    //查询所有的用户
    List<DomesticConsumerDO> selectConsumers();
    //查询个人资料
    DomesticConsumerDO selectConsumerByConsumerID(String consumerID) throws SQLException;
    //更新个人资料
    int updateConsumer(DomesticConsumerDO consumerDO)throws Exception;
    //更新密码
    void addPassword(String id,String password) throws Exception ;
    //登录:邮箱
    ConsumerBO findByMailAndPass(String mail, String pass) throws SQLException;
    //登录:手机号
    ConsumerBO findByCellAndPass(String cellPhone, String pass) throws SQLException;
    //更新相关简历内容
    int updateConsumerResume(DomesticConsumerDO consumerDO);
    //获取简历resume的相关字段
    DomesticConsumerDO selectConsumerResumeByConsumerID(String consumerId) throws SQLException;
    //根据id获取简历id
    String selectResumeIdByConsumerID(String consumerId);
}
