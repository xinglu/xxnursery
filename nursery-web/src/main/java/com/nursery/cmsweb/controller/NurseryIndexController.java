package com.nursery.cmsweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.nursery.api.iservice.*;
import com.nursery.api.iweb.NurseryIndexApi;
import com.nursery.beans.*;
import com.nursery.common.model.CommonString;
import com.nursery.common.web.BaseController;
import com.nursery.dao.NurseryAnnouncefMapper;
import com.nursery.dao.SlideshowMapper;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.*;

/**
 * author:MeiShiQiang
 * Date:2021/1/5
 * Time:11:16
 */
@Controller
public class NurseryIndexController extends BaseController implements NurseryIndexApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(NurseryIndexController.class);

    @Autowired
    private INurseryRecruitInfoSV nurseryRecruitInfoSV;
    @Autowired
    private ISlideshowSV slideshowSV;//搜索框
    @Autowired
    private INurseryAnnounceSV nurseryAnnounceSV;
    @Autowired
    private ISearchInfoSV searchInfoSV;
    @Autowired
    private IRecruitmentTypesSV recruitmentTypesSV;

    @Autowired
    @SuppressWarnings("all")
    private NurseryAnnouncefMapper mapper;
    @Autowired
    @SuppressWarnings("all")
    private SlideshowMapper slideshowMapper;

    private String hotjob = "RANKED_FIRST_HOT_JOB";

    @GetMapping("/index")
    @ResponseBody
    public ModelAndView index(ModelAndView modelAndView) {
        try {
            //1. 获取热门信息
            String[] sordStr = searchInfoSV.getSordStr();
            LOGGER.info("获取热门信息:" + JSONObject.toJSONString(sordStr));
            //2. 获取职位推荐
            List<RecruitmentDO> recruitmentDOList = nurseryRecruitInfoSV.getRandomRecruit();
            //3. 获取热招职位（只获取排行第一的）
            //3.1 获取职位类型信息
            List<RecruitmentTypesDO> recruitmentTypesDOList = recruitmentTypesSV.getTypesLimit();
            //3.2 根据type查询
            String type = recruitmentTypesDOList.get(0).getType_name();
            List<RecruitmentDO> recruitmentDOList1 = nurseryRecruitInfoSV.getRecruitByType(type);
            LOGGER.info("热门数据（"+type+"）:" + JSONObject.toJSONString(recruitmentDOList1));
            modelAndView.addObject("recommendData",recruitmentDOList);
            modelAndView.addObject("hotData",recruitmentDOList1);
            modelAndView.addObject("sordStr", sordStr);
            modelAndView.addObject("classStr",recruitmentTypesDOList);
        } catch (Exception e) {
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/index/newJob")
    @ResponseBody
    public ModelAndView getNewJob(ModelAndView model){
        //. 获取最新职位
        List<RecruitmentDO> recruitmentDOList = null;
        try {
            recruitmentDOList = nurseryRecruitInfoSV.getRecruitByNewDate();
            model.addObject("newData",recruitmentDOList);
            model.setViewName("index::new_job");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }


    @GetMapping("/index/hotJob/{typeId}/{typename}")
    @ResponseBody
    public List<RecruitmentDO> getHotJob(@PathVariable("typeId") String typeId,@PathVariable("typename") String typename){
        //. 获取最新职位
        List<RecruitmentDO> recruitmentDOList = null;
        try {
            recruitmentDOList = nurseryRecruitInfoSV.getRecruitByTypeId(typename);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recruitmentDOList;
    }

    /**
     * 查询轮播图
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
