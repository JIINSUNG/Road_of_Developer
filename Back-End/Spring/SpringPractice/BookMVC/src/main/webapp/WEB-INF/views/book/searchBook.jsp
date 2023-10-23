<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<div class="container mt-3">
		<h2>책 정보</h2>
		<table class='table'>
		<tr><td>책 번호</td><td>${book.isbn}</td></tr>
		<tr><td>제목</td><td>${book.title}</td></tr>
		<tr><td>저자</td><td>${book.author}</td></tr>
		<tr><td>가격</td><td>${book.price}</td></tr>
		<tr><td colspan="2">설명</td></tr>
		<tr><td colspan="2">${book.describ}</td></tr>
		<tr><td colspan="2" align="center">
			<a href="${root}/book/listBook" class='btn btn-primary' >목록</a>
			<a href="${root}/book/removeBook?isbn=${book.isbn}" class='btn btn-primary' >삭제</a>
			<a href="${root}/book/updateBook?isbn=${book.isbn}" class='btn btn-primary' >수정</a>
		</td></tr>
		</table>
	</div>
</body>
</html>