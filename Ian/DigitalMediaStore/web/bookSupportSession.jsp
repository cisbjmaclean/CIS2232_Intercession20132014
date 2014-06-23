<%-- 
    Document   : createNewOrder
    Created on : 10-Jun-2014, 2:25:38 AM
    Author     : prog
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!doctype html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html/css; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/tcal.css" />
        <script type="text/javascript" src="js/ts_picker.js"></script> 
        <title><bean:message key="book.support.session"/></title>
    </head>
    <body  background="img/universe3.jpg" class ="backgroundFit">
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
                
        <html:form action="/BookSupportSession" focus="firstName" onsubmit="return checkFields();"> 
            <h1 class="headingColour"><bean:message key="book.support.session"/></h1>
            <br><br>
            <table class="styleTable">
                <tr>
                    <td>
                        <label class="alignCenter" for="customerFirstName">
                            <bean:message key="label.customer.first.name"/>
                        </label>
                    </td>
                    <td>
                        <input type="text" id="first name" name="firstName" property="firstName" onkeyup="validateFormField(this)"/>
                        &emsp;<span id="first nameError"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="alignCenter" for="customerEmail">
                            <bean:message key="label.customer.email"/>
                        </label>
                    </td>
                    <td>
                        <input type="text" name="email" property="email" id="email" onkeyup="checkEmail();">
                        &emsp;<span id="emailError"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="alignCenter" for="supportSessionDate">
                            <bean:message key="label.support.session.date"/>
                        </label>
                    </td>
                    <td>
                        <input readonly="" type="text" style="background-color: white" id="date" class="tcal" name="supportSessionDate" property="supportSessionDate"
                               onchange="validateFormField(this)" onmouseover="validateFormField(this)"/>
                        &emsp;<span id="dateError"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="alignCenter" for="supportSessionDescription">
                            <bean:message key="label.support.session.description"/>
                        </label>
                    </td>
                    <td><textarea maxlength="1000" rows="10" cols="50" id="message" name="supportSessionDescription" 
                                  property="supportSessionDescription" onchange="checkMessageLength();" onkeyup="checkMessageLength();"></textarea></td>  
                </tr>
                <tr>
                    <td></td>
                    <td><span id="counterText"></span></td>
                </tr>
            </table>
        </center>
        <br>
        <span style="margin-left: 67%">
            <html:submit styleClass="buttonStyle2"><bean:message key="label.submit"/></html:submit>
            <html:link style="color:  lawngreen;" styleClass="buttonLook" action="/Main" ><bean:message key="label.cancel"/></html:link>  
            </span>
    </html:form>
    <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>