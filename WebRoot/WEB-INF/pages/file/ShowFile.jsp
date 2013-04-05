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
    
    <title>My JSP 'ShowFile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="js/common/dtree.js"></script>
	<script type="text/javascript" src="js/common/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/common/jquery-ui-1.8.23.custom.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/common/jquery-ui-1.8.23.custom.css">
	<link rel="StyleSheet" href="css/file/showfile.css"  type="text/css"/>
	 <script type="text/javascript">
		$(function() {	
				
			$( "#fileUploadDiv" ).dialog({
				autoOpen: false,
				height: 200,
				width: 350,
				modal: true
			});
			
			$( "#uploadBtn" ).click(function(){
				$("#fileUploadDiv").dialog("open");
			});	
			
			$( "#setFileDiv" ).dialog({
				autoOpen: false,
				height: 600,
				width: 800,
				modal: true
			});
			
			$( "#setFileBtn" ).click(function(){
				$("#setFileDiv").dialog("open");
			});	
			
			$( "#addFolderDiv" ).dialog({
				autoOpen: false,
				height: 200,
				width: 350,
				modal: true
			});
			
			$( "#addFolderBtn" ).click(function(){
				$("#addFolderDiv").dialog("open");
			});	
			
			
								

	});
	</script>
  </head>
  
  <body>
    <div style="float:left;width:20%">
    	j<input type="button" value="上传" id="uploadBtn"/>
    	<input type="button" value="共享" id="setFileBtn"/>
    	<button id="addFolderBtn">添加</button>
    	<br />
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
	<iframe width="2%" height="2%">
		11111111111
	</iframe>
	<iframe width="2%" height="2%">
		22222222	
	</iframe>
	<iframe width="40%" height="40%">
		<%@ include file="ListFiles.jsp"  %>	
	</iframe>
<!-- 	<iframe name="main" frameborder="0" width="100%" height="100%"> -->
		333333333333333333
		<input type="text" />
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
	    			<a href="/oa/fileAction?fatherid=${file.fatherfile.id}">${file.fileName}</a>
	    		</td>
	    	
	    	</tr>
	    	
	    </c:forEach>
    </table>
<!-- 	</iframe> -->
	</div>
	
	<div id="fileUploadDiv" >
	<form action="/oa/fileUpAction!add" method="post" enctype="multipart/form-data">
		<a href="javascript:void(0);" class="btn_addPic">
    	<span><em>+</em>添加文件</span>
    	<input  name="headImage"class="filePrew" type="file"/>
		    	
    	</a>
    	文件夹 ：<select name="fatherid">
						<c:forEach  items="${folders}" var="f">
							<option value="${f.fatherfile.id}">${f.fileName}</option>
						</c:forEach>
					
					</select>
		<br />
    	<input type="submit" value="提交"/>
	</form>
	</div>
	<div id="addFolderDiv">
		<form action="servlet/AddFolderServlet">
			父类文件夹:<select name="fatherid">
						<c:forEach  items="${folders}" var="f">
							<option value="${f.fatherfile.id}">${f.fileName}</option>
						</c:forEach>
					
					</select>
			<br />
			文件夹名:<input type="text" name="folderName" />
			<br />
		
			<input type="submit" value="提交"/>
		</form>
	
	</div>
	<div id="setFileDiv">
		<jsp:include page="SetFile.jsp"></jsp:include>
	</div>
	

  </body>
</html>
