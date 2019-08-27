/**
 * Class containing methods to validate the form
 */
class Validation
{
    Validation(){}

    /**
     * Method to validate the user details
     * @param {*} name is the user name
     * @param {*} email is the user email
     * @param {*} password is the user password
     * @param {*} confirmPassword is the confirm password field
     * @param {*} contact is the user contact number
     * @param {*} gender is the user gender
     */
    static validateUserInformation(name , email , password , confirmPassword , contact , gender)
    {
        // Validating Contact Number
        var count=0;
		var filterContact = new RegExp('([a-zA-Z!@#$%^&*()_+])');
		if(!(contact.length <= 10 && contact.length >= 8) ) {
			this.errorDescription('required_e_contact',"Insert Number Between 8 to 10");
			count++;
		}else if(filterContact.test(contact)) {
			this.errorDescription('required_e_contact',"Numeric values are only allowed");
		} else {
			this.removeDescription('required_e_contact',"");
			count--;
		}

        //Validating user name
		var filterName = new RegExp('\\d');
		if(name.length <= 2) {
			this.errorDescription('required_e_name',"Insert name greater then 2 word");
			count++;
		} else if(filterName.test(name)) {
			this.errorDescription('required_e_name',"Numeric value not allowed");
			count++;
		} else{
			this.removeDescription('required_e_name',"");
			count--;
		}

        //Validating email
		var filterEmail = new RegExp("^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$");
  		if (!filterEmail.test(email)) {
			this.errorDescription('required_e_email' ,"Insert a Valid Email");
			count++;
		} else {
			this.removeDescription('required_e_email',"");
			count--;
		}

        //Validating Password
		var filterPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
		if(password.length <= 8){
			this.errorDescription('required_e_pass' ,"Atleast 8 char required");
			count++;
		} else if (!filterPassword.test(password)) {
			this.errorDescription('required_e_pass' ,"Insert Valid password format eg Abc@123");
			count++;
		} else if(password != confirmPassword) {
			this.errorDescription('required_e_pass' ,"Both password should same");
			count++;
		} else {
			this.removeDescription('required_e_pass',"");
			count--;
		}

        // Validating Gender
		if(gender === ""){
			this.errorDescription('required_e_gender' ,"Select Any one Gender");
			count++;
		} else{
			this.removeDescription('required_e_gender',"");
			count--;
		}

		return count;
    }

    /**
     * Method to validate the vehicle information
     * @param {*} vehicleName is the vehicle name
     * @param {*} type is the vehicle type
     * @param {*} vehicleNumber is the vehicle number
     * @param {*} identity is the vehicle identity
     */
    static validateVehicleInformation(vehicleName , type , vehicleNumber , identity) {
        var count = 0;
        //validating vehicle name
        if(vehicleName.length < 3)
        {
			this.errorDescription('required_v_name',"Insert name greater then 2 word");
			count++;
        } else 
        {
			this.removeDescription('required_v_name',"");
			count--;
		}

        //validating vehicle type
		if(type == "none") {
			this.errorDescription('required_v_type',"Select Type Of Your Vehicle");
			count++;
		} else {
			this.removeDescription('required_v_type',"");
			count--;
		}

        //validating vehicle number
		if(vehicleNumber.length < 4) {
			this.errorDescription('required_v_number',"Vehicle Number required");
			count++;
		} else {
			this.removeDescription('required_v_number',"");
			count--;
        }
        
        //validating vehicle identity(description)
		if(identity.length <= 10) {
			this.errorDescription('required_v_detail',"Identity filled is required");
			count++;
		} else {
			this.removeDescription('required_v_detail',"");
			count--;
		}
		return count;
    }
    
    /**
     * This method displays the validation error
     * @param {*} id is the div id
     * @param {*} text is the error text
     */
    static errorDescription(id , text) {
		document.getElementById(id).innerHTML = text;
    }
    
    /**
     * This method removes the error descripton
     * @param {*} id is the div id
     * @param {*} text is the error text
     */
    static removeDescription(id , text) {
		document.getElementById(id).innerHTML = text;
	}
}

var selectedVehicleType = "";
var planPrice = 0;
/**
 * Method to validate and register the user
 */
function registerUser()
{
    var  name      = document.getElementById("employee_name").value;
	var  email     = document.getElementById("employee_email").value;
	var  password  = document.getElementById("employee_password").value;
	var  cPassword = document.getElementById("employee_conform_password").value;
	var  contact   = document.getElementById("employee_contact").value;
	var  genderM    = document.getElementById("employee_gender_male").checked;
	var  genderF    = document.getElementById("employee_gender_female").checked;

	var gender ="";
	if(genderM == true){
		gender = "Male";
	}
	else if(genderF == true){
		gender = "Female";
    }
    
    var count = Validation.validateUserInformation(name,email,password,cPassword,contact,gender);
    if(count == -5)
    {
        var employee_id = 0001;
        document.getElementById("employee_registration").innerHTML = "Your Registration Id is : " + employee_id;
        document.getElementById("employee_id").value = employee_id;
    }
}

