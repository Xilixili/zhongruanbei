<%--
  Created by IntelliJ IDEA.
  User: jojoba
  Date: 2018/5/4
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%--导入标签库--%>
<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>登陆</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="static/login/bootstrap.min.css" />
    <link rel="stylesheet" href="static/login/css/camera.css" />
    <link rel="stylesheet" href="static/login/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="static/login/matrix-login.css" />
    <link rel="stylesheet" href="static/login/font-awesome.css" />
    <link rel="stylesheet" type="text/css" href="css/waves.min.css?v=0.7.2">
    <script type="text/javascript" src="static/login/js/jquery-1.5.1.min.js"></script>
    <!-- 软键盘控件start -->
    <link href="static/login/keypad/css/framework/form.css" rel="stylesheet" type="text/css"/>
    <!-- 软键盘控件end -->
    <style type="text/css">
        /*控制按钮的颜色*/
        #colored-button .btn {
            color: #fff;
        }

        #colored-button a,
        #colored-button a:hover {
            background: #01BCFF;
        }

        #colored-button button,
        #colored-button button:hover {
            background: #1bb556;
        }

        #colored-button input,
        #colored-button input:hover {
            background: #ff4f0f;
        }
        /*
       body{
        -webkit-transform: rotate(-3deg);
        -moz-transform: rotate(-3deg);
        -o-transform: rotate(-3deg);
        padding-top:20px;
        }
        */
        .cavs{
            z-index:1;
            position: fixed;
            width:95%;
            margin-left: 20px;
            margin-right: 20px;
        }
    </style>
    <script>
        //window.setTimeout(showfh,3000);
        var timer;
        function showfh(){
            fhi = 1;
            //关闭提示晃动屏幕，注释掉这句话即可
            // timer = setInterval(xzfh2, 10);
        };
        var current = 0;
        function xzfh(){
            current = (current)%360;
            document.body.style.transform = 'rotate('+current+'deg)';
            current ++;
            if(current>360){current = 0;}
        };
        var fhi = 1;
        var current2 = 1;
        function xzfh2(){
            if(fhi>50){
                document.body.style.transform = 'rotate(0deg)';
                clearInterval(timer);
                return;
            }
            current = (current2)%360;
            document.body.style.transform = 'rotate('+current+'deg)';
            current ++;
            if(current2 == 1){current2 = -1;}else{current2 = 1;}
            fhi++;
        };
    </script>
</head>
<body>

