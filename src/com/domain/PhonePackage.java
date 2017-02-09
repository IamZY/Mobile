package com.domain;

public class PhonePackage {

	private String ppid;
	private String businessname; //business name
	private String fee;  //
	private String shortname;
	private String ppname;  //
	
	//流量
	private String liuliang;
	
	//时长
	private String shichang;
	
	public String getPpid() {
		return ppid;
	}
	public void setPpid(String ppid) {
		this.ppid = ppid;
	}
	public PhonePackage(String ppid, String businessname, String fee,
			String shortname, String ppname, String liuliang, String shichang) {
		super();
		this.ppid = ppid;
		this.businessname = businessname;
		this.fee = fee;
		this.shortname = shortname;
		this.ppname = ppname;
		this.liuliang = liuliang;
		this.shichang = shichang;
	}
	public PhonePackage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhonePackage(String businessname, String fee, String shortname,
			String ppname,String liuliang,String shichang) {
		super();
		this.businessname = businessname;
		this.fee = fee;
		this.shortname = shortname;
		this.ppname = ppname;
		this.liuliang = liuliang;
		this.shichang = shichang;
	}
	public String getBusinessname() {
		return businessname;
	}
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getPpname() {
		return ppname;
	}
	public void setPpname(String ppname) {
		this.ppname = ppname;
	}
	public String getLiuliang() {
		return liuliang;
	}
	public void setLiuliang(String liuliang) {
		this.liuliang = liuliang;
	}
	public String getShichang() {
		return shichang;
	}
	public void setShichang(String shichang) {
		this.shichang = shichang;
	}
	
	
	
	
}
