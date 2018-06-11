<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
	form{
		width: 40%;
		margin: 10px auto;
	}
</style>
<body>
<div class="container">

      <form class="form-signin" method="post" action="LoginServlet">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="loginUserName" class="sr-only">输入用户名</label>
        <input type="text" id="loginUserName" name="loginUserName" class="form-control" placeholder="输入用户名" required autofocus>
        <label for="loginPassword" class="sr-only">输入登录密码</label>
        <input type="password" id="loginPassword" name="loginPassword" class="form-control" placeholder="输入登录密码" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <button class="btn btn-lg btn-primary btn-block" type="reset">重置</button>

      </form>

    </div> <!-- /container -->
</body>
</html>