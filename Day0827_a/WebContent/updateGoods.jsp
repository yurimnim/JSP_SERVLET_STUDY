<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품수정</h2>
	<form action="updateGoodsOK.do" method="post" enctype="multipart/form-data">
		상품번호: ${g.no }<br>
		상품이름: <input type="text" name="name" value="${g.name }"><br>
		상품가격: <input type="text" name="price" value="${g.price }"><br>
		상품수량: <input type="text" name="qty" value="${g.qty }"><br>
		<img src="upload/${g.fname }" width="50" height="50"><br>
		<input type="hidden" name="oldFname" value="${g.fname }">
		상품사진 : <input type="file" name="fname"><br>
		<input type="submit" value="확인">
		<input type="reset" value="취소">
	</form>
</body>
</html>