package com.nursery.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.nursery.api.iservice.ILoggerManageSV;
import com.nursery.beans.LogDO;
import com.nursery.dao.LoggerManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:MeiShiQiang
 * Date:2021/3/18 | Time:11:12
 */
@Service
public class LoggerManageImpl implements ILoggerManageSV {

    @Autowired
    @SuppressWarnings("all")
    private LoggerManageMapper loggerManageMapper;

    @Override
    public List<LogDO> selectConsumerLogs(LogDO logDO) {
        String startDate = logDO.getStartDate();
        String endDate = logDO.getEndDate();
        String name = logDO.getConsumerName();
        if (!StringUtils.isEmpty(name)){
            logDO.setConsumerName("%"+logDO.getConsumerName()+"%");
        }else {
            logDO.setConsumerName("");
        }
        if (StringUtils.isEmpty(startDate)){
            //2021-03-09 16:36:37'
            logDO.setStartDate("0000-00-00 00:00:00");
        }
        if (StringUtils.isEmpty(endDate)){
            //2021-03-09 16:36:37'
            logDO.setEndDate("2099-00-00 00:00:00");
        }
        return loggerManageMapper.selectConsumerLogs(logDO);
    }

    @Override
    public List<LogDO> selectAdminLogs(LogDO logDO) {
        String startDate = logDO.getStartDate();
        String endDate = logDO.getEndDate();
        String name = logDO.getConsumerName();
        String dothing = logDO.getDothing();
        String type = logDO.getType();
        if (!StringUtils.isEmpty(name)){
            logDO.setConsumerName("%"+logDO.getConsumerName()+"%");
        }else {
            logDO.setConsumerName("");
        }
        if (StringUtils.isEmpty(startDate)){
            //2021-03-09 16:36:37'
            logDO.setStartDate("0000-00-00 00:00:00");
        }
        if (StringUtils.isEmpty(endDate)){
            //2021-03-09 16:36:37'
            logDO.setEndDate("2099-00-00 00:00:00");
        }
        return loggerManageMapper.selectAdminLogs(logDO);
    }
}
