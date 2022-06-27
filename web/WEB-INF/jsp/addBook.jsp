<%--
  Created by IntelliJ IDEA.
  User: calmness
  Date: 2021/12/10
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" >
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/Book/addBook" method="post">
        <div class="form-group">
            <label for="bkname">书籍名称：</label>
            <input type="text" id="bkname" class="form-control" name="bookName" required>
        </div>
        <div class="form-group">
            <label for="bkcount">书籍数量：</label>
            <input type="text" id="bkcount" class="form-control" name="bookCounts" required>
        </div>
        <div class="form-group">
            <label for="bkdetail">书籍描述：</label>
            <input type="text" id="bkdetail" class="form-control" name="detail" required>
        </div>
        <div class="form-group">
            <input type="submit"class="form-control" value="添加">
        </div>
    </form>
</div>
</body>
</html>
