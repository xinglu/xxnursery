package com.nursery.api.iservice;

import com.nursery.beans.RecruitAndConsumerDO;

import java.sql.SQLException;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/15 | Time:14:11
 * com.nursery.dao.RecruitAndConsumerMapper
 * 应聘者和招聘信息的业务
 */
public interface IRecruitAndConsumerSV {
    /**
     * 根据招聘信息id
     * @param id
     * @return
     */
    List<RecruitAndConsumerDO> getDOsByRecruitId(String id) throws SQLException;
}
