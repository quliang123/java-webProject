<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/08/11
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.8.2.min.js" charset="utf-8"></script>
</head>
<body>
<script type="text/javascript">
    function t() {
        var ls = $(".trs").children().length - 1;
        var arr = new Array();
        $(".trsa").each(function (index, dom) {
            //alert(index);
            //var id = $(".id").val();
            // var id = $('input:hidden').val();
            var id = $('.id').eq(index).val();
            /*if (dom.is(":checked")) {
             alert(id + "当前选中" + this.val());
             }*/
            var val = $('input:radio[class=a]:checked').val();
            if (val != null) {
                arr.push(id, val);
                alert("选中的值" + val + "id+" + id);
            }
        });
        alert(arr);

    }
</script>
<center>
    学生名称<br>
    <form action="/UserServlet?action=s" method="post">
        根据日期进行查询<input name="time" type="date"> ${id}<input type="submit" value="查询"> <br>
    </form>
    <form method="post" action="/UserServlet?action=save">
        <table class="trs">
            <input type="hidden" name="id" value="${id}"/>
            <c:forEach items="${lists}" var="item">
                <tr class="trsa">
                    <td><input type="text" class="id" value="${item.studentid}"></td>
                    <td>${item.studentname}</td>
                    <td><input name="${item.studentid}" class="a" type="radio" checked value="2">出勤</td>
                    <td><input name="${item.studentid}" class="a" type="radio" value="3">未出勤</td>
                    <td><input name="${item.studentid}" class="a" type="radio" value="4">事假</td>
                    <td><input name="${item.studentid}" class="a" type="radio" value="1">病假<br></td>
                </tr>
            </c:forEach>
        </table>
        <%-- <input type="button" value="提交" onclick="t()">--%>
        <input type="submit">提交</input>
    </form>
</center>
</body>
</html>
