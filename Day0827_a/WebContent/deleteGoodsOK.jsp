<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.bit.dao.GoodsDao"%>
<%@page import="com.bit.vo.GoodsVo"%>
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
		상품삭제성공
	</c:if>
	<c:if test="${re<=0 }">
		상품삭제실패
	</c:if>
	<hr>
	<a href="listGoods.do">상품목록</a>
	<a href="insertGoods.do">상품등록</a>
</body>
</html>