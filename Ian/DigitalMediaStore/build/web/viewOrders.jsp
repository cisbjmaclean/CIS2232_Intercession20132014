<%-- 
    Document   : viewOrders.jsp
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
        <title><bean:message key="view.all.orders.heading"/></title>
    </head>
    <body  background="img/universe9.jpg" class ="backgroundFit">
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
            <h1 class="headingColour"><bean:message key="view.all.orders.heading"/></h1>
            <br><br>
            <table class="styleTable" style="text-align: center">
                <tr>
                    <td>Order ID</td>
                    <td>Order Date</td>
                </tr>
                <logic:iterate name="AllOrders" id="TheOrder" scope ="session">
                    <tr>
                        <td>
                            <html:link page="/ViewOrderDetails.do" style="color:lawngreen;text-decoration:underline" 
                                       paramId="order_id" paramName="TheOrder" paramProperty="orderId">
                                <bean:write name="TheOrder" property="orderId"/> 
                            </html:link>
                        </td>
                        <td>
                            <bean:write name="TheOrder" property="orderDate"/> 
                        </td>
                    </tr>
                </logic:iterate>
            </table>
        </center>
        <br>
        <span style="margin-left:72%">
            <html:submit styleClass="buttonStyle2"><bean:message key="label.return"/></html:submit>
            </span>
    </html:form>
    <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html:html>
