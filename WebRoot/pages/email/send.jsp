<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" method="post" action="email!save"> 
		主题：<input type="text" name="information.topical" /> <br />
		收件人：<input type="text" name="empid" /><br />
		<textarea rows="20" cols="50" name="information.info"></textarea><br />
		<input type="button" value="立即发送" onclick="sub()" />
		<input type="submit" value="保存至草稿箱" />
	</form>
</body>

<script type="text/javascript">
	function sub(){
	
		document.frm.action="/oa/email!sender";
//		document.frm.action="/oa/pages/email/laji.jsp";
		alert("发消息");
		document.frm.submit();
	}
</script>
</html>