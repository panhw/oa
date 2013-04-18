<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/include/plugins.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>请假申请</title>
    
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
   
  <form class="form-horizontal">
    <fieldset>
      <div id="legend" class="">
        <legend class="">请假申请</legend>
      </div>
    

    <div class="control-group">

          <!-- Select Basic -->
          <label class="control-label">请假类型</label>
          <div class="controls">
            <select class="input-xlarge">
      <option>事假</option>
      <option>病假</option>
      <option>婚假</option>
      <option>公休</option>
      <option>产假</option>
      <option>其他</option></select>
          </div>

        </div><div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">开始时间</label>
          <div class="controls">
            <input type="text" placeholder="开始时间" class="input-xlarge">
            <p class="help-block"></p>
          </div>
        </div><div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">结束时间</label>
          <div class="controls">
            <input type="text" placeholder="结束时间" class="input-xlarge">
            <p class="help-block"></p>
          </div>
        </div>

    

    

    <div class="control-group">

          <!-- Textarea -->
          <label class="control-label">请假原因</label>
          <div class="controls">
            <div class="textarea">
                  <textarea type="" class="" style="margin: 0px; height: 147px; width: 268px;"> </textarea>
            </div>
          </div>
        </div><div class="control-group">
          <label class="control-label"></label>

          <!-- Button -->
          <div class="controls">
            <button class="btn btn-default">申请</button>
          </div>
        </div>

    

    </fieldset>
  </form>

  </body>
</html>
