package com.domain;

import java.sql.Date;

public class RechargeInfor {

	private String telnumb;
	private Date rechargetime;
	private String typeid;
	private String cardid;
	private String bankid;
	private String preid;
	private String disamount;
	private String rechargemoney;
	
	private int totalmoney;
	private int totaldiscount;
	private int cardcount;
	private int bankcount;
	
	public int getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(int totalmoney) {
		this.totalmoney = totalmoney;
	}
	public int getTotaldiscount() {
		return totaldiscount;
	}
	public void setTotaldiscount(int totaldiscount) {
		this.totaldiscount = totaldiscount;
	}
	public int getCardcount() {
		return cardcount;
	}
	public void setCardcount(int cardcount) {
		this.cardcount = cardcount;
	}
	public int getBankcount() {
		return bankcount;
	}
	public void setBankcount(int bankcount) {
		this.bankcount = bankcount;
	}
	public RechargeInfor(Date rechargetime, String typeid, String cardid,
			String bankid, String disamount, String rechargemoney,
			int totalmoney, int totaldiscount, int cardcount, int bankcount) {
		super();
		this.rechargetime = rechargetime;
		this.typeid = typeid;
		this.cardid = cardid;
		this.bankid = bankid;
		this.disamount = disamount;
		this.rechargemoney = rechargemoney;
		this.totalmoney = totalmoney;
		this.totaldiscount = totaldiscount;
		this.cardcount = cardcount;
		this.bankcount = bankcount;
	}
	public RechargeInfor(Date rechargetime, String typeid, String cardid,
			String bankid, String disamount, String rechargemoney) {
		super();
		this.rechargetime = rechargetime;
		this.typeid = typeid;
		this.cardid = cardid;
		this.bankid = bankid;
		this.disamount = disamount;
		this.rechargemoney = rechargemoney;
	}
	public RechargeInfor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RechargeInfor(String telnumb, Date rechargetimetime, String typeid,
			String cardid, String bankid, String preid, String disamount,
			String rechargemoney) {
		super();
		this.telnumb = telnumb;
		this.rechargetime = rechargetimetime;
		this.typeid = typeid;
		this.cardid = cardid;
		this.bankid = bankid;
		this.preid = preid;
		this.disamount = disamount;
		this.rechargemoney = rechargemoney;
	}
	public String getTelnumb() {
		return telnumb;
	}
	public void setTelnumb(String telnumb) {
		this.telnumb = telnumb;
	}
	public Date getRechargetime() {
		return rechargetime;
	}
	public void setRechargetime(Date rechargetime) {
		this.rechargetime = rechargetime;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	public String getPreid() {
		return preid;
	}
	public void setPreid(String preid) {
		this.preid = preid;
	}
	public String getDisamount() {
		return disamount;
	}
	public void setDisamount(String disamount) {
		this.disamount = disamount;
	}
	public String getRechargemoney() {
		return rechargemoney;
	}
	public void setRechargemoney(String rechargemoney) {
		this.rechargemoney = rechargemoney;
	}
	
	
	
	
	
	
	
	
}
