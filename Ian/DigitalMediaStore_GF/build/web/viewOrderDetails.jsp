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

        <title><bean:message key="view.order.details.heading"/></title>
    </head>
    <body  background="img/universe10.jpg" class ="backgroundFit">
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

        <html:form action="/MainOrderView">
            <h1 class="headingColour"><bean:message key="view.order.details.heading"/></h1>
            <br><br>
            <table class="styleTable" style="text-align: center">
                <tr>
                    <td>Product ID</td>
                    <td>Quantity Ordered</td>
                    <td>Sale Price</td>
                </tr>
                <logic:iterate name="AllOrderLines" id="TheOrderLine" scope ="session">
                    <tr>
                        <td>
                            <bean:write name="TheOrderLine" property="productName"/> 
                        </td>
                        <td>
                            <bean:write name="TheOrderLine" property="quantity_ordered"/> 
                        </td>
                        <td>
                            $<bean:write name="TheOrderLine" property="salePriceAsString"/> 
                        </td>
                    </tr>
                </logic:iterate>
                <tr>
                    <td></td>
                    <td>Total</td>
                    <td>$<bean:write name="OrderTotalView" scope="session"/></td>
                </tr>
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
