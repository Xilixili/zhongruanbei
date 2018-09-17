<%@ page import="com.hmz.entity.Company2" %>
<%@ page import="com.hmz.dao.impl.CompanyDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hmz.entity.Brand" %>
<%--
  Created by IntelliJ IDEA.
  User: jojoba
  Date: 2018/6/21
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工商信息</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="TC/css/style.css" type="text/css">

    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="GS/css/change.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="GS/css/demo.css" media="all" />
    <link href="GS/css/style.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/4.0.4/echarts-en.common.js"></script>--%>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://echarts.baidu.com/dist/echarts.min.js"></script>
    <script src="js/china.js"></script>
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
    <%--<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>--%>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>

    <%--<link rel="stylesheet" href="Brand/css/style.css" type="text/css">--%>

    <%
        String reg_no=request.getParameter("reg_no");
        String Addr=request.getParameter("Addr");
        String com_name=request.getParameter("com_name");
        System.out.println(reg_no);
        String type;
        if (com_name.contains("有限公司")){
            type="法定代表人";
        }
        else {
            type="负责人";
        }
    %>
</head>
<body>

<script type="text/javascript">
    // 一加载就被执行
    $(document).ready(function() {
        $("#test").hide();
// alert(result[1][1].company20.FD);
        $.ajax({
            type : "post",
            url : "servletdao",
            dataType : "json", 				//返回数据形式为json
            /*容易出错  */
            data : {
                reg_no : "<%=reg_no%>",
                com_name : "<%=com_name%>"
            },
            success : function(result) {

                // alert(result[0][0].company2.FW);
// EName为英文名
                EName=result[2].translation
                // alert(EName)
                // alert(result[3][0].company20.com_name);
                // alert(result[0][2].GD0.GDBL);
                $(".ZB").html(result[0][0].company2.ZB);
                $(".YZ").html(result[0][0].company2.YZ);
                $(".YX").html(result[0][0].company2.YX);
                $(".RQ").html(result[0][0].company2.RQ);
                $(".reg_no").html(result[0][0].company2.reg_no);
                $(".LX").html(result[0][0].company2.LX);
                $(".HZRQ").html(result[0][0].company2.HZRQ);
                $("#FWD").html(result[0][0].company2.FW);
                // $(".FW")[0].innerHTML = result[0][0].company2.FW;
                $(".FD").html(result[0][0].company2.FD);
                $(".DJZT").html(result[0][0].company2.DJZT);
                $(".DJJG").html(result[0][0].company2.DJJG);
                $(".com_name").html(result[0][0].company2.com_name);
                $(".Addr").html(result[0][0].company2.Addr);
                $(".DH").html(result[0][0].company2.DH);
                $(".JJ").html(result[0][0].company2.JJ);
                $(".com_url").html(result[0][0].company2.com_url);
                document.getElementById("url").setAttribute("href",result[0][0].company2.com_url);
                $(".English").html(EName);
//分公司
                $(".company2F1").html(result[0][1].company2F1);
                $(".company2F2").html(result[0][1].company2F2);
                $(".company2F3").html(result[0][1].company2F3);
                $(".company2F4").html(result[0][1].company2F4);
                $(".company2F5").html(result[0][1].company2F5);
                $(".company2F6").html(result[0][1].company2F6);
                $(".company2F7").html(result[0][1].company2F7);
                $(".company2F8").html(result[0][1].company2F8);
                $(".company2F9").html(result[0][1].company2F9);
                $(".company2F10").html(result[0][1].company2F10);
                $(".company2F11").html(result[0][1].company2F11);
                $(".company2F12").html(result[0][1].company2F12);
                $(".company2F13").html(result[0][1].company2F13);
                $(".company2F14").html(result[0][1].company2F14);

//公司高管
                $(".company2Pe1").html(result[0][2].company2Pe1);
                $(".company2Pe2").html(result[0][2].company2Pe2);
                $(".company2Pe3").html(result[0][2].company2Pe3);
                $(".company2Pe4").html(result[0][2].company2Pe4);
                $(".company2Pe5").html(result[0][2].company2Pe5);
                $(".company2Pe6").html(result[0][2].company2Pe6);
                $(".company2Pe7").html(result[0][2].company2Pe7);
                $(".company2Pe8").html(result[0][2].company2Pe8);

                $(".company2Po1").html(result[0][2].company2Po1);
                $(".company2Po2").html(result[0][2].company2Po2);
                $(".company2Po3").html(result[0][2].company2Po3);
                $(".company2Po4").html(result[0][2].company2Po4);
                $(".company2Po5").html(result[0][2].company2Po5);
                $(".company2Po6").html(result[0][2].company2Po6);
                $(".company2Po7").html(result[0][2].company2Po7);
                $(".company2Po8").html(result[0][2].company2Po8);




                // $(".PRO").html(result[0][3].company1.PRO);
                $(".FW1").html(result[0][3].company1.FW);

                //
                // if (result[0][4].GD0){
                //     $(".GD0_name").html(result[0][4].GD0.GD_name);
                // }
                // if (result[0][4].GD1){
                //     $(".GD1_name").html(result[0][4].GD1.GD_name);
                // }
                // $(".GD0_name").html(result[0][4].GD0.GD_name);
                // $(".GD1_name").html(result[0][4].GD1.GD_name);
                // $(".GD2_name").html(result[0][4].GD2.GD_name);
                // $(".GD3_name").html(result[0][2].GD3.GD_name);
                // $(".GD4_name").html(result[0][2].GD4.GD_name);

                if (result[0][4].GD0){
                    $(".GD0_name").html(result[0][4].GD0.GD_name);
                    $(".GD0_ZB").html(result[0][4].GD0.GDBL);
                    $(".GD0_BL").html(result[0][4].GD0.BL);
                }
                if (result[0][4].GD1){
                    $(".GD1_name").html(result[0][4].GD1.GD_name);
                    $(".GD1_ZB").html(result[0][4].GD1.GDBL);
                    $(".GD1_BL").html(result[0][4].GD1.BL);
                }
                if (result[0][4].GD2){
                    $(".GD2_name").html(result[0][4].GD2.GD_name);
                    $(".GD2_ZB").html(result[0][4].GD2.GDBL);
                    $(".GD2_BL").html(result[0][4].GD2.BL);
                }
                if (result[0][4].GD3){
                    $(".GD3_name").html(result[0][4].GD3.GD_name);
                    $(".GD3_ZB").html(result[0][4].GD3.GDBL);
                    $(".GD3_BL").html(result[0][4].GD3.BL);
                }
                if (result[0][4].GD4){
                    $(".GD4_name").html(result[0][4].GD4.GD_name);
                    $(".GD4_ZB").html(result[0][4].GD4.GDBL);
                    $(".GD4_BL").html(result[0][4].GD4.BL);
                }


                if (result[3][0]) {
                    if (result[3][0].company20) {
                        $(".DWTZ0_name").html(result[3][0].company20.com_name);
                        $(".DWTZ0_FD").html(result[3][0].company20.FD);
                        $(".DWTZ0_DJZT").html(result[3][0].company20.DJZT);
                        $(".DWTZ0_RQ").html(result[3][0].company20.RQ);
                    }
                    if (result[3][0].company21) {
                        $(".DWTZ1_name").html(result[3][0].company21.com_name);
                        $(".DWTZ1_FD").html(result[3][0].company21.FD);
                        $(".DWTZ1_DJZT").html(result[3][0].company21.DJZT);
                        $(".DWTZ1_RQ").html(result[3][0].company21.RQ);
                    }
                    if (result[3][0].company22) {
                        $(".DWTZ2_name").html(result[3][0].company22.com_name);
                        $(".DWTZ2_FD").html(result[3][0].company22.FD);
                        $(".DWTZ2_DJZT").html(result[3][0].company22.DJZT);
                        $(".DWTZ2_RQ").html(result[3][0].company22.RQ);
                    }
                    if (result[3][0].company23) {
                        $(".DWTZ3_name").html(result[3][0].company23.com_name);
                        $(".DWTZ3_FD").html(result[3][0].company23.FD);
                        $(".DWTZ3_DJZT").html(result[3][0].company23.DJZT);
                        $(".DWTZ3_RQ").html(result[3][0].company23.RQ);
                    }
                    if (result[3][0].company24) {
                        $(".DWTZ4_name").html(result[3][0].company24.com_name);
                        $(".DWTZ4_FD").html(result[3][0].company24.FD);
                        $(".DWTZ4_DJZT").html(result[3][0].company24.DJZT);
                        $(".DWTZ4_RQ").html(result[3][0].company24.RQ);
                    }
                    if (result[3][0].company25) {
                        $(".DWTZ5_name").html(result[3][0].company25.com_name);
                        $(".DWTZ5_FD").html(result[3][0].company25.FD);
                        $(".DWTZ5_DJZT").html(result[3][0].company25.DJZT);
                        $(".DWTZ5_RQ").html(result[3][0].company25.RQ);
                    }
                    if (result[3][0].company26) {
                        $(".DWTZ6_name").html(result[3][0].company26.com_name);
                        $(".DWTZ6_FD").html(result[3][0].company26.FD);
                        $(".DWTZ6_DJZT").html(result[3][0].company26.DJZT);
                        $(".DWTZ6_RQ").html(result[3][0].company26.RQ);
                    }
                    if (result[3][0].company27) {
                        $(".DWTZ7_name").html(result[3][0].company27.com_name);
                        $(".DWTZ7_FD").html(result[3][0].company27.FD);
                        $(".DWTZ7_DJZT").html(result[3][0].company27.DJZT);
                        $(".DWTZ7_RQ").html(result[3][0].company27.RQ);
                    }
                    if (result[3][0].company28) {
                        $(".DWTZ8_name").html(result[3][0].company28.com_name);
                        $(".DWTZ8_FD").html(result[3][0].company28.FD);
                        $(".DWTZ8_DJZT").html(result[3][0].company28.DJZT);
                        $(".DWTZ8_RQ").html(result[3][0].company28.RQ);
                    }
                    if (result[3][0].company29) {
                        $(".DWTZ9_name").html(result[3][0].company29.com_name);
                        $(".DWTZ9_FD").html(result[3][0].company29.FD);
                        $(".DWTZ9_DJZT").html(result[3][0].company29.DJZT);
                        $(".DWTZ9_RQ").html(result[3][0].company29.RQ);
                    }
                }
                // $(".DWTZ0_name").html(result[3][0].company20.com_name);
                // // $("#DWTZ0_name").html(result[3][0].company20.com_name);
                // $(".DWTZ1_name").html(result[3][0].company21.com_name);
                // $(".DWTZ2_name").html(result[1][1].company22.com_name);
                // $(".DWTZ3_name").html(result[1][1].company23.com_name);
                // $(".DWTZ4_name").html(result[1][1].company24.com_name);

                // $(".DWTZ0_FD").html(result[3][0].company20.FD);
                // $(".DWTZ1_FD").html(result[3][0].company21.FD);
                // $(".DWTZ2_FD").html(result[1][1].company22.FD);
                // $(".DWTZ3_FD").html(result[1][1].company23.FD);
                // $(".DWTZ4_FD").html(result[1][1].company24.FD);
                //
                // $(".DWTZ0_DJZT").html(result[3][0].company20.DJZT);
                // $(".DWTZ1_DJZT").html(result[3][0].company21.DJZT);
                // $(".DWTZ2_DJZT").html(result[1][1].company22.DJZT);
                // $(".DWTZ3_DJZT").html(result[1][1].company23.DJZT);
                // $(".DWTZ4_DJZT").html(result[1][1].company24.DJZT);



            },
            error : function(errorMsg) {
                // alert("不好意思,servletdao请求数据失败啦!");
            }
        });

            $.ajax({
                type : "post",
                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                data:{
                    com_name:"<%=com_name%>"
                },
                url : "GZNOTE",    //请求发送
                dataType : "json",        //返回数据形式为json
                success : function(data) {
                    if (data[0].GZ=="1") {
                        $("#guanzhu").html("已关注");
                    }
                    if (data[1].NOTE=="1"){
                        document.getElementById("NOTE").value =data[1].content;
                        // $("#NOTE").html(data[1].content);
                    }
                },
                error : function(errorMsg) { //没做出错处理

                }
            })






    });
