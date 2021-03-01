package com.nursery.api.iservice;

import com.nursery.beans.HotTopicDO;

import java.sql.SQLException;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/1 | Time:9:36
 * 话题
 */
public interface IHotTopicSV {

    List<HotTopicDO> getTopicRandom() throws SQLException;

    /**
     * 获取详情
     * @return
     * @param tableid
     */
    HotTopicDO getTopic(String tableid) throws SQLException;
}
