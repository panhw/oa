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
    g共（${many+noreading }）未读邮件 
     
    <form name="frm" id="frm" action="" method="post">
    <c:if test="${state != 6 }">
  		<input type="button" value="删除" onclick="deleteBtn()"/>
  	</c:if>
  	<input type="button" value="彻底删除" onclick="delBtn()" />
  	 <c:if test="${state != 5 }">
  			<input type="button" value="标记为已读" onclick="readBtn()" />
  	</c:if> 
  	<c:if test="${state eq 6 }">
  		<input type="button" value="还原" onclick="huanBtn()"/>
  		<input type="button" value="清空" onclick="qingBtn()"/>
  	</c:if>
  	
  			<table id="data" width="100%" align="center">
				<tr>
					<th width="5%"><input type="checkbox" id="IDS" name="IDS" onclick="selectAll(this,'ID')"/></th>
					<th width="20%">发件人</th>
					<th width="40%">主题</th>
					<th width="10%">状态</th>
					<th width="25%">日期</th>
		
				</tr>
				
				<c:forEach items="${infors }" var="infor">
					<tr>
					<td><div align="center">
						<c:if test="${empty infor.id }">
							<input type="checkbox" name="ID" id="ID" style="visibility: hidden" value=${infor.id } >
						</c:if>
						<c:if test="${!empty infor.id }">
							<input type="checkbox" name="ID" id="ID" value=${infor.id } >
						</c:if>
						</div>
					</td>
					<td><div align="center">${infor.empSend.id }</div></td>
					<td><a href="/oa/email!read?empid=${infor.id }">${infor.topical }</a></td>
					<c:if test="${infor.status eq '1' }">
						<td><div align="center">未读</div></td>
					</c:if>
					<c:if test="${infor.status eq '0' }">
						<td><div align="center">已读</div></td>
					</c:if>
					<td><div align="center">${infor.date }</div></td>					
				</tr>
				</c:forEach>
				
				<tr>
					<td colspan="5">
						<a href="/oa/email!allNoRead?pageNO=${pageNO-1 }">上一页</a>
						当前第${pageNO }页共${all }页
						<a href="/oa/email!allNoRead?pageNO=${pageNO+1 }">下一页</a>
					</td>
				</tr>
			</table>
  	</form>
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
