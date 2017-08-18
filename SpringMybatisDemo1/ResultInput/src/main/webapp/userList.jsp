<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="./js/jquery-1.8.2.min.js" charset="utf-8"></script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${user.userName}</span> , 欢迎你！</p>
        <a href="userServlet?action=logout">退出</a>
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
                <li><a href="billServlet?action=billList">账单管理</a></li>
                <li><a href="providerList.html">供应商管理</a></li>
                <li id="active"><a href="userList.jsp">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <div class="search">
            <span>用户名：</span>
            <input type="text" placeholder="请输入用户名" name="search"/>
            <input type="button" value="查询" onclick="search()"/>
            <a href="userAdd.jsp">添加用户</a>
        </div>
        <script type="text/javascript">
            function search() {
                var search = $("[name=search]").val();
                //alert(search);
                location.href = "userServlet?action=userList&search=" + search;
            }

            function delUser(id, dom) {
                alert(id);
                data = {
                    id: id
                }

                var flag = confirm("确认删除嘛?");
                if (flag) {

                    $.ajax({
                        type: "post",
                        url: "userServlet?action=delUser",
                        data: data,
                        success: function (data) {
                            if ("y" == data) {
                                alert("删除成功!!!!!");
                                $(dom).parent().parent().css({"color": "red", "border": "2px solid blue"});
                            } else {
                                alert("删除失败!!!!!")
                            }
                        }
                    });
                }

            }
        </script>

        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户编码</th>
                <th width="20%">用户名称</th>
                <th width="10%">性别</th>
                <th width="10%">年龄</th>
                <th width="10%">电话</th>
                <th width="10%">用户类型</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${page.users}" var="item">
                <tr>
                    <td>${item.userCode}</td>
                    <td>${item.userName}</td>
                    <td><c:if test="${item.gender eq 1}">
                        男
                    </c:if>
                        <c:if test="${item.gender eq 0}">
                            女
                        </c:if>
                    </td>
                    <td>${item.age}</td>
                    <td>${item.phone}</td>
                    <td>
                        <c:if test="${item.userType==3}">
                            普通员工
                        </c:if>
                        <c:if test="${item.userType==2}">
                            经理
                        </c:if>
                        <c:if test="${item.userType==1}">
                            系统管理员
                        </c:if>

                    </td>
                    <td>
                        <a href="userServlet?action=UserDetails&id=${item.id}"><img src="img/read.png" alt="查看"
                                                                                    title="查看"/></a>
                        <a href="userServlet?action=GoModify&id=${item.id}"><img src="img/xiugai.png" alt="修改"
                                                                                 title="修改"/></a>
                        <a href="javascript:delUser('${item.id}',this)" class="removeUser"><img src="img/schu.png"
                                                                                                alt="删除"
                                                                                                title="删除"/></a>
                    </td>
                </tr>
                ${item.id}
            </c:forEach>

        </table>
        <center style="font-size: 17px">
            <span>[${page.pageIndex}/${page.totalrecords}]</span>
            <a href="userServlet?action=userList&pageIndex=${page.pageIndex-1}">上一页</a>
            <a href="userServlet?action=userList&pageIndex=${page.pageIndex+1}">下一页</a>
            <a href="userServlet?action=userList&pageIndex=${page.totalrecords}">末页</a>
        </center>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
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