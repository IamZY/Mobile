package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Business;
import com.domain.MobilePackage;
import com.domain.PhonePackage;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class ReplacementServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public ReplacementServlet() {
		super();
		customerService = new customerService();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//接受手机号
		String telnumb = request.getParameter("telnumb") == null ? "" : request.getParameter("telnumb").trim();
		System.out.println("replacement...........");
		System.out.println(telnumb);
		
		//显示所有的业务
		List<Business> list = customerService.findbusiness();
		
		//查询所有的套餐
		List<PhonePackage> phonelist = customerService.findPhonePackage();
	
		
		//查询某一个手机号已经办理的套餐
		List<MobilePackage> mobileList = customerService.findmobilepackagebytel(telnumb);
	

		System.out.println("bijiao..............");
		
		for(int i = 0;i < list.size();i++){
			String starttime = "";
			String endtime = "";
			String starttime2 = "";
			String endtime2 = "";
			for(int j =0;j < mobileList.size();j++){
				if(list.get(i).getBid().equals(mobileList.get(j).getBid())){
					
					System.out.println(list.get(i).getBid() + "->" +mobileList.get(j).getBid());
					//取值
					starttime = list.get(i).getStarttime();
					endtime = list.get(i).getEndtime();
					//System.out.println(starttime);
					//System.out.println(endtime);
					
					
					Date starttimedate = mobileList.get(j).getStarttime();
					Date endtimedate = mobileList.get(j).getEndtime();
					//System.out.println(starttimedate);
					//System.out.println(endtimedate);
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					if(endtimedate != null){
						//日期格式化
						endtime2 = sdf.format(endtimedate);		
					}else {
						endtime2 = "-";
					}
					
					starttime2 = sdf.format(starttimedate);
					//System.out.println(starttime + "<-" + starttime2);
					
					//赋值	
					list.get(i).setStarttime(starttime2);
					list.get(i).setEndtime(endtime2);
					
					
					//System.out.println(list.get(i).getStarttime() + "----" + list.get(i).getEndtime());
					
					
				}
			}
		}
		
		
//		System.out.println("输出...........");
//		
//		for(Business business : list){
//			System.out.println(business.getStarttime() + "========" + business.getEndtime());
//		}
//		
		

		//查询手机已经办理的套餐
		PhonePackage p = customerService.findPhonePackagebytel(telnumb);
		String ppid = p.getPpid();
	
		//System.out.println(ppid);
		
		request.setAttribute("ppid", ppid);
		request.setAttribute("telnumb", telnumb);
		request.setAttribute("blist", list);
		request.setAttribute("phonelist", phonelist);
		request.getRequestDispatcher("/business/replacement_business.jsp").forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
