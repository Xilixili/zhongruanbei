package com.hmz.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//实体类,总表
@Entity
//指向数据库中table
@Table(name = "company")

public class Company {
    /**
     * @Author Hu mingzhi
     * Created by ThinKPad on 2017/9/8.
     */
        @Id
        @GeneratedValue(generator = "reg_no")
        @GenericGenerator(name = "reg_no", strategy = "native")
        private String reg_no;
        @Column(name = "com_name", length = 20)
        private String com_name;
    @Column(name = "yyzz", length = 20)
        private String yyzz;
        @Column(name = "base_info", length = 20)
        private String base_info;
        @Column(name = "dwcz", length = 20)
        private String dwcz;
        @Column(name = "gdcz", length = 20)
        private String gdcz;


    @Override
    public String toString() {
        return "Company{" +
                "reg_no='" + reg_no + '\'' +
                ", com_name='" + com_name + '\'' +
                ", yyzz='" + yyzz + '\'' +
                ", base_info='" + base_info + '\'' +
                ", dwcz='" + dwcz + '\'' +
                ", gdcz='" + gdcz + '\'' +
                '}';
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

        public String getYyzz() {
            return yyzz;
        }

        public void setYyzz(String yyzz) {
            this.yyzz = yyzz;
        }

        public String getBase_info() {
            return base_info;
        }

        public void setBase_info(String base_info) {
            this.base_info = base_info;
        }

        public String getDwcz() {
            return dwcz;
        }

        public void setDwcz(String dwcz) {
            this.dwcz = dwcz;
        }

        public String getGdcz() {
            return gdcz;
        }

        public void setGdcz(String gdcz) {
            this.gdcz = gdcz;
        }
    }



