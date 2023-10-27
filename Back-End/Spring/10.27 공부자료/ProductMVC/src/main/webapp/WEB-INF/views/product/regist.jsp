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
		<h2 class='text-center'>상품 등록</h2>
		<form method="post" action="${root}/product/regist" id="registForm">
			<table class='table' border='1'>
				<tr>
					<td><label for="code" class="form-label">상품코드</label></td>
					<td><input class="form-control" type='text' id='code' name='code' /></td>
				</tr>
				<tr>
					<td><label for="model" class="form-label">모델명</label></td>
					<td><input class="form-control" type='text' id='model' name='model' /></td>
				</tr>
				<tr>
					<td><label for="price" class="form-label">상품가격</label></td>
					<td><input class="form-control" type='text' id='price' name='price' /></td>
				</tr>
				<tr>
					<td><label for="id" class="form-label">관리자</label></td>
					<td><input class="form-control" type='text' id='id' name='id' /></td>
				</tr>
			</table>
			<div class='text-center'>
					<input class='btn btn-primary' type="submit"
					value="상품 등록" id="regist">
					<input class='btn btn-primary' type="reset"
					value="다시 입력" id="reset">
					<a class='btn btn-primary' href='${root}/product/list'>상품 목록</a>
			</div>
		</form>
	</div>
</body>

<script>
	
</script>
</html>
