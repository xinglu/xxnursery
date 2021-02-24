package com.nursery.dao;

import com.nursery.beans.RecruitmentTypesDO;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/2/24 | Time:9:23
 * com.nursery.beans.RecruitmentTypesDO
 */
public interface RecruitmentTypesMapper {

    //查询所有类型 分页 排序
    public List<RecruitmentTypesDO> selectTypesDescLimit();

}
