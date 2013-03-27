<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.icss.biz.organManager.organ.vo.OrganVO"%>
<%@page import="java.util.List"%>
<%@page import="com.icss.base.page.Page"%>
<%@page import="com.icss.base.web.BaseController"%>
<%@page import="com.icss.biz.smoke.vo.Smoke"%>
<%@page import="com.icss.biz.smoke.vo.Brand"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.RoundingMode"%>
<%@ taglib uri="/WEB-INF/tld/system_util.tld" prefix="sysutil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//获取分页对象
	Page pageObject = (Page)request.getAttribute("page");
	if( pageObject==null ){
		pageObject = new Page();
	}
	List dataList = pageObject.getDataList();
	String message = (String)request.getAttribute(BaseController.MESSAGE);
	
	//返回查询条件 
	String organCode = request.getAttribute("organCode")==null?"":(String)request.getAttribute("organCode");
	String organName = request.getAttribute("organName")==null?"":(String)request.getAttribute("organName");
	
	//判断当前用户是否为中心运维用户
	String isCenterMaster = (String)request.getAttribute("isCenterMaster");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script language="javascript" type="text/javascript" src="/DEMO/My97DatePicker/WdatePicker.js"></script>
  	<!-- collectInformationList.jsp -->
    <base href="<%=basePath%>">
    <title>机构管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="机构管理">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path%>/css/global.css" rel="stylesheet" type="text/css" id="styleCss">
  	<style type="text/css">
  		.buttonArea img {
			cursor: pointer;
		}
  	</style>
  </head>
  <body>
  	<form name="frm" id="frm" action="<%=path%>/servlet/SmokeController?method=getSmokeList" method="post">
  	<div class="pageQuery">
  		<div class="queryArea">
  			<table width="100%" align="center" border="0">
  				<tr>
  					<td height="30" align="right" nowrap="nowrap">品牌：</td>
					<td height="30" align="left" nowrap="nowrap">
						<%-- <input type="text" name="organCode" id="organCode" size="23" value="<%=organCode%>"/> --%>
						<select name="brand">
							<option value="test">请选择品牌</option>
							
							<option value="hong">红塔山</option>
							
						</select>
					</td>
					<td height="30" align="right" nowrap="nowrap">填报人：</td>
					<td height="30" align="left" nowrap="nowrap">
						<input type="text" name="reportPerson" id="person" size="23" value="${smoke.reportPerson }"/>
					</td>
					<td height="30" align="right" nowrap="nowrap">开始时间：</td>
					<td height="30" align="left" nowrap="nowrap">
						<input class="Wdate" type="text" onClick="WdatePicker()" name="startime" id="statartime" size="23" readonly="readonly" />
					</td>
					<td height="30" align="right" nowrap="nowrap">结束时间：</td>
					<td height="30" align="left" nowrap="nowrap">
						<input class="Wdate" type="text" onClick="WdatePicker()" name="endtime" id="endtime" size="23" readonly="readonly" />
					</td>
					
					<td width="50%" nowrap="nowrap"></td>
					
  				</tr>
			</table>
  		</div>
  		<div class="buttonArea">
  			<img id="btn_search" name="btn_search" src="/DEMO/pj_images/ico_bg01.jpg" onclick="searchBtn();"/>		
			<img id="btn_add" name="btn_add" src="/DEMO/pj_images/ico_bg07.jpg" onclick="addBtn();" />
			<img id="btn_modify" name="btn_modify" src="/DEMO/pj_images/ico_bg04.jpg" onclick="modifyBtn();" />
			<img id="btn_delete" name="btn_delete" src="/DEMO/pj_images/ico_bg06.jpg" onclick="deleteBtn();"/>
  		</div>
  		<div class="dataArea">
  			<table id="data" width="100%" align="center">
				<tr>
					<th width="2%"><input type="checkbox" id="IDS" name="IDS" onclick="selectAll(this,'ID')"/></th>
					<th width="3%">序号</th>
					<th width="9.5%">品牌</th>
					<th width="9.5%">是否填报</th>
					<th width="9.5%">填报人</th>
					<th width="9.5%">填报日期</th>
					<th width="9.5%">本期产量</th>
					<th width="9.5%">同期产量</th>
					<th width="9.5%">产量同比（%）</th>
					<th width="9.5%">本期销量</th>
					<th width="9.5%">同期销量</th>
					<th width="9.5%">销量同比（%）</th>
					
				</tr>
				
				<%
						if(dataList != null && dataList.size() > 0){
						for(int i=0, s=dataList.size(); i<s; i++){
							Smoke smoke = (Smoke)dataList.get(i);
							String id = smoke.getId();
							String brandName = "";
							if(smoke.getBrandName() != null && !"".equals(smoke.getBrandName())){
								brandName = smoke.getBrandName();
							}
							String ifReport = "";
							if(smoke.getIfReport()!=null && !"".equals(smoke.getIfReport())){
								ifReport = smoke.getIfReport();
							}
							String reportPerson = "";
							if(smoke.getReportPerson() != null && !"".equals(smoke.getReportPerson())){
								reportPerson = smoke.getReportPerson();
							}
							String reportDate = "";
							if(smoke.getReportDate() != null && !"".equals(smoke.getReportDate())){
								reportDate = smoke.getReportDate();
							}
							
							BigDecimal sellNum = null;
							if(smoke.getSellNum()!=null && !"".equals(smoke.getSellNum())){
								sellNum = smoke.getSellNum();
							}
							BigDecimal sellNuml = null;
							if(smoke.getSellNuml() != null && !"".equals(smoke.getSellNuml())){
								sellNuml = smoke.getSellNuml();
							}
							BigDecimal nbi = sellNum.divide(sellNuml,2,BigDecimal.ROUND_DOWN);
							BigDecimal c = new BigDecimal("100");
							BigDecimal sellSum = null;
							if(smoke.getSellSum() != null && !"".equals(smoke.getSellSum())){
								sellSum = smoke.getSellSum();
							}
							BigDecimal sellSum1 = null;
							if(smoke.getSellSuml() != null && !"".equals(smoke.getSellSuml())){
								sellSum1 = smoke.getSellSuml();
							}
							
							BigDecimal sbi = sellSum.divide(sellSum1,2,BigDecimal.ROUND_DOWN);
							/* sellSum.divide(sellSum1,3,BigDecimal.ROUND_DOWN) */
							
				%>
				<tr>
					<td><div align="center">
							<input type="checkbox" name="ID" id="ID<%=id%>" value="<%=id%>" onclick="releaseSelectAll('IDS')">
						</div>
					</td>
					<td><div align="center"><%=i+1%></div></td>
					<td><a href="<%=path%>/servlet/SmokeController?method=showSmokeInfo&id=<%=id%>&editFlag=N"><%=brandName%></a></td>
					<td><div align="center"><%=ifReport%></div></td>
					<td><div align="center"><%=reportPerson%></div></td>
					<td><div align="center"><%=reportDate%></div></td>
					<td><div align="center"><%=sellNum%></div></td>
					<td><div align="center"><%=sellNuml%></div></td>
					<td><div align="center"><%=nbi.multiply(c)%></div></td>
					<td><div align="center"><%=sellSum%></div></td>
					<td><div align="center"><%=sellSum1%></div></td>
					<td><div align="center"><%=sbi.multiply(c)%></div></td>
				</tr>
				<% 
						}
					}	
				%>	
			</table>
  		<div id="page" class="pageArea"></div>
  		</div>
  	</div>
  	</form>
