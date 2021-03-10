package com.nursery.dao;

import com.nursery.beans.LogDO;

import java.sql.SQLException;

/**
 * author:MeiShiQiang
 * Date:2021/3/9 | Time:11:26
 * 日志， 面向com.nursery.beans.LogDO
 */
public interface LoggerManageMapper {

    void insertLog(LogDO logDO) throws SQLException;

}
