<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<!--   css -->
<style type="text/css">
#code {
	font-family: Arial;
	font-style: italic;
	font-weight: bold;
	border: 0;
	letter-spacing: 2px;
	color: blue;
}
</style>
<!-- js -->
<script type="text/javascript">
	var code; //在全局定义验证码   
	//产生验证码  
	window.onload = function createCode() {
		code = "";
		var codeLength = 4;//验证码的长度  
		var checkCode = document.getElementById("code");
		var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C',
				'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
				'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');//随机数  
		for (var i = 0; i < codeLength; i++) {//循环操作  
			var index = Math.floor(Math.random() * 36);//取得随机数的索引（0~35）  
			code += random[index];//根据索引取得随机数加到code上  
		}
		checkCode.value = code;//把code值赋给验证码  
	}
	//校验验证码  
	function validate() {
		var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写        
		if (inputCode.length <= 0) { //若输入的验证码长度为0  
		    alert("请检查是否有未填项！！"); //则弹出请输入验证码
		    return false;
		} else if (inputCode != code) { //若输入的验证码与产生的验证码不一致时  												
			alert("验证码输入错误！@_@"); //则弹出验证码输入错误  
			return false;
			createCode();//刷新验证码  
			document.getElementById("input").value = "";//清空文本框 
		} else { //输入正确时  
			return true; 
		}
	}
</script>
</head>
<body>
	<form action="LoginServlet" method="post"  onsubmit="return validate()" name="f">
		<table method="post" action="#" border>
			<tr>
				<th>选择身份：</th>
				<td>
				   <select name="identity">
				      <option  selected>考生</option>
				      <option>考官</option>
				      <option>管理员</option>
				      <option>系统维护员</option>
				   </select>
				</td>
			</tr>
			<tr>
				<th>账号：</th>
				<td colspan="2" width="80%">
				<input type="text" name="username" /></td>
			</tr>
			<tr>
				<th>密码：</th>
				<td colspan="2" width="80%">
				<input type="password" name="userpass" /></td>
			</tr>
			<tr>
				<th>验证码：</th>
				<td>
				    <input type="text" id="input" /> 
				    <input type="button" id="code" onclick="createCode()" /> 	     
				</td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="登录" /></th>
			</tr>
			</form>
</body>
</html>