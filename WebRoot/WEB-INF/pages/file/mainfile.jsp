<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showlist.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>

	<table id="data" width="100%" align="center">
		<thead>
			<tr>
				<th>文件</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${files}" var="file">
			<tr>
				<td><div align="center">
						<c:if test="${file.type eq '0' }">
							<a href="/oa/fileAction!files?fatherid=${file.fatherfile.id}">${file.fileName}</a>
						</c:if>
						<c:if test="${file.type eq '1' }">
							<a href="/oa/fileLoadAction?fileName=${file.url}">${file.fileName}</a>
						</c:if>
					</div></td>
				<td><div align="center">
						<c:if test="${file.type eq '0' }"></c:if>
						<c:if test="${file.type eq '1' }">
							<a href="/oa/fileLoadAction?fileName=${file.url}">${file.fileName}</a>
							<c:if test="${file.state eq '2' }"><a>取消共享</a></c:if>
							<c:if test="${file.state eq '1' }"><a>设为共享</a></c:if>
							<a href="/oa/fileLoadAction!del?id=${file.id}">删除</a>
						</c:if>
				</div></td>
		</c:forEach>

		<tr>
			<td colspan="5"><a
				href="/oa/fileAction!files?pageNO=${pageNO-1 }&fatherid=${fatherid }">上一页</a> 
				当前第${pageNO }页共${all }页 <a href="/oa/fileAction!files?pageNO=${pageNO+1 }&fatherid=${fatherid }">下一页</a>
			</td>
		</tr>
	</table>
</body>
<script>
	

  	//删除
  	function deleteBtn(){
  		
	  	var ids =  document.getElementsByName('ID');
  		var empid = '';
  		var j = 0;
	  	for(var i=0; i<ids.length; i++){
	  		if(ids[i].checked){
	  			j++;
	  			empid += ids[i].value + ';';
	  		}
	  	}
	  	if(j == 0){
	  		alert('请至少选择一条数据进行操作！1');
	  	}else{
	  		
				if(confirm("您确定要将选中的数据删除吗？")){
	//				removeDefaultHintMsg();
		  			document.frm.action='/oa/email!delet?empid='+empid;	
		  			alert("删除");
		  			document.frm.submit();
	  			}
	  		
  		}
  	}
  	
  	//彻底删除
  	function delBtn(){
  		alert("彻底删除");
	  	var ids =  document.getElementsByName('ID');
  		var empid = '';
  		var j = 0;
	  	for(var i=0; i<ids.length; i++){
	  		if(ids[i].checked){
	  			j++;
	  			empid += ids[i].value + ';';
	  		}
	  	}
	  	if(j == 0){
	  		alert('请至少选择一条数据进行操作！');
	  	}else{
	  		var flag = 'true';
	  		if(flag == 'true'){
				if(confirm("您确定要将选中的数据删除吗？")){
	//				removeDefaultHintMsg();
		  			document.frm.action='/oa/email!del?empid='+empid;
		  				
		  			document.frm.submit();
	  			}
	  		}
  		}
  	}
  	
  	//彻底删除
  	function readBtn(){
  		alert("读");
	  	var ids =  document.getElementsByName('ID');
  		var empid = '';
  		var j = 0;
	  	for(var i=0; i<ids.length; i++){
	  		if(ids[i].checked){
	  			j++;
	  			empid += ids[i].value + ';';
	  		}
	  	}
	  	if(j == 0){
	  		alert('请至少选择一条数据进行操作！');
	  	}else{
	  		var flag = 'true';
	  		if(flag == 'true'){
				if(confirm("您确定要将选中的数据删除吗？")){
//					removeDefaultHintMsg();
		  			document.frm.action='/oa/email!reRead?empid='+empid;
		  				
		  			document.frm.submit();
	  			}
	  		}
  		}
  	}
  	
  	
  	//还原
  	function huanBtn(){
  		
	  	var ids =  document.getElementsByName('ID');
  		var empid = '';
  		var j = 0;
	  	for(var i=0; i<ids.length; i++){
	  		if(ids[i].checked){
	  			j++;
	  			empid += ids[i].value + ';';
	  		}
	  	}
	  	if(j == 0){
	  		alert('请至少选择一条数据进行操作！1');
	  	}else{
	  		
				if(confirm("您确定要将选中的数据删除吗？")){
	//				removeDefaultHintMsg();
		  			document.frm.action='/oa/email!huan?empid='+empid;	
		  			alert("还原");
		  			document.frm.submit();
	  			}
	  		
  		}
  	}
  	
  	//清空
  	function qingBtn(){
  		
				if(confirm("您确定要清空垃圾箱吗？")){
	//				removeDefaultHintMsg();
		  			document.frm.action='/oa/email!qing';	
		  			alert("清空");
		  			document.frm.submit();
	  			}
	  		

  	}
  	
  
  </script>
</html>
