package com.nursery.api.iservice;

import com.nursery.beans.DomesticConsumerResumeDO;

import java.sql.SQLException;

/**
 * author:MeiShiQiang
 * Date:2021/2/26 | Time:11:34
 * 个人简历业务
 */
public interface IConsumerResumeSV {
    //保存简历信息
    void insertResume(DomesticConsumerResumeDO consumerResumeDO) throws SQLException;

}
