package com.bit.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit.action.EmpAction;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("*.do")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, EmpAction> map;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, EmpAction>();
		String path = config.getServletContext().getRealPath("WEB-INF");
		try {
			FileReader fr = new FileReader(path + "/emp.properties");
			Properties prop = new Properties();
			prop.load(fr);
			Iterator keyList = prop.keySet().iterator();
			
			while(keyList.hasNext()) {
				String key = (String)keyList.next();
				String clsName = (String)prop.get(key);
				EmpAction obj = (EmpAction)Class.forName(clsName).newInstance();
				map.put(key, obj);				
			}
			fr.close();
		} catch (Exception e) {
			System.out.println("init exception: " + e.getMessage());			
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proRequest(request,response);
	}


	private void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		EmpAction action= map.get(cmd);
		String viewPage = action.pro(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
