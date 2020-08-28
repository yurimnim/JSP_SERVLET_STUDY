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
<h2>부서목록</h2><br>
<a href="insertDept.do">등록</a><br>
<table border ="1">
	<tr>
		<th>부서번호</th>
		<th>부서명</th>
		<th>부서위치</th>
		<th>action</th>		
	</tr>	
	<c:forEach var="d" items="${list }">
	<tr>
		<td>${d.deptno }</td>
		<td>${d.dname }</td>
		<td>${d.loc }</td>	
		<td>
			<a href="updateDept.do?deptno=${d.deptno }">수정</a>
			<a href="deleteDept.do?deptno=${d.deptno }">삭제</a>
		</td>
	</tr>		
	</c:forEach>
	
</table>
</body>
</html>