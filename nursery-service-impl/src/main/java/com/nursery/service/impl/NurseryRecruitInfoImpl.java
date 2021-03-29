package com.nursery.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.nursery.api.iservice.INurseryRecruitInfoSV;
import com.nursery.beans.DBDataParam;
import com.nursery.beans.RecruitmentDO;
import com.nursery.dao.NurseryRecruitmentMapper;
import com.nursery.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * 招聘信息 业务类
 */
@Service
public class NurseryRecruitInfoImpl implements INurseryRecruitInfoSV {

    private static Logger logger = LoggerFactory.getLogger(NurseryRecruitInfoImpl.class);

    @Autowired
    @SuppressWarnings("all")
    NurseryRecruitmentMapper mapper;

    @Override
    public List<RecruitmentDO> recruitList(DBDataParam dbDataParam) throws NullPointerException, SQLException {
        List<RecruitmentDO> list = null;
        if (dbDataParam != null) {
            try {
                list = mapper.selectByclassAndName(dbDataParam);
                if (list == null) {
                    System.out.println("抛出 null 对象错误");
                    throw new NullPointerException();
                }
            } catch (SQLException e) {
                throw new SQLException();
            }
        }
        return list;
    }

    @Override
    public List<RecruitmentDO> selectRecruitinfoByerid(String userId) throws SQLException {
        return mapper.selectRecruitmentDOsByRecruiterID(userId);
    }

    @Override
    public List<RecruitmentDO> selectRecruitinfoByerid() throws SQLException {
        return mapper.selectRecruitmentDOs();
    }

    @Override
    public List<RecruitmentDO> selectRecruitmentDOs() throws SQLException {
        return mapper.selectRecruitmentDOs();
    }

    @Override
    public RecruitmentDO selectRecruitInfoByrecruitid(String recruitid) throws SQLException {
        return mapper.selectRecruitInfoByrecruitid(recruitid);
    }

    @Override
    public int updateRecruitInfo(RecruitmentDO recruitmentDO) {
        int i = 0;
        try {
            i = mapper.updateRecruitInfo(recruitmentDO);
        } catch (SQLException throwables) {
            logger.error("NurseryRecruitInfoImpl ==> updateRecruitInfo ： mapper" +
                    " sql语句有问题");
        }
        return i;
    }

    @Override
    public List<RecruitmentDO> getRandomRecruit() throws SQLException {
        List<RecruitmentDO> recruitmentDOList = mapper.randomSelectRecruit();
        logger.info("职位推荐:" + JSONObject.toJSONString(recruitmentDOList));
        return mapper.randomSelectRecruit();
    }

    @Override
    public List<RecruitmentDO> selectRecruitinfoByName(String tableName) {
        return null;
    }

    @Override
    public List<RecruitmentDO> getRecruitByType(String type) throws SQLException {
        type = "%" + type + "%";
        return mapper.selectRecruitinfoByType(type);
    }

    @Override
    public List<RecruitmentDO> getRecruitByNewDate() throws SQLException {
        List<RecruitmentDO> newDate = mapper.selectRecruitByNewDateAndDesc();
        logger.info("最新职位:" + JSONObject.toJSONString(newDate));
        return newDate;
    }

    @Override
    public List<RecruitmentDO> getRecruitByTypeId(String typeId) throws SQLException {
        if (!StringUtils.isEmpty(typeId)) {
            typeId = "%" + typeId + "%";
        }
        List<RecruitmentDO> hotDate = mapper.selectRecruitinfoByType(typeId);
        logger.info("热门职位:" + JSONObject.toJSONString(hotDate));
        return hotDate;
    }

    @Transactional
    @Override
    public void insertRecruitInfo(RecruitmentDO recruitmentDO) throws SQLException {
        mapper.insertRecruitInfo(recruitmentDO);
        mapper.insertRecruitMeddleEr(recruitmentDO);
    }

    @Override
    public int deleteRecruitById(String erId) {
        int num = mapper.deleteRecruitById(erId);
        return 0;
    }

    @Override
    public List<RecruitmentDO> selectRecruitInfoByParams(String signParam) throws SQLException {
        String search = "";
        String type = "";
        String placeId = "";
        if (signParam.contains("search:")) {
            String substring = signParam.substring(7);
            String[] split = substring.split("type:");
            search = split[0];
            String param = split[1];
            String[] split1 = param.split("placeId:");
            type = split1[0];
            try {
                placeId = split1[1];
            }catch (ArrayIndexOutOfBoundsException exception){
                placeId = "";
            }
        }
        DBDataParam dataParam = new DBDataParam();
        if (!StringUtils.isEmpty(search)) {
            search = "%" + search + "%";
            dataParam.setSearch(search);
        }
        if (!StringUtils.isEmpty(type) && !"0".equals(type)) {
            dataParam.setType(type);
        }
        if (!StringUtils.isEmpty(placeId)) {
            String place = CommonUtil.getPlace(placeId);
            if (place.equals("") || place.equals("不限")){
                place = "";
            }else {
                place = "%" + place + "%";
            }
            dataParam.setPlaceId(place);
        }
        return mapper.selectRecruitInfoByParams(dataParam);
    }
}
