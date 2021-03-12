package com.nursery.service.impl;

import com.nursery.api.iservice.INurseryAnnounceSV;
import com.nursery.beans.DBDataParam;
import com.nursery.beans.NurseryAnnounceDO;
import com.nursery.beans.NurseryAnnounceDetailDO;
import com.nursery.common.model.CommonAttrs;
import com.nursery.dao.AnnounceDetailMapper;
import com.nursery.dao.NurseryAnnouncefMapper;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * author:MeiShiQiang
 */
@Service
public class NurseryAnnounceImpl implements INurseryAnnounceSV {
    private Logger logger = LoggerFactory.getLogger(NurseryAnnounceImpl.class);
    @Autowired
    @SuppressWarnings("all")
    private NurseryAnnouncefMapper nurseryAnnounceMapper;

    @Autowired
    @SuppressWarnings("all")
    private AnnounceDetailMapper announceDetailMapper;

    @Override
    public List<NurseryAnnounceDO> getAnnounceeList(DBDataParam dataParam) throws Exception {
        return nurseryAnnounceMapper.announceeList(dataParam);
    }

    @Override
    public List<NurseryAnnounceDO> getNewAndHotAndRecommendAnnounceDO() {
        // 有序列表
        List<NurseryAnnounceDO> nurseryAnnounceDOS = new ArrayList<>();
        try {
            NurseryAnnounceDO byNewDate = nurseryAnnounceMapper.selectAnnounceByNewDate();
            if (!ObjectUtils.isEmpty(byNewDate)) nurseryAnnounceDOS.add(byNewDate);
            NurseryAnnounceDO bytime = nurseryAnnounceMapper.selectAnnounceBytime();
            if (!ObjectUtils.isEmpty(bytime)) nurseryAnnounceDOS.add(bytime);
            List<NurseryAnnounceDO> announceDOList = nurseryAnnounceMapper.selectRecommendAnnounce(1);
            NurseryAnnounceDO recommendAnnounce = null;
            if (announceDOList.size() != 0) recommendAnnounce = announceDOList.get(0);
            if (!ObjectUtils.isEmpty(recommendAnnounce)) nurseryAnnounceDOS.add(recommendAnnounce);
            if (nurseryAnnounceDOS.size() < 3) {
                int size = nurseryAnnounceDOS.size();
                int num = 3 - size;
                for (int i = 0; i < num; i++) {
                    nurseryAnnounceDOS.add(recommendAnnounce);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nurseryAnnounceDOS;
    }


    @Override
    public List<NurseryAnnounceDO> getRandomAnnounceeList() {
        try {
            return nurseryAnnounceMapper.selectRecommendAnnounce(6);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NurseryAnnounceDO> getNewAnnounceDO() throws SQLException {
        return nurseryAnnounceMapper.selectAnnounceByNewDates();
    }

    @Override
    public List<NurseryAnnounceDO> getHotAnnounceDO() throws SQLException {
        return nurseryAnnounceMapper.selectAnnounceBytimes();
    }

    @Override
    public List<NurseryAnnounceDO> getRecommendAnnounceDO() throws SQLException {
        return nurseryAnnounceMapper.selectRecommendAnnounce(6);
    }

    @Override
    public NurseryAnnounceDO getannounceDetailById(String id) {
        return announceDetailMapper.selectAnnounceDetailById(id);
    }

    @Override
    public List<NurseryAnnounceDO> selectAnnunces() throws SQLException {
        return nurseryAnnounceMapper.selectAnnounces();
    }

    @Override
    public NurseryAnnounceDO getAnnounceById(String announceId) throws SQLException {
        //7d3531afb47e4adc8575f6570c533b13
        return nurseryAnnounceMapper.selectAnnounceById(announceId);
    }

    @Override
    public void deleteAnnounceById(String id) throws SQLException {
        int x = announceDetailMapper.deleteAnnounceDetailById(id);
        int y = nurseryAnnounceMapper.deleteAnnounceById(id);

    }

    @Transactional
    @Override
    public void insertAnnounce(NurseryAnnounceDO nurseryAnnounceDO) {
        NurseryAnnounceDetailDO announceDetailDO = null;
        String title = nurseryAnnounceDO.getTable();
        String bigcontent = nurseryAnnounceDO.getBigContent();
        String id = CommonUtil.getUUID();
        String author = nurseryAnnounceDO.getAuthor();
        String startDate = DateUtils.getNowDate("yyyy-MM-dd");
        try {
            nurseryAnnounceDO.setId(id);
            nurseryAnnounceDO.setDate(DateUtils.getNowDate("yyyy-MM-dd HH:mm"));
            nurseryAnnounceDO.setDate_YYYYMMDD(startDate);
            nurseryAnnounceDO.setEtcompiler(nurseryAnnounceDO.getAuthor() + ",");
            nurseryAnnounceDO.setTime("0");
            nurseryAnnounceDO.setSize(nurseryAnnounceDO.getBigContent().length() + "");
            //  /information/djxq/8.html
            nurseryAnnounceDO.setPath("/information/djxq/" + id + ".html");
            nurseryAnnounceDO.setTitle(nurseryAnnounceDO.getTable());
            nurseryAnnounceDO.setTableflag(CommonAttrs.TB_ANNOUNCE + "202101");
            nurseryAnnounceMapper.insert(nurseryAnnounceDO);
            announceDetailDO = new NurseryAnnounceDetailDO();
            announceDetailDO.setTitle(title);
            announceDetailDO.setBigContent(bigcontent);
            announceDetailDO.setId(id);
            announceDetailDO.setAuthor(author);
            announceDetailDO.setStartDate(startDate);
            announceDetailMapper.insert(announceDetailDO);
        } catch (SQLException e) {
            logger.error("插入错误1");
        } catch (Exception e) {
            logger.error("插入错误:" + e.getMessage());
        }

    }

    @Transactional
    @Override
    public void updateAnnounce(NurseryAnnounceDO nurseryAnnounceDO) throws SQLException {
        String etcompiler = nurseryAnnounceMapper.selectAnnouncEtcompilerById(nurseryAnnounceDO.getId());
        etcompiler = etcompiler+nurseryAnnounceDO.getEtcompiler()+",";
        nurseryAnnounceDO.setEtcompiler(etcompiler);
        nurseryAnnounceDO.setSize(nurseryAnnounceDO.getBigContent().length()+"");
        nurseryAnnounceMapper.update(nurseryAnnounceDO);
//        nurseryAnnounceMapper
        NurseryAnnounceDetailDO detailDO = new NurseryAnnounceDetailDO();
        detailDO.setId(nurseryAnnounceDO.getId());
        detailDO.setTitle(nurseryAnnounceDO.getTable());
        detailDO.setBigContent(nurseryAnnounceDO.getBigContent());
        announceDetailMapper.update(detailDO);

    }
}
