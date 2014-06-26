<%-- 
    Document   : viewSupportSessionDetails.jsp
    Created on : June 9,2014
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
        <title><bean:message key="view.support.session.details.heading"/></title>
    </head>
    <body  background="img/universe11.jpg" class ="backgroundFit">
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

        <html:form action="/MainSupportSessionView">
            <h1 class="headingColour"><bean:message key="view.support.session.details.heading"/></h1>
            <br><br>
            <table class="styleTable" style="text-align: center">
                <tr>
                    <td>First Name</td>
                    <td>Email</td>
                    <td>Date</td>
                    <td>Description</td>
                </tr>
                <logic:iterate name="AllSupportSessionDetails" id="TheSupportSessionDetails" scope ="session">
                    <tr>
                        <td>
                            <bean:write name="TheSupportSessionDetails" property="firstName"/> 
                        </td>
                        <td>
                            <bean:write name="TheSupportSessionDetails" property="email"/> 
                        </td>
                        <td>
                            <bean:write name="TheSupportSessionDetails" property="supportSessionDate"/> 
                        </td>
                        <td>
                            <bean:write name="TheSupportSessionDetails" property="supportSessionDescription"/> 
                        </td>
                    </tr>
                </logic:iterate>
            </table>
            <br>
        </center>
        <span style="margin-left:72%">
            <html:submit styleClass="buttonStyle2"><bean:message key="label.return"/></html:submit>
            </span>
    </html:form>
    <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html:html>