<!--小键盘承载器-->
<canvas class="cavs"></canvas>
<div style="width:100%;text-align: center;margin: 0 auto;position: absolute;">
    <!-- 登录 -->
    <div id="windows1">
        <div id="loginbox" >
            <s:form action="User_login" method="post" onsubmit="return severCheck()"  name="loginForm"  namespace="/" id="loginForm">
                <%--logo--%>
                <div class="control-group normal_text">
                    <h3>
                        <img src="/JG/images/logo1.png" alt="Logo" />
                    </h3>
                </div>
                <%--用户名--%>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
							<span class="add-on bg_lg">
							<i><img height="37" src="static/login/user.png" /></i>
							</span><input type="text" name="username" id="loginname" value="" placeholder="请输入用户名" />
                        </div>
                    </div>
                </div>
                <%--密码--%>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
							<span class="add-on bg_ly">
							<i><img height="37" src="static/login/suo.png" /></i>
							</span><input type="password" name="password" id="password" placeholder="请输入密码" class="keypad" keypadMode="full" allowKeyboard="true" value=""/>
                        </div>
                    </div>
                </div>
                <%--验证码--%>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <li class="yanzheng">
                                <div id="captcha1">
                                    <p id="wait1" class="show">正在加载验证码......</p>
                                </div>
                            </li>
                            <br>
                            <p id="notice1" class="hide">请先完成验证</p>
                        </div>
                    </div>


                    <div style="float:right;padding-right:10%;">
                        <div style="float: left;margin-top:3px;margin-right:2px;">
                            <font color="white">记住密码</font>
                        </div>
                        <div style="float: left;">
                            <input name="form-field-checkbox" id="saveid" type="checkbox"
                                   onclick="savePaw();" style="padding-top:0px;" />
                        </div>
                    </div>
                    <div class="form-actions">
                        <div style="width:86%;padding-left:8%;">
                            <script src="http://apps.bdimg.com/libs/jquery/1.9.1/jquery.js"></script>

                            <!-- 引入 gt.js，既可以使用其中提供的 initGeetest 初始化函数 -->
                            <script src="<%=request.getContextPath() %>/gt.js"></script>

                            <script>
                                var handler1 = function (captchaObj) {
                                    $("#submit1").click(function (e) {
                                        var result = captchaObj.getValidate();
                                        if (!result) {
                                            $("#notice1").show();
                                            setTimeout(function () {
                                                $("#notice1").hide();
                                            }, 2000);
                                            e.preventDefault();
                                        }
                                    });
                                    // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
                                    captchaObj.appendTo("#captcha1");
                                    captchaObj.onReady(function () {
                                        $("#wait1").hide();
                                    });
                                    // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
                                };
                                $.ajax({
                                    url: "gt/register1?t=" + (new Date()).getTime(), // 加随机数防止缓存
                                    type: "get",
                                    dataType: "json",
                                    success: function (data) {
                                        // 调用 initGeetest 初始化参数
                                        // 参数1：配置参数
                                        // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
                                        initGeetest({
                                            gt: data.gt,
                                            challenge: data.challenge,
                                            new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
                                            offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
                                            product: "float", // 产品形式，包括：float，popup
                                            width: "100%"
                                            // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
                                        }, handler1);
                                    }
                                });
                            </script>
                        </div>

                        <div>
                                <%--<c:if test="${pd.isZhuce == 'yes' }">--%>
                                <%--<span class="pull-right" style="padding-right:3%;"><a href="javascript:changepage(1);" class="btn btn-success">注册</a></span>--%>
                                <%--</c:if>--%>
                                <%--<span class="pull-right"><a onclick="severCheck();" class="flip-link btn btn-info" id="to-recover">登录</a></span>--%>
                            <p id="colored-button" class="text-right">
                                <button class="btn float-button-light waves-effect waves-button waves-float waves-light" onclick="severCheck()">登 录</button>
                                <a class="btn float-buttons waves-effect waves-button waves-float"   href="javascript:changepage(1);">注 册</a>
                                    <%--<button class="btn float-button-light waves-effect waves-button waves-float waves-light" type="button" onclick="javascript:changepage(2);">取 消</button>--%>
                                    <%--<i class="btn float-buttons waves-input-wrapper waves-effect waves-button waves-float" style="color: rgb(255, 255, 255); background: rgb(255, 79, 15)">--%>
                                    <%--<input class="waves-button-input" type="submit" value="Button C" style="background-color: rgba(0,0,0,0);"></i>--%>
                            </p>
                        </div>
                    </div>
                </div>
            </s:form>
            <!--<div class="controls">-->
            <!--&lt;!&ndash;<div class="main_input_box">&ndash;&gt;-->
            <!--&lt;!&ndash;<font color="white"><span id="nameerr">Copyright © XX科技 2018</span></font>&ndash;&gt;-->
            <!--&lt;!&ndash;</div>&ndash;&gt;-->
            <!--</div>-->
        </div>
    </div>
    <!-- 注册，注册项：用户名，密码，邮箱 -->
    <div id="windows2" style="display: none;">
        <div id="loginbox">
            <s:form action="User_add" method="post" onsubmit="return rcheck()" name="addForm"   namespace="/" id="addForm">
                <%--logo--%>
            <div class="control-group normal_text">
                <h3>
                    <img src="static/login/logo.png" alt="Logo" />
                </h3>
            </div>
                <%--用户名--%>
            <div class="control-group">
                <div class="controls">
                    <div class="main_input_box">
							<span class="add-on bg_lg">
							<i>用户</i>
							</span><input type="text" name="username" id="username" value="" placeholder="请输入用户名" />
                    </div>
                </div>
            </div>
                <%--密码--%>
            <div class="control-group">
                <div class="controls">
                    <div class="main_input_box">
							<span class="add-on bg_ly">
							<i>密码</i>
							</span><input type="password" name="password" id="PASSWORD" placeholder="请输入密码" class="keypad" keypadMode="full" allowKeyboard="true" value=""/>
                    </div>
                </div>
            </div>
                <%--重复密码--%>
            <div class="control-group">
                <div class="controls">
                    <div class="main_input_box">
							<span class="add-on bg_ly">
							<i>重输</i>
							</span><input type="password" name="chkpwd" id="chkpwd" placeholder="请重新输入密码" class="keypad" keypadMode="full" allowKeyboard="true" value=""/>
                    </div>
                </div>
            </div>
                <%--邮箱--%>
            <div class="control-group">
                <div class="controls">
                    <div class="main_input_box">
							<span class="add-on bg_lg">
							<i>邮箱</i>
							</span><input type="text" name="email" id="EMAIL" value="" placeholder="请输入邮箱" />
                    </div>
                </div>
            </div>

            <div class="control-group">

                <div class="form-actions">
                    <div style="width:86%;padding-left:8%;">
                    </div>
                    <div>
                            <%--<span class="pull-right" style="padding-right:3%;"><a href="javascript:changepage(2);" class="btn btn-success">取消</a></span>--%>

                            <%--<span class="pull-right"><a onclick="submit" type="submit" class="flip-link btn btn-info" id="to-recover">提交</a></span>--%>

                        <p id="colored-button" class="text-right">
                            <button class="btn float-button-light waves-effect waves-button waves-float waves-light" onclick="rcheck()">提 交</button>
                            <a class="btn float-buttons waves-effect waves-button waves-float" href="javascript:changepage(2);">取 消</a>
                                <%--<button class="btn float-button-light waves-effect waves-button waves-float waves-light" type="button" onclick="javascript:changepage(2);">取 消</button>--%>
                                <%--<i class="btn float-buttons waves-input-wrapper waves-effect waves-button waves-float" style="color: rgb(255, 255, 255); background: rgb(255, 79, 15)">--%>
                                <%--<input class="waves-button-input" type="submit" value="Button C" style="background-color: rgba(0,0,0,0);"></i>--%>

                        </p>
                        <script type="text/javascript">
                            Waves.attach('.flat-buttons', ['waves-button']);
                            Waves.attach('.float-buttons', ['waves-button', 'waves-float']);
                            Waves.attach('.float-button-light', ['waves-button', 'waves-float', 'waves-light']);
                        </script>
                        <script type="text/javascript" src="js/waves.min.js"></script>
                        <!-- jQuery  -->
                        <script type="text/javascript" src="js/jquery.js"></script>
                        <script type="text/javascript">
                            var currentRoute = false;
                            $(document).on('ready', function () {

                                // Init Waves
                                Waves.init();
                                Waves.attach('.drag-ripple', 'waves-block', true);
                                Waves.attach('#bg-pattern', null, true);
                                init();
                                $(window).on('hashchange', routing);
                                /**
                                 * Example source code click
                                 */
                                $('#example .top-button').on('click', function () {
                                    var type = $(this).data('code');
                                    $('#source-code .box .code').addClass('hide');
                                    $('#source-code .box #code-' + type).removeClass('hide');
                                    $('#source-code').removeClass('hide');
                                    setTimeout(function () {
                                        $('#source-code').addClass('show');
                                    }, 50);
                                });
                                $('#source-code .top-button').on('click', function () {

                                    $('#source-code').removeClass('show');

                                    setTimeout(function () {
                                        $('#source-code .box .code').addClass('hide');
                                        $('#source-code').addClass('hide');
                                    }, 500);
                                });
                            });

                        </script>
                    </div>
                </div>
                </s:form>
                <div class="controls">
                    <div class="main_input_box">
                        <font color="white"><span id="nameerr">Copyright © XX科技 2100</span></font>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!--背景图片的位置-->
