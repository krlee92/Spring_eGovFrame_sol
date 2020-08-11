function joinCheck() {
	var idInput = document.joinForm.dm_id;
	var pwInput = document.joinForm.dm_pw;
	var pwChkInput = document.joinForm.dm_pwChk;
	var nameInput = document.joinForm.dm_name;
	var addr1Input = document.joinForm.dm_addr1;
	var addr2Input = document.joinForm.dm_addr2;
	var addr3Input = document.joinForm.dm_addr3;
	var photoInput = document.joinForm.dm_photo;

	if (isEmpty(idInput) || containsHS(idInput) 
			|| $("#dm_idInput").css("color") == "rgb(255, 0, 0)") {
		alert("ID?");
		idInput.value = "";
		idInput.focus();
		return false;
	}
	
	
	
	if (isEmpty(pwInput) || notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "1234567890")) {
		alert("PW?");
		pwInput.value = "";
		pwChkInput.value = "";
		pwInput.focus();
		return false;
	}
	if (isEmpty(nameInput)) {
		alert("name?");
		nameInput.value = "";
		nameInput.focus();
		return false;
	}
	if (isEmpty(addr1Input) || isEmpty(addr2Input) || isEmpty(addr3Input)) {
		alert("addr?");
		addr1Input.value = "";
		addr2Input.value = "";
		addr3Input.value = "";
		addr1Input.focus();
		return false;
	}
	if (isEmpty(photoInput)
			|| (isNotType(photoInput, "bmp") && isNotType(photoInput, "webp")
					&& isNotType(photoInput, "jpg")
					&& isNotType(photoInput, "gif") && isNotType(photoInput,
					"png"))) {
		alert("photo?");
		photoInput.value = "";
		photoInput.focus();
		return false;
	}
	return true;
}

function loginCheck() {
	var idInput = document.loginForm.dm_id;
	var pwInput = document.loginForm.dm_pw;

	if (isEmpty(idInput) || isEmpty(pwInput)) {
		alert("check!");
		idInput.value = "";
		pwInput.value = "";
		idInput.focus();
		return false;
	}
	return true;
}

function memberUpdateCheck() {
	var idInput = document.memberUpdateForm.dm_id;
	var pwInput = document.memberUpdateForm.dm_pw;
	var pwChkInput = document.memberUpdateForm.dm_pwChk;
	var nameInput = document.memberUpdateForm.dm_name;
	var addr1Input = document.memberUpdateForm.dm_addr1;
	var addr2Input = document.memberUpdateForm.dm_addr2;
	var addr3Input = document.memberUpdateForm.dm_addr3;
	var photoInput = document.memberUpdateForm.dm_photo;

	if (isEmpty(idInput) || containsHS(idInput)) {
		alert("ID?");
		idInput.value = "";
		idInput.focus();
		return false;
	}
	if (isEmpty(pwInput) || notEquals(pwInput, pwChkInput)
			|| notContains(pwInput, "1234567890")) {
		alert("PW?");
		pwInput.value = "";
		pwChkInput.value = "";
		pwInput.focus();
		return false;
	}
	if (isEmpty(nameInput)) {
		alert("name?");
		nameInput.value = "";
		nameInput.focus();
		return false;
	}
	if (isEmpty(addr1Input) || isEmpty(addr2Input) || isEmpty(addr3Input)) {
		alert("addr?");
		addr1Input.value = "";
		addr2Input.value = "";
		addr3Input.value = "";
		addr1Input.focus();
		return false;
	}

	if (isEmpty(photoInput)) {
		return true;
	}

	if (isNotType(photoInput, "bmp") && isNotType(photoInput, "gif")
			&& isNotType(photoInput, "jpg") && isNotType(photoInput, "png")
			&& isNotType(photoInput, "webp")) {
		alert("photo?");
		photoInput.value = "";
		photoInput.focus();
		return false;
	}
	return true;webp
}

function snsWriteCheck() {
	var txtInput = document.snsWriteForm.ds_txt;

	if (isEmpty(txtInput)) {
		alert("?");
		txtInput.value = "";
		txtInput.focus();
		return false;
	}
	return true;
}

function snsWriteReplyCheck(f) {
	// <form name="snsWriteReplyForm">속의 <input name="dsr_txt">
//	var txtInput = document.snsWriteReplyForm.dsr_txt;
	
	var txtInput = f.dsr_txt;

	if (isEmpty(txtInput)) {
		alert("?");
		txtInput.value = "";
		txtInput.focus();
		return false;
	}
	return true;
}

