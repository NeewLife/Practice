$(document).ready(function(){

	$("#searchBtn").on("click", function(){
		("#search").submit();
	});

	$("#search").on("change", function(){
	
		let searchType = $("#searchType").val();
		let keyword = $("#keyword").val();
		let authType = $("#authType").val();
		let startDate = $("#startDate").val();
		let endDate = $("#endDate").val();
		
		var html = '';
		
		$.ajax({
	        type: 'post', 
	        url: "/search", 
	        dataType: "JSON",
	        data: {"searchType":searchType
	        	 , "keyword":keyword
	        	 , "authType":authType
	        	 , "startDate":startDate
	        	 , "endDate":endDate}, // 원하는 값을 중복확인하기위해서  JSON 형태로 DATA 전송
	        success: function(data){
	        	console.log(data);
	        	$("#posts").empty();
	        	if(data.length>=1){
				data.forEach(function(item){
					console.log("foreach문 실행");
	        		html += `
	        				<tr>
								<td><a href="javascript:view(${item.postId})"><p style="margin : 0px">${item.postId}</p></a></td>
								<td><a href="javascript:view(${item.postId})"><p style="margin : 0px">${item.writer}</p></a></td>
								<td><a href="javascript:view(${item.postId})"><p style="margin : 0px">${item.title}</p></a></td>
								<td><a href="javascript:view(${item.postId})"><p style="margin : 0px">${item.writeDate}</p></a></td>
								<td><a href="javascript:view(${item.postId})"><p style="margin : 0px">${item.confirmDate}</p></a></td>
								<td><a href="javascript:view(${item.postId})"><p style="margin : 0px">${item.confirmPerson}</p></a></td>
		
		 						<!-- 결재상태 DB 값에 따라 변경해서 결재상태 출력 -->
							
							`
						console.log(item.confirmStatus);
						switch(item.confirmStatus){
							case 1:
								html += `<td><a href='javascript:view(${item.postId})'><p style='margin : 0px'>임시저장</p></a></td></tr>`
								break;
							case 2:
								html += `<td><a href="javascript:view(${item.postId})"><p style="margin : 0px">결재대기</p></a></td></tr>`
								break;
							case 3:
								html += `<td><a href="javascript:view(${item.postId})"><p style="margin : 0px">결재중</p></a></td></tr>`
								break;
							case 4:
								html += `<td><a href="javascript:view(${item.postId})"><p style="margin : 0px">결재완료</p></a></td></tr>`
								break;
							case 5:
								html += `<td><a href="javascript:view(${item.postId})"><p style="margin : 0px">반려</p></a></td></tr>`
								break;
						}
	        		})
	        		$("#posts").append(html);
        		}
	        },
	        error : function(error){alert(error);}
	    });
	});
})



function writePost(){
	let url = "/write"
	location.href = url;
}

function authorize(){
	let url = "/view"
	location.href = url;
}

function view(postId){
	let url = "/view?postId=";
	location.href = url + postId;
}

