package com.nursery.api.iservice;

import com.nursery.beans.DomesticConsumerDO;

import java.sql.SQLException;
import java.util.List;

/**
 * DomesticConsumerMapper
 */
public interface IDomesticConsumerSV {


    DomesticConsumerDO findByconsumerID(String consumerID) throws Exception;

    boolean selectPassword(String consumerID, String password);

    boolean updatePassword(String consumerID, String password);

    //注册
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
    DomesticConsumerDO selectConsumerByConsumerID(String consumerID) throws Exception;

    //更新个人资料
    int updateConsumer(DomesticConsumerDO consumerDO)throws Exception;

    //更新密码
    void addPassword(String id,String password) throws Exception ;

    //登录
    DomesticConsumerDO findByMailAndPass(String mail, String pass) throws SQLException;
}
