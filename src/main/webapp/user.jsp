<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.hmz.entity.GZ" %>
<%@ page import="com.hmz.dao.impl.CompanyDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hmz.entity.NOTE" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/16
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人主页</title>
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/TX/css/amazeui.min.css">
    <link rel="stylesheet" href="/TX/css/amazeui.cropper.css">
    <link rel="stylesheet" href="/TX/css/custom_up_img.css">


    <style type="text/css">
        .up-img-cover {width: 100px;height: 100px;}
        .up-img-cover img{width: 100%;}
    </style>

    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="stylesheet" href="User/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="User/css/fontAwesome.css">
    <link rel="stylesheet" href="User/css/light-box.css">
    <link rel="stylesheet" href="User/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
    <link rel="stylesheet" href="User/css/templatemo-main.css">
    <link rel="stylesheet" href="User/css/table2_style.css" type="text/css">
    <link rel="stylesheet" href="User/css/table1_style.css" type="text/css">
    <link rel="stylesheet" href="User/css/style.css" type="text/css">
    <script src="User/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    <script src="/User/js/vendor/bootstrap.min.js"></script>
    <script src="HS/js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="HS/js/jquery.min.js" type="text/javascript"></script>


</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="/User/js/vendor/bootstrap.min.js"></script>


<%
    request.setCharacterEncoding("utf-8");
    //String password = "";
    String user_name =request.getSession().getAttribute("user_name").toString();
            System.out.print("session中的user_name为"+user_name);
%>
<nav>
    <div class="logo">
        <img src="User/img/logo.png" alt="">
    </div>
    <div class="mini-logo">
        <img src="User/img/mini_logo.png" alt="">
    </div>
    <ul>
        <li><a href="#1"><i class="fa fa-home"></i> <em>个人信息</em></a></li>
        <li><a href="#2"><i class="fa fa-user"></i> <em>我的关注</em></a></li>
        <li><a href="#3"><i class="fa fa-pencil"></i> <em>我的笔记</em></a></li>
        <li><a href="#4"><i class="fa fa-envelope"></i> <em>联系我们</em></a></li>
        <li><a href="#5" onclick="zhuye();"><i class="fa fa-fanhui"></i> <em>返回主页</em></a></li>

    </ul>
</nav>

<script type="text/javascript">
    function zhuye() {
        window.location.href="/main1.jsp";
    }

</script>
<%--给个人信息界面的基本的信息赋值--%>
<script type="text/javascript">
    // 一加载就被执行
    $(document).ready(function() {
// alert(result[1][1].company20.FD);
        $.ajax({
            type: "post",
            url: "ServletUser",
            dataType: "json", 				//返回数据形式为json
            /*容易出错  */
            data: {
                username: "<%=user_name%>",
            },
            success: function (result) {
                // alert("sucess!!!")
                if (result[0]) {
                    // alert(result[0].user.name)
                    document.getElementById("xingming").value = result[0].user.tname;
                    document.getElementById("nicheng").value = result[0].user.username;
                    document.getElementById("gongsi").value = result[0].user.com;
                    document.getElementById("zhiwu").value = result[0].user.uposition;
                    document.getElementById("dizhi").value = result[0].user.addr;
                    // $("#xingming").html(result[0].user.name);
                    // $("#nicheng").html(result[0].user.username);
                    // $("#gongsi").html(result[0].user.com);
                    // $("#zhiwu").html(result[0].user.position);
                    // $("#dizhi").html(result[0].user.Addr);
                    document.getElementById("xingbie").value = result[0].user.sex;
                    document.getElementById("hangye").value = result[0].user.FW;
                }
            },
            error: function (errorMsg) {
                // alert("不好意思,servletdao请求数据失败啦!");
            }
        })
    })


</script>


