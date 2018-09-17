package com.hmz.servlet;

import com.hmz.entity.Company1;
import com.hmz.entity.Company2;
import com.hmz.entity.GD;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


@WebServlet("/servletdao")
//@javax.servlet.annotation.WebServlet(name = "servletdao")
public class servletdao extends javax.servlet.http.HttpServlet {


    public servletdao() {
        // TODO Auto-generated constructor stub
    }

    public void init()   {

//        System.out.println("Servlet02执行了init");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        response.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
// TODO Auto-generated method stub
        response.setContentType("text/html");

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectD = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONObject jsonObject3 = new JSONObject();
        JSONObject jsonObject4 = new JSONObject();
        JSONArray jsons = new JSONArray();
        JSONArray jsons1 = new JSONArray();
        JSONArray jsons2 = new JSONArray();
        JSONArray jsons3 = new JSONArray();

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
        String reg_no = request.getParameter("reg_no");
        String com_name = request.getParameter("com_name");

        String pro="";
        String DWTZ="";
        String[] arr={"",""};
        ArrayList<String> GG_list=new ArrayList<String>();
        try {
            //界面的基本信息

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
            Company2 company2 = new Company2();
            ArrayList<String> li = new ArrayList<String>();
            sql1 = "select * from company2 where reg_no=?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, reg_no);
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                company2.setZB(rs1.getString("ZB"));
                if (!rs1.getString("YZ").contains("企业联系电话")) {
                    company2.setYZ(rs1.getString("YZ"));
                }

                company2.setYX(rs1.getString("YX"));
                company2.setRQ(rs1.getString("RQ"));
                company2.setReg_no(rs1.getString("reg_no"));
                company2.setLX(rs1.getString("LX"));
                company2.setHZRQ(rs1.getString("HZRQ"));
                company2.setFW(rs1.getString("FW"));
                company2.setFD(rs1.getString("FD"));
                company2.setDJZT(rs1.getString("DJZT"));
                company2.setDJJG(rs1.getString("DJJG"));
                company2.setCom_name(rs1.getString("com_name"));
                company2.setAddr(rs1.getString("Addr"));
                if (!rs1.getString("DH").contains("企业电子邮箱")) {
                    company2.setDH(rs1.getString("DH"));
                }
                company2.setDWTZ(rs1.getString("DWTZ"));
                company2.setXzxk(rs1.getString("xzxk"));
                company2.setXzcf(rs1.getString("xzcf"));
                company2.setSubcom(rs1.getString("subcom"));
                company2.setKey_person(rs1.getString("key_person"));
                company2.setJyycml(rs1.getString("jyycml"));
                company2.setHmd(rs1.getString("hmd"));
                company2.setCom_url(rs1.getString("com_url"));
                System.out.print("servletdao的company2 wei"+company2.toString());
                pro=rs1.getString("PRO");
                String url=company2.getCom_url();
                if (url.length()>4){
                    if (!(url.contains("http"))){
                        if (!(url.contains("www"))){
                            url="www."+url;
                        }
                        url="http://"+url;
                    }
                }else {
                    url="无";
                }
                company2.setCom_url(url);
                //得到分公司,过滤掉杂数据
                if (!(company2.getSubcom().equals("无"))&&!(company2.getSubcom().contains("暂无相关数据"))&&company2.getSubcom().length()>7) {
//                   eg：
//                    ,北京中业汇智教育科技有限公司南京分公司
//                    · 统一社会信用代码/注册号 :
//                    · 登记机关 : 北京市工商行政管理局西城分局,北京中业汇智教育科技有限公司杭州分公司
//                    · 统一社会信用代码/注册号 :
//                    · 登记机关 : 北京市工商行政管理局西城分局


                    if (pro.contains("上海")||pro.contains("江苏")||pro.contains("北京")||pro.contains("福建")||pro.contains("海南")||pro.contains("浙江")||pro.contains("广东")) {
                        String[] array = company2.getSubcom().split(",");
                        for (int j = 1; j <= array.length - 1; j++) {

                            String com = array[j].split("\n")[0];
//                        System.out.println("分公司的名字为"+com);
                            jsonObject3.put("company2F" + String.valueOf(j), com);//从零开始
                        }
                    }

                    else {
//                        eg：
//                        ,安徽朱家桥水泥有限公司,· 注册号：3400001303,· 登记机关：经济技术开发区市场监督管理局.,宁波海螺水泥有限公司,· 注册号：3400001304,.,南通海螺水泥有限责任公司,· 注册号：3400001554,.,上海海螺水泥有限公司,· 注册号：3400001570,.,揭阳海螺水泥有限公司,· 注册号：3400001571,.,宁波保税区海螺贸易公司,· 注册号：3400001575,.,张家港海螺水泥有限公司,· 注册号：3400001572,.,安徽海螺机电设备有限公司,· 注册号：3400001576,· 登记机关：芜湖市工商行政管理局.,安徽长丰海螺水泥有限公司,· 注册号：3400001573,· 登记机关：长丰县市场监督管理局.

                        //安徽、山西、贵州、黑龙江
                        if (company2.getSubcom().contains(".,")) {
                            String[] array = company2.getSubcom().split("\\.,");
                            for (int j = 0; j <= array.length - 1; j++) {
                                if (j==0){
                                    String com = array[j].split(",")[1];
                                    jsonObject3.put("company2F" + String.valueOf(j+1), com);//从零开始
                                }else{
                                    String com = array[j].split(",")[0];
                                    jsonObject3.put("company2F" + String.valueOf(j+1), com);//从零开始
                                }
                            }
                        }else {
                            String com = company2.getSubcom().split(",")[1];
                            jsonObject3.put("company2F" + String.valueOf(1), com);//从零开始
                        }
                    }
                }
                if (!(company2.getKey_person().equals("无"))&&!(company2.getKey_person().contains("暂无相关数据"))&&company2.getKey_person().length()>7) {
                    if (pro.contains("江苏")||pro.contains("北京")||pro.contains("福建")||pro.contains("浙江")||pro.contains("广东")||pro.contains("海南")){
//                    eg：
//                        ,余建美
//                        董事,会鹏
//                        董事,骆晓鸣
//                        董事,朱俊岗
//                        董事,朱峰
//                        董事长

                        //将所得，，替换掉
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
                        System.out.println("servletdao  replaceall后的key"+key_person);

                        String[] array = key_person.split(",");
                        int j=1;
                        for (int i = 1; i <= array.length - 1; j++,i++) {
                            if (array[j].contains("\n")) {
                                String person = array[j].split("\n")[0];
                                String Position = array[j].split("\n")[1];

                                //如果之前已经给出了这个人的职位
                                if (!GG_list.contains(person)) {
                                    jsonObject4.put("company2Pe" + String.valueOf(j), person);//从零开始
                                    jsonObject4.put("company2Po" + String.valueOf(j), Position);//从零开始
                                    GG_list.add(person);
                                }
                            }else{
                                //如果两个人连在一起写
                                String person = array[j];
                                String Position = array[(j+1)].split("\n")[1];
                                if (!GG_list.contains(person)) {
                                    jsonObject4.put("company2Pe" + String.valueOf(j), person);//从零开始
                                    jsonObject4.put("company2Po" + String.valueOf(j), Position);//从零开始
                                    GG_list.add(person);
                                }

                            }
                        }

                    }else {
                        //,凌人枫:董事,丁友建:董事,刘军:董事,陈勇明:董事,王建华:董事,刘军:董事长,王国胜:董事,吴俊福:董事,陆东:
                        //上海、贵州、安徽、黑龙江、山西
                        String[] array = company2.getKey_person().split(",");
                        for (int j = 1; j <= array.length - 1; j++) {

                            if (array[j].contains(":")) {
                                String person = array[j].split(":")[0];
                                String Position = array[j].split(":")[1];

//                        System.out.println("高管的名字为"+person);
//                        System.out.println("高管的职位为"+Position);
                                jsonObject4.put("company2Pe" + String.valueOf(j), person);//从零开始
                                jsonObject4.put("company2Po" + String.valueOf(j), Position);//从零开始
                            }
                        }
                    }
                }

//if (com_name.contains("贵州")) {
                if (!(company2.getDWTZ().equals("无")) && !(company2.getDWTZ().contains("暂无相关数据")) && company2.getDWTZ().length() > 7) {

                    if (pro.contains("上海")||pro.contains("江苏")||pro.contains("北京")||pro.contains("福建")||pro.contains("浙江")||pro.contains("广东")||pro.contains("海南")) {
//                eg：
//            ,江苏乾泰资产管理有限公司
//            · 统一社会信用代码/注册号 : 91320211MA1MB7WYX7,前海开鑫金服（深圳）投资有限公司
//            · 统一社会信用代码/注册号 : 91440300MA5DN2AU88,无锡开鑫网络借贷信息中介有限公司
//            · 统一社会信用代码/注册号 : 91320211MA1MY2499A,江苏开鑫分享绿色金融有限公司
//            · 统一社会信用代码/注册号 : 91320105MA1Q5X835W,江苏开金互联网金融资产交易中心有限公司
//            · 统一社会信用代码/注册号 : 91320211MA1MR0G91G,开鑫金服（南京）信息服务有限公司
//            · 统一社会信用代码/注册号 : 91320114MA1RAAT69K

                        DWTZ = company2.getDWTZ();
                        arr = null;
                        arr = company2.getDWTZ().split(",");
                        for (int j = 1; j <= arr.length - 1; j++) {
                            arr[j] = arr[j].split("\n")[0];
                        }

                    } else {
//            eg：
//            ,安顺市西秀区农业产业发展投资有限责任公司,· 统一社会信用代码/注册号： 91520402MA6DL6LB48.,安顺市西秀区扶贫开发经营有限公司,· 统一社会信用代码/注册号： 91520402MA6DR50X0C.,安顺市西秀区水利水电建设发展投资有限公司,· 统一社会信用代码/注册号： 91520402090327807E.
                        //贵州、安徽、黑龙江、山西
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
//                System.out.println("西山煤电（集团）有限责任公司"+arr[j]);
                                }
                            } else {
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
                    }
                }

//                System.out.println(li.toString());

//                System.out.println(company2.toString());
                //界面基本信息

//                jsonObject.put("FW",rs1.getString("FW"));


//                jsons2.add(jsons);
            }
            sql1 = "select * from info where reg_no=?";
            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, reg_no);
            rs1 = stmt1.executeQuery();
            int j=0;
            while (rs1.next()) {
                company2.setJJ(rs1.getString("info"));
                jsonObject.put("company2", company2);
                j=1;
            }
            if (j==0) {
                jsonObject.put("company2", company2);
            }
            jsons.add(jsonObject);
            jsons.add(jsonObject3);
            jsons.add(jsonObject4);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
        //根据投资的公司继续搜索,找出对外投资的公司的基本信息
        if (DWTZ.length()>5) {
//            arr[1]=arr[1].substring(1);
            try {
                if (arr[1].length()>2||arr[0].length()>2) {
                    int i = 0;
                    int x=0;
                    if (pro.contains("上海")||pro.contains("江苏")||pro.contains("北京")||pro.contains("福建")){
                        x=1;
                    }
                    for (int j =x; j <= arr.length - 1; j++) {
                        sql2 = "select * from company2 where com_name=?";
//            System.out.print("select * from com wh1ere reg_no=" + rowkey);
                        stmt2 = conn.prepareStatement(sql2);

                        stmt2.setString(1, arr[j]);
//                        System.out.println("arr[j]为"+arr[j]);
//                System.out.println(arr[j]);
                        rs2 = stmt2.executeQuery();
                        Company2 company2 = new Company2();
                        company2.setCom_name(arr[j]);
                        while (rs2.next()) {
                            company2.setZB(rs2.getString("ZB"));
                            company2.setYZ(rs2.getString("YZ"));
                            company2.setYX(rs2.getString("YX"));
                            company2.setRQ(rs2.getString("RQ"));
                            company2.setReg_no(rs2.getString("reg_no"));
                            company2.setLX(rs2.getString("LX"));
                            company2.setHZRQ(rs2.getString("HZRQ"));
                            company2.setFW(rs2.getString("FW"));
                            company2.setFD(rs2.getString("FD"));
                            company2.setDJZT(rs2.getString("DJZT"));
                            company2.setDJJG(rs2.getString("DJJG"));
                            company2.setCom_name(rs2.getString("com_name"));
                            company2.setAddr(rs2.getString("Addr"));
                            company2.setDH(rs2.getString("DH"));
                            company2.setDWTZ(rs2.getString("DWTZ"));
                            company2.setJJ(rs2.getString("JJ"));


                        }
                        jsonObjectD.put("company2" + String.valueOf(i), company2);//从零开始
                        i++;
//                jsonObject.put("FW",rs1.getString("FW"));

                    }
                    jsons3.add(jsonObjectD);
                }
            } catch (Exception ex) {
                ex.printStackTrace();

            } finally {

            }
        }
