/* Author: Michael Fesser
 Date: 6/16/2014
 Purpose: This is the main JavaScript page.  It will hold all the custom JS.
 Last Revision: 6/6/2014
 Dependencies: adminMain.jsp
 */

/*
 * This function makes sure the admin cannot select more then one seach field.
 */
function adminOptionUnitId() {  
    var unitId = document.getElementById('unitId').value;
    var customerUsername = document.getElementById('customerUsername').value;
    var customerLastName = document.getElementById('customerLastName').value;
    /*
     * This clears the other two options.
     */
  
    if (unitId.length > 0 && customerLastName.length > 0) {
        document.getElementById('customerLastName').value = "";
    } else if (unitId.length > 0 && customerUsername.length > 0) {
        document.getElementById('customerUsername').value = "";
    }
}

function adminOptionCustomerUsername() {
    var unitId = document.getElementById('unitId').value;
    var customerUsername = document.getElementById('customerUsername').value;
    var customerLastName = document.getElementById('customerLastName').value;

    /*
     * This clears the other two options.
     */
    if (customerUsername.length > 0 && unitId.length > 0) {
        document.getElementById('unitId').value = "";
    } else if (customerUsername.length > 0 && customerLastName.length > 0) {
        document.getElementById('customerLastName').value = "";
    }

}

function adminOptionCustomerLastName() {
    var unitId = document.getElementById('unitId').value;
    var customerUsername = document.getElementById('customerUsername').value;
    var customerLastName = document.getElementById('customerLastName').value;

    /*
     * This clears the other two options.
     */
    if (customerLastName.length > 0 && unitId.length > 0) {
        document.getElementById('unitId').value = "";
    } else if (customerLastName.length > 0 && customerUsername.length > 0) {
        document.getElementById('customerUsername').value = "";
    }
} 

function setIdZero(){
    document.getElementById('unitId').value = 0;
    document.getElementById('customerUsername').value = "";
      document.getElementById('customerLastName').value = "";
}