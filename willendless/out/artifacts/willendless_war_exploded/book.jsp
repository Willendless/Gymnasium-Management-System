<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/22
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/fore/foreHeader.jsp"%>
<style>
    .wz_banner form td{
        width: 70px;
    }
    .wz_banner form th{
        width: 100px;
    }
    .wz_banner a {
        cursor: pointer;
        text-decoration: underline;
        color: black;
    }
    .wz_banner form td,th {
        text-align: center;
        padding: 0 0 0 0;
        border-color: black;
        border-style: solid;
        border-width: 2px;
    }
</style>
<script>

    $(function () {
        //核对是否登陆
        $(".空闲").click(function(){

            $.ajaxSettings.async = false;
            var page = "forecheckLogin";
            var flag = 1;
            $.get(
                page,
                function(result){
                    if("success"==result) {
                        flag = 0;
                    } else {
                        $("#loginModal").modal('show');
                    }
                }
            );
            if (flag == 1) {
                this.style.backgroundColor = "white";
                document.getElementById("total").innerText = "0";
            }

            return true;
        });
        //模态登陆核对账号密码
        $("button.loginSubmitButton").click(function(){
            var name = $("#name").val();
            var password = $("#password").val();
            if(0==name.length||0==password.length){
                $("span.errorMessage").html("*请输入账号密码");
                $("div.loginErrorMessageDiv").show();
                return false;
            }
            var page = "foreloginAjax";
            $.get(
                page,
                {"name":name,"password":password},
                function(result){
                    if("success"==result){
                        location.reload();
                    }
                    else{
                        $("span.errorMessage").html("*账号密码错误");
                        $("div.loginErrorMessageDiv").show();
                    }
                }
            );
            return true;
        });
    })

