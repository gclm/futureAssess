<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户</title>
</head>
<body>
  <form action="getfinduser.user">
    <table>
      <tr>
        <th>选择查找方式</th>
        <td>
          <select name="Choose">
              <option value="getusertall.user" selected>查找所有用户信息</option>
              <option value="getuser.user">查找单个用户信息</option>
              <option value="getdirectionfind.user">按方向查找用户信息</option>
              <option value="getidentityfind.user">按身份查找用户信息</option>
          </select>
        </td>
     </tr>
     <tr>
        <th>输入查询信息</th>
        <td><input type="text" name="input"/></td>
     </tr>
     <tr>
       <th colspan="2"><input type="submit" value="提交"/></th>
     </tr>
   </table>
  
  
  </form>
  
</body>
</html>