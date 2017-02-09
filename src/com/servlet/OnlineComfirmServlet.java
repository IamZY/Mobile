package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.RechargeInfor;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class OnlineComfirmServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public OnlineComfirmServlet() {
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
		
		
		//telnumb=&value=100&discount=8&sumprice=108
		String telnumb = request.getParameter("telnumb") == null ? "" : request.getParameter("telnumb").trim();
		//充值金额
		String value = request.getParameter("value") == null ? "" : request.getParameter("value").trim();
		//折扣
		String discount = request.getParameter("discount") == null ? "" : request.getParameter("discount").trim();
		//总充值数
		String sumprice = request.getParameter("sumprice") == null ? "" : request.getParameter("sumprice").trim();
		
		System.out.println(telnumb);
		
		
		
		//搜索充值优惠名称
		String prename = customerService.findPreferentialInfor(value).getName();
		System.out.println(prename);
		
		
		//通过手机号查找姓名
		String name = customerService.findCustomerName(telnumb).getCustomer_name();
		System.out.println(name);
		
		
		request.setAttribute("telnumb", telnumb);
		request.setAttribute("value", value);
		request.setAttribute("sumprice", sumprice);
		request.setAttribute("prename", prename);
		request.setAttribute("name", name);
		
		request.getRequestDispatcher("/recharge_style/online_comfirm.jsp").forward(request, response);
		

		
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
