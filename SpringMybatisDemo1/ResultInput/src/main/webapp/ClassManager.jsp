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
                <li id="active"><a href="billList.">账单管理</a></li>
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
            <span>账单管理页面</span>
        </div>
        <div class="search">
            <span>商品名称：</span>
            <input type="text"
                   placeholder="${productName}"
                   name="productName"/>

            <span>供应商：</span>
            <select name="tigong">
                <option value="0">--请选择--</option>
                <c:forEach items="${page.providers}" var="item">
                    <option value="${item.id}"
                            <c:if test="${item.id eq Temptigong}">selected</c:if> >${item.proName}</option>
                </c:forEach>
            </select>

            <span>是否付款：</span>
            <select name="fukuan">
                <option value="2" <c:if test="${empty Tempfukuan}">selected</c:if>>--请选择--</option>
                <option value="1" <c:if test="${Tempfukuan eq 1}">selected</c:if>>已付款</option>
                <option value="0" <c:if test="${Tempfukuan eq 0}">selected</c:if>>未付款</option>
            </select>

            <input type="button" onclick="search()" value="查询"/>
            <a href="/ClassAdd.jsp">添加年级</a>
        </div>
        <script type="text/javascript">
            function search() {
                var fukuan = $("[name=fukuan]").val();
                var tigong = $("[name=tigong]").val();
                var productName = $("[name=productName]").val();
                alert(fukuan + "======" + tigong + "=======" + productName);
                location.href = "billServlet?action=billList&fukuan=" + fukuan + "&tigong=" + tigong + "&productName=" + productName;
            }
        </script>
        <!--账单表格 样式和供应商公用-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">年级编号</th>
                <th width="20%">年级名称</th>
            </tr>


            <c:forEach items="${clist}" var="item">
                <tr>
                    <td>${item.cid}</td>
                    <td>${item.cname}</td>
                    <td>
                        <a href="billView.html"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="billUpdate.html"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="#" class="removeBill"><img src="img/schu.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <center style="font-size: 17px">
            <span>[${page.pageIndex}/${page.totlePages}]</span>
            <a href="billServlet?action=billList&pageIndex=${page.pageIndex-1}">上一页</a>
            <a href="billServlet?action=billList&pageIndex=${page.pageIndex+1}">下一页</a>
            <a href="billServlet?action=billList&pageIndex=${page.totlePages}">末页</a>
        </center>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
    版权归北大青鸟
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>