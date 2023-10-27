<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
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
		<h2 class='text-center'>직원 정보 수정</h2>
		<form method="post" action="${root}/emp/update" id="updateForm">
			<table class='table' border='1'>
				<tr>
					<td><label for="empno" class="form-label">사원번호</label></td>
					<td><input class="form-control" type='text' id='empno' name='empno' /></td>
				</tr>
				<tr>
					<td><label for="name" class="form-label">이름</label></td>
					<td><input class="form-control" type='text' id='name' name='name' /></td>
				</tr>
				<tr>
					<td><label for="email" class="form-label">이메일</label></td>
					<td><input class="form-control" type='text' id='email' name='email' /></td>
				</tr>
				<tr>
					<td><label for="hire_date" class="form-label">입사일</label></td>
					<td><input class="form-control" type='text' id='hire_date' name='hire_date' /></td>
				</tr>
				<tr>
					<td><label for="job" class="form-label">직무</label></td>
					<td><input class="form-control" type='text' id='job' name='job'/></td>
				</tr>
				<tr>
					<td><label for="salary" class="form-label">급여</label></td>
					<td><input class="form-control" type='text' id='salary' name='salary'/></td>
				</tr>
				<tr>
					<td><label for="deptno" class="form-label">부서</label></td>
					<td><input class="form-control" type='text' id='deptno' name='deptno'/></td>
				</tr>
			</table>
			<div class='text-center'>
					<input class='btn btn-primary' type="submit"
					value="도서 정보 수정" id="regist">
					<input class='btn btn-primary' type="reset"
					value="다시 입력" id="reset">
					<a class='btn btn-primary' href='${root}/emp/list'>직원 목록</a>
			</div>
		</form>
	</div>
</body>

<script>
	
</script>
</html>
