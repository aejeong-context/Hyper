<%@page import="com.min.app.dto.User_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="widgetDate" class="widget">
	<div id="widgetDateBox">
		<span id="widgetDateBox-time"></span>
	</div>
</div>
<div id="widgetKey" class="widget">
	<div class="widgetKey-key">
		<div id="key-ctrl-name" class="key-name">Ctrl</div>
		<div id="key-ctrl-explain" class="key-explain" onclick="keydownTab();">모드
			전환</div>
	</div>
	<div class="widgetKey-key">
		<div id="key-tab-name" class="key-name">Tab</div>
		<div id="key-tab-explain" class="key-explain" onclick="keydownTab();">검색엔진
			변경</div>
	</div>
	<div class="widgetKey-key">
		<div id="key-enter-name" class="key-name">Enter</div>
		<div id="key-enter-explain" class="key-explain"
			onclick="keydownEnter();">검색</div>
	</div>
</div>
<div id="widgetFunction" class="widget">
	<div title="디데이" onmouseover="widgetDayOn();">
		<i class="fas fa-clock"></i>
	</div>
	<div title="메모" onmouseover="widgetMemoOn();">
		<i class="fas fa-sticky-note"></i>
	</div>
	<!-- 	<div title="설정"> -->
	<!-- 		<i class="fas fa-tools"></i> -->
	<!-- 	</div> -->
	<div title="회원" onmouseover="widgetLoginOn();">
		<i class="fas fa-id-badge"></i>
	</div>
</div>
<div id="widgetProfile" class="widget">
	<div>상태메시지</div>
	<div>
		Nickname · <span>email@kakao.com</span>
	</div>
</div>