package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


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

public class customerDAO implements customerDAOIface{

	public boolean findCustomer_User(String sql, String username) {
		boolean result = false;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//String sql = "select * from t_customer where customer_username=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				String tel_numb = rs.getString("tel_numb");
				
				if(tel_numb == null){
					result = false;
				}else{
					result = true;
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps,rs);
		}
		
		return result;
	}

	
	
	public String findCustomer_pwd(String sql, String username) {
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pwd = null;
		try {
			//String sql = "select * from t_customer where customer_username=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			if(rs.next()){		
				pwd = rs.getString("customer_pwd");
					
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps,rs);
		}
		
		return pwd;
	}


	
	public boolean findCustomer_Phone(String sql, String phone) {
		boolean result = false;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
				
		try {
			//String sql = "select * from t_customer where tel_numb=?";
			ps = conn.prepareStatement(sql);			
			ps.setString(1, phone);
			
			rs = ps.executeQuery();
					
			if(rs.next()){
				String customer_username = rs.getString("Customer_username");
							
				if(customer_username == null){
					result = false;
				}else{
					result = true;
				}
				
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		

		return result;
	}



	public boolean addCustomer(String sql,T_Customer customer) {
		boolean result = false;
		
		Connection conn =DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		try {
			/*
			 * 	String customer_username,
				String customer_name, String id_card_numb, int tel_numb,
				Date customer_birthday, String customer_pwd
			 */
				
			//String sql = "insert into T_Customer(Customer_username,Customer_name,Id_card_numb,tel_numb,Customer_birthday,Customer_pwd) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			System.out.println("-----------------");
			ps.setString(1, customer.getCustomer_username());
			ps.setString(2, customer.getCustomer_name());
			ps.setString(3, customer.getId_card_numb());
			ps.setString(4, customer.getTel_numb());
			ps.setDate(5, customer.getCustomer_birthday());
			ps.setString(6, customer.getCustomer_pwd());
			
			
			int i = ps.executeUpdate();
			System.out.println(i);
			if(i > 0){
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, null);
		}
		
		return result;
	}




	public List<Mobile> findMobile(String sql, Mobile mobile,int begin,int end) {
		Connection conn = DbConnectionMgr.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Mobile> list = new ArrayList<Mobile>();
		try {
			
			
			//int end = begin + 5;
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
			ps = conn.prepareStatement(sql);

			ps.setString(1, "%"+mobile.getTelAdd()+"%");
			ps.setString(2, "%"+mobile.getTelAccount());
			ps.setString(3, "%"+mobile.getTelType()+"%");
			ps.setString(4, mobile.getTeldnesg()+"%");
			ps.setString(5, "%"+mobile.getInputstyle()+"%");
			ps.setInt(6, begin);
			ps.setInt(7, end);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				String telNumber = rs.getString("tel_numb");
				String telAdd = rs.getString("Tel_add");
				String amount = rs.getString("acc_init_amount");
					
				Mobile m = new Mobile(telNumber,telAdd,amount);
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		return list;
	}



	public int totalMobile(String sql, Mobile mobile) {
		Connection conn = DbConnectionMgr.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int num = 0;
		try {
			
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
			ps = conn.prepareStatement(sql);

			ps.setString(1, "%"+mobile.getTelAdd()+"%");
			ps.setString(2, "%"+mobile.getTelAccount());
			ps.setString(3, "%"+mobile.getTelType()+"%");
			ps.setString(4, mobile.getTeldnesg()+"%");
			ps.setString(5, "%"+mobile.getInputstyle()+"%");

			
			rs = ps.executeQuery();
			
			if(rs.next()){
				num = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		return num;
	}



	public List<PhonePackage> findPhonePackage(String sql) {
		List<PhonePackage> list = new ArrayList<PhonePackage>();
		
		Connection conn =DbConnectionMgr.getConnection();
		
		Statement st = null;
		ResultSet rs = null;
		int count = 1;
		String liuliang = null;
		String shichang = null;
		try {
			st = conn.createStatement();
			/*String sql = "SELECT b.pp_id,b.business_id,c.business_name,c.short_name,a.pp_name,a.pp_fee" +
						 "FROM t_phone_package a,t_package_business b,t_business_fee c " +
						 "WHERE a.pp_id = b.pp_id AND b.business_id = c.business_id;";*/
			rs = st.executeQuery(sql);
			
			
			while(rs.next()){
				String ppid = rs.getString("pp_id");
				String businessname = rs.getString("business_name");
				String shortname = rs.getString("short_name");
				String ppname = rs.getString("pp_name");
				String fee = rs.getString("pp_fee");
				
				/**
				 * 根据单次和双次的方式来存储流量和时长 单次只存值不传值 双次传值
				 */
				if(count%2 != 0){
					liuliang = shortname;    //存入流量					
					count++;
				}else{
					shichang = shortname;  //存入时长
					//String businessname, String fee, String shortname,String ppname					
					PhonePackage phonepackage = new PhonePackage(ppid,businessname,fee,shortname,ppname.substring(0,5),liuliang,shichang);
					list.add(phonepackage);
					count++;
				}
								
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, st, rs);
		}
		return list;
	}



	public boolean updatePhoneSale(String sql, String telnumb) {
		boolean result = false;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		
		try {
			//String sql = "update t_mobile set is_sale = 1 where tel_numb=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, telnumb);
				
			int i = ps.executeUpdate();
			
			if(i > 0){
				result = true;
			}else {
				result = false;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, null);
		}
		
		return result;
	}



	public T_Customer findCustomer(String sql, String username) {
		Connection conn = DbConnectionMgr.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		T_Customer customer = null;
		try {
			//String sql = "select * from t_customer where customer_username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
				
			rs = ps.executeQuery();
			
			while(rs.next()){
				String name = rs.getString("customer_name");
				String telnumb = rs.getString("tel_numb");
					
				customer = new T_Customer(null,name,null,telnumb,null,null);
		
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
				
		return customer;
	}



	public PreferentialInfor findPreferentialInfor(String sql, String charge) {
		PreferentialInfor infor = null;
		
		Connection conn = DbConnectionMgr.getConnection();
				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//String sql = "select * from T_preferential_infor where tel_charge=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, charge);
			rs = ps.executeQuery();
			
			while(rs.next()){
				String amount = rs.getString("discount_amount");
				String name = rs.getString("Preferential_Name");
				String id = rs.getString("Preferential_id");
				infor = new PreferentialInfor(id,null,amount,name);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
	
		return infor;
	}



	public T_Customer findCustomerName(String sql, String phone) {
		T_Customer customer = null;
		
		Connection conn = DbConnectionMgr.getConnection();		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//String sql = "select * from t_customer where tel_numb=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				String customername = rs.getString("Customer_Name");
				String username = rs.getString("customer_username");
				customer = new T_Customer(username,customername,null,null,null,null);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
			
		}
				
		return customer;
	}



	public boolean insertrechangeinfo(String sql,RechargeInfor infor) {
		boolean result = false;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		try {
			//String sql = "insert into t_recharge_infor(Recharge_infor_id,Tel_numb,Recharge_time,Recharge_type_id,Bank_card_numb,Preferential_id,discount_amount,recharge_money)" +
			//		"value(rechangeinfo_seq.nextval,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, infor.getTelnumb());
			ps.setDate(2, infor.getRechargetime());
			ps.setString(3, infor.getTypeid());
			ps.setString(4, infor.getBankid());
			ps.setString(5, infor.getPreid());
			ps.setString(6, infor.getDisamount());
			ps.setString(7, infor.getRechargemoney());
			
			int i = ps.executeUpdate();
			
			if(i>0){
				result = true;
			}else{
				result = false;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, null);
		}	
		
		return result;
	}



	public RechargeCard findRechargeCard(String sql,String cardid) {
		RechargeCard card = null;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//String sql = "select * from t_recharge_card where card_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cardid);
			rs = ps.executeQuery();
			
			while(rs.next()){
				String id = rs.getString("Card_id"); 
				String available = rs.getString("Is_available");
				String money = rs.getString("Card_charge");
				String pwd = rs.getString("Card_pwd");
				card = new RechargeCard(id,pwd,money,available);		
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		return card;
	}



	public Mobile isMobile(String sql, String phone) {
		Mobile mobile = null;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//String sql = "select * from t_mobile where Tel_numb=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);

			rs = ps.executeQuery();
		
			while(rs.next()){
				String phone1 = rs.getString("tel_numb");
				String teladd = rs.getString("tel_add");
				mobile = new Mobile(phone1,teladd,null);
							
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
				
		return mobile;
	}



	public boolean updatecard(String sql, String cardid) {
		boolean result = true;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		try {
			//String sql = "update T_recharge_card set Is_available=0 where Card_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cardid);
			
			int i = ps.executeUpdate();
			
			if(i > 0){
				result = true;
			}else {
				result = false;
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, null);
		}
		
		return result;
	}



	public boolean insertrechangeinfonline(String sql, RechargeInfor infor) {
		boolean result = false;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		try {
			//String sql = "insert into t_recharge_infor
			//(Recharge_infor_id,Tel_numb,Recharge_time,
			//Recharge_type_id,Card_id,discount_amount,recharge_money)" +
			//"values(rechangeinfo_seq.nextval,?,?,?,?,?,?)";	
			ps = conn.prepareStatement(sql);
			ps.setString(1, infor.getTelnumb());
			ps.setDate(2, infor.getRechargetime());
			ps.setString(3, infor.getTypeid());
			ps.setString(4, infor.getCardid());
			ps.setString(5, infor.getDisamount());
			ps.setString(6, infor.getRechargemoney());
			
			int i = ps.executeUpdate();
			
			if(i>0){
				result = true;
			}else{
				result = false;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, null);
		}	
		
		return result;
	}



	public List<RechargeInfor> findrechargeinfor(String sql, String telnumb,
			int begin, int end) {
		
		List<RechargeInfor> inforList = new ArrayList<RechargeInfor>();		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			//String sql = "SELECT * FROM (SELECT ROWNUM r,A.* FROM (SELECT * FROM t_recharge_infor WHERE tel_numb=? )A)WHERE r>=? AND r<=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, telnumb);
			ps.setInt(2, begin);
			ps.setInt(3, end);
				
			rs = ps.executeQuery();
			String bankid = "";
			String cardid = "";
			String type = "";
			int totalcount = 0;
			int cardcount = 0;
			int bankcount = 0;
			int totalmoney = 0;
			int totaldiscount = 0;
			while(rs.next()){
				Date date = rs.getDate("Recharge_time");
				type = rs.getString("Recharge_type_id");
				
				if(type.equals("1001")){
					type = "在线充值";
				} else if(type.equals("1002")){
					type = "充值卡充值";
				} else if(type.equals("1003")){
					type = "营业厅充值";
				}
				
				
				cardid = rs.getString("Card_id");
				if(cardid == null){
					cardid = "-";
				}else {
					cardid = rs.getString("Card_id");					
					cardcount++;
				}
				bankid = rs.getString("Bank_card_numb");	
				if(bankid == null){
					bankid = "-";
				}else {
					bankid = rs.getString("Bank_card_numb");							
					bankcount++;
				}			
				
				String discount = rs.getString("discount_amount");		
				String money = rs.getString("recharge_money");
					
				totaldiscount += Integer.parseInt(discount);
				totalmoney += Integer.parseInt(money);
				
				
				
				
				RechargeInfor rechargeInfor = new RechargeInfor(date,type,cardid,bankid,discount,money,totalmoney,totaldiscount,cardcount,bankcount);
				inforList.add(rechargeInfor);					

				
				totalcount++;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
		}	
	
		return inforList;
	}



	public int totalrechargeinfor(String sql, String telnumb) {
		Connection conn = DbConnectionMgr.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int num = 0;
		try {
			//String sql = "SELECT count(*) FROM (SELECT ROWNUM r,A.* FROM (SELECT * FROM t_recharge_infor WHERE tel_numb=? )A)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, telnumb);
		
			rs = ps.executeQuery();
			
			if(rs.next()){
				num = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		return num;
	}
	
	
	
	
	
	



	public int totalcurrentrechargeinfor(String sql, String telnumb, int begin,
			int end) {
		int sum = 0;
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			//String sql = "SELECT count(*) FROM (SELECT ROWNUM r,A.* FROM (SELECT * FROM t_recharge_infor WHERE tel_numb=? )A)WHERE r>=? AND r<=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, telnumb);
			ps.setInt(2, begin);
			ps.setInt(3, end);
			rs = ps.executeQuery();
			
			while(rs.next()){
				sum = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
		}	
	
		return sum;
	}



	public List<Business> findbusiness(String sql) {
		List<Business> list = new ArrayList<Business>();
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//String sql = "SELECT * FROM t_business_fee";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			String starttime = "";
			String endtime = "";
			String zifei = "";
			while(rs.next()){
				String bid = rs.getString("business_id");
				String businessname = rs.getString("business_name");
				String shortname = rs.getString("short_name");
				String charge = rs.getString("business_charge");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				//String日期的格式化	
				Date starttimeDate = rs.getDate("start_time");	
				
				if(starttimeDate == null){
					starttime = "-";
				}else {
					starttime = rs.getString("start_time");
				}
				
				Date endtimeDate = rs.getDate("end_time");
				if(endtimeDate == null){
					endtime = "-";
				}else {
					endtime = rs.getString("end_time");
				}
							
				String islargess = rs.getString("is_largess");				
				zifei = charge;
				
				if(islargess == null){
					zifei = charge+"元";
				}else if(islargess.equals("0")){
					zifei = "基础业务";
				}else if(islargess.equals("1")){
					zifei = "赠送业务";
				}
					
				if(endtime.equals("-")){
					endtime = "-";
				}else {
					endtime = sdf.format(endtimeDate);					
				}
				
				if(starttime.equals("-")){
					starttime = "-";
				}else {
					starttime = sdf.format(starttimeDate);
				}
				String isoptional = rs.getString("is_optional");	
				Business business = new Business(bid,businessname,zifei,shortname,charge,isoptional,islargess,starttime,endtime);
							
				list.add(business);
			
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);	
		}
		
		return list;
	}



	public boolean addmobilepackage(String sql, MobilePackage mobilePackage) {
		boolean result = false;
		
		Connection conn =DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		try {
		
			//String sql = "insert into t_mobile_package(TEL_PACKAGE_ID,tel_numb,business_id,start_time) VALUES(mp_seq.nextval,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mobilePackage.getTelnumb());
			ps.setString(2, mobilePackage.getBid());
			ps.setDate(3, mobilePackage.getStarttime());
			
			
			int i = ps.executeUpdate();
			System.out.println(i);
			if(i > 0){
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, null);
		}
		
		return result;
	}



	public PhonePackage findPhonePackagebytel(String sql, String telnumb) {
		PhonePackage p = null;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//String sql = "select DISTINCT tel_numb,a.pp_id,pp_name,pp_fee from t_phone_package a,t_mobile_package b,t_package_business c WHERE a.pp_id = b.pp_id AND tel_numb=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, telnumb);
			
			
			rs = ps.executeQuery();
			if(rs.next()){
				String ppid = rs.getString("pp_id");
				p = new PhonePackage(ppid,null,null,null,null,null,null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
			
		return p;
	}



	public Account findaccount(String sql, String telnumb) {
		Account account  = null;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//String sql = "select * from t_account t WHERE tel_number=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, telnumb);
			rs = ps.executeQuery();
			
			
			while(rs.next()){
				String acc = rs.getString("account_balance");
				account = new Account(null,null,acc);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		return account;
	}



	public boolean addmobilepackage_hb(String sql, MobilePackage mobilePackage) {
		boolean result = false;
		
		Connection conn =DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		try {
		
			//String sql = "insert into t_mobile_package(TEL_PACKAGE_ID,tel_numb,pp_id,start_time) VALUES(mp_seq.nextval,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mobilePackage.getTelnumb());
			ps.setString(2, mobilePackage.getPpid());
			ps.setDate(3, mobilePackage.getStarttime());
			
			
			int i = ps.executeUpdate();
			System.out.println(i);
			if(i > 0){
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, null);
		}
		
		return result;
	}



	public List<MobilePackage> findmobilepackagebytel(String sql, String telnumb) {
		List<MobilePackage> list = new ArrayList<MobilePackage>();
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//String sql = "SELECT * FROM t_mobile_package a WHERE tel_numb=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, telnumb);
			
			rs = ps.executeQuery();
			
			
			while(rs.next()){
				String bid = rs.getString("business_id");
				Date starttime = rs.getDate("start_time");
				Date endtime = rs.getDate("end_time"); 
				
				MobilePackage mobilePackage = new MobilePackage(null,bid,null,starttime,endtime);
				
				list.add(mobilePackage);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		return list;
	}



	public boolean addaccount(String sql,int money, String telnumb) {
		boolean result = false;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		try {
			//String sql = "UPDATE t_account SET account_balance = account_balance+? WHERE tel_number=?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, money);
			ps.setString(2, telnumb);
					
			int i = ps.executeUpdate();
			if(i > 0){
				result = true;
			}
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, null);
		}
		
		return result;
	}



	public boolean updatemobilepackage_end(String sql,MobilePackage mobilePackage) {
		boolean result = false;
		
		Connection conn =DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		try {
		
			ps = conn.prepareStatement(sql);
			ps.setDate(1, mobilePackage.getEndtime());
			ps.setString(2, mobilePackage.getTelnumb());
			ps.setString(3, mobilePackage.getBid());
			
			int i = ps.executeUpdate();
			System.out.println(i);
			if(i > 0){
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, null);
		}
		
		return result;
	}



	public boolean saveaccount(String sql, String telnumb, int money) {
		boolean result = false;
		
		Connection conn = DbConnectionMgr.getConnection();
		PreparedStatement ps = null;
		try {
			//String sql = "insert into t_account(account_id,tel_number,account_balance) values(acc.nextval,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, telnumb);
			ps.setInt(2, money);
			
			
			int i = ps.executeUpdate();
			
			if(i > 0){
				result = true;
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbConnectionMgr.close(conn, ps, null);
		}
		
		return result;
	}


	

	
}
