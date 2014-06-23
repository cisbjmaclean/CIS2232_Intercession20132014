<%-- 
    Document   : createNewAccount.jsp
    Created on : June 9,2014
    Author     : Ian Mori
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html/css; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Ian Mori">
        <title><bean:message key="create.account.heading"/></title>
    </head>
    <body  background="img/universe2.jpg" class ="backgroundFit">
    <center>
        <logic:messagesPresent message="true">
            <html:messages id="msg2" message="true" property="message1">
                <div class="infoMessageCheck">                    
                    <bean:write name="msg2"/>
                </div><br/>
            </html:messages>

            <html:messages id="msg2" message="true" property="warn">
                <div class="warnExclaim"  style="color: yellow">
                    <bean:write name="msg2"/>
                </div><br/>  
            </html:messages>

            <html:messages id="msg2" message="true" property="error">
                <div class="errorX">                
                    <bean:write name="msg2"/>
                </div><br/>
            </html:messages>				  		
        </logic:messagesPresent>

        <html:form action="/CreateNewAccount" focus="customerUsername" onsubmit="return checkAllFields();">     
            <h1 class="headingColour"><bean:message key="create.account.heading"/></h1>
            <br><br>
            <table class="styleTable">
                <tr>             
                    <td>
                        <label class="alignCenter" for="customerUsername">
                            <bean:message key="label.customer.username"/>
                        </label>
                    </td>
                    <td>
                        <input type="text" property="customerUsername" name="customerUsername" 
                               id="user name" onkeyup="validateFormField(this);"/>
                    </td>
                    <td><span id="user nameError"></span></td>
                </tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="customerPassword">
                            <bean:message key="label.customer.password"/>
                        </label>
                    </td>
                    <td>
                        <input type="password" property="customerPassword" name="customerPassword" 
                               id="password" onkeyup="validateFormField(this);"/>
                    </td>
                    <td><span id="passwordError"></span></td>
                </tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="customerFirstName">
                            <bean:message key="label.customer.first.name"/>
                        </label>
                    </td>
                    <td>
                        <input type="text" property="customerFirstName" name="customerFirstName" 
                               id="first name" onkeyup="validateFormField(this);"/>
                    </td>
                    <td><span id="first nameError"></span></td>
                </tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="customerLastName">
                            <bean:message key="label.customer.last.name"/>
                        </label>
                    </td>
                    <td>
                        <input type="text" property="customerLastName" name="customerLastName" 
                               id="last name" onkeyup="validateFormField(this);"/>
                    </td>
                    <td><span id="last nameError"></span></td>
                </tr>             
                <tr>             
                    <td>
                        <label class="alignCenter" for="customerStreetAddress">
                            <bean:message key="label.customer.street.address"/>
                        </label>
                    </td>
                    <td>
                        <input type="text" property="customerStreetAddress" name="customerStreetAddress" 
                               id="street address" onkeyup="validateFormField(this);"/>
                    </td>
                    <td><span id="street addressError"></span></td>
                </tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="customerCity">
                            <bean:message key="label.customer.city"/>
                        </label>
                    </td>
                    <td>
                        <input type="text" property="customerCity" name="customerCity" 
                               id="city" onkeyup="validateFormField(this);"/>
                    </td>
                    <td><span id="cityError"></span></td>
                </tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="customerProvince">
                            <bean:message key="label.customer.province"/>
                        </label>
                    </td>
                    <td>
                        <select id="province" property="customerProvince" name="customerProvince" onchange="checkProvince()">
                            <option value="">Please select a province</option>
                            <option value="AB">Alberta</option>
                            <option value="BC">British Columbia</option>
                            <option value="MB">Manitoba</option>
                            <option value="NB">New Brunswick</option>
                            <option value="NL">Newfoundland/Labrador</option>
                            <option value="NS">Nova Scotia</option>
                            <option value="ON">Ontario</option>
                            <option value="PE">Prince Edward Island</option>
                            <option value="QC">Quebec</option>
                            <option value="SK">Saskatchewan</option>
                            <option value="NT">Northwest Territories</option>
                            <option value="NU">Nunavut</option>
                            <option value="YT">Yukon</option>
                        </select>
                    </td>
                    <td><span id="provinceError"></span></td>
                </tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="customerPostalCode">
                            <bean:message key="label.customer.postal.code"/>
                        </label>
                    </td>
                    <td>
                        <input type="text" property="customerPostalCode" name="customerPostalCode" 
                               id="postalCode" onkeyup="checkPostalCode();"/>
                    </td>
                    <td><span id="postalCodeError"></span></td>
                </tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="customerEmail">
                            <bean:message key="label.customer.email"/>
                        </label>
                    </td>
                    <td>
                        <input type="text" name="customerEmail" property="customerEmail" id="email" onkeyup="checkEmail();">
                    </td>
                    <td><span id="emailError"></span></td>
                </tr>    
                <tr>             
                    <td>
                        <label class="alignCenter" for="customerTelephone">
                            <bean:message key="label.customer.telephone"/>
                        </label>
                    </td>
                    <td>
                        <input type="text" property="customerTelephone" name="customerTelephone" 
                               id="phone" onkeyup="checkPhone();"/>
                    </td>
                    <td><span id="phoneError"></span></td>
                </tr>
            </table>
        </center>
        <br>
        <span style="margin-left: 67%">
            <html:submit styleClass="buttonStyle2"><bean:message key="label.submit"/></html:submit>&nbsp;
            <html:link style="color:  lawngreen;" styleClass="buttonLook" action="/Welcome" ><bean:message key="label.cancel"/></html:link> 
            </span>
    </html:form>
    <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</html:html>