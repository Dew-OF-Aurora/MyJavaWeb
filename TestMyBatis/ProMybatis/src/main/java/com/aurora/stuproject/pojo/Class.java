package com.aurora.stuproject.pojo;

import java.util.List;

public class Class {
    private Integer cid;
    private String cname;

    private List<Student> stus;

    @Override
    public String toString() {
        return "Class{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", stus=" + stus +
                '}';
    }

    public Class(Integer cid, String cname, List<Student> stus) {
        this.cid = cid;
        this.cname = cname;
        this.stus = stus;
    }

    public Class() {
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
