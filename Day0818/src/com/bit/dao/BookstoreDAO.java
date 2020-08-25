package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BookstoreVO;

public class BookstoreDAO {
	Connection conn;
	String sql="";

	public ArrayList<BookstoreVO> listAll() {
		ArrayList<BookstoreVO> list = new ArrayList<BookstoreVO>();
		conn = ConnectionProvider.getConnection();
		sql = "select * from bookstore";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BookstoreVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("listAll 예외발생 " + e.getMessage());
		}
		return list;	
	}
	
//	public BookstoreVO getBook(int no) {
//		conn = ConnectionProvider.getConnection();
//		sql = "select * from bookstore where no=?";
//		BookstoreVO bv = null;
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, no);
//			ResultSet rs = pstmt.executeQuery(sql);
//			while(rs.next()) {
//				new BookstoreVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(5), rs.getString(6));
//			}
//			ConnectionProvider.close(conn, pstmt, rs);
//		} catch (Exception e) {
//			System.out.println("getbook 예외발생 " + e.getMessage());
//		}
//		return bv;
//	}
}
