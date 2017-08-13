<%@ page language="java" pageEncoding="UTF-8"%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>首页</title>
</head>

<body>
	<h1>未来小组考核</h1>
	<hr />
	<c:if test="${user==null}">
		<a href="${pageContext.request.contextPath}/RegisterUIServlet"
			target="_blank">注册</a>
		<a href="${pageContext.request.contextPath}/LoginUIServlet">登陆</a>
	</c:if>
</body>
</html>
