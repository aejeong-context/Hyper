function getTime(){
	var timeDisplay = document.getElementById("widgetDateBox-time");
	let time = new Date();

	let hour = time.getHours();
	let minutes = time.getMinutes();
	let seconds = time.getSeconds();
	timeDisplay.textContent = numChk(hour)+" : "+numChk(minutes)+" : "+numChk(seconds);
}


function getDate() {
	var dateDisplay = document.getElementById("widgetDateBox");
	const date = new Date();
	
	const month = date.getMonth() + 1; 
	const day = date.getDate();
	const week = new Array ("일","월","화","수","목","금","토");
	dateDisplay.innerHTML = numChk(month) + ". " + numChk(day) +". ("+week[date.getDay()]+")<span id='widgetDateBox-time'></span>";
	

}
function numChk(num) {
	return num<10?"0"+num:num;
}

function init(){
	getDate();
	getTime();
	setInterval(getTime, 1000);
}

init();

function widgetDayOn() {
	widgetOff();
	activeChange(0);
	document.getElementById("widgetFunctionDay").style.display = "block";
	document.getElementById("form-background").style.display = "block";
}
function widgetMemoOn() {
	widgetOff();
	activeChange(0);
	document.getElementById("widgetFunctionMemo").style.display = "block";
	document.getElementById("form-background").style.display = "block";
}
function widgetLoginOn() {
	widgetOff();
	activeChange(0);
	document.getElementById("widgetFunctionLogin").style.display = "block";
	document.getElementById("form-background").style.display = "block";
}
function widgetSignOn() {
	widgetOff();
	activeChange(0);
	document.getElementById("widgetFunctionSign").style.display = "block";
}
function widgetSettingOn() {
	widgetOff();
	activeChange(0);
	document.getElementById("widgetFunctionSetting").style.display = "block";
	document.getElementById("form-background").style.display = "block";
}
function widgetOff() {
	var widget = document.getElementsByClassName("widgetFunctionArea");
	activeChange(1);
	for(var i = widget.length-1; i>=0 ;i--){
		var item = widget.item(i);
		item.style.display = "none";
	}
	document.getElementById("form-background").style.display = "none";
}

function widgetSettingTab() {
	var hSet = document.getElementById("hyperSetting");
	var hBtn = document.getElementById("settingTabBtn1");
	var pSet = document.getElementById("privacySetting");
	var pBtn = document.getElementById("settingTabBtn2");
	if (pSet.style.display == "block") {
		hSet.style.display = "block";
		hBtn.classList.add("settingTabOn");
		pSet.style.display = "none";
		pBtn.classList.remove("settingTabOn");
	}else{
		hSet.style.display = "none";
		hBtn.classList.remove("settingTabOn");
		pSet.style.display = "block";
		pBtn.classList.add("settingTabOn");
	}
}
// 테마 및 상태메시지 변경
function updateUserSet() {
	ajaxFileUpload();
	var message = document.getElementById("settingMessage").value;
	var theme = $('input[name="theme"]:checked').val();
		jQuery.ajax({
			type : "post",
			url : "./updateUserSet",
			data : "message=" + message + "&theme=" + theme,
			async : true,
			success : function(msg) {
				if (msg.checkS == "true") {
					alert("환경설정이 변경 됐습니다.");
					location.href="./";
				} else {
					alert("변경할 환경설정을 다시 확인해주세요.");
				}
			}
		});
}


function nickChange() {
	var nick = document.getElementById("nckChange");
	var nickChangeChk = document.getElementById("nckChangeChk");
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
					nickChangeChk.innerHTML = "<i class='fas fa-check'></i>";
					alert("닉네임이 변경되었습니다. 다시 로그인해주세요.");
					return true;
				} else {
					nickChangeChk.innerHTML = "<i class='fas fa-times'></i>";
					alert("중복된 닉네임 입니다.");
					return false;
				}
			}
		});
	} else {
		nckChk.innerHTML = "<i class='fas fa-times'></i>";
		alert("잘못된 닉네임 입니다.");
		return false;
	}
}

