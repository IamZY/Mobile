package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.MobilePackage;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class AccountServlet extends HttpServlet {
	customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public AccountServlet() {
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
		
		String id = request.getParameter("cid") == null ? "" : request.getParameter("cid").trim();
		String pwd = request.getParameter("cpwd") == null ? "" : request.getParameter("cpwd").trim();
		String telnumb = request.getParameter("telnumb") == null ? "" : request.getParameter("telnumb").trim(); 
		String ppid = request.getParameter("ppid") == null ? "" : request.getParameter("ppid").trim();
		String fee = request.getParameter("fee") == null ? "" : request.getParameter("fee").trim();
		
		
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(telnumb);
		System.out.println(ppid);
		System.out.println(fee);
		
		//将数据库中对应的手机号的is_sale改变 0->1
		boolean b = customerService.updatePhoneSale(telnumb);
		
		
		//将信息插入到account表中
		customerService.saveaccount(telnumb, Integer.parseInt(fee));
		
		
		//将信息存入到套餐表中
		//获取系统当前时间
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("dd-MM-yy");
		String time = format.format(date);
		
		//String->sql.date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		java.sql.Date d;
		try {
			d = new java.sql.Date(sdf.parse(time).getTime());
			System.out.println("-------------");
			System.out.println(d); //系统当前的时间
			
			MobilePackage mobilePackage = new MobilePackage(telnumb,null,ppid,d,null);
			
			//将手机订购的套餐加入到套餐表中
			boolean b1 = customerService.addmobilepackage_hb(mobilePackage);
			
			if(b == true && b1 == true){
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/recharge_style/Account.jsp").forward(request, response);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
	
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
