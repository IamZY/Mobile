package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.PhonePackage;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class SelectNumberBysetmealServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public SelectNumberBysetmealServlet() {
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
	
		String telnumb = request.getParameter("telnumber") == null ? "" : request.getParameter("telnumber");
		String teladd = request.getParameter("teladd") == null ? "" : request.getParameter("teladd");
		teladd = new String(teladd.getBytes("ISO8859-1"),"utf-8");
		String telaccount = request.getParameter("telaccount") == null ? "" : request.getParameter("telaccount");
		
		System.out.println(telnumb);
		System.out.println(teladd);
		System.out.println(telaccount);
		
		List<PhonePackage> list = customerService.findPhonePackage();
		
		for(PhonePackage p : list){
			System.out.println(p.getShortname());
		}
		
		request.setAttribute("telnumb", telnumb);
		request.setAttribute("teladd",teladd);
		request.setAttribute("telaccount", telaccount);
		request.setAttribute("phonelist", list);
		request.getRequestDispatcher("/numericalSelection/select_number_bysetmeal.jsp").forward(request, response);
		
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