<script type="text/javascript">
    $(document).ready(function(){
        //按钮点击事件
        $("#form-submit1").click(function(){
            //发起异步请求

           // var  myselect=document.getElementById("test");
           //
           //  var index=myselect.selectedIndex ;             // selectedIndex代表的是你所选中项的index
           //
           // myselect.options[index].value;
            //参数一：请求的地址；参数二：传递的参数；参数三：回调函数，接收服务器回传的数据
            $.post("User_changeXinxi.action",{"username":$("#nicheng").val(),"Tname":$("#xingming").val(),"com":$("#gongsi").val(),"Uposition":$("#zhiwu").val(),"Addr":$("#dizhi").val(),"sex":document.getElementById("xingbie").value,"FW":document.getElementById("hangye").value},function(data){
                //显示异步回传的数据
                // alert(data);
            });

        });

    });

</script>


<div class="slides">
    <div class="slide" id="1">
        <div class="content first-content">
            <div class="up-img-cover"  id="up-img-touch" >
                <img class="am-circle" alt="点击图片上传" src="User/img/author_image.png" data-am-popover="{content: '点击上传', trigger: 'hover focus'}" >
            </div>
            <div><a style="text-align: center; display: block;"  id="pic"></a></div>

            <!--图片上传框-->
            <div class="am-modal am-modal-no-btn up-frame-bj " tabindex="-1" id="doc-modal-1">
                <div class="am-modal-dialog up-frame-parent up-frame-radius">
                    <div class="am-modal-hd up-frame-header">
                        <label>修改头像</label>
                        <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
                    </div>
                    <div class="am-modal-bd  up-frame-body">
                        <div class="am-g am-fl">
                            <div class="am-form-group am-form-file">
                                <div class="am-fl">
                                    <button type="button" class="am-btn am-btn-default am-btn-sm">
                                        <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
                                </div>
                                <input type="file" id="inputImage">
                            </div>
                        </div>
                        <div class="am-g am-fl" >
                            <div class="up-pre-before up-frame-radius">
                                <img alt="" src="" id="image" >
                            </div>
                            <div class="up-pre-after up-frame-radius">
                            </div>
                        </div>
                        <div class="am-g am-fl">
                            <div class="up-control-btns">
                                <span class="am-icon-rotate-left"  onclick="rotateimgleft()"></span>
                                <span class="am-icon-rotate-right" onClick="rotateimgright()"></span>
                                <span class="am-icon-check" id="up-btn-ok" url="<%=path%>/upload/img"></span>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <!--加载框-->
            <div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
                <div class="am-modal-dialog">
                    <div class="am-modal-hd">正在上传...</div>
                    <div class="am-modal-bd">
                        <span class="am-icon-spinner am-icon-spin"></span>
                    </div>
                </div>
            </div>

            <!--警告框-->
            <div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
                <div class="am-modal-dialog">
                    <div class="am-modal-hd">信息</div>
                    <div class="am-modal-bd"  id="alert_content">
                        成功了
                    </div>
                    <div class="am-modal-footer">
                        <span class="am-modal-btn">确定</span>
                    </div>
                </div>
            </div>
            <script src="/TX/js/jquery.min.js" charset="utf-8"></script>
            <script src="/TX/js/amazeui.min.js" charset="utf-8"></script>
            <script src="/TX/js/cropper.min.js" charset="utf-8"></script>
            <script src="/TX/js/custom_up_img.js" charset="utf-8"></script>
            <div class="author-image">

                <%--<img src="User/img/author_image.png" alt="">--%>
                <%--<div class="col-md-6">--%>
                    <%--<fieldset>--%>
                        <%--<button type="submit" id="form-submit" class="btn">点击头像进行更换</button>--%>
                    <%--</fieldset>--%>
                <%--</div>--%>
            </div>
            <div class="container-fluid">
                <div class="col-md-6">
                    <s:form id="form1" name="form1" action="User_changeXinxi.action" method="post" namespace="/">
                        <div class="row">
                            <div class="col-md-12">
                                <%--<fieldset>--%>
                                    <div id="zifu">昵称：</div>
                                    <input type="text" name="username" id="nicheng" value="" placeholder="请输入用户名" />
                                    <%--<input name="username" type="text" class="form-control" id="nicheng" placeholder="请输入昵称"  >--%>
                                    <%--<input name="username" type="text" class="form-control" id="nicheng" placeholder="请输入昵称" required="" >--%>
                                <%--</fieldset>--%>
                            </div>
                            <div class="col-md-12">
                                <%--<fieldset>--%>
                                    <div id="zifu">性别：</div>
                                    <select id="xingbie" name="sex">
                                        <option value ="男">男</option>
                                        <option value ="女">女</option>
                                    </select>
                                <%--</fieldset>--%>
                            </div>
                            <div class="col-md-12">
                                <%--<fieldset>--%>
                                    <div id="zifu">真实姓名：</div>
                                    <input name="name" type="text" class="form-control" id="xingming" placeholder="请输入真实姓名" required="">
                                <%--</fieldset>--%>
                            </div>
                            <div class="col-md-12">
                                <%--<fieldset>--%>
                                    <div id="zifu">公司：</div>
                                    <input name="com" type="text" class="form-control" id="gongsi" placeholder="请输入公司名称" required="">
                                <%--</fieldset>--%>
                            </div>
                            <div class="col-md-12">
                                <%--<fieldset>--%>
                                    <div id="zifu">行业：</div>
                                    <select id="hangye" name="FW">
                                        <option value ="农、林、牧、渔业">农、林、牧、渔业</option>
                                        <option value ="采矿业">采矿业</option>
                                        <option value ="制造业">制造业</option>
                                        <option value ="电力、热力、燃气及水生产和供应业">电力、热力、燃气及水生产和供应业</option>
                                        <option value ="建筑业">建筑业</option>
                                        <option value ="批发和零售业">批发和零售业</option>
                                        <option value ="交通运输、仓储和邮政业">交通运输、仓储和邮政业</option>
                                        <option value ="住宿和餐饮业">住宿和餐饮业</option>
                                        <option value ="信息传输、软件和信息技术服务业">信息传输、软件和信息技术服务业</option>
                                        <option value ="金融业">金融业</option>
                                        <option value ="房地产业">房地产业</option>
                                        <option value ="租赁和商务服务业">租赁和商务服务业</option>
                                        <option value ="科学研究和技术服务业">科学研究和技术服务业</option>
                                        <option value ="水利、环境和公共设施管理业">水利、环境和公共设施管理业</option>
                                        <option value ="居民服务、修理和其他服务业">居民服务、修理和其他服务业</option>
                                        <option value ="教育">教育</option>
                                        <option value ="卫生和社会工作">卫生和社会工作</option>
                                        <option value ="文化、体育和娱乐业">文化、体育和娱乐业</option>
                                        <option value ="公共管理、社会保障和社会组织">公共管理、社会保障和社会组织</option>
                                        <option value ="国际组织">国际组织</option>
                                    </select>
                                <%--</fieldset>--%>
                            </div>
                            <div class="col-md-12">
                                <%--<fieldset>--%>
                                    <div id="zifu">职务：</div>
                                    <input name="posision" type="text" class="form-control" id="zhiwu" placeholder="请输入职务" required="">
                                <%--</fieldset>--%>
                            </div>
                            <div class="col-md-12">
                                <%--<fieldset>--%>
                                    <div id="zifu">地址：</div>
                                    <input name="Addr" type="text" class="form-control" id="dizhi" placeholder="请输入地址" required="">
                                <%--</fieldset>--%>
                                <div class="col-md-12" >
                                    <%--<fieldset>--%>
                                        <button type="button" id="form-submit1" type="submit" class="btn" onclick="urd();">提交</button>
                                        <button type="button" id="form-editor" class="btn" onclick="rd()">编辑</button>
                                    <%--</fieldset>--%>
                                </div>
                            </div>
                        </div>
                    </s:form>
                </div>
            </div>
        </div>
        <script>
            function tijiao() {
                var form = document.getElementById('form1');
                form.submit();
            }
        </script>
        <script>
            function urd(){
                $("#nicheng").attr("disabled",true)
                $("#xingbie").attr("disabled",true)
                $("#xingming").attr("disabled",true)
                $("#gongsi").attr("disabled",true)
                $("#hangye").attr("disabled",true)
                $("#zhiwu").attr("disabled",true)
                $("#dizhi").attr("disabled",true)
            }
            document.getElementById("nicheng").style.background = "rgba(250, 250, 250, 0.15)";
            document.getElementById("nicheng").style.color = "#ddd";
            document.getElementById("xingming").style.background = "rgba(250, 250, 250, 0.15)";
            document.getElementById("xingming").style.color = "#ddd";
            document.getElementById("gongsi").style.background = "rgba(250, 250, 250, 0.15)";
            document.getElementById("gongsi").style.color = "#ddd";
            document.getElementById("zhiwu").style.background = "rgba(250, 250, 250, 0.15)";
            document.getElementById("zhiwu").style.color = "#ddd";
            document.getElementById("dizhi").style.background = "rgba(250, 250, 250, 0.15)";
            document.getElementById("dizhi").style.color = "#ddd";
            function rd(){
                $("#nicheng").attr("disabled",false)
                $("#xingbie").attr("disabled",false)
                $("#xingming").attr("disabled",false)
                $("#gongsi").attr("disabled",false)
                $("#hangye").attr("disabled",false)
                $("#zhiwu").attr("disabled",false)
                $("#dizhi").attr("disabled",false)
            }
        </script>


    </div>
    <div class="slide" id="2">
        <div class="content second-content">
            <div class="container-fluid">
                <div class="col-md-12">
                    <div class="table1-wrapper">
                        <table class="fl-table">
                            <thead>
                            <tr>
                                <th>公司名称</th>
                                <th>关注日期</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>

