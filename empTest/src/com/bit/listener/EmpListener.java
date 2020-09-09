package com.bit.listener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bit.dao.EmpDao;
import com.bit.vo.EmpVo;

/**
 * Application Lifecycle Listener implementation class EmpListener
 *
 */
@WebListener
public class EmpListener implements ServletContextListener {
	
	EmpDao dao = EmpDao.getInstance();
    /**
     * Default constructor. 
     */
    public EmpListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
        dao.deleteEmpTable();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         dao.createEmpTable();
         String path = sce.getServletContext().getRealPath("WEB-INF");
         try {
			BufferedReader br = new BufferedReader(new FileReader(path + "/emp.txt"));
			while(true) {
				String line=br.readLine().trim(); 
				if(line==null) {
					break;
				}
				EmpVo ev = new EmpVo();
				StringTokenizer st = new StringTokenizer(line, ",");
				ev.setEmpno(Integer.parseInt(st.nextToken()));
				ev.setEname(st.nextToken());
				ev.setJob(st.nextToken());
				ev.setMgr(Integer.parseInt(st.nextToken()));
				ev.setHiredate(st.nextToken());
				ev.setSal(Integer.parseInt(st.nextToken()));
				ev.setComm(Integer.parseInt(st.nextToken()));
				ev.setDeptno(Integer.parseInt(st.nextToken()));
				dao.insertEmp(ev);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("contextInitialized 예외발생 " + e.getMessage());
		}
    }
	
}
