package com.hmz.servlet;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hmz.entity.Company2;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet8")
public class Servlet8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
//搜索失败后智能推荐的数据获取
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;

        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        JSONObject jsonObject1 = new JSONObject();

        String sql1 = null;
        String sql2 = null;
        String sql3 = null;
        ArrayList<Company2> li = new ArrayList<Company2>();


        String com_name = request.getParameter("com_name");
//        System.out.println("com_name为" + com_name);

        //初始化
        List<Term> termList = HanLP.segment(com_name);
//        System.out.println(termList.toString());




        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql2="DELETE FROM company4";
        try {
            stmt2=conn.prepareStatement(sql2);
            stmt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int x=0;x<=termList.size()-1;x++) {
            try {
                String[] arr = null;
                sql1 = "select * from company2 where com_name like '%' ? '%'";
                stmt1 = conn.prepareStatement(sql1);
//                System.out.println(termList.get(x).toString().split("/")[0]);
                stmt1.setString(1, termList.get(x).toString().split("/")[0]);
                rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    Company2 company2 = new Company2();
                    company2.setZB(rs1.getString("ZB"));
                    company2.setYZ(rs1.getString("YZ"));
                    company2.setYX(rs1.getString("YX"));
                    company2.setRQ(rs1.getString("RQ"));
                    company2.setReg_no(rs1.getString("reg_no"));
                    company2.setLX(rs1.getString("LX"));
                    company2.setHZRQ(rs1.getString("HZRQ"));
                    company2.setFW(rs1.getString("FW"));
                    company2.setFD(rs1.getString("FD"));
                    company2.setDJZT(rs1.getString("DJZT"));
                    company2.setDJJG(rs1.getString("DJJG"));
                    company2.setCom_name(rs1.getString("com_name"));
                    company2.setAddr(rs1.getString("Addr"));
                    company2.setDH(rs1.getString("DH"));
                    company2.setDWTZ(rs1.getString("DWTZ"));
                    company2.setJJ(rs1.getString("JJ"));
                    li.add(company2);
//                    System.out.println("智能推荐的结果为"+company2.toString());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
        }
        ArrayList<Company2> li3=new ArrayList<Company2>();
int n=0;
        for (int i = 0; i <= li.size() - 1; i++) {
            n++;
            if (li.get(i).getCom_name().endsWith("有限公司") || li.get(i).getCom_name().endsWith("有限责任公司")) {
                try {
                    sql3 = "insert into company4(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH)values ('" + i + "','" + li.get(i).getReg_no() + "','" + li.get(i).getCom_name() + "','" + li.get(i).getZB() + "','" + li.get(i).getRQ() + "','" + li.get(i).getFW() + "','" + li.get(i).getAddr() + "','" + li.get(i).getLX() + "','" + li.get(i).getFD() + "','" + li.get(i).getDJJG() + "','" + li.get(i).getDJZT() + "','" + li.get(i).getHZRQ() + "','" + li.get(i).getYZ() + "','" + li.get(i).getYX() + "','" + li.get(i).getDH() + "')";
                    stmt3 = conn.prepareStatement(sql3);
                    stmt3.executeUpdate();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                }
            } else {
                System.out.println("company2 分的nsfahfisahf公司为" + li.get(i).toString());
                li3.add(li.get(i));
            }
        }
            System.out.println("li3长度为"+li3.size()+"n  wei"+n);
            for (int j=0;j<=li3.size()-1;j++) {//company1获得的数据
                Company2 com2 = li3.get(j);
                n++;
                sql3 = "insert into company4(ID,reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH,JJ)values('" + n + "','" + com2.getReg_no() + "','" + com2.getCom_name() + "','" + com2.getZB() + "','" + com2.getRQ() + "','" + com2.getFW() + "','" + com2.getAddr() + "','" + com2.getLX() + "','" + com2.getFD() + "','" + com2.getDJJG() + "','" + com2.getDJZT() + "','" + com2.getHZRQ() + "','" + com2.getYZ() + "','" + com2.getYX() + "','" + com2.getDH() + "','" + com2.getJJ() + "')";

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
            PrintWriter out = response.getWriter();
            out.print(jsonObject1);
            out.flush();
            out.close();
        }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
