<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:if test='${!empty param.msg}'>
	<c:set var='msg' value="${param.msg}"/>
</c:if>
<meta charset="UTF-8">
<title>책 정보 관리 사이트</title>
<%-- 부트스트랩 사용을 위한 코드 --%>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
<script>
    <%-- request 객체에 msg가 들어있을 때 해당 내용 알림창 띄우기 --%>
	<c:if test="${!empty msg}">
		alert("${msg}");
	</c:if>
</script>