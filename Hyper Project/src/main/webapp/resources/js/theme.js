
function setTheme() {
	
	var html = document.getElementsByTagName('html')[0];

	if(theme=='A'){
		var mainColor = '#fff';
		var backColor = '#222';
		var borderColor = 'rgba(34,34,34,0.4)';
	}else if(theme=='B'){
		var mainColor = '#222';
		var backColor = '#f2f2f2';
		var borderColor = 'rgba(245,245,245,0.4)';
	}else{
		var mainColor = '#fff';
		var backColor = '#222';
		var borderColor = 'rgba(34,34,34,0.4)';
	}

	html.style.setProperty("--main-color", mainColor);
	html.style.setProperty("--back-color", backColor);
	html.style.setProperty("--border-color", borderColor);
	if (backgroundImage!="") {
		html.style.setProperty("--back-image", "url('../../upload/"+backgroundImage+"')");
	}
}

setTheme();