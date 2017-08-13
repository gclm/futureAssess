<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看所有成员</title>
</head>
<body>
    <table boreder>
       <tr>
         <th colspan="2">用户信息列表</th>
       </tr>
       <tr>
           <th>账户</th>
           <th>昵称</th>
           <th>身份</th>
           <th>年龄</th>
           <th>性别</th>
           <th>班级</th>
           <th>方向</th>
           <th>手机号</th>
           <th>电子邮箱</th>           
       </tr>
  |<c:forEach items="${List}" var="user">
       <tr>
          <td>${user.username}</td>
          <td>${user.usernick}</td>
          <td>${user.useridentity}</td>
          <td>${user.age}</td>
          <td>${user.sex}</td>
          <td>${user.grade}</td>
          <td>${user.direction}</td>
          <td>${user.phone}</td>
          <td>${user.email}</td>
       </tr> 
     </c:forEach>      
    </table>
</body>
</html>