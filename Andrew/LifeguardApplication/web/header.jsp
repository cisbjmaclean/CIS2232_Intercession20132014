<%-- 
    Document   : header
    Created on : 4-Jun-2014, 7:51:50 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
    </head>
    <body>
        <div>
            <h3  style="text-align: center;">
                <bean:message key="welcome.heading"/><br>
                <bean:message key="welcome.title"/>
            </h3>
        </div>
            <hr>
    </body>
</html>
