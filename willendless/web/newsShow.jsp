<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/24
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/fore/foreHeader.jsp"%>
<link rel="stylesheet" href="css/fore/news.css">
</head>
<%@ include file="include/fore/foreNavigator.jsp"%>
<title>${news.title}</title>
<!-- tab标签开始 -->
<div id="wrapper" style="margin-top: 20px">


    <div class="sub-content" style="margin: 20px 0; font-size: small">
        <div class="position-bar">
            当前位置：<a href="forenews">场地通知</a>&nbsp;>&nbsp;${news.title}
        </div>

        <div style="text-indent: 2em; margin: 40px">
            <p style="text-align: center">
                <strong>
                    <span style="font-size: 24px;">${news.title}</span>
                </strong>
            </p>
            <p><br/></p>
            <p><span style="font-size: 20px">各位老师、同学：<br/></span></p>
            <p><span style="font-size: 20px">&nbsp;&nbsp;&nbsp;&nbsp;${news.content}</span></p>
            <p><br/></p>
            <p><br/></p>
            <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;${news.TIME}</p>
        </div>

    </div>

    <!-- tab标签结束 -->

</div>



</div>
<%@include file="include/fore/foreFooter.jsp"%>


