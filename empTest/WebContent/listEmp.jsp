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
	  color: black;
	}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>직원목록</h2>
<table border="1" width="60%"> 
	<tr>
		<th>직원번호</th>
		<th>성명</th>
		<th>직함</th>
		<th>직속번호</th>
		<th>입사일</th>
		<th>월급</th>
		<th>상여금</th>
		<th>부서번호</th>
	</tr>
	<c:forEach var="e" items="${list }">
		<tr>
			<td>${e.empno }</td>
			<td>${e.ename }</td>
			<td>${e.job }</td>
			<td>${e.mgr }</td>
			<td>${e.hiredate }</td>
			<td>${e.sal }</td>
			<td>${e.comm }</td>
			<td>${e.deptno }</td>
		</tr>
	</c:forEach>		
	</table>
	<br>
	<br>
	${pageStr }
	
</body>
</html>