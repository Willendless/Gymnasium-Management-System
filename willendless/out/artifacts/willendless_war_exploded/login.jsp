<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/21
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/fore/foreHeader.jsp"%>
<link rel="stylesheet" href="css/fore/login.css">
</head>
<%@ include file="include/fore/foreNavigator.jsp"%>
<title>登陆</title>
<script>
    $(function(){
        <c:if test="${!empty msg}">
            $("span.errorMessage").html("${msg}");
            $("span.errorMessage").css("visibility", "visible");
        </c:if>


        $("form.loginForm").submit(function () {
            if ($("#name").val().length == 0 ||
                $("#password").val().length == 0) {
                $("span.errorMessage").css("visibility", "visible");
                $("span.errorMessage").html("*请输入账号密码");
                return false;
            }
        })

        $("form.loginForm input").keyup()(function(){
            $("span.errorMessage").css("visibility", "visible");
        })
    })
</script>

    

    <!-- 登陆框开始 -->

        <div class="content">
            <div class="login_wrapper" style="background-image:url('image/fore/main.jpg'); background-repeat: no-repeat; margin-top: 10px">
                <div class="glass"></div>
                <div class="login_content">
                    <h5 class="login-text">登陆账号</h5>
                    <div class="loginErrorMessageDiv">
                        <div >
                            <span class="errorMessage" style="color: red; visibility: hidden"></span>
                        </div>
                    </div>
                    <form class="loginForm" method="post" action="forelogin">

                        <div class="login-item">
                            <input type="text" id="name" name="name" placeholder="请输入用户名">
                        </div>
                        <div class="login-item">
                            <input type="password" id="password" name="password" placeholder="请输入密码">
                        </div>
                        <div>
                            <button type="submit" class="login-button">登陆</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="include/fore/foreFooter.jsp"%>
