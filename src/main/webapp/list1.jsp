<%@ page import="com.hmz.entity.Company2" %>
<%@ page import="com.hmz.dao.impl.CompanyDaoImpl" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jojoba
  Date: 2018/6/15
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>企业信息</title>
    <link rel="icon" href="JG/images/favicon.ico" type="image/x-icon">

    <!-- BOOTSTRAPE STYLESHEET CSS FILES -->
    <link rel="stylesheet" href="JG/css/bootstrap.min.css">

    <!-- JQUERY SELECT -->
    <link href="JG/css/select2.min.css" rel="stylesheet" />

    <!-- JQUERY MENU -->
    <link rel="stylesheet" href="JG/css/mega_menu.min.css">

    <!-- ANIMATION -->
    <link rel="stylesheet" href="JG/css/animate.min.css">

    <!-- OWl  CAROUSEL-->
    <link rel="stylesheet" href="JG/css/owl.carousel.css">
    <link rel="stylesheet" href="JG/css/owl.style.css">

    <!-- TEMPLATE CORE CSS -->
    <link rel="stylesheet" href="JG/css/style3.css">

    <!-- FONT AWESOME -->
    <link rel="stylesheet" type="text/css" href="JG/css/font-awesome.min.css">
    <link rel="stylesheet" href="JG/css/et-line-fonts.css" type="text/css">

    <!-- Google Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,900" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="JG/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="JG/css/default.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="JG/css/search-form.css" />
    <link href="JG/css/home.css"  rel="stylesheet" type="text/css">
    <link href="JG/css/style2.css" rel="stylesheet" type="text/css">
    <link href="JG/css/style.css"  rel="stylesheet" type="text/css">
    <script src="JG/js/jquery.min.js"></script>
    <script src="JG/js/modernizr.js"></script> <!-- Modernizr -->
    <!-- JavaScripts -->
    <script src="JG/js/modernizr1.js"></script>
    <script src="JG/jquery/jquery-3.3.1.min.js"></script>
    <script src="JG/dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="nav">
    <%--<div class="selectbox" style="height:50px;">--%>
        <%--<div class="selemediv">--%>
            <%--<div class="selemenu " >--%>
                <%--<span class="sqinput">公司</span><span class="csinput"></span></div>--%>

            <%--<div class="citylist2">--%>
                <%--<div class="xzk">--%>
                    <%--<div class="leibie">查找范围</div>--%>
                    <%--<ul class="shangquan">--%>
                        <%--<li class="active">企业名</li>--%>
                        <%--<li>法人或股东</li>--%>
                        <%--<li style="width:7%">高管</li>--%>
                        <%--<li>品牌/产品</li>--%>
                        <%--<li>经营范围</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="xzk">--%>
                    <%--<div class="leibie">企业类型</div>--%>
                    <%--<ul class="chengshi">--%>
                        <%--<li class="active">有限责任公司</li>--%>
                        <%--<li>股份有限公司</li>--%>
                        <%--<li style="width:7%">国企</li>--%>
                        <%--<li>外商投资企业</li>--%>
                        <%--<li>独资企业</li>--%>
                        <%--<li>合伙制企业</li>--%>
                        <%--<li>个体工商户</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="xzk">--%>
                    <%--<div class="leibie">注册资本</div>--%>
                    <%--<ul class="chengshi">--%>
                        <%--<li class="active">500万以下</li>--%>
                        <%--<li>500~1000万</li>--%>
                        <%--<li>1000~5000万</li>--%>
                        <%--<li>5000万以上</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="xzk">--%>
                    <%--<div class="leibie">成立日期</div>--%>
                    <%--<ul class="chengshi">--%>
                        <%--<li class="active" style="width:7%">2018</li>--%>
                        <%--<li style="width:7%">2017</li>--%>
                        <%--<li style="width:7%">2016</li>--%>
                        <%--<li style="width:7%">2015</li>--%>
                        <%--<li style="width:7%">2014</li>--%>
                        <%--<li style="width:7%">其他</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="xzk">--%>
                    <%--<div class="leibie">省份地区</div>--%>
                    <%--<ul class="chengshi">--%>
                        <%--<li class="active"style="width:7%">安徽</li>--%>
                        <%--<li style="width:7%">北京</li>--%>
                        <%--<li style="width:7%">重庆</li>--%>
                        <%--<li style="width:7%">福建</li>--%>
                        <%--<li style="width:7%">广东</li>--%>
                        <%--<li style="width:7%">甘肃</li>--%>
                        <%--<li style="width:7%">广西</li>--%>
                        <%--<li style="width:7%">贵州</li>--%>
                        <%--<li style="width:7%">海南</li>--%>
                        <%--<li style="width:7%">河北</li>--%>
                        <%--<li style="width:7%">河南</li>--%>
                        <%--<li style="width:13%">香港特别行政区</li>--%>
                        <%--<li style="width:7%">黑龙江</li>--%>
                        <%--<li style="width:7%">湖北</li>--%>
                        <%--<li style="width:7%">湖南</li>--%>
                        <%--<li style="width:7%">吉林</li>--%>
                        <%--<li style="width:7%">江苏</li>--%>
                        <%--<li style="width:7%">江西</li>--%>
                        <%--<li style="width:7%">辽宁</li>--%>
                        <%--<li style="width:7%">内蒙古</li>--%>
                        <%--<li style="width:7%">宁夏</li>--%>
                        <%--<li style="width:7%">青海</li>--%>
                        <%--<li style="width:7%">陕西</li>--%>
                        <%--<li style="width:7%">四川</li>--%>
                        <%--<li style="width:7%">山东</li>--%>
                        <%--<li style="width:7%">上海</li>--%>
                        <%--<li style="width:7%">山西</li>--%>
                        <%--<li style="width:7%">天津</li>--%>
                        <%--<li style="width:7%">台湾省</li>--%>
                        <%--<li style="width:7%">新疆</li>--%>
                        <%--<li style="width:7%">西藏</li>--%>
                        <%--<li style="width:7%">云南</li>--%>
                        <%--<li style="width:7%">浙江</li>--%>
                        <%--<li style="width:7%">总局</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="selemediv">--%>
            <%--<div class="selemenu " >--%>
                <%--<span class="sqinput">风险信息</span><span class="csinput"></span></div>--%>

            <%--<div class="citylist2">--%>
                <%--<div class="xzk">--%>
                    <%--<div class="leibie">查找范围</div>--%>
                    <%--<ul class="shangquan">--%>
                        <%--<li class="active">法院公告</li>--%>
                        <%--<li>裁判文书</li>--%>
                        <%--<li style="width:7%">失信人</li>--%>
                        <%--<li>被执行人</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="xzk">--%>
                    <%--<div class="leibie">时间</div>--%>
                    <%--<ul class="chengshi">--%>
                        <%--<li class="active" style="width:7%">2018</li>--%>
                        <%--<li style="width:7%">2017</li>--%>
                        <%--<li style="width:7%">2016</li>--%>
                        <%--<li style="width:7%">2015</li>--%>
                        <%--<li style="width:7%">2014</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="xzk">--%>
                    <%--<div class="leibie">省份地区</div>--%>
                    <%--<ul class="chengshi">--%>
                        <%--<li class="active"style="width:7%">安徽</li>--%>
                        <%--<li style="width:7%">北京</li>--%>
                        <%--<li style="width:7%">重庆</li>--%>
                        <%--<li style="width:7%">福建</li>--%>
                        <%--<li style="width:7%">广东</li>--%>
                        <%--<li style="width:7%">甘肃</li>--%>
                        <%--<li style="width:7%">广西</li>--%>
                        <%--<li style="width:7%">贵州</li>--%>
                        <%--<li style="width:7%">海南</li>--%>
                        <%--<li style="width:7%">河北</li>--%>
                        <%--<li style="width:7%">河南</li>--%>
                        <%--<li style="width:7%">黑龙江</li>--%>
                        <%--<li style="width:7%">湖北</li>--%>
                        <%--<li style="width:7%">湖南</li>--%>
                        <%--<li style="width:7%">江苏</li>--%>
                        <%--<li style="width:7%">江西</li>--%>
                        <%--<li style="width:7%">辽宁</li>--%>
                        <%--<li style="width:7%">宁夏</li>--%>
                        <%--<li style="width:7%">青海</li>--%>
                        <%--<li style="width:7%">陕西</li>--%>
                        <%--<li style="width:7%">四川</li>--%>
                        <%--<li style="width:7%">山东</li>--%>
                        <%--<li style="width:7%">上海</li>--%>
                        <%--<li style="width:7%">山西</li>--%>
                        <%--<li style="width:7%">天津</li>--%>
                        <%--<li style="width:7%">新疆</li>--%>
                        <%--<li style="width:7%">云南</li>--%>
                        <%--<li style="width:7%">浙江</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>



        <%--<div class="selemediv">--%>
            <%--<div class="selemenu " >--%>
                <%--<span class="sqinput">知识产权</span><span class="csinput"></span></div>--%>

            <%--<div class="citylist2" style="width:1000px;">--%>
                <%--<div class="xzk" style="width:800px;">--%>
                    <%--<div class="leibie">查找范围</div>--%>
                    <%--<ul class="shangquan" style="width:700px;">--%>
                        <%--<li class="active">商标</li>--%>
                        <%--<li>专利</li>--%>
                        <%--<li >著作权</li>--%>
                        <%--<li>软件著作权</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="xzk" style="width:800px;">--%>
                    <%--<div class="leibie">时间</div>--%>
                    <%--<ul class="chengshi" style="width:700px;">--%>
                        <%--<li class="active" style="width:7%">2018</li>--%>
                        <%--<li style="width:7%">2017</li>--%>
                        <%--<li style="width:7%">2016</li>--%>
                        <%--<li style="width:7%">2015</li>--%>
                        <%--<li style="width:7%">2014</li>--%>
                        <%--<li style="width:7%">2013</li>--%>
                        <%--<li style="width:7%">2012</li>--%>
                        <%--<li style="width:7%">2011</li>--%>
                        <%--<li style="width:7%">2010</li>--%>
                        <%--<li style="width:7%">2009</li>--%>
                        <%--<li style="width:7%">2008</li>--%>
                        <%--<li style="width:7%">2007</li>--%>
                        <%--<li style="width:7%">2006</li>--%>
                        <%--<li style="width:7%">2005</li>--%>
                        <%--<li style="width:7%">2004</li>--%>
                        <%--<li style="width:7%">2003</li>--%>
                        <%--<li style="width:7%">2002</li>--%>
                        <%--<li style="width:7%">2001</li>--%>
                        <%--<li style="width:7%">2000</li>--%>
                        <%--<li style="width:7%">1999</li>--%>
                        <%--<li style="width:7%">1998</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>

            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>



    <%--<div class="denglu">--%>
        <%--<a href="#">登录&nbsp;/&nbsp;注册</a>--%>
    <%--</div>--%>
    <%--<form class="form-inline" action="Company_querybypart">--%>
    <form class="form-inline" action="Company_querybypart.action">
        <input class="form-control mr-sm-2" name="com_name" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><span class="glyphicon glyphicon-search"></span>
        </button>
    </form>
    <div style="height:500px; color:#fff" id="cs"></div>
