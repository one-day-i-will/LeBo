package com.xian.lebo.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {
    private Integer id;
    private String sname;
    private String school;
    private String  sphone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date renewDate;
    private String project;
    private Integer duration;
    private Integer cid;

    public Student(Integer id, String sname, String school, String sphone, Date startDate, Date renewDate, String project, Integer duration, Integer cid) {
        this.id = id;
        this.sname = sname;
        this.school = school;
        this.sphone = sphone;
        this.startDate = startDate;
        this.renewDate = renewDate;
        this.project = project;
        this.duration = duration;
        this.cid = cid;
    }

    public Student() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(Date renewDate) {
        this.renewDate = renewDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", school='" + school + '\'' +
                ", sphone='" + sphone + '\'' +
                ", startDate=" + startDate +
                ", renewDate=" + renewDate +
                ", project='" + project + '\'' +
                ", duration=" + duration +
                '}';
    }


}
