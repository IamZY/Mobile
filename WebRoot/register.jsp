<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>用户注册——移动网上营业厅</title>
		<link href="css/reset.css" rel="stylesheet" type="text/css" />
		<link href="css/index.css" rel="stylesheet" type="text/css" />
	</head>
<script type="text/javascript" src="myjs.js"></script>
<script type="text/javascript">

	
	function checkUserName(){
		var username = document.getElementById("username").value;
	 	var userMsg = document.getElementById("userMsg");
	 	console.log(username); 
	 	 	
		if(username == ""){
			userMsg.innerHTML = "账户不能为空";
			//console.log(userMsg);
			userMsg.style.display="inline";
			return false;
		}else if(username.length > 20){
			userMsg.innerHTML = "账户长度必须在1-20之间";
			userMsg.style.display="inline";
			return false;
		}else{
			//ajax验证	
			//获得xmlHttpRequest对象
			getXMLHttpRequest();
			//打开URL地址
			
			//获取参数请求
			var username = document.getElementById("username").value;
			
			//准备url
			var url = "servlet/UsernameIsRemaningAjaxServlet?username="+username;
			//alert(url);
			//打开
			xmlHttpRequest.open("post",url,true);
		
			//为xmlHttpRequst对象设置回调函数
			xmlHttpRequest.onreadystatechange = callback;
			
			//发出请求
			xmlHttpRequest.send(null);
			//alert("111");
		}
		
	}
	
	function checkName(){
		var name = document.getElementById("name").value;
	 	var nameMsg = document.getElementById("nameMsg");
		var reg = /^[\u4E00-\u9FA5]{1,6}$/;
 	
		if(name == ""){
			nameMsg.innerHTML = "姓名不能为空";
			nameMsg.style.display="inline";
			return false;
		}else if(name.length > 20){
			nameMsg.innerHTML = "姓名长度必须在1-20之间";
			nameMsg.style.display="inline";
			return false;
		}else if(!reg.test(name)){
			nameMsg.innerHTML = "姓名格式不正确";
			nameMsg.style.display="inline";
			return false;
		}else{
			nameMsg.innerHTML = "";
			//userMag.style.display="inline";
			return true;
		}
	}
	
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
			var username = document.getElementById("username").value;
			
			//准备url
			var url = "servlet/PhoneIsRemaningAjaxServlet?phone="+phone;
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
	
	function checkId(){
		var id_number = document.getElementById("id_number").value;
		var idMsg = document.getElementById("idMsg");
		
		var reg = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
		
		if(id_number == ""){
			idMsg.innerHTML = "身份证号不能为空";
			idMsg.style.display="inline";
			return false;
		}else if(!reg.test(id_number)){
			idMsg.innerHTML = "身份证号的格式不正确";
			idMsg.style.display="inline";
			return false;
		}else{
			idMsg.innerHTML = "";
			//userMag.style.display="inline";
			return true;
		}
	}

	function checkBirth(){
		var birth = document.getElementById("birth").value;
		var birthMsg = document.getElementById("birthMsg");
		
		var reg = /^[1][9]\d{2}([-|\/|\.])?((0\d)|([1-9])|(1[0-2]))\1(([0|1|2]\d)|([1-9])|3[0-1])$/;
		 
		if(birth == ""){
			birthMsg.innerHTML = "生日不能为空";
			birthMsg.style.display="inline";
			return false;
		}else if(!reg.test(birth)){
			birthMsg.innerHTML = "生日的格式不正确";
			birthMsg.style.display="inline";
			return false;
		}else{
			birthMsg.innerHTML = "";
			//userMag.style.display="inline";
			return true;
		}
	}


	function checkPwd(){
		var pwd = document.getElementById("pwd").value;
		var pwdMsg = document.getElementById("pwdMsg");
		console.log(pwd);
		if(pwd == ""){
			pwdMsg.innerHTML = "密码不能为空";
			pwdMsg.style.display = "inline";
			return false;
		}else if(pwd.length > 20){
			pwdMsg.innerHTML = "密码超长";
			pwdMsg.style.display = "inline";
			return false;
		}else{
			pwdMsg.innerHTML = "";		
			return true;
		}
				
	}

	function checkConfirm_pwd(){
		var confirm_pwd = document.getElementById("confirm_pwd").value
		var confirm_pwdMsg = document.getElementById("confirm_pwdMsg");
		var pwd = document.getElementById("pwd").value;
			 
		if(confirm_pwd == ""){
			confirm_pwdMsg.innerHTML = "验证密码不能为空";
			confirm_pwdMsg.style.display="inline";
			return false;
		}else if(confirm_pwd != pwd){
			confirm_pwdMsg.innerHTML = "验证密码与密码不符";
			confirm_pwdMsg.style.display="inline";
			return false;
		}else{
			confirm_pwdMsg.innerHTML = "";
			//userMag.style.display="inline";
			return true;
		}
	}


	function verity(){
		var username = checkUserName();
		var name = checkName();
		var phone = checkPhone();
		var id = checkId();	
		var birth = checkBirth();
		var pwd = checkPwd();
		var confirm_pwd = checkConfirm_pwd();
		
		return username && name && phone && id && birth && pwd && confirm_pwd;
		
	}
	

	//callback
	function callback(){
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
					userMsg.innerHTML = "该账户已经存在";
					userMsg.style.display="inline";	
					return false;			
				} else{
					userMsg.innerHTML = "";
					return true;			
				}
							
			}
			
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
					phoneMsg.innerHTML = "该手机号已经存在";
					phoneMsg.style.display="inline";	
					return false;			
				} else{
					phoneMsg.innerHTML = "";			
					return true;
				}
							
			}
			
		}
	}




