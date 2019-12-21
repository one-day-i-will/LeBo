package com.xian.lebo.pojo;

public class StudentTest {
    private Integer id;
    private String name;
    private String sphone;

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentTest(Integer id, String name, String sphone) {
        this.id = id;
        this.name = name;
        this.sphone = sphone;
    }

    public StudentTest() {
    }
}
