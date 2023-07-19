<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<style>
	table{
	 	width: 1000px;    
	 	margin-top : 20px;
	}
	tr, th, td{ border-style: double;}
	th{	text-align: center;}
</style>
<head>
	<title>Home</title>
</head>
<body>
	<a href="/write">글쓰기</a>
		
	<div class="search_box">
        <form id="searchForm" autocomplete="off">
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
<script type="text/javascript">
	function goViewPage(seq) {
		location.href = '/post/view?seq=' + seq;
	}
	
	function movePage(){
		alert("movePage");
		const form = document.getElementById('searchForm');
        const queryParams = {
              searchType: form.searchType.value
            , keyword: form.keyword.value
        }
        location.href = location.pathname + '?' + new URLSearchParams(queryParams).toString();
	}
</script>
</html>
