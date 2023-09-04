
function temporary(){
	let html = ` <input type="hidden" id="confirmStatus" name="confirmStatus" value="1"> `
	let form = document.querySelector("form");
	form.insertAdjacentHTML('afterbegin', html);
	form.submit();
}

function request(){
	let html = ` <input type="hidden" id="confirmStatus" name="confirmStatus" value="2"> `
	let form = document.querySelector("form");
	form.insertAdjacentHTML('afterbegin', html);
	form.submit();
}