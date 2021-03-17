package com.nursery.dao;

import com.nursery.beans.RecruiterManagmentDO;
import com.nursery.beans.RoleDO;

import java.sql.SQLException;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/15 | Time:11:25
 */
public interface RecruiterManagmentMapper {


    //根据id查询姓名
    String selectRealName(RecruiterManagmentDO recruiterManagmentDO) throws SQLException;

    //根据姓名查询
    RecruiterManagmentDO selectByUsername(String username);

    //根据
    List<RoleDO> selectRolesByUsername(String recruitId);
}
