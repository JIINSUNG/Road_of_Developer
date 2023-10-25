<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div class="container p-4">
		<h2 class='text-center'>고객 정보</h2>
			<table class='table' border='1'>
				<tr>
					<td><label for="isbn" class="form-label">아이디</label></td>
					<td>${userInfo.id}</td>
				</tr>
				<tr>
					<td><label for="title" class="form-label">비밀번호</label></td>
					<td><input type='password' value='${userInfo.pass}' disabled="disabled"/></td>
				</tr>
				<tr>
					<td><label for="author" class="form-label">이름</label></td>
					<td>${userInfo.name}</td>
				</tr>
			</table>
			<div class='text-center'>
					<a class='btn btn-primary' href='${root}/book?action=updateForm&isbn=${book.isbn}'>도서 수정</a>
					<a class='btn btn-primary' href='${root}/book?action=remove&isbn=${book.isbn}'>도서 삭제</a>
					<a class='btn btn-primary' href='${root}/book?action=list'>도서 목록</a>
			</div>
		</form>
	</div>
	</div>
</body>
</html>