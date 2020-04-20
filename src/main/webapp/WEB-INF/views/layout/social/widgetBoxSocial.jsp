<%@page import="com.min.app.dto.User_Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../../component/common/widgetBoxLimit.jsp"/>

<div id="widgetFunction" class="widget">
	<div title="디데이" onmouseover="widgetDayOn();">
		<i class="fas fa-clock"></i>
	</div>
	<div title="메모" onmouseover="widgetMemoOn();">
		<i class="fas fa-sticky-note"></i>
	</div>
	<div title="나의 Hyper로 이동" onclick="location.href='./?nickname=${Ldto.setting_nck}';">
		<i class="fas fa-location-arrow"></i>
	</div>
</div>
<div id="widgetProfile" class="widget">
	<div>${Sdto.setting_msg}</div>
	<div>
		${Sdto.setting_nck}
	</div>
</div>