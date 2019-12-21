package com.xian.lebo.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Teacher {
    private Integer id;
    private String tname;
    private String tphone;
    private String teducation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date worktime;

    public Date getWorktime() {
        return worktime;
    }

    public void setWorktime(Date worktime) {
        this.worktime = worktime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getTeducation() {
        return teducation;
    }

    public void setTeducation(String teducation) {
        this.teducation = teducation;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", tphone='" + tphone + '\'' +
                ", teducation='" + teducation + '\'' +
                ", worktime=" + worktime +
                '}';
    }
}
