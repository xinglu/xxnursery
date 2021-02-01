package com.nursery.service.impl;

import com.nursery.api.iservice.INurseryRecruitInfoSV;
import com.nursery.beans.DBDataParam;
import com.nursery.beans.RecruitmentDO;
import com.nursery.dao.NurseryRecruitmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * 招聘信息 业务类
 */
@Service
public class NurseryRecruitInfoImpl implements INurseryRecruitInfoSV {
    private static Logger logger = LoggerFactory.getLogger(NurseryRecruitInfoImpl.class);

    @Autowired
    @SuppressWarnings("all")
    NurseryRecruitmentMapper mapper;

    @Override
    public List<RecruitmentDO> recruitList(DBDataParam dbDataParam) throws NullPointerException, SQLException {
        List<RecruitmentDO> list = null;
        if (dbDataParam != null) {
            try {
                list = mapper.selectByclassAndName(dbDataParam);
                if (list == null) {
                    System.out.println("抛出 null 对象错误");
                    throw new NullPointerException();
                }
            } catch (SQLException e) {
                throw new SQLException();
            }
        }
        return list;
    }

    @Override
    public List<RecruitmentDO> selectRecruitinfoByerid(String userId) throws SQLException {
        /*List<String> recruitIds = middleInformentMapper.selectRecruitIdsByerid(userId);
        List<RecruitmentDO> recruitmentDOList = new ArrayList<>();
        if (recruitIds != null && !recruitIds.isEmpty()) {
            RecruitmentDO recruitmentDO = null;
            for (String recruitId : recruitIds) {
                recruitmentDO = mapper.selectByid(recruitId);
                if (recruitmentDO!=null){
                    recruitmentDOList.add(recruitmentDO);
                }
            }
        }*/
        return mapper.selectRecruitmentDOsByRecruiterID(userId);
    }

    @Override
    public List<RecruitmentDO> selectRecruitinfoByerid() throws SQLException {
        return mapper.selectRecruitmentDOs();
    }

    @Override
    public RecruitmentDO selectRecruitInfoByrecruitid(String recruitid) throws SQLException {
        return mapper.selectRecruitInfoByrecruitid(recruitid);
    }
}
