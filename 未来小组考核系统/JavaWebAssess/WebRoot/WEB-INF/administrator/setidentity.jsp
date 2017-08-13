<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设置身份权限</title>
<script type="text/javascript">
function usernamecheck(){ 
    var i=document.getElementById("username").value;
       if ( isNaN(i) ) {
          alert("账号格式错误-只能输入数字");         
          username.value="";    
       }
}
</script>
</head>
<body>
    <h1>欢迎来到设置权限设置</h1>
      <form action="getidentity.user" method="post">
       <table >
         <tr>
            <th>请输入选择设置权限的账户:</th>
            <td><input type="text" name="username1" id="username" onkeyup="usernamecheck();"></td>
         </tr>
       	 <tr>
       	  <th>请选择身份：</th>
          <td>
             <input type="radio" name="identity" value="考生" />考生 
		     <input type="radio" name="identity" value="考官" />考官<br /> 
             <input type="radio" name="identity" value="管理员" />管理员 
             <input type="radio" name="identity" value="普通成员"/>普通成员
		  </td>
		<tr>
		<tr><th><input type="submit" value="设置"/></th></tr>		  
    </table>
    </form>

    
</body>
</html>