<%-- 
    Document   : finalizeOrder.jsp
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
        <title><bean:message key="finalize.order.heading"/></title>
    </head>
    <body  background="img/universe7.jpg" class ="backgroundFit">
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

        <html:form action="/FinalizeOrder">
            <h1 class="headingColour"><bean:message key="finalize.order.heading"/></h1>
            <br><br>
            <table class="styleTable" style="text-align: center">
                <tr>
                    <td >Product Quantity</td>
                    <td >Product Name</td>
                    <td >Sale Price</td>
                </tr>
                <logic:iterate name="AllItems" id="TheItem" scope ="session">
                    <tr>
                        <td>
                            <bean:write name="TheItem" property="productQuantity"/> 
                        </td>
                        <td>
                            <bean:write name="TheItem" property="productName"/> 
                        </td>
                        <td>
                            $<bean:write name="TheItem" property="salePriceAsString"/> 
                        </td>
                    </tr>
                </logic:iterate>
                <tr>
                    <td></td>
                    <td>Total</td>
                    <td>$<bean:write name="OrderTotal" scope="session"/></td>
                </tr>
            </table>
        </center>
        <br>
        <span style="margin-left: 64%">
            <html:submit styleClass="buttonStyle2"><bean:message key="label.finalize"/></html:submit>
            <html:link style="color:  lawngreen;" styleClass="buttonLook" action="/Main" ><bean:message key="label.cancel"/></html:link>  
            </span>
    </html:form>
    <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html:html>