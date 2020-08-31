package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BoardDao;
import com.bit.vo.BoardVo;

public class InsertBoardOkAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardVo b = new BoardVo();
		//일단 새글은 (부모글) 이라 보고 처리하도록 한다
		//b_ref는 글번호와 동일하게 처리 
		//b_level d은 0으로 설정
		//b_step은 0으로 설정
		BoardDao dao = new BoardDao();
		
		//boarddao 를 통해 새로운 글번호를 얻어와서 변수 no 에 저장 
		int no = dao.getNextNo();
		
		//일단은 새글이라는 전제하에 
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;
		
		//답글인지 새글인지 처리 
		int pno = Integer.parseInt(request.getParameter("no"));
		
		//답글처리인지 판별
		if(pno != 0) {
			BoardVo p = dao.getBoards(pno);
			b_ref = p.getB_ref();
			b_level = p.getB_level();
			b_step = p.getB_step();
			
			//이미 달려있는 답글들에 대한 b_step 을 1씩 증가시키는 메소드를 호출한다. 
			dao.updateStep(b_ref, b_step);
			
			b_level++;
			b_step++;
		}
		
		
		//사용자가 입력한 담겨진 request 로부터 vo에 담는다. 
		b.setNo(no);
		b.setTitle(request.getParameter("title"));
		b.setWriter(request.getParameter("writer"));
		b.setPwd(request.getParameter("pwd"));
		b.setContents(request.getParameter("contents"));
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		
		int re = dao.insertBoard(b);
		request.setAttribute("re", re);
		return "insertBoardOk.jsp";
	}

}
