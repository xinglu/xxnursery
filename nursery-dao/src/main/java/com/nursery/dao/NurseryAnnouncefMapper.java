package com.nursery.dao;

import com.nursery.beans.DBDataParam;
import com.nursery.beans.NurseryAnnounceDO;

import java.sql.SQLException;
import java.util.List;

/**
 *  例如   : tb_announce_202101
 */
public interface NurseryAnnouncefMapper {

    //根据表名和参数
    List<NurseryAnnounceDO> announceeList(DBDataParam dataParam);

    //保存
    void insert(NurseryAnnounceDO nurseryAnnounceDO) throws Exception;

    //更新
    int update(DBDataParam dataParam)throws SQLException;

    //删除
    int delete(DBDataParam dataParam)throws SQLException;
}
