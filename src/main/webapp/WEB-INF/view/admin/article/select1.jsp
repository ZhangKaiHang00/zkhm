<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
</head>
<body>
<form action="select" method="post">
<table class="table table-striped table-hover table-sm ">
	<tr>
		<td>文章编号：${complain.id}</td>
	</tr>
	<tr>
		<td>文章标题：${complain.article.title}</td>
	</tr>
	<tr>
		<td>文章内容：${complain.content}</td>
	</tr>
	<tr>
		<td>文章类型：${complain.typename}</td>
	</tr>
	<tr>
		<td>文章次数：${complain.article.complainNum}</td>
	</tr>
	
	
</table>
</form>
</body>
</html>