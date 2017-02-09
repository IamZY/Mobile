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
	 * ͨ�����ݿ�����Ƿ��������д�˻�����ͬ��username
	 * @param username
	 * @return
	 */
	public boolean findCustomer_User(String username);
	
	
	/**
	 * ͨ���˺� ���Ҷ�Ӧ������
	 * @param username
	 * @return
	 */
	public String findCustomer_pwd(String username);
	
	/**
	 * ͨ���ֻ��Ų����Ƿ��������д���ֻ���ͬ��phone
	 * @param phone
	 * @return
	 */
	public boolean findCustomer_Phone(String phone);
	
	
	/**
	 * ��ע����Ϣ�������ݿ�
	 * @param customer
	 * @return
	 */
	public boolean addCustomer(T_Customer customer);
	
	/**
	 * ͨ����Ϣ��ѯ����������mobile
	 * @param mobile
	 * @return
	 */
	public List<Mobile> findMobile(Mobile mobile,int currentPage,int pageSize);
	
	/**
	 * ���㰴���ܹ����ֻ�������
	 * @param mobile
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public int totalMobile(Mobile mobile);
	
	
	/**
	 * ��ѯ�ײ�
	 * @return
	 */
	public List<PhonePackage> findPhonePackage();
	
	
	/**
	 * ���ֻ����еĿ��۸�����
	 * @param telnumb
	 * @return
	 */
	public boolean updatePhoneSale(String telnumb);
	
	
	
	/**
	 * ͨ���˺� Ѱ�������������ֻ���
	 * @param username
	 * @return
	 */
	public T_Customer findCustomer(String username);
	
	
	/**
	 * ͨ��charge ��ѯ ����Ӧ���Żݽ��
	 * @param charge
	 * @return
	 */
	public PreferentialInfor findPreferentialInfor(String charge);
	
	
	
	/**
	 * ͨ���ֻ��Ų�������
	 * @param phone
	 * @return
	 */
	public T_Customer findCustomerName(String phone);
	
	
	/**
	 * ��ֵ��Ϣ���ӵ���ֵ����
	 * @param infor
	 * @return
	 */
	public boolean insertrechangeinfo(RechargeInfor infor);
	
	
	
	/**
	 * ��ѯcardid �Ƿ����
	 * @param cardid
	 * @return
	 */
	public RechargeCard findRechargeCard(String cardid);
	
	
	/**
	 * �ֻ������Ƿ���ڸ��ֻ���
	 * @param phone
	 * @return
	 */
	public Mobile isMobile(String phone);
	
	
	
	/**
	 * ����ֵ�����е�available ��1���0
	 * @param cardid
	 * @return
	 */
	public boolean updatecard(String cardid);
	
	/**
	 * �洢��ֵ����ֵ�ķ���
	 * @param sql
	 * @param infor
	 * @return
	 */
	public boolean insertrechangeinfonline(RechargeInfor infor);



	/**
	 * ͨ���ֻ��Ų�ѯ�û������г�ֵ��Ϣ
	 * @param telnumb
	 * @return
	 */
	public List<RechargeInfor> findrechargeinfor(String telnumb,int currentPage,int pageSize);

	/**
	 * ��ѯ�����ֻ����еĳ�ֵ��Ϣ
	 * @param mobile
	 * @return
	 */
	public int totalrechargeinfor(String telnumb);

	
	
	/**
	 * ����ÿһҳ���ܸ���
	 * @param telnumb
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public int totalcurrentrechargeinfor(String telnumb,int currentPage,int pageSize);
	
	
	
	/**
	 * ��ѯt_business_fee��ҵ��
	 * @return
	 */
	public List<Business> findbusiness();
	
	
	/**
	 * ͨ���ֻ��Ų�ѯ�ֻ��Ѿ�������ײ�
	 * @param telnumb
	 * @return
	 */
	public PhonePackage findPhonePackagebytel(String telnumb);
	
	
	
	/**
	 * ��ĳ���ֻ��ײͱ��м�������(��ʼʱ��)
	 * @param mobilePackage
	 * @return
	 */
	public boolean addmobilepackage(MobilePackage mobilePackage);
	
	
	
	
	/**
	 * ͨ���ֻ���ѯ�ֻ����
	 * @param telnumb
	 * @return
	 */
	public Account findaccount(String telnumb);
	
	
	
	/**
	 * ѡ�ŵ�ʱ����Ϣ���浽����
	 * @param sql
	 * @param mobilePackage
	 * @return
	 */
	public boolean addmobilepackage_hb(MobilePackage mobilePackage);
	
	
	
	
	/**
	 * ͨ���ֻ���ѯ���ֻ����Ѿ�������ײ�
	 * @param telnumb
	 * @return
	 */
	public List<MobilePackage> findmobilepackagebytel(String telnumb); 
	
	
	
	/**
	 * ��account���ж�Ӧ�ֻ��ŵĽ������
	 * @param money
	 * @return
	 */
	public boolean addaccount(int money,String telnumb);
	
	
	
	/**
	 * ��ĳ���ֻ��ײͱ��м������� ����ʱ��
	 * @param mobilePackage
	 * @return
	 */
	public boolean updatemobilepackage_end(MobilePackage mobilePackage);
	
	
	
	
	/**
	 * ��account������һ���û��ļ�¼
	 * @param telnumb
	 * @param money
	 * @return
	 */
	public boolean saveaccount(String telnumb,int money);
}
