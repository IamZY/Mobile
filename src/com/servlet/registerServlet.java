package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.T_Customer;
import com.service.customerService;
import com.service.iface.customerServiceIface;

public class registerServlet extends HttpServlet {

	private customerServiceIface customerService;
	
	/**
	 * Constructor of the object.
	 */
	public registerServlet() {
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
		String name = request.getParameter("name");
		name = new String(name.getBytes("ISO8859-1"),"utf-8");
		String phone = request.getParameter("phone");
		String id_number = request.getParameter("id_number");
		String Strbirth = request.getParameter("birth");
		String pwd = request.getParameter("pwd");
		String confirm_pwd = request.getParameter("confirm_pwd");
		
		System.out.println(username);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(id_number);
		System.out.println(Strbirth);
		System.out.println(pwd);
		System.out.println(confirm_pwd);
		
		
		//后台验证
		Map<String, String> errMsg = new HashMap<String, String>();
		
		if(username == null||username.equals("")){
			errMsg.put("userMsg", "账号不能为空");
		}else if(username.length() > 20){
			errMsg.put("userMsg", "账号长度大于20");
		}
		
		String regex = "[\u4E00-\u9FA5]{1,6}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		
		if(name == null || name.equals("")){
			errMsg.put("nameMsg", "姓名不能为空");
		}else if(!m.matches()){
			errMsg.put("nameMsg", "姓名格式不正确");
		}
		
		String regex1 = "1[3|4|5|8][0-9]{9}";
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1 = p1.matcher(phone);
		
		if(phone == null || phone.equals("")){
			errMsg.put("phoneMsg", "手机号不能为空");
		}else if(!m1.matches()){
			errMsg.put("phoneMsg", "手机号格式不正确");
		}
		
		
		//后台验证id_number
		String regex2 = "[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)";
		Pattern p2 = Pattern.compile(regex2);
		Matcher m2 = p2.matcher(id_number);
		
		if(id_number == null ||id_number.equals("")){
			errMsg.put("idMsg","身份证号不能为空");
			
		}else if(id_number.length()!=18){
			errMsg.put("idMsg","身份证号不是18位");
			
		}else if(!m2.matches()){
			errMsg.put("idMsg","身份证号格式不正确");
			
		}
		
		//后台验证birth
		String regex3 = "\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}";
		Pattern p3 = Pattern.compile(regex3);
		Matcher m3 = p3.matcher(Strbirth);
			
		if(Strbirth == null ||Strbirth.equals("")){
			errMsg.put("birthMsg","生日不能为空");
		}else if(!m3.matches()){
			errMsg.put("birthMsg","生日格式不对");
		}
		
		//后台验证password
		if(pwd == null ||pwd==""){
			errMsg.put("pwdMsg","密码不能为空!!!");
		
		}else if(pwd.length()>20){
			errMsg.put("pwdMsg","密码不能超过20个位");
			
		}
		
		
		//后台验证regpwd
		if(confirm_pwd == null ||confirm_pwd.equals("")){
			errMsg.put("confirm_pwdMsg","密码不能为空");

		}else if(!confirm_pwd.equals(pwd)){
			errMsg.put("confirm_pwdMsg","密码不一致");
		}
			
		System.out.println(errMsg.isEmpty());
		
		
		if(errMsg.isEmpty()){
			//String -> date
			System.out.println("---------------");
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			try {
				//String -> date
				Date birth = new Date(sdf.parse(Strbirth).getTime());
				T_Customer customer = new T_Customer(username,name,id_number,phone,birth,pwd);
				
				boolean b = customerService.addCustomer(customer);
				if(b == true){
					System.out.println("11111111111111111111111");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else{
					System.out.println("22222222222222222222222");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else {
			System.out.println("=============");
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
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
