<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body>

    <center>
        <logic:messagesPresent message="true">
            <html:messages id="msg2" message="true" property="message1"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>				  		
            <html:messages id="msg2" message="true" property="warn"><div class="warnExclaim"  style="color: yellow"><bean:write name="msg2"/></div><br/></html:messages>
            <html:messages id="msg2" message="true" property="error"><div class="errorX"  style="color: red"><bean:write name="msg2"/></div><br/></html:messages>				  		
        </logic:messagesPresent>
        <%-- the html:errors is populated if the validator is used!.     --%>    
        <div style="color:red">
            <html:errors />
        </div>
    </center>


    <html:form action="/Menu">
        <center>      
            <table>
                
                <tr>
                    <td>            
                        <h3><bean:message key="label.cis2232.2014.intercession.label"/></h3><br/>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <hr/>
                        <h3><bean:message key="label.cis2232.resources"/></h3>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <a target="_blank" href="http://bjmac.hccis.info:8080/styles/styles.css">Link to stylesheet</a>
                    </td>
                </tr>

                                <tr>
                    <td>            &nbsp;
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <hr/>
                        <h3>Class Examples</h3>
                    </td>
                </tr>

                <tr>
                    <td>            
                        <a target="_blank" href="http://bjmac.hccis.info:8080/CourtBooking/">Court Booking (Fall 2013/2014)</a>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <a target="_blank"  href="http://bjmac.hccis.info:8080/RegistrationBoard">Registration Board (Intercession 2013/2014)</a>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <a target="_blank" href="http://bjmac.hccis.info:8080/StudentWeb/">Student Web (Intercession 2013/2014)</a><br/>
                    </td>
                </tr>

                <tr>
                    <td>            &nbsp;
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <hr/>
                        <h3><bean:message key="label.cis2232.student.examples"/></h3>
                    </td>
                </tr>

                <tr>
                    <td>            
                        <a target="_blank" href="http://bjmac.hccis.info:8080/DigitalMediaStore/">Digital Media Sales (1/test) (Ian Mori)</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a target="_blank" href="http://bjmac.hccis.info:8080/LifeguardAppliccation6/">Pool Bookings (andrew/pw) (Andrew Reid)</a>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <a  target="_blank"  href="http://bjmac.hccis.info:8080/Soccer">Soccer Field/Bag Bookings (Ryan/1234) (Ryan Forrester)</a>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <a  target="_blank"  href="http://bjmac.hccis.info:8080/StorageUnits">Storage Unit Bookings (BJ/password) (Mike Fesser)</a>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <a target="_blank"  href="http://bjmac.hccis.info:8080/RegistrationBoard">Professional Development Component of Registration Board (Roger Myers)</a>
                    </td>
                </tr>

            </table>


        </center>
    </html:form>
</body>
</html:html>
