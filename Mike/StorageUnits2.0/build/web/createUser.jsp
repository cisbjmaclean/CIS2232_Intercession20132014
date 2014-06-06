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
    <s:form action="addUser" method="post">
        <s:textfield name="addUserLoginObject.username" label="username"/>
        <s:textfield name="addUserLoginObject.password" label="p"/>
        <s:textfield name="addUserObject.password2"/>
        <s:textfield name="addUserDetailsObject.email" label="e"/>
        <s:textfield name="addUserDetailsObject.email2"/>
        <s:textfield name="addUserDetailsObject.firstName" label="f"/>
        <s:textfield name="addUserDetailsObject.middleInitial" label="m"/>
        <s:textfield name="addUserDetailsObject.lastName" label="l"/>
        <s:textfield name="addUserDetailsObject.street"/>
        <s:textfield name="addUserDetailsObject.city"/>
        <s:textfield name="addUserDetailsObject.province"/>
        <s:textfield name="addUserDetailsObject.postalCode"/>
        <s:textfield name="addUserDetailsObject.phoneNumber"/>
        <s:submit name="submit"/>          
        </s:form>
    </body>
</html>

