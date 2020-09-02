package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BoardDao;

public class ListBoardAction implements BitAction {
	
	public static int pageSize = 10;
	public static int totalRecord = 0;
	public static int totalPage = 1;
	//한화면에 보여줄 수 있는 페이지 수를 저장하기 위한 변수
	public static int pageMax = 5;
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNUM = 1;
		if(request.getParameter("pageNUM") !=null) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}

		BoardDao dao = new BoardDao();
		totalRecord = dao.getTotalCount();
		
		if(request.getParameter("pageNUM") !=null) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		totalPage = (int)Math.ceil((double)totalRecord/pageSize); 
		
		int startPage = (pageNUM -1)/pageMax*pageMax +1;		
		int endPage = startPage + pageMax - 1;
		
		//만약 현재페이지가 1,2,3,4,5 라면 startpage =1 end = 5
		//만약 현재페이지가 6,7,8,9,10 이라면 startpage =6 end=10이 되도록 수식을 표현해 보자. 
//		
//		if(totalPage>pageMax) {
//			startPage = totalPage/pageMax + 1;
//			
//			if(totalPage%pageMax == 0) {
//				endPage = (totalPage/pageMax) * 2;
//			} else {
//				endPage = totalPage;
//			}
//		}

		request.setAttribute("totalPage", totalPage);		
		request.setAttribute("list", dao.listAll(pageNUM));
		
		String pageStr = "";
		
		if(startPage > 1) {
			pageStr +="<a href='listBoard.do?pageNUM=" + (startPage-1) + "'>[이전]..</a>";
		}
		
		for (int i=startPage;i<=endPage; i++) {
				pageStr += "<a href='listBoard.do?pageNUM=" + i + "'>" + i + "  " + "</a>";
		}
		
		if(totalPage>endPage) {
			pageStr += " <a href='listBoard.do?pageNUM="+ (endPage+1) + "'>..[다음]</a>";
		}
		
		request.setAttribute("pageStr", pageStr);
		
		return "listBoard.jsp";
	}

}
