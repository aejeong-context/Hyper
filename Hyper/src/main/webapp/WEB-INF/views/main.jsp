<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인성공
<p>${Ldto.user_email} 님 환영합니다.</p>
<a href="./logout">로그아웃</a>


<form action="./pwChange" method="post">
비밀번호 변경
<input type="hidden" name="user_seq" value="${Ldto.user_seq}">
<input type="password" name="user_pw" placeholder="변경할 비밀번호">
<button type="submit">변경</button>
</form>

<form action="" method="post">
</form>

<form action="">
</form>

<a href="">회원탈퇴</a>

</body>
</html>