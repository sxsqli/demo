<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.username}</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/chat.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${empty user}">
			<h1>请先登陆</h1>
		</c:when>
		<c:otherwise>
			<h1>聊天室</h1>
		</c:otherwise>
	</c:choose>
	<hr>
	<h1>在线人数：<span id="onlineUsersSize">${onlineUsers.size()}</span></h1>
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
			<a href="index.jsp">返回首页</a>
		</c:otherwise>
	</c:choose>
	<hr>
	<c:if test="${!empty user}">
		<h1 style="display: inline;">
			<input type="text" id="iinn">
			<input type="button" value="发送"><br>
			<textarea rows="30" cols="100" readonly="readonly" id="oouutt"></textarea>

		</h1>
	</c:if>

</body>
</html>