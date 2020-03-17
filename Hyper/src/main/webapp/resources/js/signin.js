function signinEnter() {
	if (event.keyCode == 13) {
		signinCheck();
	}
}
function signinCheck(){
	var email = document.getElementById("UserEmail").value;
	var password = document.getElementById("UserPassword").value;
	jQuery.ajax({
			type : "post",
			url : "./signIn",
			data : "email=" + email + "&password=" + password,
			async : true,
			success : function(msg) {
				if (msg.checkl == "true") {
					location.href="./";
				} else {
					alert("회원정보를 다시 확인해주세요.");
				}
			}
		});
}