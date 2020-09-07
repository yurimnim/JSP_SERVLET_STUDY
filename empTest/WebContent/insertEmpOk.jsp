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
<c:if test="${re>=1 }">
		직원등록완료!
	</c:if>

	<c:if test="${re<1 }">
		<font color="red"><b>직원등록오류</b></font>
	</c:if>
<a href ="listEmp.do">직원목록</a><br>
<a href ="insertEmp.do">직원등록</a>
</body>
</html>