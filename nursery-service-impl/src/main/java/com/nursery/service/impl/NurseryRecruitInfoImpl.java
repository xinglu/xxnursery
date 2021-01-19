package com.nursery.service.impl;

import com.nursery.api.iservice.INurseryRecruitInfoSV;
import com.nursery.beans.DBDataParam;
import com.nursery.beans.RecruitmentDO;
import com.nursery.dao.NurseryRecruitmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * 招聘信息 业务类
 */
@Service
public class NurseryRecruitInfoImpl implements INurseryRecruitInfoSV {


    @Autowired
    @SuppressWarnings("all")
    NurseryRecruitmentMapper mapper;

    @Override
    public List<RecruitmentDO> recruitList(DBDataParam dbDataParam) throws NullPointerException,SQLException{
        List<RecruitmentDO> list = null;
        if (dbDataParam!=null){
            try {
                list = mapper.selectByclassAndName(dbDataParam);
                if (list==null){
                    System.out.println("抛出 null 对象错误");
                    throw new NullPointerException();
                }
            } catch (SQLException e) {
                throw new SQLException();
            }
        }
        return list;
    }
}
