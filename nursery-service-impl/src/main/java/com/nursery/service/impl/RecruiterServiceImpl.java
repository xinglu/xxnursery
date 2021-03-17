package com.nursery.service.impl;

import com.nursery.api.iservice.IRecruitERSV;
import com.nursery.beans.RecruiterManagmentDO;
import com.nursery.beans.RoleDO;
import com.nursery.dao.RecruiterManagmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/17 | Time:14:39
 */
@Service
public class RecruiterServiceImpl implements IRecruitERSV {

    @Autowired
    @SuppressWarnings("all")
    private RecruiterManagmentMapper recruiterMapper;


    @Override
    public RecruiterManagmentDO findByUsername(String username) {
        return recruiterMapper.selectByUsername(username);
    }

    @Override
    public List<RoleDO> findRolesByUsername(String recruitId) {
        return recruiterMapper.selectRolesByUsername(recruitId);
    }
}
