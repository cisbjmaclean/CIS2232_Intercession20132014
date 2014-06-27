/* Author: Michael Fesser
 Date: 6/16/2014
 Purpose: This is the main JavaScript page.  It will hold all the custom JS.
 Last Revision: 6/6/2014
 Dependencies: adminMain.jsp
 */

/*
 * These functions make sure the admin cannot select more then one seach field.
 */
function adminOptionCustomerEmail() {
    var customerEmail = document.getElementById('customerEmail').value;
    var customerUsername = document.getElementById('customerUsername').value;
    var customerLastName = document.getElementById('customerLastName').value;
    /*
     * This clears the other two options.
     */

    if (customerEmail.length > 0 && customerLastName.length > 0) {
        document.getElementById('customerLastName').value = "";
    } else if (customerEmail.length > 0 && customerUsername.length > 0) {
        document.getElementById('customerUsername').value = "";
    }
}

function adminOptionCustomerUsername() {
    var customerEmail = document.getElementById('customerEmail').value;
    var customerUsername = document.getElementById('customerUsername').value;
    var customerLastName = document.getElementById('customerLastName').value;

    /*
     * This clears the other two options.
     */
    if (customerUsername.length > 0 && customerEmail.length > 0) {
        document.getElementById('customerEmail').value = "";
    } else if (customerUsername.length > 0 && customerLastName.length > 0) {
        document.getElementById('customerLastName').value = "";
    }

}

function adminOptionCustomerLastName() {
    var customerEmail = document.getElementById('customerEmail').value;
    var customerUsername = document.getElementById('customerUsername').value;
    var customerLastName = document.getElementById('customerLastName').value;

    /*
     * This clears the other two options.
     */
    if (customerLastName.length > 0 && customerEmail.length > 0) {
        document.getElementById('customerEmail').value = "";
    } else if (customerLastName.length > 0 && customerUsername.length > 0) {
        document.getElementById('customerUsername').value = "";
    }
}

function adminOptionUnitId() {   
    var unitID = document.getElementById('unitID').value;
    var unitCustomerId = document.getElementById('unitCustomerId').value;
    var unitCustomerLastName = document.getElementById('unitCustomerLastName').value;
    /*
     * This clears the other two options.
     */

    if (unitID > 0 && unitCustomerId > 0) {
        document.getElementById('unitCustomerId').value = "";
    } else if (unitID > 0 && unitCustomerLastName.length > 0) {
        document.getElementById('unitCustomerLastName').value = "";
    }
}

function adminOptionUnitCustomerId() {
    var unitID = document.getElementById('unitID').value;
    var unitCustomerId = document.getElementById('unitCustomerId').value;
    var unitCustomerLastName = document.getElementById('unitCustomerLastName').value;

    /*
     * This clears the other two options.
     */
    if (unitCustomerId  > 0 && unitCustomerLastName.length > 0) {
        document.getElementById('unitCustomerLastName').value = "";
    } else if (unitCustomerId  > 0 && unitID  > 0) {
        document.getElementById('unitID').value = "";
    }

}

function adminOptionUnitCustomerLastName() {  
    var unitID = document.getElementById('unitID').value;  
    var unitCustomerId = document.getElementById('unitCustomerId').value;
    var unitCustomerLastName = document.getElementById('unitCustomerLastName').value;

    /*
     * This clears the other two options.
     */
    if (unitCustomerLastName.length > 0 && unitID > 0) {
        document.getElementById('unitID').value = "";
    } else if (unitCustomerLastName.length > 0 && unitCustomerId > 0) {
        document.getElementById('unitCustomerId').value = "";
    }
}

