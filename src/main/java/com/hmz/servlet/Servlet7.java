package com.hmz.servlet;

import com.hmz.entity.Company2;
import com.hmz.entity.GD;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//import org.stringtemplate.v4.ST;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String com_name=request.getParameter("com_name");
        //传到前台
        //关联图谱数据的获取
        System.out.println("servlet7");
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

        //存的是直接的股东投资信息
        ArrayList<GD> gd_list=new ArrayList<GD>();
        ArrayList<String> GG_list=new ArrayList<String>();
        //用来找出高管在外的任职
        ArrayList<String> GG1_list=new ArrayList<String>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONObject json2 = new JSONObject();

        JSONObject json4 = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        JSONArray jsonArray1=new JSONArray();
        JSONArray jsonArray2=new JSONArray();

        //用来判断是否创建重复对象
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("1");
        arrayList.add(com_name);

        json2.put("name", com_name);
        json2.put("category",0);
        json2.put("draggable", true);
        //添加公司对象
        jsonArray1.add(json2);

String province="";
        try {
//找出直接股东的信息
            sql1="select * from ysgd where com_name=?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, com_name.trim());
            rs1 = stmt1.executeQuery();
            while (rs1.next()){
                GD gd =new GD();
                gd.setGD_name(rs1.getString("GD_name"));
                gd.setGDLX(rs1.getString("GDLX"));
                gd_list.add(gd);
//                arrayList.add(gd.getGD_name());
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
//
//            }else {

//            }
            String[] arr={"",""};
            String FD="";
//        json4.put("source",com_name);
            sql3="select * from company2 where com_name=?";
            try {
                stmt3 = conn.prepareStatement(sql3);
                stmt3.setString(1,com_name);
                rs3 = stmt3.executeQuery();

                while (rs3.next()) {
                    Company2 company2 = new Company2();
                    company2.setDWTZ(rs3.getString("DWTZ"));
                    company2.setKey_person(rs3.getString("key_person"));
                    FD=rs3.getString("FD");
                    String DWTZ = rs3.getString("DWTZ");
                    province=rs3.getString("PRO");

                    if (!(company2.getKey_person().equals("无")) && !(company2.getKey_person().contains("暂无相关数据")) && company2.getKey_person().length() > 7) {
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
                            //移除空行
                            key_person=key_person.replaceAll("(\\n\\s)", "\n");


                            String[] array = key_person.split(",");


                            for (int j = 1; j <= array.length - 1; j++) {
                                if (array[j].contains("\n")) {
                                String person = array[j].split("\n")[0];
                                String Position = array[j].split("\n")[1];
                                //GG_list的存储格式为高管，高管的职位
                                GG_list.add(person + "," + Position);
                                GG1_list.add(person);
                                System.out.println("servlet2 的GG_list内容为" + GG_list.toString());

                                if (!arrayList.toString().contains(person)) {
                                    json2.put("name", person);
                                    json2.put("category", 2);
                                    json2.put("draggable", true);
                                    jsonArray1.add(json2);
                                }
                                json4.put("source", person);
                                json4.put("target", com_name);
                                //判断是否为法定代表人
                                if (person.equals(FD)) {
                                    json4.put("value", "法定代表人" + "," + Position);
                                } else {
                                    json4.put("value", Position);
                                }
                                jsonArray2.add(json4);
                                arrayList.add(person);
                            }else {
                                    String person = array[j];
                                    String Position = array[(j+1)].split("\n")[1];

                                    //GG_list的存储格式为高管，高管的职位
                                    GG_list.add(person + "," + Position);
                                    GG1_list.add(person);
//                                    System.out.println("servlet2 的GG_list内容为" + GG_list.toString());

                                    if (!arrayList.toString().contains(person)) {

                                        json2.put("name", person);
                                        json2.put("category", 2);
                                        json2.put("draggable", true);
                                        jsonArray1.add(json2);
                                    }
                                    json4.put("source", person);
                                    json4.put("target", com_name);
                                    //判断是否为法定代表人
                                    if (person.equals(FD)) {
                                        json4.put("value", "法定代表人" + "," + Position);
                                    } else {
                                        json4.put("value", Position);
                                    }
                                    jsonArray2.add(json4);
                                    arrayList.add(person);
                                }

                            }


                        } else{
                            //,凌人枫:董事,丁友建:董事,刘军:董事,陈勇明:董事,王建华:董事,刘军:董事长,王国胜:董事,吴俊福:董事,陆东:
                            String[] array = company2.getKey_person().split(",");
                        for (int j = 1; j <= array.length - 1; j++) {
                            String person = array[j].split(":")[0];
                            String Position = array[j].split(":")[1];
//                            System.out.println("高管的名字为" + person);
//                            System.out.println("高管的职位为" + Position);
                            GG_list.add(person + "," + Position);
                            GG1_list.add(person);

//                            System.out.println("arrayList内容为" + arrayList.toString());

//                            if (arrayList.toString().contains(person)) {

//                            } else {
//                                System.out.println("股东和高管不重复xixixi");
//                                System.out.println(person);
                            //添加高管对象
                            if (!arrayList.toString().contains(person)) {
                                json2.put("name", person);
                                json2.put("category", 2);
                                json2.put("draggable", true);
                                jsonArray1.add(json2);
                            }
                                json4.put("source", person);
                                json4.put("target", com_name);
                                if (person.equals(FD)) {
                                    json4.put("value", "法定代表人" + "," + Position);
                                } else {
                                    json4.put("value", Position);
                                }
                                jsonArray2.add(json4);
                                arrayList.add(person);
//                            }
                        }
                    }
                    }
                }
                }catch (Exception ex) {
                    ex.printStackTrace();
                } finally {

                }


            String GG=GG_list.toString();
        //添加股东的对象以及和主公司之间的关系
        json4.put("target",com_name);
        for (int  i = 0; i <= gd_list.size() - 1; i++) {
//            if (arrayList.contains(gd_list.get(i).getGD_name())){
//            System.out.println("添加了股东"+gd_list.get(i).getGD_name());
            //判断高管中没有该股东
            if(!(arrayList.toString().contains(gd_list.get(i).getGD_name()))){
//                System.out.println("servlet7第一层添加不重复的股东为"+gd_list.get(i).getGD_name());
                json2.put("name", gd_list.get(i).getGD_name());
                json2.put("category", 2);
                json2.put("draggable", true);
                jsonArray1.add(json2);//添加股东
                //            arrayList.add(gd_list.get(i).getGD_name());
//            System.out.println("添加gd后arraylist"+arrayList.toString());
                json4.put("source", gd_list.get(i).getGD_name());
                if (gd_list.get(i).getGD_name().equals(FD)) {
                    json4.put("value", "法定代表人，投资");
                } else {
                    json4.put("value", "投资");
                }
//                for (int j=0;j<=GG_list.size()-1;j++) {
//                    if (GG_list.get(j).contains(gd_list.get(i).getGD_name())) {
//                        String GD_relation = json4.getString("value");
////                    if (GD_relation.contains())
//                        GD_relation = GD_relation.concat("," + GG_list.get(j).split(",")[1]);
////                    System.out.println("GD_relation:" + GD_relation);
////                json4.put("source", person);
////                json4.put("target", com_name);
//                        json4.put("value", GD_relation);
//                        jsonArray2.add(json4);
//                    }
//                }
                json4.put("target",com_name);
                jsonArray2.add(json4);//存的所有股东和主公司的关系
                arrayList.add(gd_list.get(i).getGD_name());

            }else{
                //高管中有这个股东

                if(jsonArray2.size()>0){
                    for(int n=0;n<jsonArray2.size();n++){
                        // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                        JSONObject job = jsonArray2.getJSONObject(n);
                        if (job.get("source").equals(gd_list.get(i).getGD_name())&&job.get("target").equals(com_name)){
                            String GX=job.get("value").toString();
                            GX=GX.concat(",投资");
//                            System.out.println(gd_list.get(i).getGD_name()+"GX:"+GX);
                            job.put("value",GX);
                        }
                    }
                }

            }

        }


        //公司对外投资的数据获取
        sql3="select * from company2 where com_name=?";
        try {
            stmt3 = conn.prepareStatement(sql3);
            stmt3.setString(1,com_name);
            rs3 = stmt3.executeQuery();

            while (rs3.next()){
                Company2 company2=new Company2();
                company2.setDWTZ(rs3.getString("DWTZ"));
                company2.setKey_person(rs3.getString("key_person"));
                String DWTZ=rs3.getString("DWTZ");
//                String key_person=rs3.getString("key_person");
                if (!(rs3.getString("DWTZ").contains("暂无相关数据"))&&rs3.getString("DWTZ").length()>7){
                     if (province.contains("上海")||province.contains("江苏")||province.contains("北京")||province.contains("福建")||province.contains("浙江")||province.contains("广东")||province.contains("海南")||province.contains("重庆")||province.contains("广西")||province.contains("河北")||province.contains("河南")||province.contains("湖北")) {
                        DWTZ = company2.getDWTZ();
                        arr = null;
                        arr = company2.getDWTZ().split(",");
                        for (int j = 1; j <= arr.length - 1; j++) {
                            arr[j] = arr[j].split("\n")[0];
                        }
//                        for (int j = 1; j <= arr.length - 1; j++) {
//                            System.out.println("arr wei hhh"+arr[j]);
//                        }

                        for (int j = 1; j <= arr.length - 1; j++) {
                            if (arrayList.toString().contains(arr[j])) {
//                            System.out.println(gd.getCom_name());
                            } else {
                                json2.put("name", arr[j]);
                                json2.put("category", 1);
                                json2.put("draggable", true);
                                jsonArray1.add(json2);
                            }
                            arrayList.add(arr[j]);

                            json4.put("target", arr[j]);
                            json4.put("value", "对外投资");
                            json4.put("source",com_name);
                            jsonArray2.add(json4);
                        }
                    }
                    else {
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
                            arr[1] = DWTZ.split(",")[1];
                        }
//
                        for (int j = 0; j <= arr.length - 1; j++) {
                            if (arrayList.toString().contains(arr[j])) {
//                            System.out.println(gd.getCom_name());
                            } else {
                                json2.put("name", arr[j]);
                                json2.put("category", 1);
                                json2.put("draggable", true);
                                jsonArray1.add(json2);
                            }
                            arrayList.add(arr[j]);
                            json4.put("target", arr[j]);
                            json4.put("value", "对外投资");
                            json4.put("source",com_name);
                            jsonArray2.add(json4);
                        }
                    }
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
//        System.out.println("对外投资后的json4为"+jsonArray2.toString());

        //股东向外延伸的投资
        sql2="select * from ysgd where GD_name=?";
        try{
            for (int j = 0; j <= gd_list.size() - 1; j++) {
                stmt2 = conn.prepareStatement(sql2);
                stmt2.setString(1, gd_list.get(j).getGD_name().trim());
                rs2 = stmt2.executeQuery();
                while(rs2.next()){

//                    System.out.println("dangqian GD"+gd_list.get(j).getGD_name().trim());
//                    System.out.println("jin  le  rs2");
                    GD gd=new GD();
                    gd.setGD_name(rs2.getString("GD_name"));
                    gd.setGDLX(rs2.getString("GDLX"));
                    gd.setCom_name(rs2.getString("com_name"));
                    if (!(gd.getCom_name().trim().equals(com_name.trim()))){
//                        System.out.println("jin  le  ffi"+gd.getCom_name());
                        if (arrayList.toString().contains(gd.getCom_name())){
//                            System.out.println(gd.getCom_name());
                        }
                        else {
                            //没有股东对外投资的对象则新建对象
//                            System.out.println(gd.getCom_name());
                            json2.put("name",gd.getCom_name());
                            json2.put("category",1);
                            json2.put("draggable", true);
                            jsonArray1.add(json2);
                        }
                        arrayList.add(gd.getCom_name());
                        //添加关系
                        json4.put("source",gd.getGD_name());
                        json4.put("target",gd.getCom_name());
//                        System.out.println("ggg  wei"+gd.getCom_name());
                        if (gd.getGDLX().trim().contains("1") && !(gd.getGD_name().contains("公司"))) {
                            json4.put("value", "法定代表人,投资");
                        } else {
                            json4.put("value", "投资");
                        }
                        arrayList.add(gd.getCom_name());
                        jsonArray2.add(json4);
                    }
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        //根据股东找出在外面的任职
//System.out.println("cishi    wei "+arrayList.toString());
        sql2="select * from company2 where key_person like '%' ? '%'";
        try{
            for (int j = 0; j <= gd_list.size() - 1; j++) {
//                System.out.println("GD_list wei "+gd_list.get(j).getGD_name().trim());

                stmt2 = conn.prepareStatement(sql2);
                stmt2.setString(1, gd_list.get(j).getGD_name().trim());
                rs2 = stmt2.executeQuery();

                while(rs2.next()) {
                    String pro = rs2.getString("PRO");
                    //避免出现重名的情况
                    if (!province.equals(pro)){
//                    System.out.println("jin  le  rs2");
                    //com_name为当前股东的任职的公司
                    String com = rs2.getString("com_name");
//                    System.out.println("股东" + gd_list.get(j).getGD_name().trim() + "在外任职的公司是" + com);
                    //keyperson为完整的高管信息
                    String key_person = rs2.getString("key_person");
                    //如果任职的公司不为主公司
                    if (!(com.equals(com_name))) {
//                        System.out.println("jin  le  ffi,"+gd_list.get(j).getGD_name()+","+com);
                        //如果之前已经出现了这个对象
                        if (arrayList.toString().contains(com)) {
//                            System.out.println("重复了！！！");
                            //遍历jsonarray2
                            for (int i = 0; i <= jsonArray2.size() - 1; i++) {
                                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                                JSONObject job = jsonArray2.getJSONObject(i);
//                                System.out.println("！！！"+job.get("target"));
                                if (job.get("target").equals(com)) {
//                                    System.out.println("目标和当前一样");
                                    String GX = job.get("value").toString();
//                                    System.out.println(job.get("value").toString()+"正则为"+"\\\\"+gd_list.get(j).getGD_name().trim()+":[\\u4e00-\\u9fa5\\s\\d]{1,}");

                                    Pattern pattern = Pattern.compile(gd_list.get(j).getGD_name().trim() + ":[\\u4e00-\\u9fa5\\s\\d]{1,}");
                                    Pattern pattern1 = Pattern.compile("," + gd_list.get(j).getGD_name().trim() + ":[\\u4e00-\\u9fa5\\s\\d]{1,}");
                                    Matcher matcher = pattern.matcher(key_person);
                                    Matcher matcher1 = pattern1.matcher(key_person);
//                                    if (matcher1.find()){
                                    if (matcher.find()) {
//                                        System.out.println("正则匹配成功");
                                        String string = matcher.group(0);
                                        String a = string.split(":")[1];
//                                        System.out.println("股东对外   wei"+a);
                                        GX = GX.concat("," + a);
//                                        System.out.println("GX   wei"+com+","+gd_list.get(j).getGD_name());
                                        job.put("value", GX);
                                    }
//                                }
                                }
                            }
                            Pattern pattern1 = Pattern.compile("," + gd_list.get(j).getGD_name().trim() + ":[\\u4e00-\\u9fa5\\s\\d]{1,}");
                            Matcher matcher1 = pattern1.matcher(key_person);
                            if (matcher1.find()) {
                                if (matcher1.group(0).split(",")[1].split(":")[0].equals(gd_list.get(j).getGD_name())) {
                                    json4.put("source", gd_list.get(j).getGD_name());
                                    json4.put("target", com);
                                }
                            }
                        } else {
                            Pattern pattern1 = Pattern.compile("," + gd_list.get(j).getGD_name().trim() + ":[\\u4e00-\\u9fa5\\s\\d]{1,}");
                            Matcher matcher1 = pattern1.matcher(key_person);
                            if (matcher1.find()) {
                                if (matcher1.group(0).split(",")[1].split(":")[0].trim().equals(gd_list.get(j).getGD_name().trim())) {
//                            System.out.println("没重复了！！！");
                                    //没有股东的对象则新建对象
//                                    System.out.println(gd_list.get(j).getGD_name().trim() + "mei chong fu de GG" + com);
                                    json2.put("name", com);
                                    json2.put("category", 1);
                                    json2.put("draggable", true);
                                    Pattern pattern = Pattern.compile(gd_list.get(j).getGD_name().trim() + ":[\\u4e00-\\u9fa5\\s\\d]{1,}");
                                    Matcher matcher = pattern.matcher(key_person);
                                    if (matcher.find()) {
//                                        System.out.println("正则匹配成功");
                                        String string = matcher.group(0);
                                        String a = string.split(":")[1];
//                                        System.out.println("股东对外   wei"+a);
                                        String GX = a;
//                                        System.out.println("GX   wei"+com+","+gd_list.get(j).getGD_name());
                                        json4.put("value", GX);
                                    }
                                    jsonArray1.add(json2);
                                    arrayList.add(com);
                                    //添加关系
                                    json4.put("source", gd_list.get(j).getGD_name());
                                    json4.put("target", com);
                                }
                            }
                        }
                        jsonArray2.add(json4);
                    }
                }
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
//        System.out.println("对外投资后的json4为1"+jsonArray2.toString());
//高管在外面的任职
        sql2="select * from company2 where key_person like '%' ? '%'";
        try{
            for (int j = 0; j <= GG1_list.size() - 1; j++) {

                stmt2 = conn.prepareStatement(sql2);
                stmt2.setString(1, GG1_list.get(j).trim());
                rs2 = stmt2.executeQuery();
                while(rs2.next()) {
                    String pro=rs2.getString("PRO");
                            if (!province.equals(pro)){
//                    System.out.println("jin  le  rs2");
                    //com为高管的在外任职的公司
                    String com = rs2.getString("com_name");
//                    System.out.println("高管" + GG1_list.get(j).trim() + "在外任职的公司是" + com);
                    String key_person = rs2.getString("key_person");
                    if (!(com.trim().equals(com_name.trim()))) {
                        //表示之前的已经包含了这个对象
                        if (arrayList.toString().contains(com)) {
//                            System.out.println("重复了！！！");
                            json4.put("source", GG1_list.get(j).trim());
                            json4.put("target", com);

//                            for(int i=0;i<=jsonArray2.size()-1;i++){
//                                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
//                                JSONObject job = jsonArray2.getJSONObject(i);
////                                System.out.println("！！！"+job.get("target"));
//                                if (job.get("target").equals(com)) {
////                                    System.out.println("目标和当前一样");
//                                    String GX = job.get("value").toString();
                            Pattern pattern = Pattern.compile(GG1_list.get(j).trim() + ":[\\u4e00-\\u9fa5\\s\\d]{1,}");
                            Pattern pattern1 = Pattern.compile("," + GG1_list.get(j).trim() + ":[\\u4e00-\\u9fa5\\s\\d]{1,}");
                            Matcher matcher = pattern.matcher(key_person);
                            Matcher matcher1 = pattern1.matcher(key_person);
                            String GX = "";
                            if (matcher1.find()) {
                                if (matcher.find()) {
//                                    System.out.println("正则匹配成功");
                                    String string = matcher.group(0);
                                    String a = string.split(":")[1];
//                                        System.out.println("股东对外   wei"+a);
                                    GX = GX.concat(a);
//                                        job.put("value", GX);
                                }
                            }
                            json4.put("value", GX);
                            jsonArray2.add(json4);
//                                }
//                            }
//                            Pattern pattern1 = Pattern.compile("," + GG1_list.get(j).trim() + ":[\\u4e00-\\u9fa5\\s\\d]{1,}");
//                            Matcher matcher1 = pattern1.matcher(key_person);
//                            if (matcher1.find()) {
//                                if (matcher1.group(0).split(",")[1].split(":")[0].equals( GG1_list.get(j))) {
//                                    json4.put("source", GG1_list.get(j));
//                                    json4.put("target", com);
//                                }
//                            }
                        } else {
                            Pattern pattern1 = Pattern.compile("," + GG1_list.get(j).trim() + ":[\\u4e00-\\u9fa5\\s\\d]{1,}");
                            Matcher matcher1 = pattern1.matcher(key_person);
                            if (matcher1.find()) {
                                if (matcher1.group(0).split(",")[1].split(":")[0].trim().equals(GG1_list.get(j).trim())) {
//                            System.out.println("没重复了！！！");
                                    //没有股东的对象则新建对象
//                                    System.out.println(GG1_list.get(j).trim() + "mei chong fu de GG" + com);
                                    json2.put("name", com);
                                    json2.put("category", 1);
                                    json2.put("draggable", true);
                                    Pattern pattern = Pattern.compile(GG1_list.get(j).trim() + ":[\\u4e00-\\u9fa5\\s\\d]{1,}");
                                    Matcher matcher = pattern.matcher(key_person);
                                    if (matcher.find()) {
//                                        System.out.println("正则匹配成功");
                                        String string = matcher.group(0);
                                        String a = string.split(":")[1];
//                                        System.out.println("股东对外   wei"+a);
                                        String GX = a;
                                        json4.put("value", GX);
                                    }
                                    jsonArray1.add(json2);
                                    arrayList.add(com);
                                    //添加关系
                                    json4.put("source", GG1_list.get(j));
                                    json4.put("target", com);
                                }
                            }
                        }
                        jsonArray2.add(json4);
                    }
                }
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
//        System.out.println("对外投资后的json4为111"+jsonArray2.toString());
ArrayList<String> AL=new ArrayList<String>();
        if(jsonArray1.size()>0){
            for(int i=0;i<jsonArray1.size();i++){
                JSONObject job = jsonArray1.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                String name=job.get("name").toString();

                if (i>0){
//                    System.out.println("servlet7mei重复的namewei"+name);
                    for (int j=0;j<=AL.size()-1;j++){
                        if (AL.get(j).trim().equals(name.trim())){
//                            System.out.println("servlet7重复的namewei"+name);
                            jsonArray1.remove(job);
                        }
                    }
                }
                    AL.add(name);
//                    System.out.println(AL.toString());

            }
        }
        jsonArray.add(jsonArray1);
        jsonArray.add(jsonArray2);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
//        System.out.println("servlet7 end");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
