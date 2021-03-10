package com.nursery.nurserymanage2.controller.async;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.nursery.beans.LogDO;
import com.nursery.dao.LoggerManageMapper;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

/**
 * author:MeiShiQiang
 * Date:2021/3/9 | Time:10:34
 * 创建一个异步类---记录管理员的“操作”日志
 */
@Component
public class LogAsyncComponent {
    private Logger logger = LoggerFactory.getLogger(LogAsyncComponent.class);
    private String NOWDATE_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    @Autowired
    @SuppressWarnings("all")
    private LoggerManageMapper loggerManageMapper;

    @Async
    public void logAnnounce(Map<String, String> logMap) {
        LogDO logDO = new LogDO();
        if (!StringUtils.isEmpty(logMap.get("classify"))) logDO.setClassify(logMap.get("classify"));
        if (!StringUtils.isEmpty(logMap.get("type"))) logDO.setType(logMap.get("type"));
        if (!StringUtils.isEmpty(logMap.get("date"))) logDO.setDate(logMap.get("date"));
        if (!StringUtils.isEmpty(logMap.get("id"))) logDO.setId(logMap.get("id"));
        if (!StringUtils.isEmpty(logMap.get("erId"))) logDO.setErId(logMap.get("erId"));
        if (!StringUtils.isEmpty(logMap.get("dothing"))) logDO.setDothing(logMap.get("dothing"));
        Date date = DateUtils.parse(logMap.get("date"), NOWDATE_YYYYMMDDHHMMSS);
        String quarter = DateUtils.getYearQuarter(date);
        logDO.setTableFlag(quarter);
        logDO.setLogId(CommonUtil.getUUID());
        logger.info("写入： " + JSON.toJSONString(logDO));
        try {
            loggerManageMapper.insertLog(logDO);
        }catch (SQLException throwables){
            logger.error(logMap.get("classify")+"：日志插入错误");
        }

    }
}
