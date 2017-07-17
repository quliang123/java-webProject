<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>博客列表</title>
    <link rel="stylesheet" href="/blogs/BlogHtTemplate-master/bootstrap/css/bootstrap.css"></link>
    <%-- <link rel="stylesheet" href="/blogs/BlogHtTemplate-master/css/myCSS.css"></link>
     <link rel="stylesheet" href="/blogs/BlogHtTemplate-master/css/Add.css"></link>--%>

    <script type="text/javascript" src="/blogs/BlogHtTemplate-master/bootstrap/js/jquery-1.8.2.min.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="/blogs/BlogHtTemplate-master/bootstrap/js/jquery-1.12.4.js"
            charset="utf-8"></script>

    <script type="text/javascript" src="/blogs/BlogHtTemplate-master/bootstrap/js/bootstrap.js"
            charset="utf-8"></script>


    <style>

        #myimg {
            width: 319px;
            height: 319px;
        }


    </style>


    <script type="text/javascript">
        function editBlog(id, obj) {
            alert(id);
            $("#rid").val(id);


            $.ajax({
                type: "post",
                url: "BlogServlet?action=Info&id=" + id,
                success: function (data) {
                    alert("12323" + data);
                    var data = eval('(' + data + ')');
                    /// alert(data.BlogAuthor+"==="+data.BlogAddress+"====="+data.BlogDel);\
                    //$("#name").text(data.BlogAuthor);
                    $("#rid").val(data.BlogId);
                    $("#author").val(data.BlogAuthor);
                    $("#address").val(data.BlogAddress);
                }
            });
        }


        function del(id) {
            alert(id);
            var result = confirm('确认删除吗？');
            if (result == true) {
                location.href = "BlogServlet?action=delBlog&id=" + id;
                return true;
            } else {
                return false;
            }
        }


    </script>
</head>
<body>
<!-- 学伴 -->
<div class="clearfix" id="home_partner">
    <div class="container">
        <h2 class="btitle" align="center" style="color: #00f7ff">
            有伴有爱有力量，再也不怕学习没动力
        </h2>
        <h4 class="subtitle" align="center" style="color: #4cae4c">
            <span>
                学习从来不是轻松事，与其孤身奋战，不如找到志同道合小伙伴一起坚持到底，微冷的宇
            </span>
        </h4>
        <br>
        <div class="row text-center">


            <c:forEach items="${page.getList()}" var="item">
                <div class="col-sm-4" align="center">
                    <div class="partneritem" style="position:relative;">
                        <div>
                                <%--  <img id="myimg" class="img-responsive" src="./images/${item.blogImage}" alt=""><br/>--%>
                            <a href="">${item.blogAuthor}</a>
                            <a class="a1" href="#mymodal" data-toggle="modal" onclick="editBlog(${item.blogId},this)">
                                <button>修改</button>
                            </a>
                            <a class="a2"
                               onclick="del(${item.blogId})">
                                <button>删除</button>
                            </a>
                        </div>

                        <h4>
                                ${item.blogAuthor}
                        </h4>
                        <p>
                            <a target="_blank" href="${item.blogAddress}">${item.blogAddress}</a>
                        </p>
                    </div>
                </div>
            </c:forEach>


        </div>
    </div>
</div>
<div style="text-align: center">
    <a href="<%=path%>/BlogServlet?action=Blogslist&pageIndex=1">首页</a> &nbsp;&nbsp;&nbsp;
    当前页:[ ${page.pageIndex} / ${page.totalrecords} ] &nbsp;&nbsp;&nbsp;


    <a href="<%=path%>/BlogServlet?action=Blogslist&pageIndex=${page.pageIndex-1}">上一页</a> &nbsp;&nbsp;&nbsp;

    <a href="<%=path%>/BlogServlet?action=Blogslist&pageIndex=${page.pageIndex+1}">下一页</a> &nbsp;&nbsp;&nbsp;

    <a href="<%=path%>/BlogServlet?action=Blogslist&pageIndex=${page.totalrecords}">尾页</a>
</div>

<%--=============================================================--%>

<!--弹出的模态框-->
<div id="mymodal" class="modal fade bs-examlpe-modal-sm"><!-- modal固定布局，上下左右都是0表示充满全屏，支持移动设备上使用触摸方式进行滚动。。-->
    <div class="modal-dialog modal-sm"><!-- modal-dialog默认相对定位，自适应宽度，大于768px时宽度600，居中-->
        <div class="modal-content"><!-- modal-content模态框的边框、边距、背景色、阴影效果。-->
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">
                    修改
                    <small id="name"></small>
                </h4>
            </div>
            <div class="media-body">
                <form action="/blogs/FileUpServlet?action=FileUp" method="post" enctype="multipart/form-data">

                    <input type="hidden" name="blogId" value="" id="rid"/>

                    <div class="col-md-10 col-md-offset-1 myMP">
                        博客作者：<input name="blogAuthor" id="author" class="form-control" type="text" placeholder="博客作者"/>
                    </div>
                    <div class="col-md-10 col-md-offset-1 myMP">
                        博客地址： <input name="blogAddress" id="address" class="form-control" type="text" placeholder="博客地址"/>
                    </div>
                    <div class="col-md-10 col-md-offset-1 myMP">
                        博客头像： <input name="blogImage" class="form-control" type="file" placeholder="博客头像"/>
                    </div>

                    <div class="col-md-12 myB">
                        <input class="btn btn-danger form-control" type="submit" value="修改"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>

</div>
</body>
</html>