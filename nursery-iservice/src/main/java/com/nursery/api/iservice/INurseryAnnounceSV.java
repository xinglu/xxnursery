package com.nursery.api.iservice;

import com.nursery.beans.DBDataParam;
import com.nursery.beans.NurseryAnnounceDO;

import java.sql.SQLException;
import java.util.List;

/**
 * 公告业务
 */
public interface INurseryAnnounceSV {


    /**
     * 获取公告
     * @param dataParam
     * @return
     * @throws Exception
     */
    List<NurseryAnnounceDO> getAnnounceeList(DBDataParam dataParam) throws Exception;

    /**
     * 获取最新/最热/推荐公告
     * @return
     */
    List<NurseryAnnounceDO> getNewAndHotAndRecommendAnnounceDO();

    /**
     * 返回一个随机列表
     * @return
     */
    List<NurseryAnnounceDO> getRandomAnnounceeList();

    //获取最热的
    List<NurseryAnnounceDO> getNewAnnounceDO() throws SQLException;

    //获取最新的
    List<NurseryAnnounceDO> getHotAnnounceDO() throws SQLException;

    //随机
    List<NurseryAnnounceDO> getRecommendAnnounceDO() throws SQLException;

    //根据id获取announce的详细页面
    NurseryAnnounceDO getannounceDetailById(String id);
}
