package com.hmz.servlet;

import com.hmz.entity.Company2;
import net.sf.json.JSONArray;
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

@WebServlet("/GZNOTE")
public class GZNOTE extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        //传到前台
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        JSONArray jsonArray=new JSONArray();
        String sql1 = null;
        ResultSet rs1=null;
        String sql2 = null;
        ResultSet rs2=null;

        JSONObject jsonObject4=new JSONObject();
        JSONObject jsonObject5=new JSONObject();
        String com_name = request.getParameter("com_name");
        String username=request.getSession().getAttribute("user_name").toString();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.print("DeleteGZ"+username+com_name);
        try {
            sql2=" SELECT * from gz where GZ_com=? and username=?";

            stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, com_name);
            stmt2.setString(2, username);
            rs2=stmt2.executeQuery();
            jsonObject4.put("GZ","0");
            while (rs2.next()){
                jsonObject4.put("GZ","1");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
        try {
            sql1=" SELECT * from note where NOTE_com=? and username=?";

            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, com_name);
            stmt1.setString(2, username);
            rs1=stmt1.executeQuery();
            jsonObject5.put("NOTE","0");
            while (rs1.next()){
                jsonObject5.put("NOTE","1");
                jsonObject5.put("content",rs1.getString("content"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }

        jsonArray.add(jsonObject4);
        jsonArray.add(jsonObject5);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
