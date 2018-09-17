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
    <link rel="stylesheet" href="Error/css/bootstrap.min.css">

    <!-- JQUERY SELECT -->
    <link href="Error/css/select2.min.css" rel="stylesheet" />

    <!-- JQUERY MENU -->
    <link rel="stylesheet" href="Error/css/mega_menu.min.css">

    <!-- ANIMATION -->
    <link rel="stylesheet" href="Error/css/animate.min.css">

    <!-- OWl  CAROUSEL-->
    <link rel="stylesheet" href="Error/css/owl.carousel.css">
    <link rel="stylesheet" href="Error/css/owl.style.css">

    <!-- TEMPLATE CORE CSS -->
    <link rel="stylesheet" href="Error/css/style3.css">

    <!-- FONT AWESOME -->
    <link rel="stylesheet" type="text/css" href="Error/css/font-awesome.min.css">
    <link rel="stylesheet" href="Error/css/et-line-fonts.css" type="text/css">

    <!-- Google Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,900" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="Error/css/style.css" type="text/css">

</head>
<body>
<div class="naver">

    <img src="Error/images/logo.png" alt="Logo" />
</div><!--naver结束-->
<div class="shibai">
    <div class="img">
        <img src="Error/images/shibailogo.png">
    </div>
    <div class="letter">
        <p>wow~搜索失败</p>
        <p>暂时无法显示该公司的相关信息</p>
        <p>系统正在根据您的输入<strong id="GL"></strong>智能推荐搜索结果...请稍等</p>
    </div>
</div><!--shibai结束-->


<script  type="text/javascript">
    $(document).ready(function(){
        com_name=document.getElementById("com_name").value
        $("#GL").html(com_name)
        // alert(com_name)
        $.ajax({
            type : "post",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            data:{
                com_name:com_name
            },
            url : "Servlet8",    //请求发送
            dataType : "json",        //返回数据形式为json
            success : function(data) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
                // alert("成功了")
                    //在原有窗口打开
                    window.location.href = "/error1.jsp?com_name="+com_name;
            },
            error : function(errorMsg) { //没做出错处理
                //请求失败时执行该函数
                // alert("ajax执行失败!");
            }
        })
    })

</script>



<%--<%--%>
    <%--Company2 company2=new Company2();--%>
    <%--CompanyDaoImpl companyDao=new CompanyDaoImpl();--%>
<%--//--%>
<%--//    Job job = new Job();--%>
<%--//    Dao dao = new Dao();--%>
    <%--ArrayList<Company2> list = companyDao.getAllE();--%>
    <%--int pagesum=list.size()/9+1;--%>
    <%--System.out.println("hhhh");--%>
    <%--String current_page=request.getParameter("current_page");--%>
    <%--if (current_page==null){--%>
        <%--current_page = "1";--%>
    <%--}--%>


<%--//    System.out.println("我是执行了的");--%>
    <%--System.out.println(current_page);--%>
<%--//    System.out.println(list.get(0).toString());--%>
    <%--if (list != null && list.size() > 0) {--%>
        <%--for (int i = 0; i < list.size()-1; i++) {--%>
            <%--if (i>=(Integer.valueOf(current_page)-1)*9&&i<Integer.valueOf(current_page)*9){--%>
                <%--//提取表中前面九条信息--%>
                <%--company2.setZB(list.get(i).getZB());--%>
                <%--company2.setYZ(list.get(i).getYZ());--%>
                <%--company2.setYX(list.get(i).getYX());--%>
                <%--company2.setRQ(list.get(i).getRQ());--%>
                <%--company2.setReg_no(list.get(i).getReg_no());--%>
                <%--company2.setLX(list.get(i).getLX());--%>
                <%--company2.setHZRQ(list.get(i).getHZRQ());--%>
                <%--company2.setFW(list.get(i).getFW());--%>
                <%--company2.setFD(list.get(i).getFD());--%>
                <%--company2.setDJZT(list.get(i).getDJZT());--%>
                <%--company2.setDJJG(list.get(i).getDJJG());--%>
                <%--company2.setCom_name(list.get(i).getCom_name());--%>
                <%--company2.setAddr(list.get(i).getAddr());--%>
                <%--company2.setDH(list.get(i).getDH());--%>
<%--%>--%>

<%--<div class="information">--%>
    <%--<section>--%>
        <%--<table class="info_table">--%>

            <%--<tbody>--%>
            <%--<tr>--%>
                <%--<td><img src="images/GG.png"></td>--%>
                <%--<td>--%>
                    <%--<a href="/xinxi.jsp?reg_no=<%=company2.getReg_no()%>&Addr=<%=company2.getAddr()%>&com_name=<%=company2.getCom_name()%>">--%>
                        <%--<%=company2.getCom_name()%>--%>
                    <%--</a>--%>
                    <%--<p>法定代表人：<a href=""><%=company2.getFD()%></a> <span>注册资本：<%=company2.getZB()%></span><span>成立时间：<%=company2.getRQ()%></span></p>--%>
                    <%--<p>邮箱：<%=company2.getYX()%> <span>电话:<%=company2.getDH()%></span></p>--%>
                    <%--<p>地址：<%=company2.getAddr()%></p>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--</tbody>--%>
        <%--</table>--%>
    <%--</section>--%>
<%--</div>--%>



<%--<%--%>
            <%--}--%>
        <%--}--%>
    <%--}--%>
<%--%>--%>


<input type="hidden" id='com_name' value="${com_name}" />

</body>
</html>