package com.nursery.cmsweb.controller;

import com.alibaba.fastjson.JSONObject;
import com.nursery.api.iservice.IConsumerResumeSV;
import com.nursery.api.iservice.IDomesticConsumerSV;
import com.nursery.api.iweb.ResumeApi;
import com.nursery.beans.DomesticConsumerDO;
import com.nursery.beans.DomesticConsumerResumeDO;
import com.nursery.beans.bo.ConsumerBO;
import com.nursery.common.model.CommonAttrs;
import com.nursery.common.model.response.QueryResponseResult;
import com.nursery.common.web.BaseController;
import com.nursery.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 简历上传下载
 */

@Controller
public class ConsumerResumeController extends BaseController implements ResumeApi {

    private Logger logger = LoggerFactory.getLogger(ConsumerResumeController.class);
    @Autowired
    private IConsumerResumeSV consumerResumeSV;
    @Autowired
    private IDomesticConsumerSV consumerSV;

    //访问简历页面
    @RequestMapping(value = "/consumer/resume/{param}", method = RequestMethod.GET)
    @Override
    public String visitResume(@PathVariable(value = "param", required = false) String param) {
        String consumerId = "";
        if (!StringUtils.isEmpty(param)){
            ConsumerBO consumerBO = (ConsumerBO) session.getAttribute(param);
            try {
                consumerId = consumerBO.getId();
            }catch (NullPointerException e){
                logger.error("获取不到用户，null异常");
                return "500";
            }
            try {
                DomesticConsumerDO consumerDO = consumerSV.selectConsumerResumeByConsumerID(consumerId);
                request.setAttribute("consumer",consumerDO);
            } catch (SQLException e) {
                logger.error("数据库查询异常/语句出错");
                return "500";
            }
        }
        return "resume";
    }

    /**
     * 上传简历
     * 1. 比对简历信息,是否符合要求
     * 2. 判断文件夹是否存在,下载到本地,不存在就创建mkdirs
     * 3. 下载成功,则返回url信息,并将简历信息存入到数据库中.
     *
     * @param file 简历信息
     * @return 固定返回参数信息
     */
    @RequestMapping(value = {"/consumer/resume/upload/{param}"})
    @ResponseBody
    @Override
    public JSONObject uploadResume(@RequestParam(value = "resumeFile", required = true) MultipartFile file, @PathVariable(value = "param",required = false) String liushui) {
        JSONObject responseResult = new JSONObject();
        String param = liushui;     //流水号
        String consumerId = "";     //用户id
        String path = "";           //文件的真实路径
        String realFileName = "";   //简历名称
        String suffix = "";         //简历后缀/类型
        String sqlFileUrl = "";     //简历url地址
        String resumeId = "";       //简历id
        long size = 0;              //文件大小
        String fileName = "";       //随机生成的文件名称
        File targetFile = null;
        //从cookie中获取用户id;
        /*Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("number".equals(name)) {
                consumerId = cookie.getValue();
                break;
            }
        }*/
        ConsumerBO attribute = (ConsumerBO) session.getAttribute(param);
        consumerId = attribute.getId();
        try {
            realFileName = file.getOriginalFilename();//获取文件名称
            suffix = realFileName.substring(realFileName.lastIndexOf("."));//获取后缀
            size = file.getSize();
            if (!CommonAttrs.WORD_TYPE.contains(suffix)) {
                responseResult.put("success", 0);//格式不正确
                responseResult.put("message", "简历格式不正确：{doc, docx}");
                return responseResult;
            }
            if (size > CommonAttrs.IMG_MAX_SIZE) {
                responseResult.put("success", 0);//文件过大
                responseResult.put("message", "最大长度为!2MB");
                return responseResult;
            }
            resumeId = CommonUtil.getUUID() + CommonUtil.getRandomNum(100, 200);
            fileName = resumeId + suffix;
            //获取真实路径
            path = ResourceUtils.getURL("xxnursery/").getPath() + "word/upload";
            String realPath = path.replace('/', '\\').substring(1, path.length());
            targetFile = new File(realPath, fileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            try {
                file.transferTo(targetFile);//保存
            } catch (Exception e) {
                responseResult.put("success", 0);
                responseResult.put("message", "上传失败 !");
                return responseResult;
            }
        } catch (Exception e) {
            responseResult.put("success", 0);
            responseResult.put("message", "上传失败 !");
            return responseResult;
        }
        //如果上传成功,则将该地址返回,并存入数据库中
        sqlFileUrl = request.getContextPath() + "/upload/word/" + fileName;
        //数据库操作
        try {
            DomesticConsumerResumeDO consumerResumeDO = new DomesticConsumerResumeDO();
            consumerResumeDO.setId(resumeId);
            consumerResumeDO.setName(realFileName);
            consumerResumeDO.setType(suffix);
            consumerResumeDO.setUrl(sqlFileUrl);
            consumerResumeDO.setSize(size + "");
            //保存信息
            consumerResumeSV.insertResume(consumerResumeDO);
            DomesticConsumerDO consumerDO = new DomesticConsumerDO();
            consumerDO.setConsumerID(consumerId);
            consumerDO.setResumeISNOT(1);
            consumerDO.setResumeId(resumeId);
            consumerSV.updateConsumerResume(consumerDO);
        } catch (Exception e) {
            responseResult.put("success", 0);
            responseResult.put("message", "上传失败!");
            //删除文件;
            targetFile.delete();
            return responseResult;
        }
        responseResult.put("url", sqlFileUrl);
        responseResult.put("success", 1);
        responseResult.put("message", "上传成功!");
        return responseResult;
    }


    @PostMapping("/resumeUploadIng")
    @Override
    public QueryResponseResult resumeUpload(String strDocument, MultipartFile file) {
        HashMap<String, String> returnmap = new HashMap<>();
        try {
            if (strDocument != null && strDocument != "") {

            } else if (file != null && !file.isEmpty()) {
               /* byte[] bytes = file.getBytes();
                Path path = Paths.get("D:\\1234.doc");
                Path write = Files.write(path, bytes);
                returnmap.put("path",write.getFileName().toString());*/
                String filename = file.getOriginalFilename();
                int size = (int) file.getSize();
                System.out.println(filename + "--->>>" + size);
                String path = "E:/test";
                File dest = new File(path + "/" + filename);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                file.transferTo(dest);//保存文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    @GetMapping("/resumeDownIng")
    @Override
    public QueryResponseResult resumeDownIng(String urlWord) {
        File file = new File(urlWord);
        if (file.exists()) { //判断文件父目录是否存在
            response.setContentType("application/msword");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");

            response.setHeader("Content-Disposition", "attachment;fileName=" + "f.doc");

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public QueryResponseResult resumeUpdateUpload() {
        return null;
    }

    @Override
    public QueryResponseResult resumeOnlineReading() {
        return null;
    }


}
