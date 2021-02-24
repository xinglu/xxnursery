package com.nursery.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nursery.api.iservice.IRecruitmentTypesSV;
import com.nursery.beans.RecruitmentTypesDO;
import com.nursery.dao.RecruitmentTypesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * author:MeiShiQiang
 * Date:2021/2/24 | Time:9:30
 */
@Service
public class RecruitmentTypesImpl implements IRecruitmentTypesSV {
    private Logger logger = LoggerFactory.getLogger(RecruitmentTypesImpl.class);
    @Autowired
    @SuppressWarnings("all")
    RecruitmentTypesMapper mapper;

    @Override
    public List<RecruitmentTypesDO> getTypesLimit() {
        List<RecruitmentTypesDO> recruitmentTypesDOList = mapper.selectTypesDescLimit();
        logger.info("职位类型信息:" + JSONObject.toJSONString(recruitmentTypesDOList));
        return recruitmentTypesDOList;
    }
}
