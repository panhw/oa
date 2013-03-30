<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" method="post" action=""> 
		主题：<input type="text" id="topical"  value=${information.topical } /> <br />
		发件人：<input type="text" id="tid" readonly="readonly" value=${information.empSend.id } />
			<input type="hidden" name="empid" id="hid" value=${information.id } ><br />		
		<textarea rows="20" cols="50" name="information.info">${information.info }</textarea><br />
		<input type="button" value="删除" onclick="deleteBtn()"/>
		<input type="button" value="彻底删除" onclick="delBtn()"/>
		<input type="button" value="回复" onclick="reply()" />
		<input type="button" value="转发" onclick="intransit()" />
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
  		document.frm.action='/oa/email!reply';
		alert("回复");
		document.frm.submit();
  	}
</script>
</html>