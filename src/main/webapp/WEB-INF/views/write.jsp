<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/post/save" method="post" id="saveForm">
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
		<div id="submitButton">
			<button type="button" onclick="savePost()" id="saveBtn">등록</button>
		</div>
	</form>
</body>
<script type="text/javascript">
	function savePost() {
	    alert('게시글이 저장되었습니다');
	    const form = document.getElementById('saveForm');
	    document.getElementById('saveBtn').disabled = true;
	    form.action = [[ ${post == null} ]] ? '/post/save' : '/post/update';
	    form.submit();
	}
</script>
</html>