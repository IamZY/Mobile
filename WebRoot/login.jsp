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
		<title>欢迎登录移动网上营业厅</title>
		<link href="css/reset.css" rel="stylesheet" type="text/css" />
		<link href="css/index.css" rel="stylesheet" type="text/css" />
	</head>
	
	<script type="text/javascript" src="myjs.js"></script>
	<script type="text/javascript">
    
	 function userOnClick(){
       document.getElementById('operator').style.color="#037DC9";
	   document.getElementById('operator').style.backgroundImage="url(1.jpg)";
	   document.getElementById('register').style.display="";
	   document.getElementById('current').style.color="white";
	   document.getElementById('current').style.backgroundImage="url(image/hd_title_bg1.gif)";   
	 }
	 
	  function userOnClick2(){
	   document.getElementById('register').style.display="none";
	   document.getElementById('current').style.color="#005BAF";
	   document.getElementById('current').style.backgroundImage="url(1.jpg)";
	   document.getElementById('operator').style.color="white";
	   document.getElementById('operator').style.backgroundImage="url(image/hd_title_bg1.gif)";    
	 }
	 
	 //验证账号是否为空、账号的长度
	 function checkUser(){
	 	var username = document.getElementById("username").value;
	 	var userMsg = document.getElementById("userMsg");
	 	 	
		if(username == ""){
			userMsg.innerHTML = "账户不能为空";
			userMsg.style.display="inline";
			return false;
		}else if(username.length > 20){
			userMsg.innerHTML = "账户长度必须在1-20之间";
			userMsg.style.display="inline";
			return false;
		}else{
			userMsg.innerHTML = "";
			//userMag.style.display="inline";
			return true;
		}
		
	 }
	 
	 //验证密码是否为空、长度
	 function checkPwd(){
	 	var pwd = document.getElementById("pwd").value;
	 	var pwdMsg = document.getElementById("pwdMsg");
	 		 	
		if(pwd == ""){
			pwdMsg.innerHTML = "密码不能为空";
			pwdMsg.style.display="inline";
			return false;
		}else if(pwd.length > 20){
			pwdMsg.innerHTML = "密码长度必须在1-20之间";
			pwdMsg.style.display="inline";
			return false;
		}else{
			pwdMsg.innerHTML = "";
			//userMag.style.display="inline";
			return true;
		}
	 }
	 
	 
	 function verity(){
	 	//document.action="servlet/loginServlet";
	 
	 	var result = checkUser();
	 	var result2 =  checkPwd();
	 	
	 	return result && result2;
	 	
	 	myform.submit();
	 }
	 
	 function login(){
	 	//获得xmlHttpRequest对象
			getXMLHttpRequest();
			//打开URL地址
			
				//获取参数请求
				var username = document.getElementById("username").value;
				var pwd = document.getElementById("pwd").value;
				
				//准备url
				var url = "servlet/LoginIsRemaningAjaxServlet?username="+username+"&pwd="+pwd;
				//alert(url);
				//打开
				xmlHttpRequest.open("post",url,true);
			
				//为xmlHttpRequst对象设置回调函数
				xmlHttpRequest.onreadystatechange = callback;
				
				//发出请求
				xmlHttpRequest.send(null);
				//alert("111");
	 }
	 
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
						//alert("222222");
						var username = document.getElementById("username").value;
						location.href="servlet/indexServlet?username="+username;
					} else{
						//alert("33333");
						var errMsg = document.getElementById("errMsg");
						errMsg.style.color="red";
						errMsg.style.display="block";
						errMsg.innerHTML="账号密码错误";
					}
								
				}
				
			}
						
		}

</script>

	<body>
		<div id="contain">
			<div id="head">
				r<img src="image/logo.gif" />
			</div>
			<div id="main">
				<ul class="main-recommend-list">
					<li>
						<a href="">在线充值</a>
						<p>冲100送5，冲200送12，多冲多送</p>
					</li>
					<li>
						<a href="">选号购机</a>
						<p>海量靓号免费选，在线购机优惠多</p>
					</li>
					<li>
						<a href="">优惠活动</a>
						<p>话费免费领，登录有惊喜！缤纷活动尽在促销 优惠专区</p>
					</li>


					<li>
						<a href=""> 查询办理</a>
						<p>千余项业务查询办理，让您轻松掌握、自在选择！</p>
					</li>
				</ul>
				<div id="main-loginBox">

					<ul id="main-loginBox-tab">
						<li>
							<span class="current" id="current">用户登录</span>
						</li>
					</ul>


					<form class="main-loginBox-center" id="myform" action="servlet/loginServlet" method="get">

						<div class="tusername">
							<span>账户</span>
							<input type="text" id="username" name="username" onblur="checkUser()"/>
							<span id="userMsg" style="color:red">${errMsg.userMsg }</span>
							<br>
						</div>
						<div class="tpassword">
							<span>密码</span>
							<input type="password" id="pwd" name="pwd" onblur="checkPwd()"/>
							<span id="pwdMsg" style="color:red">${errMsg.pwdMsg }</span>
						</div>
						<div class="submitbutt">
						
						<button type="button" onclick="login()">
							<font color="#ffffff" size="4">登录</font>
						</button>
												 
						 <%-- 
						 <input type="button" value="登录" onclick="login()" style="font-size: 17px" " />	
						 --%>
						 						 
							<a href="register.jsp"> <span id="register"
								style="display: ''; font-size: 17px">立即注册！</span> </a>
						</div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="errMsg"></span>
					</form>
				</div>
			</div>


		</div>
	</body>
</html>
