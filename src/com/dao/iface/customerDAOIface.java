package com.dao.iface;

import java.util.List;

import com.domain.Account;
import com.domain.Business;
import com.domain.Mobile;
import com.domain.MobilePackage;
import com.domain.PhonePackage;
import com.domain.PreferentialInfor;
import com.domain.RechargeCard;
import com.domain.RechargeInfor;
import com.domain.T_Customer;

public interface customerDAOIface {

	/**
	 * 根据账号判断是否存在数据库中
	 * @param sql
	 * @param username
	 * @return
	 */
	public boolean findCustomer_User(String sql,String username);
	
	
	/**
	 * 通过账号 查找对应的密码
	 * @param sql
	 * @param username
	 * @return
	 */
	public String findCustomer_pwd(String sql,String username);
	
	/**
	 * 根据手机号判断是否存在在数据库中
	 * @param sql
	 * @param phone
	 * @return
	 */
	public boolean findCustomer_Phone(String sql,String phone);
	
	/**
	 * 根据注册信息加如数据库
	 * @param customer
	 * @return
	 */
	public boolean addCustomer(String sql,T_Customer customer);
	
	/**
	 * 根据信息查找所需的手机号
	 * @param sql
	 * @param mobile
	 * @return
	 */
	public List<Mobile> findMobile(String sql,Mobile mobile,int begin,int end);
	
	/**
	 * 按需总共的手机号
	 * @param sql
	 * @param mobile
	 * @param begin
	 * @return
	 */
	public int totalMobile(String sql,Mobile mobile);
	
	
	/**
	 * 查询手机套餐
	 * @param sql
	 * @return
	 */
	public List<PhonePackage> findPhonePackage(String sql);
	
	
	/**
	 * 将手机表中的可售改已售
	 * @param sql
	 * @param telnumb
	 * @return
	 */
	public boolean updatePhoneSale(String sql,String telnumb);
	
	
	/**
	 * 通过账号查询 姓名和手机号
	 * @param sql
	 * @param username
	 * @return
	 */
	public T_Customer findCustomer(String sql,String username);

	
	/**
	 * 通过charge 查询 所对应的优惠金额
	 * @param sql
	 * @param charge
	 * @return
	 */
	public PreferentialInfor findPreferentialInfor(String sql,String charge);
	
	
	
	/**
	 * 通过手机号查找姓名
	 * @param sql
	 * @param phone
	 * @return
	 */
	public T_Customer findCustomerName(String sql,String phone); 
	
	
	
	/**
	 * 信息插入到充值信息表中
	 * @param infor
	 * @return
	 */
	public boolean insertrechangeinfo(String sql,RechargeInfor infor);
	
	
	/**
	 * 通过ID 找充值卡号
	 * @param cardid
	 * @return
	 */
	public RechargeCard findRechargeCard(String sql,String cardid);
	
	
	
	/**
	 * 验证手机是否存在手机表中
	 * @param sql
	 * @param phone
	 * @return
	 */
	public Mobile isMobile(String sql,String phone);
	
	
	
	/**
	 * 将充值卡中的已经充值过的卡available 1 -> 0
	 * @param sql
	 * @param cardid
	 * @return
	 */
	public boolean updatecard(String sql,String cardid);
	
	
	/**
	 * 存储充值卡充值的方法
	 * @param sql
	 * @param infor
	 * @return
	 */
	public boolean insertrechangeinfonline(String sql,RechargeInfor infor);


	/**
	 * 通过手机号查询充值信息
	 * @param sql
	 * @param telnumb
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<RechargeInfor> findrechargeinfor(String sql,String telnumb,int begin,int end);


	/**
	 * 查询单个手机所有的信息总数
	 * @param sql
	 * @param telnumb
	 * @return
	 */
	public int totalrechargeinfor(String sql,String telnumb);
	

	/**
	 * 计算每一页充值信息的个数
	 * @param sql
	 * @param telnumb
	 * @param begin
	 * @param end
	 * @return
	 */
	public int totalcurrentrechargeinfor(String sql,String telnumb,int begin,int end);
	
	
	/**
	 * 查询t_business_fee的业务
	 * @return
	 */
	public List<Business> findbusiness(String sql);
	
	
	/**
	 * 通过手机号查询手机已经办理的套餐
	 * @param telnumb
	 * @return
	 */
	public PhonePackage findPhonePackagebytel(String sql,String telnumb);
	
	
	
	/**
	 * 向某个手机套餐表中加入数据
	 * @param mobilePackage
	 * @return
	 */
	public boolean addmobilepackage(String sql,MobilePackage mobilePackage);
	
	
	
	
	
	/**
	 * 通过手机查询手机余额
	 * @param telnumb
	 * @return
	 */
	public Account findaccount(String sql,String telnumb);
	
	
	
	/**
	 * 选号的时候将信息保存到表中
	 * @param sql
	 * @param mobilePackage
	 * @return
	 */
	public boolean addmobilepackage_hb(String sql,MobilePackage mobilePackage);
	
	
	
	
	/**
	 * 往表中加套餐
	 * @param sql
	 * @param telnumb
	 * @return
	 */
	public List<MobilePackage> findmobilepackagebytel(String sql,String telnumb);
	
	
	
	/**
	 * 向表中增加手机话费
	 * @param money
	 * @param telnumb
	 * @return
	 */
	public boolean addaccount(String sql,int money, String telnumb);
	
	
	
	/**
	 * 向套餐中增加结束时间
	 * @param sql
	 * @param mobilePackage
	 * @return
	 */
	public boolean updatemobilepackage_end(String sql,MobilePackage mobilePackage);
	
	
	/**
	 * 将新的手机号的余额信息加到表中
	 * @param sql
	 * @param telnumb
	 * @param money
	 * @return
	 */
	public boolean saveaccount(String sql,String telnumb, int money);
	
}
