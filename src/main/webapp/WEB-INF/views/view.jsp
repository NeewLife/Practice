<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="${path}/resources/css/view.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.0.js" ></script>
	<script type="text/javascript" src="${path}/resources/js/view.js"></script> 
</head>
<body>
	<div class="container">
		<div class="screen">
		
			<a href="/post">목록으로</a>
			
		
			<div class="chkBoxTable">
				<table class="table">
					<thead>
						<tr>
							<th>결재요청</th>
							<th>과장</th>
							<th>부장</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:if test="${post.confirmStatus == 2 }">
							<td class="checkbox-wrapper-39">
								<label>
									<input type="checkbox" checked onclick="return false">
									<span class="checkbox"></span>
								</label>
							</td>
							<td class="checkbox-wrapper-39">
								<label>
									<input type="checkbox" onclick="return false">
									<span class="checkbox"></span>
								</label>
							</td>
							<td class="checkbox-wrapper-39">
								<label>
									<input type="checkbox" onclick="return false">
									<span class="checkbox"></span>
								</label>
							</td>
						</c:if>
						<c:if test="${post.confirmStatus == 3 }">
							<td class="checkbox-wrapper-39">
								<label>
									<input type="checkbox" checked onclick="return false">
									<span class="checkbox"></span>
								</label>
							</td>
							<td class="checkbox-wrapper-39">
								<label>
									<input type="checkbox" checked onclick="return false">
									<span class="checkbox"></span>
								</label>
							</td>
							<td class="checkbox-wrapper-39">
								<label>
									<input type="checkbox" onclick="return false">
									<span class="checkbox"></span>
								</label>
							</td>
						</c:if>
						<c:if test="${post.confirmStatus == 4 }">
							<td class="checkbox-wrapper-39">
								<label>
									<input type="checkbox" checked onclick="return false">
									<span class="checkbox"></span>
								</label>
							</td>
							<td class="checkbox-wrapper-39">
								<label>
									<input type="checkbox" checked onclick="return false">
									<span class="checkbox"></span>
								</label>
							</td>
							<td class="checkbox-wrapper-39">
								<label>
									<input type="checkbox" checked onclick="return false">
									<span class="checkbox"></span>
								</label>
							</td>
						</c:if>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="formBox">
				<form id="approval" method="post">
					<fieldset>
						<label for="postId">번호 : </label>
						<input type="text" id="postId" name="postId" value="${post.postId }" readonly="readonly">
						<br>
						<label for="writer">작성자 : </label>
						<input type="text" id="writer" value="${post.writer }" readonly="readonly">
						<br>
						<label for="title">제목 :</label>
						<input type="text" id="title" value="${post.title }" readonly="readonly">
						<br>
						<label for="content">내용 : </label>
						<textarea placeholder="내용" id="content" readonly="readonly">${post.content }</textarea>
					</fieldset>
					<div id="submitButton">
						<c:choose>
							<c:when test="${sessionScope.session.userRank == '과장'}">
								<c:if test="${post.confirmStatus == '2'}">
									<button type="button" onclick="reject()" class="btn btn-warning">반려</button>
									<button type="button" onclick="approval()" class="btn btn-primary">결재</button>
								</c:if>
							</c:when>
							<c:when test="${sessionScope.session.userRank == '부장'}">
								<c:if test="${post.confirmStatus == '2' || post.confirmStatus == '3'}">
									<button type="button" onclick="reject()" class="btn btn-warning">반려</button>
									<button type="button" onclick="approval()" class="btn btn-primary">결재</button>
								</c:if>
							</c:when>
						</c:choose>
						<c:if test="${sessionScope.session.id == post.writerPkNum && post.confirmStatus == 5}">
							<button type="button" onclick="modify()" class="btn btn-secondary">수정</button>
						</c:if>
					</div>
				</form>
			</div>
			
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>결재일</th>
						<th>결재자</th>
						<th>결재상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${history}" var="history">
						<tr>
							<td>${history.seq }</td>
							<td>${history.confirmDate }</td>
							<td>${history.confirmPerson }</td>
							<td>
								<c:choose>
									<c:when test="${history.confirmStatus eq '1' }" >임시저장</c:when>
									<c:when test="${history.confirmStatus eq '2' }" >결재대기</c:when>
									<c:when test="${history.confirmStatus eq '3' }" >결재중</c:when>
									<c:when test="${history.confirmStatus eq '4' }" >결재완료</c:when>
									<c:when test="${history.confirmStatus eq '5' }" >반려</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>