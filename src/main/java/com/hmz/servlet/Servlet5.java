package com.hmz.servlet;

import com.hmz.entity.GD;
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
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {
    //股份占比图数据获取
    String[] arr=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        //传到前台

        response.setContentType("text/html");


        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONArray jsons = new JSONArray();
        JSONArray jsons1 = new JSONArray();
        JSONArray jsons2 = new JSONArray();
        JSONArray jsons3 = new JSONArray();

        Connection conn = null;

        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;

        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        String sql1 = null;
        String sql2 = null;
        String sql3 = null;
        String reg_no = request.getParameter("reg_no");
        Double max = 0.0;
//            ArrayList<GD> arrayList=new ArrayList<GD>();
        int j = 0;
        ArrayList<GD> li = new ArrayList<GD>();

        try {
            sql3 = "select * from ysgd where reg_no=?";

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
            stmt3 = conn.prepareStatement(sql3);
            stmt3.setString(1, reg_no);
            rs3 = stmt3.executeQuery();

            while (rs3.next()) {

                GD gd = new GD();
                gd.setGD_name(rs3.getString("GD_name"));
                gd.setGDBL(Double.parseDouble(rs3.getString("GDBL")));
                gd.setGDLX(rs3.getString("GDLX"));

                li.add(gd);
//                System.out.println(company1.toString());
//                jsonObject1.put("company1", company1);
//                jsonObject.put("FW",rs1.getString("FW"));
//                jsons.add(jsonObject1);
            }
//    jsons.add(jsonObject);
            Double sum = 0.00;
            Double ZB = null;
            for (int i = 0; i <= li.size() - 1; i++) {
                sum += li.get(i).getGDBL();
            }

            for (int i = 0; i <= li.size() - 1; i++) {
                ZB = ((Double) (li.get(i).getGDBL() / sum)) * 100;
//                System.out.println(ZB);
                if (ZB > max) {
                    max = ZB;
                    j = i;
//                    System.out.println("最大的为" + j);
                }
            }
            for (int i = 0; i <= li.size() - 1; i++) {

                li.get(i).setBL(ZB.toString());
                JSONObject jsonObject = new JSONObject();
                if (i != j) {
                    jsonObject.put("value", li.get(i).getGDBL());
                    jsonObject.put("name", li.get(i).getGD_name() + "(自然人股东)");
                    jsons1.add(jsonObject);
                } else {
                    jsonObject.put("value", li.get(i).getGDBL());
                    jsonObject.put("name", li.get(i).getGD_name() + "(大股东)");
                    jsons1.add(jsonObject);
                }
                            if (i != j) {
                    jsons2.add(li.get(i).getGD_name() + "(自然人股东)");
                            }else{
                    jsons2.add(li.get(i).getGD_name() + "(大股东)");

                            }
            }
        }

        catch (Exception ex) {
            ex.printStackTrace();

        } finally {

        }
        jsons.add(jsons2);
        jsons.add(jsons1);

        jsons.add(li.get(j).getGD_name()+"(大股东)");
        PrintWriter out = response.getWriter();
        out.print(jsons);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
