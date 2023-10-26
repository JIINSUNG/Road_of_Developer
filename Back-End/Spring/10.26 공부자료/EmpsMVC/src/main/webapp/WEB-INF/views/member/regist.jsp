<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입 화면</title>
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
		<h2 class='text-center'>회원 가입</h2>
		<form method="post" action="${root}/user" id="registForm">
			<input type="hidden" name="action" value="regist">
			<table class='table' border='1'>
				<tr>
					<td><label for="id" class="form-label">아이디</label></td>
					<td><input class="form-control" type='text' id='id' name='id' /></td>
				</tr>
				<tr>
					<td><label for="name" class="form-label">이름</label></td>
					<td><input class="form-control" type='text' id='name' name='name' /></td>
				</tr>
				<tr>
					<td><label for="pw" class="form-label">비밀번호</label></td>
					<td><input class="form-control" type='password' id='pw' name='pw' /></td>
				</tr>
			</table>
			<div class='text-center'>
					<input class='btn btn-primary' type="submit"
					value="회원가입" id="regist">
					<input class='btn btn-primary' type="reset"
					value="다시 입력" id="reset">
			</div>
		</form>
	</div>
</body>

<script>
	
</script>
</html>
