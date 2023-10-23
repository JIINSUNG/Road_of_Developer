<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<a href="hello1-1"> 1.1 hello page</a><br/>
		<a href="hello1-2"> 1.2 hello page</a><br/>
		<a href="hello2-1"> 2.1 hello page - String 요청 데이타</a><br/>
		<a href="hello2-2"> 2.2 hello page - int 요청 데이타</a><br/>
		<a href="hello2-31"> 2.31 hello page - @RequestParam(required = true) String</a><br/>
		<a href="hello2-32"> 2.32 hello page - @RequestParam(defaultValue = "5000") int</a><br/>
		<a href="regist2_5"> 2.5 게시글 작성 - map</a><br/>
		<a href="regist2_6"> 2.6 게시글 작성 - DTO</a><br/>
		<a href="regist2_7"> 2.7 게시글 작성 - @ModelAttribue (alias 방식)</a><br/>
		
		<a href="writeBoardForm">게시글 작성</a> <br/>
		<a href="hello"> hello page</a><br/>
		<a href="${sfileName}"> ${rfileName}</a><br/>
		<a href="redirectTest?msg=hello"> 리다이렉트로 이동</a><br/>
		<a href="forwardTest?msg=hello"> forward로 이동</a><br/>
		<a href="hello?msg=hello"> 3.2 리턴타입 - void</a><br/>
		<a href="hello3_3?msg=hello"> 3.3 리턴타입 - ModelAndView</a><br/>
		
		<a href="error"> error test</a><br/>
		<a href="rest.do"> rest</a><br/>
		<a href="restList.do"> rest  배열</a><br/>
	</body>
</html>








