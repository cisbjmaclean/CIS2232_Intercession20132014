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

        <title><bean:message key="customer.home.page.heading"/></title>
    </head>
    <body  background="img/uni.jpg" class ="backgroundFit">
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

        <logic:present name="user">
            <h1 class="headingColour">
                <bean:write name="user" scope="session" property="authenticatedUser"/>'s Home Page
            </h1>
        </logic:present>
    </center>
    <div style="margin-left:1%">
        <html:link forward="createNewOrder">Create New Order</html:link><br>        
        <html:link action="/ViewOrders">View Orders</html:link><br>
        <html:link action="/ViewAccountDetails">View Account Details</html:link><br>
        <html:link forward="bookSupportSession">Book Support Session</html:link><br>
        <html:link action="/ViewSupportSessions">View Support Sessions</html:link><br>
        <html:link action="/Logout">Logout</html:link><br>
    </div>
        <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
    </body>
</html:html>
