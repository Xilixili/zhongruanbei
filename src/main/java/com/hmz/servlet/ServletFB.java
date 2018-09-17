package com.hmz.servlet;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
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
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/ServletFB")
public class ServletFB extends HttpServlet {
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

        JSONObject jsonObject1 = new JSONObject();

        String sql1 = null;
        String sql2 = null;
        String sql3 = null;
        ArrayList<Company2> li = new ArrayList<Company2>();

        JSONObject json1=new JSONObject();
//        JSONObject j
        String hangye = request.getParameter("hangye");
        System.out.print("servletFL"+hangye);

            JSONArray jsonArray=new JSONArray();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] arr=null;
        try {
            sql1 = "select * from hangye where hangye =?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, hangye);
//            System.out.print(hangye);
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                arr=rs1.getString("xinxi").split("#");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
        for (int i=0;i<arr.length-1;i++){
            jsonObject1.put("name",arr[i].split("/")[0]);
            jsonObject1.put("value",Integer.valueOf(arr[i].split("/")[1]));
            jsonArray.add(jsonObject1);
        }
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
