package com.domain;

public class RechargeCard {

	private String id;
	private String pwd;
	private String charge;
	private String available;
	
	
	public RechargeCard(String id, String pwd, String charge, String available) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.charge = charge;
		this.available = available;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public RechargeCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RechargeCard(String id, String pwd, String charge) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.charge = charge;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	
	
	
}
