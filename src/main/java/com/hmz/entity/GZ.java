package com.hmz.entity;

public class GZ {
    private String id;
    private String username;
    private String GZ_com;
    private String GZ_RQ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGZ_com() {
        return GZ_com;
    }

    public void setGZ_com(String GZ_com) {
        this.GZ_com = GZ_com;
    }

    public String getGZ_RQ() {
        return GZ_RQ;
    }

    public void setGZ_RQ(String GZ_RQ) {
        this.GZ_RQ = GZ_RQ;
    }

    @Override
    public String toString() {
        return "GZ{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", GZ_com='" + GZ_com + '\'' +
                ", GZ_RQ='" + GZ_RQ + '\'' +
                '}';
    }
}
