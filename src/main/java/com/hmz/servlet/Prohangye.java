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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Prohangye")
public class Prohangye extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("application/json;charset=UTF-8");
        //传到前台
        response.setContentType("text/html");

        request.setCharacterEncoding("UTF-8");


        Connection conn = null;
//搜索失败后智能推荐的数据获取
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;

        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        String sql1 = null;
        String sql2 = null;
        String sql3 = null;
        ArrayList<Company2> li = new ArrayList<Company2>();

        JSONObject json1=new JSONObject();
//        JSONObject j
        String PRO = request.getParameter("PRO");
        System.out.print(PRO);

        JSONArray jsonArray=new JSONArray();
        JSONArray jsonArray1=new JSONArray();
        JSONArray jsonArray2=new JSONArray();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] arr=null;
        try {
            sql1 = "select * from Prohangye where PRO =?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, PRO);
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                String hangye=rs1.getString("hangye");
                System.out.print(hangye);
                arr=hangye.split("#");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
        for (int i=0;i<arr.length-1;i++){
            jsonArray1.add(arr[i].split("/")[0]);
            jsonArray2.add(Integer.valueOf(arr[i].split("/")[1]));
        }
        jsonArray.add(jsonArray1);
        jsonArray.add(jsonArray2);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
