<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Welcome Book 관리</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					href="${root}/book/listBook">책목록</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${root}/book/insertBook">책 등록 하기</a></li>
			<li class="nav-item"><a class="nav-link"
					href="${root}/rest">책 정보</a></li>					
					
				<c:choose>
					<c:when test="${empty userInfo}">
						<li class="nav-item"><a class="nav-link"
							href="${root}/member/login">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="#">${userInfo.name}님</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${root}/member/mypage">마이페이지</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${root}/member/logout">로그아웃</a></li>
					</c:otherwise>

				</c:choose>
			</ul>
		</div>
	</nav>