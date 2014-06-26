
<%-- 
    Document   : welcome
    Created on : Jun 6, 2014, 1:06:10 PM
    Author     : Ryan
    Purpose:
    This page allows the user to login to access the rest of the site.
    The information is sent to a database where it is checked to see if it is
    a match.
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
        <title><bean:message key="welcome.title"/></title>
    <html:base/>
    </head>
    <body>
        
    <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
    </logic:notPresent>
    <div class="login">     
        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>
    
    <html:form action="/LoginAction.do">
        
        <bean:message key="welcome.username"/><html:text property="userName"/><br>
        <bean:message key="welcome.password"/><html:password property="password"/><br>
        <html:submit><bean:message key="label.submit"/></html:submit>

    </html:form>
    </div>
    </body>
</html:html>

