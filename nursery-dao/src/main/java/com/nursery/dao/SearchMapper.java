package com.nursery.dao;

import com.nursery.beans.SearchDO;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/2/23 | Time:16:48
 * com/nursery/beans/SearchDO.java
 */
public interface SearchMapper {

    //根据count次数排序 desc
    public List<SearchDO> selectSearchASCCount();

}
