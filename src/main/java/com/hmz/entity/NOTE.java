package com.hmz.entity;

public class NOTE {
    private String id;
    private String username;
    private String content;
    private String NOTE_com;
    private String NOTE_RQ;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNOTE_com() {
        return NOTE_com;
    }

    public void setNOTE_com(String NOTE_com) {
        this.NOTE_com = NOTE_com;
    }

    public String getNOTE_RQ() {
        return NOTE_RQ;
    }

    public void setNOTE_RQ(String NOTE_RQ) {
        this.NOTE_RQ = NOTE_RQ;
    }


    @Override
    public String toString() {
        return "NOTE{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", NOTE_com='" + NOTE_com + '\'' +
                ", NOTE_RQ='" + NOTE_RQ + '\'' +
                '}';
    }
}
