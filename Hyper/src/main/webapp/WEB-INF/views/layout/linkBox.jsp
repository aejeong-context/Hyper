<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<div id="linkBox" style="display: none;">
			<div id="linkSet">
				<%
					int cnt = 10;
					String[][] arKey = {{"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"},
							{"A", "S", "D", "F", "G", "H", "J", "K", "L"}, {"Z", "X", "C", "V", "B", "N", "M"}};
					String[][] arIcon = {
							{"fab fa-google", "fab fa-youtube", "fab fa-apple", "fas fa-lightbulb", "fas fa-envelope",
									"fas fa-award", "fas fa-box", "fas fa-car", "fab fa-java", "fab fa-js"},
							{"fas fa-seedling", "S", "D", "F", "G", "H", "J", "K", "L"}, {"Z", "X", "C", "V", "B", "N", "M"}};

					for (int i = 1; i <= 3; i++) {
				%>
				<div class="hotLow" style="padding-left: <%=(i - 1) * 27%>px;">
					<%
						for (int j = 0; j < cnt; j++) {
					%>
					<div class="hotLink">
						<div class="hotkey"><%=arKey[i - 1][j]%></div>
						<div class="hotFav">
							<i class="<%=arIcon[i - 1][j]%>"></i>
						</div>
					</div>
					<%
						}
					%>
				</div>
				<%
					cnt = cnt - i;
					}
				%>
			</div>
		</div>