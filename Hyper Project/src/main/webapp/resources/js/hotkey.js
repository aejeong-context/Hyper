var mode = "search";
active = true;

setTimeout(function() {
	inputTarget.focus();
}, 100);

/*
 * 0 : off, 1: on
 */
function activeChange(choice) {
	switch (choice) {
	case 0: active=false; break;
	case 1: active=true; break;
	default: active=true; break;
	}
}

function modeChange() {
	if (active) {
		if (mode == "search" && event.keyCode == 39) {
			keydownTrans();
		}else if (mode == "link" && event.keyCode == 37){
			keydownTrans();
		}else if (event.keyCode == 9) {
			keydownTab();
		}else if (event.keyCode>=65&&event.keyCode<=122&&mode=="link"){
			keydownLink();
		}else if(mode == "search" && event.keyCode == 13){
			keydownEnter();
		}
	}
}

function keyCodeMatch() {
	var key = String.fromCharCode(event.keyCode);
	alert(key);
}

function keydownLink() {
	var oriKey = String.fromCharCode(event.keyCode);
	var key = oriKey.toUpperCase();
	var href = $(".hotHref[data-key='"+key+"']").attr("href");
	if (href==undefined) {
		alert("경로가 설정되어 있지 않습니다.");
	}else{
		window.open(href, '_blank'); 

	}
}

function keydownTrans(key) {
	var transDisplay = document.getElementById("key-ctrl-name");
	var searchDisplay = document.getElementById("pageNav-search");
	var linkDisplay = document.getElementById("pageNav-link");
	var searchBox = document.getElementById("searchBox");
	var linkBox = document.getElementById("linkBox");
	var tabEx = document.getElementById("key-tab-explain");
	var enterEx = document.getElementById("key-enter-explain");
	var transEx = document.getElementById("key-ctrl-explain");
	var enterKey = document.getElementById("key-enter");
	if (mode == "search") {
		mode = "link";
		enterKey.style.display = "none";
		searchDisplay.textContent = "●";
		searchDisplay.classList.remove("pageNav-on");
		searchDisplay.classList.add("pageNav-off");
		linkDisplay.textContent = "즐겨찾기";
		linkDisplay.classList.remove("pageNav-off");
		linkDisplay.classList.add("pageNav-on");
		searchBox.style.display = "none";
		linkBox.style.display = "block";
		transDisplay.innerHTML = "←";
		transEx.textContent = "빠른검색 모드"
		tabEx.textContent = "편집";
		tabEx.onclick = function() {
			keydownTab();
		}
		enterEx.textContent = "검색";
		enterEx.onclick = function() {
			keydownTrans();
		}
	} else {
		mode = "search";
		transDisplay.innerHTML = "→";
		enterKey.style.display = "inline-block";
		transEx.textContent = "즐겨찾기 모드"
			searchDisplay.textContent = "빠른검색";
		searchDisplay.classList.remove("pageNav-off");
		searchDisplay.classList.add("pageNav-on");
		linkDisplay.textContent = "●";
		linkDisplay.classList.remove("pageNav-on");
		linkDisplay.classList.add("pageNav-off");
		linkBox.style.display = "none";
		searchBox.style.display = "block";
		tabEx.textContent = "검색엔진 변경";
		tabEx.onclick = function() {
			keydownTab();
		}
		enterEx.textContent = "검색";
		enterEx.onclick = function() {
			keydownEnter();
		}
		inputTarget.focus();
	}
}
var inputTarget = document.getElementById("searchInputText");
var type = 'G';

function keydownTab() {
	if (mode == "search") {
		var nowSet = document.getElementById('searchEngine');
		if (nowSet.textContent == 'G') {
			nowSet.textContent = 'N';
			nowSet.style.color="#1Ec800";
			type = 'N';
		} else if (nowSet.textContent == 'Y') {
			nowSet.textContent = 'G';
			nowSet.style.color="#4285f4";
			type = 'G';
		} else if (nowSet.textContent == 'N') {
			nowSet.textContent = 'Y';
			nowSet.style.color="#E62117";
			type = 'Y';
		}
		setTimeout(function() {
			inputTarget.focus();
		}, 100);
	}else{
		location.href="./edit";
	}
}

function keydownEnter() {
	var word = inputTarget.value;
	var url = '';
	if (word == null || word.trim() == '') {
		alert('키워드가 입력되지 않았습니다.');
		inputTarget.value = '';
	} else {
		if (type == 'G') {
			url = 'https://www.google.com/search?q=' + word;
		} else if (type == 'N') {
			url = 'https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query='
				+ word;
		} else if (type == 'Y') {
			url = 'https://www.youtube.com/results?search_query=' + word;
		}
		var win = window.open(url, '_blank');
		win.focus();
	}

}
