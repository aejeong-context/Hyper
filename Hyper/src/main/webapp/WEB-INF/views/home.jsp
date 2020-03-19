
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>

<body>
	<h1>Hello world!</h1>

	<form class="sign" action="./register" method="post">
	<input type="hidden" name="user_seq" value="${Ldto.user_seq}">
		<input type="email" id="email" name="user_email" placeholder="이메일"
			required="required"> <input type="password" id="pw"
			name="user_pw" placeholder="비밀번호" required="required"> <input
			type="text" id="nck" name="setting_nck" placeholder="닉네임"
			required="required">
		<button type="submit">완료</button>
	</form>
	<br>

	<form class="signIn" action="./signIn" method="post">
		<input type="email" id="UserEmail" name="user_email" placeholder="이메일"
			required="required"> <input type="password" id="UserPassword"
			name="user_pw" placeholder="비밀번호" required="required">
		<button type="submit">완료</button>
	</form>
	
</body>
</html>
