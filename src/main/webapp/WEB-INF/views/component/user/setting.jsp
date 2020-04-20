<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="widgetFunctionArea" id="widgetFunctionSetting">
	<div id="settingTab">
		<div id="settingTabBtn1" class="settingTabOn"
			onclick="widgetSettingTab();">환경설정</div>
		<div id="settingTabBtn2" onclick="widgetSettingTab();">개인정보</div>
	</div>
	<div id="settingBox">
		<div id="hyperSetting">
			<div class="settingItem">
				<div class="settingItemTitle">상태메시지</div>
				<div class="settingItemArea">
					<input type="text" id="settingMessage" value="${Sdto.setting_msg}"
						maxlength="32" />
				</div>
			</div>
			<div class="settingItem">
				<div class="settingItemTitle">테마</div>
				<div class="settingItemArea">
					<input id="theme1" class="themeCheck" type="radio" value="A"
						name="theme" ${arUserSet[1]=='A'?'checked="checked"':''} /> <label
						for="theme1" onclick="defaultBackground();">화이트</label> <input id="theme2" class="themeCheck"
						type="radio" value="B" name="theme"
						${arUserSet[1]=='B'?'checked="checked"':''} /> <label
						for="theme2" style="background: #fff; color: #000;" onclick="defaultBackground();">블랙</label>
				</div>
			</div>
			<div class="settingItem">
				<div class="settingItemTitle">배경화면</div>
			<div id="preDefault"></div>
			<div id="preView"></div>
				<form id="fileForm" name="frm" method="post">
					<label class="fileBtn" for="file">이미지 업로드</label>
					<input type="file" name="file" id="file">
					<span class="fileBtn" onclick="resetImage();">테마 기본 배경</span>
				</form>
			</div>
			<button class="settingSubmitBtn" type="button"
				onclick="updateUserSet();">변경하기</button>
		</div>

		<div id="privacySetting">
			<div class="settingItem">
				<form action="./changeNick" id="changeNckForm" method="post"
					onsubmit="return nickChange();">
					<div class="settingItemTitle">닉네임</div>
					<div class="settingItemArea">
						<input type="text" id="nckChange" name="setting_nck"
							placeholder="${Ldto.setting_nck}" required="required"
							onkeyup="nickCheck();" />
						<div class="form-login-check" id="nckChangeChk"
							style="right: 10px; top: 6px;"
							title="닉네임은 2글자 이상 12글자 이하로 공백을 포함하지 않습니다."></div>
					</div>
					<button class="settingSubmitBtn" type="submit">변경</button>
				</form>
			</div>
			<div class="settingItem">
				<form action="./logout" onsubmit="return pwChange();">
					<div class="settingItemTitle">비밀번호</div>
					<div class="settingItemArea">
						<input type="password" id="oldPw" placeholder="현재 비밀번호"
							required="required" /> <input type="password" id="newPw"
							placeholder="변경 비밀번호" style="margin-top: 20px;"
							required="required" />
						<div class="form-login-check" id="nckChangeChk"
							style="right: 10px; top: 6px;"
							title="닉네임은 2글자 이상 12글자 이하로 공백을 포함하지 않습니다."></div>
					</div>
					<button class="settingSubmitBtn" type="submit">재설정</button>
				</form>
			</div>

			<div class="settingItem">
				<div class="settingItemTitle">
					<a href="./logout">로그아웃</a>
				</div>
			</div>
			<hr style="border: none; border-top: 1px solid #f2f2f2;" />
			<div class="settingItemTitle" style="color: #ddd; cursor: pointer;"
				onclick="signDown();">회원탈퇴</div>
		</div>
	</div>
</div>
