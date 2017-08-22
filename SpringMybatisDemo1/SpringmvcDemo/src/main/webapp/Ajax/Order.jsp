<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/08/19
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
        $(function () {
           $('#btn').click(function () {
                   $.post('${pageContext.request.contextPath}',{},function (data) {
                       alert(data);
                   });
           });
        });
    </script>
</head>
<body>
<input type="button" id="btn" value="Ajax">
</body>
</html>
