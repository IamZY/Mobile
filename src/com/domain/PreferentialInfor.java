package com.domain;

public class PreferentialInfor {

	private String id;
	private String charge;
	private String amount;
	private String name;
	

	public PreferentialInfor(String id, String charge, String amount,
			String name) {
		super();
		this.id = id;
		this.charge = charge;
		this.amount = amount;
		this.name = name;
	}
	public PreferentialInfor(String charge, String amount, String name) {
		super();
		this.charge = charge;
		this.amount = amount;
		this.name = name;
	}
	public PreferentialInfor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PreferentialInfor(String charge, String amount) {
		super();
		this.charge = charge;
		this.amount = amount;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
