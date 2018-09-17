package com.hmz.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
//指向数据库中table
@Table(name ="company1")

public class Company1 {

    @Id
    @GeneratedValue(generator = "ID")
    @GenericGenerator(name = "ID", strategy = "native")
    @Column(name = "ID", length = 50)
    private int ID;
    @Column(name = "reg_no", length = 50)
    private String reg_no;
    @Column(name = "com_name", length = 20)
    private String com_name;
    @Column(name = "ZB", length = 20)
    private String ZB;//注册资本
    @Column(name = "RQ", length = 20)
    private String RQ;//运营日期
    @Column(name = "FW", length = 20)
    private String FW;//运营范围
    @Column(name = "PRO", length = 40)
    private String PRO;//所在省份

    @Override
    public String toString() {
        return "Company1{" +
                "ID=" + ID +
                ", reg_no='" + reg_no + '\'' +
                ", com_name='" + com_name + '\'' +
                ", ZB='" + ZB + '\'' +
                ", RQ='" + RQ + '\'' +
                ", FW='" + FW + '\'' +
                ", PRO='" + PRO + '\'' +
                '}';
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getPRO() {
        return PRO;
    }

    public void setPRO(String PRO) {
        this.PRO = PRO;
    }



}
