<%-- 
    Document   : login_fail
    Created on : Jun 6, 2014, 4:32:35 PM
    Author     : Ryan
    Purpose: This page is only shown if the information that is used to login
    does not match any of the information in the database.
--%>


<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title><bean:message key="fail.title"/></title>
    <html:base/>
    </head>
    <body>
        
    <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
    </logic:notPresent>
        
        <h3><bean:message key="fail.heading"/></h3>
        <p><bean:message key="fail.message"/></p>
        
    </body>
</html:html>
