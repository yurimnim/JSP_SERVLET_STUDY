<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품상세</h2>
	<hr>
	상품번호: ${g.no }<br>
	상품명: ${g.name }<br>
	가격: ${g.price }<br>
	수량: ${g.qty }<br>
	<img src="upload/${g.fname }" width="100" height="100">
	<a href="updateGoods.do?no=${g.no }">수정</a>	
	</body>
</html>