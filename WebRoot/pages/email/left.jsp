<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<ul>
		<li><a href="/oa/pages/email/send.jsp" target="mainframe">写消息</a></li>
		<li><a href="/oa/pages/email/bfrjsp/bfrrecieve.jsp" target="mainframe">收件箱（${noreading }）</a></li>
		<li><a href="/oa/pages/email/bfrjsp/bfrmany.jsp" target="mainframe">群消息（${many }）</a></li>
		<li><a href="/oa/pages/email/bfrjsp/bfrcaogao.jsp" target="mainframe">发件箱</a></li>
		<li><a href="/oa/pages/email/bfrjsp/bfrcaogao.jsp" target="mainframe">草稿箱（${caogao }）</a></li>
		<li><a href="/oa/pages/email/bfrjsp/bfrlaji.jsp" target="mainframe">垃圾箱（${laji }）</a></li>
	</ul>
</body>
</html>