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

@WebServlet("/Propie")
public class Propie extends HttpServlet {
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
        JSONArray jsonArray3=new JSONArray();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] arr=null;
        String[] arr1=null;
        String[] arr2=null;
        String[] arr3=null;
        try {
            sql1 = "select * from propie where PRO =?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, PRO);
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                String xinxi=rs1.getString("xinxi");

                arr=xinxi.split("\\*");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
            arr1=arr[0].split("#");
            arr2=arr[1].split("#");
            arr3=arr[2].split("#");
        for (int i=0;i<arr1.length-1;i++){
            json1.put("name",arr1[i].split("/")[0]);
            json1.put("value",Integer.valueOf(arr1[i].split("/")[1]));
            jsonArray1.add(json1);
        }
        for (int i=0;i<arr2.length-1;i++){
            json1.put("name",arr2[i].split("/")[0]);
            json1.put("value",Integer.valueOf(arr2[i].split("/")[1]));
            jsonArray2.add(json1);
        }
        for (int i=0;i<arr3.length-1;i++){
            json1.put("name",arr3[i].split("/")[0]);
            json1.put("value",Integer.valueOf(arr3[i].split("/")[1]));
            jsonArray3.add(json1);
        }
        jsonArray.add(jsonArray1);
        jsonArray.add(jsonArray2);
        jsonArray.add(jsonArray3);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
