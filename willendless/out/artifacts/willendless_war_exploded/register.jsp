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
<link rel="stylesheet" href="css/fore/register.css">
</head>
<%@ include file="include/fore/foreNavigator.jsp"%>
<title>注册</title>
<script src="js/fore/register.js"></script>
<script>
    $(function () {
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.registerErrorMessageDiv").css("visibility","visible");
        </c:if>
    })
</script>




        <div class="content">
            <div class="login_wrapper" style="background-image:url('image/fore/main.jpg'); background-repeat: no-repeat; margin-top: 10px">
                <div class="glass" style="height: 470px"></div>
                <div class="login_content">
                    <form role="form" method="post" action="foreregister" class="registerForm">
                        <h5 class="login-text">注册账号</h5>

                        <div class="registerErrorMessageDiv" style="margin: 3px">
                            <div class="alert" role="alert">
                                <span class="errorMessage" style="color: red"></span>
                            </div>
                        </div>

                        <div style="margin-top: 17px;">
                            <div class="login-item form-group">
                                E-mail:
                                <input type="email" class="form-control" name="email" placeholder="邮箱名" required>
                            </div>
                            <div class="login-item form-group">
                                用户名:
                                <input type="text" class="form-control" name="name" placeholder="请输入6-16位字符" required  title="帐号应为6-16位">
                            </div>
                            <div class="login-item form-group">
                                密码:
                                <input type="password" class="form-control" name="password" placeholder="请输入密码" required id="pwd1">
                            </div>
                            <div class="login-item form-group">
                                确认密码:
                                <input type="password" class="form-control" placeholder="请确认密码" required id="pwd2" onkeyup="validate()">
                                <span id="tishi"></span>
                            </div>
                            <div class="login-item form-group d-flex justify-content-around">
                                <div class="btn-group">
                                    <button type="submit" class="btn btn-primary" id="submit">&nbsp;&nbsp;注册&nbsp;&nbsp;</button>
                                </div>
                                <div class="btn-group">
                                    <button type="reset" class="btn btn-primary" onclick="resetpwd()">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<%@ include file="include/fore/foreFooter.jsp"%>