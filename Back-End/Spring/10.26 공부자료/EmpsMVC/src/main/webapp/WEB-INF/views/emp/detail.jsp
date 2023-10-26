<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>

	<div class="container p-4">
		<h2 class='text-center'>직원 정보 상세</h2>
		<table class='table' border='1'>
			<tr>
				<td>사원번호</td>
				<td>${emp.empno}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${emp.name}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${emp.email}</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>${emp.hireDate}</td>
			</tr>
			<tr>
				<td>직무</td>
				<td>${emp.job}</td>
			</tr>
			<tr>
				<td>급여</td>
				<td>${emp.salary}</td>
			</tr>
			<tr>
				<td>부서</td>
				<td>${emp.deptno}</td>
			</tr>
		</table>

		<table class='table' border='1'>
			<caption>근무 이력</caption>
			<tr>
				<td>부서 번호</td>
				<td>담당 업무</td>
				<td>시작</td>
				<td>종료</td>
			</tr>
			<tr>
				<td>${emp.deptno}</td>
				<td>${emp.job }</td>
				<td>${emp.hireDate}</td>
				<td></td>
			</tr>
		</table>
		<div class='text-center'>
			<a class='btn btn-primary'
				href='${root}/emp/update?empno=${emp.empno}'>직원정보 수정</a> <a
				class='btn btn-primary'
				href='${root}/emp/remove?empno=${emp.empno}'>직원정보 삭제</a> <a
				class='btn btn-primary' href='${root}/emp/list'>직원 목록</a>
		</div>
		</form>
	</div>
</body>

<script>
	
</script>
</html>