<%--从表中读取到当前用户的关注数据并用for循环遍历--%>
 <%
    GZ gz=new GZ();

    CompanyDaoImpl companyDao=new CompanyDaoImpl();

    //传user_name查询
    ArrayList<GZ> list = companyDao.getAllGZ(user_name);


    if (list != null && list.size() >0) {
        for (int i = 0; i <= list.size()-1; i++) {
            String j=String.valueOf(i);
             gz.setGZ_com(list.get(i).getGZ_com());
             gz.setUsername(list.get(i).getUsername());
             gz.setGZ_RQ(list.get(i).getGZ_RQ());
             gz.setId(list.get(i).getId());
%>

                                <tr id="show<%=j%>">
                                    <td id="GZ_com<%=j%>"><%=gz.getGZ_com()%></td>
                                    <td><%=gz.getGZ_RQ()%></td>

                                    <td><button id=<%=j%> type="button" class="btn btn-link" onclick="Delete_GZ(this);">删除</button></td>
                                </tr>

                                <%
            }

    }
%>
<script>
    function Delete_GZ(obj){
        var B_ID=obj.id;

            // var prefix = id.substring(0, id.indexOf('_') + 1);
            // var title = $("#" + prefix + "title").val();
            // var module = $("#" + prefix + "module").val();
            // var content = $("#" + prefix + "content").val();
        // alert("BID"+B_ID)
        // var pdid = 'GZ_com' + B_ID;
      // alert('GZ_com'+ B_ID)
      // alert('GZ_com'.concat(B_ID))

        // var GZ_com=$("#GZ_com1").val();
        var GZ_com=document.getElementById('GZ_com'.concat(B_ID)).innerText;
        // var GZ_com=document.getElementById('GZ_com1').value;
        // alert(GZ_com);

        var flag = confirm("确定删除该条记录吗？");
        if(flag){
            $.ajax({
                type : "post",
                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                data:{
                    com_name:GZ_com
                },
                url : "DeleteGZ",    //请求发送
                dataType : "json",        //返回数据形式为json
                success : function(data) {
                    if (data) {
                        document.getElementById('show'.concat(B_ID)).style.display='none'

                    }
                },
                error : function(errorMsg) { //没做出错处理

                }
            })
            // alert("你点击的是确定");
        }else{
            // alert("你单击的是取消");
        }
    }

