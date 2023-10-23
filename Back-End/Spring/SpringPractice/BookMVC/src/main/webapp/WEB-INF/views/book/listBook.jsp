<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>
<script>
	window.onload=function(){
	 <c:if test='${!empty param.key}'>
		 document.querySelector("#key").value='${param.key}';	 
	 </c:if>	
	 document.querySelector("#word").value='${param.word}';	 
	 <c:choose>
	 	<c:when test='${!empty param.pageNo}'>
	 		document.querySelector("#pageNo").value='${param.pageNo}';	 
	 	</c:when>
	 	<c:otherwise>
	 	document.querySelector("#pageNo").value='1';
	 	</c:otherwise>
	 </c:choose>
	 console.log('pageNo.......................', '${param.pageNo}')
	 console.log('word.......................', '${param.word}')
	 
	 
	 document.querySelector("#search").addEventListener("click", function () {
    	let form = document.querySelector("#frm");
        form.submit();
      });
	}
	function pagelist(no) {
		var frm = document.getElementById("frm");
		var pageNo = document.getElementById("pageNo");
		pageNo.value = no;
		frm.submit();
	}
</script>
<div class="container mt-3">
	<h2>책 목록</h2>
	<form id="frm" action="${root}/book/listBook">

	<table class='table table-hover'>
		<thead>
			<tr>
				<td colspan="4" align="right"><a href="insertBook"
					class='btn btn-primary'>책 등록 하기</a></td>
			</tr>
			<tr align="center">
				<td colspan="4" align="right">
					<select name="key" id="key">
							<option value="all">---선택하세요---</option>
							<option value="isbn">isbn</option>
							<option value="title">제목</option>
							<option value="author">저자</option>
					</select> 
					<input type="text" 		id="word" name="word" />
					<input type="hidden"	id="pageNo" name="pageNo" /> 
					<input class='btn  btn-primary'	type="button" value="검색" id="search"> 
				</td>
			</tr>
			<tr>
				<td width="150">isbn</td>
				<td width="150">제목</td>
				<td width="100">저자</td>
				<td width="100">출판사</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${list}">
				<tr>
					<td width="150">${book.isbn}</td>
					<td width="150"><a
						href="${root}/book/searchBook?isbn=${book.isbn}">${book.title}</a></td>
					<td width="100">${book.author}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class='row'>
		<div class='col'>${pageBean.pageLink }</div>
	</div>
</div>

</body>
</html>


