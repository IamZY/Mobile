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
		<script type="text/javascript" src="myjs.js"></script>
		<script>
			function setDiscount(i){
			
				console.log(i);
				//ajax验证
				//获得xmlHttpRequest对象
				getXMLHttpRequest();
				//打开URL地址
				
				//获取参数请求
				//准备url
				var url = "servlet/OnlineRechargeServlet?radio="+i;
				//alert(url);
				//打开
				xmlHttpRequest.open("post",url,true);
			
				//为xmlHttpRequst对象设置回调函数
				xmlHttpRequest.onreadystatechange = callback;
				
				//发出请求
				xmlHttpRequest.send(null);
				
			}
			
		function callback(){

			if(xmlHttpRequest.readyState == 4){
				//alert(xmlHttpRequest.readyState); //4
				console.log(xmlHttpRequest.readyState);
				if(xmlHttpRequest.status == 200){
					//alert(xmlHttpRequest.status);   //200
					console.log(xmlHttpRequest.status);
					//alert(xmlHttpRequest.responseText);
					//alert(xmlHttpRequest.responseXML);
					var res = xmlHttpRequest.responseXML.getElementsByTagName("result"); //null
					
					
					var result;
									
					for(var i = 0;i < res.length;i++){
						result = res[i].firstChild.nodeValue;
					}
					
					var values = result.split(",");
							
					//alert(values[0]);	//8			
					document.getElementById("discount").value = values[0]; //8
					//alert(values[1]);	//8	
					document.getElementById("sumprice").value = parseInt(values[0])+parseInt(values[1]); //8
					//console.log(result + document.getElementById("radio").value);
						
				}
				
			}
		}
			
			
			
		</script>
	</head>



	<body>
		<div id="online-contain">

			<div id="card-procedure2"></div>
			<div id="online-main">


				<form method="get" action="servlet/OnlineComfirmServlet" class="form-style">
					<table class="table-style-online">

						<tr>
							<td class="left-td-style">
								充值号码：
							</td>
							<td class="right-td-style">
								<input type="text" name="telnumb" id="telnumb" size="20" class="input-form-style"
									value="${telnumb }">
							</td>
						</tr>
						<tr>
						
							<td class="left-td-style">
								充值金额：
							</td>
							
							<td class="right-td-style">
								<input type="radio" name="value" id="radio" value="20"
									onclick="setDiscount(this.value)" />
								20元
								<input type="radio" name="value" id="radio" value="50"
									onclick="setDiscount(this.value)">
								50元
								<input type="radio" name="value" id="radio" value="100"
									onclick="setDiscount(this.value)" />
								100元
								<input type="radio" name="value" id="radio" value="200" checked="checked"
									onclick="setDiscount(this.value)" />
								200元
								<input type="radio" name="value" id="radio" value="500"
									onclick="setDiscount(this.value)">
								500元
								<input type="radio" name="value" id="radio" value="1000"
									onclick="setDiscount(this.value)" />
								1000元
								
							</td>
							
						</tr>
						
						<tr>
							<td class="left-td-style">
								充值优惠：
							</td>
							<td class="right-td-style">
								<input type="text" readOnly="readOnly" name="discount"
									id="discount" size="20" class="input-form-style" value="15">
							</td>
						</tr>
						<tr>
							<td class="left-td-style">
								实际到账：
							</td>
							<td class="right-td-style">
								<input type="text" name="sumprice" id="sumprice" size="20"
									class="input-form-style" value="215">
							</td>
						</tr>

						<tr class="button-tr-style">
							<td colspan="2" class="left-td-style">
								<input type="submit" value="下一步" class="button-sub"/>
								<input type="reset" value="重置" class="button-res" />
							</td>
						</tr>
					
					</table>
				</form>

			</div>

		</div>
	</body>
</html>
