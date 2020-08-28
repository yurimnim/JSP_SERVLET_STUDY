package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BookVo;

public class BookDao {
	public int deleteBook(int bookid) {
		int re = -1;
		String sql = "delete book where bookid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();		
			re = stmt.executeUpdate(sql);
			ConnectionProvider.close(conn, stmt, null);			
		} catch (Exception e) {
			System.out.println("deleteBook 예외발생 " + e.getMessage());
		}
		
		return re;
	}
	
	public int updateBook(int bookid, String bookname, String publisher, int price) {
		int re = -1;
		String sql = "update book set bookname=?, publisher=?, price=? where bookid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, bookname);
			pstmt.setString(2, publisher);
			pstmt.setInt(3, price);
			pstmt.setInt(4, bookid);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return re;
	}
	
	public int insertBook(int bookid, String bookname, String publisher, int price) {
		int re = -1;
		String sql = "insert into book values(?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			pstmt.setString(2, bookname);
			pstmt.setString(3, publisher);
			pstmt.setInt(4, price);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return re;
	}
	
	
	public BookVo getBook(int bookid) {
		BookVo b = null;
		String sql = "select * from book where bookid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			pstmt.setInt(1, bookid);
			if(rs.next()) {
				b = new BookVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("getBook 예외발생 " + e.getMessage());
		}
		
		return b;
	}
	
	
	public ArrayList<BookVo> listAll() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		String sql = "select * from book";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BookVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			ConnectionProvider.close(conn, stmt, rs);			
		} catch (Exception e) {
			System.out.println("listAll 예외발생 " + e.getMessage());
		}
		
		return list;
	}
	
}
