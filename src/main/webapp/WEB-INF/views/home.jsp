<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
	<script src="${path}/resources/js/home.js"></script>
	<link href="${path}/resources/css/home.css" rel="stylesheet"/> 
</head>
<body>
	<a href="/write">글쓰기</a>
		
	<div class="search_box">
        <form id="searchForm" name="searchForm" autocomplete="off">
            <div class="sch_group fl">
                <select id="searchType" name="searchType" title="검색 유형 선택">
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                    <option value="">제목+내용</option>
                    <option value="writer">작성자</option>
                </select>
                <input type="text" id="keyword" name="keyword" placeholder="키워드를 입력해 주세요." title="키워드 입력" />
                <button type="button" class="bt_search" onclick="movePage()"><span class="skip_info">검색</span></button>
            </div>
            <div>
            	<input type="date" id="startDate" name="startDate" placeholder="시작날짜(20230720)"> ~
            	<input type="date" id="endDate" name="endDate" placeholder="마지막날짜(20230720)">
            </div>
        </form>
    </div>

	<table>
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>글번호</th>
				<th>작성자(ID)</th>
				<th>제목</th>
				<th>작성일</th>
				<th>수정일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="list">
			<tr>
				<td><input type="checkbox"></td>
				<td><c:out value="${list.seq}"></c:out></td>
				<td><c:out value="${list.memName}"></c:out></td>
				<td>
					<a href="javascript:void(0);" onclick="goViewPage(${list.seq})">
						<c:out value="${list.boardSubject}"></c:out>
					</a>
				</td>
				<td><c:out value="${list.regDate }"></c:out></td>
				<td><c:out value="${list.uptDate }"></c:out></td>
				<td><c:out value="${list.viewCnt }"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
