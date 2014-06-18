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
        <title><bean:message key="view.all.support.sessions.heading"/></title>
    </head>
    <body  background="img/universe4.jpg" class ="backgroundFit">
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
           <h1 class="headingColour"><bean:message key="view.all.support.sessions.heading"/></h1>
            <br><br>
            <table class="styleTable" style="text-align: center">
                <tr>
                    <td>Support Session ID</td>
                    <td>Support Session Date</td>
                </tr>
                <logic:iterate name="AllSupportSessions" id="TheSupportSession" scope ="session">
                    <tr>
                        <td>
                            <html:link page="/ViewSupportSessionDetails.do" style="color:lawngreen;text-decoration:underline"
                                       paramId="supportSession_Id" paramName="TheSupportSession" paramProperty="supportSessionId">
                                <bean:write name="TheSupportSession" property="supportSessionId"/> 
                            </html:link>
                        </td>
                        <td>
                            <bean:write name="TheSupportSession" property="supportSessionDate"/> 
                        </td>
                    </tr>
                </logic:iterate>
            </table>
        </center>
        <br>
        <span style="margin-left: 72%">
            <html:submit styleClass="buttonStyle2"><bean:message key="label.return"/></html:submit>
            </span>
    </html:form>

    <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html:html>
