<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/07/21
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="./js/jquery-1.8.2.min.js" charset="utf-8"></script>
</head>
<script type="text/javascript">
    $(function () {
        $("span:even").css({"color": "red"});
    });
</script>
<body>
<form method="post" action="NewsServlet?action=pl">
<h1>${msg}</h1>
<c:forEach items="${talkList}" var="item">
    <p>${item.time}</p><br/>
    <p>${item.content}</p>
</c:forEach>
    <input type="hidden" value="${id}" name="id">
<input type="text" name="pl">
<input type="submit" value="评论">
</form>
</body>
</html>
