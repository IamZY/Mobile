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
	 * �����˺��ж��Ƿ�������ݿ���
	 * @param sql
	 * @param username
	 * @return
	 */
	public boolean findCustomer_User(String sql,String username);
	
	
	/**
	 * ͨ���˺� ���Ҷ�Ӧ������
	 * @param sql
	 * @param username
	 * @return
	 */
	public String findCustomer_pwd(String sql,String username);
	
	/**
	 * �����ֻ����ж��Ƿ���������ݿ���
	 * @param sql
	 * @param phone
	 * @return
	 */
	public boolean findCustomer_Phone(String sql,String phone);
	
	/**
	 * ����ע����Ϣ�������ݿ�
	 * @param customer
	 * @return
	 */
	public boolean addCustomer(String sql,T_Customer customer);
	
	/**
	 * ������Ϣ����������ֻ���
	 * @param sql
	 * @param mobile
	 * @return
	 */
	public List<Mobile> findMobile(String sql,Mobile mobile,int begin,int end);
	
	/**
	 * �����ܹ����ֻ���
	 * @param sql
	 * @param mobile
	 * @param begin
	 * @return
	 */
	public int totalMobile(String sql,Mobile mobile);
	
	
	/**
	 * ��ѯ�ֻ��ײ�
	 * @param sql
	 * @return
	 */
	public List<PhonePackage> findPhonePackage(String sql);
	
	
	/**
	 * ���ֻ����еĿ��۸�����
	 * @param sql
	 * @param telnumb
	 * @return
	 */
	public boolean updatePhoneSale(String sql,String telnumb);
	
	
	/**
	 * ͨ���˺Ų�ѯ �������ֻ���
	 * @param sql
	 * @param username
	 * @return
	 */
	public T_Customer findCustomer(String sql,String username);

	
	/**
	 * ͨ��charge ��ѯ ����Ӧ���Żݽ��
	 * @param sql
	 * @param charge
	 * @return
	 */
	public PreferentialInfor findPreferentialInfor(String sql,String charge);
	
	
	
	/**
	 * ͨ���ֻ��Ų�������
	 * @param sql
	 * @param phone
	 * @return
	 */
	public T_Customer findCustomerName(String sql,String phone); 
	
	
	
	/**
	 * ��Ϣ���뵽��ֵ��Ϣ����
	 * @param infor
	 * @return
	 */
	public boolean insertrechangeinfo(String sql,RechargeInfor infor);
	
	
	/**
	 * ͨ��ID �ҳ�ֵ����
	 * @param cardid
	 * @return
	 */
	public RechargeCard findRechargeCard(String sql,String cardid);
	
	
	
	/**
	 * ��֤�ֻ��Ƿ�����ֻ�����
	 * @param sql
	 * @param phone
	 * @return
	 */
	public Mobile isMobile(String sql,String phone);
	
	
	
	/**
	 * ����ֵ���е��Ѿ���ֵ���Ŀ�available 1 -> 0
	 * @param sql
	 * @param cardid
	 * @return
	 */
	public boolean updatecard(String sql,String cardid);
	
	
	/**
	 * �洢��ֵ����ֵ�ķ���
	 * @param sql
	 * @param infor
	 * @return
	 */
	public boolean insertrechangeinfonline(String sql,RechargeInfor infor);


	/**
	 * ͨ���ֻ��Ų�ѯ��ֵ��Ϣ
	 * @param sql
	 * @param telnumb
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<RechargeInfor> findrechargeinfor(String sql,String telnumb,int begin,int end);


	/**
	 * ��ѯ�����ֻ����е���Ϣ����
	 * @param sql
	 * @param telnumb
	 * @return
	 */
	public int totalrechargeinfor(String sql,String telnumb);
	

	/**
	 * ����ÿһҳ��ֵ��Ϣ�ĸ���
	 * @param sql
	 * @param telnumb
	 * @param begin
	 * @param end
	 * @return
	 */
	public int totalcurrentrechargeinfor(String sql,String telnumb,int begin,int end);
	
	
	/**
	 * ��ѯt_business_fee��ҵ��
	 * @return
	 */
	public List<Business> findbusiness(String sql);
	
	
	/**
	 * ͨ���ֻ��Ų�ѯ�ֻ��Ѿ�������ײ�
	 * @param telnumb
	 * @return
	 */
	public PhonePackage findPhonePackagebytel(String sql,String telnumb);
	
	
	
	/**
	 * ��ĳ���ֻ��ײͱ��м�������
	 * @param mobilePackage
	 * @return
	 */
	public boolean addmobilepackage(String sql,MobilePackage mobilePackage);
	
	
	
	
	
	/**
	 * ͨ���ֻ���ѯ�ֻ����
	 * @param telnumb
	 * @return
	 */
	public Account findaccount(String sql,String telnumb);
	
	
	
	/**
	 * ѡ�ŵ�ʱ����Ϣ���浽����
	 * @param sql
	 * @param mobilePackage
	 * @return
	 */
	public boolean addmobilepackage_hb(String sql,MobilePackage mobilePackage);
	
	
	
	
	/**
	 * �����м��ײ�
	 * @param sql
	 * @param telnumb
	 * @return
	 */
	public List<MobilePackage> findmobilepackagebytel(String sql,String telnumb);
	
	
	
	/**
	 * ����������ֻ�����
	 * @param money
	 * @param telnumb
	 * @return
	 */
	public boolean addaccount(String sql,int money, String telnumb);
	
	
	
	/**
	 * ���ײ������ӽ���ʱ��
	 * @param sql
	 * @param mobilePackage
	 * @return
	 */
	public boolean updatemobilepackage_end(String sql,MobilePackage mobilePackage);
	
	
	/**
	 * ���µ��ֻ��ŵ������Ϣ�ӵ�����
	 * @param sql
	 * @param telnumb
	 * @param money
	 * @return
	 */
	public boolean saveaccount(String sql,String telnumb, int money);
	
}
