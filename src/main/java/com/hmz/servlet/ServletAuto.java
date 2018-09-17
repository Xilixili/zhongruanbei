package com.hmz.servlet;

import com.hmz.entity.Company2;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/ServletAuto")
public class ServletAuto extends HttpServlet {
    //搜索框自动补全的操作
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        //传到前台
        response.setContentType("text/html");

        request.setCharacterEncoding("UTF-8");
        String mes=request.getParameter("mes");
        String url=request.getParameter("url");
//        System.out.println("传过来的自动补全信息为"+mes+"666");
        PreparedStatement stmt2 = null;

        ResultSet rs2 = null;

        String place="||---------------||";
        Connection conn = null;
        String sql2 = null;
        JSONArray jsonArray=new JSONArray();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (url.contains("querybyname")) {

            try {
                if ((mes.trim().length() > 0)) {
                    String[] arr = null;
                    sql2 = "select * from company2 where com_name like '%' ? '%'";
                    ArrayList<String> li = new ArrayList<String>();

                    stmt2 = conn.prepareStatement(sql2);
                    stmt2.setString(1, mes);
                    rs2 = stmt2.executeQuery();
                    while (rs2.next()) {
//                Company2 company2 = new Company2();
                        if (rs2.getString("com_name").endsWith("有限责任公司")||rs2.getString("com_name").endsWith("有限公司")) {

//                            System.out.println("gongsi" + rs2.getString("com_name"));
                            jsonArray.add(rs2.getString("com_name"));
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
        }
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        if (url.contains("querybyname")) {
//
//            try {
//                if ((mes.trim().length() > 0)) {
//                    String[] arr = null;
//                    sql2 = "select * from company2 where com_name like '%' ? '%'";
//                    ArrayList<String> li = new ArrayList<String>();
//
//                    stmt2 = conn.prepareStatement(sql2);
//                    stmt2.setString(1, mes);
//                    rs2 = stmt2.executeQuery();
//                    int i=0;
//                    while (rs2.next()) {
////                Company2 company2 = new Company2();
//
////                            System.out.println("gongsi" + rs2.getString("com_name"));
//                            jsonArray.add(rs2.getString("com_name"));
//
//                    }
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            } finally {
//
//            }
//        }
        if (url.contains("querybyperson")) {

            try {
                if ((mes.trim().length() > 0)) {
                    String[] arr = null;
                    sql2 = "select * from company2 where FD like '%' ? '%'";
                    ArrayList<String> li = new ArrayList<String>();

                    stmt2 = conn.prepareStatement(sql2);
                    stmt2.setString(1, mes);
                    rs2 = stmt2.executeQuery();
                    int i=0;
                    while (rs2.next()) {
                        i++;
                        if (i<=10) {
//                Company2 company2 = new Company2();
//                        System.out.println("FD" + rs2.getString("FD"));
                            jsonArray.add(rs2.getString("com_name") + place + "法定代表人:" + rs2.getString("FD"));
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }

            try {
                if ((mes.trim().length() > 0)) {
                    String[] arr = null;
                    sql2 = "select * from company2 where key_person like '%' ? '%'";
                    ArrayList<String> li = new ArrayList<String>();

                    stmt2 = conn.prepareStatement(sql2);
                    stmt2.setString(1, mes);
                    rs2 = stmt2.executeQuery();
                    while (rs2.next()) {
                        Pattern pattern= Pattern.compile(",[\\u4e00-\\u9fa5]{0,}"+mes+"[\\u4e00-\\u9fa5]{0,}:[\\u4e00-\\u9fa5]{0,}");
                        Matcher matcher = pattern.matcher(rs2.getString("key_person"));
                        int i=0;
                        if(matcher.find()) {
                            i++;
                            if (i<=10) {
                                String string = matcher.group(0);
                                String Position = string.split(",")[1].split(":")[1];
                                String person = string.split(",")[1].split(":")[0];
                                if (rs2.getString("com_name").endsWith("有限责任公司")||rs2.getString("com_name").endsWith("有限公司")) {

                                    jsonArray.add(rs2.getString("com_name") + place + Position + ":" + person);
                                }
                            }
                        }

                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
        }
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
