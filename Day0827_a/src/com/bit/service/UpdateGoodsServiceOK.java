package com.bit.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDao;
import com.bit.vo.GoodsVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateGoodsServiceOK implements BitService {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getRealPath("upload");
		System.out.println("path:"+path);
		MultipartRequest multi = new MultipartRequest(request, 
				path, 1024*1024*10, "utf-8", 
				new DefaultFileRenamePolicy());
		
		String oldFname = multi.getParameter("oldFname");
		GoodsVo g = new GoodsVo();
		g.setNo(Integer.parseInt(multi.getParameter("no")));
		g.setName(multi.getParameter("name"));
		g.setPrice(Integer.parseInt(multi.getParameter("price")));
		g.setQty(Integer.parseInt(multi.getParameter("qty")));
		g.setFname(oldFname);
		
		String fname = null;
		File file = multi.getFile("fname");
		if(file != null) {
			fname= file.getName();
			g.setFname(fname);
		}
		GoodsDao dao = new GoodsDao();
		int re = dao.updateGoods(g);
		if(re>0 && fname != null) {
			File f = new File(path + "/" + oldFname);
			f.delete();
		}
		
		request.setAttribute("re", re);
		return "updateGoodsOK.jsp";
	}

}
