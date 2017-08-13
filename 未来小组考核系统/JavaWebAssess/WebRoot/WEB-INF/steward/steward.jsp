<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统维护员首页</title>
<script type="text/javascript">
    	function doLogout(){
    		//访问LogoutServlet注销当前登录的用户
    		window.location.href="${pageContext.request.contextPath}/LogoutServlet";
    	}
 </script>
</head>
<body>
  <h1>欢迎来到系统维护员首页</h1>
     <c:if test="${user!=null}">
   		欢迎您：${user.usernick}
   		<input type="button" value="退出登陆" onclick="doLogout()">
	</c:if>
</body>
</html>