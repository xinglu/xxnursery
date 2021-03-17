package com.nursery.api.iservice;

import com.nursery.beans.RecruiterManagmentDO;
import com.nursery.beans.RoleDO;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/17 | Time:14:38
 * 招聘管理人员
 */
public interface IRecruitERSV {

    RecruiterManagmentDO findByUsername(String username);

    List<RoleDO> findRolesByUsername(String recruitId);
}