</div><!--nav结束-->
<script>
    $(".selemenu").click(function(){
        $(this).next().slideToggle();
        $(this).parents().siblings().find(".citylist,.citylist2").slideUp();
        $(".information").css("margin-top","500px");
        var text=$(this).children().text();
        $("#info_th").html(text);
    })

    $(".shangquan li").click(function(){
        $(".shangquan li").removeClass("active")
        $(this).addClass("active")
    })
    $(".chengshi li").click(function(){
        $(".chengshi li").removeClass("active")
        $(this).addClass("active")
    })
    $(function(){
        $(document).not($(".selectbox")).click(function(){
            $(".citylist,.citylist2").slideUp();
            $(".information").css("margin-top","0px");
        })
        $(".selectbox").click(function(event){
            event.stopPropagation();
        })
    })
</script>


<%--以上为筛选内容--%>


<div class="information" id="infohead">
    <section>
        <table class="info_table">


            <thead>
            <tr>
                <th id="info_th" style="color:#000;padding-left:10px;">公司</th>
                <th></th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </section>
</div>


<%
    Company2 company2=new Company2();

    CompanyDaoImpl companyDao=new CompanyDaoImpl();
//
//    Job job = new Job();
//    Dao dao = new Dao();
    ArrayList<Company2> list = companyDao.getAll();
    int pagesum=list.size()/9+1;
    System.out.println("hhhh");
    String current_page=request.getParameter("current_page");
    if (current_page==null){
        current_page = "1";
    }


