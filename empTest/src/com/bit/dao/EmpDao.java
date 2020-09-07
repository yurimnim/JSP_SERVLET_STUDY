package com.bit.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.bit.action.ListEmpAction;
import com.bit.db.ConnectionProvider;
import com.bit.vo.EmpVo;

import oracle.net.aso.r;

public class EmpDao {
	
	private static EmpDao dao;
	
	private EmpDao() {
		
	}
	
	public static EmpDao getInstance() {
		if(dao ==null) {
			dao = new EmpDao();
		}
		return dao;
	}
	
	 public ArrayList<EmpVo> listAll(int pageNUM, String search, String option, String op, String sort){
	
		 int end = pageNUM* ListEmpAction.pageSize;
		 int start = end - (ListEmpAction.pageSize-1);
		 
		 ArrayList<EmpVo> list = new ArrayList<EmpVo>();
		 String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from "
		 		+ "(select rownum n, empno,ename,job,mgr, to_char(hiredate,'yyyy-mm-dd')hiredate, sal,comm,deptno from (select * from emp";
		 
		 if(!search.equals("")) {
			 if(option.equals("sal")) {
				 sql += " where sal " + op + search; 
			 } else {
				 sql += " where "+ option + " like '%" + search +"%'";
			 }
		 }
		 
		 if(!sort.equals("")) {
			 sql += " order by " + sort +" desc)) " + "where n between ? and ?";
		 }else {
			 sql += ")) " + "where n between ? and ?";
		 }
			 
		 try {
			 Connection conn = ConnectionProvider.getConnection();
			 PreparedStatement pstmt  = conn.prepareStatement(sql);
			 pstmt.setInt(1, start);
			 pstmt.setInt(2, end);
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 list.add(new EmpVo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),
						 rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8)));
			 }
			 ConnectionProvider.close(rs, pstmt, conn);
			
		} catch (Exception e) {
			System.out.println("listAll 예외발생 " + e.getMessage());
		}
		 return list;
	 }
	 
	 
	 public int countTotal(String search, String option, String op) {
		 int n = 0;
		 String sql = "select count(*) from emp";
		 
		 if(!search.equals("")) {
			 if(option.equals("sal")) {
				 sql += " where sal " + op + search; 
			 } else {
				 sql += " where " + option + " like '%" + search +"%' ";
			 }
		 }

		 try {
			 Connection conn = ConnectionProvider.getConnection();
			 Statement stmt  = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
			 while(rs.next()) {
				 n = rs.getInt(1);
			 }
			 ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("countTotal 예외발생 " + e.getMessage());
		}
		 return n;
		 
	 }
	 
	 public int insertEmp(EmpVo e) {
		 int re = -1;
		 try {
			String sql="insert into emp values(?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, e.getEmpno());
			pstmt.setString(2, e.getEname());
			pstmt.setString(3, e.getJob());
			pstmt.setInt(4, e.getMgr());
			pstmt.setString(5, e.getHiredate());
			pstmt.setInt(6, e.getSal());
			pstmt.setInt(7, e.getComm());
			pstmt.setInt(8, e.getDeptno());
			
			re = pstmt.executeUpdate();			
			ConnectionProvider.close(null, pstmt, conn); 
		} catch (Exception e2) {
			System.out.println("insertEmp 예외발생 " + e2.getMessage());
		}	 
		 return re;
	 }
}
