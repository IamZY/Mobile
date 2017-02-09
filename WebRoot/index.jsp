<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sun.corba.se.spi.ior.iiop.RequestPartitioningComponent"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>移动网上营业厅首页</title>
		
	</head>
	<frameset rows="135,*" cols="*" framespacing="0" frameborder="no"
		border="0" id="framset">

		<frame src="common/header.jsp?name=<%=session.getAttribute("name") %>&telnumb=<%=session.getAttribute("telnumb") %>&acc=<%=session.getAttribute("acc") %>" name="topFrame" scrolling="no"
			id="topFrame" title="topFrame" />

		<frameset cols="220,*" frameborder="no" border="0" framespacing="0"
			id="main-frameset">
			<frame src="common/menu.jsp?name=<%=session.getAttribute("name") %>&telnumb=<%=session.getAttribute("telnumb") %>" scrolling="no"
				noresize="false" id="leftFrame" title="leftFrame">
			<frame src="common/content.jsp?name=<%=session.getAttribute("name") %>&telnumb=<%=session.getAttribute("telnumb") %>" id="mainFrame"
				title="mainFrame" style="border: 1px #1A76B7 solid;"
				noresize="false" />
		</frameset>
	</frameset>
	<noframes></noframes>

</html>