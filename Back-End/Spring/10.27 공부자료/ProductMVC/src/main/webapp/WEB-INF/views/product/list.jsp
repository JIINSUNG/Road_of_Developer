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
<script type="text/javascript">
    window.onload=function(){
            document.querySelector("#search").addEventListener('click', function() {
                let form = document.querySelector("#frm");
                document.querySelector("#pageNo").value='1'
                form.submit();
            })
            document.querySelector("#word").value='${param.word}'
            
            <c:choose>
                <c:when test='${!empty param.pageNo}'>
                    document.querySelector("#pageNo").value='${param.pageNo}'
                </c:when>
                <c:otherwise>
                    document.querySelector("#pageNo").value='1'
                </c:otherwise>
            </c:choose>
            <c:if test='${!empty param.key}'>
                document.querySelector("#key").value='${param.key}'
            </c:if>
             
               let pages = document.querySelectorAll(".page-link");
               pages.forEach(function (page) {
                 page.addEventListener("click", function () {
                      document.querySelector("#pageNo").value = this.getAttribute("data-pg");
                   let form = document.querySelector("#frm");
                   form.setAttribute("action", "${root}/product/list");
                   form.submit();
                 });
               });
    }
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<div class="container p-4">
		<h2 class='text-center'>상품 목록</h2>
		<div class='text-right pr-4'>
			<a class='btn btn-primary' href='${root}/product/regist'>등록</a>
		</div>
		<c:if test="${empty employees}">
			<table class='table table-hover'>
				<tr>
					<td>등록된 데이타가 없습니다.</td>
				</tr>
			</table>
		</c:if>

		<form id='frm' action="${root}/product/list">
			<input type='hidden' name='pageNo' id='pageNo' />
			<div class="row">
				<div class="col">
					<select name='key' id='key'>
						<option value='all'>---선택하세요---</option>
						<option value='empno'>empno</option>
						<option value='name'>이름</option>
						<option value='job'>직무</option>
						<option value='salary'>급여</option>
						<option value='deptno'>부서</option>
					</select>
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="검색어 입력"
						name="word" id="word">
				</div>
				<div class="col">
					<input type="button" class="btn btn-primary" value="검색" id='search'>
				</div>
			</div>
		</form>

		<c:if test="${!empty products}">
			<table class='table table-hover'>
				<thead>
					<tr>
						<th>code</th>
						<th>model</th>
						<th>price</th>
						<th>id</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items='${products}' var="product">
						<tr>
							<td><a href='${root}/product/detail?code=${product.code}'>
									${product.code}</a></td>

							<td>${product.model}</td>
							<td>${product.price}</td>
							<td>${product.id}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<div class="row">
				<div class="col">${pageBean.pageLink }</div>
			</div>
		</c:if>
	</div>
</body>
</html>