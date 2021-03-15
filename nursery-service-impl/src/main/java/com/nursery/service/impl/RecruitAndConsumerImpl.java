package com.nursery.service.impl;

import com.nursery.api.iservice.IRecruitAndConsumerSV;
import com.nursery.beans.RecruitAndConsumerDO;
import com.nursery.dao.RecruitAndConsumerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/15 | Time:14:12
 */
@Service
public class RecruitAndConsumerImpl implements IRecruitAndConsumerSV {

    @Autowired
    @SuppressWarnings("all")
    private RecruitAndConsumerMapper recruitAndConsumerMapper;

    @Override
    public List<RecruitAndConsumerDO> getDOsByRecruitId(String id) throws SQLException {
        return recruitAndConsumerMapper.selectDomeByRecruitId(id);
    }
}
