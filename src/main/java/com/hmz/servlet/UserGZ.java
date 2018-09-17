package com.hmz.servlet;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UserGZ")
public class UserGZ extends HttpServlet {
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

        String reg_no=null;
        String Addr=null;
        String FD=null;
        String province=null;
        String ZB=null;
        JSONObject jsonObject4=new JSONObject();
        String RQ = request.getParameter("RQ");
        String com_name = request.getParameter("com_name");
        String username=request.getSession().getAttribute("user_name").toString();
//
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }


                System.out.print("GZ"+username+com_name+RQ);
        try {
            sql1="insert into gz(username,GZ_com,GZ_RQ)values ('"+username+"','"+ com_name+"','"+RQ.trim()+"')";
            stmt1 = conn.prepareStatement(sql1);
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
