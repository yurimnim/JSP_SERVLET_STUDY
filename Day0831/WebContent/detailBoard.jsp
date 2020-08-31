<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Feed Detail</h2>
<hr>
	Feed No : ${b.no };<br>
	Title : ${b.title }<br>
	Writer : ${b.writer }<br>
	Content : <br>
	<textarea rows="10" cols="60">${b.content }</textarea><br>
	Date: ${b.regdate }<br>
	Hit: ${b.hit } <br>
	<a href="insertBoards.do?no=${b.no }">Comments</a>
</body>
</html>