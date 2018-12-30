<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/16
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/admin/adminHeader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>

<title>场馆日程安排</title>

<div class="workingArea">
    <ol class="breadcrumb">
        <li>当前位置：</li>
        <li><a href="admin_place_list">场馆管理</a></li>
        <li>${place.name}</li>
        <li>场地安排</li>
        <li class="active">${placeStadium.name}</li>
    </ol>


    <div class="tableContainer">
        <div class="tableRow">
            <div class="sideBar">
                <ul class="list-group">
                        <c:forEach items="${placeStadiums}" var="ps">
                            <li class="list-item list-group-item">
                                <a href="admin_stadiumPlan_list?pid=${place.id}&psid=${ps.id}" class="link">${ps.name}</a>
                            </li>
                        </c:forEach>
                </ul>
            </div>
            <div class="mainContent" style="padding:0 20px;width: 1200px">
                <div class="tableBar">
                    <table class="table" style="border-top: hidden">
                        <tbody>
                            <tr style="border-bottom: #778899; border-bottom-style: solid">
                                <th style="margin: 0 auto; padding: 0 auto; text-align: left; width: 100px">
                                    <b>日期选择</b>
                                </th>
                                <td style="margin: 0 auto; padding: 0 auto; text-align: left">
                                    <c:forEach items="${dates}" var="d">
                                        <a href="admin_stadiumPlan_list?pid=${place.id}&psid=${placeStadium.id}&date=${d}" name="ckRadio1" style="cursor: pointer; margin: 0 auto; padding: 0 auto; text-align: left" id="${d}">${d}</a>
                                    &nbsp;&nbsp;
                                    </c:forEach>
                                    <script>
                                        document.getElementById("${date}").style.backgroundColor="black";
                                        document.getElementById("${date}").style.color="white";
                                    </script>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <!-- 修改表格项的js脚本 -->
                <script>
                    function submitCheck() {
                        return window.confirm("是否确定提交？");
                    }
                </script>


                <div class="bookInfo" style="padding: 20px">
                    <div class="bookTableDiv">
                        <form onsubmit="return submitCheck()" action="admin_stadiumPlan_update?pid=${place.id}&psid=${placeStadium.id}&date=${date}" method="post">
                            <table class="table-bordered" id="timeTable">
                                <tbody>
                                    <tr style="text-align: center; height: 30px">
                                        <th>&nbsp;&nbsp;&nbsp;</th>
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
                                    <c:forEach items="${stadiumPlanList}" var="plan">
                                        <tr style="height: 40px">
                                            <th style="text-align: center"><%=String.valueOf(request.getAttribute("name")).substring(0,1)%>${plan.index+1}</th>
                                            <c:forEach items="${plan.stadiumPlanItemList}" var="item">
                                                <td><input onchange="isChanged(this,${item.id})" style="width: 70px; text-align: center; border: none;" value="${item.status}" name="" size="7"/></td>

                                                <script>
                                                    function isChanged(id,res) {
                                                        id.name = res;
                                                        console.log(res);
                                                    }
                                                </script>
                                            </c:forEach>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="submitTR text-center" style="margin: 15px">
                                <td colspan="2" align="center">
                                    <button type="submit" class="btn btn-success">提交</button>
                                </td>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
