<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/08/13
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <table>
        <tr>
            <td>学生名称</td>
            <td>考勤时间</td>
            <td>出勤状态</td>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <c:forEach items="${item.students}" var="i">
                <td>${i.studentname}</td>
            </c:forEach>

                <td>${item.attendancetime}</td>
                <td>${item.attendanceid}</td>
                <c:if test="${item.attendanceid} eq 1">
                    <td>病假</td>
                </c:if>
                <c:if test="${item.attendanceid} eq 2">
                    <td>出勤</td>
                </c:if>
                <c:if test="${item.attendanceid} eq 3">
                    <td>未出勤</td>
                </c:if>
                <c:if test="${item.attendanceid} eq 4">
                    <td>事假</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
