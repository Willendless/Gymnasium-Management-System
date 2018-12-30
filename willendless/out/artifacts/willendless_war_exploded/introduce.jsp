<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/24
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/fore/foreHeader.jsp"%>
<link rel="stylesheet" href="css/fore/introduce.css">
</head>
<%@ include file="include/fore/foreNavigator.jsp"%>
<title>场馆介绍</title>

        <!-- tab标签开始 -->
        <div id="wrapper" style="margin-top: 20px">


                <div class="sub-nav" id="sub-nav">
                    <dl style="background-color: #fff;">
                        <dt>全部场馆</dt>
                        <c:forEach items="${placeList}" var="p">
                            <dd style="background-color: #fff; border-bottom: 1px solid #ddd">
                                <a onclick="changeBack(this)" id="${p.name}" style="background-color: #fff;">${p.name}</a>
                            </dd>
                        </c:forEach>
                    </dl>
                    <div class="img-box" >
                        <img src="image/fore/sub-img.jpg" width="178" height="300" />
                    </div>
                </div>

                <div class="sub-content-con">
                    <div class="position-bar">
                        当前位置：场地预约
                    </div>
                    <c:forEach items="${placeList}" var="p">
                    <div class="list-content">
                        <div style="width: 100%; height: 230px; display: none; background-color: #fff;" id="${p.name}place">
                            <div class="img-box" style="background-color: #fff;padding-left: 10px;padding-top: 15px;display: inline; float: left;">
                                <img src="image/place/${p.id}.jpg" width="300" height="200"/>
                            </div>
                            <div style="width: 450px;padding-top:13px;float: right;background-color: #fff;">
                                <p style="background-color: #fff;">场馆名称：&nbsp;${p.name}</p>
                                <p style="background-color: #fff;">场馆英文名：&nbsp;${p.ename}</p>
                                <p style="background-color: #fff;">场馆地点: &nbsp;${p.location}</p>
                                <p style="background-color: #fff;">场馆介绍：&nbsp;${p.introduction}</p>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>

            <!-- tab标签结束 -->

        </div>

    </div>
    </div>
<script>
    var k = document.getElementById("${placeList[0].name}");
    k.style.backgroundColor = "#007bff";
    k.style.color = "white";
    document.getElementById(k.id.toString()+"place").style.display = "";
    function changeBack(id) {
        var tmp = document.getElementById("sub-nav").getElementsByTagName("a");
        for (var i = 0; i < tmp.length; i++) {
            tmp[i].style.color = "";
            tmp[i].style.backgroundColor = "";
            document.getElementById(tmp[i].id.toString()+"place").style.display = "none";
        }
        id.style.display = "";
        id.style.color = "white";
        id.style.backgroundColor = "#007bff";
        document.getElementById(id.id.toString()+"place").style.display = "";
    }
</script>

<%@include file="include/fore/foreFooter.jsp"%>