//        jsons.add(jsonObject);
        try {//查找公司的行业以及所处省份
            sql2 = "select * from company1 where reg_no=?";

            stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, reg_no);
            rs2 = stmt2.executeQuery();

            while (rs2.next()) {
                Company1 company1 = new Company1();
                company1.setFW(rs2.getString("FW"));
                company1.setPRO(rs2.getString("PRO"));
                company1.setReg_no(rs2.getString("reg_no"));

//                System.out.println(company1.toString());
                jsonObject1.put("company1", company1);
                //                jsonObject.put("FW",rs1.getString("FW"));
                jsons.add(jsonObject1);

            }
            //    jsons.add(jsonObject);


        }catch (Exception ex) {
            ex.printStackTrace();

        } finally {

        }

        try {//查找公司的股东以及其基本信息


            sql3 = "select * from ysgd where reg_no=?";

            stmt3 = conn.prepareStatement(sql3);
            stmt3.setString(1, reg_no);
            rs3 = stmt3.executeQuery();
            ArrayList<GD> li=new ArrayList<GD>();
            while (rs3.next()) {

                GD gd=new GD();
                gd.setGD_name(rs3.getString("GD_name"));
                gd.setGDBL(Double.parseDouble(rs3.getString("GDBL")));
                gd.setGDLX(rs3.getString("GDLX"));

                li.add(gd);
//                System.out.println(company1.toString());
//                jsonObject1.put("company1", company1);
//                jsonObject.put("FW",rs1.getString("FW"));
//                jsons.add(jsonObject1);
            }
//    jsons.add(jsonObject);
            Double sum = 0.00;
            Double ZB=null;
            for (int i=0;i<=li.size()-1;i++){
                sum+=li.get(i).getGDBL();
            }
            for (int i=0;i<=li.size()-1;i++){
                ZB=((Double)(li.get(i).getGDBL()/sum))*100;
//                System.out.println(ZB);
                DecimalFormat df = new DecimalFormat("#.00");
//                ZB=Double.parseDouble(df.format(ZB));
                li.get(i).setBL(df.format(ZB));

                jsonObject2.put("GD"+String.valueOf(i),li.get(i));
            }
            jsons.add(jsonObject2);
        }catch (Exception ex) {
            ex.printStackTrace();

        } finally {

        }
        String appKey ="70c0388749eed312";
        String query = com_name;
        String salt = String.valueOf(System.currentTimeMillis());
        String from = "zh-CHS";
        String to = "EN";
        String sign = md5(appKey + query + salt+ "Fxw3BA7CfwHqsaSDsqe8Zo8H0JYzcDyY");
        Map params = new HashMap();
        params.put("q", com_name);
        params.put("from", from);
        params.put("to", to);
        params.put("sign", sign);
        params.put("salt", salt);
        params.put("appKey", appKey);
        String result="";
        try {

            result=requestForHttp("http://openapi.youdao.com/api", params);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }


        jsons2.add(jsons);
        jsons2.add(jsons1);//没用上
        jsons2.add(result);
        jsons2.add(jsons3);

        response.getWriter().print(jsons2);

