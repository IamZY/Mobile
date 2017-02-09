package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.RechargeInfor;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class RecordServlet extends HttpServlet {
	private customerServiceIface customerService;
	/**
	 * Constructor of the object.
	 */
	public RecordServlet() {
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
		
		System.out.println("recordservlet.....");
		String telnumb = request.getParameter("telnumb") == null ? "" : request.getParameter("telnumb");
		System.out.println(telnumb);
		//如果能够读取到手机号
		if(!telnumb.equals("")){
			
			System.out.println(telnumb);
			String Strcurrentpage = request.getParameter("currentpage") == null ? "1" : request.getParameter("currentpage").trim();
			int currentpage = Integer.parseInt(Strcurrentpage);
			System.out.println("currentpage->" + currentpage);
			//每页的个数
			int pageSize = 4;
			
			//定义总的页数
			int end = 0;	
			//计算总的数据
			int total = customerService.totalrechargeinfor(telnumb); //2		
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
			
			
			//就算每一页信息的个数
			int currenttotal = customerService.totalcurrentrechargeinfor(telnumb, currentpage, pageSize);
		
			//查询充值信息表 显示该号码的所有信息
			List<RechargeInfor> list = customerService.findrechargeinfor(telnumb, currentpage, pageSize);
			
			for(RechargeInfor infor : list){
				System.out.println(infor.getRechargetime() + "::" + infor.getCardid() + "::" + infor.getBankid() + "::" + infor.getTypeid());
			}
		
			if(total == 0){
				request.getRequestDispatcher("/recorderror.jsp").forward(request, response);
				return;
			}
			System.out.println("error...");
			
			
			
			HttpSession session = request.getSession();
			session.setAttribute("telnumb", telnumb);
			
			request.setAttribute("currenttotal", currenttotal);
			request.setAttribute("inforlist", list);
			request.setAttribute("currentpage", currentpage);
			request.setAttribute("end", end);
			request.getRequestDispatcher("/recharge_style/record.jsp").forward(request, response);
		
		}else {
			//得到的手机号是空
			request.getRequestDispatcher("/login.jsp").forward(request, response);
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
