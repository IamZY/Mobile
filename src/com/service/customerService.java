package com.service;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;



import com.dao.customerDAO;
import com.dao.iface.customerDAOIface;
import com.db.DbConnectionMgr;
import com.domain.Account;
import com.domain.Business;
import com.domain.Mobile;
import com.domain.MobilePackage;
import com.domain.PhonePackage;
import com.domain.PreferentialInfor;
import com.domain.RechargeCard;
import com.domain.RechargeInfor;
import com.domain.T_Customer;
import com.service.iface.customerServiceIface;
import com.sun.crypto.provider.RSACipher;
import com.sun.faces.lifecycle.UpdateModelValuesPhase;
import com.sun.org.apache.regexp.internal.recompile;



public class customerService implements customerServiceIface {

	private customerDAOIface customerdao;
	public customerService(){
		customerdao = new customerDAO();
	}
	
	
	public boolean findCustomer_User(String username) {
		String sql = "select * from t_customer where customer_username=?";
		return customerdao.findCustomer_User(sql, username);
	}

	
	
	public String findCustomer_pwd(String username) {
		
		String sql = "select * from t_customer where customer_username=?";
		return customerdao.findCustomer_pwd(sql, username);
	
	}
	
	
	public boolean findCustomer_Phone(String phone) {
		
		String sql = "select * from t_customer where tel_numb=?";
		return customerdao.findCustomer_Phone(sql, phone);
	}
	
	public boolean addCustomer(T_Customer customer) {
		
		String sql = "insert into T_Customer(Customer_id,Customer_username,Customer_name,Id_card_numb,tel_numb,Customer_birthday,Customer_pwd) values(customer_seq.nextval,?,?,?,?,?,?)";
		return customerdao.addCustomer(sql, customer);
	}
	
	
	public List<Mobile> findMobile(Mobile mobile,int currentPage,int pageSize) {
		
		int begin = (currentPage - 1)*pageSize + 1;
		int end = begin + pageSize - 1;
		/*
		String sql = "SELECT * " +
		 "FROM (SELECT ROWNUM r,A.*" +
		 		"FROM (  SELECT * " +
		 				"FROM t_mobile " +
		 				"where Tel_add=? and acc_init_amount=? AND Tel_type=? AND tel_numb LIKE ? AND tel_numb LIKE ?" +
		 			  ")A " +
		 	   ")" +
		 "WHERE r>=? AND r<=?";
		*/
		String sql = "SELECT * " +
				"FROM (SELECT ROWNUM r,A.* " +
					   "FROM (  SELECT * " +
					   			"FROM t_mobile" +
					   			" WHERE Tel_add LIKE ? and acc_init_amount LIKE ? AND Tel_type LIKE ? AND tel_numb LIKE ? AND tel_numb LIKE ? AND is_sale='0'" +
					   			")A" +
					   	") " +
				" WHERE r>=? AND r<=?";
		
		
		
		return customerdao.findMobile(sql, mobile,begin,end);
		
	}

	public int totalMobile(Mobile mobile) {
		
		String sql = "SELECT COUNT(*) " +
					 "FROM (SELECT ROWNUM r,A.*" +
					 		"FROM (  SELECT * FROM t_mobile " +
					 				"WHERE Tel_add LIKE ? and acc_init_amount LIKE ? AND Tel_type LIKE ? AND tel_numb LIKE ? AND tel_numb LIKE ? AND is_sale='0'" +
					 		")A" +
					 ") ";
		
		return customerdao.totalMobile(sql, mobile);
	}
	
	
	
	public List<PhonePackage> findPhonePackage() {
		
		String sql = "SELECT b.pp_id,b.business_id,c.business_name,c.short_name,a.pp_name,a.pp_fee " +
						 "FROM t_phone_package a,t_package_business b,t_business_fee c " +
						 "WHERE a.pp_id = b.pp_id AND b.business_id = c.business_id";
	
		return customerdao.findPhonePackage(sql);
	}
	
	
	public boolean updatePhoneSale(String telnumb) {
		
		String sql = "update t_mobile set is_sale = 1 where tel_numb=?";
			
		return customerdao.updatePhoneSale(sql, telnumb);
	}

	
	public T_Customer findCustomer(String username) {
		String sql = "select * from t_customer where customer_username=?";
		return customerdao.findCustomer(sql, username);
		
	}

	
	public PreferentialInfor findPreferentialInfor(String charge) {
	
		String sql = "select * from T_preferential_infor where tel_charge=?";
		
		return customerdao.findPreferentialInfor(sql, charge);

	}
	
	
	
