<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="skyblue">
레드
<jsp:forward page="yellow.jsp">
	<jsp:param value="2020" name="year"/>
	<jsp:param value="hello" name="title"/>
</jsp:forward>

</body>
</html>