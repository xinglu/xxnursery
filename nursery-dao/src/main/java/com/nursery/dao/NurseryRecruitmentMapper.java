package com.nursery.dao;

import com.nursery.beans.DBDataParam;
import com.nursery.beans.RecruitmentDO;

import java.sql.SQLException;
import java.util.List;

/**
 * 幼儿园
 * 招聘信息
 */
public interface NurseryRecruitmentMapper {

    //保存
    public void insert(RecruitmentDO recruitmentDO) throws SQLException;

    //删除
    public void delete(String id) throws SQLException;

    //根据类查询
    public void selectByclassify(String classify) throws SQLException;

    //根据名称模糊查询
    public void selectByrecruittablename(String tablename) throws SQLException;

    //根据 类型和名称(模糊查询)
    List<RecruitmentDO> selectByclassAndName(DBDataParam dbDataParam) throws SQLException;

    //查询所有招聘信息
    List<RecruitmentDO> selectRecruitmentDOs() throws SQLException;

    //根据id查询
    RecruitmentDO selectRecruitInfoByrecruitid(String recruitid) throws SQLException;

    //根据招聘管理者id查询 招聘信息
    List<RecruitmentDO> selectRecruitmentDOsByRecruiterID(String recruiterID) throws SQLException;

    //更新
    int updateRecruitInfo(RecruitmentDO recruitmentDO) throws SQLException;

    //随机查询
    List<RecruitmentDO> randomSelectRecruit() throws SQLException;

    //根据类型模糊查询
    List<RecruitmentDO> selectRecruitinfoByType(String type) throws SQLException;

    //更加最新时间排序获取职位
    List<RecruitmentDO> selectRecruitByNewDateAndDesc() throws SQLException;

    //插入一条数据
    void insertRecruitInfo(RecruitmentDO recruitmentDO) throws SQLException;

    //插入一条中间表数据 tb_middle_recruiter_info
    void insertRecruitMeddleEr(RecruitmentDO recruitmentDO) throws SQLException;

    /**
     * 根据id删除招聘信息
     * @param erId 招聘id
     * @return 影响行数
     */
    int deleteRecruitById(String erId);

    /**
     * 搜索框
     * @param dataParam    参数
     */
    List<RecruitmentDO> selectRecruitInfoByParams(DBDataParam dataParam) throws SQLException;

    /**
     * 更具审核结果查询
     * @param is 是否审核通过 'yes' , 'no'
     */
    List<RecruitmentDO> selectRecruitByIsActivate(String is) throws SQLException;

    /**
     *
     * @param id 招聘id
     * @param audit 审核结果
     * @return 影响行数
     */
    int updateRecruitSetAudit(RecruitmentDO recruitmentDO) throws SQLException;
}
