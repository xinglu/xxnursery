package com.nursery.api.iservice;

import com.nursery.beans.RecruiterManagmentDO;

import java.sql.SQLException;

/**
 * author:MeiShiQiang
 * Date:2021/3/15 | Time:11:21
 * 招聘人员管理
 */
public interface INurseryRecruiterManagmentSV {
    /**
     * 根据id返回姓名
     * @param recruiterManagmentDO recruiterManagmentDO.id
     * @return recruiterManagmentDO.name
     */
    String getRealName(RecruiterManagmentDO recruiterManagmentDO) throws SQLException;

}
