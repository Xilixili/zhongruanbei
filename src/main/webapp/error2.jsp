<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <div class="fanhui">
        <a href="main1.jsp">返回首页</a>
    </div>
</div><!--naver结束-->
<div class="shibai">
    <div class="img">
        <img src="Error/images/shibailogo.png">
    </div>
    <div class="letter">
        <p>暂时没有搜索到您所查询的信息，小C感到很抱歉~<br>您可以在此提交有效公司名称，我们将在1-3个工作日内添加相关信息。</p>
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
</div><!--shibai结束-->


</body>
</html>