package com.nursery.cmsweb.controller;

import com.nursery.api.iweb.ResumeApi;
import com.nursery.beans.vo.PeoRecruitSendVO;
import com.nursery.common.model.response.QueryResponseResult;
import com.nursery.common.web.BaseController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * 简历上传下载
 */

@RestController
public class ConsumerResumeController extends BaseController implements ResumeApi {


    /**
     * 访问个人简历界面
     * @param consumerId 用户id
     * @param model 返回值
     * @return
     */
    @RequestMapping(value = "/consumer/resume/{consumerId}",method = RequestMethod.GET)
    public ModelAndView visitConsumerResume(@PathVariable("consumerId") String consumerId, ModelAndView model){

        return model;
    }

    @Override
    public List<PeoRecruitSendVO> showRecruitSend(String consumerID) {
        return null;
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
