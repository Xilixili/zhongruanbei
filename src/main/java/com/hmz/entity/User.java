package com.hmz.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Author Hu mingzhi
 * Created by ThinKPad on 2017/9/8.
 */
//实体类
@Entity
//指向数据库中table
@Table(name = "user1")
public class User {

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native")
    private int id;
    @Column(name="username", length=20)
    private String username;
    @Column(name="password", length=20)
    private String password;
    @Column(name="email", length=20)
    private String email;
    @Column(name="image_path", length=300)
    private String image_path;
    @Column(name="sex", length=20)
    private String sex;
    @Column(name="com", length=100)
    private String com;
    @Column(name="Tname", length=100)
    private String Tname;
    @Column(name="FW", length=50)
    private String FW;
    @Column(name="Uposition", length=50)
    private String Uposition;
    @Column(name="Addr", length=200)
    private String Addr;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", image_path='" + image_path + '\'' +
                ", sex='" + sex + '\'' +
                ", com='" + com + '\'' +
                ", name='" + Tname + '\'' +
                ", FW='" + FW + '\'' +
                ", position='" + Uposition + '\'' +
                ", Addr='" + Addr + '\'' +
                '}';
    }



    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getFW() {
        return FW;
    }

    public void setFW(String FW) {
        this.FW = FW;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getUposition() {
        return Uposition;
    }

    public void setUposition(String uposition) {
        Uposition = uposition;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
