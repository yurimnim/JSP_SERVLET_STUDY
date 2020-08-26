package com.bit.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit.dao.GoodsDao;
import com.bit.vo.GoodsVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InsertGoods
 */
@WebServlet("/insertGoods.do")
public class InsertGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("insertGoods.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("upload");
		System.out.println("path: " + path);
		
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*10, "utf-8",new DefaultFileRenamePolicy());
		GoodsVo g = new GoodsVo();
		g.setNo(Integer.parseInt(multi.getParameter("no")));
		g.setPrice(Integer.parseInt(multi.getParameter("price")));
		g.setQty(Integer.parseInt(multi.getParameter("qty")));
		g.setName(multi.getParameter("name"));
		g.setFname(multi.getFile("fname").getName());
		
		GoodsDao dao = new GoodsDao();
		int re = dao.insertGoods(g);
		request.setAttribute("re", re);
		RequestDispatcher dispatcher = request.getRequestDispatcher("insertGoodsOK.jsp");
		dispatcher.forward(request, response);
		
//		if(re>0) {
//			response.sendRedirect("listGoods.do");
//		} else {
//			request.setAttribute("msg", "상품등록에 실패하였습니다");
//			request.getRequestDispatcher("error.jsp");
//			dispatcher.forward(request, response);
//		}
		
	}

}
