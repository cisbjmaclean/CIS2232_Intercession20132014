/*  Author: Ian Mori
 Date: Dec 6, 2013
 Purpose: Designing a website with bootstrap, external JavaScript sheet.
 Last Revision: Dec 17, 2013
 Dependencies: This file requires no other files.
 */
//Function that calculates the full date and time.
function showCurrentTime() {
//Declare initial variables.	
    var today = new Date();
    var hours = today.getHours();
    var minutes = today.getMinutes();
    var seconds = today.getSeconds();
    //Array for each day of the week.
    var day = new Array();
    day[0] = "Sunday";
    day[1] = "Monday";
    day[2] = "Tuesday";
    day[3] = "Wednesday";
    day[4] = "Thursday";
    day[5] = "Friday";
    day[6] = "Saturday";
    //Array for each month of the year.
    var month = new Array();
    month[0] = "January";
    month[1] = "February";
    month[2] = "March";
    month[3] = "April";
    month[4] = "May";
    month[5] = "June";
    month[6] = "July";
    month[7] = "August";
    month[8] = "September";
    month[9] = "October";
    month[10] = "November";
    month[11] = "December";
    var date = today.getDate();
    var year = today.getFullYear();
    minutes = checkVariables(minutes);
    seconds = checkVariables(seconds);
    var midday;
    if (hours > 12) {
        hours -= 12;
        midday = "P.M.";
    } else if (hours <= 12) {
        midday = "A.M.";
        if (hours === 0) {
            hours = 12;
        }
    }
    document.getElementById('displayTime').style.fontWeight = "bold";
    //Display time in proper format and keep rechecking every half second.
    document.getElementById('displayTime').innerHTML = " Time: " + hours + ":" + minutes + ":" + seconds + " "
            + midday + " Date: " + day[today.getDay()] + ", " + month[today.getMonth()] + " " + date + ", " + year;
    today = setTimeout(function() {
        showCurrentTime();
    }, 500);
}

//Function that checks the time and appends a 0 if needed.
function checkVariables(x) {
    if (x < 10) {
        x = "0" + x;
    }
    return x;
}

function validateFormField(elem) {
    var id = elem.id;
    var val = document.getElementById(id).value;
    var error = id + "Error";
    if (val.length < 1 || val == null) {
        document.getElementById(error).innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>Error! Please enter a valid " + id + "!</span>";
        return false;
    } else {
        document.getElementById(error).innerHTML = "";
        return true;
    }
}

//This function checks the email passed and makes sure it is valid.
function checkEmailInput(emailVal) {
//Creating em variable and setting equal to regex statement, this works for over 99% of all emails.
    var em = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    //This checks the regex against the passed emailVal, and returns true or false.
    return em.test(emailVal);
}

//This function checks the value of the email entered by sending it to the function above.
function checkEmail() {
//Creating local emailVal variable and setting equal to the value from the form.
    var emailVal = document.getElementById("email").value;
    //If the email is valid, remove any error text and return true.
    if (checkEmailInput(emailVal)) {
        document.getElementById("emailError").innerHTML = "";
        return true;
        //If the email is not valid, display its own error message and return false.
    } else {
        document.getElementById("emailError").innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>Error! Please enter a valid email address!</span>";
        return false;
    }
}

function checkProvince() {
    var id = document.getElementById("province");
    var val = id.options[id.selectedIndex].value;
    if (val == null || val.length < 1) {
        document.getElementById("provinceError").innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>Error! Please select a valid province!</span>";
        return false;
    } else {
        document.getElementById("provinceError").innerHTML = "";
        return true;
    }
}

function checkPostalCode() {
    var val = document.getElementById("postalCode").value;
    var postalCodeExpression =
            /^[ABCEGHJKLMNPRSTVXY][0-9][ABCEGHJKLMNPRSTVWXYZ][0-9][ABCEGHJKLMNPRSTVWXYZ][0-9]$/i;
    var match = postalCodeExpression.test(val);
    if (match) {
        document.getElementById("postalCodeError").innerHTML = "";
        return true;
    } else {
        document.getElementById("postalCodeError").innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>Error! Please enter a valid postal code!</span>";
        return false;
    }
}

function checkPhoneInput(phoneVal) {
//Creating pe variable and setting equal to regex statement, this gives a couple options for entering 10 digit phone numbers.
    var phoneExpression = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
    //This checks the regex against the passed phoneVal, and returns true or false.
    return phoneExpression.test(phoneVal);
}

//This function checks the value of the phone number entered by sending it to the function above.
function checkPhone() {
//Creating local phoneVal variable and setting equal to the value from the form.
    var phoneVal = document.getElementById("phone").value;
    //If the phone number is valid, remove any error text and return true.
    if (checkPhoneInput(phoneVal)) {
        document.getElementById("phoneError").innerHTML = "";
        return true;
    } else {
//If the phone number is not valid, display its own error message and return false.
        document.getElementById("phoneError").innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>Error! Please enter a valid 10 digit phone number!</span>";
        return false;
    }
}

function checkAllFields() {
    var fieldArray = new Array();
    var results = new Array();
    var areAllFieldsFilledOut = true;
    fieldArray[0] = "user name";
    fieldArray[1] = "password";
    fieldArray[2] = "first name";
    fieldArray[3] = "last name";
    fieldArray[4] = "street address";
    fieldArray[5] = "city";
    for (var i = 0; i < fieldArray.length; ++i) {
        results[i] = validateFieldsOnSubmit(fieldArray[i]);
        if (results[i] == false) {
            areAllFieldsFilledOut = false;
        }
    }

    if (checkProvince() == false | checkPostalCode() == false | checkEmail() == false | checkPhone() == false) {
        areAllFieldsFilledOut = false;
    }
    return areAllFieldsFilledOut;
}

