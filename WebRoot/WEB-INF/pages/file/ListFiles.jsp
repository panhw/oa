<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ListFiles.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	
  	<table width="100%" >
  	    <c:if test="${!empty files}">
	  	    <thead>
	  	    	<tr>
	  	    		<th >文件 </th>
	  	    		
	  	    	</tr>
	  	    
	  	    </thead>
  	    </c:if>
  		
	    <c:forEach items="${files}" var="file">
	    	<tr>
	    		<td>
	    			<a href="servlet/FileDownLoadServlet?fileId=${file.fileId}">${file.fileName}</a>
	    		</td>
	    	
	    	</tr>
	    	
	    </c:forEach>
    </table>
  </body>
</html>
