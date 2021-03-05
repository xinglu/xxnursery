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
    private Date startTime;//招聘开始时间
    private String endtime;//招聘结束时间
    private Date endTime;//招聘结束时间
    private String place;//工作地点
    private String requireExperience;//招聘要求--工作经验*
    private String requireEduDB;//招聘要求--学历
    private int manNumbers;//招聘人数
    private String companyresume;//公司简历
    private String jobdesciption;//职位描述
    private String isNotStaleDated;//时间是否过期
    private String experience;//工作经验
    private String[] types;
    private String[] labels;
    private String responsibility;//职责描述
    private String require;//职位要求
    private String treatment;//职位待遇
    private int applynum;//报名人数
    private String cutoff;//报名是否过期
    private String enrollFull;//报名人数已满
    private String authorId;//招聘发布人员

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(String endtime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(endtime);
        } catch (ParseException e) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                parse = simpleDateFormat.parse(endtime);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
        this.endTime = parse;
        setIsNotStaleDated(parse);
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
        setEndTime(endtime);
    }

    public String getIsNotStaleDated() {
        return isNotStaleDated;
    }

    public void setIsNotStaleDated(Date endtime) {
        Date nowDate = new Date();
        if (endtime != null) {
            int i = nowDate.compareTo(endtime);
            if (i > 0) {
                this.isNotStaleDated = "true";//过期了
            } else {
                this.isNotStaleDated = "false";//没有过期
            }
        }
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public int getApplynum() {
        return applynum;
    }

    public void setApplynum(int applynum) {
        this.applynum = applynum;
    }

    public String getCutoff() {
        return cutoff;
    }

    public void setCutoff(String cutoff) {
        this.cutoff = cutoff;
    }

    public String getEnrollFull() {
        return enrollFull;
    }

    public void setEnrollFull(String enrollFull) {
        this.enrollFull = enrollFull;
    }

    public int getManNumbers() {
        return manNumbers;
    }

    public void setManNumbers(int manNumbers) {
        this.manNumbers = manNumbers;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
