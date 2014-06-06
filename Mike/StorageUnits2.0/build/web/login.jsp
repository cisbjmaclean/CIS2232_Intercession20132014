<%-- 
    Document   : login
    Created on : Jun 6, 2014, 12:24:15 AM
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
        <s:form action="systemLogin" method="post">
            <s:textfield name ="login.username"/>
            <s:textfield name ="login.password"/>
            <s:submit name ="login.submit"/>
        </s:form>
    </body>
</html>
