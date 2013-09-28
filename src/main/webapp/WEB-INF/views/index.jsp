<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<h2>Hello, ${account.username }!</h2>
	<br/>
	<a href="<c:url value="/logout.do" />">登出</a>
	
	<br/>
	<a href="<c:url value="/authc/edit.do" />">编辑</a>
	
	<br/>
	<a href="<c:url value="/authc/view.do" />">查看</a>
	
	<br/>
	<a href="<c:url value="/authc/self.do" />">self</a>
</body>
</html>