
import java.sql.*;
import java.util.*;
public class YS {
    
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            PreparedStatement stmt3 = null;
            ResultSet rs1 = null;
            ResultSet rs2 = null;
            ResultSet rs3 = null;

            String sql1 = null;
            String sql2 = null;
            String sql3 = null;
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
            Connection conn = null;
            {
                try {
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            ArrayList<Relation1> list = new ArrayList<>();

        List<company> li = new ArrayList<company>();
         stmt1 = null;
         rs1 = null;
         sql1 = null;
        Class.forName("com.mysql.jdbc.Driver");
//获取连接//http://baidu.com

        sql1 = "select * from company;";

        stmt1 = conn.prepareStatement(sql1);

        rs1 = stmt1.executeQuery();

        int i = 0;

        while (rs1.next()) {
            company com = new company();
            com.setReg_no(rs1.getString("reg_no"));
            com.setCom_name(rs1.getString("com_name"));
//            com.setYyzz(rs1.getString("yyzz"));
//            com.setDwcz(rs1.getString("dwcz"));
//            com.setBase_info(rs1.getString("base_info"));
            com.setGdcz(rs1.getString("gdcz"));
//            System.out.println(com.toString());
            System.out.println(com.getGdcz().split("\n")[0]);
            Relation1 r=new Relation1();//!!!!! list添加的是对象引用，应该每次都建立一个新的对象引用
            //add加进去的是对象的一个引用，使用同一个对象时，每次都更新了这个引用的值，所以list里面的值都一样的。如果使用for等循环时，注意把User user=new User()放到循环里面，每次都生成一个新的对象，更改自身不会对其他元素有影响。
            if (!(rs1.getString("gdcz").trim().equals("无")||rs1.getString("gdcz").trim().equals("无相关数据")||rs1.getString("gdcz").trim().equals("4"))){
                r.setCom_name(com.getCom_name());
                r.setReg_no(com.getReg_no());
                r.setMaxTZR(com.getGdcz().split(" ")[1]);
                r.setMaxTZ(com.getGdcz().split(" ")[2]);
                r.setTZRQ(com.getGdcz().split(" ")[3]);
                list.add(r);
                System.out.println(list.size());
                i++;
            }
            else {
                r.setCom_name(com.getCom_name());
                r.setReg_no(com.getReg_no());
                r.setMaxTZR("无");
                r.setMaxTZ("无");
                r.setTZRQ("无");
                list.add(r);

                i++;
            }
        }
        System.out.println(list.get(100).toString());
            for (int j=0;j<=list.size()-1;j++){
             sql2="insert into YS(ID,reg_no,com_name,maxTZR,maxTZ,TZRQ)values ('"+j+" ','"+list.get(j).getReg_no().trim()+" ','"+list.get(j).getCom_name().trim()+" ','"+list.get(j).getMaxTZR().trim()+" ','"+list.get(j).getMaxTZ().trim()+" ','"+list.get(j).getTZRQ().trim()+" ')";
             stmt2=conn.prepareStatement(sql2);
            stmt2.executeUpdate();

        }

        System.out.println(li.size());




//        fenlei1.fenlei1(li);


    }

}
