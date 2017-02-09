<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<link rel="stylesheet" href="<%=basePath%>/Style/default.css" type="text/css" />

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="<%=basePath%>/css/reset.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>/css/index.css" rel="stylesheet" type="text/css" />

	</head>


	<body>
		<div id="head-contain">
			<div id="head-head">
				<marquee>
					欢迎来到中国移动!
					<span> 你好${name }!${telnumb }!您的账户余额为:${acc }</span>
					<span class="loginout">
						<a href="<%=basePath%>/login.jsp" target="_blank">[退出]</a>
					</span>
				</marquee>
			</div>

			<div id="head-main">

				<img class="logo" src="<%=basePath%>/image/logo.gif" />
				<img src="<%=basePath%>/image/js_logo.gif" height="89" class="js-log" />
				<img id="image-right" align="right" src="<%=basePath%>/image/yd_right_logo.gif" />

			</div>
		</div>

	</body>
</html>
