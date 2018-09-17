<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.hmz.entity.Company2" %>
<%@ page import="com.hmz.dao.impl.CompanyDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hmz.servlet.Servlet8" %><%--
  Created by IntelliJ IDEA.
  User: jojoba
  Date: 2018/7/20
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>搜索失败</title>
    <script src="JG/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>

    <!-- BOOTSTRAPE STYLESHEET CSS FILES -->
    <link rel="stylesheet" href="Error/Error/css/bootstrap.min.css">

    <!-- JQUERY SELECT -->
    <link href="Error/Error/css/select2.min.css" rel="stylesheet" />

    <!-- JQUERY MENU -->
    <link rel="stylesheet" href="Error/Error/css/mega_menu.min.css">

    <!-- ANIMATION -->
    <link rel="stylesheet" href="Error/Error/css/animate.min.css">

    <!-- OWl  CAROUSEL-->
    <link rel="stylesheet" href="Error/Error/css/owl.carousel.css">
    <link rel="stylesheet" href="Error/Error/css/owl.style.css">

    <!-- TEMPLATE CORE CSS -->
    <link rel="stylesheet" href="Error/Error/css/style3.css">

    <!-- FONT AWESOME -->
    <link rel="stylesheet" type="text/css" href="Error/Error/css/font-awesome.min.css">
    <link rel="stylesheet" href="Error/Error/css/et-line-fonts.css" type="text/css">

    <!-- Google Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,900" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="Error/Error/css/style.css" type="text/css">

</head>
<body>
<%
    String com_name=request.getParameter("com_name");
//    System.out.println("error传过来的com_name为"+com_name);
%>
<div class="naver">
    <img src="Error/Error/images/logo.png" alt="Logo" />
    <div class="fanhui">
        <a href="main1.jsp">返回首页</a>
    </div>
</div><!--naver结束-->
<div class="shibai">
    <div class="img">
        <img src="Error/Error/images/shibailogo.png">
        <%--<p>wow~搜索失败</p>--%>
        <%--<p>暂时无法显示该公司的相关信息</p>--%>

    </div>
    <div class="letter">
            <p>暂时没有搜索到您所查询的公司，小C感到很抱歉~<br>您可以在此提交有效公司名称，我们将在1-3个工作日内添加相关信息。</p>

    </div>
        <div>
            <s:form class="form-inline" action="Company_Esubmit" method="post" namespace="/">
                <div class="form-group mx-sm-3 mb-2" >
                    <label for="inputPassword2" class="sr-only">请填写有效公司名称</label>
                    <input type="text" class="form-control"  name="com_name" id="inputPassword2" placeholder="请填写有效公司名称">
                </div>
                <button type="submit" class="btn btn-primary mb-2" id="bttt">提交</button>
            </s:form>
        </div>

        <%--<p>wow~搜索失败</p>--%>
        <%--<p>暂时无法显示该公司的相关信息</p>--%>
        <%----%>
    <br><br><br>
    <%--<p>这是根据您的输入<strong id="GL"><%=com_name%></strong>智能推荐的搜索结果</p>--%>
    </div>
</div><!--shibai结束-->





<div class="information">
    <section>
        <table class="info_table">
            <thead>
            <tr>
                <th id="info_th" style="color:#000;padding-left:10px;">智能推荐:<%=com_name%></th>
                <th></th>
            </tr>
            </thead>
            <tbody>

            <%
                Company2 company2=new Company2();
                CompanyDaoImpl companyDao=new CompanyDaoImpl();
//
//    Job job = new Job();
//    Dao dao = new Dao();
                ArrayList<Company2> list = companyDao.getAllE();
//                System.out.println("error中智能推荐的长度为"+list.size());
                int pagesum=list.size()/9+1;
                String current_page=request.getParameter("current_page");
                if (current_page==null){
                    current_page = "1";
                }


//    System.out.println("我是执行了的");
//                System.out.println(current_page);
//    System.out.println(list.get(0).toString());
                if (list != null && list.size() > 0) {
                    for (int i = 0; i <= list.size()-1; i++) {
//                        System.out.println("error中智能推荐的长度为"+list.size());

                        if (i>=(Integer.valueOf(current_page)-1)*9&&i<Integer.valueOf(current_page)*9){
                            //提取表中前面九条信息
//                            System.out.println("error中智能推荐的长度为"+list.size());

                            company2.setZB(list.get(i).getZB());
                            company2.setYZ(list.get(i).getYZ());
                            company2.setYX(list.get(i).getYX());
                            company2.setRQ(list.get(i).getRQ());
                            company2.setReg_no(list.get(i).getReg_no());
                            company2.setLX(list.get(i).getLX());
                            company2.setHZRQ(list.get(i).getHZRQ());
                            company2.setFW(list.get(i).getFW());
                            company2.setFD(list.get(i).getFD());
                            company2.setDJZT(list.get(i).getDJZT());
                            company2.setDJJG(list.get(i).getDJJG());
                            company2.setCom_name(list.get(i).getCom_name());
                            company2.setAddr(list.get(i).getAddr());
                            company2.setDH(list.get(i).getDH());
            %>
            <tr>
                <td><img src="Error/Error/images/default.png"></td>
                <td>
                    <a href="/xinxi.jsp?reg_no=<%=company2.getReg_no()%>&Addr=<%=company2.getAddr()%>&com_name=<%=company2.getCom_name()%>">
                        <%=company2.getCom_name()%>
                    </a>
                    <p>法定代表人：<a href=""><%=company2.getFD()%></a> <span>注册资本：<%=company2.getZB()%></span><span>成立时间：<%=company2.getRQ()%></span></p>
                    <p>邮箱：<%=company2.getYX()%> <span>电话:<%=company2.getDH()%></span></p>
                    <p>地址：<%=company2.getAddr()%></p>
                </td>
            </tr>
            <%
                        }
                    }
                }
            %>
            </tbody>
        </table>
    </section>
</div>






<%--<input type="hidden" id='com_name' value="${com_name}" />--%>

</body>
</html>