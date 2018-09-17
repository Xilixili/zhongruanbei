package com.hmz.servlet;

import com.hmz.entity.Company2;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

        private static final long serialVersionUID = -360655681801936072L;

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//投资图谱数据获取
            response.setContentType("application/json;charset=UTF-8");
            //传到前台

            response.setContentType("text/html");



//            JSONArray jsons1 = new JSONArray();
//            JSONArray jsons2 = new JSONArray();

            Connection conn = null;

            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            PreparedStatement stmt3 = null;
            PreparedStatement stmt4 = null;

            ResultSet rs1 = null;
            ResultSet rs2 = null;
            ResultSet rs3 = null;
            ResultSet rs4 = null;

            String sql1 = null;
            String sql2 = null;
            String sql3 = null;
            String sql4 = null;
            String reg_no = request.getParameter("reg_no");

//            System.out.println(reg_no);
            //设置返回类型以及编码编码，否则中文会出现乱码情况
//        resp.setContentType("application/json;charset=UTF-8");
            //传到前台
            JSONObject json1 = new JSONObject();
            //最大的json
            JSONObject jsonMax = new JSONObject();
            //jsonmax下的jsonarray
            JSONArray jsonArrayMax = new JSONArray();
            JSONArray jsonArrayMax1 = new JSONArray();
            JSONArray jsonArrayMax2 = new JSONArray();

            JSONObject jsonMax1 = new JSONObject();
            JSONObject jsonMax2 = new JSONObject();
            JSONObject json2 = new JSONObject();
            JSONObject json3 = new JSONObject();
            JSONObject json4 = new JSONObject();


            String com_name=null;
String province="";
String prov="";

            JSONObject json11 = new JSONObject();
            JSONObject json12 = new JSONObject();
            JSONObject json13 = new JSONObject();
//            JSONObject json14 = new JSONObject();

            String  value="1";
            JSONArray JArray=new JSONArray();//总的children

            JSONObject json61 = new JSONObject();
            JSONArray jsonArray=new JSONArray();//总的children
            JSONArray jsonArray1=new JSONArray();
//            JSONArray jsonArray2=new JSONArray();
//            JSONArray jsonArray3=new JSONArray();

//            JSONArray jsonArray6=new JSONArray();
//            JSONArray jsonArray7=new JSONArray();


            ArrayList<String> list=new ArrayList<String>();
//        String com_name=null;

//
//

//        jsonArray.add(json7);
//        jsonArray.add(json1);

            JSONObject json = new JSONObject();

//        json.put("name","felx");



//        JsonArray jsonArray;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String [] arr={"",""};
            //array存到的是股东的
            String [] array={"",""};

