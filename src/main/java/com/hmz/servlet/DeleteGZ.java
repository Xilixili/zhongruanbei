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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/DeleteGZ")
public class DeleteGZ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        //传到前台

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        Connection conn = null;
        PreparedStatement stmt1 = null;
        JSONArray jsonArray=new JSONArray();
        String sql1 = null;
        ArrayList<Company2> li = new ArrayList<Company2>();


        JSONObject jsonObject4=new JSONObject();
        String com_name = request.getParameter("com_name");
        String username=request.getSession().getAttribute("user_name").toString();
//
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.print("DeleteGZ"+username+com_name);
        try {
            sql1=" delete from gz where GZ_com=? and username=?";

            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, com_name);
            stmt1.setString(2, username);
            stmt1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }

        jsonArray.add(jsonObject4);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
