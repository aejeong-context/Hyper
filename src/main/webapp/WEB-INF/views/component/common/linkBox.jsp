<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div id="linkBox" style="display: none;" onkeydown="keydownLink();">
			<div id="linkSet">
				<%
					Map<String,String[]> map = (Map<String,String[]>)request.getAttribute("linkMode");
					
					int handler = 10;
					int cnt = 0;
					
					String[][] arKey = {{"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"},
							{"A", "S", "D", "F", "G", "H", "J", "K", "L"}, {"Z", "X", "C", "V", "B", "N", "M"}};
					String[] arIcon = map.get("icon");
					String[] arLink = map.get("link");

					for (int i = 1; i <= 3; i++) {
				%>
				<div class="hotLow" style="padding-left: <%=(i - 1) * 27%>px;">
					<%
						for (int j = 0; j < handler; j++) {
							if(arLink[cnt].length()>0){
					%>
					<a class="hotHref" href="http://<%=arLink[cnt] %>" target="_blank" data-key="<%=arKey[i - 1][j]%>">
					
					<%
							}
					%>
						<div class="hotLink" title="<%=arLink[cnt] %>">
							<div class="hotkey"><%=arKey[i - 1][j]%></div>
							<div class="hotFav">
								<i class="<%=arIcon[cnt]%>"></i>
							</div>
						</div>
					<%
							if(arLink[cnt].length()>0){
					%>
					</a>
					<%
							}
							cnt++;
						}
					%>
				</div>
				<%
					handler = handler - i;
					}
				%>
			</div>
		</div>