
var upload = document.querySelector('#file');
var preView =  document.querySelector('#preView');
var preDef =  document.querySelector('#preDefault');

// 아작스 업로드
function ajaxFileUpload() {

    var form = jQuery("#fileForm")[0];
    var formData = new FormData(form);

    jQuery.ajax({
          url : "./imageIn"
        , type : "POST"
        , processData : false
        , contentType : false
        , data : formData
        , success:function(map) {
        }
    });
}

// 미리보기
upload.addEventListener('change',function (e) {
	var get_file = e.target.files;
	var selected_file = upload.files[0];
	var idxDot = selected_file.name.lastIndexOf(".") + 1;
	var extFile = selected_file.name.substr(idxDot, selected_file.name.length).toLowerCase();
	if (extFile == "jpg" || extFile == "jpeg" || extFile == "png" || extFile == "svg" || extFile == "gif") {
		var image=document.createElement('img');
		var reader = new FileReader();
		reader.onload=(function(aImg){
			return function(e){
				aImg.src=e.target.result;
				
				//파일 사이즈 체크
				var oriSize = upload.files[0].size/1000000;
				var stopTemp = (oriSize+"").indexOf(".");
				var size = (oriSize+"").substring(0,stopTemp) + (oriSize+"").substring(stopTemp,4);
				if (size>2) {
					alert("이미지 크기 : "+size+"MB\n2MB보다 낮은 이미지를 다시 올려주세요.");
				}else{
					alert("이미지 크기 : "+size+"MB\n이미지를 적용할 수 있습니다.");
					//미리보기 변경
					preDef.style.display = 'none';
					preView.style.display ='block';
					preView.style.backgroundImage ='url(\"'+e.target.result+'\")';
				}
				
			}
		})(image)
		
	    if(get_file){
	    	reader.readAsDataURL(get_file[0]);
	    }
		
	} else {
	     alert("이미지 파일만 업로드 가능합니다. ex) jpg/jpeg, png, svg, gif");
	}
})

function defaultBackground() {
	setTimeout(function() {
		var themeCheck = $('input[name="theme"]:checked').val();
		var backColor = "#f2f2f2";
		if (theme=="A") {
			backColor ="#222";
		}else if(theme=="B"){
			backColor = "#f2f2f2";
		}
		
		if (themeCheck=="A") {
			backColor ="#222";
		}else if(themeCheck=="B"){
			backColor = "#f2f2f2";
		}
		
		preDef.style.background = backColor;
	}, 100);
}
defaultBackground();
// 초기화
function resetImage() {
	preView.style.backgroundImage ='';
	preView.style.display ='none';
	defaultBackground();
	preDef.style.display = "block";
	upload.value="";
	
}