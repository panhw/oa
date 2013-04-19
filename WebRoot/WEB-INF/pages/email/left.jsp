<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/include/plugins.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<ul class="nav nav-tabs nav-stacked">
		<li><a href="/oa/email!add" target="mainframe">写消息</a></li>
		<li><a href="/oa/email!shou?state=3" target="mainframe">收件箱（${noreading }）</a></li>
		<li><a href="/oa/email!qun?state=2" target="mainframe">群消息（${many }）</a></li>
		<li><a href="/oa/email!fa?state=7" target="mainframe">发件箱</a></li>
		<li><a href="/oa/email!caogao?state=5" target="mainframe">草稿箱（${caogao }）</a></li>
		<li><a href="/oa/email!laji?state=6" target="mainframe">垃圾箱（${laji }）</a></li>
	</ul>
</body>
</html>