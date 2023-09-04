function login(data){
	let html = "";
	html +=     `
				<input type="hidden" id="id" name="id" value="${data.id}">
			    `
    let form = document.getElementById("loginData");
    form.innerHTML = html;
    form.submit();
}

$(document).ready(function(){
	
	$("button").on("click", function(){
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