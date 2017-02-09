package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Account;
import com.domain.T_Customer;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class indexServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public indexServlet() {
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
		
		System.out.println("indexservlet....");
		String username = request.getParameter("username") == null ? "" : request.getParameter("username").trim();
		String user = (String) (request.getAttribute("username") == null ? "" : (String)request.getAttribute("username")).trim();
		System.out.println(username);
		System.out.println(user);
		
		
		T_Customer customer = null;
				
		if(!username.equals("")){
			customer = customerService.findCustomer(username);			
		}else {
			customer = customerService.findCustomer(user);
		}
		
		
		System.out.println("-------------------");
		System.out.println(customer.getCustomer_name());
		System.out.println(customer.getTel_numb());
		System.out.println("--------------------");
		String name = customer.getCustomer_name();
		String telnumb = customer.getTel_numb();
		
		//通过手机号查询某个人的手机余额
		String acc = (String)customerService.findaccount(telnumb).getAccount();
		
		
				
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("telnumb", telnumb);
		session.setAttribute("acc", acc);

		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
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
