package com.nursery.dao;

import com.nursery.beans.RecruitAndConsumerDO;

import java.sql.SQLException;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/15 | Time:14:10
 *
 */
public interface RecruitAndConsumerMapper {
    List<RecruitAndConsumerDO> selectDomeByRecruitId(String id) throws SQLException;
}
