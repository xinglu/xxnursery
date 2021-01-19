package com.nursery.beans;

/**
 * Create with IDEA
 * author:MeiShiQiang
 * Date:2021/1/2
 * Time:12:43
 */
public class UserInfo {

    String age;
    String educationBg; //教育背景
    String status; //省份

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEducationBg() {
        return educationBg;
    }

    public void setEducationBg(String educationBg) {
        this.educationBg = educationBg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "age='" + age + '\'' +
                ", educationBg='" + educationBg + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
