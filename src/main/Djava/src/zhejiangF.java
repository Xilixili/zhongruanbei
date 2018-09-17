import java.sql.*;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zhejiangF {
    public static void zhejiangF(List<company> li) throws SQLException {
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

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");

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
            String ZB = "";
            String RQ = "";
            String FW = "";
            String Addr="";
            String LX="";
            String FD="";
            String DJJG="";
            String DJZT="";
            String HZRQ="";
            String YZ="";
            String YX="";
            String DH="";
            String GDTZ=li.get(i).getGdcz();
            String subcom=li.get(i).getSubcom();
            String xzxk=li.get(i).getXzxk();
            String xzcf=li.get(i).getXzcf();
            String jyycml=li.get(i).getJyycml();
            String hmd=li.get(i).getHmd();
            String key_person=li.get(i).getKey_person();
            String com_url=li.get(i).getCom_url();
            String dwtz=li.get(i).getDwcz();
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);//当前年份;
            String reg_no = li.get(i).getReg_no();//注册号
            String yyzz = li.get(i).getYyzz();
            String base_info = li.get(i).getBase_info();
            String dwcz = li.get(i).getDwcz();
            String gdcz = li.get(i).getGdcz();
            Pattern pattern = Pattern.compile("\\注册资本： [\\u4e00-\\u9fa5\\d.]{1,}|\\注册资本：[\\u4e00-\\u9fa5\\d.]{1,}");
            Pattern pattern1 = Pattern.compile("\\自：[\\u4e00-\\u9fa5\\d]{1,}|\\自： [\\u4e00-\\u9fa5\\d]{1,}");
            Pattern pattern2 = Pattern.compile("\\经营范围：[\\u4e00-\\u9fa5\\s\\d].{1,}\\。|\\经营范围：[\\u4e00-\\u9fa5\\s\\d].{1,}");
            Pattern pattern3 = Pattern.compile("\\营业场所： [\\u4e00-\\u9fa5\\d]{1,}|\\住所： [\\u4e00-\\u9fa5\\d]{1,}|\\营业场所：[\\u4e00-\\u9fa5\\d]{1,}|\\住所：[\\u4e00-\\u9fa5\\d]{1,}");
            Pattern pattern4 = Pattern.compile("\\类型：[\\u4e00-\\u9fa5\\s\\d]{1,}");
            Pattern pattern5 = Pattern.compile("\\法定代表人：[\\u4e00-\\u9fa5\\dA-Za-z]{1,}|\\负责人：[\\u4e00-\\u9fa5A-Za-z]{1,}|\\法定代表人： [\\u4e00-\\u9fa5\\dA-Za-z]{1,}|\\负责人： [\\u4e00-\\u9fa5\\dA-Za-z]{1,}");
            Pattern pattern6 = Pattern.compile("\\登记机关：[\\u4e00-\\u9fa5\\d]{1,}|\\登记机关： [\\u4e00-\\u9fa5\\d]{1,}");
            Pattern pattern7 = Pattern.compile("\\登记状态：[\\u4e00-\\u9fa5\\d]{1,}|\\登记状态： [\\u4e00-\\u9fa5\\d]{1,}");
            Pattern pattern8 = Pattern.compile("\\核准日期：[\\u4e00-\\u9fa5\\d]{1,}|\\核准日期： [\\u4e00-\\u9fa5\\d]{1,}");
            Pattern pattern9 = Pattern.compile("\\邮政编码： [\\u4e00-\\u9fa5\\d]{1,}|\\邮政： [\\u4e00-\\u9fa5\\d]{1,}|\\邮政编码：[\\u4e00-\\u9fa5\\d]{1,}|\\邮政：[\\u4e00-\\u9fa5\\d]{1,}");
            Pattern pattern10 = Pattern.compile("\\邮箱： [\\u4e00-\\u9fa5\\dA-Za-z.@]{1,}|\\邮箱：[\\u4e00-\\u9fa5\\dA-Za-z.@]{1,}");
            Pattern pattern11= Pattern.compile("\\电话： [\\u4e00-\\u9fa5\\d-]{1,}|\\电话：[\\u4e00-\\u9fa5\\d-]{1,}");
            Matcher matcher = pattern.matcher(yyzz);
            Matcher matcher1 = pattern1.matcher(yyzz);
            Matcher matcher2 = pattern2.matcher(yyzz);
            Matcher matcher3 = pattern3.matcher(yyzz);
            Matcher matcher4 = pattern4.matcher(yyzz);
            Matcher matcher5 = pattern5.matcher(yyzz);
            Matcher matcher6 = pattern6.matcher(yyzz);
            Matcher matcher7 = pattern7.matcher(yyzz);
            Matcher matcher8 = pattern8.matcher(yyzz);
            Matcher matcher9 = pattern9.matcher(base_info);
            Matcher matcher10 = pattern10.matcher(base_info);
            Matcher matcher11= pattern11.matcher(base_info);

            if(matcher.find()){
                String ZCBC=matcher.group(0);
                ZB=ZCBC.split("：")[1];
                if (ZB.contains("日期")){
                    ZB=ZB.split(" · ")[0];
                }
                System.out.println("ZB为"+ZB);
//                Pattern p=Pattern.compile("[\\d].{1,}[\\u4e00-\\u9fa5\\s\\d].{1,}");
//                Matcher m=p.matcher(ZCBC);
//                if (m.find()){
//                    ZB=m.group();
//                }
            }
            else {
                ZB = "无";
            }
            if (matcher1.find()){
                String CLRQ=matcher1.group(0);
                RQ=CLRQ.split("：")[1];
//                Pattern p1=Pattern.compile("[\\d].{1,}[\\u4e00-\\u9fa5\\s\\d].{1,}");
//                Matcher m1=p1.matcher(CLRQ);
//
//                if (m1.find()){
//                    RQ=m1.group(0);
//                }

            }
            if (matcher2.find()) {
                String JYFW = matcher2.group(0);
                FW=JYFW.split("：")[1];

//                }
            }
            if (matcher3.find()){
                String Add=matcher3.group(0);
                Addr=Add.split("：")[1];

            }
//            else {
//                Pattern p31=Pattern.compile("\\住所：\\n[\\u4e00-\\u9fa5\\s\\d].{1,}");
//                Matcher m31=p31.matcher(yyzz);
//                if(m31.find()){
//                    String Add=m31.group(0);
//                    Pattern p3=Pattern.compile("[\\u4e00-\\u9fa5\\s\\d].{6,}")  ;
//                    Matcher m3=p3.matcher(Add);
//                    if (m3.find()){
//                        Addr=m3.group(0);
//
//                    }
//                }
//            }
            if (matcher4.find()){
                String X1=matcher4.group(0);
                LX=X1.split("：")[1];
//                Pattern p4=Pattern.compile("[\\u4e00-\\u9fa5\\s\\d].{6,}");
//                Matcher m4=p4.matcher(X1);
//                if (m4.find()){
//                    LX=m4.group(0);
//                }
            }

            if (matcher5.find()){
                String X2=matcher5.group(0);
                FD=X2.split("：")[1];
            }
            else {
                FD="无";
            }

            if (matcher6.find()){
                String X3=matcher6.group(0);
                DJJG=X3.split("：")[1];
//                System.out.println(DJJG+"机关");
            }

//            if (matcher7.find()){
//                String X4=matcher7.group(0);
//                DJZT=X4.split("\n")[1];
////               System.out.println(DJZT+"机关");
//            }

            if (matcher7.find()){
                String X4=matcher7.group(0);
                DJZT=X4.split("：")[1];
//                System.out.println(DJZT+"登记状态");
            }

            if (matcher8.find()){
                String X5=matcher8.group(0);
                HZRQ=X5.split("：")[1];
//                System.out.println(HZRQ+"核准日期");
            }
            if (matcher9.find()){
                String X5=matcher9.group(0);
                    YZ = X5.split("：")[1];
//                System.out.println(YZ+"邮政");

            }

            if (matcher10.find()){
                String X6=matcher10.group(0);
                if (X6.contains("从业人数")){
                    YX="";
                }else {
                    YX = X6.split("：")[1];
//                System.out.println(YX+"邮箱");
                }
            }
            if (matcher11.find()){
                String X7=matcher11.group(0);
                DH=X7.split("：")[1];
//                System.out.println(DH+"电话");
            }


            sql3="insert into company2(reg_no,com_name,ZB,RQ,FW,Addr,LX,FD,DJJG,DJZT,HZRQ,YZ,YX,DH,subcom,xzxk,xzcf,jyycml,hmd,key_person,com_url,DWTZ,GDTZ,PRO)values ('"+ reg_no.trim()+"','"+com_name.trim()+"','"+ZB.trim()+"','"+RQ.trim()+"','"+FW.trim()+"','"+Addr.trim()+"','"+LX.trim()+"','"+FD.trim()+"','"+DJJG.trim()+"','"+DJZT.trim()+"','"+HZRQ.trim()+"','"+YZ.trim()+"','"+YX.trim()+"','"+DH.trim()+"','"+subcom.trim()+"','"+xzxk.trim()+"','"+xzcf.trim()+"','"+jyycml.trim()+"','"+hmd.trim()+"','"+key_person.trim()+"','"+com_url.trim()+"','"+dwtz.trim()+"','"+GDTZ.trim()+"','"+"江苏省"+"')";
            stmt3=conn.prepareStatement(sql3);
            stmt3.executeUpdate();

        }
    }


}
