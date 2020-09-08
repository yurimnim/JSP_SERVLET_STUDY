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
	  	color: green;
	}
	
	#op {
		visibility: hidden;
		display: none;
	}
</style>
<script>
	function pro(v) {
		var op = document.getElementById("op");
		if(v =="sal") {			
			op.style.visibility="visible";
			op.style.display="inline";
		} else {
			op.style.visibility="hiddne";
			op.style.display="none";
		}
	}
</script>
<meta charset="UTF-8">
<title>직원관리페이지</title>
</head>
<body>
<h2>직원목록</h2>
<a href ="insertEmp.do">직원등록</a>

<form action="listEmp.do" method="post">
사원검색: &nbsp;&nbsp;
<select name="option" onchange="pro(this.value)">
	<option value="empno"> 직원번호 </option>
	<option value="ename"> 직원명 </option>
	<option value="job"> 직함 </option>
	<option value="mgr"> 관리자번호 </option>
	<option value="deptno"> 부서번호 </option>	
	<option value="sal"> 급여 </option>	
</select>
<select id ="op" name="op">
	<option>&gt;</option>
	<option>&lt;</option>
	<option>&gt;=</option>
	<option>&lt;=</option>
	<option>=</option>
</select>
<input type="search" name="search">
<input type="submit" value="검색"> 
</form>
<table border="1" width="60%"> 
	<tr>
		<th><a href="listEmp.do?sort=empno">직원번호</a></th>
		<th><a href="listEmp.do?sort=ename">성명</a></th>
		<th><a href="listEmp.do?sort=job">직함</a></th>
		<th><a href="listEmp.do?sort=mgr">직속번호</a></th>
		<th><a href="listEmp.do?sort=hiredate">입사일</a></th>
		<th><a href="listEmp.do?sort=sal">월급</a></th>
		<th><a href="listEmp.do?sort=comm">상여금</a></th>
		<th><a href="listEmp.do?sort=deptno">부서번호</a></th>
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
	${pageStr }
	
</body>
</html>