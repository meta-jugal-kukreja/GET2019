function currencySelectionValidation(form) {
	var selectedCurrencyType = form.typeOfCurrency.value;
	if (selectedCurrencyType == null){
		alert("please select Currency type");
		return false;
	}
	var plans = document.getElementsByName("plan");
    var checkedPlan;
    for (i = 0; i < plans.length; i++) {
        if (plans[i].checked) {
            checkedPlan = plans[i].value;
            break;
        }
    }
    var table = document.getElementById("priceTable");
    switch (checkedPlan) {
        case "Daily":
            document.getElementById("final_price").value = table.rows[1].cells[1].innerHTML;
            break;
        case "Monthly":
            document.getElementById("final_price").value = table.rows[2].cells[1].innerHTML;
            break;
        case "Yearly":
            document.getElementById("final_price").value = table.rows[3].cells[1].innerHTML;
            break;
    }
	return true;
}

function changeCurrency() {
		alert("Currency change called" + document.getElementById("selectedVehicle").value);
		var table = document.getElementById("priceTable");
	    switch (document.getElementById("selectedVehicle").value) {
	        case "Cycle":
	            table.rows[1].cells[1].innerHTML = convertCurrency(5);
	            table.rows[2].cells[1].innerHTML = convertCurrency(100);
	            table.rows[3].cells[1].innerHTML = convertCurrency(500);
	            break;
	        case "MotorCycle":
	            table.rows[1].cells[1].innerHTML = convertCurrency(10);
	            table.rows[2].cells[1].innerHTML = convertCurrency(200);
	            table.rows[3].cells[1].innerHTML = convertCurrency(1000);
	            break;
	        case "Four Wheelers":
	            table.rows[1].cells[1].innerHTML = convertCurrency(20);
	            table.rows[2].cells[1].innerHTML = convertCurrency(500);
	            table.rows[3].cells[1].innerHTML = convertCurrency(3500);
	            break;
	    }
	    var element = document.querySelector('#showPrice');
	    element.style.visibility = 'visible';
	}  

function convertCurrency(INRPrice) { 
    var currencyType = document.getElementById("typeOfCurrency").value;
    if (currencyType == "USD") {
        return (0.014 * INRPrice).toFixed(2);
    } else if (currencyType == "YEN") {
        return (1.47 * INRPrice).toFixed(2);
    } else {
        return INRPrice;
    }
}
