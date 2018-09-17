package com.hmz.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
//指向数据库中table
@Table(name ="company3")
public class Company3 {
    @Id
    @GeneratedValue(generator = "ID")
    @GenericGenerator(name = "ID", strategy = "native")
    @Column(name = "ID", length = 50)
    private int ID;
    @Column(name = "reg_no", length = 20)
    private String reg_no;
    @Column(name = "com_name", length = 50)
    private String com_name;
    @Column(name = "ZB", length = 50)
    private String ZB;//注册资本
    @Column(name = "RQ", length = 50)
    private String RQ;//运营日期
    @Column(name = "FW", length = 2000)
    private String FW;//运营范围
    @Column(name = "Addr", length = 1000)
    private String Addr;//所在地区
    @Column(name = "LX", length = 50)
    private String LX;//类型
    @Column(name = "DJJG", length = 50)
    private String DJJG;//登记机关
    @Column(name = "FD", length = 50)
    private String FD;//法定代表人
    @Column(name = "HZRQ", length = 50)
    private String HZRQ;//核准日期
    @Column(name = "DJZT", length = 40)
    private String DJZT;//登记状态
    @Column(name = "YZ", length = 40)
    private String YZ;//邮政
    @Column(name = "YX", length = 40)
    private String YX;//邮箱
    @Column(name = "DH", length = 40)
    private String DH;//电话
    @Column(name = "DWTZ", length = 40)
    private String DWTZ;//对外投资
    @Column(name = "JJ", length = 1000)
    private String JJ;//简介
    @Column(name = "subcom", length = 1000)
    private String subcom;
    @Column(name = "xzxk", length = 100)
    private String xzxk;
    @Column(name = "xzcf", length = 100)
    private String xzcf;
    @Column(name = "jyycml", length = 100)
    private String jyycml;
    @Column(name = "hmd", length = 100)
    private String hmd;
    @Column(name = "key_person", length = 1000)
    private String key_person;
    @Column(name = "com_url", length = 100)
    private String com_url;
    @Column(name = "GDTZ", length = 1000)
    private String GDTZ;

    public String getGDTZ() {
        return GDTZ;
    }

    public void setGDTZ(String GDTZ) {
        this.GDTZ = GDTZ;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getZB() {
        return ZB;
    }

    public void setZB(String ZB) {
        this.ZB = ZB;
    }

    public String getRQ() {
        return RQ;
    }

    public void setRQ(String RQ) {
        this.RQ = RQ;
    }

    public String getFW() {
        return FW;
    }

    public void setFW(String FW) {
        this.FW = FW;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public String getLX() {
        return LX;
    }

    public void setLX(String LX) {
        this.LX = LX;
    }

    public String getDJJG() {
        return DJJG;
    }

    public void setDJJG(String DJJG) {
        this.DJJG = DJJG;
    }

    public String getFD() {
        return FD;
    }

    public void setFD(String FD) {
        this.FD = FD;
    }

    public String getHZRQ() {
        return HZRQ;
    }

    public void setHZRQ(String HZRQ) {
        this.HZRQ = HZRQ;
    }

    public String getDJZT() {
        return DJZT;
    }

    public void setDJZT(String DJZT) {
        this.DJZT = DJZT;
    }

    public String getYZ() {
        return YZ;
    }

    public void setYZ(String YZ) {
        this.YZ = YZ;
    }

    public String getYX() {
        return YX;
    }

    public void setYX(String YX) {
        this.YX = YX;
    }

    public String getDH() {
        return DH;
    }

    public void setDH(String DH) {
        this.DH = DH;
    }

    public String getDWTZ() {
        return DWTZ;
    }

    public void setDWTZ(String DWTZ) {
        this.DWTZ = DWTZ;
    }

    public String getJJ() {
        return JJ;
    }

    public void setJJ(String JJ) {
        this.JJ = JJ;
    }

    public String getSubcom() {
        return subcom;
    }

    public void setSubcom(String subcom) {
        this.subcom = subcom;
    }

    public String getXzxk() {
        return xzxk;
    }

    public void setXzxk(String xzxk) {
        this.xzxk = xzxk;
    }

    public String getXzcf() {
        return xzcf;
    }

    public void setXzcf(String xzcf) {
        this.xzcf = xzcf;
    }

    public String getJyycml() {
        return jyycml;
    }

    public void setJyycml(String jyycml) {
        this.jyycml = jyycml;
    }

    public String getHmd() {
        return hmd;
    }

    public void setHmd(String hmd) {
        this.hmd = hmd;
    }

    public String getKey_person() {
        return key_person;
    }

    public void setKey_person(String key_person) {
        this.key_person = key_person;
    }

    public String getCom_url() {
        return com_url;
    }

    public void setCom_url(String com_url) {
        this.com_url = com_url;
    }


    @Override
    public String toString() {
        return "Company2{" +
                "ID=" + ID +
                ", reg_no='" + reg_no + '\'' +
                ", com_name='" + com_name + '\'' +
                ", ZB='" + ZB + '\'' +
                ", RQ='" + RQ + '\'' +
                ", FW='" + FW + '\'' +
                ", Addr='" + Addr + '\'' +
                ", LX='" + LX + '\'' +
                ", DJJG='" + DJJG + '\'' +
                ", FD='" + FD + '\'' +
                ", HZRQ='" + HZRQ + '\'' +
                ", DJZT='" + DJZT + '\'' +
                ", YZ='" + YZ + '\'' +
                ", YX='" + YX + '\'' +
                ", DH='" + DH + '\'' +
                ", DWTZ='" + DWTZ + '\'' +
                ", JJ='" + JJ + '\'' +
                ", subcom='" + subcom + '\'' +
                ", xzxk='" + xzxk + '\'' +
                ", xzcf='" + xzcf + '\'' +
                ", jyycml='" + jyycml + '\'' +
                ", hmd='" + hmd + '\'' +
                ", key_person='" + key_person + '\'' +
                ", com_url='" + com_url + '\'' +
                ", GDTZ='" + GDTZ + '\'' +
                '}';
    }
}
