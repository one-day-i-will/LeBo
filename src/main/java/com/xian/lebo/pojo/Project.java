package com.xian.lebo.pojo;

public class Project {
    private Integer id;
    private String pname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                '}';
    }
}
