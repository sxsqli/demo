<%@page import="com.sxsqli.domain.User"%>
<%@page import="java.util.Set"%>
<%@page import="com.sxsqli.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有账号</title>
</head>
<body>
	<%
		Set<User> users = new UserDao().getUsers();
		pageContext.setAttribute("users", users);
	%>
	<table border="1">
		<tbody>
			<tr>
				<td>在线账号</td>
				<td>密码</td>
				<td>注册时间</td>
				<td>头像</td>
				<td>介绍</td>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.registerTime}</td>
					<td><img src="${user.photoPath}" height="32"></img></td>
					<td>${user.introduction}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="index.jsp">返回</a>
	<br>
	<a href="word.html">背单词</a>
</body>
</html>