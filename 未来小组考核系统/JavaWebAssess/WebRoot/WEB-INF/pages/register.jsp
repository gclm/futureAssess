<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function usernamecheck(){ 
    var i=document.getElementById("username").value;
       if ( isNaN(i) ) {
          alert("账号格式错误-只能输入数字");         
          username.value="";    
       }
   }
function check() {
	/* 方向判断 */
	var sMobile = document.f.phone.value;
	var radioSelete = "Nothing";
    var seletedValue;
    for(i=0;i<document.f.direction.length;i++){
       if(document.f.direction[i].checked){
         radioSelete = "seleted";
         seletedValue = document.f.direction[i].value;
        }
     }
   //判断表单验证
	if (f.username.value =="") {
		alert("账号不能为空");
		return false;
	}else if(f.username1.value.length>12 || f.username1.value.length<3){
		alert("账号格式错误-位数不对");
		return false;
	}else if (f.userpass.value =="") {
		alert("密码为空");
		return false;
	}else if(f.userpass.value.length>17 || f.userpass.value.length<5){
		alert("密码格式错误-位数不对");
		return false;
	}else if(f.confirmpass.value ==""){
		alert("确认密码为空");
		return false;
	}else if(f.userpass.value != f.confirmpass.value){
		alert("两次密码不一致");
		return false;
	}else{
		return true;
	} 
     
    if(f.usernick.value ==""){
		alert("昵称不能为空");
		return false;
	}else if(f.usernick.value.length>7 || f.usernick.value.length<2){
		alert("昵称格式错误-位数不对");
		return false;
	}else if(!/^[\u4e00-\u9fa5]+$/gi.test(document.getElementById("usernick").value)){
        alert("昵称格式错误-只能输入汉字");
        return false;
    }else if(f.grade.value ==""){
		alert("班級不能为空");
		return false;
	}else if(radioSelete == "Nothing"){
	       alert("请选择方向");
	       return false;
	}else if(f.phone.value ==""){
		alert("电话不能为空");
		return false;
	}else if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(sMobile))){
        alert("不是完整的11位手机号或者正确的手机号前七位");
        document.f.phone.focus();
        return false;
    } else {
		return true;
	}
}
</script>
<title>用户注册</title>
</head>
<body>
	<form action="RegisterServlet" method="post" name="f"
		onSubmit="return check()">
		<table border="1" align="center">
			<tr>
				<th colspan="3"><h3>温馨提示：加*为必填项！！！！</h3></th>
			</tr>
			<tr>
				<th>*账号：</th>
			 	<td><input type="text" name="username1" id="username" onkeyup="usernamecheck();"></td>
	          	<td>建议使用学号注册<br/>账号为3-11位数字</td>	
			</tr>
			<tr>
				<th>*密码：</th>
				<td><input type="password" name="userpass"/></td>
			    <td>密码为6-16任意字符组成</td>
			</tr>
			<tr>
				<th>*确认密码：</th>
				<td><input type="password" name="confirmpass" /></td>
				<td>前后密码应一致</td>
			</tr>
			<tr>
				<th>*昵称：</th>
			 	<td><input type="text" name="usernick" /></td>
	          	<td>昵称为3-6位字符</td>	
			</tr>
			<tr>
				<th>年龄：</th>
				<td><input type="text" maxlength="2" name="age" /></td>
                
			</tr>
			<tr>
				<th>性别：</th>
				<td>
				    <input type="radio" name="sex" value="男" />男 
				    <input type="radio" name="sex" value="女">女
				</td>			
			</tr>
			<tr>
				<th>*班级：</th>
				<td><input type="text" name="grade" /></td>
			
			</tr>
			<tr>
				<th>*方向：</th>
				<td>
				    <input type="radio" name="direction" value="javaweb" />JAVAWEB
					<input type="radio" name="direction" value="前端" />前端 
					<input type="radio" name="direction" value="ui设计" />UI设计
			   </td>
		    
			</tr>
			<tr>
			    <th >*手机号：</th>
				<td><input type="text"  name="phone" /> </td>
			    <td></td>
			</tr>
			<tr>
			    <th>*邮箱：</th>
			    <td><input type="email" name="email"/></td>
			
			</tr>
			<tr>
				<th colspan="2">
				     <input type="reset" value="重置" /> 
				     <input type="submit" value="注册" />
				 </th>
			</tr>
		</table>

	</form>
</body>
</html>