<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: jojoba
  Date: 2018/6/21
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="dist/css/bootstrap.min.css">
    <link href="SY/css/style.css" rel="stylesheet" type="text/css" />
    <script src="SY/jquery/jquery-3.3.1.min.js"></script>
    <script src="SY/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css"/>
    <%--<script src="js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="js/jquery.autocomplete.min.js"></script>
    <script src="js/test.js"></script>




    <script type="text/javascript">
        //自动补全
        function  autoComplete()
        {
            var url=document.forms.form1.action

            var mes = $('#down').val();
            $.ajax({
                type: "post",
                async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                data: {
                    mes: mes,
                    url: url

                },
                url: "ServletAuto",    //请求发送
                dataType: "json",        //返回数据形式为json
                success: function (data) {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (data) {
                        // datas = data;
                        $('#down').AutoComplete({
                            'data':data,
                            'itemHeight': 22,
                            'maxHeight': 240,
                            'width': 649.7
                        }).AutoComplete('show');

                        // $.each(teams, function(index, data){
                        //     new Image().src = '../demo/image/2012中超/' + data['value'] + '.jpg'; // 预加载图片
                        //     data['image'] = '../demo/image/2012中超/' + data['value'] + '.jpg';
                        // });

                        $('#custom').AutoComplete({
                            'data': teams,
                            'width': 280,
                            'listStyle': 'custom',
                            'maxHeight': 240,
                            'createItemHandler': function (index, data) {
                                var div = $("<div></div>")
                                var cell1 = $("<div style='display:table-cell;vertical-align:top;'></div>").appendTo(div);
                                var cell1_1 = $("<img style='width:32px;height:32px;'></img>").attr('src', data.image).appendTo(cell1);
                                var cell2 = $("<div style='display:table-cell;vertical-align:top;'></div>").appendTo(div);
                                var cell2_1 = $("<div></div>").append(data.label).appendTo(cell2);
                                var cell2_2 = $("<div style='vertical-align:top;'></div>")
                                    .append("<div style='display:table-cell;width:40px;'>" + data.win + "</span>")
                                    .append("<div style='display:table-cell;width:40px;'>" + data.tie + "</span>")
                                    .append("<div style='display:table-cell;width:40px;'>" + data.lose + "</span>")
                                    .append("<div style='display:table-cell;width:40px;'>" + data.score + "</span>")
                                    .appendTo(cell2);
                                return div;
                            }
                        }).AutoComplete('show');

                        alltest.testIconList('#iconlist');
                        $('#iconlist').AutoComplete('show');

                    }
                },
                error: function (errorMsg) { //没做出错处理
                    //请求失败时执行该函数
                    alert("图表请求数据失败!");
                }
            })
        }
    </script>
</head>
<body>
<div class="naver">
    <img src="JG/images/logo1.png" alt="Logo" />
    <div class="denglu">
        <a href="/user.jsp">个人主页</a>
        <a href="/country.jsp">全国大数据</a>
    </div>

</div><!--naver结束-->


