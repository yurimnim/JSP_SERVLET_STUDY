package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;
import com.bit.vo.BoardVo;

public class BoardDao {
	
	 public void updateHit(int no) {
		 String sql = "update board set hit=hit+1 where no=?";
		 try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			System.out.println("");
		}
	 }
	
	//최신의 답글을 먼저 출력하기 위해
	//이미 달려있는 답글들의 b_step 을 1씩 증가하는 메소드 정의 
	public void updateStep(int b_ref, int b_step) {
		String sql = "update board set b_step=b_step+1 where b_ref=? b_step>?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_ref);
			pstmt.setInt(2, b_step);
			pstmt.executeUpdate();
			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			System.out.println("updateStep Exception Occured " + e.getMessage());
		}
	}
	
	 public BoardVo getBoards(int no) {
		 BoardVo b = null;
		 try {
			String sql = "select * from board where no=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getDate(6), rs.getInt(7), rs.getInt(8),rs.getInt(9), rs.getInt(10));
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.println("exception occured getBoards " + e.getMessage() );
		}
		 return b;
	 }
	
	//모든 게시물목록을 반환하는 메소드를 정의 
	public ArrayList<BoardVo> listAll() {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		//서로 관련있는 글 끼리 검색하고싶다. 
		//부모글 밑에 자식글 함꼐 출력 희망 
		 String sql = "select * from board order by b_ref desc, b_step";
		 try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getDate(6), rs.getInt(7), rs.getInt(8),rs.getInt(9), rs.getInt(10)));
			}
			
		} catch (Exception e) {
			System.out.println("listAll exception occured " + e.getMessage());		}
		
		return list;
	}
	
	//새로운 글번호를 반환하는 메소드
	public int getNextNo() {
		int n = 0;
		//기존에 있는 글번호 중에 가장 큰 값에 더하기 1을 하여 반환하고 싶다. 
		String sql = "select nvl(max(no),0)+1 from board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("getNextNo exception occured " + e.getMessage());
		}
		return n;
	}
	
	
	
	//글 등록 메소
	public int insertBoard(BoardVo b) {
		int re = -1;
		String sql = "insert into board values(?,?,?,?,?,sysdate,0,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getPwd());
			pstmt.setString(5, b.getContents());
			pstmt.setInt(6, b.getB_ref());
			pstmt.setInt(7, b.getB_level());
			pstmt.setInt(8, b.getB_step());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, pstmt, conn);
			
		} catch (Exception e) {
			System.out.println("insertBoard exception occured: " + e.getMessage());
		}
		
		return re;
		
	}
}
