<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/16
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/admin/adminHeader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function () {
        $("#addForm").submit(function () {
            if (!checkEmpty("name", "场地名称"))
                return false;
            if (!checkEmpty("num", "场地数量"))
                return false;
            if (!checkEmpty("fare", "场地费用"))
                return false;
            return true;
        });
    });

</script>

<title>场地编辑</title>

<div class="workingArea">
    <ol class="breadcrumb">
        <li><a href="admin_place_list">场馆管理</a></li>
        <li><a href="admin_placeStadium_list?pid=${place.id}">${place.name}</a></li>
        <li>${placeStadium.name}</li>
        <li class="active">信息编辑</li>
    </ol>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">场地信息编辑</div>
        <div class="panel-body">
            <form onsubmit="return submitCheck()" method="post" id="addForm" action="admin_placeStadium_update?id=${placeStadium.id}&pid=${place.id}" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>场地名称</td>
                        <td><input value="${placeStadium.name}" id="name" name="name" type="text" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>场地数量</td>
                        <td>
                            <input value="${placeStadium.num}" id="num" name="num" type="text" class="form-control"/>
                        </td>
                    </tr>
                    <tr>
                        <td>场地费用/小时</td>
                        <td>
                            <input value="${placeStadium.fare}" id="fare" name="fare" type="text" class="form-control" />
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>