<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="widgetFunctionArea" id="widgetFunctionLogin">
	<form class="signIn">
		<div class="fn-title">Hyper</div>
		<div class="form-login-low">
			<input type="text" id="UserEmail" name="user_email" placeholder="이메일"
				required="required" />
		</div>
		<div class="form-login-low">
			<input type="password" id="UserPassword" name="user_pw"
				placeholder="비밀번호" required="required" onkeyup="signinEnter();" />
		</div>
		<div class="form-login-btn">
			<button type="button" onclick="widgetSignOn();">회원가입</button>
			<button type="button" onclick="signinCheck();">로그인</button>
		</div>
	</form>
</div>
<div class="widgetFunctionArea" id="widgetFunctionSign">
	<form id="sign" action="./register" method="post"
		onsubmit="return signSubmit()">
		<div class="fn-title">Hyper</div>
		<div class="form-login-low">
			<input type="text" id="nck" name="setting_nck" placeholder="닉네임"
				required="required" onkeyup="nickCheck();" />
			<div class="form-login-check" id="nckChk"
				title="닉네임은 2글자 이상 12글자 이하로 공백을 포함하지 않습니다."></div>
		</div>
		<div class="form-login-low">
			<input type="text" id="email" name="user_email" placeholder="이메일"
				required="required" onkeyup="emailCheck();" />
			<div class="form-login-check" id="emailChk"
				title='이메일은 4글자 이상 30글자 이하로 공백과 일부 특수문자를 포함하지 않습니다.'></div>
		</div>
		<div class="form-login-low">
			<input type="password" id="pw" name="user_pw" placeholder="비밀번호"
				required="required" onkeyup="passwordCheck();" />
			<div class="form-login-check" id="pwChk"
				title="비밀번호는 4글자 이상 16글자 이하로 공백을 포함하지 않습니다."></div>
		</div>
		<div class="form-login-btn">
			<button type="submit">회원가입</button>
		</div>
	</form>
</div>