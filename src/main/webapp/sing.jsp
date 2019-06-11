<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/26
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/sing.css">
    <%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">--%>
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-horizontal" method="post" action="/sing">
    <div class="login">
        <div class="login-screen">
            <div class="app-title">
                <h1>Login</h1>
            </div>

            <div class="login-form">
                <div class="control-group">
                    <input type="text" class="login-field" value="" placeholder="请输入用户名" id="login-name" name="users">
                    <label class="login-field-icon fui-users" for="login-name"></label>
                </div>

                <div class="control-group">
                    <input type="password" class="login-field" value="" placeholder="请输入密码" id="login-pass" name="psw">
                    <label class="login-field-icon fui-lock" for="login-pass"></label>
                </div>


                <button class="btn btn-primary btn-large btn-block" href="#">登录</button>

            </div>
        </div>
    </div>
</form>
</body>
</html>
