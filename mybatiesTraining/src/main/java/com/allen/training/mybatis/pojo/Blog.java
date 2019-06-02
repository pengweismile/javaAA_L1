package com.allen.training.mybatis.pojo;

public class Blog {
    private int sid ;
    private String sname;

    public Blog(int sid, String sname){
        this.sid = sid;
        this.sname=sname;
    }
    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
