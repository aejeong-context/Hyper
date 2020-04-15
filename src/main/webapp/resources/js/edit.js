function onEdit(i,j) {
	$('.hotEdit').css("display","none");

	var arKey = [["Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"],
			["A", "S", "D", "F", "G", "H", "J", "K", "L"], ["Z", "X", "C", "V", "B", "N", "M"]];

	$('.hotEdit[data-key="'+arKey[i][j]+'"]').css("display","block");
	
}

function editChange(name) {
	document.getElementById('editIconInput').value = name;
}

function editSave(value) {
	var key = value;
	var icon = document.getElementById('editIconInput').value;
	var link = $('.editLinkInput[data-key="'+key+'"]').val();
	alert(link);
	link = link.replace("http://","");
	link = link.replace("https://","");
	
	alert(link);
		jQuery.ajax({
			type : "post",
			url : "./editSave",
			data : "key=" + key + "&icon=" + icon + "&link=" + link,
			async : true,
			success : function(msg) {
				if (msg.checku == "true") {
					location.href="./edit";
				} else {
					alert("단축키 정보를 다시 확인해주세요.");
				}
			}
		});
}

function returnHome() {
	if (event.keyCode == 9) {
		location.href="./";
	}
}