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
                        <a target="_blank"   href="http://bjmac.hccis.info:8080/RegistrationBoard">Andrew's Pool Bookings</a>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <a target="_blank" href="http://bjmac.hccis.info:8080/DigitalMediaStore/">Ian's Digital Media Sales</a>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <a  target="_blank"  href="http://bjmac.hccis.info:8080/RegistrationBoard">Mike's Storage Unit Bookings</a>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <a target="_blank"  href="http://bjmac.hccis.info:8080/RegistrationBoard">Roger's Professional Development</a>
                    </td>
                </tr>
                <tr>
                    <td>            
                        <a  target="_blank"  href="http://bjmac.hccis.info:8080/Soccer">Ryan's Soccer Field/Bag Bookings</a>
                    </td>
                </tr>

            </table>


        </center>
    </html:form>
</body>
</html:html>
