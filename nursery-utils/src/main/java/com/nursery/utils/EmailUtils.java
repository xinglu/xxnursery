package com.nursery.utils;

import com.alibaba.druid.util.StringUtils;
import com.nursery.beans.vo.MailVo;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * 邮件工具类
 */
@Component
public class EmailUtils {
    private static final String EMAIL_REGEX="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public static EmailUtils sendEmailUtils = new EmailUtils();

    public EmailUtils() {
        if (sendEmailUtils ==null){
            sendEmailUtils = new EmailUtils();
        }
    }

    public static String sendCheckEmail(String email) {
        return null;
    }

    public static boolean checkEmail(String consumerEmail) {
        return false;
    }

    /**
     * 校验邮箱
     * @param consumerEmail
     * @return
     */
    public static boolean verify(String consumerEmail) {
        return Pattern.matches(EMAIL_REGEX, consumerEmail.trim());
    }

    public MailVo sendSimpleEmail(MailVo mailVo) {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
       /* SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        try {
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(text);
            javaMailSender.send(simpleMailMessage);*/
           /* MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text,true);
            javaMailSender.send(mimeMessage);*/

        try {
            checkMail(mailVo); //1.检测邮件
            sendMimeMail(mailVo); //2.发送邮件
            return saveMail(mailVo); //3.保存邮件
        } catch (Exception e) {
            mailVo.setStatus("fail");
            mailVo.setError(e.getMessage());
            return mailVo;

        }
    }

    //检测邮件信息类
    private void checkMail(MailVo mailVo){
        if (StringUtils.isEmpty(mailVo.getTo())) {
            throw new RuntimeException("邮件收信人不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getSubject())) {
            throw new RuntimeException("邮件主题不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getText())) {
            throw new RuntimeException("邮件内容不能为空");
        }
    }
    //构建复杂邮件信息类
    private void sendMimeMail(MailVo mailVo) {
        try {
            MimeMessageHelper messageHelper;//true表示支持复杂类型
            javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            messageHelper = new MimeMessageHelper(mimeMessage, true);
            //mailVo.setFrom(getMailSendFrom());//邮件发信人从配置项读取
            messageHelper.setFrom(from);//邮件发信人
            messageHelper.setTo(mailVo.getTo().split(","));//邮件收信人
            messageHelper.setSubject(mailVo.getSubject());//邮件主题
            messageHelper.setText(mailVo.getText());//邮件内容
            if (!StringUtils.isEmpty(mailVo.getCc())) {//抄送
                messageHelper.setCc(mailVo.getCc().split(","));
            }
            if (!StringUtils.isEmpty(mailVo.getBcc())) {//密送
                messageHelper.setCc(mailVo.getBcc().split(","));
            }
            if (mailVo.getMultipartFiles() != null) {//添加邮件附件
                for (MultipartFile multipartFile : mailVo.getMultipartFiles()) {
                    messageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
                }
            }
            if (org.springframework.util.StringUtils.isEmpty(mailVo.getSentDate())) {//发送时间
                mailVo.setSentDate(new Date());
                messageHelper.setSentDate(mailVo.getSentDate());
            }
            javaMailSender.send(messageHelper.getMimeMessage());//正式发送邮件
            mailVo.setStatus("ok");
        } catch (Exception e) {
            throw new RuntimeException(e);//发送失败
        }
    }

    //保存邮件
    private MailVo saveMail(MailVo mailVo) {

        //将邮件保存到数据库..

        return mailVo;
    }

    //获取邮件发信人
    public String getMailSendFrom() {
        return javaMailSender.getJavaMailProperties().getProperty("from");
    }


    /**
     * 163邮箱
     * @param emailAddress
     * @param code
     * @return
     */
    public static boolean sendEmail(String emailAddress,String code){
        try {
            HtmlEmail email = new HtmlEmail();//不用更改
            email.setHostName("smtp.163.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
            email.setCharset("UTF-8");//设置发送的字符类型
            email.addTo(emailAddress);//设置收件人

            email.setFrom("13243038531@163.com", "xxNursery");//此处填邮箱地址和用户名,用户名可以任意填写
            email.setAuthentication("13243038531@163.com", "KCEDIYIXHVEQQUNW");//此处填写邮箱地址和客户端授权码
            email.setSubject("注册验证码");//此处填写邮件名，邮件名可任意填写
            email.setMsg("尊敬的用户您好,您本次注册的验证码是:\n" + code);//此处填写邮件内容
            //  email.setSSLOnConnect(false);
            //启用ssl加密
            email.setSSLOnConnect(true);
            //使用465端口(不设置也可，ssl默认为465)
            email.setSslSmtpPort("465");
            email.send();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
