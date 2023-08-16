<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 페이지</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link href="${path}/resources/css/post.css" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="${path}/resources/js/post.js"></script>
</head>
<body>
<div class="container">
	<div class="screen">
		<header>
			<div class="greet"> 
				${user.userName}(${user.userRank})님 환영합니다.
				<button type="button" class="logoutBtn" onclick="logout()">로그아웃</button>
			</div>
			<p>
				<button type="button" class="writeBtn" onclick="write()">글쓰기</button>
				<c:if test="${user.userRank eq '부장' or user.userRank eq '과장'}">
					<button type="button" class="authorizeBtn" onclick="authorize()">대리결재</button>
				</c:if>
			</p>
		</header>
		
		<form id="search">
			<select name="searchType">
				<option value="">선택</option>
				<option value="writer">작성자</option>
				<option value="authPeople">결재자</option>
				<option value="titleContent">제목+내용</option>
			</select>
			<input type="text" placeholder="검색어를 입력하세요">
			<select name="authType">
				<option value="">결재상태</option>
				<option value="tempStore">임시저장</option>
				<option value="waitingAuth">결재대기</option>
				<option value="underAuth">결재중</option>
				<option value="completed">결재완료</option>
				<option value="rejected">반려</option>
			</select>
			<br>
			<input type="date">   ~   <input type="date">
			<button type="button">검색</button>
		</form>
		
		
		<table class="table">
			<thead class="table-light">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
					<th>결재일</th>
					<th>결재자</th>
					<th>결재상태</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>1</th>
					<th>오세영</th>
					<th>오세영</th>
					<th>오세영</th>
					<th>오세영</th>
					<th>오세영</th>
					<th>오세영</th>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<%-- 	<div class="greet"> ${sessionScope.session}님 환영합니다</div> --%>
<%-- 	<div class="greet"> ${sessionScope.session.userId}님 환영합니다</div> --%>
<%-- 	<div class="greet"><c:out value="${sessionScope.session.userId}님 환영합니다."></c:out></div> --%>
<%-- 	<div class="greet"> ${sessionScope.userId}님 환영합니다.</div> --%>
<%-- 	<div class="greet"><% out.println(session.getAttribute("session")); %></div> --%>
</body>
</html>