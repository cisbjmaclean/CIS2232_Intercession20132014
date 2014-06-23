<%-- 
    Document   : addInstrument.jsp
    Created on : May 24,2014
    Author     : Ian Mori
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html/css; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Ian Mori">
        <title><bean:message key="create.order.heading"/></title>
    </head>
    <body background="img/universe6.jpg" class ="backgroundFit">
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

        <html:form action="/CreateNewOrder" focus="orderLine1Quantity" onsubmit="return verifyQuantities()">
            <h1 class="headingColour"><bean:message key="create.order.heading"/></h1>
            <br>
            <h2 class="headingColour">Enter quantities in the boxes below.</h2>
            <br><br>
            <table class="styleTable">
                <tr><td> <img src="img/win7Small.jpg"></td></tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="product1">
                            <bean:message key="label.product.1"/>
                        </label>
                    </td>
                    <td>
                        <input id="orderLine1Quantity" name="orderLine1Quantity" 
                               property="orderLine1Quantity" onkeyup="verifyProductQuantity(this);
                                       verifyQuantities();"/>
                        <div>$109.99</div>
                        <input hidden type='text' name='orderLine1ProductName' property='orderLine1ProductName' 
                               value="Microsoft Windows 7 Ultimate"/>
                        <input hidden type='text' name='orderLine1SalePrice' property='orderLine1SalePrice' value='109.99'/>
                        <input hidden type='text' name='orderLine1Id' property='orderLine1Id' value='100'/>
                    </td>
                    <td>
                        <span id="orderLine1QuantityError"></span>
                    </td>
                </tr>
                <tr><td> <img src="img/kasperskySmall.jpg"></td></tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="product2">
                            <bean:message key="label.product.2"/>
                        </label>
                    </td>
                    <td>
                        <input id="orderLine2Quantity" name="orderLine2Quantity" property="orderLine2Quantity" onkeyup="verifyProductQuantity(this);
                                verifyQuantities()"/>
                        <div>$89.99</div>           
                        <input hidden type='text' name='orderLine2ProductName' property='orderLine2ProductName' 
                               value="Kaspersky Pure 3.0"/>
                        <input hidden type='text' name='orderLine2SalePrice' property='orderLine2SalePrice' value='89.99'/>
                        <input hidden type='text' name='orderLine2Id' property='orderLine2Id' value='200'/>
                    </td>
                    <td>
                        <span id="orderLine2QuantityError"></span>
                    </td>
                </tr>
                <tr><td> <img src="img/itunesGiftcardSmall.jpg"></td></tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="product3">
                            <bean:message key="label.product.3"/>
                        </label>
                    </td>
                    <td>
                        <input id="orderLine3Quantity" name="orderLine3Quantity" property="orderLine3Quantity" onkeyup="verifyProductQuantity(this);
                                verifyQuantities()"/>
                        <div>$25.00</div>           
                        <input hidden type='text' name='orderLine3ProductName' property='orderLine3ProductName' 
                               value="$25 iTunes Gift Card"/>
                        <input hidden type='text' name='orderLine3SalePrice' property='orderLine3SalePrice' value='25.00'/>
                        <input hidden type='text' name='orderLine3Id' property='orderLine3Id' value='300'/>
                    </td>
                    <td>
                        <span id="orderLine3QuantityError"></span>
                    </td>
                </tr>
                <tr><td> <img src="img/borderlands2Small.jpg"></td></tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="product4">
                            <bean:message key="label.product.4"/>
                        </label>
                    </td>
                    <td>
                        <input id="orderLine4Quantity" name="orderLine4Quantity" property="orderLine4Quantity" onkeyup="verifyProductQuantity(this);
                                verifyQuantities()"/>
                        <div>$29.99</div>          
                        <input hidden type='text' name='orderLine4ProductName' property='orderLine4ProductName' 
                               value="Borderlands 2"/>
                        <input hidden type='text' name='orderLine4SalePrice' property='orderLine4SalePrice' value='29.99'/>
                        <input hidden type='text' name='orderLine4Id' property='orderLine4Id' value='400'/>
                    </td>
                    <td>
                        <span id="orderLine4QuantityError"></span>
                    </td>
                </tr>
                <tr><td> <img src="img/gameOfThronesSmall.jpg"></td></tr>
                <tr>             
                    <td>
                        <label class="alignCenter" for="product5">
                            <bean:message key="label.product.5"/>
                        </label>
                    </td>
                    <td>
                        <input id="orderLine5Quantity" name="orderLine5Quantity" property="orderLine5Quantity" onkeyup="verifyProductQuantity(this);
                                verifyQuantities()"/>
                        <div>$49.99</div>     
                        <input hidden type='text' name='orderLine5ProductName' property='orderLine5ProductName' 
                               value="A Game of Thrones Digital Bundle"/>
                        <input hidden type='text' name='orderLine5SalePrice' property='orderLine5SalePrice' value='49.99'/>
                        <input hidden type='text' name='orderLine5Id' property='orderLine5Id' value='999'/>
                    </td>
                    <td colspan="2">
                        <span id="orderLine5QuantityError"></span>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><span id="orderQuantityError"></span></td>
                </tr>
                <tr>
                </tr>
            </table>
        </center>
        <br>
        <div  style="color:white; background-color: blue; width:25%; margin-left: 37%;
              border-radius:5px;text-align: center">Your order will be finalized on the next page.
        </div>
        <span style="margin-left: 67%">
            <html:submit styleClass="buttonStyle2"><bean:message key="label.submit"/></html:submit>
            <html:link style="color:  lawngreen;" styleClass="buttonLook" action="/Main" ><bean:message key="label.cancel"/></html:link>  
            </span>    
    </html:form>
    <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>    
</html:html>