<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
</head>
<body>
    <form action="setupdateexaminee.user" method="post">
     <table boreder>
       <tr>
         <th colspan="2">要修改的用户信息列表</th>
       </tr>
       <tr>
          <th>账户：</th>
          <td><input type="text" name="username" value="${User.username}" readonly="readonly" /></td>
          <td>不可修改项</td>
       </tr>
       <tr>   
           <th>昵称</th>
           <td><input type="text" name="usernick"  value="${User.usernick}"/></td>
       </tr>
       <tr>
          <th>身份</th>
          <td><input type="text" name="useridentity" value="${User.useridentity}" readonly="readonly"/></td>
          <td>不可修改项</td>
       </tr>
       <tr>
           <th>年龄</th>
           <td><input type="text" name="age"  value="${User.age}"/></td>
       </tr>
       <tr>
           <th>性别</th>
           <td><input type="text" name="sex"  value="${User.sex}"/></td>
       </tr>
       <tr>
           <th>班级</th>
           <td><input type="text" name="grade"  value="${User.grade}"/></td>
       </tr>   
       <tr>
           <th>方向</th>
           <td><input type="text" name="direction"  value="${User.direction}"/></td>
       </tr>  
       <tr>
          <th>手机号</th>
          <td><input type="text" name="phone"  value="${User.phone}"/></td>
       </tr>
       <tr>   
           <th>电子邮箱</th>
           <td><input type="text" name="email"  value="${User.email}"/></td>           
       </tr>
       <tr>
          <th><input type="submit" value="重置"/></th>
       </tr>
    </table>
    </form>
</body>
</html>