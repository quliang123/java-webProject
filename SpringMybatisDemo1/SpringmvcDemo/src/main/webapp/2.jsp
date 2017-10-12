<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/08/30
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/first" method="post" >
        <input name="score" /><span>${scoremsg}</span>
        <input name="name" /><span>${namemsg}</span>
        <input name="phone" /><span>${phonemsg}</span>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
