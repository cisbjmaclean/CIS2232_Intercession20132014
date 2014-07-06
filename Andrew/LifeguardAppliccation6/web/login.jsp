<%-- 
    Document   : login
    Created on : 10-Jun-2014, 7:41:56 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="login.message"/></title>
    </head>
    <body>
        <html:form action="/Login">
            <table class="tableStuff">
                <tr>
                    <td>
                        <logic:messagesPresent message="true">
                                <html:messages id="msg2" message="true" property="success"><div style="color: green"><bean:write name="msg2"/></div><br/></html:messages>			  		
                                <html:messages id="msg2" message="true" property="failure"><div style="color: red"><bean:write name="msg2"/></div><br/></html:messages>			  		
                        </logic:messagesPresent>
                    </td>
                </tr>
                <tr>
                    <td><strong><bean:message key="login.username"/></strong></td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td><strong><bean:message key="login.password"/></strong></td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:center;"><input type="submit" name="submit" value="<bean:message key="login.login"/>"></td>
                </tr>
            </table>
        </html:form>
    </body>
</html>