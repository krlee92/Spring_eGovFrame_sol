function connectSNSWriteAreaSummonEvent() {
	var btnVisible = false;
	$("#snsWriteAreaSummoner").click(function() {

		if (btnVisible) {
			$("#snsWriteArea").css("left", "0px");
		} else {
			$("#snsWriteArea").css("left", "-430px");
		}
		btnVisible = !btnVisible;
	});
	$("#snsWriteAreaSummoner2").click(function() {
		if (btnVisible) {
			$("#snsWriteArea2").css("left", "-413px");
		} else {
			$("#snsWriteArea2").css("left", "0px");
		}
		btnVisible = !btnVisible;
	});
}

function connectIdCheckEvent() {
	$("#dm_idInput").keyup(function(e) {
		var dm_id = $(this).val();
		$.getJSON("member.id.check?dm_id=" + dm_id, function(data) {
			if (data.member[0] != null) { // data.member.length == 1 도 가능?..
				$("#dm_idInput").css("color", "red");
			} else {
				$("#dm_idInput").css("color", "blue");
			}
		});
	});
}

function connectTitleAreaSummonEvent() {
	$("#siteTitleArea").mouseenter(function() {
		$(this).css("top", "0px");
	});
	$("#siteTitleArea").mouseleave(function() {
		$(this).css("top", "-62px");
	});
};

function connectAddressSearchEvent() {
	$("#addrSearchBtn").click(function() {
		new daum.Postcode({
	        oncomplete: function(data) {
	        	// http://postcode.map.daum.net/guide
	        	// 이곳의 API를 활용하기
	        	// alert(JSON.stringify(data)); data에 담긴것은 JSON Object
	        	$("#dm_addr1Input").val(data.zonecode);
	        	$("#dm_addr2Input").val(data.addressEnglish);
	        	
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	        }
	    }).open();
	});
}

function rClickShow() {
	$(document).contextmenu(function() {
		return false; // 마우스R클릭 안나오게
	});
}

$(function() {
	connectAddressSearchEvent();
	connectSNSWriteAreaSummonEvent();
	connectTitleAreaSummonEvent();
	connectIdCheckEvent();
	rClickShow();
});