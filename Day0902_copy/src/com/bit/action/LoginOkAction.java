package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.bit.dao.MemberDao;

public class LoginOkAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberDao dao = MemberDao.getInstance();
		int re= dao.isMember(id, pwd);
		request.setAttribute("re", re);
		if(re == 1) {			
			request.getSession().setAttribute("id", id);
			//request.setAttribute("id", id);
		}
		return "loginOk.jsp";
	}

}