function pwChange() {
	// 기존 비밀번호 확인
	var oldPw = document.getElementById("oldPw");
	var newPw = document.getElementById("newPw");
	
	var pwLength = newPw.value.length;
	
	if ((newPw.value.indexOf(" ") == -1) // 공백 체크
			&& ((pwLength >= 4) && (pwLength <= 16))) { // 정규화표현식
		jQuery.ajax({
			type : "post",
			url : "./changePw",
			data : "oldPw=" + oldPw.value + "&newPw="+ newPw.value,
			async : true,
			success : function(msg) {
				if (msg.checkp == true) {
					alert("비밀번호가 변경되었습니다. 다시 로그인해주세요.");
					return true;
				} else {
					alert("비밀번호를 다시 확인해주세요.");
					return false;
				}
			}
		});
	} else {
		alert("비밀번호를 다시 확인해주세요.");
		return false;
	}
}

function signDown() {
	var isk = confirm("고객님의 정보는 탈퇴시 복구가 불가능합니다.\n정말 회원탈퇴 하시겠습니까?");
	if (isk) {
		location.href="./signDown";
	}
}

function dayAdd() {
	document.getElementById("dayAddBox").style.display = "block";
	document.getElementById('dayAddDate').valueAsDate = new Date();
}

function dayCancle() {
	document.getElementById("dayAddBox").style.display = "none";
}
function memoAdd() {
	document.getElementById("memoAddBox").style.display = "block";
}

function memoCancle() {
	document.getElementById("memoAddBox").style.display = "none";
}
function memoDelete(memo_seq) {
	var isc = confirm("정말 메모를 삭제하겠습니까?");
	if (isc) {
		jQuery.ajax({
			type : "post",
			url : "./memoDelete",
			data : "memo_seq=" + memo_seq,
			async : true,
			success : function(msg) {
				if (msg.checkm == "true") {
					alert("메모가 삭제됐습니다.");
					location.href="./";
					return true;
				} else {
					alert("메모를 삭제하는데 실패했습니다.");
					return false;
				}
			}
		});
	}
}
function memoSubmit() {
	var mCon = document.getElementById("memoInput");

	if (mCon.value!=""&&mCon.value.length<=80) {
		jQuery.ajax({
			type : "post",
			url : "./memoInsert",
			data : "memo_con=" + mCon.value,
			async : true,
			success : function(msg) {
				if (msg.checkm == "true") {
					alert("메모가 추가됐습니다.");
					location.href="./";
					return true;
				} else {
					alert("메모를 추가하는데 실패했습니다.");
					return false;
				}
			}
		});
	}else{
		alert("메모를 입력해주세요.");
	}
}
function daySubmit() {
	var dLabel = document.getElementById("dayAddLabel");
	var dDate = document.getElementById("dayAddDate");
	
	if (dLabel.value!="") {
		jQuery.ajax({
			type : "post",
			url : "./insertDay",
			data : "day_title=" + dLabel.value + "&day_date=" + dDate.value,
			async : true,
			success : function(msg) {
				if (msg.checkd == "true") {
					alert("D-Day가 추가됐습니다.");
					location.href="./";
					return true;
				} else {
					alert("D-Day를 추가하는데 실패했습니다.");
					return false;
				}
			}
		});
	}else{
		alert("D-Day Label을 입력해주세요.");
	}
	
}

function dayDelete(day_seq) {
	var isc = confirm("정말 D-Day를 삭제하겠습니까?");
	if (isc) {
		jQuery.ajax({
			type : "post",
			url : "./deleteDay",
			data : "dayseq=" + day_seq,
			async : true,
			success : function(msg) {
				if (msg.dDel == "true") {
					alert("D-Day가 삭제됐습니다.");
					location.href="./";
					return true;
				} else {
					alert("D-Day를 삭제하는데 실패했습니다.");
					return false;
				}
			}
		});
	}
}
