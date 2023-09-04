function reject(){
	let form = document.getElementById("approval");
	form.setAttribute("action","/reject");
	form.submit();
}

function approval(){
	let form = document.getElementById("approval");
	form.setAttribute("action","/confirm");
	form.submit();
}

function modify(){
	let form = document.getElementById("approval");
	form.setAttribute("action","/write");
	form.submit();
}