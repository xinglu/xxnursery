package com.nursery.api.iservice;

import com.nursery.beans.RecruitmentTypesDO;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/2/24 | Time:9:29
 * com.nursery.dao.RecruitmentTypesMapper
 */
public interface IRecruitmentTypesSV {

    //
    List<RecruitmentTypesDO> getTypesLimit();

}
