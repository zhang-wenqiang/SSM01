<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部书籍</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>全部书籍</h1>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" >
            <div class="page-header">
                <h1>
                    <small>书籍列表---显示所有书籍</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column" >
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/Book/toAddBook">新增书籍</a>
            </div>
            <div class="col-md-4 column" >
                <form class="form-inline" action="${pageContext.request.contextPath}/Book/queryBook" method="post" style="float:right">
                    <span style="color: red;font-weight: bold" >${error}</span>
                    <input type="text" name="queryBookName" placeholder="请输入要查询书籍的名称" class="form-control">
                    <input type="submit" value="查询">
                </form>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column" >
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>数量</th>
                    <th>描述</th>
                    <th>操作</th>
                </tr>

                </thead>
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/Book/toUpdateBook?id=${book.bookID}">修改</a>
                            <a href="${pageContext.request.contextPath}/Book/deleteBook/${book.bookID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>
