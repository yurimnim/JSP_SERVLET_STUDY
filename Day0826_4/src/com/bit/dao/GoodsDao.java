package com.bit.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.GoodsVo;

public class GoodsDao {
	
	public int updateGoods(GoodsVo g) {
		int re = -1;
		String sql = "update goods set name=?, price=?,qty=?,fname=? where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,g.getName());
			pstmt.setInt(2, g.getPrice());
			pstmt.setInt(3, g.getQty());
			pstmt.setString(4, g.getFname());
			pstmt.setInt(5, g.getNo());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("updateGoods 예외발생 " + e.getMessage());
		}
		return re;	
	}
	
	
	public int deleteGoods(int no) {
		int re = -1;
		String sql = "delete goods where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			re = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteGoods 예외발생 " + e.getMessage());
		}
		return re;
	}
	
	
	public GoodsVo getGoods(int no) {
		GoodsVo g = null;
		String sql = "select * from goods where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				g = new GoodsVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return g;
	}
	
	public ArrayList<GoodsVo> listAll() {
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		String sql = "select * from goods";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new GoodsVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("listall 예외발생 " + e.getMessage());
		}
		return list;
	}
	
	public int insertGoods(GoodsVo g) {
		int re = -1;
		try {
			String sql = "insert into goods(no,name,price,qty,fname) values(?,?,?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setInt(3, g.getPrice());
			pstmt.setInt(4, g.getQty());
			pstmt.setString(5, g.getFname());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("insert goods 예외발생" + e.getMessage());
		}
		return re;
	}

}
