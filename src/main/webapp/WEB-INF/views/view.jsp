<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script> 
</head>
<body>
	<div>
		<a href="/">목록으로</a>
		<form method="post" id="updateForm">
			<fieldset>
				<input type="hidden" id="seq" name="seq" value='<c:out value="${params.seq}"></c:out>'>
				작성자 : 
				<input type="text" id="memName" name="memName" value='<c:out value="${params.memName}"></c:out>'>
				<br>
				ID : 
				<input type="text" id="memId" name="memId" value='<c:out value="${params.memId}"></c:out>'>
				<br>
				제목 : 
				<input type="text" id="boardSubject" name="boardSubject" value='<c:out value="${params.boardSubject}"></c:out>'>
				<br>
				내용 : 
				<br>
				<textarea placeholder="내용" id="boardContent" name="boardContent"><c:out value="${params.boardContent}"></c:out></textarea>
				<input type="hidden" id="viewCnt" name="viewCnt" value='<c:out value="${params.viewCnt }"></c:out>'>
				<input type="hidden" id="useYn" name="useYn" value='<c:out value="${params.useYn }"></c:out>'>
			</fieldset>
			
			<div id="button">
				<button type="button" onclick="updatePost()" id="updateBtn">수정하기</button>
				<button type="button" id="deleteBtn">삭제하기</button>
			</div>
		</form>
		<form action="/post/delete" method="post" id="deleteForm">
			<input type="hidden" id="delSeq" name="delSeq" value='<c:out value="${params.seq }"></c:out>'>
		</form>
	</div>
</body>
<script>
	function updatePost() {
	    const form = document.getElementById('updateForm');
	    document.getElementById('updateBtn').disabled = true;
	    form.action = '/post/update';
	    form.submit();
	    alert('게시글이 수정되었습니다');
	}
	
	$(document).ready(function () {
		$('#deleteBtn').on("click", function (){
			if ( !confirm('정말로 게시글을 삭제할까요?') ) {
                return false;
            }
			var form = $('#deleteForm');
			form.submit();
			alert('게시글을 삭제하였습니다');
		});
	});
		
</script>
</html>