package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Mobile;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class PhoneCardIsRemaningAjaxServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public PhoneCardIsRemaningAjaxServlet() {
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
		
		String phone = request.getParameter("phone") == null ? "" : request.getParameter("phone").trim();
		System.out.println(phone);
		
		//查找数据库中是否存在该手机号
		Mobile mobile = customerService.isMobile(phone);
		String result = "true";
		if(mobile != null){//说明手机号不存在表中
			result = "false";
		}
		
		System.out.println("ajax结果->" + result);	
		out.print("<root><result>"+result+"</result></root>");
		
		
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
