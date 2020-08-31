<%@page import="com.bit.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INSERT BOARD</title>
</head>
<body>

	<c:if test="${re>0 }">
		Your request has been submitted.
	</c:if>

	<c:if test="${re<=0 }">
		<font color="red"><b>Your request failed.</b></font>
	</c:if>
	
</body>
</html>