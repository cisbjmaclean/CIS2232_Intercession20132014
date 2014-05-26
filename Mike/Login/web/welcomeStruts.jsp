<%-- 
    Document   : mainPage
    Created on : May 25, 2014, 7:04:44 PM
    Author     : Michael Fesser
    Purpose    : This is the welcome page.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="default.css" rel="stylesheet">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body>

        <!-- Program does not load, built in code. -->
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>

        <!-- input fields. -->
        <div class="header">
            <h3><bean:message key="welcome.heading"/></h3>
        </div>
        <div class ="mainDiv">
            <html:form action="/Form">
                <table>
                    <tr><td><bean:message key="form.radio.message"/></td></tr>
                    <tr><td><bean:message key="form.radio.option"/><html:radio property="option" value="login"/></td></tr>
                    <tr><td><html:submit><bean:message key="form.radio.submit"/></html:submit></td></tr>
                    </table>
            </html:form>  
        </div>
    </body>
</html:html>
