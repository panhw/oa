window.onload = function() {

	
	
	

};

function setShareOrUnshare(folderId) {
	
	var req = null;
	try {
		req = new XMLHttpRequest();
	} catch (e) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}

	req.open("get", "servlet/SetShareOrUnshareServlet?folderId="+folderId);

	req.onreadystatechange = function() {

		if (req.readyState == 4 && req.status) {
			var text =req.responseText;
			
			var btn =document.getElementById("shareBtn"+folderId);
			if(text=='4'){
				btn.innerHTML="设为共享";
			}else if(text=='3'){
				btn.innerHTML="取消共享";
			}else{
				alert("修改失败 ");
			}
		}
	};

	req.send();
};
function shareClick(folderId){
	
	setShareOrUnshare(folderId);
};