<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@page isELIgnored="false"%>
<html>
<title>测试redis</title>
<% List<Object[]> list= (List<Object[]>)request.getAttribute("list");
    for (Object[] item:list) {
%>
<%=item[0]%>
<%=item[1]%>
<%
    }
%>
<body onload="data()">
瞿亮
<c:forEach items="${list}" var="item">
    ${item[0]}
    ${item[1]}
</c:forEach>
<c:out value="我去"></c:out>
</body>
</html>
