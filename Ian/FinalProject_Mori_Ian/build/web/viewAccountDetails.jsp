<%-- 
    Document   : viewAll.jsp
    Created on : May 28,2014
    Author     : Ian Mori
--%>
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
        <title><bean:message key="view.account.details.heading"/></title>
    </head>
    <body  background="img/universe5.jpg" class ="backgroundFit">
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

        <html:form action="/Main">
            <h1 class="headingColour"><bean:message key="view.account.details.heading"/></h1>
            <br><br>
            <table class="styleTable" style="text-align: center">
                <logic:iterate name="AllAccountDetails" id="TheAccountDetails" scope ="session">
                    <tr>
                        <td>
                            <bean:message key="label.customer.first.name"/>
                        </td>
                        <td>
                            <bean:write name="TheAccountDetails" property="customerFirstName"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <bean:message key="label.customer.last.name"/>
                        </td>
                        <td>
                            <bean:write name="TheAccountDetails" property="customerLastName"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <bean:message key="label.customer.email"/>
                        </td>
                        <td>
                            <bean:write name="TheAccountDetails" property="customerEmail"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <bean:message key="label.customer.street.address"/>
                        </td>
                        <td>
                            <bean:write name="TheAccountDetails" property="customerStreetAddress"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <bean:message key="label.customer.city"/>
                        </td>
                        <td>
                            <bean:write name="TheAccountDetails" property="customerCity"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <bean:message key="label.customer.province"/>
                        </td>
                        <td>
                            <bean:write name="TheAccountDetails" property="customerProvince"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <bean:message key="label.customer.postal.code"/>
                        </td>
                        <td>
                            <bean:write name="TheAccountDetails" property="customerPostalCode"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <bean:message key="label.customer.telephone"/>
                        </td>
                        <td>
                            <bean:write name="TheAccountDetails" property="customerTelephone"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <bean:message key="label.customer.balance"/>
                        </td>                       
                        <td>
                            $<bean:write name="TheAccountDetails" property="customerBalance"/> 
                        </td>
                    </tr>
                </logic:iterate>
            </table>
        </center>
        <br>
        <span style="margin-left: 63%">
            <html:link style="color:  lawngreen;" styleClass="buttonLook" forward="modifyAccountPassword">Modify Password</html:link>  
            <html:submit styleClass="buttonStyle2"><bean:message key="label.return"/></html:submit>
            </span>
    </html:form>
    <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html:html>