	public T_Customer findCustomerName(String phone) {

		String sql = "select * from t_customer where tel_numb=?";
	
		return customerdao.findCustomerName(sql, phone);
	}
	
	
	public boolean insertrechangeinfo(RechargeInfor infor) {

		String sql = "insert into t_recharge_infor(Recharge_infor_id,Tel_numb,Recharge_time,Recharge_type_id,Bank_card_numb,Preferential_id,discount_amount,recharge_money)" +
					"values(rechangeinfo_seq.nextval,?,?,?,?,?,?,?)";	
		return customerdao.insertrechangeinfo(sql, infor);
	}
	
	public RechargeCard findRechargeCard(String cardid) {

		String sql = "select * from t_recharge_card where card_id=?";
	
		return customerdao.findRechargeCard(sql, cardid);
	}
	
	

	public Mobile isMobile(String phone) {

		String sql = "select * from t_mobile where Tel_numb=?";			
		return customerdao.isMobile(sql, phone);
	}
	
	
	public boolean updatecard(String cardid) {

		String sql = "update T_recharge_card set Is_available=0 where Card_id=?";
	
		return customerdao.updatecard(sql, cardid);
	}

	public boolean insertrechangeinfonline(RechargeInfor infor) {
		String sql = "insert into t_recharge_infor(Recharge_infor_id,Tel_numb,Recharge_time,Recharge_type_id,Card_id,discount_amount,recharge_money)" +
		"values(rechangeinfo_seq.nextval,?,?,?,?,?,?)";	
		return customerdao.insertrechangeinfonline(sql, infor);
	}

	
	
	public List<RechargeInfor> findrechargeinfor(String telnumb,int currentPage,int pageSize) {
		
		int begin = (currentPage - 1)*pageSize + 1;
		int end = begin + pageSize - 1;

		String sql = "SELECT * FROM (SELECT ROWNUM r,A.* FROM (SELECT * FROM t_recharge_infor WHERE tel_numb=? )A)WHERE r>=? AND r<=?";
	
		return customerdao.findrechargeinfor(sql, telnumb, begin, end);
	}
	
	
	
	public int totalrechargeinfor(String telnumb) {
	
		String sql = "SELECT count(*) FROM (SELECT ROWNUM r,A.* FROM (SELECT * FROM t_recharge_infor WHERE tel_numb=? )A)";
		
		return customerdao.totalrechargeinfor(sql, telnumb);
	}
	
	
	public int totalcurrentrechargeinfor(String telnumb, int currentPage,
			int pageSize) {
		int begin = (currentPage - 1)*pageSize + 1;
		int end = begin + pageSize - 1;
		String sql = "SELECT count(*) FROM (SELECT ROWNUM r,A.* FROM (SELECT * FROM t_recharge_infor WHERE tel_numb=? )A)WHERE r>=? AND r<=?";
	
		return customerdao.totalcurrentrechargeinfor(sql, telnumb, begin, end);
	}
	
	public List<Business> findbusiness() {
	
		String sql = "SELECT * FROM t_business_fee";

		return customerdao.findbusiness(sql);
	}
	


	public PhonePackage findPhonePackagebytel(String telnumb) {

		String sql = "select DISTINCT tel_numb,a.pp_id,pp_name,pp_fee from t_phone_package a,t_mobile_package b,t_package_business c WHERE a.pp_id = b.pp_id AND tel_numb=?";
	
		return customerdao.findPhonePackagebytel(sql, telnumb);
		
	}

	
	public boolean addmobilepackage(MobilePackage mobilePackage) {
		
		String sql = "insert into t_mobile_package(TEL_PACKAGE_ID,tel_numb,business_id,start_time) VALUES(mp_seq.nextval,?,?,?)";

		return customerdao.addmobilepackage(sql, mobilePackage);
	
	}
	
	
	
	public Account findaccount(String telnumb) {

		String sql = "select * from t_account t WHERE tel_number=?";
	
		return customerdao.findaccount(sql, telnumb);
	}
	

	
	public boolean addmobilepackage_hb(MobilePackage mobilePackage) {
	
		String sql = "insert into t_mobile_package(TEL_PACKAGE_ID,tel_numb,pp_id,start_time) VALUES(mp_seq.nextval,?,?,?)";
	
		return customerdao.addmobilepackage_hb(sql, mobilePackage);
	}
	
	
	
	
	public List<MobilePackage> findmobilepackagebytel(String telnumb) {
		
		String sql = "SELECT * FROM t_mobile_package a WHERE tel_numb=?";
	
		return customerdao.findmobilepackagebytel(sql, telnumb);
	}
	
	
	
	public boolean addaccount(int money, String telnumb) {
		
		String sql = "UPDATE t_account SET account_balance = account_balance+? WHERE tel_number=?";
	
		return customerdao.addaccount(sql, money, telnumb);
	}
	
	
	public boolean updatemobilepackage_end(MobilePackage mobilePackage) {
		
		String sql = "UPDATE t_mobile_package SET end_time=? WHERE tel_numb=? and business_id=?";
		
		return customerdao.updatemobilepackage_end(sql, mobilePackage);
	}
	
	
	
