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
        <title><bean:message key="modify.account.heading"/></title>
    </head>
    <body  background="img/universe8.jpg" class ="backgroundFit">
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
    </center>
    
    <html:form action="/ModifyAccountPassword" focus="newCustomerPassword"  onsubmit="return verifyPasswordChange()">
        <h1 class="headingColour"><bean:message key="modify.account.heading"/></h1>
        <br><br>
        <table>
            <tr>             
                <td>
                    <label class="alignCenter" for="newCustomerPassword">
                        New <bean:message key="label.customer.password"/>
                    </label>
                </td>
                <td>
                    <input type="password" id="password" name="newCustomerPassword" property="newCustomerPassword"
                           onkeyup="validateFormField(this);verifyPasswordChange();"/>
                </td>
                <td><span id="passwordError"></span></td>
            </tr>
            <tr>             
                <td>
                    <label class="alignCenter" for="confirmNewCustomerPassword">
                        Re-enter <bean:message key="label.customer.password"/>
                    </label>
                </td>
                <td>
                    <input type="password" id="new password" name="confirmNewCustomerPassword" property="confirmNewCustomerPassword"
                           onkeyup="validateFormField(this);verifyPasswordChange();"/>
                </td>
                <td><span id="new passwordError"></span></td>
            </tr>
            <tr>
                <td></td>
                <td><span id="passwordMatchError"></span></td></tr>
        </table>

        <span style="margin-left: 17%">
            <html:submit styleClass="buttonStyle2"><bean:message key="label.submit"/></html:submit>
            <html:link style="color:  lawngreen;" styleClass="buttonLook" action="/Main" ><bean:message key="label.cancel"/></html:link>  
            </span>
    </html:form>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src = "js/bootstrap.js" ></script>
</body>
</html:html>
