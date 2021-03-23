package com.nursery.dao;

import com.nursery.beans.NurseryAnnounceDetailDO;

import java.sql.SQLException;

/**
 * author:MeiShiQiang
 * Date:2021/3/3 | Time:14:57
 * tb_announce_details
 */
public interface AnnounceDetailMapper {

    NurseryAnnounceDetailDO selectAnnounceDetailById(String id) throws SQLException;

    Integer deleteAnnounceDetailById(String id) throws SQLException;

    void insert(NurseryAnnounceDetailDO announceDetailDO) throws SQLException;

    void update(NurseryAnnounceDetailDO detailDO) throws SQLException;
}
