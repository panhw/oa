<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" method="post" action=""> 
		主题：<input type="text" name="information.topical" id="topical" /> <br />
		收件人：<input type="text" id="tid" readonly="readonly" />
			<input type="hidden" name="empid" id="hid" >
			<input type="button" value="清空" id="qinkong" />
			<input type="checkbox" name="qun" id="qun" />群发
			<select name="depart" id="depart" onchange="getEmps()">
				<option value="">--选择部门--</option>
				<option value="测试部">--测试部--</option>
			</select>
			<select id="emps">
				<option value="">--选择员工--</option>
				<option value="abc">张三</option>
				<option value="123">李四</option>
				<option value="234">王麻子</option>
			</select>
		<br />		
		<textarea rows="20" cols="50" name="information.info"></textarea><br />
		<input type="button" value="立即发送" onclick="sender()" />
		<input type="button" value="保存至草稿箱" onclick="save()"/>
	</form>
</body>

<script type="text/javascript">
	
	window.onload = function() {
	
		document.frm.onsubmit = function() {
			
			return getID("tid").value  !="" && getID("hid").value !="" && getID("topical").value  !="" ;
		}
		var flag = false;
		getID("qun").onclick = function() {
			if (flag) {
				flag = false;
			} else {
				flag = true;
			}
			if (flag) {
				getID("emps").style.visibility = "hidden";
				getID("depart").onchange=getDepart;
			} else {
				getID("emps").style.visibility = "visible";
				getID("depart").onchange=getEmps;
			}
		}
		
		getID("qinkong").onclick = function(){
			getID("tid").value="";
			getID("hid").value="";
		}
		
		getID("emps").onchange = function(){
			getID("tid").value +=this.value + ";";
			getID("hid").value +=this.value +";";
		}

	}

	function getDepart() {
		getID("tid").value =this.value;
		getID("hid").value =this.value;	
	}
	function getEmps(){
		alert("AJAX");
	}
	function sender() {
		document.frm.action = "/oa/email!sender";
		alert("发消息");
		document.frm.submit();
	}
	function save() {
		document.frm.action = "/oa/email!save";
		alert("保存到草稿箱");
		document.frm.submit();
	}
	function getID(id) {
		return document.getElementById(id);
	}
</script>
</html>