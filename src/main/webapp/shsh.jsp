<%--
  Created by IntelliJ IDEA.
  User: jojoba
  Date: 2018/7/22
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工商信息</title>
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="TC/css/style.css" type="text/css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function() {
          $("#test").hide();
         return Go();
    })
</script>

<input type="button" value="Click" id="C" onclick="Go();">
<input type="button" value="Wait" id="W" onclick="javascript:alert('Amazing!');">

<script>
    function Go(){
        $("#test").click();
    }
</script>

<input type="button" id="test" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">

<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
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
                    <h6><a href="#">深圳腾讯计算机有限公司</a></h6>
                    <p>法定代表人：<a href="#">--</a></p>
                    <p>注册资本：--</p>
                    <p>成立日期：--</p>
                    <a href="#" class="btn btn-primary btn-lg active" id="bbt" role="button" aria-pressed="true">查看图谱</a>
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
                                        <td>深圳市腾讯计算机系统有限公司</td>
                                        <td >企业法人</td>
                                    </tr>
                                    <tr>
                                        <td>深圳市世纪凯旋科技有限公司）</td>
                                        <td >企业法人</td>
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
                                        <td>霍尔果斯腾影影视发行有限公司</td>
                                    </tr>
                                    <tr>
                                        <td>霍尔果斯晓腾影业文化传播有限公司</td>
                                    </tr>
                                    <tr>
                                        <td>苍穹互娱(天津)文化传播有限公司</td>
                                    </tr>
                                    <tr>
                                        <td>上海腾讯影业文化传播有限公司深圳分公司</td>
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
                                        <td>程武</td>
                                        <td >执行董事</td>
                                    </tr>
                                    <tr>
                                        <td>周颂</td>
                                        <td >监事</td>
                                    </tr>
                                    <tr>
                                        <td>程武</td>
                                        <td >总经理</td>
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
</body>
</html>