package com.xian.lebo.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TimeTable {
    private Integer id;
    private Integer sid;
    private Integer tid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date classTime;
    private Integer cid;
    private Integer useTime;
    private String sname;
    private String tname;
    private String timeslot;

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Date getClassTime() {
        return classTime;
    }

    public void setClassTime(Date classTime) {
        this.classTime = classTime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "id=" + id +
                ", sid=" + sid +
                ", tid=" + tid +
                ", classTime=" + classTime +
                ", cid=" + cid +
                ", useTime=" + useTime +
                ", sname='" + sname + '\'' +
                ", tname='" + tname + '\'' +
                ", timeslot='" + timeslot + '\'' +
                '}';
    }
}
