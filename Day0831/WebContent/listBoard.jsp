<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST BOARD</title>
</head>
<body>
<h2>Feed</h2>
<hr>
<table border ="1" width="60%">
	<tr>
		<th>No</th>
		<th>Title</th>
		<th>Writer</th>
		<th>Date</th>
	</tr>
	<c:forEach var="b" items="${list }">
		<tr>
			<td>${b.no }</td>
			<td>
			<c:if test="${b.level }>0">
				<c:forEach var="i" begin="1" end="${b.b_level }" >
					&nbsp;&nbsp;&nbsp;
				</c:forEach>
				<img src ="re.png"> 
			</c:if>
			
			<a href="detailBoard.do?no=${b.no }">${b.title }</a></td>
			<td>${b.writer }</td>
			<td>${b.regdate }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>