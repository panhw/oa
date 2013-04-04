<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'SetFile.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="javascript/file/setfile.js"></script>

</head>

<body>
	
	<table width="100%">
		<tr>
		<th width="50%">文件夹</th>
		<th width="50%">共享设置</th>
		</tr>
		<c:forEach items="${folders }" var="folder">
		
			<tr>
				<td>${folder.virtualPath}</td>
				<td>
				
				<c:if test="${folder.state ne '3' }">
					<button id="shareBtn${folder.fileId}" onclick="shareClick(${folder.fileId});">设为共享</button>
				</c:if>
				<c:if test="${folder.state eq '3' }">
					<button id="shareBtn${folder.fileId}" onclick="shareClick(${folder.fileId});">取消共享</button>
				</c:if>
				</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>
