package com.bit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.EmpVO;

public class EmpDAO {
	
	public int deleteEmp(int no) {
		int re = -1;
		String sql = "delete emp where no =?";
		try {
		  Connection conn = ConnectionProvider.getConnection();
		  
			
		} catch (Exception e) {
			System.out.println("deleteEmp 예외발생" + e.getMessage() );
		}
		
		return re; 
	}
	
	
	public ArrayList<EmpVO> listAll() {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		String sql = "select * from emp order by empno desc";		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new EmpVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("listAll 예외발생 " + e.getMessage());
		}		
		return list;
	}

	public int insertEmp(EmpVO ev) {
		int re=-1;
		String sql = "insert into emp values(?,?,?,?,sysdate,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ev.getEmpno());
			pstmt.setString(2, ev.getEname());
			pstmt.setString(3, ev.getJob());
			pstmt.setInt(4, ev.getMgr());
			pstmt.setInt(5, ev.getSal());
			pstmt.setInt(6, ev.getComm());
			pstmt.setInt(7, ev.getDeptno());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("insert emp" + e.getMessage());
		}
		
		return re;
	}
}