<div id="templatemo_banner_slide" class="container_wapper">
    <div class="camera_wrap camera_emboss" id="camera_slide">
        <!-- 背景图片 -->
        <div data-src="/static/login/images/banner_slide_01.jpg"></div>
        <%--<div data-src="/static/login/images/banner_slide_02.jpg"></div>--%>
        <div data-src="/static/login/images/banner_slide_03.jpg"></div>
        <%--<div data-src="/static/login/images/banner_slide_04.jpg"></div>--%>
        <div data-src="/static/login/images/banner_slide_05.jpg"></div>
    </div>
    <!-- #camera_wrap_3 -->
</div>

<script type="text/javascript">
    //服务器校验
    function severCheck(){
        if(check()){
            var loginname = $("#loginname").val();
            var password = $("#password").val();
            var code = loginname+","+password;
            $.ajax({
                type: "POST",
                url: 'User_login',
                data: {KEYDATA:code},
                dataType:'json',
                cache: false,
                success: function(data){
                    if("success" == data.result){
                        saveCookie();
                        window.location.href="<%=basePath%>main/index";
                    }else if("usererror" == data.result){
                        $("#loginname").tips({
                            side : 1,
                            msg : "用户名或密码有误",
                            bg : '#FF5080',
                            time : 15
                        });
                        showfh();
                        $("#loginname").focus();
                    }
                    else{
                        $("#loginname").tips({
                            side : 1,
                            msg : "缺少参数",
                            bg : '#FF5080',
                            time : 15
                        });
                        showfh();
                        $("#loginname").focus();
                    }
                }
            });
        }
    }

    //客户端校验
    function check() {

        if ($("#loginname").val() == "") {
            $("#loginname").tips({
                side : 2,
                msg : '用户名不得为空',
                bg : '#AE81FF',
                time : 3
            });
            showfh();
            $("#loginname").focus();
            return false;
        } else {
            $("#loginname").val(jQuery.trim($('#loginname').val()));
        }
        if ($("#password").val() == "") {
            $("#password").tips({
                side : 2,
                msg : '密码不得为空',
                bg : '#AE81FF',
                time : 3
            });
            showfh();
            $("#password").focus();
            return false;
        }
        if ($("#code").val() == "") {
            $("#code").tips({
                side : 1,
                msg : '验证码不得为空',
                bg : '#AE81FF',
                time : 3
            });
            showfh();
            $("#code").focus();
            return false;
        }
        $("#loginbox").tips({
            side : 1,
            msg : '正在登录 , 请稍后 ...',
            bg : '#68B500',
            time : 10
        });
        return true;
    }
    function savePaw() {
        if (!$("#saveid").attr("checked")) {
            $.cookie('loginname', '', {
                expires : -1
            });
            $.cookie('password', '', {
                expires : -1
            });
            $("#loginname").val('');
            $("#password").val('');
        }
    }

    function saveCookie() {
        if ($("#saveid").attr("checked")) {
            $.cookie('loginname', $("#loginname").val(), {
                expires : 7
            });
            $.cookie('password', $("#password").val(), {
                expires : 7
            });
        }
    }

    jQuery(function() {
        var loginname = $.cookie('loginname');
        var password = $.cookie('password');
        if (typeof(loginname) != "undefined"
            && typeof(password) != "undefined") {
            $("#loginname").val(loginname);
            $("#password").val(password);
            $("#saveid").attr("checked", true);
            $("#code").focus();
        }
    });

    //登录注册页面切换
    function changepage(value) {
        if(value == 1){
            $("#windows1").hide();
            $("#windows2").show();
            changeCode2();
        }else{
            $("#windows2").hide();
            $("#windows1").show();
            changeCode1();
        }
    }

    //注册
    function rcheck(){
        if($("#username").val()==""){
            $("#username").tips({
                side:3,
                msg:'输入用户名',
                bg:'#AE81FF',
                time:2
            });
            $("#username").focus();
            $("#username").val('');
            return false;
        }else{
            $("#username").val(jQuery.trim($('#username').val()));
        }
        if($("#PASSWORD").val()==""){
            $("#PASSWORD").tips({
                side:3,
                msg:'输入密码',
                bg:'#AE81FF',
                time:2
            });
            $("#PASSWORD").focus();
            return false;
        }
        if($("#PASSWORD").val()!=$("#chkpwd").val()){
            $("#chkpwd").tips({
                side:3,
                msg:'两次密码不相同',
                bg:'#AE81FF',
                time:3
            });
            //在重输密码框系显示验证信息  focus
            $("#chkpwd").focus();
            return false;
        }
        if($("#EMAIL").val()==""){
            $("#EMAIL").tips({
                side:3,
                msg:'输入邮箱',
                bg:'#AE81FF',
                time:3
            });
            $("#EMAIL").focus();
            return false;
        }else if(!ismail($("#EMAIL").val())){
            $("#EMAIL").tips({
                side:3,
                msg:'邮箱格式不正确',
                bg:'#AE81FF',
                time:3
            });
            $("#EMAIL").focus();
            return false;
        }
        if ($("#rcode").val() == "") {
            $("#rcode").tips({
                side : 1,
                msg : '验证码不得为空',
                bg : '#AE81FF',
                time : 3
            });
            $("#rcode").focus();
            return false;
        }
        return true;
    }

    //-注册
    function register(){
        if(rcheck()){
            var nowtime = date2str(new Date(),"yyyyMMdd");
            $.ajax({
                type: "POST",
                url: 'appSysUser/registerSysUser.do',
                data: {username:$("#username").val(),PASSWORD:$("#PASSWORD").val(),NAME:$("#name").val(),EMAIL:$("#EMAIL").val(),rcode:$("#rcode").val(),FKEY:$.md5('USERNAME'+nowtime+',fh,'),tm:new Date().getTime()},
                dataType:'json',
                cache: false,
                success: function(data){
                    if("00" == data.result){
                        $("#windows2").hide();
                        $("#windows1").show();
                        $("#loginbox").tips({
                            side : 1,
                            msg : '注册成功,请登录',
                            bg : '#68B500',
                            time : 3
                        });
                        changeCode1();
                    }else if("04" == data.result){
                        $("#username").tips({
                            side : 1,
                            msg : "用户名已存在",
                            bg : '#FF5080',
                            time : 15
                        });
                        showfh();
                        $("#username").focus();
                    }
                }
            });
        }
    }

    //邮箱格式校验
    function ismail(mail){
        return(new RegExp(/^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/).test(mail));
    }
    //js  日期格式
