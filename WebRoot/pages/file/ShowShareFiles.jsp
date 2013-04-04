<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowShareFiles.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="StyleSheet" href="css/common/dtree.css" type="text/css" />
	<link rel="stylesheet" type="text/css" href="css/common/table.css">
	<script type="text/javascript" src="javascript/common/dtree.js"></script>
  </head>
  
  <body>
     <div style="float:left;width:20%">
    	
		<a href="javascript: d.openAll();">打开全部</a> | <a
			href="javascript: d.closeAll();">关闭全部</a>
		<script> 
			var d=new dTree("d"); 
		</script>
		<!--循环为树添加内容-->
		<c:forEach items="${nodes}" var="n">
			<script> 
				d.add('${n.id}','${n.pid}','${n.name}','${n.url}','${n.title}','${n.target}','${n.icon}','${n.iconOpen}','${n.open}');
			</script>
		</c:forEach>
		<!--显示结果-->
		<script> 
			document.write(d);
		</script>
		
	</div>
	
	<div style="width:80%;height:100%;overflow:auto;">
	
	<iframe name="main_right" frameborder="0" width="100%" height="100%">
		<jsp:include page="ListFiles.jsp"></jsp:include>
	</iframe>
	</div>
  </body>
</html>
