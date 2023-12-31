<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#addFile").click(addFileForm);
});
var count=0;   //file form index
function addFileForm(){
	var html="<div id='item_"+count+"'>"
	html+="<input type='file' name='fileup' />";
	html+="<input type='button' value='삭제' onclick='removeForm("+count+")'/></div>";
	count++;
	//html=$("#content").html()+html;
	//$("#content").html(html);
	$("#fileUpForm").append(html);
}
function removeForm(count){
	var item = document.getElementById('item_'+count);
	if(item !=null) item.parentNode.removeChild(item);
}
</script>
</head>
<body>
<form method="post" action="insertBoard"    encType='multipart/form-data' >
	<table>
		<caption> 파일 업로드 테스트 </caption>
		<tbody>
			<tr height="50"><td>
				<label for="title">
				<spring:message code="customer.address"/>
				</label></td>
			    <td><input type="text" name="title" id="title"/></td>
			</tr>
			<tr height="50"><td><label for="title">아이디</label></td>
			    <td><input type="text" name="id" id="id"/></td>
			</tr>
			<tr height="50" ><td><label for="fileup">업로드할 파일</label></td>
			    <td>
			    	<input type="button" name="addFile" id="addFile" value="파일 추가"/>
			    </td>
			</tr>
			<tr height="50" ><td colspan="2" id="fileUpForm">
				<input type='file'  name='fileup'/>
			 </td>
			</tr>
			<tr><td colspan="2"><label for="content">내용</label></td></tr>
			<tr><td colspan="2" align="center">
			    <textarea name="contents" id="contents" cols="30" rows="10"></textarea>
			</td></tr>
		</tbody>
		<tfoot>
			<tr><td colspan="2" align="center">
				<input type="submit" value="작성"/>
				<input type="reset" value="취소"/>
			</td></tr>
		</tfoot>
	</table>
</form>
</body>

</html>