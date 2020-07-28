function bye(){
	if (confirm("진짜?")) {
		location.href = "member.bye";
	}
}

function imgBlink() {
	var titleImg = document.getElementById("titleImg");
	var titleImg2 = document.getElementById("titleImg2");
	var visible = true;
	setInterval(function() {
		if (visible) {
			titleImg.style.opacity = 1;
			titleImg2.style.opacity = 0;
		} else {
			titleImg.style.opacity = 0;
			titleImg2.style.opacity = 1;
		}
		visible = !visible;
	}, 500);
}

function joinGo() {
	location.href = "member.join.go";
}

function logout(){
	var ok = confirm("진짜?");
	if (ok) {
		location.href = "member.logout";
	}
}

function memberInfoGo(){
	location.href = "member.info.go";
}



