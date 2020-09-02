<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<style>
	body {
	 font-family: 'Noto Sans KR';
	}
	
</style>
<meta charset="UTF-8">
<title>게시판 만들기</title>
</head>
<body>
<h2>게시물 목록</h2>
<table border="1" width="60%"> 
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자 </th>
		<th>등록일 </th>
		<th>조회수</th>
	</tr>
	<c:forEach var="b" items="${list }">
		<tr>
			<td>${b.no }</td>
			
			
			<td>
			<c:if test="${b.b_level >0 }">
				<c:forEach var="i" begin="1" end="${b.b_level }">
					&nbsp;&nbsp;     
				</c:forEach>
				☞
			</c:if>
			<a href="detailBoard.do?no=${b.no }">${b.title }</a></td>
			<td>${b.writer }</td>
			<td>${b.regdate }</td>
			<td>${b.hit }</td>
		</tr>
	</c:forEach>		
	</table>
	<br>
	<br>
	${pageStr }
	
	<%-- <c:forEach var="i" begin="1" end="${totalPage }">
		<a href="listBoard.do?pageNUM=${i }">${i }</a> &nbsp;&nbsp;
	</c:forEach> --%>
</body>
</html>