package com.domain;

import java.sql.Date;

public class MobilePackage {

	private String telnumb;
	private String bid;
	private String ppid;
	private Date starttime;
	private Date endtime;
	public MobilePackage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MobilePackage(String telnumb, String bid, String ppid,
			Date starttime, Date endtime) {
		super();
		this.telnumb = telnumb;
		this.bid = bid;
		this.ppid = ppid;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	public String getTelnumb() {
		return telnumb;
	}
	public void setTelnumb(String telnumb) {
		this.telnumb = telnumb;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getPpid() {
		return ppid;
	}
	public void setPpid(String ppid) {
		this.ppid = ppid;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
	
	
	
	
}