/**
 * Method to validate and register the vehicle
 */
function registerVehicle()
{
    var  vehicleName = document.getElementById("vehicle_name").value;
	var  type = document.getElementById("vehicle_type").value;
	var  vehicleNumber = document.getElementById("vehicle_number").value;
	var  vehicleDetail = document.getElementById("vehicle_details").value;
	var count = Validation.validateVehicleInformation(vehicleName , type , vehicleNumber , vehicleDetail);
    if(count == -4)
    {
        selectedVehicleType = document.getElementById("vehicle_type").value;
        document.getElementById("vehicle_registration").innerHTML = " ";
        displayPlan();
    }
}
/**
 * Utility method to display the plan according to the vehicle type selected
 */
function displayPlan()
{
    currencyType = document.getElementById("currency_type").value;
    document.getElementById("vehicle_type_field").innerHTML = "Price for " + selectedVehicleType + " parkings in " + currencyType + " are :";

    dailyPriceForCycle = 5;
    monthlyPriceForCycle = 100;
    yearlyPriceForCycle = 500;

    dailyPriceForMotorCycle = 10;
    monthlyPriceForMotorCycle = 200;
    yearlyPriceForMotorCycle = 1000;

    dailyPriceForFourWheeler = 20;
    monthlyPriceForFourWheeler = 500;
    yearlyPriceForFourWheeler = 3500;
    switch(currencyType)
    {
        case "INR":
                if(selectedVehicleType == "Cycle")
                {
                    document.getElementById("vehicle_price_field_daily").innerHTML = "Rs. "  + dailyPriceForCycle + " for Daily";
                    document.getElementById("vehicle_price_field_monthly").innerHTML = "Rs. " + monthlyPriceForCycle + " for Monthly";
                    document.getElementById("vehicle_price_field_yearly").innerHTML = "Rs. " + yearlyPriceForCycle + " for Yearly";
                }
                else if(selectedVehicleType == "Motor Cycle")
                {
                    document.getElementById("vehicle_price_field_daily").innerHTML = "Rs. "  + dailyPriceForMotorCycle + " for Daily";
                    document.getElementById("vehicle_price_field_monthly").innerHTML = "Rs. " + monthlyPriceForMotorCycle + " for Monthly";
                    document.getElementById("vehicle_price_field_yearly").innerHTML = "Rs. " + yearlyPriceForMotorCycle + " for Yearly";
                }
                else if(selectedVehicleType == "Four Wheelers")
                {
                    document.getElementById("vehicle_price_field_daily").innerHTML = "Rs. "  + dailyPriceForFourWheeler + " for Daily";
                    document.getElementById("vehicle_price_field_monthly").innerHTML = "Rs. " + monthlyPriceForFourWheeler + " for Monthly";
                    document.getElementById("vehicle_price_field_yearly").innerHTML = "Rs. " + yearlyPriceForFourWheeler + " for Yearly";
                }
            break;
        case "USD" :
                if(selectedVehicleType == "Cycle")
                {
                    document.getElementById("vehicle_price_field_daily").innerHTML = "Rs. "  + (dailyPriceForCycle*0.014).toFixed(2) + " for Daily";
                    document.getElementById("vehicle_price_field_monthly").innerHTML = "Rs. " + (monthlyPriceForCycle*0.014).toFixed(2) + " for Monthly";
                    document.getElementById("vehicle_price_field_yearly").innerHTML = "Rs. " + (yearlyPriceForCycle*0.014).toFixed(2) + " for Yearly";
                }
                else if(selectedVehicleType == "Motor Cycle")
                {
                    document.getElementById("vehicle_price_field_daily").innerHTML = "Rs. "  + (dailyPriceForMotorCycle*0.014).toFixed(2) + " for Daily";
                    document.getElementById("vehicle_price_field_monthly").innerHTML = "Rs. " + (monthlyPriceForMotorCycle*0.014).toFixed(2) + " for Monthly";
                    document.getElementById("vehicle_price_field_yearly").innerHTML = "Rs. " + (yearlyPriceForMotorCycle*0.014).toFixed(2) + " for Yearly";
                }
                else if(selectedVehicleType == "Four Wheelers")
                {
                    document.getElementById("vehicle_price_field_daily").innerHTML = "Rs. "  + (dailyPriceForFourWheeler*0.014).toFixed(2) + " for Daily";
                    document.getElementById("vehicle_price_field_monthly").innerHTML = "Rs. " + (monthlyPriceForFourWheeler*0.014).toFixed(2) + " for Monthly";
                    document.getElementById("vehicle_price_field_yearly").innerHTML = "Rs. " + (yearlyPriceForFourWheeler*0.014).toFixed(2) + " for Yearly";
                }
            break;
        case "YEN" :
                if(selectedVehicleType == "Cycle")
                {
                    document.getElementById("vehicle_price_field_daily").innerHTML = "Rs. "  + (dailyPriceForCycle*1.47).toFixed(2) + " for Daily";
                    document.getElementById("vehicle_price_field_monthly").innerHTML = "Rs. " + (monthlyPriceForCycle*1.47).toFixed(2) + " for Monthly";
                    document.getElementById("vehicle_price_field_yearly").innerHTML = "Rs. " + (yearlyPriceForCycle*1.47).toFixed(2) + " for Yearly";
                }
                else if(selectedVehicleType == "Motor Cycle")
                {
                    document.getElementById("vehicle_price_field_daily").innerHTML = "Rs. "  + (dailyPriceForMotorCycle*1.47).toFixed(2) + " for Daily";
                    document.getElementById("vehicle_price_field_monthly").innerHTML = "Rs. " + (monthlyPriceForMotorCycle*1.47).toFixed(2) + " for Monthly";
                    document.getElementById("vehicle_price_field_yearly").innerHTML = "Rs. " + (yearlyPriceForMotorCycle*1.47).toFixed(2) + " for Yearly";
                }
                else if(selectedVehicleType == "Four Wheelers")
                {
                    document.getElementById("vehicle_price_field_daily").innerHTML = "Rs. "  + (dailyPriceForFourWheeler*1.47).toFixed(2) + " for Daily";
                    document.getElementById("vehicle_price_field_monthly").innerHTML = "Rs. " + (monthlyPriceForFourWheeler*1.47).toFixed(2) + " for Monthly";
                    document.getElementById("vehicle_price_field_yearly").innerHTML = "Rs. " + (yearlyPriceForFourWheeler*1.47).toFixed(2) + " for Yearly";
                }
            break
    }
}

