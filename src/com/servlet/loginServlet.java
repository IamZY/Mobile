package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.customerService;
import com.service.iface.customerServiceIface;

public class loginServlet extends HttpServlet {
	private customerServiceIface customerService;
	
	/**
	 * Constructor of the object.
	 */
	public loginServlet() {
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
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		System.out.println("================");
		
		System.out.println("用户名->" + username);
		System.out.println("密码->" + pwd);
		
		
		System.out.println("-----------------------");
		
		Map<String, String> errMsg = new HashMap<String, String>();
		
		/**
		 * 后台验证
		 */
		if(username == null || username.equals("")){
			errMsg.put("userMsg", "账号不能为空");
		} else if(username.length() > 20){
			errMsg.put("userMsg", "账号的长度必须在1-20之间");
		}
		
		if(pwd == null || pwd.equals("")){
			errMsg.put("pwdMsg", "密码不能为空");
		} else if(pwd.length() > 20){
			errMsg.put("pwdMsg", "密码的长度必须在1-20之间");
		}
		
		System.out.println(errMsg.isEmpty());
		/*if(errMsg.isEmpty()){ //为空
			//保存信息...		
			request.setAttribute("username", username);
			request.setAttribute("pwd", pwd);
			request.getRequestDispatcher("UsernameIsRemaningAjaxServlet").forward(request, response);
		
		} else{ //不为空
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);			
		}
*/
		
		
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
