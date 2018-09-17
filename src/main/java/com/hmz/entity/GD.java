package com.hmz.entity;

public class GD {
    private String reg_no;
    private String GD_name;

    @Override
    public String toString() {
        return "GD{" +
                "reg_no='" + reg_no + '\'' +
                ", GD_name='" + GD_name + '\'' +
                ", GDLX='" + GDLX + '\'' +
                ", GDBL=" + GDBL +
                ", BL='" + BL + '\'' +
                ", com_name='" + com_name + '\'' +
                '}';
    }

    private String GDLX;
    private Double GDBL;

    public String getBL() {
        return BL;
    }

    public void setBL(String BL) {
        this.BL = BL;
    }

    private String BL;
    private String com_name;


    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getGD_name() {
        return GD_name;
    }

    public void setGD_name(String GD_name) {
        this.GD_name = GD_name;
    }

    public String getGDLX() {
        return GDLX;
    }

    public void setGDLX(String GDLX) {
        this.GDLX = GDLX;
    }

    public Double getGDBL() {
        return GDBL;
    }

    public void setGDBL(Double GDBL) {
        this.GDBL = GDBL;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }
}
