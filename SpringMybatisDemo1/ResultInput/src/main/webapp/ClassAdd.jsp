<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js" charset="utf-8"></script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li id="active"><a href="ClassManager.jsp">账单管理</a></li>
                <li><a href="providerList.html">供应商管理</a></li>
                <li><a href="userList.jsp">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 添加年级</span>
        </div>
        <div class="providerAdd">
            <form action="#" method="post">
                <div>
                    <label for="billName">年级名称：</label>
                    <input type="text" name="ClassName" id="billName" required/>
                    <span>*请输入年级名称</span>
                </div>
                <div class="providerAddBtn">
                    <input type="button" value="保存" onclick="save()"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>
    </div>
</section>
<script type="text/javascript">
    function save() {
        var name = $("input[name=ClassName]").val();
        alert(name);
        $.ajax({
            type: "post",
            url: "/ClassServlet?action=save",
            data: {
                name: name
            },
            success: function (data) {
                if ("y" == data) {
                    $("input[name=ClassName]").val("");
                    alert("添加成功");
                }
            }
        });
    }
</script>


<footer class="footer">
    版权归北大青鸟
</footer>
<script src="js/time.js"></script>

</body>
</html>