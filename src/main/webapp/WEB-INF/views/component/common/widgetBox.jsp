<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="widgetDate" class="widget">
	<div id="widgetDateBox">
		<span id="widgetDateBox-time"></span>
	</div>
</div>
<div id="widgetKey" class="widget">
	<div class="widgetKey-key">
		<div id="key-ctrl-name" class="key-name">→</div>
		<div id="key-ctrl-explain" class="key-explain" onclick="keydownTrans();">즐겨찾기 모드</div>
	</div>
	<div class="widgetKey-key">
		<div id="key-tab-name" class="key-name">Tab</div>
		<div id="key-tab-explain" class="key-explain" onclick="keydownTab();">검색엔진
			변경</div>
	</div>
	<div class="widgetKey-key" id="key-enter">
		<div id="key-enter-name" class="key-name">Enter</div>
		<div id="key-enter-explain" class="key-explain"
			onclick="keydownEnter();">검색</div>
	</div>
</div>
