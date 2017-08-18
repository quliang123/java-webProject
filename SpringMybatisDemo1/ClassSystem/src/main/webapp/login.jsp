<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<center>

    <form method="post" action="UserServlet?action=login">
        用户名<input type="text" name="uName"><br/>
        密码<input type="password" name="uPwd"><br/>
        <input type="submit" value="登陆">
    </form>
</center>
</body>
</html>
