<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html/css; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Ian Mori">
        <html:base/>
        <title><bean:message key="login.heading"/></title>
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

        <html:form action="/Login" focus="customerUsernameToValidate" onsubmit="return validateLoginForm()">
            <h1 class="headingColour"><bean:message key="login.heading"/></h1>
            <br><br>
            <table class="styleTable">
                <tr>
                    <td></td>
                </tr>
                <tr>             
                    <td>Enter your username:&emsp;
                        <input type="text" property="customerUsernameToValidate" name="customerUsernameToValidate"
                               id="user name" onkeyup="validateFormField(this);" /></td>
                    <td><span id="user nameError"></span></td>
                </tr>
                <tr>
                    <td>Enter your password:&emsp;
                        <input type="password" property="customerPasswordToValidate" name="customerPasswordToValidate" 
                               id="password" onkeyup="validateFormField(this);"/></td>
                    <td><span id="passwordError"></span></td>
                </tr>
                <tr><td></td></tr>
            </table>
        </center>
        <br>
        <span style="margin-left: 67%">
            <html:submit styleClass="buttonStyle2" property="submit" value="Submit"/>&nbsp;
            <html:link style="color:  lawngreen;" styleClass="buttonLook" action="/Welcome" ><bean:message key="label.cancel"/></html:link>  
            </span>
    </html:form>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html:html>
