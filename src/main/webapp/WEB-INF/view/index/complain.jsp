<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投诉</title>
<!-- 引入样式 -->
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>

<script type="text/javascript">





function add(){
	
	var formData = new FormData($( "#form2" )[0]);
	
	$.ajax({
		type:"post",
		url:"/complain",
		data:formData,
		processData : false,
		// 告诉jQuery不要去设置Content-Type请求头
		contentType : false,
		success:function(flag){
			if(flag){
				alert("举报成功")
				location.href="/";
			}else{
				alert("举报失败，url 不正确")
			}
		}
		
		
	})
}
</script>
</head>
<body>
	<div align="center" class="container" style="width: 600px">
		<h1>投诉内容</h1>
		<hr>
		
		<form  id="form2">
		  <!-- 文章 -->
		 <input type="hidden" name="articleId" value="${article.id }">
		 <!-- 用户 -->
		 <input type="hidden" name="user_id" value="${article.user.id }">
			<div class="form-group form-inline">
				<input class="form-control" type="radio" name="typename" value="涉及黄色">涉及黄色&nbsp;
				<input class="form-control" type="radio" name="typename" value="涉及暴力">涉及暴力&nbsp;
				<input class="form-control" type="radio" name="typename" value="涉及违宗教政策">涉及违规宗教政策&nbsp;
				<input class="form-control" type="radio" name="typename" value="涉及国家安全">涉及国家安全&nbsp;
				<input class="form-control" type="radio" name="typename" value="抄袭内容">抄袭内容&nbsp;
				<input class="form-control" type="radio" name="typename" value="其他">其他
			</div>
			<div class="form-group form-inline">
				证据url地址：<input type="text" name="url" class="form-control">
			</div>
			<div class="form-group form-inline">
				举报内容：
				<textarea rows="1" cols="20" name="content" class="form-control"></textarea>
			</div>
			<div class="form-group form-inline">
				<button type="button" onclick="add()">举报</button>
			</div>
		</form>
	</div>
</body>
</html>