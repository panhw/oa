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
	<form name="frm" method="post" action=""> 
		主题：<input type="text" id="topical"  value=${information.topical } /> <br />
		发件人：<input type="text" id="tid" readonly="readonly" value=${information.empSend.id } />
			<input type="hidden" name="empid" id="hid" value=${information.id } ><br />		
		<textarea rows="20" cols="50" name="information.info">${information.info }</textarea><br />
		<input type="button" value="删除" onclick="deleteBtn()"/>
		<input type="button" value="彻底删除" onclick="delBtn()"/>
		<c:if test="${information.state !='3' }">
		<input type="button" value="回复" onclick="reply()" />
		<input type="button" value="转发" onclick="intransit()" />
		</c:if>
		<input type="button" value="返回" onclick="ret()" />
	</form>
</body>

<script type="text/javascript">
	
	//删除
	function deleteBtn(){
  		
		 document.frm.action='/oa/email!delet';	
		 alert("删除");
		 document.frm.submit();
  	}
  	
  	//彻底删除
  	function delBtn(){
  		document.frm.action='/oa/email!del';
		alert("彻底删除");
		document.frm.submit();
  	}
  	//转发
  	function intransit(){
  		document.frm.action='/oa/email!intransit';
		alert("转发");
		document.frm.submit();
  	}
  	//回复
  	function reply(){
  		document.frm.action='/oa/email!replyinfor';
		alert("回复");
		document.frm.submit();
  	}
  	//返回
  	function ret(){
  		document.frm.action='/oa/bfrmainInfor';
		alert("返回");
		document.frm.submit();
  	}
  	//发送
  	//返回
  	function send(){
  		document.frm.action='/oa/email!sender';
		alert("发送");
		document.frm.submit();
  	}
</script>
</html>