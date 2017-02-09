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
import com.sun.org.apache.bcel.internal.generic.IfInstruction;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class CardIsRemaningAjaxServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public CardIsRemaningAjaxServlet() {
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
		System.out.println(cardid);
		//通过card_id验证数据库中存不存在 并且可用 可用available为1
		RechargeCard card = customerService.findRechargeCard(cardid);
		//System.out.println(card.getAvailable());
		String result = "false"; 
		
		//验证存不存在卡
		
		if(card == null){
			result = "true";   //true表示不可用
		} else if(card.getAvailable().equals("0")){
			result = "true";
		} else{
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