function validateFieldsOnSubmit(id) {
    var val = document.getElementById(id).value;
    var error = id + "Error";
    if (val.length < 1 || val == null) {
        document.getElementById(error).innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>Error! Please enter a valid " + id + "!</span>";
        return false;
    } else {
        document.getElementById(error).innerHTML = "";
        return true;
    }
}


function verifyQuantities() {
    var quantityArray = new Array();
    var results = new Array();
    var areAllFieldsCorrectFormat = true;
    var totalProducts = 0;
    quantityArray[0] = "orderLine1Quantity";
    quantityArray[1] = "orderLine2Quantity";
    quantityArray[2] = "orderLine3Quantity";
    quantityArray[3] = "orderLine4Quantity";
    quantityArray[4] = "orderLine5Quantity";
    for (var i = 0; i < quantityArray.length; ++i) {
        totalProducts += getValue(quantityArray[i]);
    }
    if (totalProducts < 1) {
        areAllFieldsCorrectFormat = false;
        document.getElementById("orderQuantityError").innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>At least one item must be ordered!</span>";
    } else if (isNaN(totalProducts)) {
        areAllFieldsCorrectFormat = false;
        document.getElementById("orderQuantityError").innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>Only numbers are allowed!</span>";
    } else {
        document.getElementById("orderQuantityError").innerHTML = "";
    }
    return areAllFieldsCorrectFormat;
}

function getValue(id) {
    var val = document.getElementById(id).value;
    return val;
}

function verifyAllProductQuantities() {
    var quantityArray = new Array();
    var results = new Array();
    var areAllFieldsCorrectFormat = true;
    quantityArray[0] = "orderLine1Quantity";
    quantityArray[1] = "orderLine2Quantity";
    quantityArray[2] = "orderLine3Quantity";
    quantityArray[3] = "orderLine4Quantity";
    quantityArray[4] = "orderLine5Quantity";
    for (var i = 0; i < quantityArray.length; ++i) {
        results[i] = validateQuantityOnSubmit(quantityArray[i]);
        if (results[i] == false) {
            areAllFieldsCorrectFormat = false;
        }
    }
    return areAllFieldsCorrectFormat;
}


function validateQuantityOnSubmit(id) {
    var val = document.getElementById(id).value;
    var error = id + "Error";
    if (val < 0 | isNaN(val) | val % 1 != 0 | val == null) {
        document.getElementById(error).innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>Please enter positive whole numbers only!</span>";
        return false;
    } else {
        document.getElementById(error).innerHTML = "";
        return true;
    }
}

function getValue(id) {
    var val = document.getElementById(id).value;
    return val;
}


function validateLoginForm() {
    var areFieldsCorrectlyFilledOut = false;

    if (validateFieldsOnSubmit("user name") & validateFieldsOnSubmit("password")) {
        areFieldsCorrectlyFilledOut = true;
    }
    return areFieldsCorrectlyFilledOut;
}


function verifyProductQuantity(elem) {
    var id = elem.id;
    var val = document.getElementById(id).value;
    var error = id + "Error";
    //Returning false will not allow the submit to be used.
    if (val < 0 || isNaN(val) || val % 1 != 0) {
        document.getElementById(error).innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>Please enter positive whole numbers only!</span>";
        return false;
    } else {
        document.getElementById(error).innerHTML = "";
        return true;
    }
}

function checkFields() {
    var areFieldsCorrect = false;
    if (checkEmail() & validateFieldsOnSubmit("date") & validateFieldsOnSubmit("first name")) {
        areFieldsCorrect = true;
    }
    return areFieldsCorrect;
}


function verifyPasswordChange() {
    var doPasswordEntriesMatch = true;
    var passwordVal = document.getElementById("password").value;
    var passwordConfirmVal = document.getElementById("new password").value;

    if (passwordVal.length < 1 || passwordConfirmVal < 1) {
        doPasswordEntriesMatch = false;
        document.getElementById("passwordMatchError").innerHTML = "<span style='background-color: \n\
                     yellow; padding:4px;color:red;font-size:12px;border-radius:5px;'>Error! Both fields must be filled out!</span>";
        return false;
    } else if (passwordVal != passwordConfirmVal) {
        doPasswordEntriesMatch = false;
        document.getElementById("passwordMatchError").innerHTML = "<span style='background-color: \n\
                     yellow; padding:4px;color:red;font-size:12px;border-radius:5px;'>Error! Passwords do not match!</span>";
    } else {
        document.getElementById("passwordMatchError").innerHTML = "";
    }
    return doPasswordEntriesMatch;
}


function checkMessageLength() {
    var msgLength = document.getElementById("message").value.length;
    var msgVal = document.getElementById("message").value;

    if (msgLength == 1000) {
        document.getElementById('counterText').innerHTML =
                "<span style='background-color: yellow; padding:4px;color:red; \n\
                            font-size:12px;border-radius:5px;'>Message must be no more than 1000 characters.</span>&nbsp&nbsp" + msgLength;
    } else {
        //If the message is 499 characters or less, display the total message count.
        document.getElementById('counterText').innerHTML = msgLength;
    }
}

//CHANGE THIS SO USER HAS TO ENTER AT LEAST ONE CAPITAL, NUMBER, ONE SPECIAL CHARACTER, AND LENGTH OF AT LEAST 8



//Automates the main, larger carousels.
$(document).ready(function() {
    $('.carousel').carousel({interval: 5000});
});
//Shows current time on load, used with body elements.
window.onload = showCurrentTime();