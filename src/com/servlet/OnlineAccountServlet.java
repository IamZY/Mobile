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

import com.domain.RechargeInfor;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class OnlineAccountServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public OnlineAccountServlet() {
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
		
		String telnumb = request.getParameter("telnumb") == null  ? "" : request.getParameter("telnumb").trim();
		String cid = request.getParameter("cid") == null ? "" : request.getParameter("cid").trim();
		String discount = request.getParameter("discount") == null ? "" : request.getParameter("discount").trim();
		String value = request.getParameter("value") == null ? "" : request.getParameter("value").trim();
		
		
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
			System.out.println(d);
						
			System.out.println(telnumb);
			System.out.println(cid);
			System.out.println(discount);
			System.out.println(value);
			System.out.println(time);
			
			int money = Integer.parseInt(value) + Integer.parseInt(discount);
			System.out.println(money); //充值总金额
			
			//通过手机号查用户的账户
			String username = customerService.findCustomerName(telnumb).getCustomer_username();
			System.out.println(username);
			
			boolean b1 = customerService.addaccount(money, telnumb);
			
			System.out.println(b1);
			if(b1 == true){
				System.out.println("yeah");
			} else{
				System.out.println("no");
			}
			
			
			//优惠编号
			String pid = customerService.findPreferentialInfor(value).getId();
			System.out.println(pid);
			//1001在线充值
			RechargeInfor infor = new RechargeInfor(telnumb,d,"1001",null,cid,pid,discount,value);
			
			boolean b = customerService.insertrechangeinfo(infor);
			System.out.println(b);
			if(b == true){
				System.out.println("yeah");
			} else{
				System.out.println("no");
			}
			
			
			if(b == true && b1 == true){
				request.setAttribute("username", username);
				request.getRequestDispatcher("/servlet/indexServlet").forward(request, response);
			}else{
				request.getRequestDispatcher("/recharge_style/OnlineAccount.jsp").forward(request, response);
				
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
