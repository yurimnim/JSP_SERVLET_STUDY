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
		BoardDao dao = new BoardDao();
		
		int no = dao.getNextNo();
		
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;
		
		int paraNo = Integer.parseInt(request.getParameter("no"));
		
		if(paraNo>0) {
			BoardVo p = dao.getBoards(paraNo);
			b_ref = p.getB_ref();
			b_level = p.getB_level();
			b_step = p.getB_step();
			
			dao.updateStep(b_ref, b_step);
			
			b_level++;
			b_step++;		
		}
		
		b.setNo(no);
		b.setTitle(request.getParameter("title"));
		b.setWriter(request.getParameter("writer"));
		b.setPwd(request.getParameter("pwd"));
		b.setContents(request.getParameter("content"));
		b.setB_ref(b_ref);
		b.setB_ref(b_level);
		b.setB_step(b_step);
		int re = dao.insertBoard(b);
		request.setAttribute("re", re);
		
		return "insertBoardOk.jsp";
	}

}
