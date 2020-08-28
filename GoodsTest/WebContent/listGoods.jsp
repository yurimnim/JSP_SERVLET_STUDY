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
<a href="insertGoods.do">상품등록</a><br>
<table>
	<tr>
		<td>상품번호</td>
		<td>상품명</td>
		<td>상품가격</td>				
	</tr>
	<tr>
		<c:forEach var="g" items="${list}">
			<tr>
				<td>${g.no }</td>
				<td><a href = "detailGoods.do?no=${g.no }>">${g.name }</a></td>
				<td>${g.price }</td>
			</tr>
		</c:forEach>
</table>


</body>
</html>