
import java.io.UnsupportedEncodingException;
import java.sql.*;
// import utils.SystemParas;
import com.sun.jna.Library;
import com.sun.jna.Native;
import net.sf.json.JSONObject;

/**
 *
 * 功能：提取关键词功能
 * 最后更新时间：2016年3月15日 14:09:49
 */

public class bigdata {
    public static String province="湖北省";
    // 定义接口CLibrary，继承自com.sun.jna.Library
    public interface CLibrary extends Library {
        // 定义并初始化接口的静态变量，用于加载NLPIR.dll，路径指向文件NLPIR.dll，但不加后缀dll
        CLibrary Instance = (CLibrary) Native.loadLibrary("E:\\match\\mavenSSH\\source\\NLPIR",CLibrary.class);
        // 初始化函数声明：sDataPath是初始化路径地址，包括核心词库和配置文件的路径，encoding为输入字符的编码格式
        public int NLPIR_Init(String sDataPath,int encoding,String sLicenceCode);
        // 提取关键词函数声明：字符串，最多选取的关键词个数，是否显示关键词的权重值true/false
        public String NLPIR_GetKeyWords(String sLine, int nMaxKeyLimit,boolean bWeightOut);
        // 从文件中提取关键词函数声明：文件路径，最多选取的关键词个数，是否显示关键词的权重值true/false
        public String NLPIR_GetFileKeyWords(String sLine, int nMaxKeyLimit,boolean bWeightOut);
        // 获取最后一个错误信息的函数声明
        public String NLPIR_GetLastErrorMsg();
        // 退出函数声明
        public void NLPIR_Exit();
    }

    public static String transString(String aidString,String ori_encoding,String new_encoding) {
        try {
            return new String(aidString.getBytes(ori_encoding),new_encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        PreparedStatement stmt1 = null;
        ResultSet rs1 = null;
//        JSONObject jsonObject1 = new JSONObject();
        String sql1 = null;

        String content="";
        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }

            try {
                String[] arr = null;
                sql1 = "select * from company2 where PRO = ?";
                stmt1 = conn.prepareStatement(sql1);
                stmt1.setString(1, province);
                rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    content=content.concat(rs1.getString("FW"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }



        String argu = "E:\\match\\mavenSSH";     // 该路径指向Data文件夹（系统核心词库）
        // String system_charset = "UTF-8";
        int charset_type = 1;                  // UTF-8编码模式，其它的GBK对应0，BIG5对应2，含繁体字的GBK对应3
        int init_flag = CLibrary.Instance.NLPIR_Init(argu, charset_type, "0");      // 运行初始化函数，成功则返回1，失败返回0
        String nativeBytes;

        // 初始化失败提示
        if (0 == init_flag) {
            nativeBytes = CLibrary.Instance.NLPIR_GetLastErrorMsg();    // 获取错误信息
            System.err.println("初始化失败！原因："+nativeBytes);
            return;
        }

String sInput=content;
        try {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String a1="";
            int nCountKey = 0;
            String keywords = CLibrary.Instance.NLPIR_GetKeyWords(sInput, 50,true);  // 字符串提取关键词
            System.out.println("字符串关键词提取结果：" + keywords);
            String[] a=keywords.split("#");
            for (int i=0;i<=a.length-1;i++){
                if (i!=a.length-1) {
                    a1 = a1.concat(a[i].split("/")[0]).concat("/").concat(a[i].split("/")[2]).concat("#");
                }else{
                    a1 = a1.concat(a[i].split("/")[0]).concat("/").concat(a[i].split("/")[2]);
                }


            }

            try {
                sql1="insert into Kwords(province,key_words)values ('"+ province.trim()+"','"+ a1.trim()+"')";
                stmt1 = conn.prepareStatement(sql1);
                stmt1.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

            }




            // 从.txt文本中提取关键词，注意文本的编码格式要与上面对应，如UTF-8，否则会乱码
//            keywords = CLibrary.Instance.NLPIR_GetFileKeyWords("D:\\NetBeansProjects\\CWordSeg\\file\\test.txt", 50,true);
//            System.out.println("读文本关键词提取结果：" + keywords);
            CLibrary.Instance.NLPIR_Exit();     // 退出
        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
}