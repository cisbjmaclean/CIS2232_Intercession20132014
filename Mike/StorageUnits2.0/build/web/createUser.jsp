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
        <s:textfield name="addUserObject.username" key="addUser.label.username"/>
        <s:textfield name="addUserObject.password" key="addUser.label.password"/>
        <s:textfield name="addUserObject.password2" key="addUser.label.password2"/>
        <s:textfield name="addUserObject.email" key="addUser.label.email"/>
        <s:textfield name="addUserObject.email2" key="addUser.label.email2"/>
        <s:textfield name="addUserObject.firstName" key="addUser.label.firstName"/>
        <s:textfield name="addUserObject.middleInitial" key="addUser.label.middleInitial"/>
        <s:textfield name="addUserObject.lastName" key="addUser.label.lastName"/>
        <s:textfield name="addUserObject.address" key="addUser.label.address"/>
        <s:textfield name="addUserObject.city" key="addUser.label.city"/>
        <s:textfield name="addUserObject.province" key="addUser.label.province"/>
        <s:textfield name="addUserObject.postalCode" key="addUser.label.postalCode"/>
        <s:textfield name="addUserObject.phoneNumber" key="addUser.label.phoneNumber"/>
        <s:submit name="submit" key="addUser.label.submit"/>          
        </s:form>
    </body>
</html>

