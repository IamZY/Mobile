package com.domain;



public class Business {

	private String bid; 
	private String bname;
	private String zifei;
	private String shorttime;
	private String charge;
	private String isoptional;
	private String islarges;
	private String starttime;
	private String endtime;
	public String getBid() {
		return bid;
	}
	public Business(String bid, String bname, String zifei, String shorttime,
			String charge, String isoptional, String islarges,
			String starttime, String endtime) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.zifei = zifei;
		this.shorttime = shorttime;
		this.charge = charge;
		this.isoptional = isoptional;
		this.islarges = islarges;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Business(String bname, String shorttime, String charge,
			String isoptional, String islarges, String starttime, String endtime) {
		super();
		this.bname = bname;
		this.shorttime = shorttime;
		this.charge = charge;
		this.isoptional = isoptional;
		this.islarges = islarges;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getShorttime() {
		return shorttime;
	}
	public void setShorttime(String shorttime) {
		this.shorttime = shorttime;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getIsoptional() {
		return isoptional;
	}
	public void setIsoptional(String isoptional) {
		this.isoptional = isoptional;
	}
	public String getIslarges() {
		return islarges;
	}
	public void setIslarges(String islarges) {
		this.islarges = islarges;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public Business(String bname, String zifei, String shorttime,
			String charge, String isoptional, String islarges,
			String starttime, String endtime) {
		super();
		this.bname = bname;
		this.zifei = zifei;
		this.shorttime = shorttime;
		this.charge = charge;
		this.isoptional = isoptional;
		this.islarges = islarges;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	public String getZifei() {
		return zifei;
	}
	public void setZifei(String zifei) {
		this.zifei = zifei;
	}
	
	
}
