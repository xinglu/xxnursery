package com.nursery.service.impl;

import com.nursery.api.iservice.ISearchInfoSV;
import com.nursery.beans.SearchDO;
import com.nursery.dao.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/2/23 | Time:17:09
 */
@Service
public class SearchInfoImpl implements ISearchInfoSV {

    @Autowired
    @SuppressWarnings("all")
    private SearchMapper searchMapper;

    @Override
    public String getSordStr() {
        List<SearchDO> searchDOS = searchMapper.selectSearchASCCount();
        String returnStr = "";
        for (SearchDO searchDO : searchDOS) {
            returnStr = returnStr+searchDO.getInfo()+",";
        }
        returnStr = returnStr.substring(0, returnStr.length() - 1);
        return returnStr;
    }
}
