package com.bit.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDao;

public class DeleteGoodsService implements BitService {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		GoodsDao dao = new GoodsDao();
		String oldFname = dao.getGoods(no).getFname();
		int re = dao.deleteGoods(no);
		if(re>0) {
			String path = request.getRealPath("upload");
			File file = new File(path +"/"+oldFname);
			file.delete();
		}
		request.setAttribute("re", re);
		return "deleteGoodsOK.jsp";		
	}

}
