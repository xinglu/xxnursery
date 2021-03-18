package com.nursery.dao;

import com.nursery.beans.LogDO;

import java.sql.SQLException;
import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/9 | Time:11:26
 * 日志， 面向com.nursery.beans.LogDO
 */
public interface LoggerManageMapper {

    void insertLog(LogDO logDO) throws SQLException;

    List<LogDO> selectLogs(LogDO logDO);

    List<LogDO> selectAdminLogs(LogDO logDO);
}
