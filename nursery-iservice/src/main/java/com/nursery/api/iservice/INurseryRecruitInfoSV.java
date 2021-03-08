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
     * @throws SQLException
     */
    List<RecruitmentDO> selectRecruitinfoByerid(String userId) throws SQLException;

    /**
     * 获取招聘信息
     * @return
     * @throws SQLException
     */
    List<RecruitmentDO> selectRecruitinfoByerid() throws SQLException;

    //查询所有招聘信息
    List<RecruitmentDO> selectRecruitmentDOs() throws SQLException;

    /**
     * 根究id 查询招聘信息
     * @param recruitid
     * @return
     * @throws SQLException
     */
    RecruitmentDO selectRecruitInfoByrecruitid(String recruitid) throws SQLException;

    /**
     * 更新招聘信息
     * @param recruitmentDO
     * @return 返回受影响的行数
     * @throws SQLException
     */
    int updateRecruitInfo(RecruitmentDO recruitmentDO) throws SQLException;

    //随机获取招聘信息
    List<RecruitmentDO> getRandomRecruit() throws SQLException;

    //根据名称
    List<RecruitmentDO> selectRecruitinfoByName(String tableName);

    //根据类型
    List<RecruitmentDO> getRecruitByType(String type) throws SQLException;

    //获取最新时间的职位
    List<RecruitmentDO> getRecruitByNewDate() throws SQLException;

    //根据类型名称获取
    List<RecruitmentDO> getRecruitByTypeId(String typeId) throws SQLException;

    //插入一行招聘信息
    void insertRecruitInfo(RecruitmentDO recruitmentDO);
}
