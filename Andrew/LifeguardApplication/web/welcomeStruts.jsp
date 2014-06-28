<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/LifeguardApplication/styles/styles.css">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body>
        <html:form action="/Enter">
            <table>
                <tr>
                    <th><bean:message key="welcome.message"/></th>
                </tr>
                <tr>
                    <td><input type="submit" value="Enter" name="enterProgram"/></td>
                </tr>
            </table>
        </html:form>      
    </body>
</html:html>