</script>

<div class="naver">
    <div class="fanhui">
    <a href="/main1.jsp">返回首页</a>
    </div>
    <img src="/JG/images/logo1.png" alt="Logo" />
</div><!--naver结束-->

<div class="headinfo">
    <div class="headinfo_left">
        <img src="GS/images/default.jpg">
    </div><!--headinfo_left-->
    <div class="headinfo_right">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal1" data-whatever="@mdo">笔记</button>
        <div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content" style="height:350px">
                    <div class="modal-header" style="height:50px;">
                        <h5 class="modal-title" id="exampleModalLabel" >笔记</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" >
                        <form>
                            <div class="form-group">
                                <input type="text" id="NOTE"  class="form-control"  placeholder="输入笔记...">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" onclick="NOTE();" class="btn btn-secondary" data-dismiss="modal" style="width:70px;height:35px;">确定</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal2" id="guanzhu">
            关注
        </button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content" style="height:200px">
                    <div class="modal-header" style="height:50px;" >
                        <h5 class="modal-title" id="exampleModalLabel1">关注</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" >
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" >
                        是否关注该公司？
                    </div>
                    <div class="modal-footer">
                        <button type="button" onclick="guanzhu()" class="btn btn-secondary" data-dismiss="modal" style="width:70px;height:35px;">是</button>
                        <button type="button" class="btn btn-primary" style="width:70px;height:35px;">否</button>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            function guanzhu()
            {
                // alert()
                // var btn = document.getElementsByClassName("exampleModalLabel1");
                $("#guanzhu").html("已关注");
                var date1=RQ();
                $.ajax({
                    type : "post",
                    async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                    data:{
                        RQ:date1,
                        com_name:"<%=com_name%>"
                    },
                    url : "UserGZ",    //请求发送
                    dataType : "json",        //返回数据形式为json
                    success : function(data) {
                        if (data) {


                        }
                    },
                    error : function(errorMsg) { //没做出错处理

                    }
                })

            }


            function NOTE()
            {
                var date1=RQ();
                var content=$("#NOTE").val();
                // alert(content);
                // alert(content);
                $.ajax({
                    type : "post",
                    async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                    data:{
                        content:content,
                        RQ:date1,
                        com_name:"<%=com_name%>"
                    },
                    url : "UserNOTE",    //请求发送
                    dataType : "json",        //返回数据形式为json
                    success : function(data) {
                        if (data) {


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
        </script>

        <h4><%=com_name%></h4>
        <span >电话：</span><span class="DH">0755-86013388</span><span >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;官网：<a href="" id="url" class="com_url">--</a> </span><br>
        <span >邮箱：<a href="" class="YX">landyzhang@tencent.com</a></span><span >地址：<a href="map.jsp?Addr=<%=Addr%>"><%=Addr%></a>  </span><br>
        <span>公司简介：
            <!-- Button trigger modal -->
<span class="ad"><a  href="" data-toggle="modal" data-target="#exampleModalLong">
  查看详情
</a></span>
            <!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog"  role="document">
    <div class="modal-content" style="width:900px;margin-right:100px">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">公司简介</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div   class="modal-body JJ">
                 -------
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
         </span>
    </div><!--headinfo_right-->
</div><!--headinfo"-->
<div class="container">
    <div class="info">
        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">工商信息</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">股东信息</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">对外投资</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-member-tab" data-toggle="pill" href="#pills-member" role="tab" aria-controls="pills-member" aria-selected="false">主要人员</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="pills-orgnize-tab" data-toggle="pill" href="#pills-orgnize" role="tab" aria-controls="pills-orgnize" aria-selected="false">分支机构</a>
            </li>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" id="pills-change-tab" data-toggle="pill" href="#pills-change" role="tab" aria-controls="pills-change" aria-selected="false">变更记录</a>--%>
            <%--</li>--%>
            <li class="nav-item">
                <a class="nav-link" id="pills-introduce-tab" data-toggle="pill" href="#pills-introduce" role="tab" aria-controls="pills-introduce" aria-selected="false">公司简介</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" id="pills-brand-tab" data-toggle="pill" href="#pills-brand" role="tab" aria-controls="pills-brand" aria-selected="false">企业品牌</a>
            </li>
        </ul>
        <div class="tab-content" id="pills-tabContent">
            <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab"><table class="ntable">
                <tbody>
                <tr>
                    <td class="tb">法定代表人/负责人信息</td>
                    <td class="tb">企业关联图谱</td>
                    <td class="tb">股权结构图</td>
                </tr>
                <tr>
                    <td height="170px" width="35%">
                        <div class="box_td">
                            <div class="clearfix">
                                <div class="fix-left">
                                    <img src="">
                                </div><!--fix-left-->
                                <div class="fix-right">
                                    <h3 class="FD">--</h3><br>
                                    <%--<p><a href="">他关联16家公司></a></p>--%>
                                </div><!--fix-right-->
                            </div><!--clearfix-->
                            <div class="button">
                                <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">--%>
                                <%--查看人物关系--%>
                                <%--</button>--%>
                            </div><!--button-->
                        </div><!--box_td-->
                    </td>

                    <td width="35%;">
                        <div class="box_td" >
                            <div class="clearfix" >
                                <img src="images/relation.png">
                            </div><!--clearfix-->
                            <div class="button1">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg1">查看详情</button>
                                <div class="modal fade bd-example-modal-lg1" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content" style="width:1000px;height:700px;margin:0px auto">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLongTitle">企业图谱</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <ul class="nav nav-tabs" id="myTab" role="tablist" >
                                                    <li class="nav-item">

                                                    </li>
                                                    <li class="nav-item">

                                                    </li>
                                                    <li class="nav-item">

                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">关联图谱</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">企业图谱</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false">投资图谱</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link" id="contact-tab2" data-toggle="tab" href="#guquan" role="tab" aria-controls="guquan" aria-selected="false">疑似控制人</a>
                                                    </li>

                                                    <li class="nav-item">

                                                    </li>
                                                    <li class="nav-item">

                                                    </li>
                                                </ul>
                                                <div class="tab-content" id="myTabContent">
                                                    <!--关联图谱-->
                                                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                                        <div id="container1" style="width:900px;height:570px;"></div>
                                                        <script  type="text/javascript">

                                                            var dom2 = document.getElementById("container1");
                                                            var myChart4 = echarts.init(dom2);
                                                            $.ajax({
                                                                type : "post",
                                                                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                                                                data:{
                                                                    com_name:"<%=com_name%>"
                                                                },
                                                                url : "Servlet7",    //请求发送
                                                                dataType : "json",        //返回数据形式为json
                                                                success : function(data) {
                                                                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                                                                    if (data) {
                                                                        option = {
                                                                            tooltip: {
                                                                                show: false
                                                                            },
                                                                            legend: {
                                                                                x: "center",
                                                                                data: ["主企业", "其他企业","投资者"]
                                                                            },
                                                                            animation: false,
                                                                            series: [{
                                                                                categories: [{
                                                                                    name: '主企业',
                                                                                    itemStyle: {
                                                                                        normal: {
                                                                                            color: "#009800",
                                                                                        }
                                                                                    }
                                                                                }, {
                                                                                    name: '其他企业',
                                                                                    itemStyle: {
                                                                                        normal: {
                                                                                            color: "#4592FF",
                                                                                        }
                                                                                    }
                                                                                },{
                                                                                    name: '投资者',
                                                                                    itemStyle: {
                                                                                        normal: {
                                                                                            color: "#ff81c4",
                                                                                        }
                                                                                    }
                                                                                }],
                                                                                type: 'graph',
                                                                                layout: 'force',
                                                                                symbol: "circle",
                                                                                symbolSize: 50,
                                                                                roam: true, //禁止用鼠标滚轮缩小放大效果
                                                                                edgeSymbol: ['circle', 'arrow'],
                                                                                edgeSymbolSize: [0, 10],
                                                                                // 连接线上的文字
                                                                                focusNodeAdjacency: true, //划过只显示对应关系
                                                                                edgeLabel: {
                                                                                    normal: {
                                                                                        show: true,
                                                                                        textStyle: {
                                                                                            fontSize: 11
                                                                                        },
                                                                                        formatter: "{c}"
                                                                                    }
                                                                                },
                                                                                categories: [{
                                                                                    name: '主企业',
                                                                                    itemStyle: {
                                                                                        normal: {
                                                                                            color: "#ed1c18",
                                                                                        }
                                                                                    }
                                                                                }, {
                                                                                    name: '其他企业',
                                                                                    itemStyle: {
                                                                                        normal: {
                                                                                            color: "#4592FF",
                                                                                        }
                                                                                    }
                                                                                },
                                                                                    {
                                                                                        name: '投资者',
                                                                                        itemStyle: {
                                                                                            normal: {
                                                                                                color: "#ff7d18",
                                                                                            }
                                                                                        }
                                                                                    }],
                                                                                lineStyle: {
                                                                                    normal: {
                                                                                        opacity: 1,
                                                                                        width: 2,
                                                                                        curveness: 0
                                                                                    }
                                                                                },
                                                                                // 圆圈内的文字
                                                                                label: {
                                                                                    normal: {
                                                                                        show: true
                                                                                    }
                                                                                },
                                                                                force: {
                                                                                    repulsion: 5000
                                                                                },
                                                                                data: data[0]

                                                                                ,
                                                                                links: data[1]

                                                                            }]
                                                                        };
                                                                        myChart4.on('click', function(params) {


                                                                            // 控制台打印数据的名称
                                                                            // alert(params.name)
                                                                            $.ajax({
                                                                                type : "post",
                                                                                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                                                                                data:{
                                                                                    com_name:params.name
                                                                                },
                                                                                url : "Servlet9",    //请求发送
                                                                                dataType : "json",        //返回数据形式为json
                                                                                success : function(data) {
                                                                                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                                                                                    if (data) {
                                                                                        document.getElementById("aaaa").href="/xinxi.jsp?reg_no="+data[0]+"&Addr="+data[1]+"&com_name="+data[2];
                                                                                        document.getElementById("aaaa").innerHTML = params.name;
                                                                                        document.getElementById("aaaa2").innerHTML = data[0];
                                                                                        document.getElementById("aaaa3").innerHTML = data[1];
                                                                                        document.getElementById("aaaa1").innerHTML = data[3];
                                                                                        document.getElementById("aaaa4").innerHTML = data[4];
                                                                                        if (data[5][0]){
                                                                                            document.getElementById("DW0").innerHTML = data[5][0];
                                                                                        }else {
                                                                                            document.getElementById("DW0").innerHTML = "--";
                                                                                        }
                                                                                        if (data[5][1]){
                                                                                            document.getElementById("DW1").innerHTML = data[5][1];
                                                                                        }else {
                                                                                            document.getElementById("DW1").innerHTML = "--";
                                                                                        }
                                                                                        if (data[5][2]){
                                                                                            document.getElementById("DW2").innerHTML = data[5][2];
                                                                                        }else {
                                                                                            document.getElementById("DW2").innerHTML = "--";
                                                                                        }
                                                                                        if (data[5][3]){
                                                                                            document.getElementById("DW3").innerHTML = data[5][3];
                                                                                        }else {
                                                                                            document.getElementById("DW3").innerHTML = "--";
                                                                                        }
                                                                                        if (data[6][1]){
                                                                                            document.getElementById("G0").innerHTML = data[6][1];
                                                                                            document.getElementById("G00").innerHTML = "大股东";
                                                                                        }else {
                                                                                            document.getElementById("G0").innerHTML = "--";
                                                                                            document.getElementById("G00").innerHTML = "--";
                                                                                        }
                                                                                        if (data[6][2]){
                                                                                            document.getElementById("G1").innerHTML = data[6][2];
                                                                                            document.getElementById("G11").innerHTML ="自然人股东";
                                                                                        }else {
                                                                                            document.getElementById("G1").innerHTML = "--";
                                                                                            document.getElementById("G11").innerHTML = "--";
                                                                                        }
                                                                                        if (data[7]){
                                                                                            $("#GG1").html(data[7].GGPe1);
                                                                                            $("#GG11").html(data[7].GGPo1);
                                                                                            $("#GG2").html(data[7].GGPe2);
                                                                                            $("#GG22").html(data[7].GGPo2);
                                                                                            $("#GG3").html(data[7].GGPe3);
                                                                                            $("#GG33").html(data[7].GGPo3);
                                                                                            // document.getElementById("GG1").innerHTML = data[7].GGPe1;
                                                                                            // document.getElementById("GG11").innerHTML =data[7].GGPo1;
                                                                                            // document.getElementById("GG2").innerHTML = data[7].GGPe2;
                                                                                            // document.getElementById("GG22").innerHTML =data[7].GGPo2;
                                                                                            // document.getElementById("GG3").innerHTML = data[7].GGPe3;
                                                                                            // document.getElementById("GG33").innerHTML =data[7].GGPo3;
                                                                                        }
                                                                                        return Go();
                                                                                    }else {
                                                                                        document.getElementById("aaaa").innerHTML = params.name;
                                                                                        return Go();
                                                                                    }
                                                                                    //     window.location.href = "/xinxi.jsp?reg_no="+data[0]+"&Addr="+data[1]+"&com_name="+data[2];
                                                                                    // }else {
                                                                                    //     window.location.href = "/error2.jsp";
                                                                                    // }
                                                                                },
                                                                                error : function(errorMsg) { //没做出错处理
                                                                                    //请求失败时执行该函数
                                                                                    // alert("Servlet7关联图谱失败!");
                                                                                    myChart2.hideLoading();
                                                                                }
                                                                            });
                                                                    })
                                                                        myChart4.setOption(option);
                                                                }
                                                                },
                                                                error : function(errorMsg) { //没做出错处理
                                                                    //请求失败时执行该函数
                                                                    // alert("Servlet7关联图谱失败!");
                                                                    myChart2.hideLoading();
                                                                }
                                                            })
                                                        </script>
                                                    </div>
                                                    <!--企业图谱-->
                                                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                                        <div id="container" style="width:900px;height:570px;"></div>
                                                        <script type="text/javascript">
                                                            var dom = document.getElementById("container");
                                                            var myChart2 = echarts.init(dom);
                                                            // var app = {};
                                                            option = null;
                                                            myChart2.showLoading();
                                                            var datas = [];    //类别数组（实际用来盛放X轴坐标值）

                                                            $.ajax({
                                                                type : "post",
                                                                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                                                                data:{
                                                                    reg_no : "<%=reg_no%>"
                                                                },
                                                                url : "Servlet1",    //请求发送
                                                                dataType : "json",        //返回数据形式为json
                                                                success : function(data) {
                                                                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                                                                    if (data) {
                                                                        datas=data;
                                                                        // alert(data);
                                                                        // var categories = result.categories;
                                                                        // for(var i=0;i<categories.length;i++){
                                                                        //     //alert( categories[i] );
                                                                        //     categorie2.push( categories[i] );    //挨个取出类别并填入类别数组


                                                                        myChart2.hideLoading();
                                                                        myChart2.setOption(option = {
                                                                            tooltip: {
                                                                                trigger: 'item',
                                                                                triggerOn: 'mousemove'
                                                                            },
                                                                            series: [
                                                                                {
                                                                                    type: 'tree',

                                                                                    data: [datas],

                                                                                    top: '18%',
                                                                                    bottom: '14%',

                                                                                    layout: 'radial',

                                                                                    symbol: 'emptyCircle',

                                                                                    symbolSize: 7,

                                                                                    initialTreeDepth: 3,

                                                                                    animationDurationUpdate: 750

                                                                                }
                                                                            ]
                                                                        });
                                                                    }
                                                                    //alert(series);

                                                                },
                                                                error : function(errorMsg) { //没做出错处理
                                                                    //请求失败时执行该函数
                                                                    // alert("Servlet1企业图谱失败!");
                                                                    myChart2.hideLoading();
                                                                }
                                                            });
                                                            if (option && typeof option === "object") {
                                                                myChart2.setOption(option, true);
                                                            }
                                                        </script>
                                                    </div>
                                                    <!--投资图谱-->
                                                    <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                                                        <div id="container2" style="width:800px;height:630px;"></div>
                                                        <script type="text/javascript">
                                                            var dom1 = document.getElementById("container2");
                                                            var myChart3 = echarts.init(dom1);
                                                            // var app = {};
                                                            option = null;
                                                            myChart3.showLoading();
                                                            var datas = [];    //类别数组（实际用来盛放X轴坐标值）
                                                            $.ajax({
                                                                type : "post",
                                                                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                                                                data:{
                                                                    reg_no : "<%=reg_no%>"
                                                                },
                                                                url : "Servlet2",    //请求发送
                                                                dataType : "json",        //返回数据形式为json
                                                                success : function(data) {
                                                                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                                                                    if (data) {
                                                                        datas=data;
                                                                        // alert(data);
                                                                        // var categories = result.categories;
                                                                        // for(var i=0;i<categories.length;i++){
                                                                        //     //alert( categories[i] );
                                                                        //     categorie2.push( categories[i] );    //挨个取出类别并填入类别数组
                                                                        myChart3.hideLoading();
                                                                        myChart3.setOption(option = {
                                                                            tooltip: {
                                                                                trigger: 'item',
                                                                                triggerOn: 'mousemove'
                                                                            },
                                                                            series: [
                                                                                {
                                                                                    type: 'tree',

                                                                                    data: [datas],

                                                                                    top: '1%',
                                                                                    left: '7%',
                                                                                    bottom: '1%',
                                                                                    right: '20%',

                                                                                    symbolSize: 7,

                                                                                    label: {
                                                                                        normal: {
                                                                                            position: 'left',
                                                                                            verticalAlign: 'middle',
                                                                                            align: 'right',
                                                                                            fontSize: 9
                                                                                        }
                                                                                    },

                                                                                    leaves: {
                                                                                        label: {
                                                                                            normal: {
                                                                                                position: 'right',
                                                                                                verticalAlign: 'middle',
                                                                                                align: 'left'
                                                                                            }
                                                                                        }
                                                                                    },

                                                                                    expandAndCollapse: true,
                                                                                    animationDuration: 550,
                                                                                    animationDurationUpdate: 750
                                                                                }
                                                                            ]
                                                                        });
                                                                        // myChart3.setOption(option = {
                                                                        //     tooltip: {
                                                                        //         trigger: 'item',
                                                                        //         triggerOn: 'mousemove'
                                                                        //     },
                                                                        //     series: [
                                                                        //         {
                                                                        //             type: 'tree',
                                                                        //
                                                                        //             data: [datas],
                                                                        //
                                                                        //             top: '18%',
                                                                        //             bottom: '14%',
                                                                        //
                                                                        //             layout: 'radial',
                                                                        //
                                                                        //             symbol: 'emptyCircle',
                                                                        //
                                                                        //             symbolSize: 7,
                                                                        //
                                                                        //             initialTreeDepth: 3,
                                                                        //
                                                                        //             animationDurationUpdate: 750
                                                                        //
                                                                        //         }
                                                                        //     ]
                                                                        // });
                                                                    }
                                                                    //alert(series);

                                                                },
                                                                error : function(errorMsg) { //没做出错处理
                                                                    //请求失败时执行该函数
                                                                    // alert("Servlet2投资图谱失败!");
                                                                    myChart3.hideLoading();
                                                                }
                                                            })
                                                            ;
                                                            if (option && typeof option === "object") {
                                                                myChart3.setOption(option, true);
                                                            }
                                                        </script>
                                                    </div>


                                                    <script type="text/javascript">
                                                        function click1()
                                                        {

                                                        }
                                                        function click2()
                                                        {

                                                        }

                                                    </script>
                                                    <!--疑似实际控股人-->
                                                    <div class="tab-pane fade" id="guquan" role="tabpanel" aria-labelledby="contact-tab2">
                                                        <div id="container3" style="width:900px;height:570px;"></div>
                                                        <script>

                                                            var dom5 = document.getElementById('container3');
                                                            var myChart5 = echarts.init(dom5);
                                                            // dom.style.width = 780 + 'px';
                                                            // dom.style.height = 600 + 'px';
                                                            $.ajax({
                                                                type : "post",
                                                                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                                                                data:{
                                                                    com_name:"<%=com_name%>"
                                                                },
                                                                url : "Servlet6",    //请求发送
                                                                dataType : "json",        //返回数据形式为json
                                                                success : function(data) {
                                                                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                                                                    if (data) {
                                                                        option = {
                                                                            tooltip: {
                                                                                show: false
                                                                            },
                                                                            legend: {
                                                                                x: "center",
                                                                                data: ["中间公司","目的公司","控制人"]
                                                                            },
                                                                            animation: false,
                                                                            series: [{
                                                                                categories: [{
                                                                                    name: '中间公司',
                                                                                    itemStyle: {
                                                                                        normal: {
                                                                                            color: "#009800",
                                                                                        }
                                                                                    }
                                                                                }, {
                                                                                    name: '目的公司',
                                                                                    itemStyle: {
                                                                                        normal: {
                                                                                            color: "#4592FF",
                                                                                        }
                                                                                    }
                                                                                },
                                                                                    {
                                                                                        name: '控制人',
                                                                                        itemStyle: {
                                                                                            normal: {
                                                                                                color: "#ed1c18",
                                                                                            }
                                                                                        }
                                                                                    }],
                                                                                type: 'graph',
                                                                                layout: 'force',
                                                                                symbol: "circle",
                                                                                symbolSize: 50,
                                                                                roam: true, //禁止用鼠标滚轮缩小放大效果
                                                                                edgeSymbol: ['circle', 'arrow'],
                                                                                edgeSymbolSize: [0, 10],
                                                                                // 连接线上的文字
                                                                                focusNodeAdjacency: true, //划过只显示对应关系
                                                                                edgeLabel: {
                                                                                    normal: {
                                                                                        show: true,
                                                                                        textStyle: {
                                                                                            fontSize: 20
                                                                                        },
                                                                                        formatter: "{c}"
                                                                                    }
                                                                                },
                                                                                categories: [{
                                                                                    name: '中间公司',
                                                                                    itemStyle: {
                                                                                        normal: {
                                                                                            color: "#009800",
                                                                                        }
                                                                                    }
                                                                                }, {
                                                                                    name: '目的公司',
                                                                                    itemStyle: {
                                                                                        normal: {
                                                                                            color: "#4592FF",
                                                                                        }
                                                                                    }
                                                                                },{
                                                                                    name: '控制人',
                                                                                    itemStyle: {
                                                                                        normal: {
                                                                                            color: "#ed1c18",
                                                                                        }
                                                                                    }
                                                                                }],
                                                                                lineStyle: {
                                                                                    normal: {
                                                                                        opacity: 1,
                                                                                        width: 2,
                                                                                        curveness: 0
                                                                                    }
                                                                                },
                                                                                // 圆圈内的文字
                                                                                label: {
                                                                                    normal: {
                                                                                        show: true
                                                                                    }
                                                                                },
                                                                                force: {
                                                                                    repulsion: 5000
                                                                                },
                                                                                data: data[0]
                                                                                //     [{
                                                                                //     name: '节点1',
                                                                                //     category: 1,
                                                                                //     draggable: true,
                                                                                //
                                                                                // }, {
                                                                                //     name: '节点5',
                                                                                //     category: 0,
                                                                                //     draggable: true,
                                                                                // },
                                                                                //     {
                                                                                //         name: '节点7',
                                                                                //         category: 0,
                                                                                //         draggable: true,
                                                                                //     }]
                                                                                ,
                                                                                links: data[1]
                                                                                // [
                                                                                // {
                                                                                //     source: '节点1',
                                                                                //     target: '节点3',
                                                                                //     value: "朋友"
                                                                                // }, {
                                                                                //     source: '节点1',
                                                                                //     target: '节点4',
                                                                                //     value: "家人"
                                                                                // }, {
                                                                                //     source: '节点1',
                                                                                //     target: '节点5',
                                                                                //     value: "家人"
                                                                                // }, {
                                                                                //     source: '节点1',
                                                                                //     target: '节点6',
                                                                                //     value: "家人"
                                                                                // },
                                                                                // {
                                                                                //     source: '节点5',
                                                                                //     source: '节点5',
                                                                                //     target: '节点7',
                                                                                //     value: "家人"
                                                                                // },]
                                                                            }]
                                                                        };
                                                                        myChart5.setOption(option);
                                                                    }
                                                                },
                                                                error : function(errorMsg) { //没做出错处理
                                                                    //请求失败时执行该函数
                                                                    // alert("Servlet6疑似实际控股人失败!");
                                                                    myChart5.hideLoading();
                                                                }
                                                            })
                                                        </script>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!--button-->
            </div><!--box_td-->
            </td>
            <td>
                <div class="box_td" >
                    <div class="clearfix" >
                        <img src="images/guquan.png">
                    </div><!--clearfix-->
                    <div class="button">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">查看详情</button>
                        <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content" style="width:1000px;height:700px;margin:0px auto">
                                    <div class="modal-header" style="height:50px;">
                                        <h5 class="modal-title" id="exampleModalLongTitle">股权结构</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body"  >
                                        <div id="main1" style="width:900px;height:570px;"></div>
                                        <script type="text/javascript">
                                            // 基于准备好的dom，初始化echarts实例
                                            $.ajax({
                                                type : "post",
                                                data:{
                                                    reg_no : "<%=reg_no%>"
                                                },
                                                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                                                url : "Servlet5",    //请求发送
                                                dataType : "json",        //返回数据形式为json
                                                success : function(data) {
                                                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                                                    if (data) {
                                                        var myChart1 = echarts.init(document.getElementById('main1'));
                                                        option = {
                                                            tooltip: {
                                                                trigger: 'item',
                                                                formatter: "{a} <br/>{b}: {c} ({d}%)"
                                                            },
                                                            title: {
                                                                text: '占股最大成员：'+data[2]+ '-->'+'<%=com_name%>',
                                                                subtext: '',
                                                                x: 'center'
                                                            },
                                                            //tooltip: {
                                                            //    trigger: 'item',
                                                            //    formatter: "{a} <br/>{b}: {c} ({d}%)"
                                                            //},
                                                            legend: {
                                                                orient: 'vertical',
                                                                x: 'left',
                                                                data: data[0]
                                                                // ['马化腾', '张志东', '许晨晔', '陈一丹']
                                                            },
                                                            series: [
                                                                {
                                                                    name: '股权比例',
                                                                    type: 'pie',
                                                                    radius: ['40%', '55%'],
                                                                    label: {
                                                                        normal: {
                                                                            formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                                                                            backgroundColor: '#FFF',
                                                                            borderColor: '#708090 ',
                                                                            borderWidth: 1.5,
                                                                            borderRadius: 4,
                                                                            // shadowBlur:3,
                                                                            // shadowOffsetX: 2,
                                                                            // shadowOffsetY: 2,
                                                                            // shadowColor: '#999',
                                                                            // padding: [0, 7],
                                                                            rich: {
                                                                                a: {
                                                                                    color: '#999',
                                                                                    lineHeight: 22,
                                                                                    align: 'center'
                                                                                },
                                                                                // abg: {
                                                                                //     backgroundColor: '#333',
                                                                                //     width: '100%',
                                                                                //     align: 'right',
                                                                                //     height: 22,
                                                                                //     borderRadius: [4, 4, 0, 0]
                                                                                // },
                                                                                hr: {
                                                                                    borderColor: '#708090 ',
                                                                                    width: '100%',
                                                                                    borderWidth: 0.5,
                                                                                    height: 0
                                                                                },
                                                                                b: {
                                                                                    fontSize: 16,
                                                                                    lineHeight: 33
                                                                                },
                                                                                per: {
                                                                                    color: '#eee',
                                                                                    backgroundColor: '#334455',
                                                                                    padding: [2, 4],
                                                                                    borderRadius: 2
                                                                                }
                                                                            }
                                                                        },
                                                                        emphasis: {
                                                                            show: true,
                                                                            textStyle: {
                                                                                fontSize: '30',
                                                                                fontWeight: 'bold'
                                                                            }
                                                                        }
                                                                    },
                                                                    data:data[1]

                                                                    //     [
                                                                    //     {value: 3528.5705, name: '马化腾'},
                                                                    //     {value: 1485.7115, name: '张志东'},
                                                                    //     {value: 742.859, name: '许晨晔'},
                                                                    //     {value: 742.859, name: '陈一丹'}
                                                                    // ]
                                                                }
                                                            ]
                                                        };
                                                        // 使用刚指定的配置项和数据显示图表。
                                                        myChart1.setOption(option);
                                                    }
                                                },
                                                error : function(errorMsg) { //没做出错处理
                                                    //请求失败时执行该函数
                                                    // alert("Servlet5股份占比图失败!");
                                                    // myChart2.hideLoading();/**/
                                                }
                                            })

                                        </script>


                                    </div>
                                </div>
                            </div>
                        </div>

                    </div><!--button-->
                </div><!--box_td-->
            </td>
            </tr>
            </tbody>
            </table>
            <%--点击关联图谱出现的公司信息--%>
            <script>
                function Go(){
                    $("#test").click();
                }
            </script>
            <input type="button" id="test" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg2">
            <div class="modal fade bd-example-modal-lg2" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content" id="box-t">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">公司信息</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="name">
                                <h6><a href="#" id="aaaa">--</a></h6>
                                <p>法定代表人：<span id="aaaa1"></span></p>
                                <p>注册资本：<span id="aaaa4"></span></p>
                                <p>注册号：<span id="aaaa2"></span></p>
                                <p>地址：<span id="aaaa3"></span></p>
                                <%--<a href="#" class="btn btn-primary btn-lg active" id="bbt" role="button" aria-pressed="true">查看图谱</a>--%>
                                <div class="information">
                                    <nav>
                                        <div class="nav nav-tabs" id="nav-tab" role="tablist">
                                            <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">股东</a>
                                            <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">对外投资</a>
                                            <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">主要成员</a>
                                        </div>
                                    </nav>
                                    <div class="tab-content" id="nav-tabContent">
                                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                                            <table  class="ntable">
                                                <tbody>
                                                <tr>
                                                    <td class="tb" width="200px">名称</td>
                                                    <td width="100px" class="tb">类型</td>
                                                </tr>
                                                <tr>
                                                    <td id="G0">--</td>
                                                    <td id="G00">--</td>
                                                </tr>
                                                <tr>
                                                    <td id="G1">--</td>
                                                    <td id="G11">--</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                                            <table  class="ntable">
                                                <tbody>
                                                <tr>
                                                    <td class="tb" width="300px">名称</td>
                                                </tr>
                                                <tr>
                                                    <td id="DW0">--</td>
                                                </tr>
                                                <tr>
                                                    <td id="DW1">--</td>
                                                </tr>
                                                <tr>
                                                    <td id="DW2">--</td>
                                                </tr>
                                                <tr>
                                                    <td id="DW3">--</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                                            <table height="300px" class="ntable">
                                                <tbody>
                                                <tr>
                                                    <td class="tb" width="100px">名称</td>
                                                    <td width="200px" class="tb">类型</td>
                                                </tr>
                                                <tr>
                                                    <td id="GG1">--</td>
                                                    <td id="GG11">--</td>
                                                </tr>
                                                <tr>
                                                    <td id="GG2">--</td>
                                                    <td id="GG22">--</td>
                                                </tr>
                                                <tr>
                                                    <td id="GG3">--</td>
                                                    <td id="GG33">--</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table height="800px" class="ntable" style="text-align:left;" >
                <tbody>
                <tr>
                    <td width="20%" class="tb">注册资本：</td>
                    <td width="30%" class="ZB">--</td>
                    <td width="20%" class="tb">实缴资本：</td>
                    <td width="30%" class="ZB">--</td>
                </tr>
                <tr>
                    <td width="20%" class="tb">营业状态：</td>
                    <td width="30%" class="DJZT">--</td>
                    <td width="20%" >成立日期：</td>
                    <td width="30%" class="RQ">--</td>
                </tr>
                <tr>
                    <td width="20%" class="tb">统一社会信用代码:</td>
                    <td width="30%" class="reg_no">--</td>
                    <td width="20%" class="">纳税人识别号：</td>
                    <td width="30%" >--</td>
                </tr>
                <tr>
                    <td width="20%" >注册号：</td>
                    <td width="30%" class="reg_no">--</td>
                    <td width="20%" class="tb">组织机构代码：</td>
                    <td width="30%" >--</td>
                </tr>
                <tr>
                    <td width="20%" >公司类型：</td>
                    <td width="30%" class="LX">--</td>
                    <td width="20%" >所属行业：</td>
                    <td width="30%" class="FW1">--</td>
                </tr>
                <tr>
                    <td width="20%" >核准日期：</td>
                    <td width="30%" class="HZRQ">--</td>
                    <td width="20%" >登记机关：</td>
                    <td width="30%" class="DJJG">--</td>
                </tr>

                <tr>
                    <td width="20%" class="tb">所属地区：</td>
                    <td width="30%"  class="PRO">--</td>
                    <td width="20%" >英文名：</td>
                    <td width="30%" class="English">--</td>
                </tr>

                <tr>
                    <td width="20%" class="tb">曾用名：</td>
                    <td width="30%" >--</td>
                    <td width="20%" class="tb">经营方式：</td>
                    <td width="30%" >--</td>
                </tr>
                <tr>
                    <td width="20%" class="tb">人员规模：</td>
                    <td width="30%" >企业选择不公示</td>
                    <td width="20%" class="tb">企业邮箱</td>
                    <td width="30%"  class="YX">--</td>
                </tr>
                <tr>
                    <td width="20%" class="tb">企业地址：</td>
                    <td width="80%" class colspan="3" class="Addr"> <%=Addr%></td>
                    <td width="80%" class colspan="3" >
                        <a href="map.jsp?Addr=<%=Addr%>">查看地图</a>
                    </td>
                </tr>
                <tr>
                    <td width="20%" class="tb">经营范围：</td>
                    <td width="80%" class colspan="3" class="FWD" id="FWD">电梯、自动扶梯配套件、模具制造、加工、销售;低压成套开关设备、电动机、新型传感器制造、销售;燃气轮机及成套控制装置、变速箱、机械配件生产、销售;电梯、自动扶梯整机销售;经营各类商品的进出口业务(国家限定企业经营或禁止进出口的商品除外);道路普通货运服务(按许可证核定的范围和期限经营)。(依法须经批准的项目,经相关部门批准后方可开展经营活动)</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab"><table height="300px" class="ntable">
            <tbody>
            <tr>
                <td class="tb" width="50px;">序号</td>
                <td width="240px" class="tb">股东</td>
                <td width="100px" class="tb">持股比例</td>
                <td width="150px" class="tb">认缴出资额（万元）</td>
            </tr>
            <tr>
                <td>1</td>
                <td width="240px" class="GD0_name">- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td width="140px" class="GD0_BL">-</td>
                <td width="150px" class="GD0_ZB">-</td>
            </tr>
            <tr>
                <td>2</td>
                <td width="240px" class="GD1_name">- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td width="140px" class="GD1_BL">-</td>
                <td width="150px" class="GD1_ZB">-</td>
            </tr>
            <tr>
                <td>3</td>
                <td width="240px" class="GD2_name">- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td width="140px" class="GD2_BL">-</td>
                <td width="150px" class="GD2_ZB">-</td>
            </tr>
            <tr>
                <td>4</td>
                <td width="240px" class="GD3_name">-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td width="140px" class="GD3_BL">-</td>
                <td width="150px" class="GD3_ZB">-</td>
            </tr>
            <tr>
                <td>5</td>
                <td width="240px" class="GD4_name">-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td width="140px" class="GD4_BL">-</td>
                <td width="150px" class="GD4_ZB">-</td>
            </tr>
            </tbody>
        </table></div>
        <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab"><table height="300px" class="ntable">
            <tbody>
            <tr>
                <td class="tb" width="220px">被投资企业名称</td>
                <td width="240px" class="tb">被投资法定代表人</td>
                <td width="100px" class="tb">成立日期</td>
                <td class="tb">状态</td>
            </tr>
            <tr>
                <td class="DWTZ0_name">-</td>
                <td class="DWTZ0_FD">-</td>
                <td class="DWTZ0_RQ">-</td>
                <td class="DWTZ0_DJZT">-</td>
            </tr>
            <tr>
                <td class="DWTZ1_name">-</td>
                <td class="DWTZ1_FD">-</td>
                <%--<td >2000万人民币</td>--%>
                <%--<td >90.00%</td>--%>
                <td class="DWTZ1_RQ">-</td>
                <td class="DWTZ1_DJZT">-</td>
            </tr>
            <tr>
                <td class="DWTZ2_name">-</td>
                <td class="DWTZ2_FD">-</td>
                <%--<td >741.505315万</td>--%>
                <%--<td >20.23%</td>--%>
                <td class="DWTZ2_RQ">-</td>
                <td class="DWTZ2_DJZT">-</td>
            </tr>
            <tr>
                <td class="DWTZ3_name">-</td>
                <td class="DWTZ3_FD">-</td>
                <%--<td >500万元</td>--%>
                <%--<td >100%</td>--%>
                <td class="DWTZ3_RQ">-</td>
                <td class="DWTZ3_DJZT">-</td>
            </tr>
            <tr>
                <td class="DWTZ4_name">-</td>
                <td class="DWTZ4_FD">-</td>
                <%--<td >1000万元</td>--%>
                <%--<td >100%</td>--%>
                <td class="DWTZ4_RQ">-</td>
                <td class="DWTZ4_DJZT">-</td>
            </tr>
            <tr>
                <td class="DWTZ5_name">-</td>
                <td class="DWTZ5_FD">-</td>
                <%--<td >1000万元</td>--%>
                <%--<td >100%</td>--%>
                <td class="DWTZ5_RQ">-</td>
                <td class="DWTZ5_DJZT">-</td>
            </tr>
            <tr>
                <td class="DWTZ6_name">-</td>
                <td class="DWTZ6_FD">-</td>
                <%--<td >1000万元</td>--%>
                <%--<td >100%</td>--%>
                <td class="DWTZ6_RQ">-</td>
                <td class="DWTZ6_DJZT">-</td>
            </tr>
            <tr>
                <td class="DWTZ7_name">-</td>
                <td class="DWTZ7_FD">-</td>
                <%--<td >1000万元</td>--%>
                <%--<td >100%</td>--%>
                <td class="DWTZ7_RQ">-</td>
                <td class="DWTZ7_DJZT">-</td>
            </tr>
            <tr>
                <td class="DWTZ8_name">-</td>
                <td class="DWTZ8_FD">-</td>
                <%--<td >10008元</td>--%>
                <%--<td >100%</td>--%>
                <td class="DWTZ8_RQ">-</td>
                <td class="DWTZ8_DJZT">-</td>
            </tr>
            <tr>
                <td class="DWTZ9_name">-</td>
                <td class="DWTZ9_FD">-</td>
                <%--<td >1000万元</td>--%>
                <%--<td >100%</td>--%>
                <td class="DWTZ9_RQ">-</td>
                <td class="DWTZ9_DJZT">-</td>
            </tr>
            </tbody>
        </table>

            <div class="info_head">
                <h4>对外投资分布图</h4>
                <div id="main" style="width: 700px;height:400px;"></div>
            </div>
        </div>

        <script type="text/javascript">
            //数据纯属虚构
            var myChart = echarts.init(document.getElementById('main'));
            //数据纯属虚构
            $.ajax({
                type : "post",
                data:{
                    reg_no:"<%=reg_no%>",
                    com_name:"<%=com_name%>"
                },
                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "Servlet3",    //请求发送
                dataType : "json",        //返回数据形式为json
                success : function(data) {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (data) {

                        // alert(data);

                        var yData = [];

                        data.sort(function(o1, o2) {
                            if (isNaN(o1.value) || o1.value == null) return -1;
                            if (isNaN(o2.value) || o2.value == null) return 1;
                            return o1.value - o2.value;
                        });

                        for (var i = 0; i < data.length; i++) {
                            yData.push(data[i].name);
                        }

                        var option = {
                            title: {
                                text: '',
                                textStyle: {
                                    fontSize: 30
                                },
                                x: 'center'
                            },
                            tooltip: {
                                show: true,
                                formatter: function(params) {
                                    return params.name + '：' + params.data['value'] + '%'
                                },
                            },
                            visualMap: {
                                type: 'continuous',
                                text: ['', ''],
                                showLabel: true,
                                seriesIndex: [0],
                                min: 0,
                                max: 7,
                                inRange: {
                                    color: ['#edfbfb', '#b7d6f3', '#40a9ed', '#3598c1', '#215096', ]
                                },
                                textStyle: {
                                    color: '#000'
                                },
                                bottom: 30,
                                left: 'left',
                            },
                            grid: {
                                right: 10,
                                top: 80,
                                bottom: 30,
                                width: '20%'
                            },
                            xAxis: {
                                type: 'value',
                                scale: true,
                                position: 'top',
                                splitNumber: 1,
                                boundaryGap: false,
                                splitLine: {
                                    show: false
                                },
                                axisLine: {
                                    show: false
                                },
                                axisTick: {
                                    show: false
                                },
                                axisLabel: {
                                    margin: 2,
                                    textStyle: {
                                        color: '#aaa'
                                    }
                                }
                            },
                            yAxis: {
                                type: 'category',
                                nameGap: 16,
                                axisLine: {
                                    show: false,
                                    lineStyle: {
                                        color: '#ddd'
                                    }
                                },
                                axisTick: {
                                    show: false,
                                    lineStyle: {
                                        color: '#ddd'
                                    }
                                },
                                axisLabel: {
                                    interval: 0,
                                    textStyle: {
                                        color: '#999'
                                    }
                                },
                                data: yData
                            },
                            geo: {
                                roam: true,
                                map: 'china',
                                left: 'left',
                                right:'300',
                                layoutSize: '80%',
                                label: {
                                    emphasis: {
                                        show: false
                                    }
                                },
                                itemStyle: {
                                    emphasis: {
                                        areaColor: '#fff464'
                                    }
                                },
                                regions: [{
                                    name: '南海诸岛',
                                    value: 0,
                                    itemStyle: {
                                        normal: {
                                            opacity: 0,
                                            label: {
                                                show: false
                                            }
                                        }
                                    }
                                }],
                            },
                            series: [{
                                name: 'mapSer',
                                type: 'map',
                                roam: false,
                                geoIndex: 0,
                                label: {
                                    show: false,
                                },
                                data: data
                            }, {
                                name: 'barSer',
                                type: 'bar',
                                roam: false,
                                visualMap: false,
                                zlevel: 2,
                                barMaxWidth: 20,
                                itemStyle: {
                                    normal: {
                                        color: '#40a9ed'
                                    },
                                    emphasis: {
                                        color: "#3596c0"
                                    }
                                },
                                label: {
                                    normal: {
                                        show: false,
                                        position: 'right',
                                        offset: [0, 10]
                                    },
                                    emphasis: {
                                        show: true,
                                        position: 'right',
                                        offset: [10, 0]
                                    }
                                },
                                data: data
                            }]
                        };

                        myChart.setOption(option);
                        // myChart1.showLoading();
                    }
                },
                error : function(errorMsg) { //没做出错处理
                    //请求失败时执行该函数
                    // alert("Servlet3对外投资分布图失败!");
                    myChart2.hideLoading();
                }
            })

        </script>

        <div class="tab-pane fade" id="pills-member" role="tabpanel" aria-labelledby="pills-member-tab"><table height="300px" class="ntable">
            <tbody>
            <tr>
                <td class="tb" width="50px">序号</td>
                <td width="100px" class="tb">姓名</td>
                <td width="180px" class="tb">职务</td>
            </tr>
            <tr>
                <td >1</td>
                <td class="company2Pe1">--</td>
                <td class="company2Po1">--</td>
            </tr>
            <tr>
                <td>2</td>
                <td class="company2Pe2">--</td>
                <td class="company2Po2">--</td>
            </tr>
            <tr>
                <td>3</td>
                <td class="company2Pe3">--</td>
                <td class="company2Po3">--</td>
            </tr>
            <tr>
                <td>4</td>
                <td class="company2Pe4">--</td>
                <td class="company2Po4">--</td>
            </tr>
            <tr>
                <td>5</td>
                <td class="company2Pe5">--</td>
                <td class="company2Po5">--</td>
            </tr>
            <tr>
                <td>6</td>
                <td class="company2Pe6">--</td>
                <td class="company2Po6">--</td>
            </tr>
            <tr>
                <td>7</td>
                <td class="company2Pe7">--</td>
                <td class="company2Po7">--</td>
            </tr>
            <tr>
                <td>8</td>
                <td class="company2Pe8">--</td>
                <td class="company2Po8">--</td>
            </tr>
            </tbody>
        </table></div>

        <div class="tab-pane fade" id="pills-orgnize" role="tabpanel" aria-labelledby="pills-orgnize-tab"><table height="300px" class="ntable">
            <tbody>
            <tr>
                <td class="tb" width="20px">1</td>
                <td width="350px"><a href="" class="company2F1">--</a></td>
                <td width="20px" class="tb" >2</td>
                <td ><a href="" class="company2F2"> -</a></td>
            </tr>
            <tr>
                <td class="tb">3</td>
                <td ><a href="" class="company2F3">-</a></td>
                <td  class="tb">4</td>
                <td ><a href="" class="company2F4">-</a></td>
            </tr>
            <tr>
                <td class="tb">5</td>
                <td ><a href="" class="company2F5">-</a></td>
                <td  class="tb">6</td>
                <td ><a href="" class="company2F6">-</a></td>
            </tr>
            <tr>
                <td class="tb">7</td>
                <td ><a href="" class="company2F7">-</a></td>
                <td class="tb">8</td>
                <td ><a href="" class="company2F8">-</a></td>
            </tr>
            <tr>
                <td class="tb">9</td>
                <td ><a href="" class="company2F9">-</a></td>
                <td class="tb">10</td>
                <td ><a href="" class="company2F10">-</a></td>
            </tr>
            <tr>
                <td class="tb">11</td>
                <td ><a href="" class="company2F11">-</a></td>
                <td class="tb">12</td>
                <td ><a href="" class="company2F12">-</a></td>
            </tr>
            <tr>
                <td class="tb">13</td>
                <td ><a href="" class="company2F13">-</a></td>
                <td class="tb">14</td>
                <td ><a href="" class="company2F14">-</a></td>
            </tr>
            </tbody>
        </table></div>



        <div class="tab-pane fade" id="pills-introduce" role="tabpanel" aria-labelledby="pills-introduce-tab">
            <table height="300px" class="ntable">
                <tbody>
                <tr>
                    <%--<div id="JJ"><td style="text-align:left;line-height:30px;" id="JJ"></div>--%>
                    <td style="text-align:left;line-height:30px;" class="JJ">
                        ---------
                    </td>
                </tr>
                </tbody>
            </table>
        </div>


        <div class="tab-pane fade" id="pills-brand" role="tabpanel" aria-labelledby="pills-brand-tab">

            <div class="container1" >
                <%--<div class="box-name"><p>商标注册信息：</p></div>--%>
                <%--<div class="name-list">--%>
                    <ul>
                            <%
    Brand brand=new Brand();
        int  size=0;
    CompanyDaoImpl companyDao=new CompanyDaoImpl();
    ArrayList<Brand> list = companyDao.getAllB(reg_no);
    if (list.size()>8){
          size=8;
    }else {
        size=list.size();
    }
    if (list != null && list.size() >0) {
        for (int i = 0; i <= size-1; i++) {
                brand.setService(list.get(i).getService());
                brand.setReg_no(list.get(i).getReg_no());
                brand.setImg_url(list.get(i).getImg_url());
                brand.setDate(list.get(i).getDate());
                brand.setClass_no(list.get(i).getClass_no());
                brand.setBrand_no(list.get(i).getBrand_no());
                if (brand.getImg_url().contains("trademark.png")){
                    brand.setImg_url("/Brand/images/trade.png");
                }
%>
                        <li>
                            <div class="info1-box">
                                <div class="shb">
                                    <img src=<%=brand.getImg_url()%>>
                                </div>
                                <div class="info1">
                                    <div class="info1-list">
                                        <span class="infostyle1">商标注册号：</span>
                                        <span class="infostyle2"><%=brand.getBrand_no()%></span>
                                    </div>
                                    <div class="info1-list">
                                        <span class="infostyle1">类别：</span>
                                        <span class="infostyle2"><%=brand.getClass_no()%></span>
                                    </div>
                                    <div class="info1-list">
                                        <span class="infostyle1">日期：</span>
                                        <span class="infostyle2"><%=brand.getDate()%></span>
                                    </div>

                                    <%--<div class="info1-list">--%>
                                        <%--<span class="infostyle1">服务范围：</span>--%>
                                        <%--<span class="infostyle2" style=""><%=brand.getService()%></span>--%>
                                    <%--</div>--%>
                                    <div class="info1-a">
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal2<%=i%>" id="guanzhu">
                                            查看详情
                                        </button>
                                        <%--<a href=<%=brand.getImg_url()%>>查看详情>></a>--%>
                                    </div>
                                    <div class="modal fade" id="exampleModal2<%=i%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content" style="height:350px">
                                                <div class="modal-header" style="height:50px;">
                                                    <h5 class="modal-title" id="exampleModalLabel" >服务范围</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body" >
                                                    <%=brand.getService()%>
                                                </div>
                                                <%--<div class="modal-footer">--%>
                                                    <%--<button type="button" onclick="NOTE();" class="btn btn-secondary" data-dismiss="modal" style="width:70px;height:35px;">确定</button>--%>
                                                <%--</div>--%>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </li>


                                    <%
            }
        }

%>


                            <%--<table height="300px" class="ntable">--%>
                <%--<tbody>--%>
                <%--<tr>--%>
                    <%--&lt;%&ndash;<div id="JJ"><td style="text-align:left;line-height:30px;" id="JJ"></div>&ndash;%&gt;--%>
                    <%--<td style="text-align:left;line-height:30px;" class="JJ">--%>
                        <%-------------%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--</tbody>--%>
            <%--</table>--%>
        </div>

    <%--</div>--%>
</div><!--info-->
</div><!--container-->

<script>
    //自适应
    $(window).load(function(){
        var winWidth=$(window).innerWidth();
        var winHeight=$(window).innerHeight();
        $(".fanhui").css("margin-right",(30/1536)*winWidth);
        $(".headinfo").css("width",(950/1536)*winWidth)
        $(".container").css("width",(1000/1536)*winWidth)


    })
</script>

</body>
</html>