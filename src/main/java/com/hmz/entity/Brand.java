package com.hmz.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
//实体类,总表
@Entity
//指向数据库中table
@Table(name ="brand")
public class Brand {

        /**
         * @Author Hu mingzhi
         * Created by ThinKPad on 2017/9/8.
         */
        @Id
        @GeneratedValue(generator = "brand_no")
        @GenericGenerator(name = "brand_no", strategy = "native")
        private String brand_no;

    public String getBrand_no() {
        return brand_no;
    }

    public void setBrand_no(String brand_no) {
        this.brand_no = brand_no;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getClass_no() {
        return class_no;
    }

    public void setClass_no(String class_no) {
        this.class_no = class_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Column(name = "reg_no", length = 50)
        private String reg_no;
        @Column(name = "img_url", length = 300)
        private String img_url;
        @Column(name = "class_no", length = 100)
        private String class_no;
        @Column(name = "date", length = 100)
        private String date;
        @Column(name = "service", length = 300)
        private String service;

    @Override
    public String toString() {
        return "Brand{" +
                "brand_no='" + brand_no + '\'' +
                ", reg_no='" + reg_no + '\'' +
                ", img_url='" + img_url + '\'' +
                ", class_no='" + class_no + '\'' +
                ", date='" + date + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}
