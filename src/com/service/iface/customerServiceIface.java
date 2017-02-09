package com.service.iface;

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

public interface customerServiceIface {

	/**
	 * 通过数据库查找是否存在与填写账户名相同的username
	 * @param username
	 * @return
	 */
	public boolean findCustomer_User(String username);
	
	
	/**
	 * 通过账号 查找对应的密码
	 * @param username
	 * @return
	 */
	public String findCustomer_pwd(String username);
	
	/**
	 * 通过手机号查找是否存在与填写的手机相同的phone
	 * @param phone
	 * @return
	 */
	public boolean findCustomer_Phone(String phone);
	
	
	/**
	 * 将注册信息加入数据库
	 * @param customer
	 * @return
	 */
	public boolean addCustomer(T_Customer customer);
	
	/**
	 * 通过信息查询符合条件的mobile
	 * @param mobile
	 * @return
	 */
	public List<Mobile> findMobile(Mobile mobile,int currentPage,int pageSize);
	
	/**
	 * 计算按需总共的手机号数量
	 * @param mobile
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public int totalMobile(Mobile mobile);
	
	
	/**
	 * 查询套餐
	 * @return
	 */
	public List<PhonePackage> findPhonePackage();
	
	
	/**
	 * 将手机表中的可售改已售
	 * @param telnumb
	 * @return
	 */
	public boolean updatePhoneSale(String telnumb);
	
	
	
	/**
	 * 通过账号 寻找他的姓名和手机号
	 * @param username
	 * @return
	 */
	public T_Customer findCustomer(String username);
	
	
	/**
	 * 通过charge 查询 所对应的优惠金额
	 * @param charge
	 * @return
	 */
	public PreferentialInfor findPreferentialInfor(String charge);
	
	
	
	/**
	 * 通过手机号查找姓名
	 * @param phone
	 * @return
	 */
	public T_Customer findCustomerName(String phone);
	
	
	/**
	 * 充值信息增加到充值表中
	 * @param infor
	 * @return
	 */
	public boolean insertrechangeinfo(RechargeInfor infor);
	
	
	
	/**
	 * 查询cardid 是否存在
	 * @param cardid
	 * @return
	 */
	public RechargeCard findRechargeCard(String cardid);
	
	
	/**
	 * 手机表中是否存在该手机号
	 * @param phone
	 * @return
	 */
	public Mobile isMobile(String phone);
	
	
	
	/**
	 * 将充值卡表中的available 从1变成0
	 * @param cardid
	 * @return
	 */
	public boolean updatecard(String cardid);
	
	/**
	 * 存储充值卡充值的方法
	 * @param sql
	 * @param infor
	 * @return
	 */
	public boolean insertrechangeinfonline(RechargeInfor infor);



	/**
	 * 通过手机号查询用户的所有充值信息
	 * @param telnumb
	 * @return
	 */
	public List<RechargeInfor> findrechargeinfor(String telnumb,int currentPage,int pageSize);

	/**
	 * 查询单个手机所有的充值信息
	 * @param mobile
	 * @return
	 */
	public int totalrechargeinfor(String telnumb);

	
	
	/**
	 * 计算每一页的总个数
	 * @param telnumb
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public int totalcurrentrechargeinfor(String telnumb,int currentPage,int pageSize);
	
	
	
	/**
	 * 查询t_business_fee的业务
	 * @return
	 */
	public List<Business> findbusiness();
	
	
	/**
	 * 通过手机号查询手机已经办理的套餐
	 * @param telnumb
	 * @return
	 */
	public PhonePackage findPhonePackagebytel(String telnumb);
	
	
	
	/**
	 * 向某个手机套餐表中加入数据(起始时间)
	 * @param mobilePackage
	 * @return
	 */
	public boolean addmobilepackage(MobilePackage mobilePackage);
	
	
	
	
	/**
	 * 通过手机查询手机余额
	 * @param telnumb
	 * @return
	 */
	public Account findaccount(String telnumb);
	
	
	
	/**
	 * 选号的时候将信息保存到表中
	 * @param sql
	 * @param mobilePackage
	 * @return
	 */
	public boolean addmobilepackage_hb(MobilePackage mobilePackage);
	
	
	
	
	/**
	 * 通过手机查询该手机号已经办理的套餐
	 * @param telnumb
	 * @return
	 */
	public List<MobilePackage> findmobilepackagebytel(String telnumb); 
	
	
	
	/**
	 * 将account表中对应手机号的金额增加
	 * @param money
	 * @return
	 */
	public boolean addaccount(int money,String telnumb);
	
	
	
	/**
	 * 向某个手机套餐表中加入数据 结束时间
	 * @param mobilePackage
	 * @return
	 */
	public boolean updatemobilepackage_end(MobilePackage mobilePackage);
	
	
	
	
	/**
	 * 往account中增加一条用户的记录
	 * @param telnumb
	 * @param money
	 * @return
	 */
	public boolean saveaccount(String telnumb,int money);
}
