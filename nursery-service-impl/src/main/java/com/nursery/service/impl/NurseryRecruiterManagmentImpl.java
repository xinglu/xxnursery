package com.nursery.service.impl;

import com.nursery.api.iservice.INurseryRecruiterManagmentSV;
import com.nursery.beans.RecruiterManagmentDO;
import com.nursery.dao.RecruiterManagmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * author:MeiShiQiang
 * Date:2021/3/15 | Time:11:22
 */
@Service
public class NurseryRecruiterManagmentImpl implements INurseryRecruiterManagmentSV {

    @Autowired
    @SuppressWarnings("all")
    private RecruiterManagmentMapper mapper;

    @Override
    public String getRealName(RecruiterManagmentDO recruiterManagmentDO) throws SQLException {
        return mapper.selectRealName(recruiterManagmentDO);
    }
}
