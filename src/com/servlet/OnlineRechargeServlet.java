package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.PreferentialInfor;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class OnlineRechargeServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public OnlineRechargeServlet() {
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
		
		//radio 适宜较过来的充值金额
		String radio = request.getParameter("radio") == null ? "" : request.getParameter("radio"); 
		
		//查询数据库中的优惠信息
		PreferentialInfor infor = customerService.findPreferentialInfor(radio);
		//优惠的金额
		System.out.println(infor.getAmount());
		String amount = infor.getAmount();
		String result = "";
				
		if(amount.equals("1")){
			result = amount+","+radio;
		} else if(amount.equals("2")){
			result = amount+","+radio;
		} else if(amount.equals("8")){
			result = amount+","+radio;
		} else if(amount.equals("15")){
			result = amount+","+radio;
		} else if (amount.equals("30")) {
			result = amount+","+radio;
		} else if (amount.equals("80")) {
			result = amount+","+radio;
		}
		System.out.println("-----------------");
		System.out.println(result);
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
