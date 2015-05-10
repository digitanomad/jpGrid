package com.digitanomad.gridtest.dto;

public class UserDto {

	private int id;
	private String name;
	private String company;
	private String startdate;
	private String cardnum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", company=" + company
				+ ", startdate=" + startdate + ", cardnum=" + cardnum + "]";
	}
	
}
