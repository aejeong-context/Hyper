<%@page import="com.min.app.dto.Day_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="widgetFunctionArea" id="widgetFunctionDay">
	<div class="widgetTitle">
		D - Day
	</div>
	<div class="dayBox">
		<%
			List<Day_Dto> Ddto = (List<Day_Dto>)request.getAttribute("dayList");
			if(Ddto != null){
				for (int i = 0; i < Ddto.size(); i++) {
		%>
		<div class="dayLine">
			<div class="dayName"><%=Ddto.get(i).getDay_title() %></div>
			<div class="dayCount"><%=Ddto.get(i).getDay_date() %>일</div>
			<div class="dayDay"><%=Ddto.get(i).getDay_oldDate() %></div>
		</div>
		<%
				}
			}
		%>
	</div>
</div>