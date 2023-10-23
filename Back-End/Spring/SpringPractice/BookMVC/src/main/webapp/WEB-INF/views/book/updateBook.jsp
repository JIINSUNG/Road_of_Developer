<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<div class="container mt-3">
		<h2>책 정보 수정</h2>
		<form method="post"	action="${root}/book/updateBook">
		<table class='table'>
		<tr><td>책 번호</td><td><input type="text" name="isbn"  	value="${book.isbn}" readonly="readonly" /></td></tr>
		<tr><td>제목</td><td><input type="text" name="title"  	value="${book.title}"/></td></tr>
		<tr><td>저자</td><td><input type="text" name="author"  	value="${book.author}"/></td></tr>
		<tr><td>가격</td><td><input type="text" name="price"  	value="${book.price}"/></td></tr>
		<tr><td colspan="2">설명</td></tr>
		<tr><td colspan="2">
			<textarea rows="" cols="" name='describ'>
				${book.describ}	
			</textarea>
		</td></tr>
		<tr><td colspan="2" align="center">
			<a href="${root}/book/listBook" class='btn btn-primary' >목록</a>
			<input type="submit"  class='btn btn-primary'  value="수정"/>
		</td></tr>
	</table>
	</form>
	</div>
</body>
</html>