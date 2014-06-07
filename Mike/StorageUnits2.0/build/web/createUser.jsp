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
        <s:textfield name="addUserObject.username" label="username"/>
        <s:textfield name="addUserObject.password" label="p"/>
        <s:textfield name="addUserObject.password2"/>
        <s:textfield name="addUserObject.email" label="e"/>
        <s:textfield name="addUserObject.email2"/>
        <s:textfield name="addUserObject.firstName" label="f"/>
        <s:textfield name="addUserObject.middleInitial" label="m"/>
        <s:textfield name="addUserObject.lastName" label="l"/>
        <s:textfield name="addUserObject.street"/>
        <s:textfield name="addUserObject.city"/>
        <s:textfield name="addUserObject.province"/>
        <s:textfield name="addUserObject.postalCode"/>
        <s:textfield name="addUserObject.phoneNumber"/>
        <s:submit name="submit"/>          
        </s:form>
    </body>
</html>

