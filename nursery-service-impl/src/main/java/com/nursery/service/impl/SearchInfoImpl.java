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
    public String[] getSordStr() {
        List<SearchDO> searchDOS = searchMapper.selectSearchASCCount();
        String[] returnStr = new String[searchDOS.size()];
        for (int i = 0; i < searchDOS.size(); i++) {
            returnStr[i] = searchDOS.get(i).getInfo();
        }
        return returnStr;
    }
}
