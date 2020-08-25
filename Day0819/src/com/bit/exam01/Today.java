package com.bit.exam01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Today
 */
@WebServlet("/Today")
public class Today extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Today() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date today = new Date();
		int year = today.getYear() + 1900;
		int month = today.getMonth() + 1;
		int date = today.getDate();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String str = "<h3>";
		str += year + "";
		str += "³â ";
		str += month + "";
		str += "¿ù ";
		str += date + "";
		str += "ÀÏ";
		str += "</h3>";
		
		out.print(str);
		out.close();	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