</body>
<script type="text/javascript" src="<%=path%>/js/Dialog.js"></script>
<script type="text/javascript" src="<%=path%>/js/mootools-1.2.4-core.js"></script>
<script type="text/javascript" src="<%=path%>/js/mootools-1.2.4.4-more.js"></script>
<script type="text/javascript" src="<%=path%>/js/checkbox.js" language="JavaScript"></script>
<script type="text/javascript" src="<%=path%>/js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path%>/js/default_hint.js"></script>
<script type="text/javascript" src="<%=path%>/js/bordercolor.js"></script>
<script type="text/javascript" src="<%=path%>/js/page.js"></script>

<script type="text/javascript">

	window.addEvent('domready', function() {
		addBorderColor();
	    addDefaultHintMsg();
		MooTools.lang.setLanguage("zhs-CN");
		var myFormValidator = new Form.Validator.Inline($('frm'), {
			stopOnFailure: true,
			useTitles: true,
			errorPrefix: "",
			//验证结束执行的方法
			onFormValidate: function(passed, form, event) {
				if (passed) {
					form.submit();
				}
			}
		});
		
		var page = new Page(<%=pageObject.getPageSize()%>,<%=pageObject.getPageRadius()%>,'frm');
		page.setRScopeDataListSize(<%=pageObject.getRScopeDataListSize()%>);
		page.setPageNo(<%=pageObject.getPageNo()%>);
		page.setMaxPageSize(<%=pageObject.getMaxPageSize()%>);
		page.setMaxRowSize(<%=pageObject.getMaxRowSize()%>);
		page.setFormValidator(null);
		page.generate();
		
	});
	
	//新增
  	function addBtn(){
		//removeDefaultHintMsg();
  		document.frm.action='<%=path%>/smoke/smokeadd.jsp';	
  		//document.frm.action='<%=path%>/dataservice/organManage/organAdd.jsp';	
  		document.frm.submit();
  	}
  	
  	//删除
  	function deleteBtn(){
	  	var ids =  document.getElementsByName('ID');
  		var groupID = '';
  		var j = 0;
	  	for(var i=0; i<ids.length; i++){
	  		if(ids[i].checked){
	  			j++;
	  			groupID += ids[i].value + ',';
	  		}
	  	}
	  	if(j == 0){
	  		alert('请至少选择一条数据进行操作！');
	  	}else{
	  		var flag = 'true';//标示  true：表示可以删除  false：表示不可以删除
	  		/*
	  		var groupIDs = (groupID.substring(0, groupID.length-1)).split(",");
	  		for(var a=0; a<groupIDs.length; a++){
	  			var everyStatus = document.getElementById('everyStatus'+groupIDs[a]).value;
	  			
		  		if(!(parseInt(everyStatus) == 1 || parseInt(everyStatus) == 4)){
		  			flag = 'false';
		  			alert('只允许对信息状态是草稿和退回的数据进行删除，请重新选择！');
		  			break;
	  			}else{
	  				flag = 'true';
	  			}
	  			
	  		}
	  		*/
	  		if(flag == 'true'){
				if(confirm("您确定要将选中的数据删除吗？")){
					removeDefaultHintMsg();
		  			document.frm.action='<%=path%>/servlet/SmokeController?method=delSmokeInfo&id='+groupID;	
		  			document.frm.submit();
	  			}
	  		}
  		}
  	}
  	
  	//变更
  	function modifyBtn(){
	  	var ids =  document.getElementsByName('ID');
  		var groupID = '';
  		var j = 0;
	  	for(var i=0; i<ids.length; i++){
	  		if(ids[i].checked){
	  			j++;
	  			id = ids[i].value;
	  		}
	  	}
	  	if(j == 0){
	  		alert('请选择一条数据进行操作！');
	  	}else if(j > 1){
	  		alert('只能逐项进行修改，请选择一项！');
	  	}else if(j == 1){
			//removeDefaultHintMsg();
  			document.frm.action='<%=path%>/servlet/SmokeController?method=showSmokeInfo&id='+id+'&editFlag=Y';
  			document.frm.submit();
  		}
  	}
  	
  	//分配预警类型
  	function alertAreaBtn(){
	  	var ids =  document.getElementsByName('ID');
  		var groupID = '';
  		var j = 0;
	  	for(var i=0; i<ids.length; i++){
	  		if(ids[i].checked){
	  			j++;
	  			groupID = ids[i].value;
	  		}
	  	}
	  	if(j == 0){
	  		alert('请选择一条数据进行操作！');
	  	}else if(j > 1){
	  		alert('只能逐项进行配置，请选择一项！');
	  	}else if(j == 1){
	  		
	  		document.frm.action='<%=path%>/servlet/OrganController?method=showAlertAreaInfo&organId='+groupID;
  			document.frm.submit();
			//showAlertAreaInfo(groupID);
  		}
  	}
  	
  	
  	function showAlertAreaInfo(groupID) {
	  var diag = new Dialog("showCatagoryTree");
	  diag.Width = 400;
	  diag.Height = 350;
	  diag.Title = "选择事件类别";
	  diag.URL = '<%=path%>/servlet/OrganController?method=showAlertAreaInfo&organId='+groupID;
	  //diag.URL = basePath + "/alertInfo/alertInfoPublish/collection/chooseCategory.jsp";
	  diag.ImagePath=basePath + "/images/dialog/";
	  diag.ShowButtonRow = true;
	  diag.OKEvent=function() {
		 var win=diag.Window;
		 var flag=win.saveBtn();
		 if(flag) {
		   diag.close();
		 }
	  };
	  diag.show();
	}
  	
  	//查询
  	function searchBtn(){
		//removeDefaultHintMsg();
		document.frm.action='<%=path%>/servlet/SmokeController?method=getSmokeList';	
  		document.frm.submit();
  	}
  	
  	
  </script>
</html>
