<%-- 
    Document   : login
    Created on : May 25, 2014, 3:39:57 PM
    Author     : Michael Fesser
    Purpose    : This is the login page.
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="login.title"/></title>
        <link href="default.css" rel="stylesheet">
        <html:base/>
    </head>
    <body style="background-color: white">

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
            <html:form action="/Login">
                <table>
                    <tr>
                        <td><label for="userName"><bean:message key="login.userName"/></label><html:text property="userName"/></tr>
                    </td>
                    <tr>
                        <td><label for="password"><bean:message key="login.password"/><html:password property="password"/></tr>
                    </td>
                    <tr>
                        <td><html:submit><bean:message key="form.radio.submit"/></html:submit></td>
                        </tr>
                    </table>
            </html:form>
        </div>
    </body>
</html:html>
