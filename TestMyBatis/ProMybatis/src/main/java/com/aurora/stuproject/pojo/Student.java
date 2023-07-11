package com.aurora.stuproject.pojo;

public class Student {
    private Integer sid;
    private String sname;
    private Class myclass;

    public Student(Integer sid, String sname, Class myclass) {
        this.sid = sid;
        this.sname = sname;
        this.myclass = myclass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", myClass=" + myclass +
                '}';
    }

    public Class getMyclass() {
        return myclass;
    }

    public void setMyclass(Class myclass) {
        this.myclass = myclass;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Student() {
    }
}
