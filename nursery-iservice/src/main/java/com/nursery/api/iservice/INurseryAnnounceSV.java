package com.nursery.api.iservice;

import com.nursery.beans.DBDataParam;
import com.nursery.beans.NurseryAnnounceDO;

import java.util.List;

/**
 * 公告业务
 */
public interface INurseryAnnounceSV {


    List<NurseryAnnounceDO> announceeList(DBDataParam dataParam) throws Exception;

}