</script>
                            <tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="slide" id="3">
        <div class="content third-content">
            <div class="container-fluid">
                <div class="col-md-12">
                    <div class="table2-wrapper">
                        <table class="f2-table">
                            <thead>
                            <tr>
                                <th>内容</th>
                                <th>公司名称</th>
                                <th>记录时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
<%
     NOTE note=new NOTE();
    //传user_name查询
    ArrayList<NOTE> list1 = companyDao.getAllNOTE(user_name);


    if (list1 != null && list1.size() >0) {
        for (int i = 0; i <= list1.size()-1; i++) {
                String j=String.valueOf(i);
             note.setNOTE_RQ(list1.get(i).getNOTE_RQ());
             note.setNOTE_com(list1.get(i).getNOTE_com());
             note.setContent(list1.get(i).getContent());
             note.setId(list1.get(i).getId());


%>

                                <tr id="display<%=j%>">
                                    <td id="content<%=j%>"><%=note.getContent()%></td>
                                    <td id="NOTE_com<%=j%>"><%=note.getNOTE_com()%></td>
                                    <td id="NOTE_RQ<%=j%>"><%=note.getNOTE_RQ()%></td>
                                    <td>
                                        <button type="button" class="btn btn-link" id=<%=j%> data-toggle="modal" onclick="Edit_NOTE(this)" data-target="#exampleModal" data-whatever="@mdo">编辑</button>

                                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content" id="content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">编辑笔记</h5>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form>
                                                            <div class="form-group">
                            <textarea name="a" class="form-control" id="NOTE<%=j%>"><%=note.getContent()%></textarea>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <%--data-dismiss="modal"  点击为关闭--%>
                                                        <button type="button"  id=<%=j%>  onclick="NOTE(this);" data-dismiss="modal" class="btn btn-secondary">保存</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <button id=<%=j%> type="button" class="btn btn-link" onclick="Delete_NOTE(this);">删除</button></td>
                                <%--</tr>--%>

<%--<button type="button" id=<%=j%> class="btn btn-link" onclick="Delete_NOTE(this);">删除</button>--%>

                                </tr>


                                <%
            }
        }