/**
 * This method calculates the plan price according to the vehicle type selected
 */
function getPlanPrice()
{
    var elementChecked;
    var radioButtons = document.getElementsByName('price_plan');
    for(i = 0; i < radioButtons.length; i++) { 
        if(radioButtons[i].checked) 
        {
            elementChecked = radioButtons[i].value;
            break;
        }
    } 
    switch(elementChecked)
    {
        case "Daily" : 
            if(selectedVehicleType == "Cycle")
            {
                planPrice = 5;
            }
            else if(selectedVehicleType == "Motor Cycle")
            {
                planPrice = 10;
            }
            else if(selectedVehicleType == "Four Wheelers")
            {
                planPrice = 20;
            }
            break;
        case "Monthly" :
            if(selectedVehicleType == "Cycle")
            {
                planPrice = 100;
            }
            else if(selectedVehicleType == "Motor Cycle")
            {
                planPrice = 200;
            }
            else if(selectedVehicleType == "Four Wheelers")
            {
                planPrice = 500;
            }
            break;
        case "Yearly" :
            if(selectedVehicleType == "Cycle")
            {
                planPrice = 500;
            }
            else if(selectedVehicleType == "Motor Cycle")
            {
                planPrice = 1000;
            }
            else if(selectedVehicleType == "Four Wheelers")
            {
                planPrice = 3500;
            }
            break;
    }
    currencyType = document.getElementById("currency_type").value;
    convertedPlanPrice = changeCurrency(currencyType, planPrice);
    document.getElementById("pass_div").innerHTML = "Pass price is " + convertedPlanPrice.toFixed(2) + " " + currencyType;
}

/**
 * This method changes the currency
 * @param {*} currencyType is the currency type selected
 * @param {*} planPrice is the plan price calculated
 */
function changeCurrency(currencyType, planPrice)
{
    if(currencyType == "USD")
    {
        planPrice = planPrice * 0.014;
    }
    else if(currencyType == "YEN")
    {
        planPrice = planPrice * 1.47;
    }
    return planPrice;
}

/**
 * This method generates the pass
 */
function getPass()
{
    var displayPass = document.getElementById("master_div");
    displayPass.innerHTML = "<br /><br /><h2>Your pass for vehicle type " + selectedVehicleType + " is $" + (planPrice * 0.014).toFixed(2) + "</h2>";
}
