package com.nursery.api.iservice;

import com.nursery.beans.DBDataParam;
import com.nursery.beans.RecruitmentDO;

import java.sql.SQLException;
import java.util.List;

/**
 * 首页信息展示
 *      幼儿园 招聘信息
 */
public interface INurseryRecruitInfoSV {
    /**
     * 查询招聘信息
     * @param dbDataParam  dbDataParam.param1 dbDataParam.param2
     * @return
     * @throws NullPointerException
     * @throws SQLException
     */
    List<RecruitmentDO> recruitList(DBDataParam dbDataParam) throws NullPointerException,SQLException;

    /**
     * 根据 id获取招聘信息
     * @param userId 招聘部门人员id
     * @return
     */
    List<RecruitmentDO> selectRecruitinfoByerid(String userId) throws SQLException;

    //获取招聘信息
    List<RecruitmentDO> selectRecruitinfoByerid() throws SQLException;


    //根究id 查询招聘信息
    RecruitmentDO selectRecruitInfoByrecruitid(String recruitid) throws SQLException;
}
