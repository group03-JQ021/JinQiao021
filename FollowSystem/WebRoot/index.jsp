<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    
    <base href="<%=basePath%>">
    
    <title>主页 |图书管理系统</title>
	
    <!-- Bootstrap -->
    <link href="bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	<!-- 本页自定义样式 -->
	<link href="css/index.css" rel="stylesheet">

  </head>
  
  <body>
 	<div class="container">
	
	<jsp:forward page="ManageBooksServlet"></jsp:forward>
 

    </div> <!-- /container -->
  
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->	
    <script src="js/jquery-2.1.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。也可以根据需要只加载单个插件。 -->
    <script src="bootstrap-3.3.7/js/bootstrap.js"></script>

  </body>
</html>
