<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
<h1>%号的使用, 因为有的标签不识别OGNL表达式, 使用%可以强制解析</h1>
<%
  request.setAttribute("name", "苗骐");
%>
姓名:<s:textfield name="name" value="%{#request.name}"/>
</body>
</html>