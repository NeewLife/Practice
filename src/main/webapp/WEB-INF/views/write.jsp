<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
	<script src="${path}/resources/js/write.js"></script>
</head>
<body>
	<a href="/">목록으로</a>

	<form action="/post/save" method="post" id="saveForm" name="saveForm" enctype="multipart/form-data">
		<fieldset>
			작성자 : 
			<input type="text" id="memName" name="memName">
			<br>
			ID : 
			<input type="text" id="memId" name="memId">
			<br>
			제목 : 
			<input type="text" id="boardSubject" name="boardSubject">
			<br>
			내용 : 
			<br>
			<textarea placeholder="내용" id="boardContent" name="boardContent"></textarea>
		</fieldset>
		<div class="fileUpload">
			<button type="button" id="addFileInput">파일 추가</button>
		</div>
		<div id="submitButton">
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>