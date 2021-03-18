package com.nursery.api.iservice;

import com.nursery.beans.LogDO;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/18 | Time:11:11
 */
public interface ILoggerManageSV {

    /**
     * 根据条件查询
     * @param logDO
     * @return
     */
    List<LogDO> selectConsumerLogs(LogDO logDO);

    /**
     *
     * @param logDO
     * @return
     */
    List<LogDO> selectAdminLogs(LogDO logDO);
}
