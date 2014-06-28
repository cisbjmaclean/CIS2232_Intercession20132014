<%-- 
    Document   : addLifeguard
    Created on : 14-Jun-2014, 2:47:38 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="lifeguard.addLifeguard"/></title>
    </head>
    <body>
        <html:form action="/AddLifeguard">
            <h3><bean:message key="menu.message.addLifeguard"/></h3>
            <table class="tableStuff">
                <tr>
                    <td><bean:message key="lifeguard.firstName"/></td>
                    <td><input type="text" name="firstName" required></td>
                </tr>
                <tr>
                    <td><bean:message key="lifeguard.lastName"/></td>
                    <td><input type="text" name="lastName" required></td>
                </tr>
                <tr>
                    <td><bean:message key="lifeguard.phoneNumber"/></td>
                    <td><input type="text" name="phoneNumber" required></td>
                </tr>
                <tr>
                    <td><bean:message key="lifeguard.NLS"/></td>
                    <td><input id="NLS" type="date" name="NLS" value="2011-01-13"/></td>
                </tr>
                <tr>
                    <td><bean:message key="lifeguard.CPR"/></td>
                    <td><input id="CPR" type="date" name="CPR" value="2011-01-13"/></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;"><input type="submit" name="submit" value="<bean:message key="lifeguard.addLifeguard"/>"</td>
                </tr>
            </table>
        </html:form>
    </body>
</html>
