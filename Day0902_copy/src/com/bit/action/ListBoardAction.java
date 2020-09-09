package com.bit.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.BoardDao;

public class ListBoardAction implements BitAction {
	
	public static int pageSize = 5;
	public static int totalRecord = 0;
	public static int totalPage = 1;
	//한화면에 보여줄 수 있는 페이지 수를 저장하기 위한 변수
	public static int pageMax = 5;
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 판별 
//		String id = (String)request.getSession().getAttribute("id");
//		if(id==null) {
//			return "login.jsp";
//		}
//				
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");

		String sort = "";		
		String cnt = "";
		
		if(request.getParameter("sort")!=null) {
			cnt = "asc";
			
			String firstSort = (String)session.getAttribute("sort");
			String secondSort = request.getParameter("sort");
			
			//아래 기능은 아까와 지금이 같을때에만 동작시키도록 한다. 
			if(firstSort != null && firstSort.equals(secondSort)) {
				if(session.getAttribute("cnt")!=null) {
					cnt = (String)session.getAttribute("cnt");
					if(cnt.contentEquals("desc")) {
						cnt = "asc";
					}else {
						cnt = "desc";
					}
			  }
			}
			sort = request.getParameter("sort");
			session.setAttribute("sort", sort);
			session.setAttribute("cnt", cnt);
		}
		
		if(session.getAttribute("sort")!=null) {
			sort = (String)session.getAttribute("sort");
		
		}

		System.out.println("정렬칼럼:"+sort);
		System.out.println("정렬:"+ cnt);
		System.out.println("정렬방식 " );
		
		int pageNUM = 1;
		if(request.getParameter("pageNUM") != null ) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		
		//검색어(search)가 올수도 있고 오지 않을 수도 있.
		//일단은 search변수를 하나 만들고 ""초기화 
		//만약 검색어가 오면 그 검색어를 search에 담고
		//오지 않으면 ""담아서 Dao에게 보내자!
		
		String search = "";
		String option = "";
		
		if(request.getSession().getAttribute("search") != null) {
			search = (String)session.getAttribute("search");
			option = (String)session.getAttribute("option");
		}
		
		if(request.getParameter("search") != null) {
			search = request.getParameter("search");
			option = (String)request.getParameter("option");
			session.setAttribute("search", search);  
			session.setAttribute("option", option);  
		}
			
		BoardDao dao = new BoardDao();
		totalRecord = dao.getTotalCount(search,option);
		totalPage = (int)Math.ceil( (double)totalRecord/pageSize);
		
		int startPage = (pageNUM-1)/pageMax*pageMax+1;
		// 6,7,8,9,10
		
		int endPage = startPage+pageMax-1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		//만약 현재페이지가 1,2,3,4,5 라면 startPage=1 endPage=5
		//만약 현재페이지가 6,7,8,9,10 라면 startPage=6 endPage=10
		//이되도록 수식을 표현해 보세요.
				
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("list", dao.listAll(pageNUM,search,option,sort,cnt));
		
		String pageStr = "";
		if(startPage > 1) {
			pageStr += "<a href='listBoard.do?pageNUM="+(startPage-1)+"'>[이전]</a>  ";
		}
		
		for(int i=startPage;i<=endPage;i++) {
			pageStr += "<a href='listBoard.do?pageNUM="+i+"'>"+ i + "</a> ";
		}
		
		if(totalPage > endPage) {
			pageStr += "  <a href='listBoard.do?pageNUM="+(endPage+1)+"'>[다음]</a>";
		}
		
		request.setAttribute("pageStr", pageStr);
		
		return "listBoard.jsp";
	}

}
