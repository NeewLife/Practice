function deleteForm(index){
	$(".form"+index).remove();
}

function fileCheck(fillAdd){
	console.log(fillAdd.name);
    var fileInput = document.getElementById(fillAdd.name);
    console.log(fileInput);

    var file = fileInput.files[0];
    var fileName = file.name;
    var fileWidth = file.width;
    console.log("fileName = " + fileName + ", fileWidth = " + fileWidth);
    
    var image = new Image();
    image.src = URL.createObjectURL(file);
    
    var fileType = fileName.split('.').pop().toLowerCase();
        
    console.log("fileType = " + fileType);
    console.log($.inArray(fileType,['gif', 'png', 'jpg', 'jpeg', 'gif']));
    
    if($.inArray(fileType,['gif', 'png', 'jpg', 'jpeg']) == -1){
    	alert("이미지 파일만 첨부 가능합니다.");
    	fileInput.value = "";
    }
    
    image.onload = function() {
        var imageWidth = this.width;
        var imageHeight = this.height;
        
        
        if(imageWidth >= 500 || imageHeight >= 500){
        	alert("높이나 너비는 500px 까지만 가능합니다.\n현재 첨부된 이미지 높이 = " + imageHeight + "\n현재 첨부된 이미지 너비 = " + imageWidth);
        	fileInput.value = "";
        	console.log("파일 초기화됨");
        }
    }
};


$(document).ready(function(){
	var i = 1;
	$("#addFileInput").on("click", function(){
		
		let html = `<div class="form${i}">
					<input type="file" id="fileItem${i}" name="fileItem${i}" onchange="fileCheck(this)">
					<button type="button" onclick="deleteForm(${i})">삭제</button>
					</div>
					`
		$(".fileUpload").append(html);
		i++;
	});
	
	
	
	$("#saveBtn").on("click", function(e){
		alert("파일 전송");
		
		var formData = $("#saveForm").serializeArray()
		console.log(formData);
		
	});
});

