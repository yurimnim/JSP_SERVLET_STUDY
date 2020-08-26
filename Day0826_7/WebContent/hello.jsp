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
	int cnt = 0;
	cnt++;	
	Cookie []coockies = request.getCookies();
	if(coockies != null) {
		for(Cookie c:coockies) {
			if(c.getName().equals("cnt")){
				Integer.parseInt(c.getValue());
			}
		}
	}
	
	//나머지 코드 완성 

		
	out.print("<h2>" + cnt +"번째 방문입니다.</h2>"); 	
	Cookie cookie = new Cookie("cnt", cnt+"");
	cookie.setMaxAge(60*60*24);
	response.addCookie(cookie);
%>	

</body>
</html>