%>
<script>
    var nameID='0';
    function NOTE(obj)
    {
        // alert(nameID);
        var NOTE_com=document.getElementById('NOTE_com'.concat(nameID)).innerText;
        // alert(NOTE_com);
        var date1=RQ();
        var content=document.getElementById("NOTE0").value;
        // alert(content);
        $.ajax({
            type : "post",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            data:{
                content:content,
                RQ:date1,
                com_name:NOTE_com
            },
            url : "UserNOTE",    //请求发送
            dataType : "json",        //返回数据形式为json
            success : function(data) {
                if (data) {
                    document.getElementById('NOTE_RQ'.concat(nameID)).innerText=date1;
                    document.getElementById('content'.concat(nameID)).innerText=content;

                }
            },
            error : function(errorMsg) { //没做出错处理
                //请求失败时执行该函数
                // alert("Servlet7关联图谱失败!");
            }
        })
        <%--$.post("User_changeXinxi.action",{"mes":<%=com_name%>,"number":date1},function(data){--%>
        <%--//显示异步回传的数据--%>
        <%--// alert(data);--%>
        <%--});--%>
    }
    function RQ()
    {
        // alert()
        var date=new Date;
        var year=date.getFullYear();
        var month=date.getMonth()+1;
        var day=date.getDay();
        var hour=date.getHours();
        var minute=date.getMinutes();
        var
            month =(month<10 ? "0"+month:month);
        var mydate = (year.toString()+"-"+month.toString()+"-"+day.toString()+"   "+hour.toString()+":"+minute.toString());
        // alert(mydate)
        return mydate;
        // btn.value="已关注";
        // alert(btn);
        // btn.disabled=true;
    }
    function Delete_NOTE(obj){
        var B_ID=obj.id;
        // alert(B_ID);
        var NOTE_com=document.getElementById('NOTE_com'.concat(B_ID)).innerText;
        // alert(NOTE_com)
        var flag = confirm("确定删除该条记录吗？");
        if(flag){
            $.ajax({
                type : "post",
                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                data:{
                    com_name:NOTE_com
                },
                url : "DeleteNOTE",    //请求发送
                dataType : "json",        //返回数据形式为json
                success : function(data) {
                    if (data) {
                        document.getElementById('display'.concat(B_ID)).style.display='none'

                        // document.getElementById("NOTE".concat(B_ID)).innerText=data[1].content;
                    }
                },
                error : function(errorMsg) { //没做出错处理

                }
            })
            // alert("你点击的是确定");
        }else{
            // alert("你单击的是取消");
        }
    }
    function Edit_NOTE(obj){

        var B_ID=obj.id;
        nameID=B_ID
        // alert(B_ID);
        var NOTE_com=document.getElementById('NOTE_com'.concat(B_ID)).innerText;
        // alert(NOTE_com)
        $.ajax({
            type : "post",
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            data:{
                com_name:NOTE_com
            },
            url : "GZNOTE",    //请求发送
            dataType : "json",        //返回数据形式为json
            success : function(data) {
                if (data[1].NOTE=="1"){
                    // alert(data[1].content)
                    document.getElementById("NOTE0").value =data[1].content;
                    // $("#NOTE").html(data[1].content);
                }
            },
            error : function(errorMsg) { //没做出错处理

            }
        })
    }
