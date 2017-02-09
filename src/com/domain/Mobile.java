package com.domain;


public class Mobile {

	private String telNumber;
	private String telType;
	private String telAdd;
	private String telAccount;
	private String teldnesg;
	private char sale;
	private String inputstyle;
	
	
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(String teldnesg, String telType, String telAdd,
			String telAccount,String inputstyle) {
		super();
		this.teldnesg = teldnesg;
		this.telType = telType;
		this.telAdd = telAdd;
		this.telAccount = telAccount;
		this.inputstyle = inputstyle;
	}
	
	
	public Mobile(String telNumber,String telAdd,String telAccount){
		this.telNumber = telNumber;
		this.telAdd = telAdd;
		this.telAccount = telAccount;
	}
	
	
	public String getTeldnesg() {
		return teldnesg;
	}
	public void setTeldnesg(String teldnesg) {
		this.teldnesg = teldnesg;
	}
	
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getTelType() {
		return telType;
	}
	public void setTelType(String telType) {
		this.telType = telType;
	}
	public String getTelAdd() {
		return telAdd;
	}
	public void setTelAdd(String telAdd) {
		this.telAdd = telAdd;
	}
	
	public String getTelAccount() {
		return telAccount;
	}
	public void setTelAccount(String telAccount) {
		this.telAccount = telAccount;
	}
	
	public char getSale() {
		return sale;
	}
	public void setSale(char sale) {
		this.sale = sale;
	}
	public String getInputstyle() {
		return inputstyle;
	}
	public void setInputstyle(String inputstyle) {
		this.inputstyle = inputstyle;
	}
	
	
	
	
}
