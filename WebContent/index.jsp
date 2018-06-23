<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<h1>首页</h1>
	<hr>
	<h1>在线人数：${onlineUsers.size()}</h1>
	<hr>
	<c:choose>
		<c:when test="${empty user}">
			<form action="CheckForm" method="post">
				<input type="text" name="username">
				<input type="text" name="password" />
				<input type="submit" value="登陆">
				<a href="alluser.jsp">查看所有账号</a>
			</form>
		</c:when>
		<c:otherwise>
			<h1>欢迎登陆，<a href="upload.jsp"><img src="${user.photoPath}" height="32"></img></a>${user.username}</h1>
			<h6>介绍：${user.introduction}</h6>
			<a href="Logout">注销</a>
			&nbsp;&nbsp;
			<a href="upload.jsp">上传头像</a>
			&nbsp;&nbsp;
			<a href="setting.jsp">添加介绍</a>
			&nbsp;&nbsp;
			<a href="chat.jsp">进入聊天室</a>
		</c:otherwise>
	</c:choose>
	<hr>

	<c:if test="${onlineUsers.size()>0}">
		<table border="1">
			<tbody>
				<tr>
					<td>在线账号</td>
					<td>密码</td>
					<td>注册时间</td>
					<td>头像</td>
					<td>介绍</td>
				</tr>
				<c:forEach items="${onlineUsers}" var="user">
					<tr>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.registerTime}</td>
						<td><a href="${user.photoPath}"><img src="${user.photoPath}" height="32"></img></a></td>
						<td>${user.introduction}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

</body>
</html>