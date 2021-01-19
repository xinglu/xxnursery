package com.nursery.service.impl;

import com.nursery.api.iservice.INurseryAnnounceSV;
import com.nursery.beans.DBDataParam;
import com.nursery.beans.NurseryAnnounceDO;
import com.nursery.dao.NurseryAnnouncefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2021/1/5
 * Time:15:20
 */
@Service
public class NurseryAnnounceImpl implements INurseryAnnounceSV {

    @Autowired
    @SuppressWarnings("all")
    NurseryAnnouncefMapper nurseryAnnouncefMapper;

    @Override
    public List<NurseryAnnounceDO> announceeList(DBDataParam dataParam) throws Exception{
        return nurseryAnnouncefMapper.announceeList(dataParam);
    }
}
