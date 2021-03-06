package com.nursery.dao;

import com.nursery.beans.DBDataParam;
import com.nursery.beans.RecruitmentDO;

import java.sql.SQLException;
import java.util.List;

/**
 * 幼儿园
 *  招聘信息
 */
public interface NurseryRecruitmentMapper {

    //保存
    public void insert(RecruitmentDO recruitmentDO)throws SQLException;
    //更新
    public void update(RecruitmentDO recruitmentDO)throws SQLException;
    //删除
    public void delete(String id)throws SQLException;
    //根据类查询
    public void selectByclassify(String classify)throws SQLException;
    //根据名称模糊查询
    public void selectByrecruittablename(String tablename)throws SQLException;
    //根据id查询
    public void selectByid(String id)throws SQLException;
    //根据 类型和名称(模糊查询)
    List<RecruitmentDO> selectByclassAndName(DBDataParam dbDataParam)throws SQLException;

}
