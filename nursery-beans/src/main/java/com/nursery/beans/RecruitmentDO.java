package com.nursery.beans;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 招聘内容
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentDO {
    private String id;
    private String recruittablename;//招聘标题
    private String classify;//招聘分类信息
    private String pay;//招聘待遇--薪资
    private String starttime;//招聘开始时间
    private Date endtime;//招聘结束时间
    private String place;//招聘地点
    private String requireExperience;//招聘要求--工作经验
    private String requireEduDB;//招聘要求--学历
    private String manNumbers;//招聘人数
    private String companyresume;//公司简历
    private String jobdesciption;//职位描述
    private String isNotStaleDated;//时间是否过期

    public String getIsNotStaleDated() {
        return isNotStaleDated;
    }

    public void setIsNotStaleDated(Date endtime) {
        Date nowDate = new Date();
        if (endtime!=null){
            int i = nowDate.compareTo(endtime);
            if (i>0){
                this.isNotStaleDated = "true";//过期了
            }else {
                this.isNotStaleDated = "false";//没有过期
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecruittablename() {
        return recruittablename;
    }

    public void setRecruittablename(String recruittablename) {
        this.recruittablename = recruittablename;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(endtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.endtime = parse;
        setIsNotStaleDated(parse);
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRequireExperience() {
        return requireExperience;
    }

    public void setRequireExperience(String requireExperience) {
        this.requireExperience = requireExperience;
    }

    public String getRequireEduDB() {
        return requireEduDB;
    }

    public void setRequireEduDB(String requireEduDB) {
        this.requireEduDB = requireEduDB;
    }

    public String getManNumbers() {
        return manNumbers;
    }

    public void setManNumbers(String manNumbers) {
        this.manNumbers = manNumbers;
    }

    public String getCompanyresume() {
        return companyresume;
    }

    public void setCompanyresume(String companyresume) {
        this.companyresume = companyresume;
    }

    public String getJobdesciption() {
        return jobdesciption;
    }

    public void setJobdesciption(String jobdesciption) {
        this.jobdesciption = jobdesciption;
    }
}
