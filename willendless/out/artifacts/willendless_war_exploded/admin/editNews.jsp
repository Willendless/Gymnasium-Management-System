<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/25
  Time: 21:09
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
            if (!checkEmpty("title", "通知标题"))
                return false;
            if (!checkEmpty("content", "通知内容"))
                return false;
            return true;
        });
    });

</script>


<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="admin_news_list">通知管理</a></li>
        <li class="active">编辑</li>
    </ol>

    <div class="panel panel-warning">
        <div class="panel-heading">通知信息编辑</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_news_update?id=${news.id}" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <input type="hidden" name="id" value="${news.id}" />
                    </tr>
                    <tr>
                        <td>通知标题</td>
                        <td><input id="title" name="title" type="text" class="form-control" value="${news.title}"/></td>
                    </tr>

                    <tr>
                        <td>通知内容</td>
                        <td>
                            <textarea id="content" name="content" class="form-control" rows="5">${news.content}</textarea>
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

