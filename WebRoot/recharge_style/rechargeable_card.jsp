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
	<script type="text/javascript" src="myjs.js"></script>
	<script type="text/javascript">
		function checkPhone(){
			var phone = document.getElementById("phone").value;
			var phoneMsg = document.getElementById("phoneMsg");		
			var reg = /^1[3|4|5|8]\d{9}$/;
			
			if(phone == ""){
				phoneMsg.innerHTML = "手机号不能为空";
				phoneMsg.style.display="inline";
				return false;
			}else if(!reg.test(phone)){
				phoneMsg.innerHTML = "手机号的格式不正确";
				phoneMsg.style.display="inline";
				return false;
			}else{
				//ajax验证	
				//获得xmlHttpRequest对象
				getXMLHttpRequest();
				//打开URL地址	
				//获取参数请求
				var username = document.getElementById("phone").value;			
				//准备url
				var url = "servlet/PhoneCardIsRemaningAjaxServlet?phone="+phone;
				//alert(url);
				//打开
				xmlHttpRequest.open("post",url,true);
			
				//为xmlHttpRequst对象设置回调函数
				xmlHttpRequest.onreadystatechange = callback_phone;			
				//发出请求
				xmlHttpRequest.send(null);
				//alert("111");
			}	
		}
	
		//callback_phone
		function callback_phone(){
			//alert("callback_phone");
			//alert(xmlHttpRequest.readyState);
			if(xmlHttpRequest.readyState == 4){
				//alert(xmlHttpRequest.readyState); //4
				console.log(xmlHttpRequest.readyState);
				if(xmlHttpRequest.status == 200){
					//alert(xmlHttpRequest.status);   //200
					console.log(xmlHttpRequest.status); 
					//alert(xmlHttpRequest.responseText);
					var res = xmlHttpRequest.responseXML.getElementsByTagName("result"); //null
					
					var result;
									
					for(var i = 0;i < res.length;i++){
						result = res[i].firstChild.nodeValue;
					}
					
					//alert(result);	//true			
					if(result == "true"){
						phoneMsg.innerHTML = "该手机号不存在";
						phoneMsg.style.display="inline";	
						return false;			
					} else{
						phoneMsg.innerHTML = "";			
						return true;
					}								
				}			
			}
		}
	
	
	
	function checkCardId(){
			var cardid = document.getElementById("cardid").value;
			var cardidMsg = document.getElementById("cardidMsg");		
			
			if(cardid == ""){
				cardidMsg.innerHTML = "充值卡号不能为空";
				cardidMsg.style.display="inline";
				return false;
			}else{
				//ajax验证	
				//获得xmlHttpRequest对象
				getXMLHttpRequest();
				//打开URL地址	
				//获取参数请求
				var cardid = document.getElementById("cardid").value;			
				//准备url
				var url = "servlet/CardIsRemaningAjaxServlet?cardid="+cardid;
				//alert(url);
				//打开
				xmlHttpRequest.open("post",url,true);
			
				//为xmlHttpRequst对象设置回调函数
				xmlHttpRequest.onreadystatechange = callback_card;			
				//发出请求
				xmlHttpRequest.send(null);
				//alert("111");
			}	
		}
	
	
	function callback_card(){
			//alert("callback_card");
			//alert(xmlHttpRequest.readyState);
			if(xmlHttpRequest.readyState == 4){
				//alert(xmlHttpRequest.readyState); //4
				console.log(xmlHttpRequest.readyState);
				if(xmlHttpRequest.status == 200){
					//alert(xmlHttpRequest.status);   //200
					console.log(xmlHttpRequest.status); 
					//alert(xmlHttpRequest.responseText);
					var res = xmlHttpRequest.responseXML.getElementsByTagName("result"); //null
					
					var result;
									
					for(var i = 0;i < res.length;i++){
						result = res[i].firstChild.nodeValue;
					}
					
					//alert(result);	//true			
					if(result == "true"){
						cardidMsg.innerHTML = "该充值卡不能使用";
						cardidMsg.style.display="inline";	
						return false;			
					} else{
						cardidMsg.innerHTML = "";			
						return true;
					}								
				}			
			}
		}
	
	function login(){
		//ajax验证	
		//获得xmlHttpRequest对象
		getXMLHttpRequest();
		//打开URL地址	
		//获取参数请求
		var cardid = document.getElementById("cardid").value;		
		var cardpwd = document.getElementById("cardpwd").value;	
		//准备url
		var url = "servlet/CardLoginIsRemaningServlet?cardid="+cardid+"&cardpwd="+cardpwd;
		//alert(url);
		//打开
		xmlHttpRequest.open("post",url,true);
	
		//为xmlHttpRequst对象设置回调函数
		xmlHttpRequest.onreadystatechange = callback_login;			
		//发出请求
		xmlHttpRequest.send(null);
		//alert("111");
	}
	
	
	function callback_login(){
			//alert("call back");
			//alert(xmlHttpRequest.readyState);
			if(xmlHttpRequest.readyState == 4){
				//alert(xmlHttpRequest.readyState); //4
				console.log(xmlHttpRequest.readyState);
				if(xmlHttpRequest.status == 200){
					//alert(xmlHttpRequest.status);   //200
					console.log(xmlHttpRequest.status);
					//alert(xmlHttpRequest.responseText);
					var res = xmlHttpRequest.responseXML.getElementsByTagName("result"); //null
					
					var result;
									
					for(var i = 0;i < res.length;i++){
						result = res[i].firstChild.nodeValue;
					}
					
					//alert(result);	//true			
					if(result == "true"){
						//alert("222222");
						var phone = document.getElementById("phone").value;
						var cardid = document.getElementById("cardid").value;	
						location.href="servlet/CardSaveInfoServlet?phone="+phone+"&cardid="+cardid;
					} else{
						//alert("33333");
						var errMsg = document.getElementById("errMsg");
						errMsg.style.color="red";
						errMsg.style.display="block";
						errMsg.innerHTML="充值卡或密码错误";
					}
								
				}			
			}
		}
	
	
</script>

	<body id="card-body">
		<div id="card-contain">
			<div id="card-main">
				<div id="card-procedure"></div>

				<form method="get" class="form-style">
					<table>
						<tr>
							<td class="left-td-style">
								手机号码：
							</td>
							<td class="right-td-style">
								<input type="text" name="phone" id="phone" size="20" class="input-form-style"
									value="${telnumb }" onblur="checkPhone()"/>
							</td>
							<td>&nbsp;<span id="phoneMsg" style="color:red;display:none"></span></td>

						</tr>
						<tr>
							<td class="left-td-style">
								充值卡卡号：
							</td>
							<td class="right-td-style">
								<input type="text" name="cardid" id="cardid" size="20" class="input-form-style" onblur="checkCardId()">
							</td>
							<td>&nbsp;<span id="cardidMsg" style="color:red;display:none"></span></td>
						</tr>
						<tr>
							<td class="left-td-style">
								充值卡密码：
							</td>
							<td class="right-td-style">
								<input type="password" name="cardpwd" id="cardpwd" size="20"
									class="input-form-style">
							</td>
						</tr>
						<tr class="button-tr-style">
							<td colspan="2" class="left-td-style">
								<input type="button" value="提交" onclick="login()" class="button-sub" />
								<input type="reset" value="重置" class="button-res" />

							</td>
						</tr>
						<tr>
							<td><span id="errMsg" name="errMsg" style="color:red;display:none"></span></td>
						</tr>
					</table>

				</form>
				
			</div>

		</div>
	</body>
</html>
