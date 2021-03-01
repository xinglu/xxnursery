package com.nursery.service.impl;

import com.alibaba.fastjson.JSON;
import com.nursery.api.iservice.IHotTopicSV;
import com.nursery.beans.HotTopicDO;
import com.nursery.dao.HotTopicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/1 | Time:9:37
 */
@Service
public class HotTopicImpl implements IHotTopicSV {
    private Logger logger = LoggerFactory.getLogger(IHotTopicSV.class);

    @Autowired
    @SuppressWarnings("all")
    private HotTopicMapper hotTopicMapper;

    @Override
    public List<HotTopicDO> getTopicRandom() throws SQLException {
        List<HotTopicDO> topicDOList = hotTopicMapper.selectTopicRandom();
        logger.info(JSON.toJSONString(topicDOList));
        return topicDOList;
    }



    @Override
    public HotTopicDO getTopic(String tableid) throws SQLException {
        return hotTopicMapper.selectTopic(tableid);
    }
}
