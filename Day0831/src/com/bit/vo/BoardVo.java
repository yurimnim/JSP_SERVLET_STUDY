package com.bit.vo;

import java.sql.Date;

public class BoardVo {
	private int no;
	private String title;
	private String writer;
	private String pwd;
	private String contents;
	private Date regdate;
	private int hit;
	private int b_ref;
	private int b_level;
	private int b_step;
	
	public BoardVo(int no, String title, String writer, String pwd, String contents, Date regdate, int hit, int b_ref,
			int b_level, int b_step) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.pwd = pwd;
		this.contents = contents;
		this.regdate = regdate;
		this.hit = hit;
		this.b_ref = b_ref;
		this.b_level = b_level;
		this.b_step = b_step;
	}

	public BoardVo() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getB_ref() {
		return b_ref;
	}

	public void setB_ref(int b_ref) {
		this.b_ref = b_ref;
	}

	public int getB_level() {
		return b_level;
	}

	public void setB_level(int b_level) {
		this.b_level = b_level;
	}

	public int getB_step() {
		return b_step;
	}

	public void setB_step(int b_step) {
		this.b_step = b_step;
	}
	
	
	
	
	
}	