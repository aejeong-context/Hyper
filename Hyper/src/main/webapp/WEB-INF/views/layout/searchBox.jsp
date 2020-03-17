<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="searchBox" onkeyup="keydownSearch()">
			<div id="searchEngine" onclick="keydownTab();">G</div>
			<div id="searchInput">
				<input autocomplete="off" type="text" id="searchInputText" onfocus="test();" onfocusout="test2();">
			</div>
			<div id="searchButton">
				<button onclick="keydownEnter();">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</div>
		<script>
		function test() {
			document.getElementById("searchBox").style.opacity ="1.0";
		}
		function test2() {
			document.getElementById("searchBox").style.opacity ="0.8";
		}
		</script>