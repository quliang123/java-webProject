<%@ page import="Listener.OnlineCounter" %><%--<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/06/22
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    我的天那
    ：<%=OnlineCounter.getOnline()%>
 <%=session.getId()%>
</body>
</html>
