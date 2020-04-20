<%@page import="com.min.app.dto.User_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../../component/common/widgetBox.jsp"/>

<div id="widgetProfile" class="widget">
	<div>${Sdto.setting_msg}</div>
	<div>
		${Sdto.setting_nck} · <span>${Ldto.user_email}</span>
	</div>
</div>

<div id="widgetFunction" class="widget">
	<div title="디데이" onmouseover="widgetDayOn();">
		<i class="fas fa-clock"></i>
	</div>
	<div title="메모" onmouseover="widgetMemoOn();">
		<i class="fas fa-sticky-note"></i>
	</div>
	<div title="설정" onmouseover="widgetSettingOn();">
		<i class="fas fa-tools"></i>
	</div>
</div>
