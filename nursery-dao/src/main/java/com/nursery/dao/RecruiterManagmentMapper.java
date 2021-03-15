package com.nursery.dao;

import com.nursery.beans.RecruiterManagmentDO;

import java.sql.SQLException;

/**
 * author:MeiShiQiang
 * Date:2021/3/15 | Time:11:25
 */
public interface RecruiterManagmentMapper {


    //根据id查询姓名
    String selectRealName(RecruiterManagmentDO recruiterManagmentDO) throws SQLException;
}
