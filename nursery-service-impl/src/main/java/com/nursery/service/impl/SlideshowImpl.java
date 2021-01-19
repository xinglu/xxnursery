package com.nursery.service.impl;

import com.nursery.api.iservice.ISlideshowSV;
import com.nursery.beans.SlideshowDO;
import com.nursery.dao.SlideshowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2021/1/5
 * Time:14:00
 */
@Service
public class SlideshowImpl implements ISlideshowSV {

    @Autowired
    @SuppressWarnings("all")
    SlideshowMapper slideshowMapper;

    @Override
    public List<SlideshowDO> slideList(String classify) throws SQLException {
        return slideshowMapper.slideList(classify);
    }
}
