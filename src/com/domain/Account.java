package com.domain;

public class Account {

	private String id;
	private String tel_numb;
	private String account;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String id, String tel_numb, String account) {
		super();
		this.id = id;
		this.tel_numb = tel_numb;
		this.account = account;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTel_numb() {
		return tel_numb;
	}
	public void setTel_numb(String tel_numb) {
		this.tel_numb = tel_numb;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
	
	
	
}
