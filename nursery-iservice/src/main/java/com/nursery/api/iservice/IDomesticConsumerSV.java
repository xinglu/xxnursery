package com.nursery.api.iservice;

import com.nursery.beans.DomesticConsumerDO;

import java.util.List;

/**
 * DomesticConsumerMapper
 */
public interface IDomesticConsumerSV {


    DomesticConsumerDO findByconsumerID(String consumerID) throws Exception;

    boolean selectPassword(String consumerID, String password);

    boolean updatePassword(String consumerID, String password);

    /**
     * 注册
     * @param domesticConsumerDO
     */
    void insertConsumer(DomesticConsumerDO domesticConsumerDO) throws Exception;

    //查询当前月份新增用户，
    List<DomesticConsumerDO> selectByMonth(String date);

    //查询当前季度份新增用户，
    List<DomesticConsumerDO> selectByQuarter(String date);

    //查询今年份新增用户，
    List<DomesticConsumerDO> selectByYear(String date);

    //查询所有的用户
    List<DomesticConsumerDO> selectConsumers();

}
