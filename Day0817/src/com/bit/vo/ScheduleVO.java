package com.bit.vo;


public class ScheduleVO {
	int no; 
	int year;
	int month;
	int day; 
	String content;
	
	public ScheduleVO() {
		super();
	}

	public ScheduleVO(int no, int year, int month, int day, String content) {
		super();
		this.no = no;
		this.year = year;
		this.month = month;
		this.day = day;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
	
}
