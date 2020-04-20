<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<input id="editIconInput" type="hidden"/>
<div id="linkBox" style="display: block;">
	<div id="linkSet">
		<%
		Map<String,String[]> map = (Map<String,String[]>)request.getAttribute("linkMode");
		
		int handler = 10;
		int cnt = 0;
		
		String[][] arKey = {{"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"},
				{"A", "S", "D", "F", "G", "H", "J", "K", "L"}, {"Z", "X", "C", "V", "B", "N", "M"}};
		String[] arIcon = map.get("icon");

		String[] arIconSet = { "fab fa-airbnb", "fab fa-angellist", "fab fa-apple", "fas fa-asterisk",
					"fab fa-blogger", "far fa-bookmark", "fas fa-book", "fas fa-cloud-download-alt", "fas fa-cloud",
					"fas fa-code", "fab fa-codepen", "far fa-comments", "fab fa-discord", "fas fa-dog", "fas fa-paw",
					"fab fa-evernote", "fab fa-facebook-square", "fab fa-github-square", "fab fa-google-drive",
					"fas fa-heart", "fab fa-instagram-square", "fab fa-linkedin", "fab fa-medium",
					"fab fa-pinterest-square", "fas fa-podcast", "fas fa-seedling", "fas fa-shopping-cart",
					"fas fa-shopping-basket", "fas fa-shipping-fast", "fas fa-skull-crossbones", "fab fa-slack",
					"fab fa-stack-overflow", "fab fa-skype", "far fa-star", "fas fa-star-of-david",
					"fab fa-steam-square", "fab fa-twitch", "fab fa-twitter-square", "fab fa-tumblr-square",
					"fab fa-youtube", "fas fa-won-sign", "fas fa-sms", "fas fa-route", "fas fa-poo", "fas fa-paperclip",
					"fas fa-moon", "fas fa-mug-hot", "fas fa-mouse-pointer", "fas fa-music", "fas fa-graduation-cap",
					"fas fa-grin-hearts", "fas fa-grin-squint", "fas fa-grin-stars", "fas fa-grin-squint-tears",
					"far fa-thumbs-up", "fas fa-at", "fas fa-language", "fas fa-map-marker-alt",
					"fas fa-map-marked-alt", "fas fa-play" };

			for (int i = 1; i <= 3; i++) {
		%>
		<div class="hotLow" style="padding-left: <%=(i - 1) * 27%>px;">
			<%
				for (int j = 0; j < handler; j++) {
			%>
			<div class="hotLink" onclick="onEdit(<%=i - 1%>,<%=j%>);">
				<div class="hotkey"><%=arKey[i - 1][j]%></div>
				<div class="hotFav">
					<i class="<%=arIcon[cnt]%>"></i>
				</div>
				<div class="hotEdit" data-key="<%=arKey[i - 1][j]%>">
					<!-- 링크 -->
					<div class="editLink">
						<input type="text" class="editLinkInput" data-key="<%=arKey[i - 1][j]%>"
							placeholder="<%=arKey[i - 1][j]%>:url ex) www.naver.com/" />
					</div>
					<!-- 아이콘 -->
					<div class="editIcon">

						<i onclick="editChange('');"> </i>
						<%
							for (int k = 0; k < arIconSet.length; k++) {
						%>
						<i class="<%=arIconSet[k]%>" data-click="false"
							onclick="editChange('<%=arIconSet[k]%>');"></i>
						<%
							}
						%>

					</div>
					<!-- 적용 -->
					<div class="editBtn">
						<i class="fas fa-check" onclick="editSave('<%=arKey[i - 1][j]%>');"></i>
					</div>
				</div>
			</div>
			<%
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