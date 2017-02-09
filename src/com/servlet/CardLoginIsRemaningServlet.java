package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.RechargeCard;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class CardLoginIsRemaningServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public CardLoginIsRemaningServlet() {
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
		
		String cardid = request.getParameter("cardid") == null ? "" : request.getParameter("cardid").trim();
		String cardpwd = request.getParameter("cardpwd") == null ? "" : request.getParameter("cardpwd").trim();
		
		System.out.println(cardid);
		System.out.println(cardpwd);
		
		RechargeCard card = customerService.findRechargeCard(cardid);
		
		String pwd = card.getPwd();
		String result = "false";
		if(cardpwd.equals(pwd)){
			result = "true";
		}
		
		System.out.println("ajax½á¹û->" + result);	
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
