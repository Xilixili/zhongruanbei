import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class bigdata2 {

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

        JSONObject json1 = new JSONObject();
        //        JSONObject j
        String PRO = "湖北省";

        JSONArray jsonArray = new JSONArray();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Map<String, Integer> map1 = new HashMap<String, Integer>();


        try {
            sql1 = "select * from company1 where PRO =?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, PRO);
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                String hangye = rs1.getString("FW");
                if (map1.containsKey(hangye)) {
                    int num = map1.get(hangye);
                    num++;
                    map1.put(hangye, num);
                } else {
                    map1.put(hangye, 1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
        String xinxi="";
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String hangye = entry.getKey();
            if (hangye != null && !hangye.equals("")) {
                int num = entry.getValue();
                if (num != 0) {

                    System.out.println(num);
                    System.out.println(xinxi);
                    xinxi = xinxi.concat(hangye).concat("/").concat(String.valueOf(num)).concat("#");
                }
            }
        }

        try {
            sql1 = "insert into Prohangye(PRO,hangye)values ('" + PRO.trim() + "','" + xinxi.trim() + "')";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }


}
