<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>부서수정</h2>
	<form action="updateDeptOk.do" method="post">
		부서번호:${d.deptno }
		<input type="hidden" name="deptno" value="${d.deptno }"><br>
		부서이름:<input type="text" name="dname" value="${d.dname }"><br>
		부서위치:<input type="text" name="loc" value="${d.loc }"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>