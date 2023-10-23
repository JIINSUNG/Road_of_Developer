<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value = "${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Spring MVC</h1>
	<a href="${root}/hello1">Hello1 Spring</a><br>
	<a href="${root}/hello2">Hello2 Spring</a><br>
	<a href="${root}/param/single">Single Parameter test</a><br>
	<a href="${root}/param/multi">multi Parameter test</a><br>
</body>
</html>