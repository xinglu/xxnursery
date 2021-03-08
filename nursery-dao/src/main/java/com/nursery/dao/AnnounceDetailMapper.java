package com.nursery.dao;

import com.nursery.beans.NurseryAnnounceDO;

/**
 * author:MeiShiQiang
 * Date:2021/3/3 | Time:14:57
 * tb_announce_details
 */
public interface AnnounceDetailMapper {

    NurseryAnnounceDO selectAnnounceDetailById(String id);

}
