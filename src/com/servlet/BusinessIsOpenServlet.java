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
import com.sun.org.apache.bcel.internal.generic.IfInstruction;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class BusinessIsOpenServlet extends HttpServlet {
	customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public BusinessIsOpenServlet() {
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

		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//接受手机号判断业务是否已经开通
		System.out.println("businessisopen..............");
		String telnumb = request.getParameter("telnumb") == null ? "" : request.getParameter("telnumb").trim();
		String bid = request.getParameter("businessid") == null ? "" : request.getParameter("businessid").trim();
		System.out.println(telnumb);
		System.out.println(bid);
		
		
		//插入t_mobile_package表中，并改变表中对应属性的状态

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
			
			MobilePackage mobilePackage = new MobilePackage(telnumb,bid,null,d,null);
			String result = "";
			boolean b = customerService.addmobilepackage(mobilePackage);
			
			if(b == true){
				System.out.println("yeah");
				result = "true";
			}else {
				System.out.println("no");
				result = "false";
			}
			
			
			out.print("<root><result>"+result+"</result></root>");
		
		
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
