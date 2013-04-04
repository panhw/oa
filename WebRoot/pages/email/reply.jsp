<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reply.jsp' starting page</title>
    
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
    <form name="frm" method="post" action=""> 
		主题：<input type="text" id="topical"  value=${information.topical } /> <br />
		收件人：<input type="text" id="tid" readonly="readonly" value=${information.empSend.id } />
			<input type="hidden" name="hid" id="hid" value=${information.id } ><br />		
		<textarea rows="20" cols="50" name="information.info">
		
${information.info }</textarea><br />
		<input type="button" value="发送" onclick="deleteBtn()"/>
		<input type="button" value="返回" onclick="delBtn()"/>
	</form>
  </body>
  <script type="text/javascript">
  	//删除
	function deleteBtn(){
  		
		 document.frm.action='/oa/email!sender?empid='+getID("tid").value;	
		 alert("发送");
		 document.frm.submit();
  	}
  	
  	//彻底删除
  	function delBtn(){
  		document.frm.action='/oa/email!read?empid='+getID("hid").value;
		alert("返回");
		document.frm.submit();
  	}
  	function getID(id) {
  		return document.getElementById(id);
  	}
  </script>
</html>
