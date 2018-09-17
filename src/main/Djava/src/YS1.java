import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YS1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<GD> list=new ArrayList<GD>();
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        Double a1 = null;
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

        sql1 = "select * from special";
        stmt1 = conn.prepareStatement(sql1);
        rs1 = stmt1.executeQuery();

        int i = 0;

        while (rs1.next()) {
            company com = new company();
            com.setReg_no(rs1.getString("reg_no"));
            com.setCom_name(rs1.getString("com_name"));
            com.setGdcz(rs1.getString("gdcz"));
//            System.out.println(com.toString());
            if (com.getGdcz().length()>5&&!(com.getGdcz().contains("企业选择不公示"))){
                String[] array=com.getGdcz().split("\\.,");
//            System.out.println("array"+array[1]);
            int len=array.length;
            System.out.println(len);
            for (i=1;i<=len-1;i++) {
                if (!(array[i].contains(",,,"))) {
                    GD gd = new GD();
                    gd.setGD_name(array[i].split(",")[1]);
                    gd.setGDLX(array[i].split(",")[0]);
                    String a = array[i].split(",")[2];//split中是正则
                    Pattern p = Pattern.compile("[\\d.]{1,9}");
                    Matcher m = p.matcher(a);
                    if (m.find()) {
                        if (a.contains("美元")) {

                            a1 = (Double.parseDouble(m.group(0)) * 6.4379);
                        } else {
                            a1 = (Double.parseDouble(m.group(0)));
                        }
                    }
                    gd.setGDBL(a1);
                    gd.setCom_name(com.getCom_name());
                    gd.setReg_no(com.getReg_no());
                    System.out.println(gd.toString());
                    list.add(gd);
                }
            }
            }
        }

        for (int j=0;j<=list.size()-1;j++){
            sql2="insert into YSGD(reg_no,com_name,GD_name,GDLX,GDBL)values ('"+list.get(j).getReg_no().trim()+"','"+list.get(j).getCom_name().trim()+"','"+list.get(j).getGD_name().trim()+"','"+list.get(j).getGDLX().trim()+"','"+list.get(j).getGDBL().toString().trim()+"')";
            stmt2=conn.prepareStatement(sql2);
            stmt2.executeUpdate();
        }
    }
}
