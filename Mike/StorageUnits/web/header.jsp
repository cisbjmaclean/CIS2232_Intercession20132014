<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*"%>


<%--
This provides the standard header for each page in the application.
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/StorageUnits/styles/styles.css">
        <link rel="stylesheet" href="/StorageUnits/styles/jquery-ui.min.css">
        <link rel="stylesheet" href="/StorageUnits/styles/jquery-ui.theme.css">
        <link rel="stylesheet" href="/StorageUnits/styles/jquery-ui.structure.css">
        <script src="/StorageUnits/scripts/jquery.js"></script>
        <script src="/StorageUnits/scripts/generalUse.js"></script>
        <script src="/StorageUnits/scripts/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="/StorageUnits/styles/storageUnitTheme.css">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body>
        <div>
            <h1 style="text-align: center; ">
                <bean:message key="welcome.title"/><br/>
            </h1>
        </div>        
    </body>

</html>