</script>
<script src="static/login/js/bootstrap.min.js"></script>
<script src="static/js/jquery-1.7.2.js"></script>
<script src="static/login/js/jquery.easing.1.3.js"></script>
<script src="static/login/js/jquery.mobile.customized.min.js"></script>
<script src="static/login/js/camera.min.js"></script>
<script src="static/login/js/templatemo_script.js"></script>
<script src="static/login/js/ban.js"></script>
<script type="text/javascript" src="static/js/jQuery.md5.js"></script>
<script type="text/javascript" src="static/js/jquery.tips.js"></script>
<script type="text/javascript" src="static/js/jquery.cookie.js"></script>

<!-- 软键盘控件start -->
<script type="text/javascript" src="static/login/keypad/js/form/keypad.js"></script>
<script type="text/javascript" src="static/login/keypad/js/framework.js"></script>
<!-- 软键盘控件end -->
</body>
</html>
<script type="text/javascript" src="js/passwordStrength.js"></script>
<script type="text/javascript">
    new PasswordStrength('pass','passStrength');
</script>
<script type="text/javascript" src="js/passwordStrength.js"></script>
<script type="text/javascript">
    new PasswordStrength('pass','passStrength');
</script>
<script src="~/Content/plugins/jquery/jquery-1.8.2.min.js"></script>
<script>
    window.addEventListener('load', processGeeTest);

    function processGeeTest() {
        $.ajax({
            // 获取id，challenge，success（是否启用failback）
            url: "/Login/GeekTest",
            type: "get",
            dataType: "json", // 使用jsonp格式
            success: function (data) {
                // 使用initGeetest接口
                // 参数1：配置参数，与创建Geetest实例时接受的参数一致
                // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
                initGeetest({
                        gt: data.gt,
                        challenge: data.challenge,
                        product: "float", // 产品形式
                        offline: !data.success
                    },
                    handler);
            }
        });
    }

    var handler = function (captchaObj) {
        // 将验证码加到id为captcha的元素里
        captchaObj.appendTo("#geetest-container");

        captchaObj.onSuccess = function (e) {
            console.log(e);
        }

    };
</script>
<script src="gt.js"></script>