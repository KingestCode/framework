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
<!-- 方式一的获取: 利用Action在值栈中的特性 -->
<s:property value="user.username"/>
<s:property value="user.password"/>
<!-- 方式二的获取: 调用ValueStack本身的方法 -->
<s:property value="username"/>
<s:property value="password"/>
<s:property value="name"/>
</body>
</html>