package com.hmz.servlet;

import com.hmz.entity.User;
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

@WebServlet("/ServletUser")
public class ServletUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        //传到前台
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
System.out.print("User的username为"+username);
        PreparedStatement stmt2 = null;
        ResultSet rs2 = null;
        Connection conn = null;
        String sql2 = null;
        JSONArray jsonArray=new JSONArray();
        JSONObject json=new JSONObject();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
                String[] arr = null;
                sql2 = "select * from user1 where username =?";
                ArrayList<String> li = new ArrayList<String>();

                stmt2 = conn.prepareStatement(sql2);
                stmt2.setString(1, username);
                rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    User u=new User();
                    String Tname=rs2.getString("Tname");
                    String image_path=rs2.getString("image_path");
                    String sex=rs2.getString("sex");
                    String com=rs2.getString("com");
                    String FW=rs2.getString("FW");
                    String Uposition=rs2.getString("Uposition");
                    String Addr=rs2.getString("Addr");
                    u.setTname(Tname);
                    u.setAddr(Addr);
                    u.setCom(com);
                    u.setFW(FW);
                    u.setImage_path(image_path);
                    u.setUposition(Uposition);
                    u.setSex(sex);
                    u.setUsername(username);
                    json.put("user",u);
                    jsonArray.add(json);
                }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
