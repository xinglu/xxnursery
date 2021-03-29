package com.nursery.api.iservice;

import com.nursery.beans.HotTopicDO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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


    /**
     * 存储话题相关评论
     * @param map
     */
    void insertTopicComment(Map<String, String> map) throws SQLException;
}
