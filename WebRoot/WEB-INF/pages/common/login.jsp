<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/include/plugins.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线办公系统登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function login(){
			$.post("employee!login", {"employee.name": $("#inputName").val(), "employee.password": $("#inputPassword").val() } ,function(data){
				if (""==data) location.href="employee!index";
				else alert(data);
			});
		}
	</script>

  </head>

<body>

	<form class="form-horizontal" action="javascript:login()" style="margin-top: 150px;">
		<div class="control-group">
			<label class="control-label" for="inputEmail">登录名：</label>
			<div class="controls">
				<input type="text" class="input-large" id="inputName"
					name="employee.name" placeholder="登录名">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputPassword">密码：</label>
			<div class="controls">
				<input type="password" class="input-large" id="inputPassword"
					name="employee.password" placeholder="密码">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">登录</button>
			</div>
		</div>
	</form>

</body>
</html>
