function bye(){
	if (confirm("are you sure?")) {
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

function snsMsgDelete(no){
	if(confirm("are you sure?")){
		location.href = "sns.delete?ds_no=" + no;
	}
}

function snsMsgUpdate(no, txt){
	txt = prompt("txt", txt);
	if(txt != null && txt.length > 0 && txt.length < 250){
		location.href = "sns.update?ds_no=" + no + "&ds_txt=" + txt;
	} 
}

function joinGo() {
	location.href = "member.join.go";
}

function logout(){
	var ok = confirm("are you sure?");
	if (ok) {
		location.href = "member.logout";
	}
}

function memberInfoGo(){
	location.href = "member.info.go";
}

function snsPageChange(page){
	location.href = "sns.page.change?p=" +  page;
//	alert(page + "page");
	
}