</script>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="slide" id="5">
        <div class="content fifth-content">
            <div class="container-fluid">
                <div class="col-md-6">
                    <form id="contact" action="" method="post">
                        <div class="row">
                            <div class="col-md-12">
                                <fieldset>
                                    <input name="name" type="text" class="form-control" id="name" placeholder="Your name..." required="">
                                </fieldset>
                            </div>
                            <div class="col-md-12">
                                <fieldset>
                                    <input name="email" type="email" class="form-control" id="email" placeholder="Your email..." required="">
                                </fieldset>
                            </div>
                            <div class="col-md-12">
                                <fieldset>
                                    <input name="subject" type="text" class="form-control" id="subject" placeholder="Subject..." required="">
                                </fieldset>
                            </div>
                            <div class="col-md-12">
                                <fieldset>
                                    <textarea name="message" rows="6" class="form-control" id="message" placeholder="Your message..." required=""></textarea>
                                </fieldset>
                            </div>
                            <div class="col-md-12">
                                <fieldset>
                                    <button type="submit" id="form-submit" class="btn">发送</button>
                                </fieldset>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%--<script src="User/js/vendor/jquery-1.11.2.min.js"></script>--%>

    <%--<script src="User/js/vendor/bootstrap.min.js"></script>--%>

    <script src="User/js/datepicker.js"></script>
    <script src="User/js/plugins.js"></script>
    <script src="User/js/main.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {



            // navigation click actions
            $('.scroll-link').on('click', function(event){
                event.preventDefault();
                var sectionID = $(this).attr("data-id");
                scrollToID('#' + sectionID, 750);
            });
            // scroll to top action
            $('.scroll-top').on('click', function(event) {
                event.preventDefault();
                $('html, body').animate({scrollTop:0}, 'slow');
            });
            // mobile nav toggle
            $('#nav-toggle').on('click', function (event) {
                event.preventDefault();
                $('#main-nav').toggleClass("open");
            });
        });
        // scroll function
        function scrollToID(id, speed){
            var offSet = 0;
            var targetOffset = $(id).offset().top - offSet;
            var mainNav = $('#main-nav');
            $('html,body').animate({scrollTop:targetOffset}, speed);
            if (mainNav.hasClass("open")) {
                mainNav.css("height", "1px").removeClass("in").addClass("collapse");
                mainNav.removeClass("open");
            }
        }
        if (typeof console === "undefined") {
            console = {
                log: function() { }
            };
        }
    </script>

    <script>
        //自适应
        $(window).load(function(){
            var navWidth=$(".nav").width();
            var navHeight=$(".nav").height();
            $(".logo").css("margin-left",(20/307)*navWidth);
            $(".nav").find("a").css("width",(152/307)*navWidth);
            $(".nav").find("a").css("height",(65/582)*navWidth);
            $(".nav").find("ul").css("margin-top",(40/307)*navWidth);
            $(".nav").find("li").css("width",(155/307)*navWidth);


        })
    </script>
</body>
</html>
