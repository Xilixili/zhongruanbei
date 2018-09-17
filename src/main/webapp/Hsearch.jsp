<%@ page import="javax.xml.soap.Text" %>
<%@ page import="net.sf.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: jojoba
  Date: 2018/6/4
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>高级搜索</title>
    <link rel="stylesheet" href="HS/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="HS/css/default.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="HS/css/search-form.css" />
    <link rel="stylesheet" type="text/css" href="HS/css/home.css">
    <link href="HS/css/style.css"  rel="stylesheet" type="text/css" >
    <script src="HS/js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="HS/js/jquery-1.4.3.min.js"></script>
    <script type="text/javascript" src="HS/js/main.js"></script>
    <script src="HS/jquery/jquery-3.3.1.min.js"></script>
    <script src="HS/dist/js/bootstrap.min.js"></script>
    <script src="HS/dist/js/jquery.min.js"></script>
</head>
<body>
<%
    JSONObject value= new JSONObject();
%>
<div class="nav">
    <img src="/JG/images/logo1.png" alt="Logo" />
    <div class="fanhui">
        <a href="#">返回首页</a>
    </div>
    <%--<form class="form-inline">--%>
        <%--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
        <%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit"><span class="glyphicon glyphicon-search">--%>
        <%--</button>--%>
    <%--</form>--%>
</div><!--nav结束-->


<div class="main">
    <section class="aui-screen-box" >
        <div class="aui-screen-content" >
            <div class="aui-choice-screen">
                <div class="aui-screen-head-choice">
                    <dl>
                        <dt style="color:#000;">已选条件：</dt>
                        <dd style="display:none" class="aui-clear-delete">
                            <div class="aui-clear-list"></div>
                            <div style="display:none" class="aui-eliminate">清除筛选条件</div>
                        </dd>
                        <div class="button" onclick="sss()"><img src="images/search.png"></div>
                    </dl>

                </div>
                <div id="aui-selectList" class="aui-screen-list-box">
                    <dl class="aui-screen-list-item" attr="terminal_brand_s" style="height:200px;">
                        <dt>省份：</dt>
                        <dd style="height:200px;">
                            <a href="javascript:void(0)" values2="" values1="" attrval="全国">全国</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="北京市">北京市</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="天津市">天津市</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="河北省">河北省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="山西省">山西省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="内蒙古自治区">内蒙古自治区</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="辽宁省">辽宁省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="吉林省">吉林省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="黑龙江省">黑龙江省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="上海市">上海市</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="江苏省">江苏省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="浙江省">浙江省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="安徽省">安徽省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="福建省">福建省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="江西省">江西省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="山东省">山东省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="河南省">河南省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="湖北省">湖北省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="湖南省">湖南省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="广东省">广东省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="广西壮族自治区">广西壮族自治区</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="海南省">海南省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="重庆市">重庆市</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="四川省">四川省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="贵州省">贵州省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="云南省">云南省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="西藏自治区">西藏自治区</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="陕西省">陕西省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="贵州省">贵州省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="甘肃省">甘肃省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="青海省">青海省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="宁夏回族自治区">宁夏回族自治区</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="新疆维吾尔自治区">新疆维吾尔自治区</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="台湾省">台湾省</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="香港特别行政区">香港特别行政区</a>
                                <a href="javascript:void(0)" values2="" values1="" attrval="澳门特别行政区">澳门特别行政区</a>
                        </dd>
                    </dl>
                    <dl class="aui-screen-list-item" attr="" style="height:200px;">
                        <dt>主营行业：</dt>
                        <dd style="height:200px;">
                            <a href="javascript:void(0)" values2="" values1="" attrval="农、林、牧、渔业">农、林、牧、渔业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="采矿业">采矿业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="制造业">制造业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="电力、热力、燃气及水生产和供应业">电力、热力、燃气及水生产和供应业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="建筑业">建筑业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="批发和零售业">批发和零售业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="交通运输、仓储和邮政业">交通运输、仓储和邮政业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="住宿和餐饮业">住宿和餐饮业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="信息传输、软件和信息技术服务业">信息传输、软件和信息技术服务业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="金融业">金融业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="房地产业">房地产业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="租赁和商务服务业">租赁和商务服务业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="科学研究和技术服务业">科学研究和技术服务业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="水利、环境和公共设施管理业">水利、环境和公共设施管理业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="居民服务、修理和其他服务业">居民服务、修理和其他服务业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="教育">教育</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="卫生和社会工作">卫生和社会工作</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="文化、体育和娱乐业">文化、体育和娱乐业</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="公共管理、社会保障和社会组织">公共管理、社会保障和社会组织</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="国际组织">国际组织</a>
                        </dd>
                    </dl>
                    <dl class=" aui-screen-list-item" attr="aui-terminal">
                        <dt>成立年限：</dt>
                        <dd>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">不限</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">1年内</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">1-3年</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">4-10年</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">10年以上</a>
                        </dd>
                    </dl>
                    <dl class=" aui-screen-list-item" attr="aui-terminal">
                        <dt>注册资本：</dt>
                        <dd>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">不限</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">100万以内</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">100-500万</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">500-1000万</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">1000-3000万</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">3000-5000万</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">5000万以上</a>
                        </dd>
                    </dl>


                    <dl class="aui-screen-list-item" attr="aui-terminal" style="border-bottom: #abbeef 1px none;">
                        <dt>失信信息：</dt>
                        <dd>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">不限</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">有失信信息</a>
                            <a href="javascript:void(0)" values2="" values1="" attrval="">无失信信息</a>
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
    </section>
