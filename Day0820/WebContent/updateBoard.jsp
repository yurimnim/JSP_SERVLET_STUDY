<%@page import="com.bit.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.BoardDAO"%>
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
int no = Integer.parseInt(request.getParameter("no"));
BoardDAO dao = new BoardDAO();
BoardVO b = dao.getBoard(no, false);

%>

<h2>게시물 수정</h2>

   <hr>
   <form action="updateBoardOk.jsp" method="post">
       <input type="hidden" name="no" value="<%=no%>">
      글제목 : <input type="text" name="title" value="<%=b.getTitle()%>"><br>   
      작성자 : <%=b.getWriter() %> <br>
      글내용 : <br>
      <textarea rows="10" cols="60" name="content"><%=b.getContent() %></textarea><br>
      <input type="submit" value="수정">   
   </form>

</body>
</html>