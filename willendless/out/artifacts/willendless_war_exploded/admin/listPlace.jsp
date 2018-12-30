<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/11
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/admin/adminHeader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>

<script>
$(function () {
    $("#addForm").submit(function () {
        if (!checkEmpty("name", "场馆名称"))
            return false;
        if (!checkEmpty("location", "场馆地址"))
            return false;
        if (!checkEmpty("introduction", "场馆介绍"))
            return false;
        if (!checkEmpty("placePic", "场馆图片"))
            return false;
        return true;
    });
});

</script>

<title>场馆管理</title>

<div class="workingArea">
    <h1 class="label label-info">场馆管理</h1>
    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>图片</th>
                    <th>场馆名称</th>
                    <th>场地安排</th>
                    <th>场地信息</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${places}" var="p">

                    <tr>
                        <td>${p.id}</td>
                        <td><img height="40px" src="image/place/${p.id}.jpg"></td>
                        <td>${p.name}</td>
                        <td><a href="admin_stadiumPlan_list?pid=${p.id}&psid=0"><span class="glyphicon glyphicon-align-justify"></span> </a></td>
                        <td><a href="admin_placeStadium_list?pid=${p.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>
                        <td><a href="admin_place_edit?id=${p.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                        <td><a deleteLink="true" href="admin_place_delete?id=${p.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <%@ include file="../include/admin/adminPage.jsp" %>
    </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增场馆</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_place_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>场馆名称</td>
                        <td><input id="name" name="name" type="text" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>英文名称</td>
                        <td>
                            <input id="ename" name="ename" type="text" class="form-control"/>
                        </td>
                    </tr>
                    <tr>
                        <td>场馆地址</td>
                        <td>
                            <input id="location" name="location" type="text" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td>场馆简介</td>
                        <td>
                            <textarea id="introduction" name="introduction" class="form-control"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>场馆图片</td>
                        <td>
                            <input id="placePic" accept="image/*" type="file" name="filepath" />
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