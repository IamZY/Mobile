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

import com.domain.RechargeCard;
import com.domain.RechargeInfor;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class CardSaveInfoServlet extends HttpServlet {
	private customerServiceIface custonerService;
	/**
	 * Constructor of the object.
	 */
	public CardSaveInfoServlet() {
		super();
		custonerService = new customerService();
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
		
		String telnumb = request.getParameter("phone") == null ? "" : request.getParameter("phone").trim();
		String cardid = request.getParameter("cardid") == null ? "" : request.getParameter("cardid").trim();
		System.out.println("11111111111111111111");
		System.out.println(telnumb);
		System.out.println(cardid);
		
		//查询充值卡的金额
		String money = custonerService.findRechargeCard(cardid).getCharge();
		System.out.println(money);
		//将卡号的available  1->0
		custonerService.updatecard(cardid);
		
		
		//更新用户的余额
		custonerService.addaccount(Integer.parseInt(money), telnumb);
		
		
		//获取系统当前时间
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("dd-MM-yy");
		String time = format.format(date);
		
		//String->sql.date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		java.sql.Date d;
		try {
			d = new java.sql.Date(sdf.parse(time).getTime());
				
			//存储
			RechargeInfor infor = new RechargeInfor(telnumb,d,"1002",cardid,null,null,"0",money);
			
			boolean b = custonerService.insertrechangeinfonline(infor);
			if(b == true){
				System.out.println("yeah");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else {
				System.out.println("no");
				//错误跳转
				request.getRequestDispatcher("/recharge_style/rechargeable_card.jsp").forward(request, response);
			}
						
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