//    System.out.println("我是执行了的");
    System.out.println(current_page);


    if (list != null && list.size() >0) {
        for (int i = 0; i <= list.size()-1; i++) {
            if (i>=(Integer.valueOf(current_page)-1)*9&&i<Integer.valueOf(current_page)*9){
                //提取表中前面九条信息
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

<div class="information">
    <section>
        <table class="info_table">

            <tbody>
            <tr>
                <td><img src="images/GG.png"></td>
                <td>
                    <a href="/xinxi.jsp?reg_no=<%=company2.getReg_no()%>&Addr=<%=company2.getAddr()%>&com_name=<%=company2.getCom_name()%>">
                        <%=company2.getCom_name()%>
                    </a>
                    <p>法定代表人：<a href="#"><%=company2.getFD()%></a> <span>注册资本：<%=company2.getZB()%></span><span>成立时间：<%=company2.getRQ()%></span></p>
                    <p>邮箱：<%=company2.getYX()%> <span>电话:<%=company2.getDH()%></span></p>
                    <p>地址：<%=company2.getAddr()%></p>
                </td>
            </tr>
            </tbody>
        </table>
    </section>
</div>



<%
            }
        }
    }
%>

<div id="app">
    <div>
        <div class="page"  v-show="show">
            <div class="pagelist">
                <a href="list1.jsp?current_page=<%=Integer.valueOf(current_page)-1%>"><span class="jump" :class="{disabled:pstart}" @click="{current_page--}">上一页</span></a>
                <span v-show="current_page>5" class="jump" @click="jumpPage(1)">1</span>
                <span class="ellipsis"  v-show="efont">...</span>
                <a href="" id="linkToCart1"><span class="jump"  id="num" v-for="num in indexs" :class="{bgprimary:current_page==num}" @click="jumpPage(num)">{{num}}</span></a>
                <span class="ellipsis"  v-show="ebehind">...</span>

                <a href="list1.jsp?current_page=<%=Integer.valueOf(current_page)+1%>"> <span :class="{disabled:pend}" class="jump" @click="{current_page++}">下一页</span></a>
                <span v-show="current_page<pages-4" class="jump" @click="jumpPage(pages)">{{pages}}</span>

                <span class="jumppoint">跳转到：</span>
                <span class="jumpinp"><input type="text" id="tiaozhuan" v-model="changePage"></span>
                <a href="" id="linkToCart"><span class="jump gobtn" @click="jumpPage(changePage)">GO</span></a>
            </div>
        </div>
    </div>