</div><!--main结束-->
<script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
<script type="text/javascript">
    var dlNum = $("#aui-selectList").find("dl");
    for (i = 0; i < dlNum.length; i++) {
        $(".aui-screen-head-choice .aui-clear-list").append("<div class=\"aui-selected-info selectedShow\" style=\"display:none\"><span></span><label id='label"+i+"'></label><em></em></div>");
    }
<%
int i;
%>
    var text;
    var refresh = "true";
    $(".aui-screen-list-item a ").live("click", function() {
        text = $(this).text();
        var selectedShow = $(".selectedShow");
        var textTypeIndex = $(this).parents("dl").index();
        var textType = $(this).parent("dd").siblings("dt").text();
        index = textTypeIndex - (2);
        $(".aui-clear-delete").show();
        $(".selectedShow").eq(index).show();
        $(this).addClass("selected").siblings().removeClass("selected");
// 给具体的赋值
        selectedShow.eq(index).find("span").text(textType);
        selectedShow.eq(index).find("label").text(text);

        var show = $(".selectedShow").length - $(".selectedShow:hidden").length;
        if (show > 1) {
            $(".aui-eliminate").show();
        }

    });
    $(".selectedShow em").live("click", function() {
        $(this).parents(".selectedShow").hide();
        var textTypeIndex = $(this).parents(".selectedShow").index();
        index = textTypeIndex;
        $(".aui-screen-list-item").eq(index).find("a").removeClass("selected");

        if ($(".aui-screen-list-item .selected").length < 2) {
            $(".aui-eliminate").hide();
        }
    });

    $(".aui-eliminate").live("click", function() {
        $(".selectedShow").hide();
        $(this).hide();
        $(".aui-screen-list-item a ").removeClass("selected");
    });
    function sss()
    {

        var label0 = document.getElementById("label0");
        var value0 = label0.innerText.trim();

        var label1 = document.getElementById("label1");
        var value1 = label1.innerText.trim();

        var label2 = document.getElementById("label2");
        var value2 = label2.innerText.trim();

        var label3 = document.getElementById("label3");
        var value3 = label3.innerText.trim();

        var label4 = document.getElementById("label4");
        var value4 = label4.innerText.trim();

        // alert($(".aui-selected-info selectedShow label[id='label2']").text())
        // $("label").text
        // var A=$("label").contents();

        // var C=A.nextAll();
        // // var C1=A.toArray();
        // B=A.length;

        // var C1=A.toArray();
        // var C1=A.toArray();
        // var id = document.getElementById('label0');
        // var attribute = id.getAttribute('label0');
        // alert(attribute)
        // var X0=document.getElementById('label0').value;
        // var X1=document.getElementById('label1').value;
        // var X2=document.getElementById('label2').value;
        // var X3=document.getElementById('label3').value;
        // var X4=document.getElementById('label4').value;
        // alert(X0);
        // alert(X1);
        // alert(X2);


       //  alert(B)
       // var C1=A.text().toArray();
       //  alert(C1.toString());
        // 例子使用fastjson
        <%--var value="<%=value%>"--%>

        <%--value.put("message", Cl); // 放一个字符串--%>
       var value1={message0:value0,message1:value1,message2:value2,message3:value3,message4:value4};

        $.ajax({
            url: "HCompany_querybyHsearch.action",//你在后台处理的地址一般为XXX.do
            type:"POST",//一般用post 地址提交用 get
            datatype:"text",//一般用json格式
            async:false,
            data:value1,//json相当于一个map，a是相当于key，XXX是你js中的获取的参数值
            success:function(){
                // alert("success")
                window.location.href="/list1.jsp";
            },//是成功在后台处理后的下一步操作
            error:function(){
                // alert("error")
            }//发生错误后的操作
        });
    }
     //自适应
    $(window).load(function(){
        var winWidth=$(window).innerWidth();
        var winHeight=$(window).innerHeight();
        $(".fanhui").css("margin-right",(30/1536)*winWidth);
        $(".aui-choice-screen").css("width",(1198/1536)*winWidth)

    })

</script>
</body>
</html>