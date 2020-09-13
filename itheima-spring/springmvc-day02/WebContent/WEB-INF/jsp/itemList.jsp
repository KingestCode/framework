<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>查询商品列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/item/queryitem.action" method="post">
  查询条件：
  <table width="100%" border=1>
    <tr>
      <td>名称：<input type="text" name="items.name"/></td>
      <td>价格：<input type="text" name="items.price"/></td>
      <td><input type="submit" value="查询"/></td>
    </tr>
  </table>
</form>
商品列表：
<%-- <form action="${pageContext.request.contextPath}/deleteByArray.action" method="post"> --%>
<form action="${pageContext.request.contextPath}/deleteByList.action" method="post">
  <table width="100%" border=1>
    <tr>
      <td><input type="checkbox"/></td>
      <td>商品名称</td>
      <td>商品价格</td>
      <td>生产日期</td>
      <td>商品描述</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${itemList }" var="item" varStatus="i">
      <tr>
        <td><input type="checkbox" value="${item.id}" name="ids"/></td>
        <td><input type="text" value="${item.name }" name="itemsList[${i.index}].name"/></td>
        <td><input type="text" value="${item.price }" name="itemsList[${i.index}].price"/></td>
        <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td>${item.detail }</td>
        
        <td><a href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}">修改</a></td>
      
      </tr>
    </c:forEach>
  
  </table>
  <input type="submit" value="sub"/>
</form>
</body>

</html>