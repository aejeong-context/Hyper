setTimeout(function() {
		inputTarget.focus();
	}, 100);

	var mode = "search";

	function modeChange() {
		if (event.keyCode == 17) {
			keydownCtrl();
		}
	}
	
	function keydownCtrl() {
		var searchDisplay = document.getElementById("pageNav-search");
		var linkDisplay = document.getElementById("pageNav-link");
		var searchBox = document.getElementById("searchBox");
		var linkBox = document.getElementById("linkBox");
		var tabEx = document.getElementById("key-tab-explain");
		var enterEx = document.getElementById("key-enter-explain");
		
		if (mode == "search") {
			mode = "link";
			searchDisplay.textContent = "●";
			searchDisplay.classList.remove("pageNav-on");
			searchDisplay.classList.add("pageNav-off");
			linkDisplay.textContent = "즐겨찾기";
			linkDisplay.classList.remove("pageNav-off");
			linkDisplay.classList.add("pageNav-on");
			searchBox.style.display = "none";
			linkBox.style.display = "block";
			tabEx.textContent = "편집";
			tabEx.onclick = function() {
				
			}
			enterEx.textContent = "검색";
			enterEx.onclick = function() {
				keydownCtrl();
			}
		} else {
			mode = "search";
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
		var nowSet = document.getElementById('searchEngine');
		if (nowSet.textContent == 'G') {
			nowSet.textContent = 'N';
			type = 'N';
		} else if (nowSet.textContent == 'Y') {
			nowSet.textContent = 'G';
			type = 'G';
		} else if (nowSet.textContent == 'N') {
			nowSet.textContent = 'Y';
			type = 'Y';
		}
		setTimeout(function() {
			inputTarget.focus();
		}, 100);
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

	function keydownSearch() {
		if (mode == "search") {
			if (event.keyCode == 9) {
				keydownTab();
			} else if (event.keyCode == 13) {
				keydownEnter();
			}
		}
	}