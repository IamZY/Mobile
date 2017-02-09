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
		
		System.out.println("�û���->" + username);
		System.out.println("����->" + pwd);
		
		
		System.out.println("-----------------------");
		
		Map<String, String> errMsg = new HashMap<String, String>();
		
		/**
		 * ��̨��֤
		 */
		if(username == null || username.equals("")){
			errMsg.put("userMsg", "�˺Ų���Ϊ��");
		} else if(username.length() > 20){
			errMsg.put("userMsg", "�˺ŵĳ��ȱ�����1-20֮��");
		}
		
		if(pwd == null || pwd.equals("")){
			errMsg.put("pwdMsg", "���벻��Ϊ��");
		} else if(pwd.length() > 20){
			errMsg.put("pwdMsg", "����ĳ��ȱ�����1-20֮��");
		}
		
		System.out.println(errMsg.isEmpty());
		/*if(errMsg.isEmpty()){ //Ϊ��
			//������Ϣ...		
			request.setAttribute("username", username);
			request.setAttribute("pwd", pwd);
			request.getRequestDispatcher("UsernameIsRemaningAjaxServlet").forward(request, response);
		
		} else{ //��Ϊ��
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
