<%@page import="com.min.app.dto.Memo_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="widgetFunctionArea" id="widgetFunctionMemo">
	<div class="widgetTitle">
		MEMO
	</div>
	<div class="memoBox">
	<%
		List<Memo_Dto> mDTO = (List<Memo_Dto>)request.getAttribute("memoList");
		
		if(mDTO != null){
			for(int i = 0; i< mDTO.size(); i++){
	%>
		<div class="memoLine">
			<%=mDTO.get(i).getMemo_con() %>
		</div>
	<%
			}
		}
	%>
	</div>
</div>
    