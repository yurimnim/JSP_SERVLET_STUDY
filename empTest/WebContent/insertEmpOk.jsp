<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
</style>
<meta charset="UTF-8">
<title>직원등록페이지 </title>
</head>
<body>
<c:if test="${re>=1 }">
		직원등록완료! <br>
	</c:if>
	<c:if test="${re<1 }">
		<font color="red"><b>직원등록오류</b></font><br>
	</c:if>
<a href ="listEmp.do">직원목록 &nbsp;&nbsp;</a>
<a href ="insertEmp.do">직원등록</a>
</body>
</html>