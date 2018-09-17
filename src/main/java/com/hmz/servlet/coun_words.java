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
import java.util.Random;

@WebServlet("/coun_words")
public class coun_words extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        //传到前台

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        Connection conn = null;
        PreparedStatement stmt1 = null;
        JSONArray jsonArray=new JSONArray();
        JSONArray jsonArray2=new JSONArray();
        JSONArray jsonArray3=new JSONArray();
        String sql1 = null;
        ResultSet rs1=null;
        JSONObject jsonObject4=new JSONObject();
        JSONObject jsonObject3=new JSONObject();
        String province = request.getParameter("province");
//        System.out.print("KV"+province);
//ArrayList li=new ArrayList();
String s=" \"中共中央政治局\": [104.99, 36.04],\n" +
        "                        \"常务委员会\": [95.08, 44.3],\n" +
        "                        \"会议\": [123.53, 43.24],\n" +
        "                        \"听取\": [106.21, 27.35],\n" +
        "                        \"吉林长春\": [108.61, 44.57],\n" +
        "                        \"长生\": [103.58, 38.69],\n" +
        "                        \"公司\": [101.39, 47.5],\n" +
        "                        \"疫苗\": [97.53, 32.89],\n" +
        "                        \"案件\": [112.46, 31.65],\n" +
        "                        \"调查\": [95.65, 36.0],\n" +
        "                        \"问责\": [100.15, 45.99],\n" +
        "                        \"情况\": [102.89, 37.34],\n" +
        "                        \"汇报\": [98.69, 38.77],\n" +
        "                        \"中共中央\": [105.82, 35.02],\n" +
        "                        \"总书记\": [121.9, 41.05],\n" +
        "                        \"习近平\": [113.57, 41.37],\n" +
        "                        \"主持会议\": [126.32, 30.97],\n" +
        "                        \"发表\": [94.76, 47.18],\n" +
        "                        \"重要讲话\": [117.52, 46.9],\n" +
        "                        \"这起\": [100.95, 34.62],\n" +
        "                        \"发生\": [90.33, 37.6],\n" +
        "                        \"高度重视\": [108.29, 37.91],\n" +
        "                        \"作出\": [124.89, 35.73],\n" +
        "                        \"指示\": [108.42, 47.71],\n" +
        "                        \"查清\": [101.92, 28.49],\n" +
        "                        \"事实真相\": [112.78, 47.68],\n" +
        "                        \"严肃\": [108.35, 36.48],\n" +
        "                        \"依法\": [110.25, 39.51],\n" +
        "                        \"从严处理\": [118.38, 30.86],\n" +
        "                        \"守住\": [113.1, 38.09],\n" +
        "                        \"底线\": [113.0, 34.17],\n" +
        "                        \"保障\": [97.19, 34.41],\n" +
        "                        \"群众\": [90.58, 26.0],\n" +
        "                        \"切身利益\": [116.88, 32.39],\n" +
        "                        \"社会\": [98.17, 23.91],\n" +
        "                        \"稳定\": [104.51, 43.17],\n" +
        "                        \"大局\": [100.77, 32.43],\n" +
        "                        \"党\": [84.31, 39.14],\n" +
        "                        \"十八\": [104.78, 30.31],\n" +
        "                        \"健康\": [106.42, 28.41],\n" +
        "                        \"场合\": [104.57, 41.79],\n" +
        "                        \"食品安全\": [88.72, 38.85],\n" +
        "                        \"药品\": [88.55, 43.72],\n" +
        "                        \"重要性\": [105.3, 31.97],\n" +
        "                        \"一系列\": [106.65, 40.06],\n" +
        "                        \"论述\": [110.7, 32.79],\n" +
        "                        \"点击\": [116.02, 27.91],\n" +
        "                        \"一页\": [109.5, 42.9],\n" +
        "                        \"猛药\": [91.26, 34.25],\n" +
        "                        \"刮骨\": [114.8, 29.88],\n" +
        "                        \"疗毒\": [96.39, 42.43],\n" +
        "                        \"决心\": [99.32, 40.33],\n" +
        "                        \"完善\": [93.11, 30.84],\n" +
        "                        \"我国\": [117.27, 36.07],\n" +
        "                        \"管理体制\": [100.79, 41.93],\n" +
        "                        \"确保\": [107.9, 25.47],\n" +
        "                        \"各级党委\": [101.26, 44.75],\n" +
        "                        \"政府\": [113.42, 43.33],\n" +
        "                        \"义不容辞\": [109.56, 34.71],\n" +
        "                        \"之责\": [114.0, 25.86],\n" +
        "                        \"始终\": [94.57, 37.56],\n" +
        "                        \"身体健康\": [94.81, 40.81],\n" +
        "                        \"放在首位\": [117.34, 33.63],\n" +
        "                        \"生物\": [126.78, 37.85],\n" +
        "                        \"2018\": [125.32, 29.18],\n" +
        "                        \"国民\": [120.43, 25.46],\n" +
        "                        \"政策\": [116.81, 37.32],\n" +
        "                        \"提供\": [125.11, 33.55],\n" +
        "                        \"全方位\": [112.1, 28.46],\n" +
        "                        \"全\": [120.02, 45.17],\n" +
        "                        \"周期\": [90.69, 27.94],\n" +
        "                        \"服务\": [88.07, 35.42],\n" +
        "                        \"民族\": [101.26, 24.91],\n" +
        "                        \"昌盛\": [118.34, 39.73],\n" +
        "                        \"国家\": [86.51, 41.1],\n" +
        "                        \"富强\": [92.12, 36.14],\n" +
        "                        \"标志\": [83.82, 35.38],\n" +
        "                        \"深化\": [120.23, 43.85],\n" +
        "                        \"医药卫生\": [120.98, 27.9],\n" +
        "                        \"体制改革\": [105.44, 23.89],\n" +
        "                        \"建立\": [121.92, 37.69],\n" +
        "                        \"中国\": [87.08, 29.89],\n" +
        "                        \"特色\": [90.33, 32.27],\n" +
        "                        \"医疗卫生\": [96.57, 28.24],\n" +
        "                        \"制度\": [87.68, 30.9],\n" +
        "                        \"医疗保障\": [95.81, 26.73],\n" +
        "                        \"优质\": [89.72, 44.8],\n" +
        "                        \"高效\": [114.34, 26.88],\n" +
        "                        \"服务体系\": [120.43, 42.39],\n" +
        "                        \"健全\": [107.91, 30.26],\n" +
        "                        \"医院\": [92.65, 39.07],\n" +
        "                        \"管理制度\": [96.6, 29.34],\n" +
        "                        \"基层\": [94.05, 25.15],\n" +
        "                        \"全科\": [122.97, 38.86],\n" +
        "                        \"医生\": [97.76, 37.56],\n" +
        "                        \"队伍\": [109.54, 24.0],\n" +
        "                        \"建设\": [115.23, 45.31],\n" +
        "                        \"取消\": [89.74, 42.52],\n" +
        "                        \"以药\": [104.41, 25.27],\n" +
        "                        \"养医\": [87.17, 32.98],";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i=0;
        String a="";
        try {
            sql1="select * from Kwords where province=? ";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1,province);
            rs1=stmt1.executeQuery();
            while(rs1.next()){
                a=rs1.getString("key_words");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }

        String[]  a1=a.split("#");

//jsonArray1.add([104.99, 36.04];);


        for (int j=0;j<=a1.length-1;j++){
            jsonObject4.put("name",a1[j].split("/")[0]);
            jsonObject4.put("value",a1[j].split("/")[1]);
            jsonArray.add(jsonObject4);
        }


        for (int j=0;j<=a1.length-1;j++){
            JSONArray jsonArray1=new JSONArray();
                String num1=s.split("\n")[j].split(":")[1].split("\\[")[1].split("]")[0].split(",")[0];
                String num2=s.split("\n")[j].split(":")[1].split("\\[")[1].split("]")[0].split(",")[1];
//                System.out.print("num1"+num1+"num2"+num2+"hhh");
                jsonArray1.add(num1);
                jsonArray1.add(num2);

            jsonObject3.put(a1[j].split("/")[0],jsonArray1);

        }


        jsonArray3.add(jsonArray);
        jsonArray3.add(jsonObject3);
        PrintWriter out = response.getWriter();
        out.print(jsonArray3);
        out.flush();
        out.close();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
