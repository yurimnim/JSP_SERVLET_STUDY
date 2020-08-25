package com.bit.vo;

public class PensionVO {
	private int no;
	private String name;
	private String addr;
	private String tel;
	private int rooms;
	private String facility;
	private String etc;
	
	public PensionVO() {
		super();
	}

	public PensionVO(int no, String name, String addr, String tel, int rooms, String facility, String etc) {
		super();
		this.no = no;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.rooms = rooms;
		this.facility = facility;
		this.etc = etc;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	} 
}
