package com.hmz.servlet;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
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
import java.util.List;

@WebServlet("/Servlet9")
public class Servlet9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//关联图谱点击跳转到相应的公司
        response.setContentType("application/json;charset=UTF-8");
        //传到前台
        response.setContentType("text/html");

        request.setCharacterEncoding("UTF-8");
        Connection conn = null;

        PreparedStatement stmt1 = null;
        PreparedStatement stmt3 = null;

        ResultSet rs1 = null;


        JSONArray jsonArray=new JSONArray();

        String sql1 = null;
        String sql2 = null;
        String sql3 = null;
        ArrayList<Company2> li = new ArrayList<Company2>();

        String reg_no=null;
        String Addr=null;
        String FD=null;
        String province=null;
        String ZB=null;


        JSONObject jsonObject4=new JSONObject();
        String com_name = request.getParameter("com_name");
//        System.out.println("com_name为" + com_name);
        String [] arr={"",""};
        String [] array={"",""};
        String[] array1={""};
        //初始化
        List<Term> termList = HanLP.segment(com_name);
//        System.out.println(termList.toString());
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }


            try {
                sql1 = "select * from company2 where com_name =? ";
                stmt1 = conn.prepareStatement(sql1);
                stmt1.setString(1, com_name);
                rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    Company2 company2 = new Company2();
//                company2.setZB(rs1.getString("ZB"));
                    company2.setReg_no(rs1.getString("reg_no"));
                    company2.setFD(rs1.getString("FD"));
                    company2.setCom_name(rs1.getString("com_name"));
                    com_name = rs1.getString("com_name");
                    company2.setDWTZ(rs1.getString("DWTZ"));
                    company2.setGDTZ(rs1.getString("GDTZ"));
                    company2.setKey_person(rs1.getString("key_person"));
                    ZB=rs1.getString("ZB");
                    province=rs1.getString("PRO");
                    reg_no=rs1.getString("reg_no");
                    Addr=rs1.getString("Addr");
                    FD=rs1.getString("FD");
                    String DWTZ=rs1.getString("DWTZ");
                    if (!(company2.getGDTZ().equals("无")) && company2.getGDTZ().length() >= 7 && !(company2.getGDTZ().contains("暂无相关数据"))) {
                        //array[0]为空
                        String GDTZ=company2.getGDTZ();
                        if(company2.getGDTZ().contains(".,,,")){
                            GDTZ=GDTZ.split("\\.,,,")[0];
                        }
                        array=GDTZ.split("\\.,");
                        for (int j=1;j<=array.length-1;j++){
                            array[j]=array[j].split(",")[1];
                            System.out.println("jinle gudong touzi 为"+array[j]);
                        }
                    }
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
                        else if (province.contains("上海")) {
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
                    }
                    if (!(company2.getKey_person().equals("无"))&&!(company2.getKey_person().contains("暂无相关数据"))&&company2.getKey_person().length()>7) {
                        array1 = company2.getKey_person().split(",");
                        for (int j = 1; j <= array1.length - 1; j++) {
                            String person=array1[j].split(":")[0];
                            String Position=array1[j].split(":")[1];
//                        System.out.println("高管的名字为"+person);
//                        System.out.println("高管的职位为"+Position);
                            jsonObject4.put("GGPe"+String.valueOf(j), person);//从零开始
                            jsonObject4.put("GGPo"+String.valueOf(j), Position);//从零开始
                        }
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
            jsonArray.add(reg_no);
            jsonArray.add(Addr);
            jsonArray.add(com_name);
            jsonArray.add(FD);
            jsonArray.add(ZB);
            jsonArray.add(arr);
            jsonArray.add(array);
            jsonArray.add(jsonObject4);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
