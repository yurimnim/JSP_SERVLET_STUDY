package com.bit.vo;

import java.sql.Date;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private Date regdate;
	private String content;
	private int hit;
	private String ip;
	private String fname;
	private String pwd;
	
	public BoardVO(int no, String title, String writer, Date regdate, String content, int hit, String ip, String fname,
			String pwd) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.content = content;
		this.hit = hit;
		this.ip = ip;
		this.fname = fname;
		this.pwd = pwd;
	}

	public BoardVO() {
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
