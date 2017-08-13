<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类用户信息列表</title>
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
       <tr>
          <td>${User.username}</td>
          <td>${User.usernick}</td>
          <td>${User.useridentity}</td>
          <td>${User.age}</td>
          <td>${User.sex}</td>
          <td>${User.grade}</td>
          <td>${User.direction}</td>
          <td>${User.phone}</td>
          <td>${User.email}</td>
       </tr>       
    </table>
</body>
</html>