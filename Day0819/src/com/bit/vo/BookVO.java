package com.bit.vo;

public class BookVO {
	private int bookid;
	private String bookname;
	private String pulisher;
	private int price;
	
	public BookVO(int bookid, String bookname, String pulisher, int price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.pulisher = pulisher;
		this.price = price;
	}

	public BookVO() {
		super();
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPulisher() {
		return pulisher;
	}

	public void setPulisher(String pulisher) {
		this.pulisher = pulisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
