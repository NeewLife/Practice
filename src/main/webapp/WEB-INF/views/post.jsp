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
	
</head>
<body>
<div class="container">
	<div class="screen">
		<header>
			<div class="greet"> 
				${user.userName}(${user.userRank})님 환영합니다.
				<button type="button" class="logoutBtn" onclick="location.href='/'">로그아웃</button>
			</div>
				<button class="writeBtn" onclick="writePost()">글쓰기</button>
				<c:if test="${user.userRank eq '부장' or user.userRank eq '과장'}">
					<button type="button" class="authorizeBtn">대리결재</button>
				</c:if>
		</header>
		
		<form action="/post" method="get" id="search">
			<select id="searchType" name="searchType">
				<option value="">선택</option>
				<option value="writer">작성자</option>
				<option value="authPeople">결재자</option>
				<option value="titleContent">제목+내용</option>
			</select>
			<input id="keyword" name="keyword" type="text" placeholder="검색어를 입력하세요">
			<select id="authType" name="authType">
				<option value="">결재상태</option>
				<option value="1">임시저장</option>
				<option value="2">결재대기</option>
				<option value="3">결재중</option>
				<option value="4">결재완료</option>
				<option value="5">반려</option>
			</select>
			<br>
			<input id="startDate" name="startDate" type="date">   ~   <input id="endDate" name="endDate" type="date">
			<button id="searchBtn" type="button">검색</button>
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
			<tbody id="posts">
				<c:forEach items="${list}" var="list">
					<tr>
						<td><a href="javascript:view(${list.postId})"><p style="margin : 0px">${list.postId}</p></a></td>
						<td><a href="javascript:view(${list.postId})"><p style="margin : 0px">${list.writer}</p></a></td>
						<td><a href="javascript:view(${list.postId})"><p style="margin : 0px">${list.title}</p></a></td>
						<td><a href="javascript:view(${list.postId})"><p style="margin : 0px">${list.writeDate}</p></a></td>
						<td><a href="javascript:view(${list.postId})"><p style="margin : 0px">${list.confirmDate}</p></a></td>
						<td><a href="javascript:view(${list.postId})"><p style="margin : 0px">${list.confirmPerson}</p></a></td>

 						<!-- 결재상태 DB 값에 따라 변경해서 결재상태 출력 -->
						<td>
							<a href="javascript:view(${list.postId})"><p style="margin : 0px">
								<c:choose>
									<c:when test="${list.confirmStatus eq 1 }" >임시저장</c:when>
									<c:when test="${list.confirmStatus eq 2 }" >결재대기</c:when>
									<c:when test="${list.confirmStatus eq 3 }" >결재중</c:when>
									<c:when test="${list.confirmStatus eq 4 }" >결재완료</c:when>
									<c:when test="${list.confirmStatus eq 5 }" >반려</c:when>
								</c:choose>
							</p></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%-- 	<div class="greet"> ${sessionScope.session.userId}님 환영합니다</div> --%>
<script src="${path}/resources/js/post.js"></script>
</body>
</html>