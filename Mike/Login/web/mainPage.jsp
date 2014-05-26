<%-- 
    Document   : mainPage
    Created on : May 25, 2014, 7:04:44 PM
    Author     : Michael Fesser
    Purpose    : This is the main page of the website.
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="mainpage.title"/></title>
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

<!-- Will be the user page/main page when functionality is required. -->
<div class="header">
    <h3><bean:message key="main.heading"/></h3>
</div>
<div class="mainDiv header">
    <p><bean:message key="main.message"/></p>
</div>
</body>
</html:html>