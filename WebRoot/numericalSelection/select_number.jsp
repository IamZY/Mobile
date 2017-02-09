<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.domain.*" %>

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
<script>

        /**
		 	选择城市，选中某个城市城市颜色变为背景颜色变为
			红色，边框变为黄色
		 */
		function chooseCity(ii){
		
			//ii代表选中的li对象
			var temp = document.getElementById('myul');
			var lis = temp.getElementsByTagName('li');  //获得ul下面所有的li对象
		    
            for(var i = 0; i < lis.length; i ++){       
			 
				  if(lis[i].getAttribute("value")==ii.getAttribute("value")){ 
				  //遍历li对象，循环对比li对象value值是否和传入ii对象值是否一致
						lis[i].style.background="#FFDDDD";
						lis[i].style.borderColor="#FFCC00";
						console.log(lis[i].innerHTML);
						var city = document.getElementById("city");
						city.value = lis[i].getAttribute("value");
						
				  }else{				  
						 lis[i].style.background="#E1E1E1";
						 lis[i].style.borderColor="#BEBEBE";				  
				  }
			
		     }
			
		}
		
		/*
			选择话费的类型
		*/
		function query_telfee(ii,ul_id){
		
			temp = document.getElementById(ul_id);
			lis = temp.getElementsByTagName('li');
	
			for(var i = 0; i < lis.length; i ++){		
				if(lis[i].getAttribute("value")==ii.getAttribute("value")){
				   lis[i].style.background="#03AFEB";
				   lis[i].style.color="white";
				   console.log(lis[i].innerHTML);
				   var telfee = document.getElementById("telfee");
				   telfee.value = lis[i].getAttribute("value");			   
				}else{
					lis[i].style.background="white";
				    lis[i].style.color="#666666"; 
			   }		   
			}				
		}
		
		/**
			选择号段的类型
		*/
		function query_dnseg(ii,ul_id){
		
			temp = document.getElementById(ul_id);
			lis = temp.getElementsByTagName('li');
	
			for(var i = 0; i < lis.length; i ++){		
				if(lis[i].getAttribute("value")==ii.getAttribute("value")){
				   lis[i].style.background="#03AFEB";
				   lis[i].style.color="white";
				   console.log(lis[i].innerHTML);
				   var teldnseg = document.getElementById("teldnseg");
				   teldnseg.value = lis[i].getAttribute("value");			   
				}else{
					lis[i].style.background="white";
				    lis[i].style.color="#666666"; 
			   }		   
			}				
		}
		
		/**
			选择手机卡的类别
		*/
		function query_type(ii,ul_id){
		
			temp = document.getElementById(ul_id);
			lis = temp.getElementsByTagName('li');
	
			for(var i = 0; i < lis.length; i ++){		
				if(lis[i].getAttribute("value")==ii.getAttribute("value")){
				   lis[i].style.background="#03AFEB";
				   lis[i].style.color="white";
				   console.log(lis[i].innerHTML);
				   var teltype = document.getElementById("teltype");
				   teltype.value = lis[i].getAttribute("value");			   
				}else{
					lis[i].style.background="white";
				    lis[i].style.color="#666666"; 
			   }		   
			}				
		}
		
						
		
