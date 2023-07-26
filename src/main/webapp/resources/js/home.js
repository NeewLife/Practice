function goViewPage(seq) {
	location.href = '/post/view?seq=' + seq;
}
	
function movePage(){
	var form = document.searchForm; 
	form.method = "post";
	form.action = "/";
	form.submit();
}

$(document).ready(function() {
	$("span").on("click", function(){
	
	
	  	$.ajax({
		    type: "post"
		  , url: "page"
		  , data: {
		    	"pageNum" : 2	    	
		    	}
    	  , error: function() {
		      console.log('통신실패!!');
		    }
	      , success: function(data) {
		      console.log("통신데이터 값 : " + Object.entries(data));
		    }
	  	});
  	});
});