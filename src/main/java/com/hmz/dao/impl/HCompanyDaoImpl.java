package com.hmz.dao.impl;

import com.hmz.dao.HCompanyDao;
import com.hmz.entity.Company;
import com.hmz.entity.Company1;
import com.hmz.entity.Company2;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.*;
import java.util.*;

@Repository

public class HCompanyDaoImpl implements HCompanyDao {

    PreparedStatement stmt1 = null;
    PreparedStatement stmt2 = null;
    PreparedStatement stmt3 = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;

    String sql1 = null;
    String sql2 = null;
    String sql3 = null;

         {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection conn=null;

    {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private HibernateTemplate template;
    @Resource(name="hibernateTemplate")

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }


    List<Company1> company1List;
    List<Company2> company2List=new List<Company2>() {
        public int size() {
            return 0;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean contains(Object o) {
            return false;
        }

        public Iterator<Company2> iterator() {
            return null;
        }

        public Object[] toArray() {
            return new Object[0];
        }

        public <T> T[] toArray(T[] a) {
            return null;
        }

        public boolean add(Company2 company2) {
            return false;
        }

        public boolean remove(Object o) {
            return false;
        }

        public boolean containsAll(Collection<?> c) {
            return false;
        }

        public boolean addAll(Collection<? extends Company2> c) {
            return false;
        }

        public boolean addAll(int index, Collection<? extends Company2> c) {
            return false;
        }

        public boolean removeAll(Collection<?> c) {
            return false;
        }

        public boolean retainAll(Collection<?> c) {
            return false;
        }

        public void clear() {

        }

        public Company2 get(int index) {
            return null;
        }

        public Company2 set(int index, Company2 element) {
            return null;
        }

        public void add(int index, Company2 element) {

        }

        public Company2 remove(int index) {
            return null;
        }

        public int indexOf(Object o) {
            return 0;
        }

        public int lastIndexOf(Object o) {
            return 0;
        }

        public ListIterator<Company2> listIterator() {
            return null;
        }

        public ListIterator<Company2> listIterator(int index) {
            return null;
        }

        public List<Company2> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    Company2 company2;
    public void querybyHsearch(Company1 company1) {
//        System.out.println(company1.toString());
//        System.out.println("执行dao层");
        if (!(company1.getPRO().equals("全国"))&&
                !company1.getRQ().equals("不限")&&
                !company1.getZB().equals("不限")){
            System.out.println(company1.toString());
            company1List=(List<Company1>)this.template.find(
                            "from Company1 c1 where " +
                                    "c1.FW=? and " +
                                    "c1.PRO=? and " +
                                    "c1.RQ=? and " +
                                    "c1.ZB=?",
                                         company1.getFW(),company1.getPRO(),company1.getRQ(),company1.getZB());
            System.out.println(company1List.size());
        }//所有条件
       else if (company1.getPRO().equals("全国")&&!(company1.getRQ().equals("不限"))&&!(company1.getZB().equals("不限"))){
            System.out.println("进了2"+company1.toString());
            company1List=(List<Company1>)this.template.find(
                    "from Company1 c1 where " +
                            "c1.FW=? and " +
                            "c1.RQ=? and " +
                            "c1.ZB=?",
                    company1.getFW(),company1.getRQ(),company1.getZB());
            System.out.println(company1List.size());
        }//只有全国一个

        else if (!(company1.getPRO().equals("全国")) &&
                company1.getRQ().equals("不限") &&
                !(company1.getZB().equals("不限"))){
            System.out.println("进了5"+company1.toString());
           company1List=(List<Company1>)this.template.find(
                    "from Company1 c1 where " +
                            "c1.FW=? and " +
                            "c1.PRO=? and " +
                            "c1.ZB=?",
                    company1.getFW(),company1.getPRO(),company1.getZB());
            System.out.println(company1List.size());
        }//只有日期一个

        else if (!company1.getPRO().equals("全国")&&
                !company1.getRQ().equals("不限")&&
                company1.getZB().equals("不限")){
            System.out.println("进了4");
         company1List=(List<Company1>)this.template.find(
                    "from Company1 c1 where " +
                            "c1.FW=? and " +
                            "c1.PRO=? and " +
                            "c1.RQ=?",
                    company1.getFW(),company1.getPRO(),company1.getRQ());
            System.out.println(company1List.size());
        }//只有资本一个


       else if (company1.getPRO().equals("全国")&&
                company1.getRQ().equals("不限")&&
                !(company1.getZB().equals("不限"))){
            System.out.println("进了3");
          company1List=(List<Company1>)this.template.find(
                    "from Company1 c1 where " +
                            "c1.FW=? and " +
                            "c1.ZB=?",
                    company1.getFW(),company1.getZB());
        }//两个  1和2


       else if (!(company1.getPRO().equals("全国"))&&
                company1.getRQ().equals("不限")&&
                company1.getZB().equals("不限")){
            System.out.println("条件来了啊");
            company1List=(List<Company1>)this.template.find(
                    "from Company1 c1 where " +
                            "c1.FW=? and " +
                            "c1.PRO=? " ,
                    company1.getFW(),company1.getPRO());
            System.out.println(company1.getFW()+company1.getPRO());
            System.out.println(company1List.size());
        }//两个  2和3


       else if (company1.getPRO().equals("全国")&&
                !(company1.getRQ().equals("不限"))&&
                company1.getZB().equals("不限")){

            company1List=(List<Company1>)this.template.find(
                    "from Company1 c1 where " +
                            "c1.FW=? and " +
                            "c1.RQ=?  " ,
                    company1.getFW(),company1.getRQ());
            System.out.println(company1List.size());
        }//两个，1和3
        else if ((company1.getPRO().equals("全国")&&
                company1.getRQ().equals("不限")&&
                company1.getZB().equals("不限"))){
            System.out.println("进了5");
            company1List=(List<Company1>)this.template.find(
                    "from Company1 c1 where " +
                            "c1.FW=? " ,
                    company1.getFW());
            System.out.println(company1List.size());
        }//三个都不限

        List<Company2> li2;

        sql1="DELETE FROM company3";
        try {
            stmt1=conn.prepareStatement(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Company2> li3=new ArrayList<Company2>();
        int n=0;
        for (int i=0;i<=company1List.size()-1;i++){//company1获得的数据
            n++;
            String reg_no=company1List.get(i).getReg_no();//得到相应的reg_no，每找到一条插入一条
           li2 =(List<Company2>)this.template.find(
                    "from Company2 c2 WHERE "+
                            "c2.reg_no=?",
                    reg_no);
//           System.out.println(li2.get(0).toString());
//           company2List.add(i,li2.get(0));
            if (li2.size()>0) {
                Company2 com2 = li2.get(0);
//                Company2 com22=new Company2();
//                com22=com2;
                System.out.println("com2为"+com2.toString());
if (com2.getCom_name().endsWith("有限公司")||com2.getCom_name().endsWith("有限责任公司")) {
//System.out.println();
    sql3 = "insert into company3(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH,JJ,subcom,xzxk,xzcf,jyycml,hmd,key_person,com_url,DWTZ)values('" + i + "','" + com2.getReg_no() + "','" + com2.getCom_name() + "','" + com2.getZB() + "','" + com2.getRQ() + "','" + com2.getFW() + "','" + com2.getAddr() + "','" + com2.getLX() + "','" + com2.getFD() + "','" + com2.getDJJG() + "','" + com2.getDJZT() + "','" + com2.getHZRQ() + "','" + com2.getYZ() + "','" + com2.getYX() + "','" + com2.getDH() + "','" + com2.getJJ() + "','" + com2.getSubcom() + "','" + com2.getXzxk() + "','" + com2.getXzcf() + "','" + com2.getJyycml() + "','" + com2.getHmd() + "','" + com2.getKey_person() + "','" + com2.getCom_url() + "','" + com2.getDWTZ() + "')";
    try {
        stmt3 = conn.prepareStatement(sql3);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    try {
        stmt3.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}else {

    System.out.println("company2 分的nsfahfisahf公司为"+com2.toString());
    li3.add(com2);
}

            }
        }
        System.out.println("li3长度为"+li3.size()+"n  wei"+n);
        for (int j=0;j<=li3.size()-1;j++) {//company1获得的数据
            Company2 com2 = li3.get(j);
            n++;
            sql3 = "insert into company3(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH,JJ,subcom,xzxk,xzcf,jyycml,hmd,key_person,com_url,DWTZ)values('" + n + "','" + com2.getReg_no() + "','" + com2.getCom_name() + "','" + com2.getZB() + "','" + com2.getRQ() + "','" + com2.getFW() + "','" + com2.getAddr() + "','" + com2.getLX() + "','" + com2.getFD() + "','" + com2.getDJJG() + "','" + com2.getDJZT() + "','" + com2.getHZRQ() + "','" + com2.getYZ() + "','" + com2.getYX() + "','" + com2.getDH() + "','" + com2.getJJ() + "','" + com2.getSubcom() + "','" + com2.getXzxk() + "','" + com2.getXzcf() + "','" + com2.getJyycml() + "','" + com2.getHmd() + "','" + com2.getKey_person() + "','" + com2.getCom_url() + "','" + com2.getDWTZ() + "')";

            try {
                stmt3 = conn.prepareStatement(sql3);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                stmt3.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        }
}
