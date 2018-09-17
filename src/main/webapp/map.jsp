<%--
  Created by IntelliJ IDEA.
  User: jojoba
  Date: 2018/6/10
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <%
        String Addr = request.getParameter("Addr");
        System.out.println(Addr);
    %>
    <title>百度地图</title>
    <!-- css样式文件 -->
    <style type="text/css">
        body,
        html {
            width: 100%;
            height: 100%;
            margin: 0;
            font-family: "微软雅黑";
            overflow: hidden;
        }

        #allmap {
            height: 100%;
            width: 100%;
            overflow: hidden;
        }

        #r-result {
            width: 100%;
            font-size: 14px;
            position: absolute;
            top: 10px;
            left: 200px
        }
    </style>

</head>

<body onload="theLocation()">
<%--<script>--%>
    <%--$(document).ready(theLocation(){--%>

        <%--var param = window.location.search;//获取当前页面URL信息--%>
        <%--var city = <%=Addr%>;--%>
        <%--if (city!= "") {--%>
            <%--local.search(city);--%>
        <%--}--%>

    <%--});--%>

<%--</script>--%>
<!-- 地图盒子 -->
<div id="allmap"></div>
<!-- 搜索显示框 -->
<div id="r-result">
  <input id="cityName" type="hidden" style="width:100px; margin-right:10px;" value="<%=Addr%> "/>
    <%--<input type="button" value="搜索" onClick="theLocation()" /> --%>
    <input type="hidden" id="lng" />
    <input type="hidden" id="lat" />
    <%--<button onClick="submit()">提交</button>--%>
</div>
<!-- js文件 -->
<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.3&services=true"></script>
<!-- 页面地图js方法 -->
<script type="text/javascript">
    // 在指定容器创建地图实例并设置最大最小缩放级别
    var map = new BMap.Map("allmap", {
        minZoom: 5,
        maxZoom: 19
    });

    // 初始化地图，设置中心点和显示级别
    // map.centerAndZoom(new BMap.Point(121.36564, 31.22611), 19);

    // 开启鼠标滚轮缩放功能，仅对PC上有效
    map.enableScrollWheelZoom(true);

    // 将控件（平移缩放控件）添加到地图上
    map.addControl(new BMap.NavigationControl());

    // 为地图增加点击事件，为input赋值
    map.addEventListener("click", function(e) {
        document.getElementById('lat').value = e.point.lat;
        document.getElementById('lng').value = e.point.lng;

    });

    // 创建位置检索、周边检索和范围检索
    var local = new BMap.LocalSearch(map, {
        renderOptions: {
            map: map
        }
    });

    // 发起检索
    function theLocation() {

        var city = document.getElementById('cityName').value;
       <%--var city=<%=Addr%>--%>
        if (city!= "") {
            local.search(city);
        }
    };

    // 弹出经纬度
    function submit() {
        var lat = document.getElementById('lat');
        var lng = document.getElementById('lng');
        alert("经度：" + lng.value + "\n" + "纬度：" + lat.value);
    };
</script>
</body>

</html>