</script>


	</head>


	<body>

		<div id="select_number_contain">
			<div id="select_number_main_main">
			
				<ul class="loc" id="myul">
					<li onclick="chooseCity(this)" value="南京"> 
						南京 
					</li>
					<li onclick="chooseCity(this)" value="镇江">
						镇江
					</li>
					<li onclick="chooseCity(this)" value="常州">
						常州
					</li>
					<li onclick="chooseCity(this)" value="无锡">
						无锡
					</li>
					<li onclick="chooseCity(this)" value="苏州">
						苏州
					</li>
					<li onclick="chooseCity(this)" value="南通">
						南通
					</li>
					<li onclick="chooseCity(this)" value="泰州">
						泰州
					</li>
					<li onclick="chooseCity(this)" value="扬州">
						扬州
					</li>
					<li onclick="chooseCity(this)" value="宿迁">
						宿迁
					</li>
					<li onclick="chooseCity(this)" value="淮安">
						淮安
					</li>
					<li onclick="chooseCity(this)" value="徐州">
						徐州
					</li>
					<li onclick="chooseCity(this)" value="连云港">
						连云港
					</li>
					<li onclick="chooseCity(this)" value="盐城">
						盐城
					</li>
				</ul>
				
				<div class="clear"></div>
				
				<ul class="fee" id="my-ul-fee">
					<li>
						<span class="numb-form">预存话费</span>
					</li>
					<li onclick="query_telfee(this,'my-ul-fee')" value="" class="renyi">
						任意
					</li>
					<li onclick="query_telfee(this,'my-ul-fee')" value="50">
						50元
					</li>
					<li onclick="query_telfee(this,'my-ul-fee')" value="100">
						100元
					</li>
					<li onclick="query_telfee(this,'my-ul-fee')" value="200">
						200元
					</li>
					<li onclick="query_telfee(this,'my-ul-fee')" value="300">
						300元
					</li>
					<li onclick="query_telfee(this,'my-ul-fee')" value="400">
						400元
					</li>
					<li onclick="query_telfee(this,'my-ul-fee')" value="500">
						500元
					</li>
					<li onclick="query_telfee(this,'my-ul-fee')" value="600">
						600元
					</li>
					<li onclick="query_telfee(this,'my-ul-fee')" value="800">
						800元
					</li>
				</ul>
				
				<div class="clear"></div>
				<ul id="dnseg">
					<li>
						<span class="numb-form">号段</span>
					</li>
					<li class="renyi" onclick="query_dnseg(this,'dnseg')" value="">
						任意
					</li>
					<li onclick="query_dnseg(this,'dnseg')" value="13X">
						13X
					</li>
					<li onclick="query_dnseg(this,'dnseg')" value="15X">
						15X
					</li>
					<li onclick="query_dnseg(this,'dnseg')" value="18X">
						18X
					</li>
				</ul>
				<div class="clear"></div>
				
				<ul id="type">
					<li>
						<span class="numb-form">手机卡类别</span>
					</li>
					<li class="renyi" onclick="query_type(this,'type')" value="">
						任意
					</li>
					<li onclick="query_type(this,'type')" value="4G">
						4G
					</li>
					<li onclick="query_type(this,'type')" value="3G">
						3G
					</li>
					<li onclick="query_type(this,'type')" value="GSM">
						GSM
					</li>
				</ul>
				<div class="clear"></div>
				
				<div id="search">
				<form action="servlet/SelectNumberServlet" method="get">
					<input type="hidden" name="city" id="city"/>
					<input type="hidden" name="telfee" id="telfee"/>
					<input type="hidden" name="teldnseg" id="teldnseg"/>
					<input type="hidden" name="teltype" id="teltype"/>
					<%--
					<input type="hidden" name="flag" id="flag" value="select"/>
					 --%>
					<span class="numb-form">指定数字</span>
					<input type="text" name="inputstyle" id="inputstyle" />
					<button type="submit" id="sousuo" ></button>
				</form>		
				</div>
				
				
				<div class="clear"></div>
				<table width="700" class="table-infor-record-style">
					<tr>
						<th>号码</th>
						<th>号码归属地</th>
						<th>预存话费</th>
						<th>操作</th>
					</tr>

					<%
						List<Mobile> list = (List<Mobile>)request.getAttribute("mobilelist");
						if(list == null){
							
						}else{
						
						for(Mobile m : list){						
						
						
					%>
					
					<tr>
						<td><%=m.getTelNumber() %></td>
						<td><%=m.getTelAdd() %></td>
						<td><%=m.getTelAccount() %></td>
						<td>
							<div align="center">
								<input type="button" class="buy" value="立即购买"
									onclick="location.href='servlet/SelectNumberBysetmealServlet?telnumber=<%=m.getTelNumber() %>&teladd=<%=m.getTelAdd() %>&telaccount=<%=m.getTelAccount() %>' " />
							</div>
						</td>
					</tr>
								
					<%	
						
						}
					}
					 %>
					 
				</table>
				<div id="clear"></div>
				<table class="table-infor-record-style" id="page">
					<tr>
						<th width="113">
							第${currentpage }页/共${end }页
						</th>
						
						<td>
						
						<form action="servlet/SelectNumberServlet" method="get">
							<input type="hidden" name="city" id="city" value="<%=request.getAttribute("city") %>">
							<input type="hidden" name="telfee" id="telfee" value="<%=request.getAttribute("telfee") %>">
							<input type="hidden" name="teldnseg" id="teldnseg" value="<%=request.getAttribute("teldnseg") %>">
							<input type="hidden" name="teltype" id="teltype" value="<%=request.getAttribute("teltype") %>">
							<input type="hidden" name="inputstyle" id="inputstyle" value="<%=request.getAttribute("inputstyle") %>" >
							
							<a href="servlet/SelectNumberServlet?city=<%=request.getAttribute("city") %>&telfee=<%=request.getAttribute("telfee") %>&teldnseg=<%=request.getAttribute("teldnseg") %>&teltype=<%=request.getAttribute("teltype") %>&inputstyle=<%=request.getAttribute("inputstyle") %>&currentpage=1">首页</a> 
							<a href="servlet/SelectNumberServlet?city=<%=request.getAttribute("city") %>&telfee=<%=request.getAttribute("telfee") %>&teldnseg=<%=request.getAttribute("teldnseg") %>&teltype=<%=request.getAttribute("teltype") %>&inputstyle=<%=request.getAttribute("inputstyle") %>&currentpage=${currentpage-1 }">上一页</a>
							<a href="servlet/SelectNumberServlet?city=<%=request.getAttribute("city") %>&telfee=<%=request.getAttribute("telfee") %>&teldnseg=<%=request.getAttribute("teldnseg") %>&teltype=<%=request.getAttribute("teltype") %>&inputstyle=<%=request.getAttribute("inputstyle") %>&currentpage=${currentpage+1 }">下一页</a> 
							<a href="servlet/SelectNumberServlet?city=<%=request.getAttribute("city") %>&telfee=<%=request.getAttribute("telfee") %>&teldnseg=<%=request.getAttribute("teldnseg") %>&teltype=<%=request.getAttribute("teltype") %>&inputstyle=<%=request.getAttribute("inputstyle") %>&currentpage=${end }">尾页</a>
							<input type="text" id="currentpage" name="currentpage" class="input-page-style">
							
							<%-- 
							<input type="hidden" name="flag" id="flag" value="go"/>
							--%>
							<input type="submit" value="go" />							
						</form>
						
						</td>
							
					</tr>
				</table>


			</div>
		</div>

	</body>
</html>
