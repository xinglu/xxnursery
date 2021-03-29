package com.nursery.service.impl;

import com.nursery.api.iservice.IConsumerResumeSV;
import com.nursery.beans.DomesticConsumerResumeDO;
import com.nursery.dao.DomesticConsumerResumeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * author:MeiShiQiang
 * Date:2021/2/26 | Time:11:35
 */
@Service
public class ConsumerResumeImpl implements IConsumerResumeSV {

    @Autowired
    @SuppressWarnings("all")
    private DomesticConsumerResumeMapper resumeMapper;

    @Override
    public void insertResume(DomesticConsumerResumeDO consumerResumeDO) throws SQLException {
        resumeMapper.insertResume(consumerResumeDO);
    }
}
