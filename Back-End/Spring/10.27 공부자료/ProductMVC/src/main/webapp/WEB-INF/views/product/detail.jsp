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
		<h2 class='text-center'>상품 정보 상세</h2>
			<table class='table' border='1'>
			</table>
			
			<table class='table' border='1'>
				<caption>근무 이력</caption>
					<tr>
					<td>상품 코드</td>
					<td>상품 모델</td>
					<td>상품 가격</td>
					<td>관리자</td>
					</tr>
					<tr>
					<td>${product.code}</td>
					<td>${product.model}</td>
					<td>${product.price}</td>
					<td>${product.id}</td>
					</tr>
					
			</table>
			<div class='text-center'>
					<a class='btn btn-primary' href='${root}/product/remove?code=${product.code}'>상품 삭제</a>
					<a class='btn btn-primary' href='${root}/product/list'>상품 목록</a>
			</div>
		</form>
	</div>
</body>

<script>
	
</script>
</html>