</div>



<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        //点击链接的时候调用
        $("#linkToCart").click(function(){

            //得到input的值
            // var count = $("#inputId").val();

            //得到id的值
            var current_page = $("#tiaozhuan").val()
            //设置linkToCart的href的值
            $("#linkToCart").attr("href","list1.jsp?current_page="+current_page);//动态添加跳转href
        });
    });
</script>
<script src="js/vue.js"></script>
<script>
    var newlist = new Vue({
        el: '#app',
        data: {
            current_page: <%=current_page%>, //当前页
            pages: <%=pagesum%>, //总页数
            changePage:'',//跳转页
            nowIndex:0
        },
        computed:{
            show:function(){
                return this.pages && this.pages !=1
            },
            pstart: function() {
                return this.current_page == 1;
            },
            pend: function() {
                return this.current_page == this.pages;
            },
            efont: function() {
                if (this.pages <= 7) return false;
                return this.current_page > 5
            },
            ebehind: function() {
                if (this.pages <= 7) return false;
                var nowAy = this.indexs;
                return nowAy[nowAy.length - 1] != this.pages;
            },
            indexs: function() {

                var left = 1,
                    right = this.pages,
                    ar = [];
                if (this.pages >= 7) {
                    if (this.current_page > 5 && this.current_page < this.pages - 4) {
                        left = Number(this.current_page) - 3;
                        right = Number(this.current_page) + 3;
                    } else {
                        if (this.current_page <= 5) {
                            left = 1;
                            right = 7;
                        } else {
                            right = this.pages;

                            left = this.pages - 6;
                        }
                    }
                }
                while (left <= right) {
                    ar.push(left);
                    left++;
                }
                return ar;
            },
        },
        methods: {
            jumpPage: function(id) {
                this.current_page = id;
                $(document).ready(function(){
                    //点击链接的时候调用
                    $("#linkToCart1").click(function(){

                        //得到input的值
                        // var count = $("#inputId").val();

                        //设置linkToCart的href的值
                        $("#linkToCart1").attr("href","list1.jsp?current_page="+id);
                    });
                });
            },
        },

    })
</script>

//自适应
<script>
    $(window).load(function(){
        var winWidth=$(window).innerWidth();
        var winHeight=$(window).innerHeight();
        $(".selectbox").css("width",(600/1536)*winWidth);
        $(".selemenu ").css("width",(180/1536)*winWidth);
        $(".form-inline").css("margin-right",(20/1536)*winWidth);


    })

</script>
</body>
</html>