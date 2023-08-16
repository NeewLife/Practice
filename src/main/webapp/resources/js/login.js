function login(data){
	let html = "";
	html +=     `
				<input type="hidden" id="id" name="id" value="${data.id}">
				<input type="hidden" id="userId" name="userId" value="${data.userId}">
				<input type="hidden" id="userPw" name="userPw" value="${data.userPw}">
				<input type="hidden" id="userName" name="userName" value="${data.userName}">
				<input type="hidden" id="userRank" name="userRank" value="${data.userRank}">
			    `
    let form = document.getElementById("loginData");
    form.innerHTML = html;
    form.submit();
}

$(document).ready(function(){
	
	$("#submit").on("click", function(){
		
		if($("#loginId").val() == ""){
			alert("아이디를 입력하세요");
			return 0;
		}
		if($("#loginPw").val() == ""){
			alert("비밀번호를 입력하세요");
			return 0;
		}
		
		var loginId = $("#loginId").val()
		var loginPw = $("#loginPw").val()
		
		
		$.ajax({
		    type: "post",
			url : "login",
	 		data : {loginId : loginId
	 				, loginPw : loginPw
	 			   },
			success : function (data, statusText, jqXHR){
				alert(data.message);
				if(data.message == "로그인 성공"){
					login(data.user);
				}else{
					location.replace("/");
				}
			},
		                    
			error : function (jqXHR, textStatus, errorThrown){
				alert(textStatus); //"error"로 고정인듯함
			}
		});
	});
});