<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	body {
	 font-family: 'Noto Sans KR';
	}
</style>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<form action="loginOk.do" method="post">
	ID: <input type="text" name="id"><br>
	PWD: <input type="password" name="pwd"><br>
<input type="submit" value="확인">
</form>
</body>
</html>