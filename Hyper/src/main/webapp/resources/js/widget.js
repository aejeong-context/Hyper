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
	document.getElementById("widgetFunctionDay").style.display = "block";
	document.getElementById("form-background").style.display = "block";
}
function widgetMemoOn() {
	widgetOff();
	document.getElementById("widgetFunctionMemo").style.display = "block";
	document.getElementById("form-background").style.display = "block";
}
function widgetLoginOn() {
	widgetOff();
	document.getElementById("widgetFunctionLogin").style.display = "block";
	document.getElementById("form-background").style.display = "block";
}
function widgetSignOn() {
	widgetOff();
	document.getElementById("widgetFunctionSign").style.display = "block";
}
function widgetOff() {
	document.getElementById("widgetFunctionLogin").style.display = "none";
	document.getElementById("widgetFunctionSign").style.display = "none";
	document.getElementById("widgetFunctionMemo").style.display = "none";
	document.getElementById("widgetFunctionDay").style.display = "none";
	document.getElementById("form-background").style.display = "none";
}