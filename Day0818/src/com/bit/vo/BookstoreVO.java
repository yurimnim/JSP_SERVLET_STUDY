package com.bit.vo;

public class BookstoreVO {
	private int no;
	private String publisher;
	private String title;
	private int price;
	private int parcel;
	private String author; 
	private String fname;
	
	public BookstoreVO(int no, String publisher, String title, int price, int parcel, String author, String fname) {
		super();
		this.no = no;
		this.publisher = publisher;
		this.title = title;
		this.price = price;
		this.parcel = parcel;
		this.author = author;
		this.fname = fname;
	}

	public BookstoreVO() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getParcel() {
		return parcel;
	}

	public void setParcel(int parcel) {
		this.parcel = parcel;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

}
