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
<h1>查看值栈的内部结构</h1>
<s:debug/>
<h1>获取一个对象的数据</h1>
<s:property value="username"/>
<s:property value="password"/><br/>
<h1>获取集合中的数据</h1>
<s:property value="list[0].username"/>
<s:property value="list[0].password"/><br/>
<s:property value="list[1].username"/>
<s:property value="list[1].password"/><br/>
<s:property value="list[2].username"/>
<s:property value="list[2].password"/><br/>
<h1>获取context中的数据</h1>
<s:property value="#request.name"/><br/>
<s:property value="#session.name"/><br/>
<s:property value="#application.name"/><br/>
<!-- 会一次从request, session, application中查找 -->
<s:property value="#attr.name"/><br/>
<hr>
${username }

</body>
</html>