//得到当前公司的对外投资信息并存入arr中
            try {
                sql2 = "select * from company2 where reg_no=?";
                ArrayList<String> li = new ArrayList<String>();

                stmt2 = conn.prepareStatement(sql2);
                stmt2.setString(1, reg_no);
                rs2 = stmt2.executeQuery();
                String DD=null;
                while (rs2.next()) {
                    Company2 company2 = new Company2();
//                company2.setZB(rs1.getString("ZB"));
                    company2.setReg_no(rs2.getString("reg_no"));
                    company2.setFD(rs2.getString("FD"));
                    company2.setCom_name(rs2.getString("com_name"));
                    com_name = rs2.getString("com_name");
                    company2.setDWTZ(rs2.getString("DWTZ"));
                    company2.setGDTZ(rs2.getString("GDTZ"));
                    province=rs2.getString("PRO");
                    String DWTZ=rs2.getString("DWTZ");
                    //添加主公司名字
                    jsonMax.put("name",company2.getCom_name());//最终返回的json
//                    System.out.println("jinle arr 主公司gudong touzi 为"+company2.getGDTZ());
                    //array存的是股东投资的数据
                    if (!(company2.getGDTZ().equals("无")) && company2.getGDTZ().length() >= 7 && !(company2.getGDTZ().contains("暂无相关数据"))) {
                        //array[0]为空
                        if (!(province.contains("江苏")||province.contains("北京")||province.contains("福建")||province.contains("浙江")||province.contains("广东")||province.contains("海南")||province.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北"))){
                            String GDTZ = company2.getGDTZ();
                            if (company2.getGDTZ().contains(".,,,")) {
                                GDTZ = GDTZ.split("\\.,,,")[0];
                            }
                            array = GDTZ.split("\\.,");
                            for (int j = 1; j <= array.length - 1; j++) {
                                array[j] = array[j].split(",")[1];
//                                System.out.println("jinle gudong touzi 为" + array[j]);
                            }
                    }else {
                            String GDTZ = company2.getGDTZ();
                            if (company2.getGDTZ().contains(".,")) {
                                array = GDTZ.split("\\.,");
                                for (int j = 0; j <= array.length - 1; j++) {
                                    if (j==0) {
                                        array[j] = array[j].split(",")[2];
                                    }else {
                                        array[j] = array[j].split(",")[1];
                                    }

                                }
                        }else {
                            array=GDTZ.split(",货币,");
                            array[0]=array[0].split(",")[2];
                            }
                        }
                    }else{
//                        System.out.println("进了第一个else, 没有股东信息");
                        //主公司没有股东信息
                        jsonMax2.put("name","股东");
                        jsonMax2.put("value",value);
                        jsonArrayMax.add(jsonMax2);
                    }


                    //arr存的是主对外投资的数据
                        if (!(company2.getDWTZ().equals("无")) && company2.getDWTZ().length() >= 7 && !(company2.getDWTZ().contains("暂无相关数据"))) {
                        if (!(province.contains("上海")||province.contains("江苏")||province.contains("北京")||province.contains("福建")||province.contains("浙江")||province.contains("广东")||province.contains("海南")||province.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北"))) {
                            DWTZ = company2.getDWTZ();
                            if (DWTZ.contains(".,")) {
                                arr = null;
                                arr = company2.getDWTZ().split("\\.,");
                                if (arr[0].contains(",·")) {
                                    for (int j = 0; j <= arr.length - 1; j++) {
                                        if (j == 0) {
                                            arr[j] = arr[j].split(",")[1];
                                        } else {
                                            arr[j] = arr[j].split(",")[0];
                                        }
                                    }
                                }else {
                                    for (int j = 0; j <= arr.length - 1; j++) {
                                        if (j == 0) {
                                            arr[j] = arr[j].split("·")[0].split(",")[1];
                                        } else {
                                            arr[j] = arr[j].split("·")[0];
                                        }
                                    }
                                }
                            } else {
                                arr[0] = DWTZ.split(",")[1];
                            }
                        }
                        else if (province.contains("上海")||province.contains("江苏")||province.contains("北京")||province.contains("福建")||province.contains("浙江")||province.contains("广东")||province.contains("海南")||province.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北")) {
                            DWTZ = company2.getDWTZ();
                            arr = null;
                            arr = company2.getDWTZ().split(",");
                            for (int j = 1; j <= arr.length - 1; j++) {
                                arr[j] = arr[j].split("\n")[0];
//                                System.out.println("diyige arr[j]:"+arr[j]);
                            }
                        }
                            else  {
                                DWTZ = company2.getDWTZ();
                                if (DWTZ.contains(".,")) {
                                    arr = null;
                                    arr = company2.getDWTZ().split("\\.,");
                                    if (arr[0].contains(",·")) {
                                        for (int j = 0; j <= arr.length - 1; j++) {
                                            if (j == 0) {
                                                arr[j] = arr[j].split(",")[1];
                                            } else {
                                                arr[j] = arr[j].split(",")[0];
                                            }
                                        }
                                    }else {
                                        for (int j = 0; j <= arr.length - 1; j++) {
                                            if (j == 0) {
                                                arr[j] = arr[j].split("·")[0].split(",")[1];
                                            } else {
                                                arr[j] = arr[j].split("·")[0];
                                            }
                                        }
                                    }
                                } else {
                                    arr[0] = DWTZ.split(",")[1];
                                }
                            }
                    }else {
                        System.out.println("servlet2 进了第二个else,没有对外投资信息");
                        //主公司没有对外投资信息
                    jsonMax1.put("name","对外投资");
                    jsonMax1.put("value",value);
                    jsonArrayMax.add(jsonMax1);
                    }
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            } finally {
            }



            String [] arr1={" # "};
                //因为数据结构不同，加以区别
            try {
                //arr1存的是第二级的对外投资，即住公司对外的继续投资
                int x=0;
            if (province.contains("上海")||province.contains("江苏")||province.contains("北京")||province.contains("福建")||province.contains("浙江")||province.contains("广东")||province.contains("海南")||province.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北")){
                x=1;
            }
//                遍历当前对外投资的公司,if用来判断arr中是否有数据
                if (arr[1].length()>2||arr[0].length()>2) {
                    for (int i = x; i <= arr.length - 1; i++) {
                        //找出arr中的对外投资公司的对外投资
                        sql4 = "select * from company2 where com_name=?";
                        stmt4 = conn.prepareStatement(sql4);
                        stmt4.setString(1, arr[i]);
                        rs4 = stmt4.executeQuery();
                        System.out.println("servlet2 cishi DWTZ  wei"+arr[i]);
                        int k=0;
                        while (rs4.next()) {
//                            System.out.println("k de zhi wei "+k+"当前第一级对外投资 wei "+arr[i]);
                            JSONArray jsonArray2=new JSONArray();
                            k++;
                            Company2 company2=new Company2();
                            company2.setReg_no(rs4.getString("reg_no"));
                            company2.setFD(rs4.getString("FD"));
                            company2.setCom_name(rs4.getString("com_name"));
                            company2.setDWTZ(rs4.getString("DWTZ"));
                            company2.setGDTZ(rs4.getString("GDTZ"));
                            String DWTZ=rs4.getString("DWTZ");
                            prov=rs4.getString("PRO");
                            if (!(company2.getDWTZ().equals("无")) && company2.getDWTZ().length() >= 7 && !(company2.getDWTZ().contains("暂无相关数据"))) {
                                 if (prov.contains("上海")||prov.contains("江苏")||prov.contains("北京")||prov.contains("福建")||prov.contains("浙江")||prov.contains("广东")||prov.contains("海南")||prov.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北")) {
                                    DWTZ = company2.getDWTZ();
                                    arr1 = null;
                                    arr1 = company2.getDWTZ().split(",");
                                    for (int j = 1; j <= arr.length - 1; j++) {
                                        arr1[j] = arr1[j].split("\n")[0];
//                                        System.out.println("diyige arr1[j]:"+arr1[j]);
                                    }
                                    for (int j = 1; j <= arr1.length - 1; j++) {
                                        json.put("name", arr1[j]);
                                        json.put("value", value);
                                        jsonArray2.add(json);
                                    }
                                    json1.put("name", arr[i]);
                                    json1.put("children", jsonArray2);
//                                jsonArray2 = null;
                                    jsonArrayMax1.add(json1);
//                                    jsonArray2 = null;
                                }
                                else {
                                    DWTZ = company2.getDWTZ();
                                    if (DWTZ.contains(".,")) {
                                        arr1 = null;
                                        arr1 = company2.getDWTZ().split("\\.,");
                                        if (arr1[0].contains(",·")) {
                                            for (int j = 0; j <= arr1.length - 1; j++) {
                                                if (j == 0) {
                                                    arr1[j] = arr1[j].split(",")[1];
                                                } else {
                                                    arr1[j] = arr1[j].split(",")[0];
                                                }
                                            }
                                        }else {
                                            for (int j = 0; j <= arr1.length - 1; j++) {
                                                if (j == 0) {
                                                    arr1[j] = arr1[j].split("·")[0].split(",")[1];
                                                } else {
                                                    arr1[j] = arr1[j].split("·")[0];
                                                }
                                            }
                                        }
                                    } else {
                                        arr1[0] = DWTZ.split(",")[1];
                                    }
//                                    JSONArray jsonArray2=new JSONArray();
                                    //arr1存的是第一级对外投资的信息
                                    for (int j = 0; j <= arr1.length - 1; j++) {
                                        json.put("name", arr1[j]);
                                        json.put("value", value);
                                        jsonArray2.add(json);
                                        System.out.println("servlet2 DWTZ也有DWTZ"+arr1[j]);
                                    }
                                    json1.put("name", arr[i]);
                                    json1.put("children", jsonArray2);
//                                jsonArray2 = null;
                                    jsonArrayMax1.add(json1);
//                                     System.out.println("jsonarray1 wei you"+jsonArrayMax1.toString());

//                                    jsonArray2 = null;
                                }
                            }
                            //当前第一级的对外投资公司没有下一级,jsonArray代表第二个[
                            else {
                                //有第一级公司的信息但是没有DWTZ
//                                System.out.println(arr[i]+"没有对外投资");
                                json.put("name", arr[i]);
                                json.put("value", value);
                                jsonArrayMax1.add(json);
//                                System.out.println("jsonarray1 wei"+jsonArrayMax1.toString());
                            }
                        }
                        //没有当前第一级投资公司的信息
                        if(k==0){
                            System.out.println(arr[i]+"servlet2 没有相关信息");
                            json.put("name", arr[i]);
                            json.put("value", value);
                            jsonArrayMax1.add(json);
                        }
                    }
                    jsonMax1.put("name","对外投资");
                    jsonMax1.put("children",jsonArrayMax1);
                    jsonArrayMax.add(jsonMax1);
                }else {
                //主公司没有对外投资
//                System.out.println("arr中没有数据"+arr[0]+arr[1]);

                }

            }catch (Exception ex) {
                ex.printStackTrace();
            }finally {

            }


//            String [] array={"",""};
            //因为数据结构不同，加以区别
            try {
                //找出股东对外的投资
                int x=0;
                if (!(province.contains("江苏")||province.contains("北京")||province.contains("福建")||province.contains("浙江")||province.contains("广东")||province.contains("海南")||province.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北"))){
                    x=1;
                }
                if (array[x].length()>=2) {
                    for (int i = x; i <= array.length - 1; i++) {
//                        System.out.println("array[i]  wei"+array[i]);
                        sql4 = "select * from ysgd where GD_name=?";
                        stmt4 = conn.prepareStatement(sql4);
                        stmt4.setString(1, array[i]);
                        rs4 = stmt4.executeQuery();
                        int k=0;
                        JSONArray jsonArray3=new JSONArray();
//                        jsonArray3=null;
                        while (rs4.next()) {
                            k++;
//                            System.out.println("k zhi wei"+k);
                            GD gd=new GD();
                            gd.setCom_name(rs4.getString("com_name"));
                            //判断是否含有对外投资的数据
                            if (!(gd.getCom_name().trim().equals(com_name.trim()))) {
//                                System.out.println("com_name wei"+com_name);
//                                System.out.println("股东也有自己的对外投资"+gd.getCom_name());
                                json3.put("name",gd.getCom_name());
                                json3.put("value", value);
                                jsonArray3.add(json3);
                            }
                        }
                        if (k!=0) {
                            json2.put("name", array[i]);
                            json2.put("children", jsonArray3);
                            jsonArrayMax2.add(json2);
                        }
                        if(k==0){
//                            System.out.println("股东meiyou自己的对外投资"+array[i]);
//                            System.out.println(array[i]+"没有相关信息");
                            json2.put("name", array[i]);
                            json2.put("value", value);
                            jsonArrayMax2.add(json2);
                        }
                    }
                    jsonMax2.put("name","股东");
                    jsonMax2.put("children",jsonArrayMax2);
                    jsonArrayMax.add(jsonMax2);
                }else {

//                    System.out.println("array中没有数据"+array[0]+array[1]);
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            } finally {
            }


//            // 一个未转化的字符串
//            // 首先把字符串转成 JSONArray  对象
//            if(jsonArray1.size()>0){
//                for(int i=0;i<json.size();i++){
//                    // 遍历 jsonarray 数组，把每一个对象转成 json 对象
//                    JSONObject job = json.getJSONObject(i);
//// 得到 每个对象中的属性值
//                    System.out.println(job.get("name")+"=") ;
//                }
//            }


            jsonMax.put("children",jsonArrayMax);
            PrintWriter out = response.getWriter();
            out.print(jsonMax);
            out.flush();
            out.close();
        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
