<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<script type="text/javascript">
	function checkId(){
		var cid = document.getElementById("cid").value;
		var cidMsg = document.getElementById("cidMsg");
				 
		if(cid == ""){
			cidMsg.innerHTML = "银行卡卡号不能为空";
			cidMsg.style.display="inline";
			return false;
		}else if(cid.length>19 || cid.length<16){
			cidMsg.innerHTML = "银行卡的格式不正确";
			cidMsg.style.display="inline";
			return false;
		}else{
			cidMsg.innerHTML = "";
			return true;
		}
	}


	function checkPwd(){
		var cpwd = document.getElementById("cpwd").value;
		var cpwdMsg = document.getElementById("cpwdMsg");
				 
		if(cpwd == ""){
			cpwdMsg.innerHTML = "密码不能为空";
			cpwdMsg.style.display="inline";
			return false;
		}else if(cpwd.length != 6){
			cpwdMsg.innerHTML = "密码长度不正确";
			cpwdMsg.style.display="inline";
			return false;
		}else{
			cpwdMsg.innerHTML = "";
			return true;
		}
	}


	function verity(){
		var result = checkId();
		var result1 = checkPwd();	
		return result && result1;
	}

</script>


	<body id="new-operator-body">
		<div id="new-operator-contain">
			<div class="zhzf"></div>
			<div id="new-operator-main">

				<br>
				<form method="get" action="servlet/AccountServlet" class="form-style" onsubmit="return verity()">
					<table>
						<tr>
							<td class="left-td-style">银行卡号：</td>
							<td class="right-td-style">
								<input type="text" name="cid" id="cid" onblur="checkId()" size="20" class="input-form-style">
							</td>
							<td><span id="cidMsg" style="color:red;display:none"></span></td>
						</tr>
							
						<tr>
							<td class="left-td-style">密码：</td>
							<td class="right-td-style">
								<input type="password" name="cpwd" id="cpwd" onblur="checkPwd()" size="20"
									class="input-form-style">
							</td>
							<td><span id="cpwdMsg" style="color:red;display:none"></span></td>
						</tr>
						
						<tr class="button-tr-style">
							<td colspan="2" class="right-td-style">
								<input type="submit" value="提交" name="B1" class="button-sub" />
								<input type="reset" value="重置" name="B1" class="button-res" />
								<input type="hidden" name="telnumb" id="telnumb" value="<%=request.getParameter("telnumb") %>"/>
								<input type="hidden" name="ppid" id="ppid" value="<%=request.getParameter("ppid") %>"/>
								<input type="hidden" name="fee" id="fee" value="<%=request.getParameter("fee") %>"/> 
							</td>
						</tr>
					</table>

				</form>

			</div>

		</div>

	</body>
</html>
