package com.bit.vo;

public class PlantsVO {
	private int no;
	private String name;
	private String info;
	private String fname;
	
	public PlantsVO(int no, String name, String info, String fname) {
		super();
		this.no = no;
		this.name = name;
		this.info = info;
		this.fname = fname;
	}

			
	public PlantsVO() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

}
