<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/24
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/admin/adminHeader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function () {
        $("#addForm").submit(function () {
            if (!checkEmpty("title", "通知标题"))
                return false;
            if (!checkEmpty("content", "通知内容"))
                return false;
            return true;
        });
    });

</script>


<title>通知管理</title>

<div class="workingArea">
    <h1 class="label label-info">通知管理</h1>

    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>通知时间</th>
                <th>通知标题</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${news}" var="n">
                <tr>
                    <td>${n.id}</td>
                    <td>${n.TIMEX}</td>
                    <td>${n.title}</td>
                    <td><a href="admin_news_edit?id=${n.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_news_delete?nid=${n.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>

    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp"%>
    </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增通知</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_news_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>通知标题</td>
                        <td><input id="title" name="title" type="text" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>通知内容</td>
                        <td>
                            <textarea id="content" name="content" class="form-control"></textarea>
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


    <%@include file="../include/admin/adminFooter.jsp"%>
</div>

