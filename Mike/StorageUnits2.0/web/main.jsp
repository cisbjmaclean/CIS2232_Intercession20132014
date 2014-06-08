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
        <input type="button" name="login" value="Login" onclick="window.location='login.jsp';"/>
        <input type="button" name="create"  value="Create User" onclick="window.location='createUser.jsp';"/>
        <s:form action="loadUnits">
            <s:submit name="Submit" key="main.label.submit"/>
        </s:form>
    </body>
</html>
