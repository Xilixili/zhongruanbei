package com.hmz.servlet;

import com.hmz.entity.Company1;
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
import java.util.Map;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//对外投资分布图数据获取
        response.setContentType("application/json;charset=UTF-8");
        //传到前台

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        //传到前台
        JSONObject json1 = new JSONObject();
//        JSONObject json2 = new JSONObject();
//        JSONObject json3 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
//        JSONArray jsonArray1=new JSONArray();


        JSONObject jsonObject1 = new JSONObject();
        JSONArray jsons = new JSONArray();


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

String province="";
        String Pro = "";
        String[] arr = {"",""};
        String reg_no = request.getParameter("reg_no");
        String com_name = request.getParameter("com_name");
//        System.out.println(reg_no);

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
//            System.out.println("servlet3 init");

            sql2 = "select * from company2 where reg_no=?";
//            ArrayList<String> li = new ArrayList<String>();
            stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, reg_no);
            rs2 = stmt2.executeQuery();

            while (rs2.next()) {
//                System.out.println("servlet3 jin le regno"+rs2.getString("DWTZ"));
                Company2 company2 = new Company2();
                company2.setCom_name(rs2.getString("com_name"));
                company2.setDWTZ(rs2.getString("DWTZ"));
                province=rs2.getString("PRO");
                String DWTZ = company2.getDWTZ();
//                company2.setFW(rs2.getString("FW"));
//                company2.setReg_no(rs2.getString("reg_no"));
                if (!(company2.getDWTZ().equals("无")) && !(company2.getDWTZ().contains("暂无相关数据")) && company2.getDWTZ().length() > 7) {

                    if (province.contains("上海")||province.contains("江苏")||province.contains("北京")||province.contains("福建")||province.contains("浙江")||province.contains("广东")||province.contains("海南")||province.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北")) {
                        DWTZ = company2.getDWTZ();
                        arr = null;
                        arr = company2.getDWTZ().split(",");
                        for (int j = 1; j <= arr.length - 1; j++) {
                            arr[j] = arr[j].split("\n")[0];
                        }

                    } else {
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
                            } else {
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
//                        arr[1]=null;
                        }
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        Map<String, Integer> map1 = new HashMap<String, Integer>();
//init map
        map1.put("北京", 0);
        map1.put("天津", 0);
        map1.put("上海", 0);
        map1.put("重庆", 0);
        map1.put("河北", 0);
        map1.put("河南", 0);
        map1.put("云南", 0);
        map1.put("辽宁", 0);
        map1.put("黑龙江", 0);
        map1.put("湖南", 0);
        map1.put("安徽", 0);
        map1.put("山东", 0);
        map1.put("新疆", 0);
        map1.put("江苏", 0);
        map1.put("浙江", 0);
        map1.put("江西", 0);
        map1.put("湖北", 0);
        map1.put("广西", 0);
        map1.put("甘肃", 0);
        map1.put("山西", 0);
        map1.put("内蒙古", 0);
        map1.put("陕西", 0);
        map1.put("吉林", 0);
        map1.put("福建", 0);
        map1.put("贵州", 0);
        map1.put("广东", 0);
        map1.put("青海", 0);
        map1.put("西藏", 0);
        map1.put("四川", 0);
        map1.put("宁夏", 0);
        map1.put("海南", 0);
        map1.put("台湾", 0);
        map1.put("香港", 0);
        map1.put("澳门", 0);
//        arr[0]=arr[0].substring(1);
        try {

            //如果存在对外投资公司的具体数据，执行查询判断省份,arr存储的是对外投资的信息
            if (arr[1].length() >= 2 || arr[0].length() >= 2) {
            //先查表看是否在表中有该公司的数据
                int x = 0;
                if (province.contains("上海")||province.contains("江苏")||province.contains("北京")||province.contains("福建")||province.contains("浙江")||province.contains("广东")||province.contains("海南")||province.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北")){
                    x = 1;
                }
                for (int i = x; i <= arr.length - 1; i++) {
                    sql1 = "select * from company2 where com_name=?";
                    stmt1 = conn.prepareStatement(sql1);
                    stmt1.setString(1, arr[i]);
                    rs1 = stmt1.executeQuery();
                    int k = 0;
                    while (rs1.next()) {
                        k++;
                        String PRO = (rs1.getString("PRO"));
                        PRO = PRO.replaceAll("\\省|\\市|\\自治区|\\特别行政区 ", "");
                        int num = map1.get(PRO);
                        num++;
                        map1.put(PRO, num);
                    }
                    //k=0表示当前对外投资在数据库中没有信息
                    if (k == 0) {
//                        System.out.println("serlet3 meiyou 具体信息" + arr[i]);
                        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                            Pro = entry.getKey();
                            int num = entry.getValue();
                            if (arr[i].contains(Pro)) {
//                                System.out.println("servelt3第二个 you");
                                num++;
                                map1.put(Pro, num);
                                k++;
                            }
                        }
                    }
                    if (k == 0) {
//                        System.out.println("servelt3第二个");
                            sql1 = "select * from dict_city";
                            sql2 = "select * from dict_province WHERE N_PROVID=?";
                            stmt1 = conn.prepareStatement(sql1);
                            rs1 = stmt1.executeQuery();
                            while (rs1.next()) {
                                 String pro_num=(rs1.getString("N_PROVID"));
                                String city_name=(rs1.getString("S_CITYNAME"));
                                city_name = city_name.replaceAll("\\区|\\市|\\自治区|\\特别行政区", "");
                                city_name = city_name.replaceAll(" ", "");
//                                System.out.println("没进去了的city_name  wei"+city_name);
                                if(arr[i].contains(city_name)){
//                                    System.out.println("进去了的city_name  wei"+city_name);
                                    stmt2=conn.prepareStatement(sql2);
                                    stmt2.setString(1,pro_num);
                                    rs2=stmt2.executeQuery();
                                    while (rs2.next()){
                                        if (k==0){
                                        pro_num=(rs2.getString("N_PROVID"));
                                       String  PROV=(rs2.getString("S_PROVNAME")).trim();
                                        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                                            String Provin = entry.getKey();
                                            PROV = PROV.replaceAll("\\省|\\市|\\自治区|\\特别行政区 ", "");
                                            if (Provin.trim().equals(PROV.trim())) {
                                                int num = entry.getValue();
                                                num++;
                                                map1.put(Provin, num);
                                                k++;
                                            }
                                        }
                                        }
                                    }
                                }
                            }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }






            //遍历当前map，将结果put到json中,传到前台
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                       //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
                         //entry.getKey() ;entry.getValue(); entry.setValue();
                         //map.entrySet()  返回此映射中包含的映射关系的 Set视图。

                        Pro= entry.getKey();
                        int num=entry.getValue();
                        if (num!=0) {
                            json1.put("name", Pro);
                            //       if (arr.length)
                            json1.put("value", num);
                            jsonArray.add(json1);
                        }
//                         System.out.println("key= " + entry.getKey() + " and value= "+ entry.getValue());
                     }

//        System.out.println("servlet3 end");
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
