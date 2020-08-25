<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="joinOK.jsp" method="post">
		이름:<input type="text" name="name"><br>
		취미: 
		<input type="checkbox" name="hb" value="플라잉요가"> 플라잉 요가
		<input type="checkbox" name="hb" value="수영"> 수영
		<input type="checkbox" name="hb" value="마라톤"> 마라톤
		<input type="checkbox" name="hb" value="노래부르기"> 노래부르기
		<input type="checkbox" name="hb" value="영화감상"> 영화감상
		<input type="checkbox" name="hb" value="독서"> 독서 <br>
		좋아하는 음식:
		<select name ="food" multiple="multiple" >
			<option value="치킨">치킨</option>
			<option value="피자">피자</option>
			<option value="고기">고기</option>
			<option value="팥빙수">팥빙수</option>
			<option value="곤드레쌈밥">곤드레쌈밥</option>
		</select>
		<input type="submit" value="확인">
	</form>
</body>
</html>