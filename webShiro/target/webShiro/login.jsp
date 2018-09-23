<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shiro Login Demo</title>
</head>
<body>
	<form action="shiroLogin" method="post"><%--这个的shiroLogin指的是servlet里面的路径--%>
		用户名：<input type="text" name="mid" id="mid"><br>
		密&nbsp;码：<input type="password" name="password" id="password"><br>
		<input type="submit" value="登录">
		<input type="reset" value="重置">
	</form> 
</body>
</html>