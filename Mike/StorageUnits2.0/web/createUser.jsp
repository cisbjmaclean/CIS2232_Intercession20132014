<%-- 
    Document   : createUser
    Created on : Jun 5, 2014, 5:47:03 PM
    Author     : Michael
--%>

<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <s:form action="addUser">
        <s:textfield key="username"/>
        <s:textfield key="password"/>
        <s:textfield key="password2"/>
        <s:textfield key="email"/>
        <s:textfield key="email2"/>
        <s:textfield key="firstName"/>
        <s:textfield key="middleInitial"/>
        <s:textfield key="lastName"/>
        <s:textfield key="street"/>
        <s:textfield key="city"/>
        <s:textfield key="provice"/>
        <s:textfield key="postalCode"/>
        <s:textfield key="phoneNumber"/>
        <s:submit key="submit"/>          
        </s:form>
    </body>
</html>

