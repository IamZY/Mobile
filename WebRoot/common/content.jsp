<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<link href="<%=basePath%>/css/index.css" rel="stylesheet" type="text/css" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
	</head>

	<body>
		<div id="container">
			<div class="right">

				<div id="cnt">
					<div id="dTab1" class="Box">

						<iframe src="<%=basePath%>/numericalSelection/select_number.jsp"
							name="content1" frameborder="0" scrolling="auto" />
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
