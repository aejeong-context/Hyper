
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>

<script>

	
</script>
<body>
	<h1>Hello world!</h1>

	<form class="sign" action="./register" method="post">
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
	
	



	<script src="https://code.jquery.com/jquery-3.4.1.js"
		integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
		crossorigin="anonymous"></script>

	<script type="text/javascript">
$(document).ready(function(){
	$("#nck").keyup(function(){
		var inputLength = $(this).val().length;
		var nick="";
		//한글, 영문, 숫자만 입력 가능
		var nickReg = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|\*]+$/;
		
		nick=$(this).val();
		if(inputLength < 2 || inputLength > 15){
			$("#nck").before("<span>불가능</span>");
		}else if(nick.indexOf(" ") != -1){
			$("#nck").before("<span>불가능</span>");
		}else if(nickReg.test($("input[name=setting_nck]").val())){
			jQuery.ajax({
				type:"post",
				url:"./checknick",
				data:"nick="+$(this).val(),
				asyn:true,
				success:function(msg){
					if(msg.checkn=="null"){
						$("#nck").before("<span>가능</span>");
					}else{
						$("#nck").before("<span>불가능</span>");
					}
				}
			})
		}

		
	});
	$("#email").keyup(function(){
		var inputLength = $(this).val().length;
		var email="";
		//한글, 영문, 숫자만 입력 가능
		var emailReg = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		
		nick=$(this).val();
		if(inputLength < 4 || inputLength > 30){
			$("#email").before("<span>불가능</span>");
		}else if(email.indexOf(" ") != -1){
			$("#email").before("<span>불가능</span>");
		}else if(emailReg.test($("input[name=user_email]").val())){
			jQuery.ajax({
				type:"post",
				url:"./checkemail",
				data:"email="+$(this).val(),
				asyn:true,
				success:function(msg){
					if(msg.checke=="null"){
						$("#email").before("<span>가능</span>");
					}else{
						$("#email").before("<span>불가능</span>");
					}
				}
			})
		}

		
	})
	
	$("#pw").keyup(function(){
		var inputLength = $(this).val().length;
		var pw = "";
		pw=$(this).val();
		//5글자이상 15글자 이내
		if(inputLength < 4 || inputLength > 16){
			$("#email").before("<span>불가능</span>");
		}else if(email.indexOf(" ") != -1){
			$("#email").before("<span>불가능</span>");
	
		}
		})
	
	
	
})
</script>
</body>
</html>
