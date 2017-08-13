<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改考生信息</title>
 <script type="text/javascript">
function usernamecheck(){ 
    var i=document.getElementById("username").value;
       if ( isNaN(i) ) {
          alert("账号格式错误-只能输入数字");         
          username.value="";    
       }
   }
  /*  function check() {
	 //方向判断 
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
	}else if(f.usernick.value ==""){
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
}  */ 
</script>
</head>
<body>
    <form action="getupdateexaminee.user">
      <table>
        <tr>
          <th>需要修改的账号：</th>
          <td><input type="text" name="username" id="username" onkeyup="usernamecheck();"></td>
        </tr>
        <tr><td><input type="submit" value="查询"/></td></tr>
      </table>
    </form>
</body>
</html>