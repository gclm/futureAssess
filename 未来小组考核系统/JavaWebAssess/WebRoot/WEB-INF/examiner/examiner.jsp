<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考官首页</title>
<script type="text/javascript">
	function doLogout() {
		//访问LogoutServlet注销当前登录的用户
		window.location.href = "${pageContext.request.contextPath}/LogoutServlet";
	}
</script>
</head>
<body>
	<h1>欢迎来到考官首页</h1>
	<c:if test="${user!=null}">
   		欢迎您：${user.usernick}
   		<input type="button" value="退出登陆" onclick="doLogout()">
	</c:if>
	<table>
	 <tr>
	 <th>
	 <form action="fileupload" method="post" enctype="multipart/form-data">
		文件描述:<input type="text" name="desc" size="20" maxlength="80" /><br />
		文件名称:<input type="file" name="file" size="20" maxlength="80" /><br />
		<input type="submit" value="上传" />
	 </form>
	 </th>
	 </tr>
	 <tr><th><a href="${pageContext.request.contextPath}/ListFileServlet"
			target="_blank">下载</a></th>
			</tr>
	</table>
	<form action="ResultServlet" method="post">
		<table>
			<tr>
				<th colspan="2">考试成绩录入</th>
			</tr>
			<tr>
				<th>账号：</th>
				<th>界面美观</th>
				<th>代码规范</th>
				<th>目录结构</th>
				<th>功能完善</th>
				<th>数据库设计合理</th>
				<th>业务逻辑合理</th>
				<th>亮点</th>
			</tr>
			<tr>
			    <th><input type="text" name="username" /></th>
				 <th><input type="text" name="NO1" /></th>
				 <th><input type="text" name="NO2" /></th>
				 <th><input type="text" name="NO3" /></th>
				 <th><input type="text" name="NO4" /></th>
				 <th><input type="text" name="NO5" /></th>
				 <th><input type="text" name="NO6" /></th>
				 <th><input type="text" name="NO7" /></th>
			</tr>
			<tr><th><input type="submit" value="录入"/></th></tr>
		</table>
	</form>
	
</body>
</html>