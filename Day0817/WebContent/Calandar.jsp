<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
	table,td,th {
		font-family: '맑은 고딕';
		border: 1px solid black;
	}
	
	table {
		border-collapse: collapse;
		width: 610px;
		font-size: 12px;
		margin-top: 15px;
	}
	
	th {
		height: 20px;
		background-color
	}
	
	#day {
		color: red;	
	}	
	
	tr {
		height: 60px;
		vertical-align: top;
	}
	
	td {
		width: 76px;
		padding: 5px;
	}
	
	h3 {
		font-family: '맑은 고딕';
		border-left: 8px solid blue;
		padding: 10px;
	}
	
</style>
<title>Insert title here</title>
</head>
<body>
<%
	int []lastDay = {31,28,31,30,31,30,31,31,30,31,30,31};

	Date today = new Date();
	int year = today.getYear();
	int month = today.getMonth();
	
	Date startDay = new Date(year, month, 1);
	int yoil= startDay.getDay();
	
%>
<h3>나의 일정</h3>
<table>
	<tr>
		<td colspan='7' align='right'>◀ <%=year+1900 %>년 <%= month+1 %>월 ▶</td>
	</tr>
	<tr id = 'day'>
		<th class ='sun'>일</th>
		<th>월</th>
		<th>화</th>
		<th>수</th>
		<th>목</th>
		<th>금</th>
		<th>토</th>
	</tr>
	<tr>
		<%
			//날짜를 출력하기 전에 그달의 1일의 요일의 숫자 만큼 빈칸을 출력
			//만약 8월 1일이 토요일이면 6만큼 빈칸(아무글자가 
			//		없는  <td></td>)을 출력해야 합니다!
			for(int j=1; j<=yoil; j++){
				if( (j+yoil)%7 !=1)
				%>
					<td>&nbsp;</td>
				<% else 
					%><td class = 'sun'>&nbsp;</td>
			<% 
			}
		
			for(int i=1;i<=lastDay[month];i++){
				%>
					<td><%=i %></td>
				<%
				if( (i+yoil) % 7 ==0){
					%>
					</tr><tr>
					<%					
				}				
			}
		%>
	</tr>
</table>
</body>
</html>