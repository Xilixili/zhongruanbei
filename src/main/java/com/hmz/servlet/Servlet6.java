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
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

@WebServlet("/Servlet6")
public class Servlet6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //疑似实际控股人数据的获取

        response.setContentType("application/json;charset=UTF-8");
       String com_name=request.getParameter("com_name");
        JSONArray jsonArray=new JSONArray();
        JSONArray jsonArray1=new JSONArray();
        JSONArray jsonArray2=new JSONArray();
        JSONObject json1 = new JSONObject();

        JSONObject json2 = new JSONObject();

        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;

        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        String sql1 = null;
        String sql2 = null;
        String sql3 = null;
        Connection conn=null;
        String SJ=null;
        ArrayList<GD> lis=new ArrayList<GD>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //找出所有股东
        sql1="select * from ysgd where com_name=?";
        try {
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, com_name.trim());
            rs1 = stmt1.executeQuery();
            ArrayList<GD> li=new ArrayList<GD>();
            while (rs1.next()){
                GD gd=new GD();
                gd.setGD_name(rs1.getString("GD_name"));
                gd.setGDBL(Double.parseDouble(rs1.getString("GDBL")));
                gd.setGDLX(rs1.getString("GDLX"));
                li.add(gd);
            }

            Double sum = 0.00;
            Double BL=null;
            Double max=0.00;
            int j=0;
            for (int i=0;i<=li.size()-1;i++){
                    sum+=li.get(i).getGDBL();
                }
                for (int i=0;i<=li.size()-1;i++){
                    if (li.get(i).getGDBL()>max){
                        max=li.get(i).getGDBL();
                        j=i;
//                        System.out.println("j变化为"+j);
                    }
                DecimalFormat df = new DecimalFormat("0.0");
                BL=((Double)(li.get(i).getGDBL()/sum))*100;
                li.get(i).setBL(df.format(BL));
            }
//           System.out.println("汉字的长度为"+li.get(j).getGD_name().length()+li.get(j).getGD_name());
            if (li.get(j).getGD_name().length()<5){
                json1.put("name",li.get(j).getGD_name());
                json1.put("category",2);
                json1.put("draggable",true);
                jsonArray1.add(json1);
                json1.put("name",com_name);
                json1.put("category",1);
                json1.put("draggable",true);
                jsonArray1.add(json1);
                json1.put("source",li.get(j).getGD_name());
                json1.put("target",com_name);
                json1.put("value",li.get(j).getBL()+"%");
                jsonArray2.add(json1);
            }else {//包含公司
//                System.out.println("我已经包含公司了");
                sql2="select * from ysgd where com_name=?";
                //找出当前公司的具体信息
                stmt2 = conn.prepareStatement(sql2);
                stmt2.setString(1, li.get(j).getGD_name());
                rs2 = stmt2.executeQuery();

                while (rs2.next()){
                    GD gd=new GD();
                    gd.setGD_name(rs2.getString("GD_name"));
                    gd.setGDBL(Double.parseDouble(rs2.getString("GDBL")));
                    gd.setGDLX(rs2.getString("GDLX"));
                    lis.add(gd);
                }
                int j1 = 0;//j1表示投资额最大的股东
                if (lis.size()>0) {
//                    System.out.println("更牛逼的公司股东是" + lis.toString());
                    Double sum1 = 0.00;
                    Double BL1 = null;
                    Double max1 = 0.00;
                    for (int i = 0; i <= lis.size() - 1; i++) {
                        sum1 += lis.get(i).getGDBL();
//                        System.out.println("sum 为" + sum1);
                    }
                    for (int i = 0; i <= lis.size() - 1; i++) {
                        if (lis.get(i).getGDBL() > max1) {
                            max1 = lis.get(i).getGDBL();
                            j1 = i;
                        }
                    }

                    DecimalFormat df = new DecimalFormat("0.0");
                    BL1 = ((Double) (lis.get(j1).getGDBL() / sum1)) * 100;
                    lis.get(j1).setBL(df.format(BL1));
                }
//                BL1=lis.get(j1).getGDBL()/sum1;
//                System.out.println(BL1);
//                lis.get(j1).setBL(String.valueOf(BL1));
//                System.out.println("汉字的长度为"+lis.get(j1).getGD_name().length()+lis.get(j1).getGD_name());
//                if (lis.get(j1).getGD_name()){
//
                    //建立公司的第一个最大投资股东的对象
                    json1.put("name",li.get(j).getGD_name());
                    json1.put("category",0);
                    json1.put("draggable",true);
                    jsonArray1.add(json1);
                    //建立当前公司的对象
                    json1.put("name",com_name);
                    json1.put("category",1);
                    json1.put("draggable",true);
                    jsonArray1.add(json1);

                    //连接当前公司以及第一个最大投资额
//                    System.out.println(jsonArray1.toString());
                    json1.put("source",li.get(j).getGD_name());
                    json1.put("target",com_name);
                    json1.put("value",li.get(j).getBL()+"%");
                    jsonArray2.add(json1);
                    if (lis.size()>0) {
                        json1.put("name", lis.get(j1).getGD_name());
                        json1.put("category", 2);
                        json1.put("draggable", true);
                        jsonArray1.add(json1);
                        json1.put("source", lis.get(j1).getGD_name());
                        json1.put("target", li.get(j).getGD_name());
                        json1.put("value", lis.get(j1).getBL() + "%");
                        jsonArray2.add(json1);
                    }
//                    json1.put("source",lis.get(j1).getGD_name());
//                    json1.put("target",com_name);
////                    System.out.println();
//                    json1.put("value",String.valueOf(Double.parseDouble(lis.get(j1).getBL())*Double.parseDouble(li.get(j).getBL())/10000)+"%");
//                    jsonArray2.add(json1);
//                    System.out.println(jsonArray2.toString());
//                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {

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
