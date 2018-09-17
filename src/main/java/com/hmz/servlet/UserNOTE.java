package com.hmz.servlet;

import com.hmz.entity.Company2;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.nutz.lang.random.R;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/UserNOTE")
public class UserNOTE extends HttpServlet {
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
        ResultSet rs1=null;

        JSONObject jsonObject4=new JSONObject();
        String RQ = request.getParameter("RQ");
        String com_name = request.getParameter("com_name");
        String content = request.getParameter("content");
        String username=request.getSession().getAttribute("user_name").toString();
//
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
int i=0;
        try {
            sql1="select * from note where username=? and NOTE_com=?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1,username);
            stmt1.setString(2,com_name);
            rs1=stmt1.executeQuery();
            while(rs1.next()){
                i=1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }

        //为1表示数据库已经有该数据
        if (i == 1) {
            try {
                sql1="update note set content=? , NOTE_RQ=? where username=? and NOTE_com=?";
                stmt1 = conn.prepareStatement(sql1);
                stmt1.setString(1,content);
                stmt1.setString(2,RQ);
                stmt1.setString(3,username);
                stmt1.setString(4,com_name);
                stmt1.executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
        }else {

//            System.out.print("NOTE" + username + com_name + RQ + content);
            try {
                sql1 = "insert into note(username,NOTE_com,NOTE_RQ,content)values ('" + username + "','" + com_name + "','" + RQ.trim() + "','" + content.trim() + "')";
                stmt1 = conn.prepareStatement(sql1);
                stmt1.executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
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
