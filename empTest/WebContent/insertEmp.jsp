<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 사원번호 : <input type="text" name ="empno" required="required"><br>
 사원이름 : <input type="text" name ="ename" required="required"><br>
 직함 : <input type="text" name ="job" required="required"><br>
 직속번호 : <input type="text" name ="mgr"><br>
 입사일 : <input type="date" name ="hiredate" required="required"><br>
 월 급여 : <input type="text" name ="sal" required="required"><br>
 커미션 : <input type="text" name ="comm"><br>
 부서번호 : <input type="text" name ="deptno"><br>
 <input type="submit" value ="등록">
 <input type="reset" value ="취소">
</form>
</body>
</html>