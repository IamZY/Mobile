<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.domain.PhonePackage"%>
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
		<title>套餐选择</title>
		<link href="<%=basePath%>/css/reset.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>/css/index.css" rel="stylesheet" type="text/css" />
<style>
.package-list-result {
	border: 2px solid #DDF0FE;
	padding: 35px 17px 0px;
	height: 400px;
	width: 900px;
	margin-top: 10px;
}

.package-list {
	position: relative;
	padding: 35px 20px 0px;
	z-index: 1000;
}

.package-list li {
	float: left;
	display: inline;
	width: 140px;
	margin-left: 42px;
	margin-right: 42px;
	padding-bottom: 35px;
}

.package-info {
	border: 1px solid #D6D6D6;
	padding: 15px 0px;
	text-align: center;
	background: #FFF none repeat scroll 0% 0%;
}

.package-info-price {
	color: #55B4FC;
	font: 24px/ 48px "microsoft yahei";
}

.package-info-des {
	color: #8FC320;
	line-height: 20px;
	font-weight: 700;
}

.package-name {
	height: 27px;
	line-height: 27px;
	text-align: center;
	background: #E5E5E5 none repeat scroll 0% 0%;
}

.package-action {
	padding-top: 8px;
}

.package-action .add-compare,.package-select-result .package-action .add-compared,.package-select-result .package-action .handle-now
	{
	float: left;
	margin-right: 0px;
	padding: 0px 6px;
	color: #FFF;
	font: 12px/ 24px "microsoft yahei";
}

.blue-btn {
	background: #32ADFB none repeat scroll 0% 0%;
}
</style>
<script>
	
	/**
		确认提交方法
		如果提交按钮的innerHTML为提交的话，将提价按钮的innerHTML改为支付，并将确认信息显示
		如果提交按钮的 innerHTML为支付的话，直接跳转账户界面
	*/
	function comfirmInfor(){

		if( document.getElementById("submit").innerHTML=='提交'){
	 		document.getElementById("submit").innerHTML='支付';
   			document.getElementById('comfirmInfor').style.display='';
	 	}else{
	 		location.href='<%=basePath%>/recharge_style/Account.jsp';
	 	}
  }
    
</script>
	</head>

	<body>
		<div id="setmeal-contain">
			<!-- setmeal-contain 开始-->
			<div id="setmeal-main" ><!-- setmeal-main 开始-->
	
			<table  class="table-style" style="float:left" >
			  <tr>
			    <td class="left-td-style" >手机号码：</td>
			    <td class="right-td-style">${telnumb }</td>
			  </tr>
			  <tr>
			    <td class="left-td-style" >充值金额：</td>
			    <td class="right-td-style">${telaccount }元</td>
			  </tr>
			  <tr>
			    <td class="left-td-style">号码归属地：</td>
			    <td class="right-td-style">${teladd }地区</td>
			   </tr>
			  <tr>
			  	 <td class="left-td-style">付款方式：</td>
			     <td class="right-td-style">  <img  src="<%=basePath%>/image/h-show-buyPro-userCos-pay-unipay.gif" /><span>网银支付</span></td>
			  </tr>
			  
			 </table>
			 <img src="<%=basePath%>/image/qqtsl58.gif"  style="margin-top:30px"/>




				<div class="package-list package-list-result" id="packageListResult">
					<ul class="clearfix">
						
						<%
							List<PhonePackage> list = (List<PhonePackage>)request.getAttribute("phonelist");
							for(PhonePackage p : list){
															
						%>
						
						<li>
							<div title="商旅套餐58元" class="package-info">
								<p class="package-info-price">
									￥
									<strong><%=p.getFee() %></strong>
								</p>
								<p title="国内主叫国内150分钟" class="package-info-des">
									赠送<%=p.getShichang() %>
									<br>
									<%=p.getLiuliang() %>B流量
								</p>
							</div>
							<div title="商旅套餐58元" class="package-name">
								商旅套餐<%=p.getFee() %>元
							</div>
							<div class="package-action">
								<a name="" href="javascript:void(0)"
									onclick="location.href='<%=basePath%>recharge_style/Account.jsp?telnumb=${telnumb }&ppid=<%=p.getPpid() %>&fee=${telaccount }'"
									class="blue-btn add-compare">立即办理</a>
							</div>
						</li>
													
						<% 	
							}
						 %>
						
					</ul>
				</div>
				
			</div>
			<!-- setmeal-main 结束-->
		</div>
		<!-- setmeal-contain 结束-->

	</body>
</html>
