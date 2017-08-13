<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考生首页</title>
 <script type="text/javascript">
    	function doLogout(){
    		//访问LogoutServlet注销当前登录的用户
    		window.location.href="${pageContext.request.contextPath}/LogoutServlet";
    	}
   </script>
</head>
<body>
     <h1>欢迎来到考生首页</h1>
     <c:if test="${user!=null}">
   		欢迎您：${user.usernick}
   		<input type="button" value="退出登陆" onclick="doLogout()">
	</c:if>
	<form action="fileupload" method="post" enctype="multipart/form-data">
              文件描述:<input type="text" name="desc" size="20" maxlength="80"/><br/>
              文件名称:<input type="file" name="file" size="20" maxlength="80"/><br/>
      <input type="submit" value="上传"/>
    </form>
    <a href="${pageContext.request.contextPath}/ListFileServlet" target="_blank">下载</a>
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