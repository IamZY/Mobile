package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RecordFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httptRequest = (HttpServletRequest) request;
		HttpSession session = httptRequest.getSession();
		System.out.println("record.....");
		System.out.println(session.getAttribute("name"));
		System.out.println(session.getAttribute("telnumb"));
		
		if(session.getAttribute("name") == null){
			System.out.println("yeah");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			System.out.println("no");
			request.setAttribute("name", session.getAttribute("name"));
			request.setAttribute("telnumb", session.getAttribute("telnumb"));
			System.out.println(request.getAttribute("name"));
			System.out.println(request.getAttribute("telnumb"));
			
			request.getRequestDispatcher("../servlet/RecordServlet").forward(request, response);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		

	}

}
