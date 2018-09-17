import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class bigdata1
{
    public static void main(String[] args) throws Exception {
        Connection conn = null;
//搜索失败后智能推荐的数据获取
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;

        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        JSONObject jsonObject1 = new JSONObject();

        String sql1 = null;
        String sql2 = null;
        String sql3 = null;
        ArrayList<Company2> li = new ArrayList<Company2>();

        JSONObject json1=new JSONObject();
//        JSONObject j
        String hangye = "国际组织";

        JSONArray jsonArray=new JSONArray();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("ok");


        try {
            String[] arr = null;
            sql1 = "select * from company1 where FW =?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, hangye);
//            System.out.print(hangye);
            rs1 = stmt1.executeQuery();
            int k=0;
            while (rs1.next()) {

                Company2 company2 = new Company2();
                company2.setReg_no(rs1.getString("reg_no"));
                company2.setCom_name(rs1.getString("com_name"));
                li.add(company2);
//                System.out.print(company2.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
        Map<String, Integer> map1 = new HashMap<String, Integer>();


        for (int x=0;x<=li.size()-1;x++) {
//            System.out.print(li.get(x).toString());
            try {
                int k=0;
                sql1 = "select * from company2 where com_name = ?";
                stmt1 = conn.prepareStatement(sql1);
                stmt1.setString(1, li.get(x).getCom_name());
                rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    k=1;
                    Company2 company2 = new Company2();
                    String a1="";
                    String Add=rs1.getString("Addr");
//                    System.out.println("Add wei "+Add);
                    li.get(x).setDJJG(Add);
                }
                if(k==0){
                    li.remove(x);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }
        }



        for (int i = 0; i <= li.size()-1; i++) {
            //k=0表示当前对外投资在数据库中没有信息
            try {
//                        System.out.println("servelt3第二个");
                sql1 = "select * from dict_city";
                stmt1 = conn.prepareStatement(sql1);
                rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    String city_name = (rs1.getString("S_CITYNAME"));
                    city_name = city_name.replaceAll("\\区|\\市|\\自治区|\\特别行政区", "");
                    city_name = city_name.replaceAll(" ", "");
//                    System.out.println(li.get(i).getCom_name());
                    if (li.get(i).getDJJG()!=null) {
                        if (li.get(i).getDJJG().contains(city_name)) {
                            li.get(i).setAddr(city_name);
                        }
                    }

                }
            } catch(Exception ex){
                ex.printStackTrace();
            } finally{
            }
        }
        for (int i = 0; i <= li.size() - 1; i++) {
            if (map1.containsKey(li.get(i).getAddr())){
                int num=map1.get(li.get(i).getAddr());
                num++;
                map1.put(li.get(i).getAddr(),num);
            }else {
                map1.put(li.get(i).getAddr(),1);
            }
        }

        String xinxi="";
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String Pro = entry.getKey();
            if (Pro != null && !Pro.equals("")) {
                int num = entry.getValue();
                if (num != 0) {
                    json1.put("name", Pro);
                    //       if (arr.length)
                    json1.put("value", num);
                    jsonArray.add(json1);
//                    System.out.println(Pro);
//                    System.out.println(num);
//                    System.out.println(xinxi);
                    xinxi = xinxi.concat(Pro).concat("/").concat(String.valueOf(num)).concat("#");
                }
            }
        }
//            System.out.print(xinxi);

        try {
            sql1 = "insert into hangye(hangye,xinxi)values ('" + hangye.trim() + "','" + xinxi.trim() + "')";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }

//        System.out.print(jsonArray.toString());




    }








}
