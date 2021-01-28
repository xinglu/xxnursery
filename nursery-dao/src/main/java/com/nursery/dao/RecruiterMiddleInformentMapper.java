package com.nursery.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/1/27 | Time:17:22
 * 招聘人员 middle 招聘信息
 * sql: tb_middle_recruiter_info
 */
public interface RecruiterMiddleInformentMapper {

    /**
     * 根据招聘人员id 查找 招聘信息id
     * @param userId
     * @return
     */
    List<String> selectRecruitIdsByerid(String userId) throws SQLException;
}
