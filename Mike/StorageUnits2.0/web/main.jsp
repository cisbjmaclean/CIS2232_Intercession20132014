<%-- 
    Document   : main
    Created on : Jun 6, 2014, 12:50:12 AM
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <html:button property="login" onclick="window.location='login.jsp';"><bean:message key="main.label.login"/></html:button>
        <html:button property="create" onclick="window.location='createUser.jsp';"><bean:message key="main.label.create"/></html:button>
        <html:form action="/loadUnits">
            <html:submit><bean:message key="main.label.view"/></html:submit>
        </html:form>
    </body>
</html>
