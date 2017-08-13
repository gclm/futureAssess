<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员首页</title>
<script type="text/javascript">
    	function doLogout(){
    		//访问LogoutServlet注销当前登录的用户
    		window.location.href="${pageContext.request.contextPath}/LogoutServlet";
    	}
    </script>
</head>
<body>
    <h1>欢迎来到管理员首页</h1>
     <c:if test="${user!=null}">
   		欢迎您：${user.usernick}
   	<input type="button" value="退出登陆" onclick="doLogout()">
	</c:if>
	<ul>
     <li><a href="finduser.user">查找成员信息</a></li>
     <li><a href="setpassword.user"/>重置密码</li>  
     <li><a href="updateexaminee.user">修改成员信息</a></li>
     <li><a href="setidentity.user">设置权限</a></li>
     <li><a href="setinformation.user">发布信息</a></li> 
    </ul>
    <table boreder>
       <tr>
         <th colspan="2">身份申请列表</th>
       </tr>
       <tr>
           <th>申请编号</th>
           <th>账户</th>
           <th>申请身份</th>          
       </tr>
  |<c:forEach items="${List}" var="apply">
       <tr>
          <td>${apply.id}</td>
          <td>${apply.username}</td>
          <td>${apply.applyidentity}</td>
       </tr> 
     </c:forEach>      
    </table>
</body>
</html>