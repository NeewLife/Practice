function goViewPage(seq) {
		location.href = '/post/view?seq=' + seq;
	}
	
function movePage(){
	var form = document.searchForm; 
	form.method = "post";
	form.action = "/";
	form.submit();
	
}
