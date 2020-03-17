var nckChk = document.getElementById("nckChk"); // 닉네임 체크 아이콘 표시
var emailChk = document.getElementById("emailChk"); // 이메일 체크 아이콘 표시
var pwChk = document.getElementById("pwChk"); // 비밀번호 체크 아이콘 표시

var nckPass = false; // 닉네임 통과여부
var emailPass = false; // 이메일 통과여부
var pwPass = false; // 비밀번호 통과여부

function nickCheck() {
	var nick = document.getElementById("nck");
	var nickLength = nick.value.length;

	// 정규화표현식 : 한글, 영문, 숫자만 입력 가능
	var nickReg = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|\*]+$/;

	if ((nick.value.indexOf(" ") == -1) // 공백체크
			&& ((nickLength >= 2) && (nickLength <= 12)) // 글자수체크
			&& nickReg.test(nick.value)) { // 정규화표현식
		jQuery.ajax({
			type : "post",
			url : "./checknick",
			data : "nick=" + nick.value,
			async : true,
			success : function(msg) {
				if (msg.checkn == "null") {
					nckChk.innerHTML = "<i class='fas fa-check'></i>";
					nckPass = true;
				} else {
					nckChk.innerHTML = "<i class='fas fa-times'></i>";
					nckPass = false;
				}
			}
		});
	} else {
		nckChk.innerHTML = "<i class='fas fa-times'></i>";
		nckPass = false;
	}
}

function emailCheck() {
	var email = document.getElementById("email");
	var emailLength = email.value.length;

	// 정규화표현식 : 이메일 형식만 가능
	var emailReg = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

	if ((email.value.indexOf(" ") == -1) // 공백체크
			&& ((emailLength >= 4) && (emailLength <= 30)) // 글자수체크
			&& emailReg.test(email.value)) { // 정규화표현식
		jQuery.ajax({
			type : "post",
			url : "./checkemail",
			data : "email=" + email.value,
			async : true,
			success : function(msg) {
				if (msg.checke == "null") {
					emailChk.innerHTML = "<i class='fas fa-check'></i>";
					emailPass = true;
				} else {
					emailChk.innerHTML = "<i class='fas fa-times'></i>";
					emailPass = false;
				}
			}
		});
	} else {
		emailChk.innerHTML = "<i class='fas fa-times'></i>";
		emailPass = false;
	}

}

function passwordCheck() {
	var pw = document.getElementById("pw");
	var pwLength = pw.value.length;

	if ((pw.value.indexOf(" ") == -1) // 공백 체크
			&& ((pwLength >= 4) && (pwLength <= 16))) { // 글자수 체크
		pwChk.innerHTML = "<i class='fas fa-check'></i>";
		pwPass = true;
	} else {
		pwChk.innerHTML = "<i class='fas fa-times'></i>";
		pwPass = false;
	}
}

function signSubmit() {
	if (nckPass && emailPass && pwPass) {
		return true;
	}else{
		alert("입력한 값을 다시 확인해주세요.");
		return false;
	}
}