</script>


<body>
	<div id="register-contain">
		<div id="register-main">
		<img src="image/register.jpg" id="reg-img" />
   
   	<form class="add-customer" id="registerform" action="servlet/registerServlet" method="get" onsubmit="return verity()">
   	
   	<table>
   		<tr align="right">
   			<td class="regtitle">账户：</td>
   			<td class="reginput"><span><input type="text" id="username" name="username" onblur="checkUserName()"/></span></td>
   			<td>&nbsp;<span id="userMsg" style="color:red;display:none"></span></td>
   		</tr>
   		
   		<tr align="right">
   			<td><span class="regtitle">姓名：</span></td>
   			<td><span><input type="text" id="name" name="name" onblur="checkName()"/></span></td>
   			<td>&nbsp;<span id="nameMsg" style="color:red;display:none"></span></td>
   		</tr>
   		<tr align="right">
   			<td><span class="regtitle">手机号码：</span></td>
   			<td><span><input type="text" id="phone" name="phone" onblur="checkPhone()"/></span></td>
   			<td>&nbsp;<span id="phoneMsg" style="color:red;display:none"></span></td>
   		</tr>
   		<tr align="right">
   			<td><span class="regtitle">身份证号码：</span></td>
   			<td><span><input type="text" id="id_number" name="id_number" onblur="checkId()"/></span></td>
   			<td>&nbsp;<span id="idMsg" style="color:red;display:none"></span></td>
   		</tr>
   		<tr align="right">
   			<td><span class="regtitle">出生日期:</span></td>
   			<td><span><input type="text" id="birth" name="birth" onblur="checkBirth()"/></span></td>
   			<td>&nbsp;<span id="birthMsg" style="color:red;display:none"></span></td>
   		</tr>
   		<tr align="right">
   			<td><span class="regtitle">登录密码：</span></td>
   			<td><span><input type="password" id="pwd" name="pwd" onblur="checkPwd()"/></span></td>
   			<td>&nbsp;<span id="pwdMsg" style="color:red;display:none"></span></td>
   		</tr>
   		<tr align="right">
   			<td><span class="regtitle">确认密码：</span></td>
   			<td><span><input type="password" id="confirm_pwd" name="confirm_pwd" onblur="checkConfirm_pwd()"/></span></td>
   			<td>&nbsp;<span id="confirm_pwdMsg" style="color:red;display:none"></span></td>
   		</tr>
   		
   		<tr align="right">
   			<td colspan="2"><button type="submit" id="reg-sub" >立即注册</button></td>
   		</tr>
   		
   	</table>

   </form>
   
    </div>
</div>
</body>
</html>
