<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%--
This provides the standard header for each page in the application.
--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <html:base/>
</head>
<body>
        <div class="mainContain">
            <div class="container">
                <h3 class="header">
                    <bean:message key="header.main"/>
                </h3>
            </div>        
            <div class="menuBlend"></div>
