<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.domain.RechargeInfor"%>
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
		<title>无标题文档</title>

		<link href="<%=basePath%>/css/index.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>/css/reset.css" rel="stylesheet" type="text/css" />
	</head>

	<body id="record-body">
		<div id="record-contain">
			<div id="record-main">


				<div class="record-tel">
					号码
					<span class="tel-account">${telnumb }</span>的充值记录如下：
				</div>

				<table width="700px" class="table-infor-record-style2">
					<tr>
						<th>充值时间</th>
						<th>充值金额（元）</th>
						<th>充值方式</th>
						<th>充值卡编号</th>
						<th>银行卡编号</th>
						<th>优惠金额</th>
					</tr>
					
					<%
						List<RechargeInfor> list = (List<RechargeInfor>)request.getAttribute("inforlist");
						int currtenttotal = (Integer)request.getAttribute("currenttotal");
						for(RechargeInfor infor : list){
					%>
					
					<tr>
						<td><%=infor.getRechargetime() %></td>
						<td><%=infor.getRechargemoney() %></td>
						<td><%=infor.getTypeid() %></td>
						<td><%=infor.getCardid() %></td>
						<td><%=infor.getBankid() %></td>
						<td><%=infor.getDisamount() %></td>
					</tr>
						
										
					<%	
						}
					%>
					
					
					
					<tr>
						<td style="background: #79c8E6">总计</td>
						<td><%=list.get(currtenttotal-1).getTotalmoney() %></td>
						<td>--</td>
						<td><%=list.get(currtenttotal-1).getCardcount() %>次</td>
						<td><%=list.get(currtenttotal-1).getBankcount() %>次</td>
						<td><%=list.get(currtenttotal-1).getTotaldiscount() %></td>
					</tr>	
					
					


				</table>

				<form action="servlet/RecordServlet" method="post">
					<input type="hidden" name="telnumb" id="telnumb" value="${telnumb }"/>
					<table class="table-infor-record-style2" id="page2">
						<tr>
							<th width="113">
								第${currentpage }页/共${end }页
							</th>
							<td id="page-skip">
							<input type="hidden" name="telnumb" id="telnumb" value="${telnumb }">
							<a href="servlet/RecordServlet?&telnumb=${telnumb }&currentpage=1">首页</a> 
							<a href="servlet/RecordServlet?&telnumb=${telnumb }&currentpage=${currentpage-1 }">上一页</a>
							<a href="servlet/RecordServlet?&telnumb=${telnumb }&currentpage=${currentpage+1 }">下一页</a> 
							<a href="servlet/RecordServlet?&telnumb=${telnumb }&currentpage=${end }">尾页</a>
								<input type="text" name="currentpage" id="currentpage" class="input-page-style">
								<input type="submit" value="go" />
							</td>
						</tr>
					</table>
				</form>

			</div>

		</div>

	</body>
</html>
