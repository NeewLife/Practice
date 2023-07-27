function goViewPage(seq) {
	location.href = '/post/view?seq=' + seq;
}

function goPage(num){
	console.log("num = " + num);
	console.log(`$("#pageNum").val() = " + ${$("#pageNum").val()}`);
	$("#pageNum").val(num);
	console.log(`입력후 $("#pageNum").val() = " + ${$("#pageNum").val()}`);
	$(".bt_search").click();
}

	
$(document).ready(function() {

	$(".bt_search").on("click", function (){
	
		$.ajax({
			type: "post"
		  , url: "page"
		  , data: $("#searchForm").serialize()
    	  , error: function() {
		      console.log('검색실패!!');
		    }
	      , success: function(data) {
	      		var listElement = $("#list");
	      		let html = "";
	      		
	      		var dataList = new Array(data.list.length);
	      		for(var i = 0; i < data.list.length; i++){
	      			dataList[i] = data.list[i];
	      			if(dataList[i].uptDate == null){
	      				dataList[i].uptDate = "";
	      			}
	      		}
				
				listElement.empty();
	      		$.each(dataList,function(index, dataList){
	      			html += `
						<tr>3
							<td><input type="checkbox"></td>
							<td>${dataList.seq}</td>
							<td>${dataList.memName}</td>
							<td>
								<a href="javascript:void(0);" onclick="goViewPage(${dataList.seq})">
									${dataList.boardSubject}
								</a>
							</td>
							<td>${dataList.regDate}</td>
							<td>${dataList.uptDate}</td>
							<td>${dataList.viewCnt}</td>
						</tr>
					`;
	      		});
	      		listElement.html(html);
	      		
	      		
	        }
		});
	});
	
});