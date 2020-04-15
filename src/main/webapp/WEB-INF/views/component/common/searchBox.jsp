<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="searchBox">
			<div id="searchEngine" onclick="keydownTab();" style="color:#4285f4;">G</div>
			<div id="searchInput">
				<input autocomplete="off" type="text" id="searchInputText" onfocus="inInput();" onfocusout="outInput();">
			</div>
			<div id="searchButton">
				<button onclick="keydownEnter();">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</div>
		<script>
		function inInput() {
			document.getElementById("searchBox").style.opacity ="1.0";
		}
		function outInput() {
			document.getElementById("searchBox").style.opacity ="0.8";
		}
		</script>