<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");	
%>
	<jsp:useBead id ="book" class="com.bit.vo.BookVO"/>
	<jsp:setProperty property="*" name="book"/>
	도서번호 :<jsp:getProperty property="bookid" name="book"/></br>
	도서이름 :<jsp:getProperty property="bookname" name="book"/></br>
	출판사 :<jsp:getProperty property="publisher" name="book"/></br>
	가격 :<jsp:getProperty property="price" name="book"/>
	
</body>
</html>