
import java.sql.*;

public class mysql {
    public static String url = "jdbc:mysql://localhost:3306/test";//characterEncoding=GBK
    public static String username = "root";
    public static String password = "root";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    public static void main(String[] args) throws SQLException {
        connect();
        stmt.close();
        con.close();
    }
    public static void test() {
        String sql_select = "select * from tablename where id=1";
        String sql_insert = "insert into tablename (col1,col2..) values('1','2'...)";
        String sql_update = "update tablename set colname='update' where id=1";
        //insert(sql_insert);
        //select(sql_select);
        //update(sql_update);
    }
    public static void connect() {
        // 定位驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功!");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败!");
            e.printStackTrace();
        }
        // 建立连接
        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("数据库连接成功!");
        } catch(SQLException e) {
            System.out.println("数据库连接失败!");
        }
    }
    public static void select(String sql) {
        try {
            rs = stmt.executeQuery(sql);
            ResultSetMetaData meta_data = rs.getMetaData();//列名
            for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
                System.out.print(meta_data.getColumnLabel(i_col) + "   ");
            }
            System.out.println();
            while (rs.next()) {
                for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
                    System.out.print(rs.getString(i_col) + "  ");
                }
                System.out.println();
            }
            rs.close();
        }catch (Exception e) {
            System.out.println("数据查询失败!");
        }
    }
    public static void insert(String sql) {
        try {
            stmt.clearBatch();
            stmt.addBatch(sql);
            stmt.executeBatch();
            System.out.println("数据插入成功!");
        }catch (Exception e) {
            System.out.println("数据插入失败!");
        }
    }
    public static void update(String sql) {
        try {
            stmt.executeUpdate(sql);
            System.out.println("数据更新成功!");
        }catch (Exception e) {
            System.out.println("数据更新失败!");
        }
    }
}