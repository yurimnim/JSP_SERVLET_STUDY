<%@page import="com.bit.vo.BookstoreVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.BookstoreDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS -->
<style>
 * {
 	font-family: 'Noto Sans KR';
 	font-weight: 300px;
 }
 
 h3 {
 	margin: 0;
 	padding 0;
 }
 
 ul {
 	list-style: none;
 }
 
 img {
	height: 120px;
 	width: 100px;
 }
 
 #main_title{
 	margin: 10px;
 	padding-bottom: 6px;
 	border-bottom: solid 2px #aaaaaa;
 }

.list_item {
	clear: both;
	height: 130px;
	margin: 10px;
	border-bottom: solid 1px #cccccc;
}

.image {
	float: left;
	width: 100px;
}

.intro {
	float: left;
	width: 300px;
	margin-left: 20px;
}

.price{
	float: left;
	width: 150px;
	margin-top: 1.8px;
}

.red {
	font-weight: 500px;
	color: red;
}

.small {
	font-size: 12px;
	margin-top: 5px;
}

.writer {
	float: left;
	width: 100px;
}


</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- Essensial JAVA  -->
<%
BookstoreDAO dao = new BookstoreDAO();
ArrayList<BookstoreVO> list = dao.listAll();
%>

<h3 id='main_title'>판매 도서 목록</h3>
<div>
<%	
	for(BookstoreVO v:list) {
%>
	<div class ='list_item'>
		<div class ='image'><img src = "img/<%=v.getFname()%>"></div>
		<div class ='intro'>[<%=v.getPublisher() %>] <%=v.getTitle() %></div>
		<ul class='price'>
			<li class ='red'><%=v.getPrice() %>원</li>
			<li class = 'small'>배송비 <%= v.getParcel()%>원</li>
		</ul>
		<div class = 'writer'><%=v.getAuthor() %> 저</div>
	</div>
		<%
		} 
		%>
	
</div>	
</body>
</html>