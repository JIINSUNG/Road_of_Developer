<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-light">
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/product/list">상품 목록</a></li>
		<li class="nav-item"><a class="nav-link" href="${root}/product/regist">상품 정보 등록</a></li>
	</ul>
	<c:choose>
		<c:when test="${empty userInfo }">
		<%-- session에 userInfo 객체 없는 경우(로그인 X) --%>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="${root}/member/login">로그인</a>
				</li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="#">${userInfo.name}님 환영합니다.</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${root}/member/mypage">MyPage</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${root}/member/logout">로그아웃</a>
				</li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>

