import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CoreSynonymDictionary;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class jiangsuHan {

    public static void hanlp(List<company> li) throws SQLException {


        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        String sql1 = null;
        String sql2 = null;
        String sql3 = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");

//        Iterator<company> iter = li.iterator();
//        while(iter.hasNext()){  //执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
//            System.out.println(iter.next());
//            String com_name=
//
//
//            iter.toString();
//        }
        int i = 0;
        System.out.println();
        for (i = 0; i <= li.size() - 1; i++) {
            String com_name = li.get(i).getCom_name();
            String ZB="";
            String RQ="";
            String FW="";
            String PRO="";
            String pro_num="";
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            String reg_no = li.get(i).getReg_no();
            String yyzz = li.get(i).getYyzz();
            String base_info = li.get(i).getBase_info();
            String dwcz = li.get(i).getDwcz();
            String gdcz = li.get(i).getGdcz();
            Pattern pattern = Pattern.compile("\\注册资本： [\\u4e00-\\u9fa5\\d.]{1,}|\\注册资本：[\\u4e00-\\u9fa5\\d.]{1,}");
            Pattern pattern1 = Pattern.compile("\\自：[\\u4e00-\\u9fa5\\d]{1,}|\\自： [\\u4e00-\\u9fa5\\d]{1,}");
            Pattern pattern2 = Pattern.compile("\\经营范围：[\\u4e00-\\u9fa5\\s\\d].{1,}\\。|\\经营范围：[\\u4e00-\\u9fa5\\s\\d].{1,}");
            Pattern pattern3 = Pattern.compile("[\\u4e00-\\u9fa5^市\\s\\d].{1,}\\市");
            Matcher matcher = pattern.matcher(yyzz);
            Matcher matcher1 = pattern1.matcher(yyzz);
            Matcher matcher2 = pattern2.matcher(yyzz);
            Matcher matcher3 = pattern3.matcher(yyzz);
            if (matcher.find()) {
                String ZCZB=matcher.group(0);
                Pattern p=Pattern.compile("[0-9]{1,}");
                Matcher m=p.matcher(ZCZB);
                if (m.find()){
                    ZB=m.group(0);
                    if (Integer.valueOf(ZB)<=100){
                        ZB="100万以内";
                    }
                    else if (Integer.valueOf(ZB)>100&&Integer.valueOf(ZB)<=500){
                        ZB="100-500万";
                    }
                    else if (Integer.valueOf(ZB)>500&&Integer.valueOf(ZB)<=1000){
                        ZB="500-1000万";
                    }
                    else if (Integer.valueOf(ZB)>1000&&Integer.valueOf(ZB)<=3000){
                        ZB="1000-3000万";
                    }
                    else if (Integer.valueOf(ZB)>3000&&Integer.valueOf(ZB)<=5000){
                        ZB="3000-5000万";
                    }
                    else {
                        ZB="5000万以上";
                    }
                }
            }
            if (matcher1.find()) {
                String CLRQ=matcher1.group(0);
                Pattern p1=Pattern.compile("[0-9]{4,}");
                Matcher m1=p1.matcher(CLRQ);
                if (m1.find()){
                    RQ=m1.group(0);
                    if (year-Integer.valueOf(RQ)<=1){
                        RQ="1年内";
                    }
                    else if (year-Integer.valueOf(RQ)>1&&year-Integer.valueOf(RQ)<=3){
                        RQ="1-3年";
                    }
                    else if (year-Integer.valueOf(RQ)>3&&year-Integer.valueOf(RQ)<=10){
                        RQ="4-10年";
                    }
                    else{
                        RQ="10年以上";
                    }
                }
            }
            if (matcher2.find()) {
                String JYFW=matcher2.group(0);
                String content =JYFW;
                List<String> phraseList1 = HanLP.extractPhrase(content, 5);
                String phrase=phraseList1.toString();
                Suggester suggester = new Suggester();
                String[] titleArray =
                        (       "农、林、牧、渔业\n"+
                                "采矿业\n"+
                                "制造业\n"+
                                "电力、热力、燃气及水生产和供应业\n"+
                                "建筑业\n"+
                                "批发和零售业\n"+
                                "交通运输、仓储和邮政业\n"+
                                "住宿和餐饮业\n"+
                                "信息传输、软件和信息技术服务业\n"+
                                "金融业\n"+
                                "房地产业\n"+
                                "租赁和商务服务业\n"+
                                "科学研究和技术服务业\n"+
                                "水利、环境和公共设施管理业\n"+
                                "居民服务、修理和其他服务业\n"+
                                "教育\n"+
                                "卫生和社会工作\n"+
                                "文化、体育和娱乐业\n"
//                                "公共管理、社会保障和社会组织\n"
                        ).split("\n");
                for (String title : titleArray)
                {
                    suggester.addSentence(title);

                }

                FW=suggester.suggest(phrase, 1).get(0).toString().trim();       // 语义
//                System.out.println(FW);
            }
            if (matcher3.find()){
                String ZS=matcher3.group(0);
//                System.out.println(ZS);
//                ZS=ZS.substring(0,3);
//                System.out.println(ZS);


                sql1 = "select * from dict_city";
                sql2 = "select * from dict_province WHERE N_PROVID=?";

                stmt1 = conn.prepareStatement(sql1);
                rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    pro_num=(rs1.getString("N_PROVID"));
                    String city_name=(rs1.getString("S_CITYNAME"));
                    if(ZS.contains(city_name)){
                        stmt2=conn.prepareStatement(sql2);
                        stmt2.setString(1,pro_num);
                        rs2=stmt2.executeQuery();
                        while (rs2.next()){
                            pro_num=(rs2.getString("N_PROVID"));
                            PRO=(rs2.getString("S_PROVNAME")).trim();
//                            System.out.println(PRO);
                        }
                    }
                }
            }
//            sql3="insert into company1(ID,reg_no,com_name,ZB,RQ,FW,PRO)values ('"+ i+" ','"+ reg_no.trim()+" ','"+com_name.trim()+" ',' "+ZB.trim()+" ',' "+RQ.trim()+" ',' "+FW.trim()+" ',' "+PRO.trim()+" ')";
            sql3="insert into company1(reg_no,com_name,ZB,RQ,FW,PRO)values ('"+ reg_no.trim()+"','"+com_name.trim()+"','"+ZB.trim()+"','"+RQ.trim()+"','"+FW.trim()+"','"+"江苏省"+"')";
            stmt3=conn.prepareStatement(sql3);
            stmt3.executeUpdate();
        }
    }
}
