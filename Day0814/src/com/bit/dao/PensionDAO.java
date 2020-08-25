package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.bit.db.ConnectionProvider;
import com.bit.vo.PensionVO;

public class PensionDAO {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	
	public ArrayList<PensionVO> serchPension(String searchfield, String keyword){
		ArrayList<PensionVO> list = new ArrayList<PensionVO>();
		try {
			String sql = "select * from pension where "+ searchfield +" like '%" + keyword + "%'";
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PensionVO vo = new PensionVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5), rs.getString(6), rs.getString(7));
				list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("search pension 예외발생 " + e.getMessage());
		}
		return list;
	}
	
	public PensionVO getPension(int no) {
		PensionVO p = null;
		try {
			String sql ="select * from pension where no=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				p  = new PensionVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7));
			}			 
			ConnectionProvider.close(conn, pstmt, rs);			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return p;
			
	}

}