	public boolean saveaccount(String telnumb, int money) {
	
		String sql = "insert into t_account(account_id,tel_number,account_balance) values(acc.nextval,?,?)";
		
		return customerdao.saveaccount(sql, telnumb, money);
	}

	
	
	
	public static void main(String[] args) {
		customerService c = new customerService();
		Mobile mobile = new Mobile();
		mobile.setTelAdd("南通");
		mobile.setTelAccount("");
		mobile.setTeldnesg("");
		mobile.setTelType("");
		mobile.setInputstyle("");
//		List<Mobile> list = c.findMobile(mobile, 1, 6);
//		for(Mobile m : list){
//			System.out.println(m.getTelNumber() + "::" + m.getTelAdd() + "::" + m.getTelAccount());
//		}
//		System.out.println(c.totalMobile(mobile));
		
		//System.out.println(":");
		
//		List<PhonePackage> list = c.findPhonePackage();
//		List list1 = new ArrayList();
//		List list2 = new ArrayList();
//		for(PhonePackage p : list){
//			System.out.println(p.getShortname());
//			
			/*if(p.getShortname().contains("M") == true || p.getShortname().contains("G") == true){
				list1.add(p.getShortname());
			}else{
				list2.add(p.getShortname());
			}
		}	
		

		System.out.println(list1.toString());
		System.out.println(list2.toString());*/
		
		
		//c.updatePhoneSale("13456544356");
		
//		T_Customer customer = c.findCustomer("1213042021");
//		System.out.println(customer.getCustomer_name());
//		System.out.println(customer.getTel_numb());
		
		
//		PreferentialInfor preferentialInfor = c.findPreferentialInfor("50");
//		System.out.println(preferentialInfor.getAmount());
//		System.out.println(preferentialInfor.getName());
//		System.out.println(preferentialInfor.getId());
//		
//		T_Customer customer = c.findCustomerName("13023565305");
//		System.out.println(customer.getCustomer_name());
		
		//RechargeInfor infor = new RechargeInfor("15329138121",d,"1001",null,"11111111111111111","1002",discount,value);	
		//c.insertrechangeinfo(infor);
		
//		RechargeCard card = c.findRechargeCard("2015028802");
//		System.out.println(card.getAvailable());
		
		//mobile = c.isMobile("13851545129");
		//System.out.println(mobile.getTelAdd());
		
		
		//System.out.println(c.updatecard("2015018801"));
		
//		List<RechargeInfor> list = c.findrechargeinfor("13456375432", 1, 4);
//		for(RechargeInfor infor : list){
//			System.out.println(infor.getRechargetime() + "::" + infor.getCardid() + "::" + infor.getBankid() + "::" 
//					+ infor.getTypeid() + "::" + infor.getBankid() + "::"
//					+ infor.getBankcount() + "::" + infor.getCardid() + "::" 
//					+ infor.getCardcount() + "::" + infor.getTotalmoney() + "::" + infor.getTotaldiscount());
//		}
//		
//		System.out.println(c.totalrechargeinfor("13456375432"));
//		
//		System.out.println(c.totalcurrentrechargeinfor("13456375432", 2, 4));
		
		
//		List<Business> list = c.findbusiness();
//		
//		for(Business business : list){
//			System.out.println(business.getBid() + ":::" +business.getBname() + ":::" + business.getZifei() + ":::" + business.getStarttime() + ":::" + business.getEndtime() + ":::" + business.getIsoptional());
//		}
//		
//		PhonePackage p = c.findPhonePackagebytel("15329138121");
//
//		System.out.println(p.getPpid());	
		

//		Account account = c.findaccount("13023565305");
//		System.out.println(account.getAccount());
//		
//		List<MobilePackage> list = c.findmobilepackagebytel("13456375432");
//		for(MobilePackage mobilePackage : list){
//			System.out.println(mobilePackage.getBid() + "::::" + mobilePackage.getStarttime());
//			
//		}
		
		
		//c.addaccount(100, "13023565305");
		
		//获取系统当前时间
//		Date date = new Date();
//		DateFormat format = new SimpleDateFormat("dd-MM-yy");
//		String time = format.format(date);
//		
//		//String->sql.date
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
//		java.sql.Date d;
//		try {
//			d = new java.sql.Date(sdf.parse(time).getTime());
//			System.out.println("-------------");
//			System.out.println(d); //系统当前的时间
//		
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		MobilePackage mobilePackage = new MobilePackage("13456375432","1019",null,null,d);
//		c.updatemobilepackage_end(mobilePackage);
		
		
		
	}


	

	

}
