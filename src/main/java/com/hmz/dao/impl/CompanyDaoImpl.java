package com.hmz.dao.impl;

import com.hmz.dao.CompanyDao;
import com.hmz.entity.*;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

@Repository
public class CompanyDaoImpl implements CompanyDao {
    PreparedStatement stmt1 = null;

    PreparedStatement stmt3 = null;

    String sql1 = null;

    String sql3 = null;

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection conn;

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

    public String querybyname(String com_name) {
//        System.out.println("dao");
        List<Company2> companylist = (List<Company2>) this.template.find("from Company2 c2 where c2.com_name like '%"+com_name+"%'");
        ArrayList<Company2> companylist1=new ArrayList<Company2>();
//        Company2 company2 = companylist.get(0);
//        System.out.println(companylist.toString());
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
        int j=1;
        for (int i=0;i<=companylist.size()-1;i++){
            if (companylist.get(i).getCom_name().endsWith("有限公司")||companylist.get(i).getCom_name().endsWith("有限责任公司")){
                sql3 = "insert into company3(reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH)values('" + companylist.get(i).getReg_no().trim() + "','" + companylist.get(i).getCom_name().trim() + "','" + companylist.get(i).getZB().trim() + "','" + companylist.get(i).getRQ().trim() + "','" + companylist.get(i).getFW().trim() + "','" + companylist.get(i).getAddr().trim() + "','" + companylist.get(i).getLX().trim() + "','" + companylist.get(i).getFD().trim() + "','" + companylist.get(i).getDJJG().trim() + "','" + companylist.get(i).getDJZT().trim() + "','" + companylist.get(i).getHZRQ().trim() + "','" + companylist.get(i).getYZ().trim() + "','" + companylist.get(i).getYX().trim() + "','" + companylist.get(i).getDH().trim() + "')";
                try {
                    stmt3=conn.prepareStatement(sql3);

                    stmt3.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                companylist1.add(companylist.get(i));
            }

//            if (companylist.get(i).getCom_name().equals(com_name)) {
//                sql3 = "insert into company3(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH)values('" + 0 + "','" + companylist.get(i).getReg_no().trim() + "','" + companylist.get(i).getCom_name().trim() + "','" + companylist.get(i).getZB().trim() + "','" + companylist.get(i).getRQ().trim() + "','" + companylist.get(i).getFW().trim() + "','" + companylist.get(i).getAddr().trim() + "','" + companylist.get(i).getLX().trim() + "','" + companylist.get(i).getFD().trim() + "','" + companylist.get(i).getDJJG().trim() + "','" + companylist.get(i).getDJZT().trim() + "','" + companylist.get(i).getHZRQ().trim() + "','" + companylist.get(i).getYZ().trim() + "','" + companylist.get(i).getYX().trim() + "','" + companylist.get(i).getDH().trim() + "')";
//            }
//            else{
//                sql3 = "insert into company3(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH)values('" + j + "','" + companylist.get(i).getReg_no().trim() + "','" + companylist.get(i).getCom_name().trim() + "','" + companylist.get(i).getZB().trim() + "','" + companylist.get(i).getRQ().trim() + "','" + companylist.get(i).getFW().trim() + "','" + companylist.get(i).getAddr().trim() + "','" + companylist.get(i).getLX().trim() + "','" + companylist.get(i).getFD().trim() + "','" + companylist.get(i).getDJJG().trim() + "','" + companylist.get(i).getDJZT().trim() + "','" + companylist.get(i).getHZRQ().trim() + "','" + companylist.get(i).getYZ().trim() + "','" + companylist.get(i).getYX().trim() + "','" + companylist.get(i).getDH().trim() + "')";
//                j++;
//            }

        }
        for (int i=0;i<=companylist1.size()-1;i++){
            sql3 = "insert into company3(reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH)values('"+companylist.get(i).getReg_no().trim() + "','" + companylist.get(i).getCom_name().trim() + "','" + companylist.get(i).getZB().trim() + "','" + companylist.get(i).getRQ().trim() + "','" + companylist.get(i).getFW().trim() + "','" + companylist.get(i).getAddr().trim() + "','" + companylist.get(i).getLX().trim() + "','" + companylist.get(i).getFD().trim() + "','" + companylist.get(i).getDJJG().trim() + "','" + companylist.get(i).getDJZT().trim() + "','" + companylist.get(i).getHZRQ().trim() + "','" + companylist.get(i).getYZ().trim() + "','" + companylist.get(i).getYX().trim() + "','" + companylist.get(i).getDH().trim() + "')";

            try {
                stmt3=conn.prepareStatement(sql3);

                stmt3.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("companylist长度为"+companylist.size());
        if (companylist.size()<1){
            return "error";
        }else{
            return "";
        }
    }

    public String querybyfw(String fw) {
//        System.out.println("dao");
        List<Company2> companylist = (List<Company2>) this.template.find("from Company2 c2 where c2.FW like '%"+fw+"%'");

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
        for (int i=0;i<=companylist.size()-1;i++){
            sql3="insert into company3(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH)values('"+i+"','"+ companylist.get(i).getReg_no().trim()+"','"+companylist.get(i).getCom_name().trim()+"','"+companylist.get(i).getZB().trim()+"','"+companylist.get(i).getRQ().trim()+"','"+companylist.get(i).getFW().trim()+"','"+companylist.get(i).getAddr().trim()+"','"+companylist.get(i).getLX().trim()+"','"+companylist.get(i).getFD().trim()+"','"+companylist.get(i).getDJJG().trim()+"','"+companylist.get(i).getDJZT().trim()+"','"+companylist.get(i).getHZRQ().trim()+"','"+companylist.get(i).getYZ().trim()+"','"+companylist.get(i).getYX().trim()+"','"+companylist.get(i).getDH().trim()+"')";
            try {
                stmt3=conn.prepareStatement(sql3);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                stmt3.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("companylist长度为"+companylist.size());
        if (companylist.size()<1){
            return "error";
        }else{
            return "";
        }
    }


    public String querybygd(String gd) {
//        System.out.println("dao");
        List<Company2> companylist = (List<Company2>) this.template.find("from Company2 c2 where c2.GDTZ like '%"+gd+"%'");

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
        for (int i=0;i<=companylist.size()-1;i++){
            sql3="insert into company3(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH)values('"+i+"','"+ companylist.get(i).getReg_no().trim()+"','"+companylist.get(i).getCom_name().trim()+"','"+companylist.get(i).getZB().trim()+"','"+companylist.get(i).getRQ().trim()+"','"+companylist.get(i).getFW().trim()+"','"+companylist.get(i).getAddr().trim()+"','"+companylist.get(i).getLX().trim()+"','"+companylist.get(i).getFD().trim()+"','"+companylist.get(i).getDJJG().trim()+"','"+companylist.get(i).getDJZT().trim()+"','"+companylist.get(i).getHZRQ().trim()+"','"+companylist.get(i).getYZ().trim()+"','"+companylist.get(i).getYX().trim()+"','"+companylist.get(i).getDH().trim()+"')";
            try {
                stmt3=conn.prepareStatement(sql3);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                stmt3.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("companylist长度为"+companylist.size());
        if (companylist.size()<1){
            return "error";
        }else{
            return "";
        }
    }

    public String queryreg_no(String reg_no) {
        System.out.print("执行cdaoimpl成功");
        List<Company2> companylist = (List<Company2>) this.template.find("from Company2 c2 where c2.reg_no like '%"+reg_no+"%'");

        System.out.println(companylist.toString());
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
        for (int i=0;i<=companylist.size()-1;i++){
            sql3="insert into company3(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH)values('"+i+"','"+ companylist.get(i).getReg_no().trim()+"','"+companylist.get(i).getCom_name().trim()+"','"+companylist.get(i).getZB().trim()+"','"+companylist.get(i).getRQ().trim()+"','"+companylist.get(i).getFW().trim()+"','"+companylist.get(i).getAddr().trim()+"','"+companylist.get(i).getLX().trim()+"','"+companylist.get(i).getFD().trim()+"','"+companylist.get(i).getDJJG().trim()+"','"+companylist.get(i).getDJZT().trim()+"','"+companylist.get(i).getHZRQ().trim()+"','"+companylist.get(i).getYZ().trim()+"','"+companylist.get(i).getYX().trim()+"','"+companylist.get(i).getDH().trim()+"')";
            try {
                stmt3=conn.prepareStatement(sql3);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                stmt3.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("companylist长度为"+companylist.size());
        if (companylist.size()<1){
            return "error";
        }else{
            return "";
        }
//        if (companylist.size()<1){
//            return "error";
//        }else{
//            return "";
//        }
//        return company;
    }

    public String querybyperson(String person) {
        System.out.print("执行cdaoimpl成功");
        List<Company2> companylist = (List<Company2>) this.template.find("from Company2 c2 where c2.FD like '%"+person+"%' or c2.key_person like '%"+person+"%'" );

        System.out.println(companylist.toString());
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
        for (int i=0;i<=companylist.size()-1;i++){
            sql3="insert into company3(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH)values('"+i+"','"+ companylist.get(i).getReg_no().trim()+"','"+companylist.get(i).getCom_name().trim()+"','"+companylist.get(i).getZB().trim()+"','"+companylist.get(i).getRQ().trim()+"','"+companylist.get(i).getFW().trim()+"','"+companylist.get(i).getAddr().trim()+"','"+companylist.get(i).getLX().trim()+"','"+companylist.get(i).getFD().trim()+"','"+companylist.get(i).getDJJG().trim()+"','"+companylist.get(i).getDJZT().trim()+"','"+companylist.get(i).getHZRQ().trim()+"','"+companylist.get(i).getYZ().trim()+"','"+companylist.get(i).getYX().trim()+"','"+companylist.get(i).getDH().trim()+"')";
            try {
                stmt3=conn.prepareStatement(sql3);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                stmt3.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("companylist长度为"+companylist.size());
        if (companylist.size()<1){
            return "error";
        }else{
            return "";
        }
    }


    //局部搜索
    public String querybypart(String part) {
        System.out.print("执行dao中的Company_querybypart成功");
        List<Company3> companylist = (List<Company3>) this.template.find("from Company3 c3 where c3.com_name like '%"+part+"%'" );

        System.out.println(companylist.toString());
        sql1="DELETE FROM company4";
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
        for (int i=0;i<=companylist.size()-1;i++) {
            sql3 = "insert into company4(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH)values('" + i + "','" + companylist.get(i).getReg_no().trim() + "','" + companylist.get(i).getCom_name().trim() + "','" + companylist.get(i).getZB().trim() + "','" + companylist.get(i).getRQ().trim() + "','" + companylist.get(i).getFW().trim() + "','" + companylist.get(i).getAddr().trim() + "','" + companylist.get(i).getLX().trim() + "','" + companylist.get(i).getFD().trim() + "','" + companylist.get(i).getDJJG().trim() + "','" + companylist.get(i).getDJZT().trim() + "','" + companylist.get(i).getHZRQ().trim() + "','" + companylist.get(i).getYZ().trim() + "','" + companylist.get(i).getYX().trim() + "','" + companylist.get(i).getDH().trim() + "')";
            try {
                stmt3 = conn.prepareStatement(sql3);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            try {
                stmt3.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("companylist长度为"+companylist.size());
            if (companylist.size()<1){
                return "error";
            }else{
                return "";
            }
    }

    public String  Esubmit(String error) {


if (error.length()>4) {
    sql3="insert into error(company)values('"+error+"')";

}else {
    sql3="insert into error(person)values('"+error+"')";
}
            try {
                stmt3=conn.prepareStatement(sql3);
                stmt3.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "1";

    }


    //得到company3中的所有数据
    public ArrayList<Company2> getAll(){
            Connection conn = null;
            PreparedStatement stmt;
            ResultSet rs;
            ArrayList<Company2> list = new ArrayList<Company2>();
            try {
                {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                {
                    try {
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                String sql = "select * from company3;"; // SQL���
                assert conn != null;
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Company2 company2 = new Company2();
                    company2.setDH(rs.getString("DH"));
                    company2.setAddr(rs.getString("Addr"));
                    company2.setCom_name(rs.getString("com_name"));
                    company2.setDJJG(rs.getString("DJJG"));
                    company2.setDJZT(rs.getString("DJZT"));
                    company2.setFD(rs.getString("FD"));
                    company2.setFW(rs.getString("FW"));
                    company2.setHZRQ(rs.getString("HZRQ"));
                    company2.setLX(rs.getString("LX"));
                    company2.setReg_no(rs.getString("reg_no"));
                    company2.setRQ(rs.getString("RQ"));
                    company2.setYX(rs.getString("YX"));
                    company2.setYZ(rs.getString("YZ"));
                    company2.setZB(rs.getString("ZB"));
                    list.add(company2);
                }


                    } catch (SQLException e) {
                e.printStackTrace();
            }
        return list;
    }


    //得到company4的所有数据，用于错误时智能搜索推荐
    public ArrayList<Company2> getAllE(){
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        ArrayList<Company2> list = new ArrayList<Company2>();
        try {
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            {
                try {
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String sql = "select * from company4;"; // SQL���
            assert conn != null;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Company2 company2 = new Company2();
                company2.setDH(rs.getString("DH"));
                company2.setAddr(rs.getString("Addr"));
                company2.setCom_name(rs.getString("com_name"));
                company2.setDJJG(rs.getString("DJJG"));
                company2.setDJZT(rs.getString("DJZT"));
                company2.setFD(rs.getString("FD"));
                company2.setFW(rs.getString("FW"));
                company2.setHZRQ(rs.getString("HZRQ"));
                company2.setLX(rs.getString("LX"));
                company2.setReg_no(rs.getString("reg_no"));
                company2.setRQ(rs.getString("RQ"));
                company2.setYX(rs.getString("YX"));
                company2.setYZ(rs.getString("YZ"));
                company2.setZB(rs.getString("ZB"));
                list.add(company2);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<Brand> getAllB(String reg_no){
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        ArrayList<Brand> list = new ArrayList<Brand>();
        try {
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            {
                try {
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String sql = "select * from brand where reg_no=?;"; // SQL���

            assert conn != null;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,reg_no);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Brand brand=new Brand();
                brand.setBrand_no(rs.getString("brand_no"));
                brand.setClass_no(rs.getString("class_no"));
                brand.setDate(rs.getString("date"));
                brand.setImg_url(rs.getString("img_url"));
                brand.setReg_no(rs.getString("reg_no"));
                brand.setService(rs.getString("service"));
                list.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public ArrayList<GZ> getAllGZ(String username){
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        ArrayList<GZ> list = new ArrayList<GZ>();
        try {
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            {
                try {
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String sql = "select * from GZ where username=?;"; // SQL���
            assert conn != null;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                 GZ gz=new GZ();
                 gz.setGZ_com(rs.getString("GZ_com"));
                 gz.setGZ_RQ(rs.getString("GZ_RQ"));
                 gz.setUsername(rs.getString("username"));
                 gz.setId(rs.getString("id"));
                list.add(gz);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }




    public ArrayList<NOTE> getAllNOTE(String username){
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        ArrayList<NOTE> list = new ArrayList<NOTE>();
        try {
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            {
                try {
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            String sql = "select * from NOTE where username=?;"; // SQL���
            assert conn != null;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                NOTE note=new NOTE();
                note.setContent(rs.getString("content"));
                note.setId(rs.getString("id"));
                note.setNOTE_com(rs.getString("NOTE_com"));
                note.setNOTE_RQ(rs.getString("NOTE_RQ"));
                note.setUsername(rs.getString("username"));
                list.add(note);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    }
    //由于hiberanteTemplate已经由Spring注入，所以直接调用HibernateTemplate类的save()方法即可。







