<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.domain.Business"%>
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
		<link href="<%=basePath%>/css/index.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>/css/reset.css" rel="stylesheet" type="text/css" />
		<title>无标题文档</title>

	</head>
	<script type="text/javascript" src="myjs.js"></script>
	
<script type="text/javascript">
	function switchStatus(businessid,target){
		//获取业务的当前状态
		var status = target.parentNode.childNodes[1].value;
		alert(status);
		
		if(status == 0){
			//target.value="开通";
			//target.parentNode.childNodes[0].value = 0;
			//关闭
			alert("close");
			getXMLHttpRequest();
			//打开URL地址
			
				//获取参数请求
				//准备url
				var url = "servlet/BusinessIsCloseServlet?businessid="+businessid+"&telnumb="+${telnumb };
				alert(url);
				//打开
				xmlHttpRequest.open("post",url,true);
				//为xmlHttpRequst对象设置回调函数
				xmlHttpRequest.onreadystatechange = callbackend;
				//发出请求
				xmlHttpRequest.send(null);
				alert("111");		
		
		
		

		}else{
			//target.value="关闭";
			//target.parentNode.childNodes[0].value = 1;
			alert("open");
			//获得xmlHttpRequest对象
			getXMLHttpRequest();
			//打开URL地址
			
				//获取参数请求
				//准备url
				var url = "servlet/BusinessIsOpenServlet?businessid="+businessid+"&telnumb="+${telnumb };
				alert(url);
				//打开
				xmlHttpRequest.open("post",url,true);
				//为xmlHttpRequst对象设置回调函数
				xmlHttpRequest.onreadystatechange = callback;
				//发出请求
				xmlHttpRequest.send(null);
				alert("222");		
		}

	}



	function callback(){
			alert("call back");
			//alert(xmlHttpRequest.readyState);
			if(xmlHttpRequest.readyState == 4){
				//alert(xmlHttpRequest.readyState); //4
				console.log(xmlHttpRequest.readyState);
				if(xmlHttpRequest.status == 200){
					//alert(xmlHttpRequest.status);   //200
					console.log(xmlHttpRequest.status);
					alert(xmlHttpRequest.responseText);
					var res = xmlHttpRequest.responseXML.getElementsByTagName("result"); //null
					
					var result;
									
					for(var i = 0;i < res.length;i++){
						result = res[i].firstChild.nodeValue;
					}
					
					var open = document.getElementById("open");
				
					alert(result);	//true		
					if(result == "true"){
						//将开通变成关闭
						alert("value is true");
						location.href="servlet/ReplacementServlet?telnumb=${telnumb }";
					} else{
						//alert("33333");
						alert("开通失败");
					}
								
				}
				
			}
						
		}



	function callbackend(){
			alert("call back_end");
			//alert(xmlHttpRequest.readyState);
			if(xmlHttpRequest.readyState == 4){
				//alert(xmlHttpRequest.readyState); //4
				console.log(xmlHttpRequest.readyState);
				if(xmlHttpRequest.status == 200){
					//alert(xmlHttpRequest.status);   //200
					console.log(xmlHttpRequest.status);
					alert(xmlHttpRequest.responseText);
					var res = xmlHttpRequest.responseXML.getElementsByTagName("result"); //null
					
					var result;
									
					for(var i = 0;i < res.length;i++){
						result = res[i].firstChild.nodeValue;
					}
								
					alert(result);	//true		
					if(result == "true"){
						//将关闭变开通
						alert("value is close");
						location.href="servlet/ReplacementServlet?telnumb=${telnumb }";
					} else{
						alert("关闭失败");
					}
								
				}
				
			}
						
		}



</script>


	<body id="changebus-body">
		<div id="changebus-contain">
			<div id="changebus-main">

				<div class="ywbl"></div>

				<table class="table-infor-record-style2" width="700px">
					<tr>
						<th width="20%">业务名称</th>
						<th width="10%">资费</th>

						<th width="25%">启用时间</th>
						<th width="25%">终止时间</th>
						<th width="20%">操作</th>
					</tr>
					
					<%
						List<Business> list = (List<Business>)request.getAttribute("blist");
						for(Business business : list){	
					%>
					
					<tr>
						<td>
							<%=business.getBname() %>
						</td>
						<td>
							<%=business.getZifei() %>
						</td>
						
						
						
						<td id='st2'><%=business.getStarttime() %></td>					
						<td id='ed2'><%=business.getEndtime() %></td>
						
						<% 
							if(business.getIsoptional().equals("1")){							
								if(business.getStarttime().equals("-") || !business.getEndtime().equals("-")){			
						%>
						
						<td>
							<form id="business" action="" method="get">
								<input type="hidden" name="status" value="1" />
								<input type="button" id="open" name="open" class="blywkt" value="开通" onclick="switchStatus(<%=business.getBid() %>,this)" />
							</form>
						</td>
						
						
						<% 		
								}else{
						%>		
							
						<td>
							<form id="business" action="" method="get">
								<input type="hidden" name="status" value="0" />
								<input type="button" id="open" name="open" class="blywkt" value="关闭" onclick="switchStatus(<%=business.getBid() %>,this)" />
							</form>
						</td>
								
						<% 		
								}
							}else {
						%>	
							
						<td></td>	
							
						<% 
							}
						%>	
						
					</tr>
					<% 	
						}						 
					%>
					
					
				</table>



				<div class="tcbl"></div>

				<table class="table-infor-record-style2" width="700px">
					<tr>
						<th>套餐名称</th>
						<th>套餐资费</th>
						<th>套餐详情</th>
						<th>操作</th>
					</tr>
					
					
					
					<%
						List<PhonePackage> phonelist = (List<PhonePackage>)request.getAttribute("phonelist");
						String ppid = (String)request.getAttribute("ppid");
						for(PhonePackage p : phonelist){				
					%>
					<tr>
						<td>神州行<%=p.getPpname() %></td>
						<td><%=p.getFee() %>元</td>
						<td>通话<%=p.getShichang() %>，流量<%=p.getLiuliang() %></td>
						
					<% 
						if(p.getPpid().equals(ppid)){
					%>	
						<td>
							<form>
								<input type="button" id='dqtc' name="meal" class="dqtc"
									value="当前套餐" />
							</form>
						</td>
					
					<% 
						}else {
					%>	
						<td>
							<form>
								<input type="submit" id='dqtc' name="meal" class="dqtc"
									value="开通" />
							</form>
						</td>
					<% 	
						}
					%>		
						
							
					</tr>
					
					<%	
						}
					 %>
				
				</table>
				
			</div>
			
		</div>

	</body>
</html>
