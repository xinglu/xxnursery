package com.nursery.service.impl;

import com.nursery.api.iservice.INurseryAnnounceSV;
import com.nursery.beans.DBDataParam;
import com.nursery.beans.NurseryAnnounceDO;
import com.nursery.dao.AnnounceDetailMapper;
import com.nursery.dao.NurseryAnnouncefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * author:MeiShiQiang
 */
@Service
public class NurseryAnnounceImpl implements INurseryAnnounceSV {

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
        return  nurseryAnnounceMapper.selectAnnounceByNewDates();
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
    public NurseryAnnounceDO getAnnounceById(String announceId) throws SQLException{
        return nurseryAnnounceMapper.selectAnnounceById(announceId);
    }
}
