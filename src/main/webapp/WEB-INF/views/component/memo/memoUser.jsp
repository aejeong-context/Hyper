<%@page import="com.min.app.dto.Memo_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="widgetFunctionArea" id="widgetFunctionMemo">
	<div class="widgetTitle">
		MEMO <i class="widgetAdd fas fa-plus" onclick="memoAdd();"></i>
		<div id="memoAddBox" class="widgetAddBox">
			<div class="widgetAddLine">
				<input type="text" id="memoInput" placeholder="Contents" style="padding-left:2px;"/>
			</div>
			<div class="widgetAddLine">
				<div><i class="fas fa-check" onclick="memoSubmit();"></i></div>
				<div><i class="fas fa-times" onclick="memoCancle();"></i></div>
			</div>
		</div>
	</div>
	<div class="memoBox">
	<%
		List<Memo_Dto> mDTO = (List<Memo_Dto>)request.getAttribute("memoList");
		
		if(mDTO != null){
			for(int i = 0; i< mDTO.size(); i++){
	%>
		<div class="memoLine" onclick="memoDelete('<%=mDTO.get(i).getMemo_seq() %>');">
			<%=mDTO.get(i).getMemo_con() %>
		</div>
	<%
			}
		}
	%>
	</div>
</div>
    