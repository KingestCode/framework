<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
<h1>#号的用法</h1>
<h3>获取context中的数据</h3>
<%
  request.setAttribute("name", "苗骐");
%>
<s:property value="#request.name"/>
<h3>构建map集合</h3>
<!-- 构建list集合 -->
<s:iterator var="i" value="{'aa', 'bb', 'cc'}">
  <s:property value="i"/> -- <s:property value="#i"/><br/>
</s:iterator>
<hr>
<!-- 构建map -->
<s:iterator var="entry" value="#{'aa':'111', 'bb':'222', 'cc':'333' }">
  <s:property value="key"/> -- <s:property value="value"/><br/>
  <s:property value="#entry.key"/> -- <s:property value="#entry.value"/><br/>
</s:iterator>
<hr>
性别<input type="radio" name="sex" value="男">男
<input type="radio" name="sex" value="女">女<br/>

<s:radio list="{'男', '女'}" name="sex2" label="性别"></s:radio><br/>
<s:radio list="#{'1':'男', '2':'女'}" name="sex3" label="性别"></s:radio>
<s:debug/>
</body>
</html>