//        System.out.println("servletdao执行了print");

    }
    public static String requestForHttp(String url,Map requestParams) throws Exception{
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        /**HttpPost   有道词典在线翻译*/
        HttpPost httpPost = new HttpPost(url);

        System.out.println(new org.json.JSONObject(requestParams).toString());

        List params = new ArrayList();
        Iterator it = requestParams.entrySet().iterator();
        while (it.hasNext()) {
            Entry en = (Entry) it.next();
            String key = (String) en.getKey();
            String value = (String) en.getValue();
            if (value != null) {
                params.add(new BasicNameValuePair(key, value));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
        /**HttpResponse*/
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try{
            HttpEntity httpEntity = httpResponse.getEntity();

            result = EntityUtils.toString(httpEntity, "utf-8");
//            System.out.println("fdsfds"+result);

            EntityUtils.consume(httpEntity);
        }finally{
            try{
                if(httpResponse!=null){
                    httpResponse.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return result;


    }

    /**
     * 生成32位MD5摘要
     * @param string
     * @return
     */
    public static String md5(String string) {
        if(string == null){
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        try{
            byte[] btInput = string.getBytes("utf-8");
            /** 获得MD5摘要算法的 MessageDigest 对象 */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** 使用指定的字节更新摘要 */
            mdInst.update(btInput);
            /** 获得密文 */
            byte[] md = mdInst.digest();
            /** 把密文转换成十六进制的字符串形式 */
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * 根据api地址和参数生成请求URL
     * @param url
     * @param params
     * @return
     */
    public static String getUrlWithQueryString(String url, Map params) {
        if (params == null) {
            return url;
        }

        StringBuilder builder = new StringBuilder(url);
        if (url.contains("?")) {
            builder.append("&");
        } else {
            builder.append("?");
        }

        int i = 0;
        for (Object key : params.keySet()) {
            String value = (String) params.get(key);
            if (value == null) { // 过滤空的key
                continue;
            }

            if (i != 0) {
                builder.append('&');
            }

            builder.append(key);
            builder.append('=');
            builder.append(encode(value));

            i++;
        }

        return builder.toString();
    }
    /**
     * 进行URL编码
     * @param input
     * @return
     */
    public static String encode(String input) {
        if (input == null) {
            return "";
        }

        try {
            return URLEncoder.encode(input, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return input;
    }
}
