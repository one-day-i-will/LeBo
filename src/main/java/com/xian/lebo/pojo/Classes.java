package com.xian.lebo.pojo;

public class Classes {
    private Integer id;
    private String cname;
    private Integer tid;
    private String tname;


    public Classes() {
    }

    public Classes(Integer id, String cname, Integer tid, String tname) {
        this.id = id;
        this.cname = cname;
        this.tid = tid;
        this.tname = tname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }
}
