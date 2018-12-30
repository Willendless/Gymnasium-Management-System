<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/21
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<body>
<!-- header开始 -->
<div class="header-area" style="background-color: #f0f0f0; height: 55px">
    <div class="container h-100">
        <div class="h-100 d-flex justify-content-between align-items-center">
            <div class="p-2">
                <a href="forehome"><img src="./image/fore/logo.jpg" width="275"></a>
            </div>

            <c:if test="${empty user}">
                <div class="p-2">
                    <a href="register.jsp" style="color: #666; text-decoration: none; font-size: 14px;font-weight: 400">注册</a>
                    <span>|</span>
                    <a href ="login.jsp" style="color: #666; text-decoration: none;font-size: 14px;font-weight: 400">登录</a>
                </div>
            </c:if>
            <c:if test="${!empty user}">
                <div class="p-2">
                    <a href="foreuser" style="color: #666; text-decoration: none;font-size: 14px;font-weight: 400">个人中心</a>
                    <span>|</span>
                    <a href="forelogout" style="color: #666; text-decoration: none;font-size: 14px;font-weight: 400">退出</a>
                </div>
            </c:if>

        </div>
    </div>
</div>

<div style="background-color: #f0f0f0; min-height: 670px">
    <div class="container">
        <div id="nav-main">
            <ul class="nav-inner-box">
                <li><a id="home.jsp" href="forehome" style="font-weight: 400">首页</a></li>
                <li><a id="introduce.jsp" href="foreintroduce" style="font-weight: 400">场馆介绍</a></li>
                <li><a id="book.jsp" href="forebook" style="font-weight: 400">场地预约</a></li>
                <li><a id="news.jsp" href="forenews" style="font-weight: 400">场馆通知</a></li>
            </ul>
        </div>

<script>
    var where = window.location.pathname;

    <c:if test="${empty where}">
        document.getElementById("home.jsp").style.background = "gray no-repeat center bottom";
        document.getElementById("home.jsp").style.color = "#fff";
    </c:if>
    <c:if test="${not empty where}">
        document.getElementById("${where}").style.background = "gray no-repeat center bottom";
        document.getElementById("${where}").style.color = "#fff";
    </c:if>

</script>