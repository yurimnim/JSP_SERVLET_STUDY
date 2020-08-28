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
	<c:if test="${re>0 }">
	  <font color="green">부서를 수정하였습니다. </font>
	</c:if>
	<c:if test="${re <=0 }">
	  부서수정 오류
	</c:if>
	<br>
	<a href="listDept.do">부서목록</a><br>
	<a href="insertDept.do">부서등록</a>
</body>
</html>