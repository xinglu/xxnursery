package com.nursery.nurserymanage2.controller;

import com.alibaba.fastjson.JSONObject;
import com.nursery.api.iservice.INurseryAnnounceSV;
import com.nursery.api.iwebm.ManageAnnunceApi;
import com.nursery.beans.NurseryAnnounceDO;
import com.nursery.beans.code.AnnounceCode;
import com.nursery.common.model.CommonAttrs;
import com.nursery.common.model.response.ResponseResult;
import com.nursery.common.web.BaseController;
import com.nursery.nurserymanage2.controller.async.LogAsyncComponent;
import com.nursery.utils.CommonUtil;
import com.nursery.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * author:MeiShiQiang
 * Date:2021/3/9 | Time:10:16
 * 通告中心
 */
@Controller
public class ManageAnnunceController extends BaseController implements ManageAnnunceApi {
    private Logger logger = LoggerFactory.getLogger(ManageAnnunceController.class);
    private String NOWDATE_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private INurseryAnnounceSV annunceManageSV;

    @Autowired
    private LogAsyncComponent logAsync;

    /**
     * 通告管理-删除通告
     * @param erid 管理人员id
     * @param id   通告id
     * @return ResponseResult
     */
    @RequestMapping(value = {"/manage/announce/delete/{erId}/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    @Override
    public ResponseResult deleteAnnounce(@PathVariable(value = "erId") String erid, @PathVariable(value = "id") String id) {
        ResponseResult result = new ResponseResult();
        result.setCommonCode(AnnounceCode.ANNOUNCE_DELETE_SUCCESS);
        Map<String, String> logMap = new HashMap<>();
        logMap.put("classify", ManageAnnunceController.class.getName() + ".deleteAnnounce");//操作类型- 作用：日志查询
        logMap.put("type", "announce");//操作类型- 作用：日志查询
        logMap.put("erId", erid);
        logMap.put("dothing", "1");
        logMap.put("id", id);
        logMap.put("date", DateUtils.getNowDate(NOWDATE_YYYYMMDDHHMMSS));
        try {
            annunceManageSV.deleteAnnounceById(id);
            logMap.put("resultCode", "0");
        } catch (SQLException throwables) {
            logger.error("错误信息 ： " + throwables.getMessage());
            result.setCommonCode(AnnounceCode.ANNOUNCE_SERVER_FAIL);
            logMap.put("resultCode", "1");
        }
        //储存log操作信息
        logAsync.logAnnounce(logMap);
        return result;
    }


    @RequestMapping(value = "/manage/announce/editorMdPic/")
    @ResponseBody
    @Override
    public JSONObject editormdPic(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file) {
        JSONObject responseResult = new JSONObject();
        String fileName = "";
        String path = "";
        try {
            String trueFileName = file.getOriginalFilename();//获取图片名
            String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));//获取后缀
            if(!CommonAttrs.IMG_TYPE.contains(suffix)){
                responseResult.put("success", 0);//图片格式不正确
                responseResult.put("message", "图片格式：{jpg, jpeg, gif, png, bmp, webp}");
                return responseResult;
            }
            long size = file.getSize();
            if (size>CommonAttrs.IMG_MAX_SIZE){
                responseResult.put("success", 0);//图片过大
                responseResult.put("message", "最大长度为!2MB");
                return responseResult;
            }
            fileName = CommonUtil.getUUID()+CommonUtil.getRandomNum(100,200)+ suffix;
//            /D:/IdeaProjects/git/xxnursery/xxnurserystatic/img/upload
            path = ResourceUtils.getURL("xxnursery/").getPath()+"img/upload";
            String realPath = path.replace('/', '\\').substring(1,path.length());
            File targetFile = new File(realPath, fileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            try {
                file.transferTo(targetFile);//保存
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            responseResult.put("success", 0);
            responseResult.put("message", "upload fail !");
            return responseResult;
        }
        responseResult.put("url", request.getContextPath() + "/upload/img/" + fileName);
        responseResult.put("success", 1);
        responseResult.put("message", "upload success!");
        return responseResult;
    }

    @RequestMapping(value = "/manage/announce/editorMdPic_C/",method = RequestMethod.POST)
    @ResponseBody
    @Override
    public JSONObject uploadPicC(@RequestParam(value = "coverPic", required = true) MultipartFile file) {
        JSONObject responseResult = new JSONObject();
        String fileName = "";
        String path = "";
        try {
            String trueFileName = file.getOriginalFilename();//获取图片名
            String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));//获取后缀
            if(!CommonAttrs.IMG_TYPE.contains(suffix.toLowerCase())){
                responseResult.put("success", 0);//图片格式不正确
                responseResult.put("message", "图片格式：{jpg, jpeg, gif, png, bmp, webp}");
                return responseResult;
            }
            long size = file.getSize();
            if (size>CommonAttrs.IMG_MAX_SIZE){
                responseResult.put("success", 0);//图片过大
                responseResult.put("message", "最大长度为!2MB");
                return responseResult;
            }
            fileName = CommonUtil.getUUID()+CommonUtil.getRandomNum(100,200)+ suffix;
//            /D:/IdeaProjects/git/xxnursery/xxnurserystatic/img/upload
            path = ResourceUtils.getURL("xxnursery/").getPath()+"img/upload/cover";
            String realPath = path.replace('/', '\\').substring(1,path.length());
            File targetFile = new File(realPath, fileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            try {
                file.transferTo(targetFile);//保存
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            responseResult.put("success", 0);
            responseResult.put("message", "upload fail !");
            return responseResult;
        }
        responseResult.put("url", request.getContextPath() + "/upload/cover/img/" + fileName);
        responseResult.put("success", 1);
        responseResult.put("message", "upload success!");
        return responseResult;
    }

    @RequestMapping(value = {"/manage/announce/pull/"},method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseResult pullAnnounce(NurseryAnnounceDO nurseryAnnounceDO) {
        ResponseResult responseResult = ResponseResult.SUCCESS();
        if (!ObjectUtils.isEmpty(nurseryAnnounceDO)){
            try {
                annunceManageSV.insertAnnounce(nurseryAnnounceDO);
            }catch (SQLException exception) {
                responseResult.setCommonCode(AnnounceCode.ANNOUNCE_SQL_FAIL);
            }
        }else {
            responseResult.setCommonCode(AnnounceCode.ANNOUNCE_PARAM_NONE);
        }
        return responseResult;
    }

    @RequestMapping(value = {"/manage/announce/put"},method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseResult updateAnnounce(NurseryAnnounceDO nurseryAnnounceDO) {
        ResponseResult responseResult = ResponseResult.SUCCESS();
        if (!ObjectUtils.isEmpty(nurseryAnnounceDO)){
            try {
                annunceManageSV.updateAnnounce(nurseryAnnounceDO);
            }catch (SQLException exception) {
                responseResult.setCommonCode(AnnounceCode.ANNOUNCE_SQL_FAIL);
            }
        }else {
            responseResult.setCommonCode(AnnounceCode.ANNOUNCE_PARAM_NONE);
        }
        return responseResult;
    }

}
