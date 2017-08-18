<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/08/17
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<form method="post" action="/parameter">
    <input name="name">
    地址:<input name="address.address">
    java高级图书1:<input name="list[0].bookName">
    java高级图书1:<input name="list[1].bookName">
    <input type="submit" value="登陆">
</form>
</center>
</body>
</html>
