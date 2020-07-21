function check(){
	var priceInput = document.inputForm.p;
	var countInput = document.inputForm.c;
	
	if (isEmpty(priceInput) || isNotNumber(priceInput)) {
		alert("단가!");
		priceInput.value = "";
		priceInput.focus();
		return false;
	}

	
	
	if (isEmpty(countInput) || isNotNumber(countInput)) {
		alert("수량!");
		countInput.value = "";
		countInput.focus();
		return false;
	}

	return true;
	
}