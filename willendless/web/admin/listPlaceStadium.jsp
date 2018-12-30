<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/16
  Time: 14:37
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

<title>场地管理</title>

<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="admin_place_list">场馆管理</a></li>
        <li>${place.name}</li>
        <li><a href="admin_placeStadium_list?pid=${place.id}">场地管理</a></li>
    </ol>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>场地名称</th>
                <th>数量</th>
                <th>费用/小时</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${placeStadiums}" var="ps">

                <tr>
                    <td>${ps.id}</td>
                    <td>${ps.name}</td>
                    <td>${ps.num}</td>
                    <td>${ps.fare}</td>
                    <td><a href="admin_placeStadium_edit?id=${ps.id}&pid=${place.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_placeStadium_delete?id=${ps.id}&pid=${place.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>


    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增场地</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_placeStadium_add?pid=${place.id}" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>场地名称</td>
                        <td><input id="name" name="name" type="text" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>场地数量</td>
                        <td>
                            <input id="num" name="num" type="text" class="form-control"/>
                        </td>
                    </tr>
                    <tr>
                        <td>场地费用/小时</td>
                        <td>
                            <input id="fare" name="fare" type="text" class="form-control" />
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

<%@include file="../include/admin/adminFooter.jsp"%>
