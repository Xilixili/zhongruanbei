package com.hmz.entity;
public class Relation1
{
    private String com_name;
    private String reg_no;
    private String max_TZ;
    private String TZRQ;


    @Override
    public String toString() {
        return "Relation1{" +
                "com_name='" + com_name + '\'' +
                ", reg_no='" + reg_no + '\'' +
                ", max_TZ='" + max_TZ + '\'' +
                ", TZRQ='" + TZRQ + '\'' +
                '}';
    }


    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getMax_TZ() {
        return max_TZ;
    }

    public void setMax_TZ(String max_TZ) {
        this.max_TZ = max_TZ;
    }

    public String getTZRQ() {
        return TZRQ;
    }

    public void setTZRQ(String TZRQ) {
        this.TZRQ = TZRQ;
    }


}
