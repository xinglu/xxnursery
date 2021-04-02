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
     * 获取招聘下的 简历信息
     * @param id 根据招聘信息id
     * @return
     */
    List<RecruitAndConsumerDO> getDOsByRecruitId(String id) throws SQLException;
}