</script>
</head>
<%@ include file="include/fore/foreNavigator.jsp"%>
<title>场馆预约</title>


        <div class="sub-content" style="margin: 20px 0; font-size: small">
            <div class="position-bar">
                当前位置：场地预约
            </div>



            <div class="wz_banner" style="margin-top: 20px">
                <table style="margin-top:20px; border: none">
                    <tbody>
                        <tr>
                            <th style="border: none; width: 75px">场馆选择</th>
                            <c:forEach items="${placeList}" var="p">
                                <td>
                                    <a id="${p.name}" href="forebook?pid=${p.id}">${p.name}</a>&nbsp;&nbsp;
                                </td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <th style="border: none; width: 75px">场地选择</th>
                            <c:forEach items="${place.placeStadium}" var="ps">
                                <td>
                                    <a id="${ps.name}" href="forebook?psid=${ps.id}">${ps.name}</a>&nbsp;&nbsp;
                                </td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <th style="border: none; width: 75px">日期选择</th>
                            <c:forEach items="${dates}" var="d" varStatus="status">
                                <td>
                                    <a id="${status.index}" onclick="changeTable(this)" style="text-decoration: underline">${d}</a>&nbsp;&nbsp;
                                </td>

                            </c:forEach>
                        </tr>
                    </tbody>
                </table>



                <script>
                    document.getElementById("${place.name}").style.backgroundColor="#49afcd";
                    document.getElementById("${place.name}").style.color="white";
                    document.getElementById("${placeStadium.name}").style.backgroundColor="#49afcd";
                    document.getElementById("${placeStadium.name}").style.color="white";
                    document.getElementById("0").style.backgroundColor="#49afcd";
                    document.getElementById("0").style.color="white";

                    function changeTable(x) {
                        //表格初始化
                        document.getElementById("list0").style.display = "none";
                        document.getElementById("list1").style.display = "none";
                        document.getElementById("list2").style.display = "none";
                        //日期初始化
                        document.getElementById("0").style.color = "";
                        document.getElementById("0").style.backgroundColor = "";
                        document.getElementById("1").style.color = "";
                        document.getElementById("1").style.backgroundColor = "";
                        document.getElementById("2").style.color = "";
                        document.getElementById("2").style.backgroundColor = "";
                        //显示项修改
                        var index = x.id;
                        document.getElementById(index).style.backgroundColor="#49afcd";
                        document.getElementById(index).style.color = "white";
                        document.getElementById("list"+index).style.display = "";
                    }

                    function submitCheck() {
                        var total = Number(document.getElementById('total').innerText);
                        console.log(total);
                        if (total == 0) {
                            window.alert("请选择预约项！");
                            return false;
                        }
                        return true;
                    }

                </script>

                <div style="height: 3px;background-color: #3C3C3C; margin: 10px 0"></div>

                <div style="float: right;">总费用：<span id="total">0</span>&nbsp;元</div>

                <div style="margin: 20px 0;">
                    注：<span style="border:thin solid black; background:yellow">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;为已被占用场地&nbsp;&nbsp;
                    <span style="border:thin solid black; background:gray">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;为维护中场地&nbsp;&nbsp;
                    <span style="border:thin solid black; background:white">&nbsp;&nbsp;&nbsp;&nbsp;</span>&nbsp;为可预约场地
                </div>

                <div>
                    <form id="bookForm" onsubmit="return submitCheck()" action="forebookSubmit" method="post">
                        <table style="border-style: solid; border-bottom:none; border-width: 3px; border-collapse: collapse">
                            <tbody>
                            <tr style="text-align: center;">
                                <th >&nbsp;&nbsp;&nbsp;</th>
                                <td>08:00<br>-<br>09:00</td>
                                <td>09:00<br>-<br>10.00</td>
                                <td>10:00<br>-<br>11:00</td>
                                <td>11:00<br>-<br>12:00</td>
                                <td>12:00<br>-<br>13:00</td>
                                <td>13:00<br>-<br>14:00</td>
                                <td>14:00<br>-<br>15:00</td>
                                <td>15:00<br>-<br>16:00</td>
                                <td>16:00<br>-<br>17:00</td>
                                <td>17:00<br>-<br>18:00</td>
                                <td>18:00<br>-<br>19:00</td>
                                <td>19:00<br>-<br>20:00</td>
                                <td>20:00<br>-<br>21:00</td>
                            </tr>
                            </tbody>
                        </table>

                        <c:forEach items="${lists}" var="list" varStatus="status">
                            <table id="list${status.index}" style="display: none; border-style: solid; border-top: none; border-width: 3px; border-collapse: collapse">

                            <c:forEach items="${list}" var="plan">
                                <tr style="text-align: center; height: 40px">
                                    <th style="text-align: center;"><%=String.valueOf(request.getAttribute("name")).substring(0,1)%>${plan.index+1}</th>
                                <c:forEach items="${plan.stadiumPlanItemList}" var="item">
                                    <td class="${item.status}" onclick="clickTr(this)">
                                        <input type="hidden" id="${item.id}" value="${item.id}" name="">
                                    </td>
                                </c:forEach>
                                </tr>
                            </c:forEach>
                            </table>
                        </c:forEach>

                        <script>
                            //当天日期显示初始化
                            document.getElementById("list0").style.display = "";

                            //“占用”项初始化
                            var tmp1 = document.getElementsByClassName("占用");
                            for (var i = 0; i < tmp1.length; i++)
                                tmp1[i].style.backgroundColor = 'yellow';
                            //“维护”项初始化
                            var tmp2 = document.getElementsByClassName("维护");
                            for (var i = 0; i < tmp2.length; i++)
                                tmp2[i].style.backgroundColor = 'gray';
                            //“空闲”项初始化
                            var tmp3 = document.getElementsByClassName("空闲");
                            for (var i = 0; i < tmp3.length; i++) {
                                tmp3[i].style.backgroundColor = 'white';
                                tmp3[i].style.cursor = "pointer";
                            }
                            //"未付款"项初始化
                            var tmp4 = document.getElementsByClassName("未付款");
                            for (var i = 0; i < tmp4.length; i++) {
                                tmp4[i].style.backgroundColor = 'yellow';
                                tmp4[i].innerText = '未付款';
                                tmp4[i].style.color = 'red';
                            }
                            //“审核中”项初始化
                            var tmp5 = document.getElementsByClassName("审核中");
                            for (var i = 0; i < tmp5.length; i++) {
                                tmp5[i].style.backgroundColor = 'yellow';
                                tmp5[i].innerText = '审核中';
                                tmp5[i].style.color = 'red';
                            }

                            function clickTr(id) {
                                if (id.className == '空闲') {
                                    var s = id.style.backgroundColor;
                                    var total = Number(document.getElementById("total").innerText);

                                    if (s.toString() == 'white') {
                                        id.style.backgroundColor = '#7FFF00';
                                        total += ${placeStadium.fare};

                                        var input = id.getElementsByTagName("input");
                                        input[0].name = input[0].value;
                                    } else {
                                        id.style.backgroundColor = 'white';
                                        total -= ${placeStadium.fare};

                                        var input = id.getElementsByTagName("input");
                                        input[0].name = "";
                                    }

                                    document.getElementById("total").innerHTML = total.toString();
                                    document.getElementById("bookForm").action = "forebookSubmit?pid=${place.id}&psid=${placeStadium.id}&fare="+total;
                                }

                            }

                        </script>


                        <div class="submitTR text-center" style="margin: 15px">
                            <td colspan="2" align="center">
                                <button type="submit" class="btn btn-success">提交</button>
                            </td>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <c:if test="${not empty flag}">
            <script>
                alert("预定成功，请尽快前往个人中心支付费用！");
            </script>
        </c:if>

    </div>
</div>

<%@include file="include/fore/foreFooter.jsp"%>