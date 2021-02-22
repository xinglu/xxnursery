package com.nursery.cmsweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.nursery.api.iservice.INurseryAnnounceSV;
import com.nursery.api.iservice.ISlideshowSV;
import com.nursery.api.iweb.NurseryIndexApi;
import com.nursery.beans.DBDataParam;
import com.nursery.beans.NurseryAnnounceDO;
import com.nursery.beans.SlideshowDO;
import com.nursery.common.model.CommonString;
import com.nursery.common.model.response.CommonCode;
import com.nursery.common.model.response.QueryResponseResult;
import com.nursery.common.model.response.ResponseResult;
import com.nursery.common.web.BaseController;
import com.nursery.dao.NurseryAnnouncefMapper;
import com.nursery.dao.SlideshowMapper;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.*;

/**
 * author:MeiShiQiang
 * Date:2021/1/5
 * Time:11:16
 */
@RestController
public class NurseryIndexController extends BaseController implements NurseryIndexApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(NurseryIndexController.class);

    @Autowired
    NurseryRecruitInfoController recruitInfoController;
    @Autowired
    ISlideshowSV slideshowSV;
    @Autowired
    INurseryAnnounceSV nurseryAnnounceSV;

    @Autowired
    @SuppressWarnings("all")
    NurseryAnnouncefMapper mapper;
    @Autowired
    @SuppressWarnings("all")
    SlideshowMapper slideshowMapper;

    @GetMapping("/recruit_index")
    public ResponseResult index() {
        HashMap<String, Map<String, String>> returnMap = null;
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.FAIL,null);
        try {
            returnMap = new HashMap<>();
            //获取轮播图的类名,根据类名查找
            String classify = CommonString.SLIDESHOW_CLASS_INDEX_NAME;
            if (classify == null) {
                classify = NurseryIndexController.class.getName();
            }
            Map<String, String> slideMap = slideList(classify);
            LOGGER.info("轮播图的所属类型:" + classify + " slideMap:" + JSONObject.toJSONString(slideMap));
            returnMap.put("slideInfo", slideMap);
            //获取公告
            Map<String, String> announceMap = announceeList();
            LOGGER.info("获取公告:" + JSONObject.toJSONString(announceMap));
            returnMap.put("announceInfo", announceMap);
            //获取招聘信息
            queryResponseResult = recruitInfoController.recruitList(null, null);
            LOGGER.info("招聘信息:" + JSONObject.toJSONString(queryResponseResult));
        } catch (SQLException e) {
            return queryResponseResult;
        }
        queryResponseResult.setCommonCode(CommonCode.SUCCESS);
        queryResponseResult.setBeans(returnMap);
        return queryResponseResult;
    }


    /**
     * 查询轮播图
     *
     * @param classify
     * @return
     */
    public Map<String, String> slideList(String classify) throws SQLException {
        Map<String, String> slideMap = new HashMap<>();
        List<SlideshowDO> slideshowDTOS = null;
        slideshowDTOS = slideshowSV.slideList(classify);
        for (SlideshowDO slideshowDTO : slideshowDTOS) {
            // 轮播图名字 ; 路径
            // 轮播图宽 ; 高
            slideMap.put(slideshowDTO.getName() + ";" + slideshowDTO.getPath()
                    , slideshowDTO.getHeight() + ";" + slideshowDTO.getWidth());
        }
        return slideMap;
    }

    /**
     * 查询公告
     *
     * @param
     * @return
     */
    public Map<String, String> announceeList() {
        Map<String, String> announceMap = new LinkedHashMap<>();
        //传入参数
        DBDataParam dbDataParam = new DBDataParam();
        String table_prefix = CommonString.TB_ANNOUNCE;
        String table_flag = table_prefix.concat(DateUtils.getNowDate());
        dbDataParam.setTable_flag(table_flag);
        List<NurseryAnnounceDO> nurseryAnnounceDOList = null;
        try {
            nurseryAnnounceDOList = nurseryAnnounceSV.announceeList(dbDataParam);
            for (NurseryAnnounceDO nurseryAnnounceDO : nurseryAnnounceDOList) {
                Integer id = nurseryAnnounceDO.getId();
                String author = nurseryAnnounceDO.getAuthor();
                String etcompiler = nurseryAnnounceDO.getEtcompiler();
                String date = nurseryAnnounceDO.getDate();
                String table = nurseryAnnounceDO.getTable();
                String path = nurseryAnnounceDO.getPath();
                String time = nurseryAnnounceDO.getTime();
                String size = nurseryAnnounceDO.getSize();
                // 公告名 ; 时间 * id ; path
                // 作者名 / 编辑 / 时间
                announceMap.put(table + ";" + date + "*" + id + ";" + path, author + "/" + etcompiler + "/" + time);
            }
        } catch (Exception e) {
            System.out.println("公告查询错误");
            e.printStackTrace();
        }
        return announceMap;
    }


    @PutMapping("/insertAnnounce")
    public void insertAnnounce() {
        String nowDate = DateUtils.getNowDate();
        String tableflag = CommonString.TB_ANNOUNCE.concat(nowDate);
        NurseryAnnounceDO nurseryAnnounceDO = null;
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int ran_um = random.nextInt(200) + 50;
            nurseryAnnounceDO = new NurseryAnnounceDO();
            nurseryAnnounceDO.setTable("测试通告标题111111111111111::" + i);
            nurseryAnnounceDO.setAuthor("管理员");
            nurseryAnnounceDO.setEtcompiler("管理员");
            nurseryAnnounceDO.setPath("http://测试通告标题111111111111111.html");
            nurseryAnnounceDO.setSize("230");
            nurseryAnnounceDO.setTime(ran_um + "");
            nurseryAnnounceDO.setDate(DateUtils.getNowDate("yyyy-MM-dd HH:mm"));
            nurseryAnnounceDO.setTableflag(tableflag);
            System.out.println(nurseryAnnounceDO);
            try {
                mapper.insert(nurseryAnnounceDO);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }
    }


    @PutMapping("/insertlunbotu")
    public void insertlunbotu() {
        SlideshowDO slideshowDO = null;
        for (int i = 0; i < 10; i++) {
            slideshowDO = new SlideshowDO();
            slideshowDO.setId(CommonUtil.getUUID());
            slideshowDO.setClassify(NurseryIndexController.class.getName());
            slideshowDO.setName("轮播图" + i);
            slideshowDO.setWidth("400");
            slideshowDO.setHeight("400");
            slideshowDO.setPath("https://轮播图" + i + ".png");
            System.out.println(slideshowDO);
            try {
                slideshowMapper.insert(slideshowDO);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

}
