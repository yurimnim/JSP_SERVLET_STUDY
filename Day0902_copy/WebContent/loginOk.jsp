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
	</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${re==1 }">
		${id } 님 로그인 성공
	</c:if>

	<c:if test="${re==0 }">
		<font color="red"><b>로그인실패: 비밀번호를 확인하세요. </b></font>
	</c:if>
	
	<c:if test="${re==-1 }">
		<font color="red"><b>로그인실패: 아이디를 확인하세요. </b></font>
	</c:if>
<br>
<hr>
<a href="listBoard.do">게시물목록</a>
</body>
</html>