package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.bit.db.ConnectionProvider;
import com.bit.vo.PlantsVO;

public class PlantsDAO {
	Connection conn;
	
	public ArrayList<PlantsVO> listAll() {
		ArrayList<PlantsVO> list = new ArrayList<PlantsVO>();
		conn = ConnectionProvider.getConnection();
		String sql = "select * from plants";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new PlantsVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));				
			}
			ConnectionProvider.close(conn, stmt, rs);			
		} catch (Exception e) {
			System.out.println("listAll 예외발생 " + e.getMessage());
		}
		return list;		
	}
	
	public PlantsVO getPlants(int no) {
		PlantsVO p = null;
		String sql = "select * from plants where no = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				 p = new PlantsVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}				
			ConnectionProvider.close(conn, pstmt, rs);		
		} catch (Exception e) {
			System.out.println("getPlants 예외발생 " + e.getMessage());
		}
		return p;
	}
}
