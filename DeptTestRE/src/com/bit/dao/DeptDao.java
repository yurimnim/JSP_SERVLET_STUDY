package com.bit.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.bit.db.ConnectionProvider;
import com.bit.vo.DeptVo;

public class DeptDao {
	
	public int deleteDept(int deptno) {
		int re = -1;
		try {
			String sql = "delete dept where deptno=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, deptno);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("delete dept 예외발생 " + e.getMessage());
		}
		return re;
	}
		
	public int updateDept(DeptVo d) {
		int re = -1;
		try {
			String sql = "update dept set dname=?, loc=? where deptno=? ";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, d.getDname());
			pstmt.setString(2, d.getLoc());
			pstmt.setInt(3, d.getDeptno());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("update dept 예외발생 " + e.getMessage());
		}
		return re;
	}
	
	public int insertDept(DeptVo d) {
		int re = -1;
		try {
			String sql = "insert into dept values(?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDeptno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getLoc());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("insertdept 예외발생 " + e.getMessage());
		}
		return re;
	}
	
	public DeptVo getDept(int deptno) {
		DeptVo d = null;
		String sql = "select * from dept where deptno=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				d = new DeptVo(rs.getInt(1), rs.getString(2),  rs.getString(3));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("getdept 예외발생 " + e.getMessage());
		}
		return d;
	}
	
	public ArrayList<DeptVo> listAll () {
		ArrayList<DeptVo> list = new ArrayList<DeptVo>();
		Connection conn = ConnectionProvider.getConnection();
		String sql = "select * from dept";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("listall 예외발생 " + e.getMessage());
		}		
		return list;
	}
}
