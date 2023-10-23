<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container">
		<c:if test="${!empty msg}">
			<h1>전달된 메세지는 :${msg}</h1> <!-- Redirect돼서 데이터 전송안됨. -->
		</c:if>
		<h3>메세지를 입력하세요</h3>
		<form action="hello">
			<div class="mb-3 mt-3">
				<label for="email" class="form-label">Email:</label> 
				<input type="text" class="form-control" id="msg"
					   placeholder="Enter msg" name="msg">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>