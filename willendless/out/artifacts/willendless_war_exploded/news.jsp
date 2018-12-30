<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/24
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/fore/foreHeader.jsp"%>
<link rel="stylesheet" href="css/fore/news.css">
<style>
.sub-ul {
    margin: 20px;
}
.sub-ul li {
    line-height: 29px;
    border-bottom: 1px dashed #ddd;
    padding: 0 5px 0 20px;
}
.sub-ul a{
    width: 370px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    text-decoration: none;
    cursor: pointer;
    color: #666;
}
</style>
</head>
<%@ include file="include/fore/foreNavigator.jsp"%>
<title>场馆通知</title>
<!-- tab标签开始 -->
<div id="wrapper" style="margin-top: 20px">


    <div class="sub-content" style="margin: 20px 0; font-size: small">
        <div class="position-bar">
            当前位置：场地通知
        </div>
        <div class="sub-ul">
            <ul style="font-size: 13px;line-height: 30px">
                <c:forEach items="${newsList}" var="n">
                    <li>
                        <span style="color: #00AAEE">>>&nbsp;&nbsp;<a href="forenewsShow?nid=${n.id}">${n.title}</a></span>
                        <span style="float: right;">${n.TIMEX}</span>
                    </li>
                </c:forEach>
            </ul>
        </div>

    </div>

    <!-- tab标签结束 -->

</div>



    </div>
</div>
    <%@include file="include/fore/foreFooter.jsp"%>


