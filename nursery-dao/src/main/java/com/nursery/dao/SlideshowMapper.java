package com.nursery.dao;


import com.nursery.beans.SlideshowDO;

import java.util.List;

//轮播图表
public interface SlideshowMapper {


    List<SlideshowDO> slideList(String classify);

    void insert(SlideshowDO slideshowDO);

}
