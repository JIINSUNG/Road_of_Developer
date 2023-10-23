<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<div class="container mt-3">
		<h2>책 등록</h2>
		<form method="post"	action="insertBook">
		<table class='table'>
			<tr><td>책 번호</td>	<td><input type="text" name="isbn"  	/></td></tr>
			<tr><td>제목</td>		<td><input type="text" name="title"  	/></td></tr>
			<tr><td>저자</td>		<td><input type="text" name="author"  	/></td></tr>
			<tr><td>가격</td>		<td><input type="text" name="price"  	/></td></tr>
			<tr><td colspan="2">설명</td></tr>
			<tr><td colspan="2">
					<textarea rows="5" cols="30" name="describ"></textarea>
				</td></tr>
			<tr><td colspan="2" align="center">
				<a href="listBook" class='btn btn-primary' >목록</a>
				<input type="submit" class='btn btn-primary' value="등록"/>
			</td></tr>
		</table>
		</form>
	</div>
</body>
</html>