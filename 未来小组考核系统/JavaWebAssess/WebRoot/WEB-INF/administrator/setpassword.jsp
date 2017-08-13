<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>
</head>
<body>
    <form action="getpassword.user" method="post">
      <table>
         <tr>
           <th>账号：</th>
           <td><input type="text" name="username" placeholder="请输入需要修改的账户" /></td>
         </tr>
         <tr>
           <th>密码：</th>
           <td><input type="password" name="userpass"  placeholder="请输入新密码"/></td>
         </tr>
         <tr><th><input type="submit" value="重置"/></th></tr>
      </table>
    
    </form>
</body>
</html>