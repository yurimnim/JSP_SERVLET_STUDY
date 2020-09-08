<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	#op {
		visibility: hidden;
		display: none;
	}
</style>
<meta charset="UTF-8">
<title>사원등록</title>
</head>
<body>
<form action="insertEmpOk.do" method="post">
<h2>사원등록</h2>
<hr>
 사원번호 : <input type="text" name ="empno" value= "${newEmpno }"required="required"><br>
 사원이름 : <input type="text" name ="ename" required="required"><br>
 직함:<select name="job">
		 <option value="사장"> 사장 </option>
		 <option value="부장"> 부장 </option>
		 <option value="과장"> 과장 </option>
		 <option value="대리"> 대리 </option>
		 <option value="직원"> 직원</option>
	</select><br>
 관리자번호 : <select name="mgr">
 	<c:forEach var="map" items="${list }" >
		 <option value="${map.empno }"> (${map.empno }):${map.ename }</option>
	</c:forEach> 	 
	</select><br>
	
 입사일 : <input type="date" name ="hiredate" required="required"><br>
 월 급여 : <input type="text" name ="sal" required="required"><br>
 커미션 : <input type="text" name ="comm"><br>
 부서번호 :<select name="deptno">
 	<c:forEach var="d" items="${dlist }">
		 <option value="${d.deptno }"> ${d.dname }(${d.deptno }/${d.loc }) </option>
	</c:forEach> 
	</select><br>
 <input type="submit" value ="등록">
 <input type="reset" value ="취소">
</form>
</body>
</html>