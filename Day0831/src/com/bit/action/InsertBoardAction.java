package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBoardAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//새글일때는 아무것도 값도 안오지만
		//답글일떄는 부모글의 글번호가 no로 전달된다. 
		
		//일단 새글이라 보고 0으로 설정 
		int no = 0; 
		
		//만약 답글 작성이라면, 즉 파라메터로  전달된 no 의 값이있다면
		//정수로 변환하여 no 에 저
		if(request.getParameter("no") !=null) {
			no = Integer.parseInt(request.getParameter("no"));
		}
		
		//이렇게 정해진 no값을 상태유지하고 view 페이지로 이동 
		request.setAttribute("no", no);
		
		return "insertBoard.jsp";
	}

}
