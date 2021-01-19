package com.nursery.api.iservice;

import com.nursery.beans.DomesticConsumerDO;

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

}
