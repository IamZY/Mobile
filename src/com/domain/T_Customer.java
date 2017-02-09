package com.domain;

import java.sql.Date;



public class T_Customer {

	private int customer_id;
	private String customer_username;
	private String customer_name;
	private String Id_card_numb;
	private String tel_numb;
	//private Date customer_birthday;
	private Date customer_birthday;
	private String customer_email;
	private String customer_pwd;
	public T_Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public T_Customer(String customer_username, String customer_name,
			String id_card_numb, String tel_numb, Date customer_birthday,
			String customer_pwd) {
		super();
		this.customer_username = customer_username;
		this.customer_name = customer_name;
		Id_card_numb = id_card_numb;
		this.tel_numb = tel_numb;
		this.customer_birthday = customer_birthday;
		this.customer_pwd = customer_pwd;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_username() {
		return customer_username;
	}
	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getId_card_numb() {
		return Id_card_numb;
	}
	public void setId_card_numb(String id_card_numb) {
		Id_card_numb = id_card_numb;
	}
	public String getTel_numb() {
		return tel_numb;
	}
	public void setTel_numb(String tel_numb) {
		this.tel_numb = tel_numb;
	}
	public Date getCustomer_birthday() {
		return customer_birthday;
	}
	public void setCustomer_birthday(Date customer_birthday) {
		this.customer_birthday = customer_birthday;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_pwd() {
		return customer_pwd;
	}
	public void setCustomer_pwd(String customer_pwd) {
		this.customer_pwd = customer_pwd;
	}
	
	
}