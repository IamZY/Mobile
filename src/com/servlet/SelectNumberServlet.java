package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Flags.Flag;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Mobile;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class SelectNumberServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public SelectNumberServlet() {
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
		
		List<Mobile> mobileList = new ArrayList<Mobile>();
		
			
		String city = request.getParameter("city") == null ? "" : request.getParameter("city").trim();
		//解决乱码问题
		city = new String(city.getBytes("ISO8859-1"),"utf-8");
		String telfee = request.getParameter("telfee") == null ? "0" : request.getParameter("telfee").trim();
		//转换telfee
		//int telfee = Integer.parseInt(Strtelfee);
		String Strteldnseg = request.getParameter("teldnseg") == null ? "" : request.getParameter("teldnseg").trim();
		String teltype = request.getParameter("teltype") == null ? "" : request.getParameter("teltype").trim();
		String inputstyle = request.getParameter("inputstyle") == null ? "" : request.getParameter("inputstyle").trim();
		
		String teldnseg = "";
		//System.out.println(Strteldnseg);
		//System.out.println("----------------");
		if(Strteldnseg == ""){
			teldnseg = "";
		}else {
			teldnseg = Strteldnseg.substring(0, 2); //13x "" String index out of range: 2			
		}
		
		/*	
		System.out.println(city);
		System.out.println(telfee);
		System.out.println(teldnseg);
		System.out.println(teltype);
		System.out.println(inputstyle);
		*/
		request.setAttribute("city", city);
		request.setAttribute("telfee", telfee);
		//System.out.println(telfee);
		request.setAttribute("teldnseg", teldnseg);
		request.setAttribute("teltype", teltype);
		request.setAttribute("inputstyle", inputstyle);
		
		
		Mobile mobile = new Mobile(teldnseg,teltype,city,telfee,inputstyle);
			
		String Strcurrentpage = request.getParameter("currentpage") == null ? "1" : request.getParameter("currentpage").trim();
		System.out.println(Strcurrentpage);
		int currentpage = Integer.parseInt(Strcurrentpage);
		
		//每页的个数
		int pageSize = 6;
		
		//定义总的页数
		int end = 0;	
		//计算总的数据
		int total = customerService.totalMobile(mobile); //2
		System.out.println("total->"+total);
		
		if(total % pageSize == 0){
			end = total / pageSize;
		}else{
			end = total / pageSize + 1;
		}	
		
		if(currentpage < 1){
			currentpage = 1;
		}else if(currentpage > end){
			currentpage = end;
		}
		
		mobileList = customerService.findMobile(mobile,currentpage,pageSize);
		/*
		for(Mobile mobile2 : mobileList){
			System.out.println(mobile2.getTelNumber() + "::" + mobile2.getTelAdd() + "::" +mobile2.getTelAccount());
		}		
		*/
		request.setAttribute("mobilelist", mobileList);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("end", end);
		request.getRequestDispatcher("/numericalSelection/select_number.jsp").forward(request, response);
					
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
