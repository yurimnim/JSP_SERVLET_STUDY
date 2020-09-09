<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<style>
	body {
	 font-family: 'Noto Sans KR';
	}
</style>

<!-- <script type="text/javascript">
	function pro() {
		title = document.F.title.value.trim();
		writer = document.F.writer.value.trim();
		pwd = document.F.pwd.value.trim();
		content = document.F.content.value.trim();
		
		if(title == ""){
			alert("글제목을 입력하세요!");
			return;
		}
		if(writer == ""){
			alert("작성자를 입력하세요!");
			return;
		}
		if(pwd == ""){
			alert("암호를 입력하세요!");
			return;
		}
		if(content == ""){
			alert("글내용을 입력하세요!");
			return;
		}
		document.F.submit();		
	}
	
</script> -->

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${no }==0">
		<h2>Create a new post</h2>
	</c:if>
	<c:if test="${no }!=0">
		<h2>Comment the post</h2>
	</c:if>
	
	<hr>
	<form name ="F" action ="insertBoardOk.do" method = "post">
		<input type="hidden" name="no" value="${no }"><br>
		TITLE : <input type="text" name ="title" required="required"><br>
		WRITER : <input type="text" name ="writer" required="required"><br>
		Password : <input type="password" name ="pwd" required="required"><br>
		Content : <br>
		<textarea rows ="10" cols="60" name="content" required="required">
		</textarea><br>
		<input type="submit" value="등록">
	<!-- 	<input type="button" value="등록" onclick="pro()"> -->
		<input type="reset" value="취소">
	</form>
</body>
</html>