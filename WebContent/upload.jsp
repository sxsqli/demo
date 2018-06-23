<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头像上传</title>
</head>
<body>
	<h1>请上传头像</h1>
	<hr>
	<form action="UploadPhoto" method="post" enctype="multipart/form-data">
		<input type="file" name="photo">
		<input type="submit" value="上传">
	</form>
	<hr>
	<a href="index.jsp">返回</a>
</body>
</html>