<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏</title>
<!-- 引入样式 -->
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>

<script type="text/javascript">


function add(){
	
	var formData = new FormData($( "#form2" )[0]);
	
	$.ajax({
		type:"post",
		url:"/shou",
		data:formData,
		processData : false,
		// 告诉jQuery不要去设置Content-Type请求头
		contentType : false,
		success:function(flag){
			if(flag){
				alert("收藏成功")
				location.href="/";
			}else{
				alert("收藏失败，url 不正确")
			}
		}
		
		
	})
}
</script>
</head>
<body>

	<table class="table table-bordered table-hover">
		<tr align="center">
			<td>主键</td>
			<td>文本</td>
			<td>地址</td>
			<td>时间</td>
		</tr>
		<c:forEach items="${list}" var="u" varStatus="i">
			<tr align="center">
				<td>${i.count}</td>
				<td>${u.text }</td>
				<td>${u.url }</td>
				<td>${u.created}</td>
			</tr>

		</c:forEach>
		

	</table>
	</div>
</body>
</html>