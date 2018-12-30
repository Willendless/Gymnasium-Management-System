<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/11
  Time: 23:36
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
            if (!checkEmpty("ename", "场馆英文名称"))
                return false;
            if (!checkEmpty("location", "场馆地址"))
                return false;
            if (!checkEmpty("introduction", "场馆介绍"))
                return false;
            return true;
        });
    });

</script>


<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="admin_place_list">场馆管理</a></li>
        <li><a href="admin_place_edit?id=${place.id}">${place.name}</a></li>
        <li class="active">信息编辑</li>
    </ol>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">场馆信息编辑</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_place_update" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <input type="hidden" name="id" value="${place.id}" />
                    </tr>
                    <tr>
                        <td>场馆名称</td>
                        <td><input id="name" name="name" type="text" class="form-control" value="${place.name}"/></td>
                    </tr>
                    <tr>
                        <td>英文名称</td>
                        <td>
                            <input id="ename" name="ename" type="text" class="form-control" value="${place.ename}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>场馆地址</td>
                        <td>
                            <input id="location" name="location" type="text" class="form-control" value="${place.location}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>场馆简介</td>
                        <td>
                            <textarea id="introduction" name="introduction" class="form-control" rows="5">${place.introduction}</textarea>
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

<%@ include file="../include/admin/adminFooter.jsp"%>
