<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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
	<form action ="insertBoardOk.do" method = "post">
		<input type="hidden" name="no" value="${no }">
		TITLE : <input type="text" name ="title"><br>
		WRITER : <input type="text" name ="writer"><br>
		Password : <input type="password" name ="pwd"><br>
		Content : <br>
		<textarea rows ="10" cols="60" name="contents">
		</textarea><br>
		<input type="submit" value="Submit">
		<input type="reset" value="cancel">
	</form>
</body>
</html>