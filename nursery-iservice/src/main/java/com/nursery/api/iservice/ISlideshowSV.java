package com.nursery.api.iservice;

import com.nursery.beans.SlideshowDO;

import java.sql.SQLException;
import java.util.List;

/**
 * 操作轮播图
 */
public interface ISlideshowSV {

    List<SlideshowDO> slideList(String classify) throws SQLException;
}
