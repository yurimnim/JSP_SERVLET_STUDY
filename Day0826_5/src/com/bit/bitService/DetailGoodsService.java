package com.bit.bitService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDao;

public class DetailGoodsService implements BitService {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodsDao dao = new GoodsDao();
		int no = Integer.parseInt(request.getParameter("no"));
		request.setAttribute("g", dao.getGoods(no));
		return "detailGoods.jsp";
	}

}