<div class="main">

    <div class="main-top"></div><!--main-top结束-->
    <div class="main-mid">
        <div class="main-mid-subnav" >
            <ul class="nav nav-pills" >
                <li role="presentation" ><a href="#" onclick="ColorMdify (this);del1()" data-type="0">全部</a></li>
                <li role="presentation" ><a href="#" onclick="ColorMdify (this);del2()" data-type="2">企业名</a></li>
                <li role="presentation" ><a href="#"  onclick="ColorMdify (this);del3()"data-type="4">法人/高管</a></li>
                <li role="presentation" ><a href="#"  onclick="ColorMdify (this);del4()" data-type="6">股东</a></li>
                <li role="presentation" ><a href="#"  onclick="ColorMdify (this);del5()" data-type="8">注册号</a></li>
                <li role="presentation" ><a href="#"  onclick="ColorMdify (this);del6()" data-type="10">经营范围</a></li>
            </ul>
        </div><!--main-mid-subnav结束-->
    </div>

    <script type="text/javascript">
        function del1(){
            document.forms.form1.action="/Company_querybyall.action";
        }
        function del2(){
            document.forms.form1.action="/Company_querybyname.action";
        }
        function del3(){
            document.forms.form1.action="/Company_querybyperson.action";
        }
        function del4(){
            document.forms.form1.action="/Company_querybygd.action";
        }
        function del5(){
            document.forms.form1.action="/Company_querybyreg_no.action";
        }
        function del6(){
            document.forms.form1.action="/Company_querybyfw.action";
        }

    </script>

    <script type="text/javascript">
        function tijiao(){
            document.getElementById("form1").submit();//表单提交
        }
    </script>
    <div class="main-mid-searchInput">
        <div class="col-lg-6">

            <div class="input-group" id="search">
                <script type="text/javascript">

                    function ColorMdify (temp)
                    {

                        var tr = temp.parentNode;
                        var ti = neighbourNode(tr);
                        for(var i=0;i<ti.length;i++)
                            removeClass(ti[i],"active");
                        tr.className+="active";
                        var inputValue=temp.getAttribute("data-type");
                        // alert(inputValue);
                        text=document.getElementById("down");
                        if (inputValue==="0")
                        {
                            text.value= "请输入企业名称、人名、注册号、经营范围等";
                        }
                        else if(inputValue==="2")
                        {
                            text.value = "请输入企业名称";
                        }
                        else if(inputValue==="4")
                        {
                            text.value= "请输入法人名称或高管名称";
                        }
                        else if(inputValue==="6")
                        {
                            text.value= "请输入股东名称";
                        }
                        else if(inputValue==="8")
                        {
                            text.value= "请输入企业注册号";
                        }
                        else if(inputValue==="10")
                        {
                            text.value= "请输入企业经营范围";
                        }

                    }
                    function neighbourNode (temp)
                    {
                        var a = [];
                        var b = temp.parentNode.children;
                        for (var i = 0 ; i < b.length ; i++){
                            if(b[i] !== temp)   a.push(b[i]);
                        }
                        return a;
                    }
                    function removeClass(obj, cls) {
                        if (hasClass(obj, cls)) {
                            var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
                            obj.className = obj.className.replace(reg, ' ');
                        }
                    }
                    function hasClass(obj, cls) {
                        return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
                    }

                    function change()
                    {

                    }



                </script>
                <s:form id="form1" action="Company_querybyname" method="post" namespace="/">

                    <input type="text" name="com_name" class="form-control" id="down" placeholder="请输入查询内容"  onkeyup="autoComplete()">

                    <%--<div class="col-xs-6">输入框</div><div class="col-xs-6">查一下</div>--%>

                </s:form>
                <span class="input-group-btn">
                           <button class="btn btn-default" onclick="tijiao()" type="submit"><span class="glyphicon glyphicon-search">&nbsp;查一下</span></button>
                         </span>
                <a href="/Hsearch.jsp">高级搜索</a>


            </div><!-- /input-group -->

        </div><!-- /.col-lg-6 -->
    </div><!--main-mid-searchInput结束-->
    <div class="row">

        <div class="resou">热搜：</div>
        <div class="hot_data">
            <li><a href="/xinxi.jsp?reg_no=911400001101008977&Addr=太原市万柏林区西矿街335号&com_name=西山煤电（集团）有限责任公司">西山煤电（集团）有限责任公司</a></li>
            <li><a href="/xinxi.jsp?reg_no=9152010021449398XY&Addr=贵州省贵阳市云岩区中华北路77号&com_name=贵阳银行股份有限公司">贵阳银行股份有限公司</a></li>
            <li><a href="/xinxi.jsp?reg_no=91340000148975314D&Addr=安徽省合肥市葛淝路1号&com_name=安徽安凯汽车股份有限公司">安徽安凯汽车股份有限公司</a></li>
            <li><a href="/xinxi.jsp?reg_no=91310118MA1JL43G18&Addr=上海市青浦区华新镇华腾路1288号1幢2层G区246室&com_name=上海商桥供应链服务有限公司">上海商桥供应链服务有限公司</a></li>
        </div>

    </div><!--row结束-->
</div><!--main-mid结束-->
</div><!--main结束-->
<nav id="index_M_Nav">
    <div class="container">
        <a href="#"><h3>查专利</h3><small>200万+专利</small></a>
        <a href="#"><h3>查商标</h3><small>2400万+商标</small></a>
        <a href="#"><h3>查失信</h3><small>2000万+失信信息</small></a>
        <a href="#"><h3>查裁判文书</h3><small>3000万+裁判文书</small></a>
        <a href="#"><h3>投融资查询</h3><small>30万+创业公司</small></a>
    </div>
</nav><!--nav结束-->
<div class="footer">
    <div class="footer-container">
        <ul>
            <li><a href="#">关于我们</a></li>
            <li><a href="#">联系我们</a></li>
            <li><a href="#">微信客服</a></li>
            <li><a href="#">微信公众号</a></li>
        </ul>
    </div><!--footer-container结束-->
</div><!--footer结束-->

<script>
    //自适应
    $(window).load(function(){
        var winWidth=$(window).innerWidth();
        var winHeight=$(window).innerHeight();
        $(".denglu").css("margin-right",(30/1536)*winWidth);
        $(".main-mid").css("width",(700/1536)*winWidth);
        $(".main-mid-searchInput").css("width",(730/1536)*winWidth);
        $(".row").css("width",(900/1536)*winWidth);
        //footer自适应
        $(".footer").css("width",winWidth);

    })
</script>




</body>
</html>