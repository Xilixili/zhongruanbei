import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;
import java.util.*;

public class Hcom {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<company> li = new ArrayList<>();
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
        String sql1 = null;
        Class.forName("com.mysql.jdbc.Driver");
//获取连接//http://baidu.com
        Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");

        sql1 = "select * from special;";


        stmt1 = conn.prepareStatement(sql1);


        rs1 = stmt1.executeQuery();

        int i=0;

        String[] nengliArr;

        while (rs1.next()) {
            company com = new company();
            com.setReg_no(rs1.getString("reg_no"));
            com.setCom_name(rs1.getString("com_name"));
            com.setYyzz(rs1.getString("yyzz"));
            com.setDwcz(rs1.getString("dwcz"));
            com.setBase_info(rs1.getString("base_info"));
            com.setGdcz(rs1.getString("gdcz"));
            com.setXzxk(rs1.getString("xzxk"));
            com.setXzcf(rs1.getString("xzcf"));
            com.setSubcom(rs1.getString("subcom"));
            com.setKey_person(rs1.getString("key_person"));
            com.setJyycml(rs1.getString("jyycml"));
            com.setHmd(rs1.getString("hmd"));
            com.setCom_url(rs1.getString("com_url"));


            li.add(i,com);
            i++;
        }

//System.out.println(li.get(2).getCom_name());
//System.out.println(li.get(3).getCom_name());
//System.out.println(li.get(4).getCom_name());
//System.out.println(li.get(5).getCom_name());
        jiangsuHan.hanlp(li);

    }
}

