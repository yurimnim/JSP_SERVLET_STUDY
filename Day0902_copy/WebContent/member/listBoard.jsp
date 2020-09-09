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
	
	a {
	  text-decoration: none;
	}
	 
	
</style>

<meta charset="UTF-8">
<title>게시판 만들기</title>
</head>
<body>
<h2>게시물 목록</h2>

<form action ="listBoard.do" method="post">
	<select name = "option">
		<option value="title">글제목</option> 
		<option value="writer">작성자</option> 
		<option value="content">글내용</option> 
	</select>
	
	<input type="search" name="search">
	<input type="submit" value="검색">
</form>

<table border="1" width="60%"> 
	<tr>
		<th><a href="listBoard.do?sort=no">글번호</a></th>
		<th><a href="listBoard.do?sort=title">제목</a></th>
		<th><a href="listBoard.do?sort=writer">작성자</a></th>
		<th><a href="listBoard.do?sort=regdate">등록일</a></th>
		<th><a href="listBoard.do?sort=hit">조회수</a></th>
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