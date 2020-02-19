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
	<div align="center" class="container" style="width: 600px">
		<h1>收藏内容</h1>
		<hr>
		
		<form  id="form2">
		  <!-- 文章 -->
		 <input type="hidden" name="articleId" value="${article.id }">
		 <!-- 用户 -->
		 <input type="hidden" name="user_id" value="${article.user.id }">
			
			<div class="form-group form-inline">
				收藏文本：
				<textarea rows="1" cols="20" name="text" class="form-control"></textarea>
			</div>
			<div class="form-group form-inline">
				收藏地址：<input type="text" name="url" class="form-control">
			</div>
			<div class="form-group form-inline">
				<button type="button" onclick="add()">收藏</button>
			</div>
		</form>
	</div>
</body>
</html>