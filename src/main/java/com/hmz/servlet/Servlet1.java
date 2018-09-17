package com.hmz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonArray;
//import com.mysql.cj.xdevapi.JsonArray;
import com.hmz.entity.Company2;
import com.hmz.entity.GD;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {

    private static final long serialVersionUID = -360655681801936072L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //企业图谱数据获取
        response.setContentType("application/json;charset=UTF-8");
        //传到前台

        response.setContentType("text/html");


        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONArray jsons = new JSONArray();
        JSONArray jsons1 = new JSONArray();
        JSONArray jsons2 = new JSONArray();

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

//        System.out.println(reg_no);
        //设置返回类型以及编码编码，否则中文会出现乱码情况
//        resp.setContentType("application/json;charset=UTF-8");
        //传到前台
        JSONObject json1 = new JSONObject();
        JSONObject json2 = new JSONObject();
        JSONObject json3 = new JSONObject();
        JSONObject json4 = new JSONObject();
        JSONObject json5 = new JSONObject();
        JSONObject json6 = new JSONObject();
        JSONObject json61 = new JSONObject();
        JSONObject json23 = new JSONObject();


        JSONObject json11 = new JSONObject();
        JSONObject json12 = new JSONObject();
        JSONObject json13 = new JSONObject();
        JSONObject json14 = new JSONObject();
        JSONObject jsonMax1 = new JSONObject();
        JSONObject jsonMax = new JSONObject();


//        JSONObject json61 = new JSONObject();//
        JSONArray jsonArray=new JSONArray();
        JSONArray jsonArray1=new JSONArray();
        JSONArray jsonArray2=new JSONArray();
        JSONArray jsonArray3=new JSONArray();
        JSONArray jsonArray4=new JSONArray();
        JSONArray jsonArray5=new JSONArray();
        JSONArray jsonArray6=new JSONArray();
        JSONArray jsonArrayMax=new JSONArray();
        JSONArray jsonArrayMax1=new JSONArray();
        JSONArray jsonArrayMax2=new JSONArray();
        JSONArray jsonArrayMax3=new JSONArray();
        JSONArray jsonArray7=new JSONArray();
String value="1";
String province="";

//        String com_name=null;

//
//



        JSONObject json = new JSONObject();

//        json.put("name","felx");



//        JsonArray jsonArray;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String com_name=null;
        String [] arr={""};
        String [] array={""};
        String [] array1={""};
        try {
            sql2 = "select * from company2 where reg_no=?";
            ArrayList<String> li = new ArrayList<String>();

            stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, reg_no);
            rs2 = stmt2.executeQuery();
            while (rs2.next()) {
                Company2 company2 = new Company2();
//                company2.setZB(rs1.getString("ZB"));
                company2.setReg_no(rs2.getString("reg_no"));
                company2.setFD(rs2.getString("FD"));
                company2.setCom_name(rs2.getString("com_name"));
                 com_name = rs2.getString("com_name");
                company2.setDWTZ(rs2.getString("DWTZ"));
                company2.setKey_person(rs2.getString("key_person"));
                company2.setGDTZ(rs2.getString("GDTZ"));
                String DWTZ=rs2.getString("DWTZ");
                String FD=rs2.getString("FD");
                json61.put("name",FD);
                json61.put("value",value);
                jsonArray6.add(json61);
                province=rs2.getString("PRO");
                //添加主公司名字
                jsonMax.put("name",company2.getCom_name());//最终返回的json
//                System.out.println("jinle arr 主公司GG为"+company2.getKey_person());

                if (!(company2.getKey_person().equals("无")) && company2.getKey_person().length() >= 4 && !(company2.getKey_person().contains("暂无相关数据"))) {

                    if (province.contains("江苏")||province.contains("北京")||province.contains("福建")||province.contains("浙江")||province.contains("广东")||province.contains("海南")||province.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北")) {

                        String key_person=company2.getKey_person();
                        if (key_person.contains(",,")){
                            key_person=key_person.replaceAll(",,",",");
                        }
                        if (key_person.contains(",,")){
                            key_person=key_person.replaceAll(",,",",");
                        }
                        if (key_person.contains(",,")){
                            key_person= key_person.replaceAll(",,",",");
                        }
                        key_person=key_person.replaceAll("(\\n\\s)", "\n");
                        System.out.println("servletdao  replaceall后的key"+key_person);

                        array1 = key_person.split(",");
                        for (int j = 1; j <= array1.length - 1; j++) {

                            array1[j] = array1[j].split("\n")[0];
                            json13.put("name", array1[j]);
                            json13.put("value", value);
//                        System.out.println("servlet1 de GG wei "+array1[j]);
                            jsonArrayMax3.add(json13);
                        }
                    }else{
                        array1 = company2.getKey_person().split(",");
                    for (int j = 1; j <= array1.length - 1; j++) {
                        array1[j] = array1[j].split(":")[0];
                        json13.put("name", array1[j]);
                        json13.put("value", value);
//                        System.out.println("servlet1 de GG wei "+array1[j]);
                        jsonArrayMax3.add(json13);
                    }
                }
                    json3.put("name","高管");
                    json3.put("children",jsonArrayMax3);
                }else{
//                    System.out.println("进了第一个else");
                    //主公司没有股东信息
                    json3.put("name","高管");
                    json3.put("value",value);
//                    jsonArrayMax.add(jsonMax1);
                }

                    if (!(company2.getGDTZ().equals("无")) && company2.getGDTZ().length() >= 7 && !(company2.getGDTZ().contains("暂无相关数据"))) {
                    //array[0]为空
                    array=company2.getGDTZ().split("\\.,");
                    for (int j=1;j<=array.length-1;j++){
                        array[j]=array[j].split(",")[1];
                        json12.put("name",array[j]);
                        json12.put("value",value);
//                        System.out.println("servlet1 de gudong wei "+array[j]);
                        jsonArrayMax2.add(json12);
                    }
                    json1.put("name","股东");
                    json1.put("children",jsonArrayMax2);
                }else{
//                    System.out.println("进了第一个else");
                    //主公司没有股东信息
                    json1.put("name","股东");
                    json1.put("value",value);
//                    jsonArrayMax.add(jsonMax1);
                }

                if (!(company2.getDWTZ().equals("无")) && company2.getDWTZ().length() >= 7 && !(company2.getDWTZ().contains("暂无相关数据"))) {

                        if (province.contains("上海")||province.contains("江苏")||province.contains("北京")||province.contains("福建")||province.contains("浙江")||province.contains("广东")||province.contains("海南")||province.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北")) {
                        DWTZ = company2.getDWTZ();
                        arr = null;
                        arr = company2.getDWTZ().split(",");
                        for (int j = 1; j <= arr.length - 1; j++) {
                            arr[j] = arr[j].split("\n")[0];
//                            System.out.println("diyige arr[j]:"+arr[j]);
                            json11.put("name", arr[j]);
                            json11.put("value", value);
                            jsonArrayMax1.add(json11);
                        }
                    }
                    else {
                        DWTZ = company2.getDWTZ();
                        if (DWTZ.contains(".,")) {
                            arr = null;
                            arr = company2.getDWTZ().split("\\.,");
                            for (int j = 0; j <= arr.length - 1; j++) {
                                if (j == 0) {
                                    arr[j] = arr[j].split(",")[1];
                                } else {
                                    arr[j] = arr[j].split(",")[0];
                                }
                                json11.put("name", arr[j]);
                                json11.put("value", value);
                                jsonArrayMax1.add(json11);
                            }

                        } else {
                            arr[0] = DWTZ.split(",")[1];
                            json11.put("name", arr[0]);
                            json11.put("value", value);
                            jsonArrayMax1.add(json11);
                        }
                    }
                    json2.put("name","对外投资");
                    json2.put("children",jsonArrayMax1);
                }else {
//                    System.out.println("进了第二个else");
                    //主公司没有对外投资信息
                    json2.put("name","对外投资");
                    json2.put("value",value);
                }
                //添加当前主公司的名字
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }






//        json3.put("name","高管");
//        json3.put("children",jsonArray3);

        json4.put("name","法院公告");
        json4.put("children",jsonArray4);

        json5.put("name","裁判文书");
        json5.put("children",jsonArray5);

        json6.put("name","法人/负责人");
        json6.put("children",jsonArray6);

        jsonArray.add(json1);
        jsonArray.add(json2);
        jsonArray.add(json3);

        jsonArray.add(json4);
        jsonArray.add(json5);
        jsonArray.add(json6);
        json.put("name",com_name);
        json.put("children",jsonArray);
//        System.out.println(json);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }
}
