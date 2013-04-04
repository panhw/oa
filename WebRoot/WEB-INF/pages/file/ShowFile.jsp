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
	<link rel="stylesheet" type="text/css" href="css/common/table.css">
	<script type="text/javascript" src="javascript/common/table.js"></script>
	<link rel="StyleSheet" href="css/common/dtree.css" type="text/css" />
	<script type="text/javascript" src="javascript/common/dtree.js"></script>
	<link rel="stylesheet" type="text/css" href="css/common/jquery-ui-1.8.23.custom.css">
	<script type="text/javascript" src="javascript/common/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="javascript/common/jquery-ui-1.8.23.custom.min.js"></script>
	<link rel="StyleSheet" href="css/file/showfile.css"  type="text/css"/>
	 <script type="text/javascript">
		$(function() {	
			onloadFunction();	
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
    	<input type="button" value="上传" id="uploadBtn"/>
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
	
	<iframe name="main_right" frameborder="0" width="100%" height="100%">
		<jsp:include page="ListFiles.jsp"></jsp:include>
	</iframe>
	</div>
	
	<div id="fileUploadDiv" >
	<form action="servlet/FileUploadServlet" method="post" enctype="multipart/form-data">
		<a href="javascript:void(0);" class="btn_addPic">
    	<span><em>+</em>添加文件</span>
    	<input  name="file" tabindex="3" 
		    	title="支持jpg、jpeg、gif、png格式，文件小于5M" 
		    	size="3" name="pic" class="filePrew" type="file"/>
		    	
    	</a>
    	文件夹 ：<select name="folderId">
						<c:forEach  items="${folders}" var="f">
							<option value="${f.fileId}">${f.virtualPath}</option>
						</c:forEach>
					
					</select>
		<br />
    	<input type="submit" value="提交"/>
	</form>
	</div>
	<div id="addFolderDiv">
		<form action="servlet/AddFolderServlet">
			父类文件夹:<select name="folderId">
						<c:forEach  items="${folders}" var="f">
							<option value="${f.fileId}">${f.virtualPath}</option>
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
