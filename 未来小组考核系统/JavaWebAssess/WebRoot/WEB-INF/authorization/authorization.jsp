<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>授权界面</title>
<script type="text/javascript">
    	function doLogout(){
    		//访问LogoutServlet注销当前登录的用户
    		window.location.href="${pageContext.request.contextPath}/LogoutServlet";
    	}
 </script>
</head>
<body>
  <h1>欢迎来到申请授权首页</h1>
     <c:if test="${user!=null}">
   		欢迎您：${user.usernick}
   		<input type="button" value="退出登陆" onclick="doLogout()">
	 </c:if>
	 <form action="applyidentity.user">
	   <table>
	      <tr>
	        <th colspan="2">授权申请表</th>
	      </tr>
	      <tr>
	         <th>账户:</th>
	         <td><input type="text" name="username" value="${user.username}" /></td>
	      </tr>
	      <tr>
	        <th>身份：</th>
	        <td>
	           <select name="useridentity">
	              <option>考官</option>
	              <option selected>考生</option>
	              <option>管理员</option>
	           </select>
	        </td> 
	      </tr>
	      <tr><th colspan="2"><input type="submit" value="提交申请"/></th></tr>
	   </table> 
	 </form>
	 <table boreder>
       <tr>
         <th colspan="2">消息通知表</th>
       </tr>
       <tr>
           <th>通知编号</th>
           <th>通知</th>                    
       </tr>
      <c:forEach items="${List}" var="info">
       <tr>
          <td>${info.id}</td>
          <td>${info.information}</td>
       </tr> 
     </c:forEach>      
    </table>
</body>
</html>